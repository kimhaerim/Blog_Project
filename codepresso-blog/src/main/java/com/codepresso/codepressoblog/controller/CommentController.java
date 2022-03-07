package com.codepresso.codepressoblog.controller;

import com.codepresso.codepressoblog.controller.dto.CommentRequestDto;
import com.codepresso.codepressoblog.controller.dto.CommentResponseDto;
import com.codepresso.codepressoblog.controller.dto.PostRequestDto;
import com.codepresso.codepressoblog.service.CommentService;
import com.codepresso.codepressoblog.service.PostService;
import com.codepresso.codepressoblog.vo.Comment;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {
    private CommentService commentService;
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/comment")
    public List<CommentResponseDto> getComment(@RequestParam("post_id") Integer post_id, @RequestParam Integer page){
        List<Comment> comments = commentService.getCommentList(post_id, 3, page);
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
        for(Comment comment : comments)
            commentResponseDtos.add(new CommentResponseDto(comment));

        return commentResponseDtos;
    }

    @PostMapping("/comment")
    public String createComment(@RequestBody CommentRequestDto commentDto) {
        Comment comment = commentDto.getComment();
        commentService.saveComment(comment);

        return "success";
    }

    @PutMapping("/comment")
    public String updateComment(@RequestBody CommentRequestDto commentDto){
        return null;
    }
}
