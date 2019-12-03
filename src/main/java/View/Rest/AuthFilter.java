package View.Rest;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

    //This class is automatically called along CORS filter when the rest api is called

/*
Ligesom med CORS-filteret er de muligt at filtrere requests før de overhovedet rammer et endpoint.
I stedet for at skrive JWTHandler.validate(token) på alle services, kan du istedet fange requests'ne og validere dem alle.
 Husk at login-services IKKE skal valideres..
 */
    @Provider
    @Priority(1000)
    public class AuthFilter implements ContainerRequestFilter {

        @Override
        public void filter(ContainerRequestContext containerRequestContext) throws IOException {
            //JWTHandler.validate(containerRequestContext.getHeaderString("Authorization"));

            System.out.println("before: "+containerRequestContext.getUriInfo().getPath());
            if (!"campusnet/login".equals(containerRequestContext.getUriInfo().getPath())) {
                if(!"campusnet/redirect".equals(containerRequestContext.getUriInfo().getPath())) {
                    System.out.println("the header(was not correct): " + containerRequestContext.getHeaderString("Authorization"));
                    //todo: fix the validate
                    JWTHandler.validate(containerRequestContext.getHeaderString("Authorization"));
                }
            }
        }
    }

