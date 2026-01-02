(ns portfolio.styles.main
  (:refer-clojure :exclude [rem])
  (:require [garden.def :as garden]
            [garden.stylesheet :refer [at-media]]))

(garden/defstyles screen

(list
 
 [:.post
  {:display "flex"
   :justify-content "center"}
 
  [:img
   {:width "100%"}]
 
  [:div
   {:text-align "left"
    :max-width "30%"}
 
   [:ul
    {:text-align "left"}]
 
   [:pre
    {:background "#eef"
     :text-align "left"}
    [:code
     {:background "#eef"}]]]]
 
 [:.padding-left-30
  {:padding-left "30%"}]
 
 [:.padding-left-0
  {:padding-left "0"}]
 
 [:.margin-0
  {:margin "0"}]
 
 [:.font-2rem
  {:font-size "2rem"}]
 
 [:.padding-bottom-2
  {:padding-bottom "5%"}]
 
 [:.list-style-none
  {:list-style "none"}]

 [:.center
  {:display "flex"
   :justify-content "center"
   :gap "10px"}]
 
 [:.subtitle
  {:text-align "center"
   :max-width "90%"}]
 
 [:.description
  {:max-width "40%"}]
 
 [:.project-container
  {:display "flex"
   :flex-wrap "wrap"
   :gap "20px"
   :justify-content "center"
   :margin-right "25%"
   :margin-left "25%"}]
 
 [:.project-item
  {:box-sizing "border-box"
   :text-align "center"
   :display "grid"
   :justify-content "center"
   :border "5px double black"}]
 
 [:.project-image
  {:width "250px"
   :height "103px"
   ;:height "auto"
   }]
 
 (at-media {:max-width "1000px"}
           [:.post
            [:div
             {:max-width "90%"}]])
 
 )
  
  )