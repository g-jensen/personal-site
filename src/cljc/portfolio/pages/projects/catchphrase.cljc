(ns portfolio.pages.projects.catchphrase
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "Catchphrase"]]
    [:div.center
     [:h4.subtitle "A web implementation of the classic " [:a {:href "https://en.wikipedia.org/wiki/Catch_Phrase_(game)" :target "_blank"} "party game"]]]
    [:div.center
     [:br]
     [:div.description
      [:ul
       [:li "Singleplayer & multiplayer with room links to invite your friends"]
       [:li "Clojurescript frontend, Clojure backend. Live updates with websockets"]
       [:li [:a {:href "https://catchphrase.sajensen.dev" :target "_blank"} "Play the game"]]
       [:li [:a {:href "https://github.com/s-ajensen/catchphrase" :target "_blank"} "Repo link"]]]]]]))