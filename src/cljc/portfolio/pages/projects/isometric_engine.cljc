(ns portfolio.pages.projects.isometric-engine 
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "Isometric Engine"]]
    [:div.center
     [:h4.subtitle "Written in C++"]]
    [:div.center
     [:br]
     [:div.description
      [:ul
       [:li "An extension to SFML's 2D graphics engine into an isometric 3D.\n\nFeatures include a grid collision system and sprite loading onto faces of objects"]
       [:br]
       [:iframe {:width "600" :height "300" :src "https://www.youtube.com/embed/zBIwGc6dhlI"}]
       [:br]
       [:li [:a {:href "https://github.com/g-jensen/Isomorphic-Engine"} "Repo link"]]]]]]))