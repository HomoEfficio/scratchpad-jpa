package io.homo_efficio.scratchpad.jpa.lazy.model;

import java.io.Serializable;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-22
 */
public class TraitTargetSourceIdTypeId implements Serializable {

    private Long traitTarget;
    private String idType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TraitTargetSourceIdTypeId that = (TraitTargetSourceIdTypeId) o;

        if (!traitTarget.equals(that.traitTarget)) return false;
        return idType.equals(that.idType);
    }

    @Override
    public int hashCode() {
        int result = traitTarget.hashCode();
        result = 31 * result + idType.hashCode();
        return result;
    }
}
