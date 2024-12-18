package com.khaikin.airline.post;

import com.khaikin.airline.exception.ConflictException;
import com.khaikin.airline.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<byte[]> getImageByPostId(@PathVariable int id) {
        Post post = postService.getPostById(id);
        byte[] imageFile = post.getImageData();

        return ResponseEntity.ok().contentType(MediaType.valueOf(post.getImageType())).body(imageFile);
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
