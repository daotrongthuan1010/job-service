package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.api.request.postcontent.PostPostContentApiRequest;
import com.job.future.jobservice.dto.postcontent.GetPostContentDTO;
import com.job.future.jobservice.dto.postcontent.PostPostContentDTO;
import com.job.future.jobservice.repository.PostContentRepository;
import com.job.future.jobservice.repository.PostCustomRepository;
import com.job.future.jobservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Service
@AllArgsConstructor
public class PostServiceIpm implements PostService {

    private final PostCustomRepository postCustomRepository;

    private final PostContentRepository postContentRepository;

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

    List<Exception> listError = new ArrayList<>();
    @Override
    public List<GetPostContentDTO> findPostByTitle(String title) {
        List<GetPostContentDTO> list = postCustomRepository.findPostContentByName(title);

        CollectionUtils.isEmpty(list){
            listError.add(new ServerException("Not found"));
        }

        return list;
    }
}
