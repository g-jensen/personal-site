(ns portfolio.pages.home 
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen's Website")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "Greg Jensen's Website"]]
    [:div.center
     [:h4.subtitle "Programmer & Student living in Indianapolis, IN interested in Mathematics and Software Development."]]
    [:div.center
     [:h2.subtitle 
      [:u "Projects"]]]
    [:div.project-container
     [:a.project-item {:href "https://set.gregjensen.dev"}
      "Set"
      [:img.project-image {:src "images/set.png" :alt "The card game Set"}]]
     [:a.project-item {:href "./specc"}
      "specc"
      [:img.project-image {:src "images/specc.png" :alt "specc"}]]
     [:a.project-item {:href "https://scattergories.gregjensen.dev"}
      "Scattergories"
      [:img.project-image {:src "images/scattergories.png" :alt "Scattergories"}]]
     [:a.project-item {:href "./http-server"}
      "HTTP Server"
      [:img.project-image {:src "images/http.png" :alt "HTTP Server"}]]
     [:a.project-item {:href "https://catchphrase.gregjensen.dev"}
      "Catchphrase"
      [:img.project-image {:src "images/catchphrase.png" :alt "Catchphrase"}]]
     [:a.project-item {:href "./text-editor"}
      "Text Editor"
      [:img.project-image {:src "images/text_editor.png" :alt "Text editor"}]]
     [:a.project-item {:href "./graphing-calculator"}
      "Graphing Calculator"
      [:img.project-image {:src "images/graphing.png" :alt "Graphing Calculator"}]]
     [:a.project-item {:href "./programming-challenges"}
      "Programming Challenges"
      [:img.project-image {:src "images/project-euler.png" :alt "Project Euler"}]]
     [:a.project-item {:href "./bezier-curve"}
      "Bezier Curve Visualization"
      [:img.project-image {:src "images/bezier.png" :alt "Bezier curve"}]]
     [:a.project-item {:href "./fourier-series"}
      "Fourier Series Visualization"
      [:img.project-image {:src "images/fourier.png" :alt "Fourier series"}]]
     [:a.project-item {:href "./music-player"}
      "Music Player"
      [:img.project-image {:src "images/musicplayer.png" :alt "Music player"}]]]])
  )