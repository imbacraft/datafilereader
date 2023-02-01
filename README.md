# DataFileReader

## Introduction

This is a training Maven Java project. 
Its goals is to create a library that reads the file `./sample/Substances.dat` and makes its contents available as Java objects for further processing.

## Requirements

1. For each line of the file, the number of attributes contained and the length of the individual attributes must be checked according to the specification document.
2. Further file types (e.g. the enclosed /sample/Companies.dat) as well as resulting objects should be able to be added with as little intervention as possible in the existing code while maximising its reuse.
3. Since the files can be of almost any length, it is important that the reading is done in blocks - i.e. in the case of Substances.dat per pure substance - so that the entire file or the resulting objects do not have to be loaded into the main memory before further processing.
4. The project shall include a unit test that reads the file and writes it in the format: CAS-NR, first synonym of the current locale.
5. The same test shall check whether the last substance is called "TestD" or "TestE" according to the locale set.

## Dependencies

1. Java SE 1.8+
2. Git
3. Maven

## Installation 

1. Clone the repository from GitHub using the command: `git clone https://github.com/imbacraft/datafilereader.git`
2. Navigate to the root directory of the cloned repository: `cd filereader`
3. Install the project and its dependencies using the following command: `mvn clean install`
4. Run the project either from your favorite IDE, or using the command: `java -cp target/classes starter.MainClass`

## Deployment 

In case the project needs to be deployed onto a production server, do the following:
1. Package the project into a jar file using the following command: `mvn package`.
2. Copy the generated .jar file onto the production server
3. Run the jar file on the production server using the following command:`java -jar DataFileReader-1.0-SNAPSHOT.jar`

## Project structure

DataFileReader
├── README.md
├── pom.xml
├── samples
│   ├── Companies.dat
│   └── Substances.dat
└── src
    ├── prod
    │   └── java
    │       ├── constants
    │       │   ├── FilePaths.java
    │       │   ├── HeaderConstants.java
    │       │   ├── ItemConstants.java
    │       │   ├── SubstanceConstants.java
    │       │   └── SynonymConstants.java
    │       ├── entities
    │       │   ├── Header.java
    │       │   ├── Substance.java
    │       │   └── Synonym.java
    │       ├── exceptions
    │       │   ├── InvalidFieldException.java
    │       │   └── MissingFieldException.java
    │       ├── factories
    │       │   ├── FactoryInterface.java
    │       │   ├── HeaderFactory.java
    │       │   ├── SubstanceFactory.java
    │       │   └── SynonymFactory.java
    │       ├── filereader
    │       │   ├── DataFileReaderInterface.java
    │       │   └── SubstanceFileReader.java
    │       ├── messages
    │       │   ├── HeaderErrorMessages.java
    │       │   ├── SubstanceErrorMessages.java
    │       │   └── SynonymErrorMessages.java
    │       ├── starter
    │       │   └── MainClass.java
    │       └── utils
    │           └── HelperMethods.java
    └── test
        └── java
            └── starter
                └── MainClassTest.java

## Functionality

This project is a Java library that provides functionality to read a file (currently ./sample/Substances.dat, but can be easily expanded to read others), and make its contents available as Java objects for further processing. The library takes the contents of the Substances.dat file, parses it, rigorously checks the parsed fields against specified criteria and creates objects representing each item in the file. The resulting objects can then be used for various purposes, such as data analysis, reporting, or further processing.

The library is designed to be flexible and easy to use. It can be used as a standalone library in a variety of applications or integrated into existing applications to provide additional functionality. The library is also designed to be easily extendable, allowing users to add their own custom file formats and custom objects to represent substances.

By providing an easy-to-use library for reading and processing files, this project makes it possible for developers to quickly and efficiently process large amounts of data and use it in their applications.






