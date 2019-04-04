#!/bin/sh
classfile=./GUETWebClient/Logout.class
file=./GUETWebClient/Logout.java
if [ ! -f "$classfile" ]; then
javac $file -encoding utf8
fi
java GUETWebClient.Logout
