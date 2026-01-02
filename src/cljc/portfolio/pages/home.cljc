(ns portfolio.pages.home 
  (:require [portfolio.page :as page]))

(defn project->html [{:keys [label href img] :as _project}] 
  [:a.project-item {:href href}
   label
   [:img.project-image img]])

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
     (doall 
      (map 
       project->html 
       [{:label "Set"                          :href "https://set.sajensen.dev"           :img {:src "images/set.png"           :alt "The card game Set"}}
        {:label "specc"                        :href "./specc.html"                       :img {:src "images/specc.png"         :alt "Testing library"}}
        {:label "Scattergories"                :href "https://scattergories.sajensen.dev" :img {:src "images/scattergories.png" :alt "Scattergories"}}
        {:label "HTTP Server"                  :href "./http-server.html"                 :img {:src "images/http.png"          :alt "HTTP Server"}}
        {:label "Catchphrase"                  :href "https://catchphrase.sajensen.dev"   :img {:src "images/catchphrase.png"   :alt "Catchphrase"}}
        {:label "Text Editor"                  :href "./text-editor.html"                 :img {:src "images/text_editor.png"   :alt "Text editor"}}
        {:label "Graphing Calculator"          :href "./graphing-calculator.html"         :img {:src "images/graphing.png"      :alt "Graphing Calculator"}}
        {:label "Programming Challenges"       :href "./programming-challenges.html"      :img {:src "images/project-euler.png" :alt "Project Euler"}}
        {:label "Bezier Curve Visualization"   :href "./bezier-curve.html"                :img {:src "images/bezier.png"        :alt "Bezier curve"}}
        {:label "Fourier Series Visualization" :href "./fourier-series.html"              :img {:src "images/fourier.png"       :alt "Fourier series"}}
        {:label "Music Player"                 :href "./music-player.html"                :img {:src "images/musicplayer.png"   :alt "Music player"}}]))
     ]])
  )