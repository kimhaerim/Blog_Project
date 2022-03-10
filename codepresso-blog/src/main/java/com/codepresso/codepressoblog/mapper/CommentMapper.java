package com.codepresso.codepressoblog.mapper;

import com.codepresso.codepressoblog.vo.Comment;
import com.codepresso.codepressoblog.vo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> findByPostIdAndPage(@Param("postId") Integer postId, @Param("limit") Integer limit, @Param("offset") Integer offset);
    Integer save(@Param("comment") Comment comment);
    Integer update(@Param("comment") Comment comment);
    Integer delete(@Param("id") Integer id);
}
