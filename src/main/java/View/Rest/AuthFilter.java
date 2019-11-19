package View.Rest;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

    //This class is automatically called along CORS filter when the rest api is called
    @Provider
    @Priority(1000)
    public class AuthFilter implements ContainerRequestFilter {

        @Override
        public void filter(ContainerRequestContext containerRequestContext) throws IOException {
            System.out.println(containerRequestContext.getUriInfo().getPath());
            if (!"login".equals(containerRequestContext.getUriInfo().getPath())) {
                System.out.println(containerRequestContext.getHeaderString("Authorization"));
                //Authorize the request!
            }
        }
    }

