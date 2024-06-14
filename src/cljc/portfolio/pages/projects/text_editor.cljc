(ns portfolio.pages.projects.text-editor 
  (:require [portfolio.page :as page]))

(def page
  (list
   [:html {:lang "en"}]
   (page/head "Greg Jensen")
   [:body
    page/nav-bar
    [:div.center
     [:h1 "Text Editor"]]
    [:div.center
     [:h4.subtitle "Written in C++"]]
    [:div.center
     [:br]
     [:div.description
      [:ul
       [:li "Features"
        [:ul
         [:li "Basic movement around the file with the arrow keys"]
         [:li "Creating and deleting new lines"]
         [:li "Slicing between lines"]
         [:li "Inputing any unicode characters"]
         [:li "File importing and exporting"]
         [:li "Custom keybinding system"]
         [:li "Custom theme system"]]]
       [:br]
       [:iframe {:width "600" :height "300" :src "https://www.youtube.com/embed/edAwFYiuAqE"}]
       [:br]
       [:li [:a {:href "https://github.com/g-jensen/text-editor"} "Repo link"]]]]]]))