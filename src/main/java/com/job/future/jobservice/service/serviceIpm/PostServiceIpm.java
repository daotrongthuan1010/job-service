package com.job.future.jobservice.service.serviceIpm;

import com.job.future.jobservice.api.request.postcontent.PostPostContentApiRequest;
import com.job.future.jobservice.dto.postcontent.GetPostContentDTO;
import com.job.future.jobservice.dto.postcontent.PostPostContentDTO;
import com.job.future.jobservice.repository.PostContentCustomRepository;
import com.job.future.jobservice.repository.PostContentRepository;
import com.job.future.jobservice.service.PostService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
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
    public void saveOrUpdate(PostPostContentApiRequest request) {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (!Objects.isNull(request.getId())) {

            postContentCustomRepository.save(
                    PostPostContentDTO.builder()
                            .content(request.getContent())
                            .title(request.getTitle())
                            .createAt(localDateTime).build()
            );
        } else {

            postContentCustomRepository.update(
                    PostPostContentDTO.builder()
                            .content(request.getContent())
                            .title(request.getTitle())
                            .createAt(localDateTime).build()
            );
        }
    }


    @Override
    @Transactional(readOnly = true)
    public List<GetPostContentDTO> findPostByTitle(String title) {

        if (Objects.isNull(title) || Strings.isEmpty(title)) {
            throw new ServiceException(PostService.PARAM_NULL);
        }

        List<GetPostContentDTO> list = postContentRepository.findPostContentByName(title)
                .stream()
                .map(x -> GetPostContentDTO.builder()
                        .code(String.valueOf(x.get("code")))
                        .title(String.valueOf(x.get("title")))
                        .content(String.valueOf(x.get("content")))
                        .build())
                .collect(Collectors.toList());

        if (ObjectUtils.isEmpty(list)) {
            throw new ServiceException(PostService.NoRecordFound);
        }

        return list;

    }
}
