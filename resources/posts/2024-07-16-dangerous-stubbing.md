# Tricky Tests
2024-07-16

Throughout my experience writing and testing software, I've come across some situations that can be tricky to test. Some solutions to these situations are better than others.

### Want to deal with input and output in the terminal? 

Maybe you stub out your `read-line` function to return what input you want to simulate. You also stub out your `print` function and make sure it is called with the correct paramters.

Maybe you have some sort of `data-stream` abstraction that you use to read and write arbitrary data. Reading and writing from standard input would then simply be a special case of a `data-stream`.

Maybe you're low level and have access to the literal standard input stream, and so you don't even have to abstract. With some threading magic, you could read from standard input and then write to standard input in the same test.

### Want to send and receive data over the wire?

Maybe you stub out your `send-request` function on the client side and just make sure that it is called with the correct parameters. On the server side, you directly test all the ways that your `request-handler` will be called and make sure the correct response is returned.

Maybe you have some sort of `web-server` abstraction such that you can create a mock server and have requests really hit their endpoints on the server and have the client really get the response back.

Maybe your tests literally spin up a server and have the client and server literally communicate with each other.

### Analysis

The pattern with these solutions is that they get progressively closer to how the program will run in reality. I'll refer to the types of solutions as "stub", "mock", and "literal" respectively.

"Closeness to reality" has a great influence on how much you can trust your tests to fail when use-cases change (which is really the whole point of testing). Generally, the closer you are to reality, the more accurately your tests will fail with different use-cases.

As a case study, let's look at Clojure pseudocode for the wire "stub" solution:
```clojure
; server-spec.clj
(it "crunches a number"
  (should= 2 (wire-crunch-data {:data 1})))
```
```clojure
; server.clj
(defn wire-crunch-data [request]
  (inc (:data request)))
```
```clojure
; client-spec.clj
(it "sends data to be crunched"
  (with-redefs [send-request (stub :send-request)]
    (client/request-crunched-data)
    (should-have-invoked :send-request {:with [{:data 1}]})))
```
```clojure
; client.clj
(defn request-crunched-data []
  (send-request {:data 1}))
```

This solution is okay, and accounts for every piece of code shown. What this doesn't account for is the actual communication between client and server.

Imagine use-cases change and now we need to crunch a list instead of a single number. We might rewrite our server-side like so:
```clojure
; server-spec.clj
(it "crunches multiple numbers"
  (should= [2 3] (wire-crunch-data {:data [1 2]})))
```
```clojure
; server.clj
(defn wire-crunch-data [request]
  (map inc (:data request)))
```

Cool. So we're done. Except now our app is broken because the client-side is still sending a number instead of a list. We now have to also fix our client-side even though no tests are failing. Now imagine this test was 10x more complex and there were 100x more instances of this test on the client side. Then it might be hard to figure out all of the places that tests are implicitly failing. This kind of solution causes low trust in tests which decreases the value of testing overall.

Using the other two solutions ("mock" and "literal") would avoid these 'implicitly' failing tests and cause both the client-side and server-side tests to fail.

But what about the standard input and output example? You would likely never run into this problem when stubbing terminal I/O. This is because the API for `print` and `read-line` are probably never going to change, so your stub will never be inaccurate. The problem with the wire situation was that our API for `wire-crunch-data` changed, and so our stub was not accurate to the real use-case. (kinda sounds like the same reason that comments are bad)

#### Pros and Cons

Okay. You're sold on "mock" or "literal" testing. But when should you use one over the other? I said earlier that the solutions got closer to reality and that getting closer to reality is better, so "literal" testing must be the best. That's only sort of true. In the wire example, mocking a server would require the client and server to be written in the same language which is not always the case. On the other hand, spinning up a server for your tests might take a while and make TDD slow. This could cause you to reconsider the "stub" solution. Evidently there's definitely a happy medium to find when deciding which solution you choose.
