package com.job.future.jobservice.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "job_paths")
public class JobPath extends Auditlog {
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
