package com.rzeb.forum.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.rzeb.forum.model.Post;
import com.rzeb.forum.model.User;
import com.rzeb.forum.service.PostService;
import com.rzeb.forum.service.UserService;
import com.rzeb.forum.util.Pager;

@Controller
public class ForumController {

    private final UserService userService;
    private final PostService postService;

    @Autowired
    public ForumController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/blog/{username}")
    public String postsForUsername(@PathVariable String username,
                                   @RequestParam(defaultValue = "0") int page,
                                   Model model) {

        Optional<User> optionalUser = userService.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Page<Post> posts = postService.findByUserOrderedByDatePageable(user, page);
            Pager pager = new Pager(posts);

            model.addAttribute("pager", pager);
            model.addAttribute("user", user);

            return "/posts";
        } 
        else {
            return "/error";
        }
    }
}
