package io.homo_efficio.scratchpad.jpa.lazy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-22
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class IdType implements Serializable {

    @Id
    private String idType;
    private String name;
    private Integer orderSeq;
}
