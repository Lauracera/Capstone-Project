package com.example.Capstone.Project.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/posts")
public class PostCTRL {
    @Autowired
    private PostSRV postSRV;

    @GetMapping
    public Page<Post> getAll(@RequestParam(defaultValue = "0")int page,
                             @RequestParam(defaultValue = "10")int size,
                             @RequestParam(defaultValue = "id")String orderBy
                             ){
        return this.postSRV.getAll(page, size, orderBy);
    }



    @GetMapping("/{id}")
    public Post findById(@PathVariable UUID id) {
        return this.postSRV.findById(id);
    }

}
