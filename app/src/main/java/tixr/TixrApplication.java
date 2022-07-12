package tixr;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import tixr.api.GreetingResource;
import tixr.config.TixrConfiguration;
import tixr.health.AlwaysHealthy;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class TixrApplication extends Application<TixrConfiguration> {

    public static void main(String[] args) throws Exception {
        new TixrApplication().run(args);
    }

    @Override
    public void run(TixrConfiguration cfg, Environment env) throws Exception {
        final var greeting = new GreetingResource(cfg.getTemplate());
        env.jersey().register(greeting);

        final var check = new AlwaysHealthy(cfg.getRegion(), cfg.getStage());
        env.healthChecks().register("always up", check);
    }
}
