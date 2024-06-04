package com.example.mdb.dao;

import com.example.mdb.model.*;
import java.util.Collection;

public interface MovieDao extends AbstractDao<Movie> {

    void like(Movie movie, User user);

    void unlike(Movie movie, User user);

    Collection<Movie> findByText(String text);
}
