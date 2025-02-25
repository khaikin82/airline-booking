package com.khaikin.airline.post;

import com.khaikin.airline.exception.ConflictException;
import com.khaikin.airline.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Integer id) {
        return postService.getPostById(id);
    }

    @GetMapping("/types/{typeName}")
    public List<Post> getPostsByType(@PathVariable String typeName) {
        return postService.getPostsByType(typeName);
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<Resource> getImageByPostId(@PathVariable int id) {
        try {
            Post post = postService.getPostById(id);
            String imagePath = post.getImagePath();
            Path filePath = Paths.get(imagePath);
            Resource resource = new FileSystemResource(filePath);

            // Kiểm tra xem tệp có tồn tại không
            if (resource.exists()) {
                String contentType = Files.probeContentType(filePath);
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(contentType != null ? contentType : "image/jpeg"))
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestPart Post post, @RequestPart MultipartFile imageFile) {
        try {
            Post newPost = postService.createPost(post, imageFile);
            return new ResponseEntity<>(newPost, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ConflictException("Conflict Error: Create Post ");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestPart Post post,
                                           @RequestPart MultipartFile imageFile) {
        try {
            Post newPost = postService.updatePost(id, post, imageFile);
            return new ResponseEntity<>(newPost, HttpStatus.CREATED);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        } catch (Exception e) {
            throw new ConflictException("Conflict Error: Update post");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Integer id) {
        postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }

}
