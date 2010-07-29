; create a trade from a request
(defn trade
    "Make a trade from the request"
  [request]
  {:ref-no (:ref-no request)
   :account (:account request)
   :instrument (:instrument request)
   :principal (* (:unit-price request) (:quantity request))
   :tax-fees {}})
	
	
; a sample request	
(def request
  {:ref-no "trd-123"
   :account "nomura-123"
   :instrument "IBM"
   :unit-price 120
   :quantity 300})

 
; augment a trade with a tax fee value
(defn with-values [trade tax-fee value]
  (fn [request]
    (let [trdval (trade request)
          principal (:principal trdval)]
       (assoc-in trdval [:tax-fees tax-fee]
         (* principal (/ value 100))))))


; helper macro to redefine an existing value         
(defmacro redef
    "Redefine an existing value, keeping the meta-data intact"
  [name value]
  `(let [m# (meta #'~name)
	 v# (def ~name ~value)]
      (alter-meta! v# merge m#)
       v#))


; macro to decorate a function       
(defmacro with-tax-fee
    "Wrap a function in one or more decorators"
  [func & decorators]
  `(redef ~func (-> ~func ~@decorators)))


; compute the net value of a trade  
(defn net-value [trade]
  (let [principal (:principal trade)
	tax-fees (vals (trade :tax-fees))]
    (reduce + (conj tax-fees principal))))