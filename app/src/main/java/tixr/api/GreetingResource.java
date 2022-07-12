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
    public String greet(@PathParam("name") String name) {
        return String.format(this.template, name);
    }

    @GET()
    @Path("/reverse/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String greetBackwards(@PathParam("name") String name) {
        var msg = String.format(this.template, name);
        var sb = new StringBuilder();
        for(int i=msg.length()-1; i>=0; i--) {
            sb.append(msg.charAt(i));
        }
        return sb.toString();
    }
}