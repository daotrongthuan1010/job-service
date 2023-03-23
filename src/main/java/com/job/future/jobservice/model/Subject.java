package com.job.future.jobservice.model;

import com.job.future.jobservice.utils.DateTimeUtils;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "subjects")
public class Subject extends Auditlog{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;
  @Column(name = "startTime")
  private LocalDateTime startTime;

  @Column(name = "endTime")
  private LocalDateTime endTime;

  @Column(name = "description")
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "job_path_id", referencedColumnName = "id")
  private JobPath jobPath;

  public void setStartTime(LocalDateTime startTime, String timeZone) {
    this.startTime = DateTimeUtils.convertToUTC(startTime, timeZone);
  }

  public void setEndTime(LocalDateTime endTime, String timeZone) {
    this.endTime = DateTimeUtils.convertToUTC(endTime, timeZone);
  }

}
