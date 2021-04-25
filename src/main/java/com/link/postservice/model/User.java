package com.link.postservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="posts_users")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "user_conn")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_conn_id;

    @Column(name = "user_id",nullable = false)
    private int user_id;

    @Column(name = "post_id",nullable = false)
    private int post_id;

    public User(int user_id,int post_id){
        this.user_id=user_id;
        this.post_id = post_id;
    }



}
