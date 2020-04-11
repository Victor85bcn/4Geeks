package com.example.newspaper.service;

import com.example.newspaper.model.Post;

import java.util.List;

public interface PostService {

    public List<Post> validationId(List<Post> posts);
    public boolean saveNewPost(Post post);
    public Post getPostById(int id);
    public List<Post> getAllPosts();
    public boolean update(Post object);
    public boolean deleteByPostId(int id);
    public List<Post> findAll();

}
