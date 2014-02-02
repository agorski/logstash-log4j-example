logstash-log4j-example
======================

# Description
An example of a java maven application which logs to logstash. Logstash is configured with log4j input. Send message is json type and is filtered/parsed. All send to embedded Elasticsearch.

# Prepare

Logstash is packed as a simple JAR file including: logstash, embedded Elasticsearch storage and nice frontend called Kibana.

Download logstash
from http://logstash.net
into the project directory called "logstash" or anywhere you want but then use a config file from "logstash" directory.

## Start logstash (here example for version 1.3.3)
java -jar logstash-1.3.3-flatjar.jar agent -f logstash-log4j.conf -- web

## Execute Unit Test

One Unit Test execution creates2 Log Events:
    * simple with a map

    "msg" : {
            "first-name" : "Albert",
             "last-name" : "Gorski",
             "city" :"Berlin"
            }


    * and complex (a map which incudes a map):

    "msg":
        {"customer" : {
            "first-name" : "Albert",
            "last-name" : "Gorski",
            "city" : "Berlin"
            }
        }


## Look at Kibana frontend to see log events
http://localhost:9292/index.html#/dashboard/file/logstash.json


# Query Kibana

Now you can query JSON messages in Kibana like:
    * simple:
        msg.city:Berlin
    * complex analog:
        msg.customer.city:Berlin