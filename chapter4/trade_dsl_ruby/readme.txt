Running the examples :-

1. Prerequisite: Download and install JRuby (http://jruby.org). The current example is built using JRuby 1.5.1.
2. cd lib
3. mvn install ## will compile JRuby scripts and generate class files in current directory
4. java -cp d:\tech\jruby-1.5.1\lib\jruby.jar;. trade_dsl ## run Ruby as Java class
5. java -cp d:\tech\jruby-1.5.1\lib\jruby.jar;. run_script

Note: In 4 and 5 replace d:\tech\jruby-1.5.1\lib\jruby.jar with the actual installation path of JRuby in your system.
