#!/bin/bash

javac -cp ./src/  -d ./target/ *.java  ./class_Animal/*.java ./class_Biome/*.java ./class_Carte/*.java ./class_Vegetal/*.java ./class_Animal/Homme/*.java
cd target
jar cvfm Main.jar ../manifest.txt *.class ./class_Animal/*.class ./class_Biome/*.class ./class_Carte/*.class ./class_Vegetal/*.class ./class_Animal/Homme/*.class
cd ..