#!/bin/bash

input="/Users/minisha/workspace/hellocucumber/src/test/resources/hellocucumber/test.feature"
while IFS= read -r line
do
  group=$line | cut -d "[" -f2 | cut -d "]" -f1

done < "$input"

sed 's/\[[^][]*\]//g' $input > "/Users/minisha/workspace/hellocucumber/src/test/resources/hellocucumber/feature/test.feature"