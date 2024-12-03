package com.khaikin.airline.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
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
}
