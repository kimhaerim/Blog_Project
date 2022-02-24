package com.codepresso.codepressoblog.mapper;

import com.codepresso.codepressoblog.vo.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> findAll();
}
