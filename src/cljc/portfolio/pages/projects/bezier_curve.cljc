(ns portfolio.pages.projects.bezier-curve 
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "Bezier Curve"]]
    [:div.center
     [:h4.subtitle "Written in C++"]]
    [:div.center
     [:br]
     [:div.description
      [:ul
       [:li "Graphical visualization of a quadratic bezier curve. It depicts 3 points, all at positions on a line coresponding to a single interpolation value. Gradually changing this value results in a curve seen in the video below."]
       [:br]
       [:iframe
        {:width "600"
         :height "300"
         :src "https://www.youtube.com/embed/1zO1_BbB2JU"}]
       [:br]
       [:li
        [:a {:href "https://github.com/g-jensen/BezierCurve"} "Repo Link"]]
       [:li "More about the Bezier Curve"
        [:ul
         [:li [:a {:href "https://en.wikipedia.org/wiki/Pierre_B%C3%A9zier"} "Pierre Bézier"] " was the French engineer that discovered the curve"]
         [:li [:a {:href "https://www.youtube.com/watch?v=aVwxzDHniEw"} "Useful Youtube video on Bezier Curves"]]]]]]]]))