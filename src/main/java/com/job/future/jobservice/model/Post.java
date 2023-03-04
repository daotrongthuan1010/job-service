package com.job.future.jobservice.model;

import com.job.future.jobservice.utils.DateTimeUtils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
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

@Entity
@Builder
@Getter
@Setter
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
  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
  private Set<Rating> ratings;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "rating_avg")
  private Double ratingAvg;

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
