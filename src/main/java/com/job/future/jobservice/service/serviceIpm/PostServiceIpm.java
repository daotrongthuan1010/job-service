package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.api.request.postcontent.PostPostContentApiRequest;
import com.job.future.jobservice.dto.postcontent.PostPostContentDTO;
import com.job.future.jobservice.repository.PostCustomRepository;
import com.job.future.jobservice.service.PostService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Service
@AllArgsConstructor
public class PostServiceIpm implements PostService {

    private final PostCustomRepository postCustomRepository;

    @Override
    public void save(PostPostContentApiRequest postPostContentApiRequest) {
        LocalDateTime localDateTime = LocalDateTime.now();

        postCustomRepository.save(
                PostPostContentDTO.builder()
                        .content(postPostContentApiRequest.getContent())
                        .title(postPostContentApiRequest.getTitle())
                        .createAt(localDateTime).build()
        );


    }
}
