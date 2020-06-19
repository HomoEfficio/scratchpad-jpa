package io.homo_efficio.scratchpad.jpa.lazy;

import io.homo_efficio.scratchpad.jpa.lazy.model.Containee1;
import io.homo_efficio.scratchpad.jpa.lazy.model.Container;
import io.homo_efficio.scratchpad.jpa.lazy.model.ContainerOut;
import io.homo_efficio.scratchpad.jpa.lazy.repository.ContainerRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-19
 */
@Service
@RequiredArgsConstructor
public class ContainerService {

    private final ContainerRepository containerRepository;

    @Transactional
    public Container save(Container container) {
        return containerRepository.save(container);
    }

    @Transactional(readOnly = true)
    public Container findById(Long id) {
        Optional<Container> optContainer = containerRepository.findById(id);
        Container container = optContainer.orElseThrow(() -> new RuntimeException("Not found " + id));
//        List<Containee1> containee1s = container.getContainee1s();
        return container;
    }

    @Transactional(readOnly = true)
    public ContainerOut findOutById(Long id) {
        Optional<Container> optContainer = containerRepository.findById(id);
        Container container = optContainer.orElseThrow(() -> new RuntimeException("Not found " + id));
//        List<Containee1> containee1s = container.getContainee1s();
//        Hibernate.initialize(containee1s);
        Set<Long> resources = container.getResources();
        ContainerOut containerOut = ContainerOut.from(container);
        return containerOut;
    }
}
