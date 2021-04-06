#!/bin/bash

parentDirectory=$( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )
subPath="/src/test/resources/hellocucumber/"
featureFileRawDirectory=$parentDirectory$subPath"rawfeature"
featureFileDirectory=$parentDirectory$subPath"feature"

generateFeatureFile() {
  input=$1
  jsonString=""
  filePathToWrite=""
  while IFS= read -r line
  do
    if [[ "$line" =~ "Group" ]]; then
      group=`echo $line | cut -d "[" -f2 | cut -d "]" -f1`
      line=`echo $line | sed -e 's/\[[^][]*\]//g'`
      jsonString+='{"group":"'$group'","line":"'$line'"},'
    fi
  done < $input
  finalJsonString=`echo $jsonString | sed 's/.$//'`
  jsonStringToWrite=`echo $finalJsonString | sed -e '1s/^/[/' -e 's/$/,/' -e '$s/,$/]/'`
  echo $jsonStringToWrite > $parentDirectory"feature.json"

  subPathValue=(`echo $input | sed -e 's/rawfeature/\n/g'`)
  subPathValueFirstElement=`echo ${subPathValue[1]}`
  finalSubPathValue=${subPathValueFirstElement#/} # Remove possible leading /
  filePathToWrite=$parentDirectory$subPath$finalSubPathValue
  echo "Wrinting file to Path"$filePathToWrite
  sed 's/\[[^][]*\]//g' $input >> $filePathToWrite
}

execute() {
  array=(`find $featureFileRawDirectory -type f`)

  for i in "${array[@]}"
  do :
      filePath=`echo $i`
      generateFeatureFile "$filePath"
  done
}

execute