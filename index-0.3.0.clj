{:namespaces
 ({:source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :wiki-url
   "http://clojure.github.com/java.jmx/clojure.java.jmx-api.html",
   :name "clojure.java.jmx",
   :author "Stuart Halloway",
   :doc
   "JMX support for Clojure\n\nUsage\n  (require '[clojure.java.jmx :as jmx])\n\nWhat beans do I have?\n\n  (jmx/mbean-names \"*:*\")\n  -> #<HashSet [java.lang:type=MemoryPool,name=CMS Old Gen,\n                java.lang:type=Memory, ...]\n\nWhat attributes does a bean have?\n\n  (jmx/attribute-names \"java.lang:type=Memory\")\n  -> (:Verbose :ObjectPendingFinalizationCount\n      :HeapMemoryUsage :NonHeapMemoryUsage)\n\nWhat is the value of an attribute?\n\n  (jmx/read \"java.lang:type=Memory\" :ObjectPendingFinalizationCount)\n  -> 0\n  (jmx/read \"java.lang:type=Memory\" [:HeapMemoryUsage :NonHeapMemoryUsage])\n  ->\n  {:NonHeapMemoryUsage\n    {:used 16674024, :max 138412032, :init 24317952, :committed 24317952},\n   :HeapMemoryUsage\n    {:used 18619064, :max 85393408, :init 0, :committed 83230720}}\n\nCan't I just have *all* the attributes in a Clojure map?\n\n  (jmx/mbean \"java.lang:type=Memory\")\n  -> {:NonHeapMemoryUsage\n       {:used 16674024, :max 138412032, :init 24317952, :committed 24317952},\n      :HeapMemoryUsage\n       {:used 18619064, :max 85393408, :init 0, :committed 83230720},\n      :ObjectPendingFinalizationCount 0,\n      :Verbose false}\n\nCan I find and invoke an operation?\n\n  (jmx/operation-names \"java.lang:type=Memory\")\n  -> (:gc)\n  (jmx/invoke \"java.lang:type=Memory\" :gc)\n  -> nil\n\nWhat about some other process? Just run *any* of the above code\ninside a with-connection:\n\n  (jmx/with-connection {:host \"localhost\", :port 3000}\n    (jmx/mbean \"java.lang:type=Memory\"))\n  -> {:ObjectPendingFinalizationCount 0,\n      :HeapMemoryUsage ... etc.}\n\nCan I serve my own beans?  Sure, just drop a Clojure ref\ninto an instance of clojure.java.jmx.Bean, and the bean\nwill expose read-only attributes for every key/value pair\nin the ref:\n\n  (jmx/register-mbean\n     (create-bean\n     (ref {:string-attribute \"a-string\"}))\n     \"my.namespace:name=Value\")"}),
 :vars
 ({:arglists ([n]),
   :name "attribute-names",
   :namespace "clojure.java.jmx",
   :source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj#L267",
   :raw-source-url
   "https://github.com/clojure/java.jmx/raw/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/attribute-names",
   :doc "All attribute names available on an MBean.",
   :var-type "function",
   :line 267,
   :file "src/main/clojure/clojure/java/jmx.clj"}
  {:arglists ([state-ref]),
   :name "create-bean",
   :namespace "clojure.java.jmx",
   :source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj#L325",
   :raw-source-url
   "https://github.com/clojure/java.jmx/raw/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/create-bean",
   :doc
   "Expose a reference as a JMX bean. state-ref should be a Clojure\nreference (ref, atom, agent) containing a map.",
   :var-type "function",
   :line 325,
   :file "src/main/clojure/clojure/java/jmx.clj"}
  {:arglists ([n op & args]),
   :name "invoke",
   :namespace "clojure.java.jmx",
   :source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj#L295",
   :raw-source-url
   "https://github.com/clojure/java.jmx/raw/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/invoke",
   :doc "Invoke an operation an an MBean. See also: invoke-signature",
   :var-type "function",
   :line 295,
   :file "src/main/clojure/clojure/java/jmx.clj"}
  {:arglists ([n op signature & args]),
   :name "invoke-signature",
   :namespace "clojure.java.jmx",
   :source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj#L278",
   :raw-source-url
   "https://github.com/clojure/java.jmx/raw/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/invoke-signature",
   :doc
   "Invoke an operation an an MBean. You must also supply\nthe signature of the operation. This is useful in cases\nwhere the operation is overloaded. Otherwise you should\nuse the 'invoke' operation which will determine the\nsignature for you.\n\nThe signature parameter is a sequence of strings that\ndescribes the method parameter types in order.",
   :var-type "function",
   :line 278,
   :file "src/main/clojure/clojure/java/jmx.clj"}
  {:arglists ([n]),
   :name "mbean",
   :namespace "clojure.java.jmx",
   :source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj#L300",
   :raw-source-url
   "https://github.com/clojure/java.jmx/raw/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/mbean",
   :doc
   "Like clojure.core/bean, but for JMX beans. Returns a read-only map of\na JMX bean's attributes. If an attribute it not supported, value is\nset to the exception thrown.",
   :var-type "function",
   :line 300,
   :file "src/main/clojure/clojure/java/jmx.clj"}
  {:arglists ([n]),
   :name "mbean-names",
   :namespace "clojure.java.jmx",
   :source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj#L262",
   :raw-source-url
   "https://github.com/clojure/java.jmx/raw/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/mbean-names",
   :doc
   "Finds all MBeans matching a name on the current *connection*.",
   :var-type "function",
   :line 262,
   :file "src/main/clojure/clojure/java/jmx.clj"}
  {:arglists ([n]),
   :name "operation-names",
   :namespace "clojure.java.jmx",
   :source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj#L273",
   :raw-source-url
   "https://github.com/clojure/java.jmx/raw/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/operation-names",
   :doc "All operation names available on an MBean.",
   :var-type "function",
   :line 273,
   :file "src/main/clojure/clojure/java/jmx.clj"}
  {:file "src/main/clojure/clojure/java/jmx.clj",
   :raw-source-url
   "https://github.com/clojure/java.jmx/raw/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj#L207",
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/read",
   :namespace "clojure.java.jmx",
   :line 207,
   :var-type "var",
   :doc "Read one or more mbean properties.",
   :name "read"}
  {:arglists ([n attr]),
   :name "readable?",
   :namespace "clojure.java.jmx",
   :source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj#L236",
   :raw-source-url
   "https://github.com/clojure/java.jmx/raw/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/readable?",
   :doc "Is attribute readable?",
   :var-type "function",
   :line 236,
   :file "src/main/clojure/clojure/java/jmx.clj"}
  {:arglists ([mbean mbean-name]),
   :name "register-mbean",
   :namespace "clojure.java.jmx",
   :source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj#L257",
   :raw-source-url
   "https://github.com/clojure/java.jmx/raw/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/register-mbean",
   :doc "Register an mbean with the current *connection*.",
   :var-type "function",
   :line 257,
   :file "src/main/clojure/clojure/java/jmx.clj"}
  {:arglists ([opts & body]),
   :name "with-connection",
   :namespace "clojure.java.jmx",
   :source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj#L178",
   :raw-source-url
   "https://github.com/clojure/java.jmx/raw/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/with-connection",
   :doc
   "Execute body with JMX connection specified by opts. opts can also\ninclude an optional :environment key which is passed as the\nenvironment arg to JMXConnectorFactory/connect.",
   :var-type "macro",
   :line 178,
   :file "src/main/clojure/clojure/java/jmx.clj"}
  {:arglists ([n attr value]),
   :name "write!",
   :namespace "clojure.java.jmx",
   :source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj#L222",
   :raw-source-url
   "https://github.com/clojure/java.jmx/raw/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/write!",
   :doc "Write an attribute value.",
   :var-type "function",
   :line 222,
   :file "src/main/clojure/clojure/java/jmx.clj"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/Bean",
   :namespace "clojure.java.jmx",
   :var-type "type",
   :name "Bean"}
  {:file "src/main/clojure/clojure/java/jmx.clj",
   :raw-source-url
   "https://github.com/clojure/java.jmx/raw/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj",
   :source-url
   "https://github.com/clojure/java.jmx/blob/8b1165232b70a3ac0afb108017b30af3248f142a/src/main/clojure/clojure/java/jmx.clj#L125",
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/Destract",
   :namespace "clojure.java.jmx",
   :line 125,
   :var-type "protocol",
   :doc nil,
   :name "Destract"}
  {:file nil,
   :raw-source-url nil,
   :source-url nil,
   :wiki-url
   "http://clojure.github.com/java.jmx//clojure.java.jmx-api.html#clojure.java.jmx/objects->data",
   :namespace "clojure.java.jmx",
   :var-type "function",
   :arglists ([_]),
   :doc
   "Convert JMX object model into data. Handles CompositeData, TabularData, maps, and atoms.",
   :name "objects->data"})}