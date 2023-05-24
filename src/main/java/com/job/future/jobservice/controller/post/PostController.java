package com.job.future.jobservice.controller.post;

import com.job.future.jobservice.api.request.postcontent.GetPostContentByTitleApiRequest;
import com.job.future.jobservice.api.request.postcontent.PostPostContentApiRequest;
import com.job.future.jobservice.api.response.postcontent.GetPostContentByTitleResponse;
import com.job.future.jobservice.dto.postcontent.GetPostContentDTO;
import com.job.future.jobservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/post-content")
    public void index(@RequestBody PostPostContentApiRequest postPostContentApiRequest) {
        postService.save(postPostContentApiRequest);
    }

    @GetMapping("/search-by-title")
    public ResponseEntity<List<GetPostContentDTO>> searchByTitle(@RequestParam("title") String title) {
        List<GetPostContentDTO> listPostContent = postService.findPostByTitle(title);
        return ResponseEntity.ok(listPostContent);
    }

}
