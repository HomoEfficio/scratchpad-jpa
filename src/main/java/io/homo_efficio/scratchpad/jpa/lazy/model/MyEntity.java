package io.homo_efficio.scratchpad.jpa.lazy.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * @author homo.efficio@gmail.com
 * created on 2021-05-24
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyEntity extends AbstractEntity {

    private String description;

    public MyEntity(Long id, String name, String description) {
        super(id, name);
        this.description = description;
    }
}
