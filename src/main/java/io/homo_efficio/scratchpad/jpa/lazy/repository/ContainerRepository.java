package io.homo_efficio.scratchpad.jpa.lazy.repository;

import io.homo_efficio.scratchpad.jpa.lazy.model.Container;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-19
 */
public interface ContainerRepository extends JpaRepository<Container, Long> {
}
