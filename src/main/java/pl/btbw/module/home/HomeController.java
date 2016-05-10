package pl.btbw.module.home;

import pl.btbw.core.thymeleaf.HtmlResponse;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class HomeController {

    @Inject
    private HomeService homeService;

    @Path("/")
    @GET
    public HtmlResponse home() {
        return new HtmlResponse("home.html")
                .add("message", homeService.getMessage(false));
    }

    @Path("/exception-test")
    @GET
    public HtmlResponse exceptionTest() {
        return new HtmlResponse("home.html")
                .add("message", homeService.getMessage(true));
    }
}
