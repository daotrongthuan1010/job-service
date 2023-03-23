package com.job.future.jobservice.model;

import com.job.future.jobservice.utils.DateTimeUtils;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "favorites")
public class Favorites extends Auditlog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "created_at")
  private LocalDateTime createdAt;


  @OneToMany(mappedBy = "favorites", fetch = FetchType.LAZY)
  private Set<PostFavorites> postFavorites;

  @OneToMany(mappedBy = "favorites", fetch = FetchType.LAZY)
  private Set<JobPathFavorites> jobPathFavorites;

  public void setEndTime(LocalDateTime createdAt, String timeZone) {
    this.createdAt = DateTimeUtils.convertToUTC(createdAt, timeZone);
  }


}
