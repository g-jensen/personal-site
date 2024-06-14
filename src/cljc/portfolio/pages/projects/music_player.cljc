(ns portfolio.pages.projects.music-player 
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "Music Player"]]
    [:div.center
     [:h4.subtitle "Written in C++"]]
    [:div.center
     [:br]
     [:div.description
      [:ul
       [:li "This is a custom music player that I made because I didn't want to use spotify. It works by the user inputting a youtube link and then the program downloads the sound as an .ogg using youtube-dl."]
       [:br]
       [:img {:style "width: 100%;" :src "./images/musicplayer_1.png" :alt "Music player"}]
       [:br]
       [:li [:a {:href "https://github.com/g-jensen/music-player"} "Repo link"]]]]]]))