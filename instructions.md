##Instructions to run the project by Alberto García Castro:

- The whole project has been made in Java 11 version and using the compiler Intellij IDEA
so I will suject to use the same compiler to check out the project and play with it.

##Storage data base
-As it was said, the project has self storage by a H2 data base integrated. This kind of data base provides a client
to see that the data is well saved onces you are testing your services.
To access this client just insert the following url in your browser:http://localhost:8085/h2-console
To connect, just introduce the following data:

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:

##Test the methods
-Once the project is running, it has include a swagger 2 to test the services. 
To access this swagger, just insert the following url in your browser: http://localhost:8085/swagger-ui.html
The methods works by inserting json objects into their bodies. So to test the first service you can test it by inserting :
{
  "reference":"ABCD123456",
  "parcels" : [
  {
    "weight":1,
    "width": 10,
    "height": 10,
    "length": 10
  },
  {
    "weight":2,
    "width": 20,
    "height": 20,
    "length": 20
  }
  ]
}

and to test the second one, by inserting: 
{
  "status":"DELIVERED",
  "parcels":2,
  "weight":1,
  "reference":"ABCD123454"
}

All the jsons are the sames as there were in the initial instructions
##Additional sftware
I used another different software to test my code. It is postman and if you want to test the methos by using it, you can find it here: https://www.postman.com/downloads/

The rest of the tools are included into the IDE.

