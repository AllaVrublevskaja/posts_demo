package ru.top.posts_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.top.posts_demo.entity.dto.request.PostRequest;
import ru.top.posts_demo.entity.dto.response.PostResponse;
import ru.top.posts_demo.service.PostService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public PostResponse findById(@PathVariable(value = "id") UUID postId) {
        return postService.findById(postId);
    }

    @GetMapping("/user/{id}")
    public List<PostResponse> userPosts(@PathVariable(value = "id") UUID userId) {
        return postService.allUserPosts(userId);
    }

    @PostMapping
    public PostResponse createPost(@RequestBody PostRequest dto) {
        return postService.save(dto);
    }

    @PutMapping("/{id}")
    public PostResponse updatePost(@PathVariable(value = "id") UUID postId,
                                   @RequestBody PostRequest dto) {
        return postService.update(postId, dto);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable(value = "id") UUID postId) {
        postService.delete(postId);
        return String.format("Post with id: %s has been successfully deleted", postId);
    }
}
