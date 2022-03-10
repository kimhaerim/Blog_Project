package com.codepresso.codepressoblog.service;

import com.codepresso.codepressoblog.mapper.CommentMapper;
import com.codepresso.codepressoblog.vo.Comment;
import com.codepresso.codepressoblog.vo.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper){
        this.commentMapper = commentMapper;
    }

    public List<Comment> getCommentListByPostIdAndPage(Integer postId, Integer page, Integer size){
        return commentMapper.findByPostIdAndPage(postId, size, (page-1) * size);
    }

    public boolean saveComment(Comment comment){
        Integer result = commentMapper.save(comment);
        return result == 1;
    }

    public boolean updateComment(Comment comment){
        Integer result = commentMapper.update(comment);
        return result == 1;
    }

    public boolean deleteComment(Integer id){
        Integer result = commentMapper.delete(id);
        return result == 1;
    }
}
