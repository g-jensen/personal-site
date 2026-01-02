# Fingerprinting
2024-07-15

Recently, I came across an interesting solution to a problem that had never even thought about before.

### Problem Explanation

When a person visits a website, the person's web browser sends an HTTP request to that site and the site will usually respond with at least an HTML file, but usually also Javascript and CSS files.

These files can be large in size, so the web browser will 'cache' (save for later) the files so that the next time the site is visited, the person doesn't have to re-download the files. This improves the performance of websites because less time is spent downloading from the server.

The problem occurs when these files eventually do change. Maybe there is a new feature on the website, so the files reflect that. How does the web browser know to re-download those files? Well, it doesn't. It will just re-download them every once in a while or whenever the user specifies. (Generally, it just depends on the browser)

So, how do we make sure that the user always has the newest files?

### Solution

To understand the solution, one must know how the browser decides whether or not to download a file. In short, the browser just looks at the name of the file. If there is a file with a given name already in the cache, then it doesn't download it. Otherwise, it does download it.

As you may have guessed, the solution lies in changing the name of the files being sent. But we don't want to have to manually change the name of the file each time, so we might have an automated system that adds a little hash to the end of the file names. The hash is based on the contents of the file, so it will only change when the file changes.

A hash is just a function that takes in data and tries to return a unique string based on that data.

### Fingerprinting Isn't Perfect

From my last sentence you probably gathered that this system isn't perfect. The hash generated is likely only going to be around 10 characters long, which is not enough to create a 1-to-1 map from data that is larger than 10 characters. This means that multiple versions of a file could map to the same hash, therefore making the user not re-download the file. The good part is that this is a very rare occurrence, and hash functions are designed to distribute the strings as evenly as possible.
