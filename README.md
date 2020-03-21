
# Product Service

Product service is a micro-service that serves as a repository for products in marketplace.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Things you need to install the software and how to install them

#### Oracle Java 8

##### Steps to download and install Oracle Java 8 on Ubuntu 16.04 LTS

```bash
# Update and upgrade package list and packages.
$ sudo apt-get update -y
$ sudo apt-get upgrade -y
# Add personal package archive for java and update package list information.
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt-get update -y
# Download and install java
$ sudo apt-get install oracle-java8-installer
# Check the version of the Java
$ java -version
# You should see the following output:
java version "1.8.0_91"
Java(TM) SE Runtime Environment (build 1.8.0_91-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.91-b14, mixed mode)
```

#### Apache Maven 3.x

##### Steps to download and install Apache Maven 3 on Ubuntu 16.04 LTS

```bash
# Update and upgrade package list and packages.
$ sudo apt-get update -y
$ sudo apt-get upgrade -y
# Download maven
$ sudo cd /opt/
wget http://www-eu.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
# Extract the downloaded archive
$ sudo tar -xvzf apache-maven-3.3.9-bin.tar.gz
# Rename the extracted directory
$ sudo mv apache-maven-3.3.9 maven 
```

##### Configure Environment Variables for Apache Maven 3

```bash
# Open file in text editor
$ sudo nano /etc/profile.d/mavenenv.sh
# Add the following lines
$ export M2_HOME=/opt/maven
$ export PATH=${M2_HOME}/bin:${PATH}
# Save and close the file, update its permissions, then load the environment variables with the following command:
$ sudo chmod +x /etc/profile.d/mavenenv.sh
$ sudo source /etc/profile.d/mavenenv.sh
# Check the version of the Apache Maven
$ mvn --version
# You should see the following output:
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T22:11:47+05:30)
Maven home: /opt/maven
Java version: 1.8.0_101, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-8-oracle/jre
Default locale: en_US, platform encoding: ANSI_X3.4-1968
OS name: "linux", version: "3.13.0-32-generic", arch: "amd64", family: "unix"
```

#### Git

##### Steps to download and install Git on Ubuntu 16.04 LTS

```bash
# Update and upgrade package list.
$ sudo apt-get update
# # Download and install git
$ sudo apt-get install git
# Check the version of the Apache Maven
$ git --version
# You should see the following output:
git version 2.7.4
```

#### MongoDB

##### Steps to download and install MongoDB  on Ubuntu 16.04 LTS

```bash
# Import key for official mongoDB repository for Ubuntu
$ sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv EA312927
# Issue the following command to create a list file for MongoDB.
$ echo "deb http://repo.mongodb.org/apt/ubuntu xenial/mongodb-org/3.2 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.2.list
# After adding the repository details, we need to update the packages list.
$ sudo apt-get update
# Install MongoDB
$ sudo apt-get install -y mongodb-org
```

##### Start MongoDB

```bash
# Issue the following command to start MongoDB.
$ sudo systemctl start mongod
# You can also use `systemctl` to check that the service has started properly.
$ sudo systemctl status mongod
# You should see the following output:
● mongodb.service - High-performance, schema-free document-oriented database
   Loaded: loaded (/etc/systemd/system/mongodb.service; enabled; vendor preset: enabled)
   Active: active (running) since Mon 2016-04-25 14:57:20 EDT; 1min 30s ago
 Main PID: 4093 (mongod)
    Tasks: 16 (limit: 512)
   Memory: 47.1M
      CPU: 1.224s
   CGroup: /system.slice/mongodb.service
           └─4093 /usr/bin/mongod --quiet --config /etc/mongod.conf
# If you want to automaically start MongoDB as your system boots or re-boots.
$ sudo systemctl enable mongod
# If you want to disable automaically start the MongoDB as your system boots or re-boots
$ sudo systemctl disable mongod
```

### Installing Service

A step by step series of examples that tell you how to get a development env running in Ubuntu 16.04 LTS

#### Step 1 : Create workspace

```bash
# Switch to your home directory
$ cd ~
# Create a directroy to host all your development projects.
$ mkdir workspace
```

#### Step 2 : Download project

```bash
# Switch to your workspace directory
$ cd ~/workspace
# Download project source code from git repository
$ git clone <THE GIT REPOSITORY URI FOR THIS PROJECT>
```

#### Step 3 : Build your project

```bash
# Switch to your project directory
$ cd ~/workspace/product-service
# Download project source code from git repository
$ ./mvnw package

```

#### Step 4 : Run the service
```bash
# Switch to your project directory
$ cd ~/workspace/product-service
# Issues the following command to run the service
$ java -jar target/product-service-*.jar
```

Open any browser and enter the following URL

```
http://localhost:8080/products
```

## Running the tests

To run the automated tests for this service issue the following command

```bash
# Switch to your project directory
$ cd ~/workspace/product-service
# Issues the following command to execute unit tests
$ mvn clean test
```

## Built With

* [Oracle Java 8](https://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) - The language used
* [Spring](https://spring.io/microservices) - The framework used.
* [Maven](https://maven.apache.org/) - The dependency management tool used.
* [MongoDB](https://www.mongodb.com/) - The database used.

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Muhammad Ali Qasmi** - *Initial work* - [Muhammad Ali Qasmi](https://github.com/muhammadaliqasmi)

## License

This project is licensed under the GNU GENERAL PUBLIC LICENSE - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* [Mateusz Papiernik](https://www.digitalocean.com/community/tutorials/how-to-install-mongodb-on-ubuntu-16-04) - How to Install MongoDB on Ubuntu 16.04
* [Brennen Bearnes](https://www.digitalocean.com/community/tutorials/how-to-install-git-on-ubuntu-16-04) - How To Install Git on Ubuntu 16.04
* [VULTR](https://www.vultr.com/docs/how-to-install-apache-maven-on-ubuntu-16-04) - How to install apache maven on ubuntu 16.04

