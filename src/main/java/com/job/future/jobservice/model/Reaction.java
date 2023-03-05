package com.job.future.jobservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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
@Table(name = "reactions")
public class Reaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "reaction_type")
  private ReactionType reactionType;

  @OneToMany(mappedBy = "reaction", fetch = FetchType.LAZY)
  private List<PostReaction> postReactions;

  @OneToMany(mappedBy = "reaction", fetch = FetchType.LAZY)
  private List<CommentReaction> commentReactions;


  public enum ReactionType {
    SAD("01"),
    HAPPY("02"),
    LOVE("03"),
    CRY("04"),
    MISS("04"),
    HEARTBROKEN("05");

    private String value;

    private ReactionType(String value) {
      this.value = value;
    }

  }
}
