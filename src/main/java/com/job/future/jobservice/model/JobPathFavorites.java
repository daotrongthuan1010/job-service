package com.job.future.jobservice.model;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_path_favorites")
public class JobPathFavorites extends Auditlog{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "job_path_id", referencedColumnName = "id")
  private JobPath jobPath;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "favorite_id", referencedColumnName = "id")
  private Favorites favorites;


}
