package com.khaikin.airline.post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer id;

    private String type; // news, discount etc.
    private String title;
    private String content;

    private String imageName;
    private String imageType;

    @Lob
    private byte[] imageData;

    private LocalDateTime postedTime;

    public Post(String type, String title, String content, String imageName, String imageType, byte[] imageData) {
        this.type = type;
        this.title = title;
        this.content = content;
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageData = imageData;
    }
}
