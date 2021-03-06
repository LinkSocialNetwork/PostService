package com.link.postservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "likes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Like {
    @Id
    @Column(name = "like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;

    //Why no foreign key constraint??
    //Because no guarantee that a user that likes a post
    //will have created a post beforehand for the foreign key constraint
    //to be consistent
    @ManyToOne(cascade =CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_FK")
    @JsonBackReference("postLikes")
    private Post post;

}