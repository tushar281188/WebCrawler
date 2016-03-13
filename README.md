# WebCrawler
1. git clone https://github.com/tushar281188/WebCrawler.git
2. cd WebCrawler

## Prerequisite
1. jdk v1.7 and above
2. maven v3.2.4
3. Mysql 5.6

##maven commands
1. mvn clean compile assembly:single
2. cd target

##Java command to run
java -jar crawler-0.0.1-SNAPSHOT-jar-with-dependencies.jar XML_TEMPLATE_PATH USER_PROFILE_URL > OUTPUT_FILE

e.g java -jar crawler-0.0.1-SNAPSHOT-jar-with-dependencies.jar /home/tushar/Desktop/user_profile.xml https://sg.linkedin.com/in/gargakshay > output.json
 
Note: user_profile.xml can be downloaded from https://raw.githubusercontent.com/tushar281188/WebCrawler/master/user_profile.xml
