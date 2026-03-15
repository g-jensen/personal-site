(ns portfolio.pages.home
  (:require [clojure.string :as str]
            [portfolio.page :as page]))

(defn project->html [{:keys [label href img] :as _project}] 
  [:a.project-item (merge {:href href} (when (str/starts-with? href "https") {:target "_blank"}))
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
      [:u "Personal Projects"]]]
    [:div.project-container
     (doall 
      (map 
       project->html 
       [{:label "Homelab"                      :href "/homelab"                :img {:src "images/grafana.png"       :alt "My homelab"}}
        {:label "Set"                          :href "/set"                    :img {:src "images/set.png"           :alt "The card game Set"}}
        {:label "specc"                        :href "/specc"                  :img {:src "images/specc.png"         :alt "Testing library"}}
        {:label "Scattergories"                :href "/scattergories"          :img {:src "images/scattergories.png" :alt "Scattergories"}}
        {:label "HTTP Server"                  :href "/http-server"            :img {:src "images/http.png"          :alt "HTTP Server"}}
        {:label "Catchphrase"                  :href "/catchphrase"            :img {:src "images/catchphrase.png"   :alt "Catchphrase"}}
        {:label "Text Editor"                  :href "/text-editor"            :img {:src "images/text_editor.png"   :alt "Text editor"}}
        {:label "Graphing Calculator"          :href "/graphing-calculator"    :img {:src "images/graphing.png"      :alt "Graphing Calculator"}}
        {:label "Programming Challenges"       :href "/programming-challenges" :img {:src "images/project-euler.png" :alt "Project Euler"}}
        {:label "Bezier Curve Visualization"   :href "/bezier-curve"           :img {:src "images/bezier.png"        :alt "Bezier curve"}}
        {:label "Fourier Series Visualization" :href "/fourier-series"         :img {:src "images/fourier.png"       :alt "Fourier series"}}
        {:label "Music Player"                 :href "/music-player"           :img {:src "images/musicplayer.png"   :alt "Music player"}}]))
     ]])
  )

;; TODO - Add explanation page for Set, Scattergories, and Catchphrase. Fix blog post images. Write more blogs posts. Add homelab to projects