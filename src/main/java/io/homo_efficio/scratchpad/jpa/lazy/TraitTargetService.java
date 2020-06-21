package io.homo_efficio.scratchpad.jpa.lazy;

import io.homo_efficio.scratchpad.jpa.lazy.model.TraitTarget;
import io.homo_efficio.scratchpad.jpa.lazy.model.TraitTargetOut;
import io.homo_efficio.scratchpad.jpa.lazy.repository.TraitTargetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-19
 */
@Service
@RequiredArgsConstructor
public class TraitTargetService {

    private final TraitTargetRepository traitTargetRepository;

    @Transactional
    public TraitTarget save(TraitTarget traitTarget) {
        return traitTargetRepository.save(traitTarget);
    }

//    @Transactional(readOnly = true)
//    public TraitTarget findById(Long id) {
//        Optional<TraitTarget> optTraitTarget = traitTargetRepository.findById(id);
//        TraitTarget traitTarget = optTraitTarget.orElseThrow(() -> new RuntimeException("Not found " + id));
////        List<Containee1> containee1s = container.getContainee1s();
//        return traitTarget;
//    }

    @Transactional(readOnly = true)
    public TraitTargetOut findOutById(Long id) {
//        Optional<Container> optContainer = containerRepository.findById(id);
//        Container container = optContainer.orElseThrow(() -> new RuntimeException("Not found " + id));
////        List<Containee1> containee1s = container.getContainee1s();
////        Hibernate.initialize(containee1s);
////        Set<Long> resources = container.getResources();
//        ContainerOut containerOut = ContainerOut.from(container);
//        return containerOut;

        return traitTargetRepository.findById(id)
                .map(TraitTargetOut::from)
                .orElseThrow(() -> new RuntimeException("Not found " + id));
    }
}
