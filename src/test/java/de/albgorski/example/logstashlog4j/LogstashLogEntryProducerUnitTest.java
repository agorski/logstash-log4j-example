package de.albgorski.example.logstashlog4j;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LogstashLogEntryProducerUnitTest {
    private LogstashLogEntryProducer logstashLogEntryProducer;

    @Before
    public void setUp() {
        logstashLogEntryProducer = new LogstashLogEntryProducer();
    }

    @Test
    public void createComplexLogEntry() {
        logstashLogEntryProducer.makeLogEntry(getComplexMap());
        assert true;
    }

    @Test
    public void createSimpleLogEntry() {
        logstashLogEntryProducer.makeLogEntry(getSimpleMap());
        assert true;
    }

    private Map<String, ?> getComplexMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("order-date", new DateTime().toString());
        map.put("customer", getSimpleMap());
        return map;
    }

    private Map<String, ?> getSimpleMap() {
        Map<String, String> map = new HashMap<>();
        map.put("first-name", "Albert");
        map.put("last-name", "Gorski");
        map.put("city", "Berlin");
        return map;
    }

}
