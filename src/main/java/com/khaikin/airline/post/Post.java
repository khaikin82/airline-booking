package com.khaikin.airline.post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private String imagePath; // Đường dẫn tới ảnh lưu trong thư mục

    private LocalDateTime postedTime;

    public Post(String type, String title, String content, String imageName, String imageType, String imagePath) {
        this.type = type;
        this.title = title;
        this.content = content;
        this.imageName = imageName;
        this.imageType = imageType;
        this.imagePath = imagePath;
    }
}
