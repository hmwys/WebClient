#!/bin/sh
classfile=./GUETWebClient/Login.class
if [ ! -f "$classfile" ]; then
javac  ./GUETWebClient/Login.java -encoding utf8
fi
java GUETWebClient.Login
