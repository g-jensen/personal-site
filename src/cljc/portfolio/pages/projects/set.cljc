(ns portfolio.pages.projects.set
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "Set"]]
    [:div.center
     [:h4.subtitle "A web implementation of the " [:a {:href "https://en.wikipedia.org/wiki/Set_(card_game)" :target "_blank"} "card game"] " by the same name"]]
    [:div.center
     [:br]
     [:div.description
      [:ul
       [:li "Singleplayer & multiplayer with room links to invite your friends"]
       [:li "Clojurescript frontend, Clojure backend. Live updates with websockets"]
       [:li [:a {:href "https://set.sajensen.dev" :target "_blank"} "Play the game"]]
       [:li [:a {:href "https://github.com/g-jensen/set" :target "_blank"} "Repo link"]]]]]]))