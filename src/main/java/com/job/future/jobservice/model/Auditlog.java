package com.job.future.jobservice.model;

import com.job.future.jobservice.utils.DateTimeUtils;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Auditlog implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreatedBy
  @Column(name = "created_by")
  private String createUser;

  @CreatedDate
  @Column(name = "creation_date")
  private LocalDateTime createDateTime;

  @LastModifiedBy
  @Column(name = "last_updated_by")
  private String updateUser;

  @LastModifiedDate
  @Column(name = "last_update_date")
  private LocalDateTime updateDateTime;

  public void createDateTime(LocalDateTime createDateTime, String timeZone) {
    this.createDateTime = DateTimeUtils.convertToUTC(createDateTime, timeZone);
  }

  public void setEndTime(LocalDateTime updateDateTime, String timeZone) {
    this.updateDateTime = DateTimeUtils.convertToUTC(updateDateTime, timeZone);
  }
}
