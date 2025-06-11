# fileuploadwithcontrolspringboot
in this projet, We build a small DTO to validate a form that contain same data and a PDF file

The application is made with springboot framework and here is endpoint of our application


| Methode | Endpoint            | description                                                  |
|---------|---------------------|--------------------------------------------------------------|
| POST    | api/file            | Upload a PDF and same data about the user                    |
| GET     | api/files           | get all  files and details                                   |
| GET     | api/file/{id:int}   | get detail of a file (not implemented yet)                   |
| GET     | api/file/show/{url} | it will display the PDF in the browser (not implemented yet) |

The application use Java 21 and POSTGRESQL as database

To run the app for the first time you need to have docker installed on your system and run

```
docker-compose up -build 
```
