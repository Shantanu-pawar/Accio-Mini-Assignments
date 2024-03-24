package com.example.SocialApp.repository;

import com.example.SocialApp.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo  extends JpaRepository<Post, Integer> {

    @Query(value = "select * from post where likes = (select max(likes) from post)", nativeQuery = true)
    public Post findMaxLikePost();
}
