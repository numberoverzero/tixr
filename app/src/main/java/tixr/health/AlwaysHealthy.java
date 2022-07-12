package tixr.health;

import com.codahale.metrics.health.HealthCheck;

import tixr.config.Region;
import tixr.config.Stage;

public class AlwaysHealthy extends HealthCheck {

    private final Region region;
    private final Stage stage;

    public AlwaysHealthy(final Region region, final Stage stage) {
        this.region = region;
        this.stage = stage;
    }

    @Override
    protected Result check() throws Exception {
        final var msg = String.format("(%s, %s) is always healthy", this.region.toValue(), this.stage.toValue());
        return Result.healthy(msg);
    }

}
