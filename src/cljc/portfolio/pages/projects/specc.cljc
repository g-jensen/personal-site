(ns portfolio.pages.projects.specc
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "specc"]]
    [:div.center
     [:h4.subtitle "Unit testing framework for C/C++"]]
    [:div.center
     [:br]
     [:div.description
      [:ul
       [:li "specc is a library of macros that allows for unit testing of both C and C++ code."]
       [:li "Find instructions for setup here: " [:a {:href "https://github.com/g-jensen/specc"} "repo link"]]
       [:br]
       [:li "An example output:"]
       [:img {:style "width: 100%;" :src "./images/specc.png" :alt "specc"}]]]]]))