# Fhir-Patient-Json-Filter
This is a prerequisite Gsoc2018 task for LibreHealth .

This project consists of two application, the spring application which is this one and the user interface https://github.com/lehone-hp/fhir-patient-json-filter-ui. 

Fhir-Patient-Json-Filter was build with spring framework and the Fhir-Patient-Json-Filter-Ui was built with angular 5.

## First Run the server

### Prerequisites
    * maven
    * java
    * git
    
### Get the code from github

    git clone https://github.com/lehone-hp/fhir-patient-json-filter.git

### Build the application
Change working directory

    cd fhir-patient-json-filter
    
build the application

    mvn clean package
    
### Run the application on port 8080
Ensure that no other application is running on 8080

    cd target
    
    java -jar fhir-patient-json-filter-0.0.1-SNAPSHOT.jar
    
## Run the UI
If the server is successfully running, get the code of the UI 

    git clone https://github.com/lehone-hp/fhir-patient-json-filter-ui.git 
    
then 

    cd fhir-patient-json-filter-ui
    
and run the user interface in dev mode
    
    ng serve
    
if you get the error message 

    /usr/lib/node_modules/@angular/cli/models/config/config.js:17
        constructor(_configPath, schema, configJson, fallbacks = []) {
                                                               ^
    
    SyntaxError: Unexpected token =
        at exports.runInThisContext (vm.js:53:16)
        at Module._compile (module.js:373:25)
        at Object.Module._extensions..js (module.js:416:10)
        at Module.load (module.js:343:32)
        at Function.Module._load (module.js:300:12)
        at Module.require (module.js:353:17)
        at require (internal/module.js:12:17)
        at Object.<anonymous> (/usr/lib/node_modules/@angular/cli/models/config.js:3:18)
        at Module._compile (module.js:409:26)

use 
    
    sudo nd serve
    
and access the application on your browser at localhost:4200