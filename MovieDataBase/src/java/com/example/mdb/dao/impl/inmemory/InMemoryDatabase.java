package com.example.mdb.dao.impl.inmemory;

import com.example.mdb.dao.DaoFactory;
import com.example.mdb.model.*;
import java.util.*;

public class InMemoryDatabase {

    Map<Integer, Movie> movies;
    Map<Integer, Comment> comments;
    Map<Integer, User> users;

    public InMemoryDatabase() {
        movies = new TreeMap<>();
        comments = new TreeMap<>();
        users = new TreeMap<>();
    }

    public DaoFactory getDaoFactory() {
        return new InMemoryDaoFactory(this);
    }

}
