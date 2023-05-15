package com.job.future.jobservice.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "reactions")
public class Reaction extends Auditlog {

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
