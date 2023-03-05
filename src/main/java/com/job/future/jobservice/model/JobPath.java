package com.job.future.jobservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
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
@Table(name = "career_paths")
public class JobPath extends Auditlog{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @OneToMany(mappedBy = "jobPath", cascade = CascadeType.ALL)
  private Set<Subject> subjectList;

  @OneToMany(mappedBy = "jobPath", cascade = CascadeType.ALL)
  private Set<Job> jobs;

  @OneToMany(mappedBy = "jobPath")
  private Set<JobPathFavorites> favorites = new HashSet<>();



}
