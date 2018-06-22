Project Title
PegaUiTestDemo

Getting Started
Update the "PegaUrl" key in resources/config.properties file to reflect the same.

Prerequisites
Install Pega Personal Edition in local machine and start the service or Have any Pega Instance URL handy.

Give examples
<<To be added>>

Running the tests
The Test can be run in any one of below methods:
1 - Using Run As --> TestNG
2 - Using Run As --> Maven - Install
3 - Jenkins --> Job

The Test basically logs into Pega using Admin credentials and changes the URLs for Online Help, Public Link, External Link and SMA links. 
Then revalidates them & logs off. 

Built With
Selenium+Java
TestNG & Cucumber Framework
Maven Build Tool
and Jenkins CI/CD

Versioning
NA
Authors
Asokarao Guntuku

License
NA

Acknowledgments
Hat tip to anyone whose code was used
Inspiration
etc