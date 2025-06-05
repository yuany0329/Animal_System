//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bnu.mapper;

import com.bnu.pojo.Post;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PostMapper {
    List<Post> findAll();

    void insert(Post post);

    @Select({"SELECT p.*, u.id as user_id, u.username, u.headpic FROM post p LEFT JOIN user u ON p.createId = u.id"})
    @Results({@Result(
            property = "id",
            column = "id"
    ), @Result(
            property = "title",
            column = "title"
    ), @Result(
            property = "description",
            column = "description"
    ), @Result(
            property = "createId",
            column = "createId"
    ), @Result(
            property = "commentCount",
            column = "commentCount"
    ), @Result(
            property = "viewCount",
            column = "viewCount"
    ), @Result(
            property = "likeCount",
            column = "likeCount"
    ), @Result(
            property = "tag",
            column = "tag"
    ), @Result(
            property = "createTime",
            column = "createTime"
    ), @Result(
            property = "user.id",
            column = "user_id"
    ), @Result(
            property = "user.username",
            column = "username"
    ), @Result(
            property = "user.headpic",
            column = "headpic"
    )})
    List<Post> findAllWithUser();
}
