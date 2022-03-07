package com.codepresso.codepressoblog.controller;

import com.codepresso.codepressoblog.service.CommentService;
import com.codepresso.codepressoblog.service.PostService;
import com.codepresso.codepressoblog.vo.Comment;
import com.codepresso.codepressoblog.vo.Post;
import lombok.AllArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class PostPageController {
    private PostService postService;
    private CommentService commentService;

//    //public PostPageController(PostService postService){
//        this.postService = postService;
//    }

    @RequestMapping("/post/{id}")
    public String getPostDetailPage(Model model, @PathVariable Integer id){
        Post post = postService.getPostById(id);
        List<Comment> comments = commentService.getCommentList(id, 3, 1);

        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "post_detail";
    }

    @RequestMapping("/post/create")
    public String getCreatePage(){
        return "post_write";
    }

    @RequestMapping("/post/edit/{id}")
    public String getPostCreatePage(Model model, @PathVariable Integer id){
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post_edit";
    }
}