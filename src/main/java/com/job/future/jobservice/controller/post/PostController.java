package com.job.future.jobservice.controller.post;

import com.job.future.jobservice.api.request.postcontent.PostPostContentApiRequest;
import com.job.future.jobservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/post-content")
public class PostController {

    private final PostService postService;

    @PostMapping("/save")
    public void  save(@RequestBody  PostPostContentApiRequest request, Authentication authentication){
        postService.saveOrUpdate(request, authentication);
    }

}
