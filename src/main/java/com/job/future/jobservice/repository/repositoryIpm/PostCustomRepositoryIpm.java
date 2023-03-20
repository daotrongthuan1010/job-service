package com.job.future.jobservice.repository.repositoryIpm;

import com.job.future.jobservice.dto.FindPostDto;
import com.job.future.jobservice.model.Post;
import com.job.future.jobservice.repository.PostCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Repository
public class PostCustomRepositoryIpm implements PostCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public List<FindPostDto> findPostByName(String name){

    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<FindPostDto> query = builder.createQuery(FindPostDto.class);
    Root<Post> post = query.from(Post.class);
    query.select(builder.construct(FindPostDto.class, post.get("id"), post.get("title"), post.get("content")));

    // sử dụng index để tìm kiếm nhanh chóng
    query.where(builder.like(post.get("title"), "%" + name + "%"));
    query.orderBy(builder.desc(post.get("createdAt")));

    // sử dụng caching để giảm thiểu truy vấn đến cơ sở dữ liệu
    TypedQuery<FindPostDto> typedQuery = entityManager.createQuery(query).setHint("javax.persistence.cache.storeMode", "USE");

    // trả về kết quả tìm kiếm
    return typedQuery.getResultList();

  }

}
