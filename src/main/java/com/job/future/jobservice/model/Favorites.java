package com.job.future.jobservice.model;

import com.job.future.jobservice.utils.DateTimeUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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


  @OneToMany(mappedBy = "reaction", fetch = FetchType.LAZY)
  private Set<PostFavorites> postFavorites;

  @OneToMany(mappedBy = "reaction", fetch = FetchType.LAZY)
  private Set<JobPathFavorites> jobPathFavorites;

  public void setEndTime(LocalDateTime createdAt, String timeZone) {
    this.createdAt = DateTimeUtils.convertToUTC(createdAt, timeZone);
  }


}
