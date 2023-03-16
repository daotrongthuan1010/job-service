package com.job.future.jobservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "jobs")
public class Job extends Auditlog{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="code")
  private String code;

  @Column(name="name")
  private String name;

  @Column(name = "salary_avg")
  private Double salaryAvg;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "job_path_id", referencedColumnName = "id")
  private JobPath jobPath;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "job_category_id", referencedColumnName = "id")
  private JobCategory jobCategory;

  @OneToMany(mappedBy = "job",fetch = FetchType.LAZY)
  private Set<Post> posts;


}
