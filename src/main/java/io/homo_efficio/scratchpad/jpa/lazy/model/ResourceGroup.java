package io.homo_efficio.scratchpad.jpa.lazy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-19
 */
@Entity
@NoArgsConstructor
@Getter
public class ResourceGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Site site;

    @ElementCollection(fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.TRUE)
    private Set<Long> resources = new HashSet<>();
}
