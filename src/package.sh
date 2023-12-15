#!/bin/bash

javac -cp ./src/  -d ./target/ ./dech/*.java  ./src/fr/dech/Animal/*.java ./src/fr/dech/Biome/*.java ./src/fr/dech/Carte/*.java ./src/fr/dech/Vegetal/*.java ./src/fr/dech/Animal/Homme/*.java
cd target
jar cvfm Main.jar ../manifest.txt ./fr/dech/*.class ./fr/dech/Animal/*.class ./fr/dech/Biome/*.class ./fr/dech/Carte/*.class ./fr/dech/Vegetal/*.class ./fr/dech/Animal/Homme/*.class
cd ..