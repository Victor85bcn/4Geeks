package com.example.newspaper.service.impl;

import com.example.newspaper.model.Post;
import com.example.newspaper.repository.PostRepository;
import com.example.newspaper.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> validationId(List<Post> posts) {
        for (Post post : posts){
            if (post.getIdPost() == 0) {
                throw new NullPointerException("El post no tiene ID asignado.");
            }
        }
        return posts;
    }

    @Override
    public boolean saveNewPost(Post post) {
        return postRepository.save(post);
    }
}
