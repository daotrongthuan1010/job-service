package com.job.future.jobservice.repository;

import com.job.future.jobservice.dto.postcontent.GetPostContentDTO;
import com.job.future.jobservice.dto.postcontent.PostPostContentDTO;
import com.job.future.jobservice.model.Post;
import com.job.future.jobservice.utils.ConstantSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface PostContentRepository  extends JpaRepository<Post, Long> {
    @Query(value = ConstantSQL.FIND_POST_CONTENT_BY_TITLE, nativeQuery = true)
    List<GetPostContentDTO> findPostContentByName(String name);


}
