package tixr.config;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Region {
    LOCAL("local"),
    DEMO("demo"),
    US_EAST_1("us-east-1");

    private final String name;

    Region(final String name) {
        this.name = name;
        _singleton.map.put(name, this);
    }

    @JsonCreator
    public static Region fromValue(String name) {
        return _singleton.map.get(name);
    }

    @JsonValue
    public String toValue() {
        return this.name;
    }

    private static class _singleton {
        static Map<String, Region> map = new HashMap<>();
    }
}
