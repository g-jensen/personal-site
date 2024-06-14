(ns portfolio.pages.projects.http-server 
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "HTTP Server"]]
    [:div.center
     [:h4.subtitle "Written in Java from scratch (no external libraries or java.net.http)"]]
    [:div.center
     [:br]
     [:div.description
      [:ul
       [:li "The server uses " [:a {:href "https://datatracker.ietf.org/doc/html/rfc2616"} "RFC2616"] " for HTTP/1.1"]
       [:li "You can find the source code on the " [:a {:href "https://github.com/g-jensen/HttpServer"} "GitHub page"]]
       "Here is an example app using the server:"
       [:div.center
        [:img {:src "./images/carbon.png" :style "width: 100%; height: auto;"}]]
       [:br]
       [:li "I also made a more complex example app " [:a {:href "https://github.com/g-jensen/HttpServerApp"} "here"]]]]]]))