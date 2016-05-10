package pl.btbw.core;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

    @Override
    public Response toResponse(BusinessException ex) {

        return Response
                .status(ex.getCode())
                .header("Content-Type","application/json")
                .header("cause", ex.toString())
                .header("message", ex.getMessage())
                .entity(new ExceptionResponse(ex.getMessage(), ex.getCode()))
                .build();
    }

    class ExceptionResponse {
        public String message;
        public int code;

        public ExceptionResponse(String message, int code) {
            this.message = message;
            this.code = code;
        }
    }

}
