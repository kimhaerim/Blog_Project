package com.codepresso.codepressoblog.controller;

import com.codepresso.codepressoblog.controller.dto.PostRequestDto;
import com.codepresso.codepressoblog.controller.dto.PostResponseDto;
import com.codepresso.codepressoblog.service.PostService;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public List<PostResponseDto> getPostList(@RequestParam(name="page") Integer page) {
        List<Post> posts = postService.getFindByPage(page, 3);

        List<PostResponseDto> PostResponseDtoList = new ArrayList<>();
        for (Post post : posts) {
            PostResponseDtoList.add(new PostResponseDto(post));
        }
        return PostResponseDtoList;
    }

    @PostMapping("/post")
    public String createPost(@RequestBody PostRequestDto postDto) {
        Post post = postDto.getPost();
        postService.savePost(post);

        return "success";
    }

    @PutMapping("/post")
    public String updatePost(@RequestBody PostRequestDto postDto) {
        Post post = postDto.getPost();
        postService.updatePost(post);

        return "success";
    }

    @DeleteMapping(value = "/post")
    public String deletePost(@RequestParam Integer id){
        postService.deletePost(id);

        return "success";
    }
}
