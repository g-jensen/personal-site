(ns portfolio.pages.home
  (:require [clojure.string :as str]
            [portfolio.page :as page]))

(defn project->html [{:keys [label href img] :as _project}] 
  [:a.project-item (merge {:href href} (when (str/starts-with? href "https") {:target "_blank"}))
   label
   [:img.project-image img]])

(def no-margin-bottom {:style {:margin-bottom "0px"}})
(def no-margin-top {:style {:margin-top "0px"}})

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen's Website")
   [:body
    page/nav-bar
    [:div.center [:h1 "Greg Jensen's Website"]]
    [:div {:style {:display "grid", :grid-template-columns "1fr 1.6fr 1fr"}}
     [:div]
     [:div
      [:div
       [:h4 no-margin-bottom "Interests"]
       [:ul.padding-ul no-margin-top
        [:li "Software (see projects below)"]
        [:li [:a page/math-href "Math"]]
        [:li "Learning German"]]]
      [:div
       [:h4 no-margin-bottom "Currently Exploring"]
       [:ul.padding-ul no-margin-top
        [:li "Site Reliability"]
        [:li [:a {:href "https://pi.dev/" :target "_blank"} "Pi"] " (coding agent)"]
        [:li "Woodworking"]]]
      [:div
       [:h4 no-margin-bottom "Actively Reading"]
       [:ul.padding-ul no-margin-top
        [:li [:a {:href "https://sre.google/workbook/table-of-contents/" :target "_blank"} "The Site Reliability Workbook"]]
        [:li [:a {:href "https://files.cercomp.ufg.br/weby/up/410/o/Phillip_K._Dick_-_Do_Androids_Dream_of_Electric_Sheep_c%C3%B3pia.pdf" :target "_blank"} "Do Androids Dream of Electric Sheep?"]]
        [:li [:a {:href "https://kinokultur.ch/app/uploads/2015/10/buchtext_der_kleine_prinz.pdf" :target "_blank"} "Der Kleine Prinz"]]]]
      [:div
       [:h2
        [:u "Personal Projects"]]]
      [:div.project-container
        (doall 
          (map 
          project->html 
          [{:label "Crucible"                      :href "https://github.com/g-jensen/crucible"                :img {:src "images/crucible.png"       :alt "Crucible"}}
            {:label "Homelab"                      :href "/homelab"                :img {:src "images/grafana.png"       :alt "My homelab"}}
            {:label "Set"                          :href "/set"                    :img {:src "images/set.png"           :alt "The card game Set"}}
            {:label "specc"                        :href "/specc"                  :img {:src "images/specc.png"         :alt "Testing library"}}
            {:label "Scattergories"                :href "/scattergories"          :img {:src "images/scattergories.png" :alt "Scattergories"}}
            {:label "HTTP Server"                  :href "/http-server"            :img {:src "images/http.png"          :alt "HTTP Server"}}
            {:label "Catchphrase"                  :href "/catchphrase"            :img {:src "images/catchphrase.png"   :alt "Catchphrase"}}
            {:label "Text Editor"                  :href "/text-editor"            :img {:src "images/text_editor.png"   :alt "Text editor"}}
            {:label "Music Player"                 :href "/music-player"           :img {:src "images/musicplayer.png"   :alt "Music player"}}
            {:label "Graphing Calculator"          :href "/graphing-calculator"    :img {:src "images/graphing.png"      :alt "Graphing Calculator"}}
            {:label "Programming Challenges"       :href "/programming-challenges" :img {:src "images/project-euler.png" :alt "Project Euler"}}
            {:label "Bezier Curve Visualization"   :href "/bezier-curve"           :img {:src "images/bezier.png"        :alt "Bezier curve"}}
            {:label "Fourier Series Visualization" :href "/fourier-series"         :img {:src "images/fourier.png"       :alt "Fourier series"}}]))]]]]))

;; TODO - Add explanation page for Set, Scattergories, and Catchphrase. Fix blog post images. Write more blogs posts. Add homelab to projects