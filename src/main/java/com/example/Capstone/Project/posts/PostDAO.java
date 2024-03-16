package com.example.Capstone.Project.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostDAO extends JpaRepository<Post, UUID> {
    List<Post> findAll();
    Optional<Post> findById(UUID id);
}
