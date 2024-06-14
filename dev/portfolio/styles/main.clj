(ns portfolio.styles.main
  (:refer-clojure :exclude [rem])
  (:require [garden.def :as garden]))

(garden/defstyles screen

(list
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
 
 )
  
  )