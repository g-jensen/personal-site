(ns portfolio.pages.projects.programming-challenges 
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "Programming Challenges"]]
    [:div.center
     [:br]
     [:div.description
      [:ul
       [:a {:href "https://projecteuler.net/"} [:img {:src "./images/euler_portrait.png"}]]
       [:li "Project Euler is \"a series of challenging mathematical/computer programming problems that will require more than just mathematical insights to solve\""
        [:ul
         [:li [:a {:href "https://github.com/g-jensen/Project-Euler-Problems"} "Repo link (Various Languages)"]]
         [:li [:a {:href "https://github.com/g-jensen/euler"} "Repo link (Only Clojure)"]]]]
       [:li "The CSES Problem Set contains a collection of algorithm programming practice problems"
        [:ul
         [:li [:a {:href "https://github.com/g-jensen/CSES"} "CSES"]]]]]]]]))