package com.example.Capstone.Project.posts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;
    private String title;
    private String bodyText;

    public Post(String title, String bodyText) {
        this.title = title;
        this.bodyText = bodyText;
    }
}
