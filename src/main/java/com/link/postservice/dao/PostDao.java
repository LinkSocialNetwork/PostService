package com.link.postservice.dao;

import com.link.postservice.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

@Repository("postDao")
public interface PostDao extends JpaRepository<Post, Integer>{

    /** Authored by Sam Jenkins
     *
     */
    public Page<Post> findAllByUserUserIDOrderByPostIdDesc(int userId, Pageable pageable);

    public Post findByPostId(int id);

    /** Author: Michael Loutfi
     * CRUD method (READ) - Uses hibernate to access Posts table from database and grabs all
     * existing posts and maps it to a Java array list of Post objects.
     * @return Array list of Post objects.
     */
    //public List<Post> findAll();

    //pagination
    @Override
    public Page<Post> findAll(Pageable pageable);
    public Page<Post> findByUserUserIDInOrderByPostIdDesc(ArrayList<Integer> followingUserIDs, Pageable aPageableObject);


}
