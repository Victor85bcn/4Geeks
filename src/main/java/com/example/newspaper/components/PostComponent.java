package com.example.newspaper.components;

import com.example.newspaper.model.Post;
import com.example.newspaper.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("postComponent")
public class PostComponent {


    @Autowired
    PostRepository postRepository;


    public Post getPostById(int id) {
        Post post = postRepository.findById(id);
        return post;
    }

    public List<Post> getAllPosts() {
        SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
        List<Post> posts = postRepository.findAll(pageable);
        return posts;
    }

}
