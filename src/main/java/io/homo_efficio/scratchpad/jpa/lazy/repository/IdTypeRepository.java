package io.homo_efficio.scratchpad.jpa.lazy.repository;

import io.homo_efficio.scratchpad.jpa.lazy.model.IdType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-22
 */
public interface IdTypeRepository extends JpaRepository<IdType, String> {

    Optional<IdType> findByIdType(String idType);
}
