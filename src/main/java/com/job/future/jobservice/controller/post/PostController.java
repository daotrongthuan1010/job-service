package com.job.future.jobservice.controller.post;

import com.job.future.jobservice.api.request.postcontent.PostPostContentApiRequest;
import com.job.future.jobservice.exception.BusinessException;
import com.job.future.jobservice.exception.ValidationException;
import com.job.future.jobservice.exception.response.ValidationErrorResponse;
import com.job.future.jobservice.service.PostService;
import com.job.future.jobservice.service.serviceIpm.AddressServiceIpm;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

@Slf4j
@ToString
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/post-content")
public class PostController {

    private Logger logger;

    private Validator validator;

    private final PostService postService;

    private final AddressServiceIpm serviceIpm;

    @PostMapping("/save")
    public void saveOrUpdate(@RequestBody  PostPostContentApiRequest request, Authentication authentication){
        logger.info("Request: "+request.toString());
        String username = authentication.getName();
        postService.saveOrUpdate(request, authentication);
    }

    @GetMapping("/address/search")
    public void getAddress(@RequestParam("keyWord") String keyWord){
        serviceIpm.save(keyWord);
    }


}
