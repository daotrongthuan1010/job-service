package com.job.future.jobservice.controller.post;

import com.job.future.jobservice.api.response.comment.GetCommentByTitleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final Comment`

    @PostMapping("/save")
    public void index(){



    }

    public ResponseEntity<List<GetCommentByTitleResponse>> getAllComment(){

    }
}
