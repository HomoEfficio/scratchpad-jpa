package io.homo_efficio.scratchpad.jpa.lazy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-06-19
 */
@Entity
@NoArgsConstructor
@Getter
public class TraitTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_SITE"))
    private Site site;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "container_id")
//    private List<Containee1> containee1s;

//    @OneToOne(cascade = CascadeType.PERSIST)
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private ResourceGroup resourceGroup;

//    @ElementCollection(fetch = FetchType.LAZY)
//    @LazyCollection(LazyCollectionOption.TRUE)
//    private Set<Long> resources;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Long> dataSourceIds;
}
