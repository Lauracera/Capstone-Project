package com.example.Capstone.Project.posts;

import com.example.Capstone.Project.enums.Role;
import com.example.Capstone.Project.exceptions.UnauthorizedException;
import com.example.Capstone.Project.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;


@Service
public class PostSRV {
    @Autowired
    private PostDAO postDAO;



    public void createPost(PostDTO postDTO, User currentUser) {
        if (!currentUser.getRoles().equals(Role.ADMIN)) {
            throw new UnauthorizedException("Solo gli amministratori possono creare nuovi post");
        }
    }


    public Post save(PostDTO postDTO) throws IOException {
        //if(postDAO.findByTitle(postDTO.title())) throw new BadRequestException("Post già esistente.");

        Post post = new Post(postDTO.title(), postDTO.bodyText(), postDTO.image());
        return postDAO.save(post);
    }

    public Page<Post> getAll(int pageNumber, int size, String orderBy){
        if(size > 100)size = 100;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return postDAO.findAll(pageable);
    }

    /*public Post updatePost(String title,PostDTO postDTO){
        Post found = this.updatePost(title,postDTO);
        found.setTitle(postDTO.title());
        found.setBodyText(postDTO.bodyText());
        return postDAO.save(found);
    }*/

    public Post updatePost(String title, PostDTO postDTO) {

        Optional<Post> postOptional = postDAO.findByTitle(title);

        if (postOptional.isPresent()) {
            Post found = postOptional.get();

            found.setTitle(postDTO.title());
            found.setBodyText(postDTO.bodyText());
            found.setBodyText(postDTO.image());

            return postDAO.save(found);
        } else {
            return null;
        }
    }

    public Post deletePost(String title){
        Post found = this.deletePost(title);
        postDAO.delete(found);
        return found;
    }
}
