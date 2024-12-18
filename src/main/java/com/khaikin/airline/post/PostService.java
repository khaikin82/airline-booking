package com.khaikin.airline.post;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PostService {
    public List<Post> getAllPosts();

    public Post getPostById(Integer id);

    public List<Post> getPostsByType(String type);

    public Post createPost(Post post);

    public Post createPost(Post post, MultipartFile imageFile)
            throws IOException;

    public Post updatePost(Integer id, Post updatePost, MultipartFile updateImageFile)
            throws IOException;

    public void deletePostById(Integer id);
}
