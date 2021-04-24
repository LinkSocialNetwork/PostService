package com.link.postservice.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="posts")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @Column(name="post_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int postId;

    @Column(name="user_id", nullable = false)
    private int userId;

    @Column(name="post_content")
    private String postContent;

    @Column(name="post_image_link")
    private String postImageUrl;

    @Column (name="youtube_link")
    private String youtubeUrl;


    //????
    @Column(name="posted_at")
    private String postedAt;

    @OneToMany(mappedBy="post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("postLikes")
    private List<Like> usersWhoLiked = new ArrayList<>();

    @OneToMany(mappedBy = "commentPost",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("postComments")
    private List<Comment> comments = new ArrayList<>();



}
