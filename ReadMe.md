# Calculator


## Requirements

<ul>
<li>Java: v1.8</li>
<br>
<li>Maven: v3.3.9</li>
</ul>


## Setup

Building this project requires maven installed in your system. Make sure you have maven v3.3.9 or higher.
<br>
<br>
`mvn clean install`
<br>
<br>
A makefile is also included for user convenience. Users can also call:
<br>
<br>
`make clean build`


## Run

To run the project
<br>
<br>
`java -Dinput=<expression> -jar <path/to/jar>`

eg: <br>

`java -Dinput="2+4/2*3-1" -jar target/calculator.jar`
<br>
<br>
Users can also call:
<br>
<br>
`make run ARGS='-Dinput="2+4/2*3-1"'`

## TestCases

Testcases can be run using maven.
<br>
<br>
`mvn test`

Users can also call:
<br>
<br>
`make test`


## Dependencies

The project uses no external dependencies other than:

For testing:
##### JUnit v4.12 : [https://junit.org/junit4/](https://junit.org/junit4/)

For packaging executable JAR:
##### Maven Shade Plugin v4.12 : [https://maven.apache.org/plugins/maven-shade-plugin/](https://maven.apache.org/plugins/maven-shade-plugin/)


## Author

Janardhanan V S
