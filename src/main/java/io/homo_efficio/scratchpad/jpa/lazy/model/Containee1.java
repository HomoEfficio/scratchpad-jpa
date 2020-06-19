package io.homo_efficio.scratchpad.jpa.lazy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-19
 */
@Entity
@NoArgsConstructor
@Getter
public class Containee1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
