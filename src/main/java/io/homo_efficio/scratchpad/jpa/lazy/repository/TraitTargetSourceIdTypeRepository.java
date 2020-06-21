package io.homo_efficio.scratchpad.jpa.lazy.repository;

import io.homo_efficio.scratchpad.jpa.lazy.model.TraitTargetSourceIdType;
import io.homo_efficio.scratchpad.jpa.lazy.model.TraitTargetSourceIdTypeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-22
 */
public interface TraitTargetSourceIdTypeRepository extends JpaRepository<TraitTargetSourceIdType, TraitTargetSourceIdTypeId> {

    Optional<TraitTargetSourceIdType> findByTraitTarget_IdAndIdType_IdType(Long traitTargetId, String idType);
}
