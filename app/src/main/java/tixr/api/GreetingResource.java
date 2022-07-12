package tixr.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private final String template;

    public GreetingResource(final String template) {
        this.template = template;
    }

    @GET()
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("name") String name) {
        return String.format(this.template, name);
    }
}