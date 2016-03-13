# WebCrawler
git clone https://github.com/tushar281188/WebCrawler.git
cd WebCrawler


##maven commands
mvn clean compile assembly:single

cd target
##Java command to run
java -jar crawler-0.0.1-SNAPSHOT-jar-with-dependencies.jar <XML_TEMPLATE_PATH> <USER_PROFILE_URL> > <OUTPUT_FILE>

e.g java -jar crawler-0.0.1-SNAPSHOT-jar-with-dependencies.jar /home/tushar/Desktop/user_profile.xml https://sg.linkedin.com/in/gargakshay > output.json
