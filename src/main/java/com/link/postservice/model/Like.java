package com.link.postservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.link.postservice.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "likes")
@Data
@AllArgsConstructor
public class Like {
    @Id
    @Column(name = "like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;

    //Why no foreign key constraint??
    //Because no guarantee that a user that likes a post
    //will have created a post beforehand for the foreign key constraint
    //to be consistent
    @Column(name = "user_id", nullable = false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "post_FK")
    @JsonBackReference("postLikes")
    private Post post;

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}