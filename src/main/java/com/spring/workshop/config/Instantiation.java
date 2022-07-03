package com.spring.workshop.config;

import com.spring.workshop.domain.Post;
import com.spring.workshop.domain.User;
import com.spring.workshop.dto.AuthorDTO;
import com.spring.workshop.repository.PostRepository;
import com.spring.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        repository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        repository.saveAll(Arrays.asList(maria, alex, bob));

        
        Post post1 = new Post(null, sdf.parse("03/07/2022"), "Partiu viagem", "Valeu galera partiu!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("03/07/2022"), "Bom dia!", "Acordei feliz!", new AuthorDTO(maria));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
