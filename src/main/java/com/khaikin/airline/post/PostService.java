package com.khaikin.airline.post;

import java.util.List;

public interface PostService {
    public List<Post> getAllPosts();

    public List<Post> getPostsByType(String type);

    public Post createPost(Post post);
}
