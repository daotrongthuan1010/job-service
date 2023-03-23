package com.job.future.jobservice.model;

import com.job.future.jobservice.utils.DateTimeUtils;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post extends Auditlog{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "code")
  private String code;

  @Column(name = "title")
  private String title;

  @Column(name = "content")
  private String content;

  @Column(name = "views")
  private Long views;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "rating_avg")
  private Double ratingAvg;

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
  private Set<Rating> ratings;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "job", referencedColumnName = "id")
  private Job job;

  @OneToMany(mappedBy = "post")
  private List<PostReaction> postReactions = new ArrayList<>();


  @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
  private Set<PostFavorites> postFavorites;

  @OneToMany(mappedBy = "post")
  private List<Comment> comments = new ArrayList<>();


  public void setRatingAvg(Set<Rating> ratings) {
    this.ratingAvg = ratings.stream()
        .mapToDouble(Rating::getRating)
        .average()
        .orElse(ratingAvg);
  }

  public void setEndTime(LocalDateTime createdAt, String timeZone) {
    this.createdAt = DateTimeUtils.convertToUTC(createdAt, timeZone);
  }

}
