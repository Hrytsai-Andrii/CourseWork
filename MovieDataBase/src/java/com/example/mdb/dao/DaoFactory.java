package com.example.mdb.dao;

public interface DaoFactory {

    CommentDao getCommentDao();

    MovieDao getMovieDao();

    UserDao getUserDao();
}
