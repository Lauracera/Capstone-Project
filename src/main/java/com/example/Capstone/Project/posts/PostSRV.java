package com.example.Capstone.Project.posts;

import com.example.Capstone.Project.enums.Role;
import com.example.Capstone.Project.exceptions.NotFoundException;
import com.example.Capstone.Project.exceptions.UnauthorizedException;
import com.example.Capstone.Project.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostSRV {
    @Autowired
    private PostDAO postDAO;

    public void createPost(PostDTO postDTO, User currentUser) {
        if (!currentUser.getRoles().contains(Role.ADMIN)) {
            throw new UnauthorizedException("Solo gli amministratori possono creare nuovi post");
        }
    }

    public Page<Post> getAll(int pageNumber, int size, String orderBy){
        if(size > 100)size = 100;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return postDAO.findAll(pageable);
    }

    /*public Post save(PostDTO invoiceDTO) {
        Post post= postSRV.findById(postDTO.title());
        return postDAO.save(new Post());
    }*/

    public Post findById(UUID postId){
        return postDAO.findById(postId).orElseThrow(()->new NotFoundException(postId));
    }



    public void createAndSaveNewPost() {
        Post newPost = new Post();
        postDAO.save(newPost);
    }
}
