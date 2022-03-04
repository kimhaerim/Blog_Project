package com.codepresso.codepressoblog.service;

import com.codepresso.codepressoblog.mapper.CommentMapper;
import com.codepresso.codepressoblog.vo.Comment;
import com.codepresso.codepressoblog.vo.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentMapper commentMapper;
    public CommentService(CommentMapper commentMapper){
        this.commentMapper = commentMapper;
    }
    public List<Comment> getCommentList(Integer post_id, Integer size, Integer page){
        return commentMapper.findByPostIdAndPage(post_id, size, (page-1) * size);
    }
    public boolean saveComment(Comment comment){
        Integer result = commentMapper.save(comment);
        return result == 1;
    }
}
