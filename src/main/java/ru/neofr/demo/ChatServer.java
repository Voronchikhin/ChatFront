package ru.neofr.demo;

import org.springframework.stereotype.Component;
import ru.neofr.demo.entity.LoginReply;
import ru.neofr.demo.entity.LoginRequest;
import ru.neofr.demo.entity.MessageReply;
import ru.neofr.demo.entity.PostMessage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
