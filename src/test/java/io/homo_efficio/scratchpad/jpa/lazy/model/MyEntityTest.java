package io.homo_efficio.scratchpad.jpa.lazy.model;

import org.junit.jupiter.api.Test;

class MyEntityTest {

    @Test
    public void identity() {
        MyEntity myEntity1 = new MyEntity(1L, "name1", "description1");
        MyEntity myEntity2 = new MyEntity(1L, "name2", "description2");

        System.out.println("myEntity1: " + myEntity1);
        System.out.println("myEntity2: " + myEntity2);

        System.out.println("myEntity1.hashCode(): " + myEntity1.hashCode());
        System.out.println("myEntity2.hashCode(): " + myEntity2.hashCode());

        System.out.println("myEntity1.equals(myEntity2): " + myEntity1.equals(myEntity2));

        Long myId1 = 1L;
        System.out.println("myId1.hashCode(): " + myId1.hashCode());
    }
}
