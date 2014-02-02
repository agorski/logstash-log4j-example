logstash-log4j-example
======================

# Description
An example of a java maven application which logs to logstash. Logstash is configured with log4j input.
Sent message is json type and it's content is filtered/parsed and mutated (some fields are stripped from oryginal message).
After filter and mutate, final json is send to embedded Elasticsearch.

Logstash is packed as a simple JAR file including:
* logstash
* embedded Elasticsearch storage
* nice frontend called Kibana

# Steps

## Download logstash
from http://logstash.net
* into the project directory called "logstash"
* or anywhere you want but then use a config file from "logstash" directory

## Start logstash (here example for version 1.3.3)
java -jar logstash-1.3.3-flatjar.jar agent -f logstash-log4j.conf -- web

## Execute Unit Test
start terminal, go to project directory and execute following command:
<tt>mvn test</tt>

One Unit Test execution creates 2 Log Events:
* simple with a map
<tt>
"msg" : {
        "first-name" : "Albert",
         "last-name" : "Gorski",
         "city" :"Berlin"
        }
</tt>

* and complex (a map which incudes a map):
<tt>
"msg":
    {"customer" : {
        "first-name" : "Albert",
        "last-name" : "Gorski",
        "city" : "Berlin"
        }
    }
</tt>

## Look at Kibana frontend to see log events
http://localhost:9292/index.html#/dashboard/file/logstash.json

# Query Kibana

Now you can query JSON messages in Kibana like:
* simple: <tt>msg.city:Berlin</tt>
* complex analog: <tt>msg.customer.city:Berlin</tt>