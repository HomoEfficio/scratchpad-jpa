package io.homo_efficio.scratchpad.jpa.lazy.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-22
 */
@Getter
@RequiredArgsConstructor
public class TraitTargetSourceIdTypeOut {

    private final Long traitTargetId;
    private final String idType;

    public TraitTargetSourceIdTypeOut from(TraitTargetSourceIdType sourceIdType) {
        return new TraitTargetSourceIdTypeOut(
                sourceIdType.getTraitTarget().getId(),
                sourceIdType.getIdType().getIdType()
        );
    }
}
