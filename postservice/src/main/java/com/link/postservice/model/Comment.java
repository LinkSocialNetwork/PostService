package com.link.postservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="post_comments")
@Data
@AllArgsConstructor
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Column(name = "comment_content")
    private String commentContent;
    @Column(name = "commented_at")
    private String commentedAt;


    @Column(name = "user_id", nullable = false)
    private int commentWriter;

    @ManyToOne
    @JsonBackReference("postComments")
    @JoinColumn(name = "post_id")
    private Post commentPost;

}