# BitTE Optimization Project

## Overview

We have managed to develop an application called *PackApp* that assists travellers with the task of loading a suitcase.

Below you can find a detailed description of this repositorys contents and its intended use.

---

## Compilation

We have chosen to work with Maven as a compilation and packing/testing tool.

In order to compile the program the following command is used:

```bash
mvn clean install
```

This command will clean the target directory and then compile and package the application.

---

## Execution

### Header

Directions for program execution

---

## Usage Guide

Below you can find a description of the standard program use.

- When the app is launched, the user is prompted to input the dimension (length, width, height) of their suitcase.
- Afterwards, the app requests an input from the user that concerns some essential items
  
  that the user requires to be packed (such as a shirt or hoodie).
  
- The app makes sure to ask for the user's sex so that it can select the appropriate items accordingly.
- This process is then continued for as long as the user needs until they have added all essential items.
- The same process follows for essential accessories one might need.
- When the user is satisfied with their choices and exits the selection process,

  the app uses optimization methods to present the combination of items that can fit the remainder of space

  while already having packed all essential items beforehand.

---

## Repository Layout

The project follows the standard Maven directory structure:

```
project-root/
├── src/
│   ├── main/
│   │   ├── java/          
│   │   ├── resources/  
│   └── test/
│       ├── java/         
│       ├── resources/    
├── pom.xml                 
└── target/ 
```

We Have also added some external files for the purpose of static code analysis

and github actions such as automatic pull request reviewer assignment, as well as 

the get-pip.py file that eases the package download process in terminal use.

---

## UML Diagram

UML DIAGRAM HERE

---

## Algorithm and Database Review

### Algorithms used

- Inside the pom.xml file, we include multiple dependencies and plugins that provide us with tools to assist in the

   optimization process.

- Most notably, we use the *chocosolver* dependency to create the base model due for optimization

  and set volume and weigh constraints. We made sure the algorithm provides the user with an answer

  whether a solution is found or not.
### Database Review

→ We have developed a structured database using sql in order to store different items in the clothing

 as well as the extras categories. Sql comands are then used to insert said items into their respected tables.

→ We have created specific files under src-> main-> recources in order to store some properties for the jdbc drivers used and connection settings.

---

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.
