package io.homo_efficio.scratchpad.jpa.lazy;

import io.homo_efficio.scratchpad.jpa.lazy.model.IdType;
import io.homo_efficio.scratchpad.jpa.lazy.model.TraitTarget;
import io.homo_efficio.scratchpad.jpa.lazy.model.TraitTargetOut;
import io.homo_efficio.scratchpad.jpa.lazy.model.TraitTargetSourceIdType;
import io.homo_efficio.scratchpad.jpa.lazy.repository.IdTypeRepository;
import io.homo_efficio.scratchpad.jpa.lazy.repository.TraitTargetRepository;
import io.homo_efficio.scratchpad.jpa.lazy.repository.TraitTargetSourceIdTypeRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-19
 */
@Service
@RequiredArgsConstructor
public class TraitTargetService {

    private final TraitTargetRepository traitTargetRepository;
    private final IdTypeRepository idTypeRepository;
    private final TraitTargetSourceIdTypeRepository traitTargetSourceIdTypeRepository;

    @Transactional
    public TraitTargetOut save(TraitTarget traitTarget) {
        TraitTarget dbTraitTarget = traitTargetRepository.save(traitTarget);
        setTraitTargetSourceIdTypes(traitTarget, dbTraitTarget);
        return TraitTargetOut.from(dbTraitTarget);
    }

    private void setTraitTargetSourceIdTypes(TraitTarget traitTarget, TraitTarget dbTraitTarget) {
        List<TraitTargetSourceIdType> selectedSourceIdTypes = traitTarget.getSourceIdTypes();
        if (selectedSourceIdTypes == null || selectedSourceIdTypes.isEmpty()) {
            throw new IllegalArgumentException("TraitTarget 에는 sourceIdTypes가 있어야 합니다.");
        }

        dbTraitTarget.setSourceIdTypes(selectedSourceIdTypes);
    }

    private List<TraitTargetSourceIdType> getTraitTargetSourceIdTypes(TraitTarget traitTarget,
                                                                      List<TraitTargetSourceIdType> selectTraitTargetSourceIdTypesIn,
                                                                      TraitTarget dbTraitTarget) {
        List<TraitTargetSourceIdType> selectedTraitTargetSourceIdTypes = new ArrayList<>();
        for (TraitTargetSourceIdType selectedTraitTargetSourceIdType : selectTraitTargetSourceIdTypesIn) {

            IdType idType = idTypeRepository.findByIdType(selectedTraitTargetSourceIdType.getIdType().getIdType())
                    .orElseThrow(() -> new IllegalArgumentException(selectedTraitTargetSourceIdType.getIdType() + "인 IdType이 존재하지 않습니다."));
            TraitTargetSourceIdType dbTargetSourceIdType = traitTargetSourceIdTypeRepository.findByTraitTarget_IdAndIdType_IdType(
                    selectedTraitTargetSourceIdType.getTraitTarget().getId(), selectedTraitTargetSourceIdType.getIdType().getIdType())
                    .map(targetSourceIdType -> traitTarget.updateTraitTargetSourceIdType(targetSourceIdType, selectedTraitTargetSourceIdType, idType))
                    .orElseGet(() -> traitTargetSourceIdTypeRepository.save(selectedTraitTargetSourceIdType.mapToTargetSourceIdType(traitTarget, idType)));
            selectedTraitTargetSourceIdTypes.add(dbTargetSourceIdType);
        }
        return selectedTraitTargetSourceIdTypes;
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
                .map(TraitTargetOut::from)  // error
//                .map(traitTarget -> {
//                    Hibernate.initialize(traitTarget);  // error
//                    Hibernate.initialize(traitTarget.getResourceGroup());  // error
//                    Hibernate.initialize(traitTarget.getResourceGroup().getResources());  // 성공
//                    return TraitTargetOut.from(traitTarget);
//                })
                .orElseThrow(() -> new RuntimeException("Not found " + id));
    }

}
