package com.job.future.jobservice.controller.post;

import com.job.future.jobservice.api.request.postcontent.PostPostContentApiRequest;
import com.job.future.jobservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/post-content")
    public ResponseEntity<PostPostContentApiRequest> index(PostPostContentApiRequest postPostContentApiRequest) {
        postService.save(postPostContentApiRequest);
        return null;
    }

}
