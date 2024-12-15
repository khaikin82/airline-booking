package com.khaikin.airline.post;

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

    @PostMapping
    public ResponseEntity<?> createPost(@RequestPart Post post, @RequestPart MultipartFile imageFile) {
        try {
            Post newPost = postService.createPost(post, imageFile);
            return new ResponseEntity<>(newPost, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping
//    public ResponseEntity<Post> createPost(@RequestBody Post post) {
//        Post newPost = postService.createPost(post);
//        return ResponseEntity.ok(newPost);
//    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Integer id) {
        postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }

}
