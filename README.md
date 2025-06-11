# fileuploadwithcontrolspringboot
in this projet, We build a small DTO to validate a form that contain same data and a PDF file

The application is made with springboot framework and here is endpoint of our application


| Methode | Endpoint            | description                                                  |
|---------|---------------------|--------------------------------------------------------------|
| POST    | api/file            | Upload a PDF and same data about the user                    |
| GET     | api/files           | get all  files and details                                   |
| GET     | api/file/{id:int}   | get detail of a file (not implemented yet)                   |
| GET     | api/file/show/{url} | it will display the PDF in the browser (not implemented yet) |

The application use Java 21 and H2 as database (the app was just for fun)

To run the app for the first time you need to have java 21 installed and run the following cmd
```
mvn spring-boot:run
```

the app will start on port 8080. if you have another app running on that port, you can change the default port in `application.properties` file
