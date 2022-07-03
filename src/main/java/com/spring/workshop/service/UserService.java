package com.spring.workshop.service;

import com.spring.workshop.domain.User;
import com.spring.workshop.repository.UserRepository;
import com.spring.workshop.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        User user = repository.findById(id).orElse(null);
        if(user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }
}
