package de.albgorski.example.logstashlog4j;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class LogstashLogEntryProducer {
    private static final Logger LOG = LoggerFactory.getLogger("logstash-socket");

    public void makeLogEntry(Map<String, ?> input) {
        JSONObject json = new JSONObject(input);
        LOG.info(json.toJSONString());
    }
}
