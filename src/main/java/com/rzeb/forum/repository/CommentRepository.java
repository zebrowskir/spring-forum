package com.rzeb.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rzeb.forum.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
