package com.job.future.jobservice.model;

import com.job.future.jobservice.utils.DateTimeUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
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
@Table(name = "comments")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "code")
  private String code;

  @Column(name = "content")
  private String content;

  @Column(name = "views")
  private Long views;
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  public void setCreatedAt(LocalDateTime createdAt, String timeZone) {
    this.createdAt = DateTimeUtils.convertToUTC(createdAt, timeZone);
  }

}
