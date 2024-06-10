# Docker Images for Selenium

Docker images for Selenium, built for Debian ARM64, ARM/v7, and AMD64 are available [here](https://github.com/seleniumhq-community/docker-seleniarm).

## Start Standalone Server of Chrome and Firefox

### Selenium Chrome Standalone
To start the standalone server for Chrome, use the following command:

docker run --rm -it -p 4444:4444 -p 5900:5900 -p 7900:7900 --shm-size 2g seleniarm/standalone-chromium:latest

### Selenium Firefox Standalone
To start the standalone server for Firefox, use the following command:

docker run --rm -it -p 4442:4444 -p 5901:5900 -p 7901:7900 --shm-size 2g seleniarm/standalone-firefox:latest

To see what is happening inside the Chrome container, head to:
http://localhost:7900/?autoconnect=1&resize=scale&password=secret.

To see what is happening inside the Firefox container, head to:
http://localhost:7901/?autoconnect=1&resize=scale&password=secret.

### Pre-requisite
Run command mvn clean install -DskipTests=true

### To use Chrome browser
Run command mvn test -DBROWSER=chrome

###  To use firefox browser
Run command mvn test -DBROWSER=firefox

### To create and run the project as package

# Create package
Run command mvn clean package -DskipTests=true

# Run package present inside target folder
cd target
sudo chmod -R u+rwx,go+rwx .
java -DBROWSER=firefox -cp "seleniumDocker.jar:seleniumDocker-tests.jar:libs/*" org.testng.TestNG ../testng.xml
