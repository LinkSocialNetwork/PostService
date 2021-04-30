package com.link.postservice.dao;

import com.link.postservice.model.Post;
import com.link.postservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository("postDao")
public interface PostDao extends JpaRepository<Post, Integer>{

    /** Authored by Sam Jenkins
     *
     */
    public List<Post> findAllByUserUserID(int userId);

    public Post findById(int id);

    /** Author: Michael Loutfi
     * CRUD method (READ) - Uses hibernate to access Posts table from database and grabs all
     * existing posts and maps it to a Java array list of Post objects.
     * @return Array list of Post objects.
     */
    //public List<Post> findAll();

    //pagination
    @Override
    public Page<Post> findAll(Pageable pageable);
    public Page<Post> findByUserUserIDIn(ArrayList<Integer> followingUserIDs, Pageable aPageableObject);


}
