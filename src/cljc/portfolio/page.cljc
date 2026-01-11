(ns portfolio.page)

(defn head [title]
  [:head
   [:meta {:charset "UTF-8"}]
   [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
   [:link {:href "styles.css" :rel "stylesheet"}]
   [:title title]])

(def nav-bar
  [:div.center
   [:a {:href "/"} "Home"]
   [:a {:href "/math.html"} "Math"]
   [:a {:href "/contact.html"} "Contact"]
   [:a {:href "/blog"} "Blog"]
   [:a {:href "https://www.github.com/g-jensen"} "GitHub"]])

(defn ->page [file-name hiccup]
  {:file-name file-name :hiccup hiccup})