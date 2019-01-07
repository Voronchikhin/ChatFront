package ru.neofr.demo;

import org.apache.cxf.headers.Header;
import org.springframework.stereotype.Component;
import ru.neofr.demo.entity.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ChatServer {
    @GET
    @Path("/messages")
    MessageReply getMessages(@QueryParam("offset") int offset, @QueryParam("count") int count, @HeaderParam("Authorization") String token);

    @POST
    @Path("/login")
    LoginReply login(LoginRequest loginRequest);

    @POST
    @Path("/messages")
    PostMessageReply postMessage(PostMessage message, @HeaderParam("Authorization") String token);
}
