(ns portfolio.pages.projects.graphing-calculator 
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "Graphing Calculator"]]
    [:div.center
     [:h4.subtitle "Written in C++"]]
    [:div.center
     [:br]
     [:div.description
      [:ul
       [:li "Features"
        [:ul
         [:li "Camera movement with arrow keys and zooming with the scroll wheel"]
         [:li "Number line on the x and y axes"]
         [:li "Efficient graphing engine"]
         [:li "Function evaluation with an abstract syntax tree"]]]
       [:br]
       [:iframe
        {:width "600"
         :height "300"
         :src "https://www.youtube.com/embed/Zse4VcbfXMI"}]
       [:br]
       [:li
        [:a {:href "https://github.com/g-jensen/graphing"} "Repo Link"]]]]]]))