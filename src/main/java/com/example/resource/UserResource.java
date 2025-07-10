package com.example.resource;

import com.example.core.User;
import com.example.db.UserDAO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") int id) {
        User user = userDAO.findById(id);
        if (user == null) {
            throw new NotFoundException("User not found with id: " + id);
        }
        return user;
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUserById(@PathParam("id") int id) {
        int rows = userDAO.deleteById(id);
        if (rows == 0) {
            throw new NotFoundException("No user with id: " + id);
        }
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public User updateUser(@PathParam("id") int id,  User updatedUser) {
        int rows = userDAO.updateById(id, updatedUser);
        if (rows == 0) {
            throw new NotFoundException("No user with id: " + id);
        }
        return userDAO.findById(id);
    }
}
