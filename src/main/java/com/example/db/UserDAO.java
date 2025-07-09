package com.example.db;

import com.example.core.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;

import java.util.List;

public interface UserDAO {

    @SqlUpdate("INSERT INTO users (name, email) VALUES (:name, :email)")
    @GetGeneratedKeys
    long insertAndReturnId(@BindBean User user);

    @SqlQuery("SELECT * FROM users WHERE id = :id")
    @RegisterBeanMapper(User.class)
    User findById(@Bind("id") long id);

    @SqlQuery("SELECT * FROM users")
    @RegisterBeanMapper(User.class)
    List<User> findAll();
}
