package com.spring.workshop.service;

import com.spring.workshop.domain.Post;
import com.spring.workshop.repository.PostRepository;
import com.spring.workshop.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {


    @Autowired
    private PostRepository repository;


    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }


}