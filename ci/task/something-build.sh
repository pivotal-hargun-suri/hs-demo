#!/bin/bash

cd source-code
mvn clean package

cd ..
mkdir build-output
mv source-code/target/*.jar build-output/
