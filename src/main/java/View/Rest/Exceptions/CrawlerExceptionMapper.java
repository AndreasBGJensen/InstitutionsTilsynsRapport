package View.Rest.Exceptions;



import Controller.Download.ErrorDownloadPDFException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Christian on 15-05-2017.
 */
@Provider
public class CrawlerExceptionMapper implements ExceptionMapper<ErrorDownloadPDFException> {
    @Override
    public Response toResponse(ErrorDownloadPDFException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity("Could not download: " + exception.getMessage())
                .build();

    }
}