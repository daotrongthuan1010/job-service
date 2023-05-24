package com.job.future.jobservice.repository;

import com.job.future.jobservice.dto.postcontent.GetPostContentDTO;
import com.job.future.jobservice.dto.postcontent.PostPostContentDTO;
import com.job.future.jobservice.model.Post;
import com.job.future.jobservice.utils.ConstantSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
public interface PostContentRepository  extends JpaRepository<Post, Long> {
    @Transactional(readOnly = true)
    @Query(value = ConstantSQL.FIND_POST_CONTENT_BY_TITLE, nativeQuery = true)
    List<Map<String, Object>> findPostContentByName(String title);


}
