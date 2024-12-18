package com.khaikin.airline.post;

import com.khaikin.airline.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Integer id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            return postOptional.get();
        } else {
            throw new ResourceNotFoundException("Post not found!");
        }
    }

    @Override
    public List<Post> getPostsByType(String type) {
        return postRepository.findByType(type);
    }

    @Override
    public Post createPost(Post post) {
        post.setPostedTime(LocalDateTime.now());
        return postRepository.save(post);
    }

    @Override
    public Post createPost(Post post, MultipartFile imageFile)
            throws IOException {
        post.setImageName(imageFile.getOriginalFilename());
        post.setImageType(imageFile.getContentType());
        post.setImageData(imageFile.getBytes());
        post.setPostedTime(LocalDateTime.now());
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Integer id, Post updatePost, MultipartFile updateImageFile)
            throws IOException {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setType(updatePost.getType());
            post.setTitle(updatePost.getTitle());
            post.setContent(updatePost.getContent());

            post.setImageName(updateImageFile.getOriginalFilename());
            post.setImageType(updateImageFile.getContentType());
            post.setImageData(updateImageFile.getBytes());
            return postRepository.save(post);
        } else {
            throw new ResourceNotFoundException("Post not found!");
        }
    }

    @Override
    public void deletePostById(Integer id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isPresent()) {
            postRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Post not found!");
        }
    }

}
