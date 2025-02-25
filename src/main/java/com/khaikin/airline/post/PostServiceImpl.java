package com.khaikin.airline.post;

import com.khaikin.airline.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    private final String uploadDir = "uploads/";

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
        String imageName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
        String imageType = imageFile.getContentType();

        Path path = Paths.get(uploadDir + imageName);
        Files.createDirectories(path.getParent());  // Tạo thư mục nếu chưa tồn tại
        imageFile.transferTo(path.toFile());

        post.setImageName(imageName);
        post.setImageType(imageType);
        post.setImagePath(path.toString());
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

            String imageName = System.currentTimeMillis() + "_" + updateImageFile.getOriginalFilename();
            String imageType = updateImageFile.getContentType();
            Path path = Paths.get(Paths.get(uploadDir).toAbsolutePath() + "/" + imageName);
            Files.createDirectories(path.getParent());  // Tạo thư mục nếu chưa tồn tại
            updateImageFile.transferTo(path.toFile());

            post.setImageName(imageName);
            post.setImageType(imageType);
            post.setImagePath(path.toString());

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
