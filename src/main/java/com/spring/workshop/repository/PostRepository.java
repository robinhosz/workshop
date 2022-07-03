package com.spring.workshop.repository;

import com.spring.workshop.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
//?0 é para pegar o primeiro parametro do metodo ou seja pega o text
    //o options passando o 'i' ele vai ignorar maisculas e minusculas
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);
    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ $and: [ {date: { $gte: ?1} }, { date: { $lte: ?2 } } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] }\n" +
            "\n ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
