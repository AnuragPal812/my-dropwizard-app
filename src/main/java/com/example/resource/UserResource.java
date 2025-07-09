package com.example.resources;

import com.example.core.User;
import com.example.db.UserDAO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserDAO userDAO;

    public UserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @POST
    public User createUser(User user) {
        long id = userDAO.insertAndReturnId(user);
        return userDAO.findById(id);
    }

    @GET
    public List<User> getUsers() {
        return userDAO.findAll();
    }
}
