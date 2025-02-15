package com.microservice.post.post.controller;

import com.microservice.post.post.entity.Post;

import com.microservice.post.post.payload.PostDto;
import com.microservice.post.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/posts")
@RestController

public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post post){
        Post newPost = postService.savePost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }
// http://localhost:8081/api/posts
    @GetMapping("/{postId}")
    public Post getPostByPostId(@PathVariable String postId){
        Post post = postService.findPostById(postId);
         return post;
    }

    // http://localhost:8081/api/posts/{postid}comments
    @GetMapping("{postId}/comments")
    public ResponseEntity<PostDto> getPostWithComment(@PathVariable String postId){
        PostDto postDto=postService.getPostWithComments(postId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

}
