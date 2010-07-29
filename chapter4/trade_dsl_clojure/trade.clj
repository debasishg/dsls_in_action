; sample accounts
; use for trading and executions

(def ac1
  {:no "cl-a1" :name "john doe" :type ::trading})
  
(def ac2
  {:no "cl-a2" :name "j p morgan" :type ::trading})
  
; sample executions
; used for generating client trade

(def ex1
  {:ref-no "er-123" :account ac1 :instrument "eq-123" :value 1000})
  
  
  
(defn trading?
    "Returns true if the account is a trading account"
  [account]
  (= (:type account) ::trading))
  
  
  
; stub that generates dummy reference no
; currently it generates 100 unconditionally
; in real life it will be a detailed algorithm for generating reference numbers

(defn generate-trade-ref-no
    "Generate reference no"
  []
  100)
  

(defn allocate
    "Allocate execution to client account and generate client trade"
  [acc exe]
  (cond
    (nil? acc) (throw (IllegalArgumentException.
		       "account cannot be nil"))
    (= (trading? acc) false) (throw (IllegalArgumentException.
				     "must be a trading account"))
    :else {:ref-no (generate-trade-ref-no)
	   :account acc
	   :instrument (:instrument exe) :value (:value exe)}))
	   

; a macro to abstract boilerplates

(defmacro with-account
  [acc & body]
  `(cond
      (nil? ~acc) (throw (IllegalArgumentException.
		          "account cannot be nil"))
      (= (trading? ~acc) false) (throw (IllegalArgumentException.
					"must be a trading account"))
      :else ~@body))
      
      
; allocate function using macro with-account

(defn allocatem
    "Allocate execution to client account and generate client trade"
  [acc exe]
  (with-account acc
    {:ref-no (generate-trade-ref-no) :account acc :instrument (:instrument exe) :value (:value exe)}))