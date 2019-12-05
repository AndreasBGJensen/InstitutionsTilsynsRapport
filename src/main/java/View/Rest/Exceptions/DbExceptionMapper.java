package View.Rest.Exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class DbExceptionMapper implements ExceptionMapper<DbException> {
    @Override
    public Response toResponse(DbException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
}
