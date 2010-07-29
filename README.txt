Welcome to DSLs In Action
-------------------------

The archive contains all the source code that you will find in the book chapters. The code base has
been indexed based on the chapters where they occur and the context in which we use them. As for example,
the following is the layout for one of the sample chapters in the book:

chapter2
|
|
+--- order_dsl_groovy
|
|
+--- order_dsl_java

This indicates that chapter 2 of the book discusses order processing DSLs and we have 2 implementations 
of the same. In the code package we have 2 folders for the 2 implementations. Let's dig deep into the folders 
to get an idea of how we package these DSLs here.

order_dsl_groovy
|
|
+--- order
|    |
|    |
|    +--- src
|    |    |
|    |    |
|    |    +--- main
|    |         |
|    |         |
|    |         +--- groovy
|    |              |
|    |              |
|    |              +--- ch2
|    |                   |
|    |                   |
|    |                   +--- order
|    |                        |
|    |                        |
|    |                        +--- ClientOrder.groovy
|    |                        |
|    |                        |
|    |                        +--- order.dsl
|    +--- pom.xml
|
|
+--- readme.txt

The artifact order contains the source hierarchy, while the readme.txt contains instructions on how to build 
and run the DSL main scripts. The actual instructions depend on whether the source is Java, Groovy, Ruby, Scala
or Clojure.

Happy DSLing!
