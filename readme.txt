Servlet Programming using Java in ubuntu:
First set up Apache Tomcat in Ubuntu,
In order to setup apache tomcat in Ubuntu follow the insrtuction the link given below
http://www.howtogeek.com/howto/linux/installing-tomcat-6-on-ubuntu/
In the place of Java_Home make sure you give the path to your jdk
In order to know the path where your JDK is store 
open terminal and type locate jdk
Copy paste the link of your jdk file in JAVA_HOME variable.
wget might not work in proxy so go n download the apache tomcat folder for ubuntu.
Then when you're about to compile the java package set this classpasth
CLASSPATH=.:/usr/local/tomcat7/lib/servlet-api.jar
This servelt uses MySQL for backend and it is used to perform register update delere operation of student details.
in order to view the file 
type:
http://localhost:8080/registeruser/home.html
In order to establish connectivity make sure you add the mysql connector file in your tomcat lib folder and restart tomcat again
to restart tomcat again you type the following command in terminal
sudo /etc/init.d/tomcat restart