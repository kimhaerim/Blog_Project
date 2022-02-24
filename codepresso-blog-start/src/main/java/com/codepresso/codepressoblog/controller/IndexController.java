package com.codepresso.codepressoblog.controller;


import com.codepresso.codepressoblog.Service.PostService;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    private PostService postService;
    public IndexController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/")
    public String index(Model model) {
        List<Post> posts = new ArrayList<>();
        posts = postService.getPostList();
        model.addAttribute("posts", posts);
        return "index";
    }
}
