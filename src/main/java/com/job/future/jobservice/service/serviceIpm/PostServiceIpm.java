package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.api.request.postcontent.PostPostContentApiRequest;
import com.job.future.jobservice.api.response.postcontent.GetPostContentByTitleResponse;
import com.job.future.jobservice.dto.postcontent.GetPostContentDTO;
import com.job.future.jobservice.dto.postcontent.PostPostContentDTO;
import com.job.future.jobservice.repository.PostContentCustomRepository;
import com.job.future.jobservice.repository.PostContentRepository;
import com.job.future.jobservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Service
@AllArgsConstructor
public class PostServiceIpm implements PostService {

    private final PostContentCustomRepository postContentCustomRepository;

    private final PostContentRepository postContentRepository;

    @Override
    public void save(PostPostContentApiRequest postPostContentApiRequest) {
        LocalDateTime localDateTime = LocalDateTime.now();
        postContentCustomRepository.save(
                PostPostContentDTO.builder()
                        .content(postPostContentApiRequest.getContent())
                        .title(postPostContentApiRequest.getTitle())
                        .createAt(localDateTime).build()
        );


    }


    @Override
    @Transactional(readOnly = true)
    public List<GetPostContentDTO> findPostByTitle(String title) {
        List<GetPostContentDTO> list = new ArrayList<>();
        List<Map<String, Object>> obj = postContentRepository.findPostContentByName(title);
        obj.forEach(x->
        {
            list.add(GetPostContentDTO.builder()
                    .code(String.valueOf(x.get("code")))
                            .title(String.valueOf(x.get("title")))
                            .content(String.valueOf(x.get("content")))

                    .build());

        });
        return  list;


    }
}
