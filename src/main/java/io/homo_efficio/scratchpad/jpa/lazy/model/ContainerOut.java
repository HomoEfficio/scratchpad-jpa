package io.homo_efficio.scratchpad.jpa.lazy.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-19
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ContainerOut {

    private final Long id;
    private final String name;
//    private final List<Containee1> containee1s;
//    private final Containee2 containee2;
    private final Set<Long> resources;

    public static ContainerOut from(Container container) {
        return new ContainerOut(
                container.getId(),
                container.getName(),
//                container.getContainee1s(),
//                container.getContainee2()
                container.getResources()
        );
    }
}
