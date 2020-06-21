package io.homo_efficio.scratchpad.jpa.lazy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-22
 */
@Entity
@Getter @Setter
@IdClass(TraitTargetSourceIdTypeId.class)
@NoArgsConstructor
@AllArgsConstructor
public class TraitTargetSourceIdType {

    @Id
    @ManyToOne
    @JoinColumn(name = "trait_target_id")
    private TraitTarget traitTarget;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_type")
    private IdType idType;

    public TraitTargetSourceIdType mapToTargetSourceIdType(TraitTarget traitTarget, IdType idType) {
        return new TraitTargetSourceIdType(traitTarget, idType);
    }
}
