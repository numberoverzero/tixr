package tixr.config;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Stage {
    DEVELOPMENT("dev"),
    TEST_ISOLATED("test-iso"),
    TEST_INTEG("test-integ"),
    PRODUCTION("prod");

    private final String name;

    Stage(final String name) {
        this.name = name;
        _singleton.map.put(name, this);
    }

    @JsonCreator
    public static Stage fromValue(String name) {
        return _singleton.map.get(name);
    }

    @JsonValue
    public String toValue() {
        return this.name;
    }

    private static class _singleton {
        static Map<String, Stage> map = new HashMap<>();
    }
}
