package com.example.Capstone.Project.posts;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/posts")
public class PostCTRL {
    @Autowired
    private PostSRV postSRV;
    @Autowired
    private PostDAO postDAO;

    @GetMapping
    public Page<Post> getAll(@RequestParam(defaultValue = "0")int page,
                             @RequestParam(defaultValue = "10")int size,
                             @RequestParam(defaultValue = "id")String orderBy
                             ){
        return this.postSRV.getAll(page, size, orderBy);
    }


    //@PostMapping
    //public Post savePost(@RequestBody @Validated PostDTO postDTO, BindingResult validation)throws IOException {
     //   if (validation.hasErrors()) {
     //       throw new BadRequestException(String.valueOf(validation.getAllErrors()));
    //    }
       // return PostSRV.save(postDTO);
    //}

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody @Validated PostDTO postDTO, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException();
        }
        Post createdPost = postSRV.save(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }


   /* @PutMapping("/{title}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Post updatePost(@PathVariable String title, @RequestBody PostDTO postDTO){
        System.out.println("Title: " + title);
        return postSRV.updatePost(String.valueOf(title),postDTO);

    }*/

    @PutMapping("/{title}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public Post updatePost(@PathVariable String title, @RequestBody PostDTO postDTO) {
     return postSRV.updatePost(title, postDTO);
    }

    /*@DeleteMapping("/{title}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void deletePost(@PathVariable String title){
        postSRV.deletePost(String.valueOf(title));
    }*/

}
