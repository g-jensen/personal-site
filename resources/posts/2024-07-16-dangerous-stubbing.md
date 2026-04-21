# Tricky Tests
2024-07-16

Throughout my experience writing and testing software, I've come across some situations that can be tricky to test. Some solutions to these situations are better than others.

### Want to deal with input and output in the terminal? 

Maybe you stub out your `read-line` function to return what input you want to simulate. You also stub out your `print` function and make sure it is called with the correct paramters.

Maybe you have some sort of `data-stream` abstraction that you use to read and write arbitrary data. Reading and writing from standard input would then simply be a special case of a `data-stream`.

Maybe you're low level and have access to the literal standard input stream, and so you don't even have to abstract. With some threading magic, you could read from standard input and then write to standard input in the same test.

### Want to send and receive data over the wire?

Maybe you stub out your `send-request` function on the client side and just make sure that it is called with the correct parameters. On the server side, you directly test all the ways that your `request-handler` will be called and make sure the correct response is returned.

Maybe you have some sort of `web-server` abstraction such that you can create a fake server and have requests actually hit something on the fake server and have the client get a response back.

Maybe your tests literally spin up a server and have the client and server truly communicate with each other.

### Analysis

The pattern with these solutions is that they get progressively closer to how the program will run in reality. I'll refer to the types of solutions as Stub, (Test) Doubles, and Integration testing respectively.

"Closeness to reality" has a great influence on how much you can trust your tests to fail when use-cases change (which is really the whole point of testing). Generally, the closer you are to reality, the more accurately your tests will fail with different use-cases.

#### Case Study

As a case study, let's look at Clojure pseudocode for the wire Stub solution:
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

This solution accounts for every piece of code shown. What this doesn't account for is the actual communication between client and server.

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

Cool. So we're done. Except now our app is broken because the client-side is still sending a number instead of a list. We now have to also fix our client-side even though no tests are failing. **Tests are only useful if they fail when functionality is broken.** Now imagine this test was 10x more complex and there were 100x more instances of this test on the client side. Then it might be hard to figure out all of the places that tests are implicitly failing. This kind of solution causes low trust in tests which decreases the value of testing overall.

#### The Alternatives

Using the other two solutions (Double and Integration) are the alternatives to Stub and I argue that you should use *both* of them in this case.

Making Test Doubles would entail creating a `Client` abstraction (an interface) that implements `request-crunched-data`. In the tests, you use a fake implementation of `Client` like `ClientSpy` that doesn't actually send a request to the server and just saves the request to make sure the correct parameters were passed. In production, you use a real implementation. This is functionally equivalent to stubbing in the unit tests, so this actually doesn't solve our implicitly failing tests problem. But architecturally, it does solve a more hidden problem of depending on concretions rather than on abstractions. By picking Doubles over Stubs, we've stumbled upon an objectively better architecture. We could substitute an `HttpClient`, `Grpclient`, `CachingClient`, `LoggingClient`, etc. The possibilities are endless and we only have to swap out the implementations. The usage stays the same.

Integration testing is where we end up actually solving our problem. This entails writing a test that just does whatever a user of that piece of code would do in production (except for possibly pointing the request at a local server instead of a live one). This way, you get real confirmation that functionality is broken. These kinds of tests can take time to run so you don't run them during every TDD loop. Instead, you run them at least before you push your code (or during, if you have a CI pipeline) and maybe more.

### The Importance of Both

It may be tempting to just pick either Test Doubles or Integration testing, but it's important to understand why you need both. If you only use Test Doubles, you run into the same problem as Stubbing where you have implicitly failing tests. If you only Integration test, you fall into lazy architecture habits that result in high coupling and therefore fragile code. TDD or even unit testing in general is also a lot harder since you depend on slow tests a lot more. Doing both is the only way to maintain clean code that is truly tested.