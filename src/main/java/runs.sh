#!/bin/bash
javac com/aleshamray/pra/Main.java

for ((i = 1; i <= 30; i++)); do
  java com/aleshamray/pra/Main $i
  cp algs.data data/algs-1-$i-001.data
  rm algs.data
done
