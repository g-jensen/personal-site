(ns portfolio.pages.projects.multiplayer-game 
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "Multiplayer Game"]]
    [:div.center
     [:h4.subtitle "Written in C++"]]
    [:div.center
     [:br]
     [:div.description
      [:ul
       [:li "This is my implementation of a simple 2 player game. I had never programmed any sort of networking so I created this to see if I could figure it out. The network is client/server (as opposed to peer-to-peer) and just sends the other player's position over TCP every 0.5 second."]
       [:br]
       [:iframe {:width "600" :height "300" :src "https://www.youtube.com/embed/C9tFAy3n0VM"}]
       [:br]
       [:li [:a {:href "https://github.com/g-jensen/mpgame"} "Repo link"]]]]]]))