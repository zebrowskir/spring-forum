package com.rzeb.forum.service;

import org.springframework.data.domain.Page;

import com.rzeb.forum.model.Post;
import com.rzeb.forum.model.User;

import java.util.Optional;

public interface PostService {

    Optional<Post> findForId(Long id);

    Post save(Post post);
 
    Page<Post> findByUserOrderedByDatePageable(User user, int page);

    Page<Post> findAllOrderedByDatePageable(int page);

    void delete(Post post);
}
