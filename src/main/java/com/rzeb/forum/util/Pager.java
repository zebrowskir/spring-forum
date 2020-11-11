package com.rzeb.forum.util;

import org.springframework.data.domain.Page;

import com.rzeb.forum.model.Post;

public class Pager {

    private final Page<Post> posts;

    public Pager(Page<Post> posts) {
        this.posts = posts;
    }

    public int getPageIndex() {
        return posts.getNumber() + 1;
    }

    public int getPageSize() {
        return posts.getSize();
    }

    public boolean hasNext() {
        return posts.hasNext();
    }

    public boolean hasPrevious() {
        return posts.hasPrevious();
    }

    public int getTotalPages() {
        return posts.getTotalPages();
    }

    public long getTotalElements() {
        return posts.getTotalElements();
    }

    public Page<Post> getPosts() {
        return posts;
    }

    public boolean indexOutOfBounds() {
        return getPageIndex() < 0 || getPageIndex() > getTotalElements();
    }

}
