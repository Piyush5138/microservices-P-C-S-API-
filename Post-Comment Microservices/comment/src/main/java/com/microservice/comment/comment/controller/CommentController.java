package com.microservice.comment.comment.controller;


import com.microservice.comment.comment.entity.Comment;
import com.microservice.comment.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    //http://localhost:8080/api/comments
    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){
        Comment c =commentService.saveComment(comment);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("{postId}")
    public List<Comment> getAllCommentsByPostId(@PathVariable String postId){
        List<Comment> comments = commentService.getAllCommentsByPostId(postId);
        return comments;
        //http://localhost:8082/api/comments/9b58f4f4-a22c-473c-a5bc-d13ae8f8b0cd
    }
}
