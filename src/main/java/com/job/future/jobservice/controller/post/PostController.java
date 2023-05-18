package com.job.future.jobservice.controller.post;

import com.job.future.jobservice.api.request.postcontent.PostPostContentApiRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
    @PostMapping("/post-content")
    public ResponseEntity<PostPostContentApiRequest> index() {

        return null;
    }

}
