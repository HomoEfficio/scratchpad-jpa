package io.homo_efficio.scratchpad.jpa.lazy.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-19
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TraitTargetOut {

    private final Long id;
    private final String name;
//    private final List<Containee1> containee1s;
    private final ResourceGroup resourceGroup;
//    private final Set<Long> resources;
    private final List<Long> dataSourceIds;

    public static TraitTargetOut from(TraitTarget traitTarget) {
        return new TraitTargetOut(
                traitTarget.getId(),
                traitTarget.getName(),
//                container.getContainee1s(),
                traitTarget.getResourceGroup(),
//                container.getResources()
                traitTarget.getDataSourceIds()
        );
    }
}
