package com.example.mdb.dao;

import com.example.mdb.model.*;
import java.util.Collection;

public interface CommentDao extends AbstractDao<Comment> {

    Collection<Comment> findByMovieId(Integer moveId);

    void addComment(Movie movie, User user, String text);
}
