# Quote Service
A demo spring boot app to test Cassandra + Spring Boot.
# Build and Run
Ensure a [Cassandra](http://cassandra.apache.org/) Instance is running before running the quote service. 
```
${cassandra_root}/bin/cassandra
```
```
mvn clean install
java -jar target/quote-service-0.1.0.jar
```


# Adding new quotes
### **POST** http://localhost:8080/addQuote
Example body: 
```
{
	"quote" : "The most dangerous phrase in the language is, 'We've always done it this way.'",
	"author": "Grace Hopper"
}
```

# Getting a random quote from the database
### **GET** http://localhost:8080/getQuotes
Quotes are randomly selected from those in the database. Example response:
```
“That brain of mine is something more than merely mortal; as time will show.” - Ada Lovelace
```
