(ns portfolio.pages.contact
  (:require [portfolio.page :as page]))

(def page
  (list
    [:html {:lang "en"}]
    (page/head "Greg Jensen")
    [:body
     page/nav-bar
     [:div.center
      [:h1 "Contact"]]
     [:div.center
      [:h4.subtitle "Email is my preferred form of communication"]]
     [:div.center
      [:br]
      [:div.description
       [:ul
        [:li "Timezone - " [:a {:href "https://www.timeanddate.com/worldclock/usa/indianapolis" :target "_blank"} "EST America/Indianapolis"] " (UTC -05:00)"]
        [:li [:a {:href "mailto:greg.micah.jensen@gmail.com" :target "_blank"} "greg.micah.jensen@gmail.com"]]
        [:li [:a {:href "https://linkedin.com/in/greg-jensen-88210a262" :target "_blank"} "LinkedIn"]]]]]]))