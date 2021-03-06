package com.link.postservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name="posts_users")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private int userID;

    @Column(name= "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name= "profile_img_url", unique = false)
    private String profileImg;

    @ColumnDefault("0")
    @Column(name= "check_password")
    private int checkPassword;


}
