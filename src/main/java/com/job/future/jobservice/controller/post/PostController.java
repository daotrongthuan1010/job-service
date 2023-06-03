package com.job.future.jobservice.controller.post;

import com.job.future.jobservice.api.request.postcontent.GetPostContentByTitleApiRequest;
import com.job.future.jobservice.api.request.postcontent.PostPostContentApiRequest;
import com.job.future.jobservice.api.response.postcontent.GetPostContentByTitleResponse;
import com.job.future.jobservice.dto.postcontent.GetPostContentDTO;
import com.job.future.jobservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/post-content")
    public void index(@RequestBody PostPostContentApiRequest postPostContentApiRequest) {
        postService.saveOrUpdate(postPostContentApiRequest);
    }

    @GetMapping("/search-by-title")
    public ResponseEntity<List<GetPostContentByTitleResponse>> searchByTitle(@RequestParam("title") String title) {
        List<GetPostContentByTitleResponse> listPostContent =
                postService.findPostByTitle(title).stream().map(
                        x -> GetPostContentByTitleResponse.builder()
                                .title(x.getTitle())
                                .content(x.getContent())
                                .views(x.getViews())
                                .createdAt(x.getCreatedAt())
                                .ratingAvg(x.getRatingAvg())
                                .commentContent(x.getCommentContent())
                                .commentCreateAt(String.valueOf(x.getCommentCreateAt()))
                                .build()).collect(Collectors.toList());
        return ResponseEntity.ok(listPostContent);
    }

}
