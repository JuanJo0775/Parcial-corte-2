package org.arle.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

public class FacultadListener {

    @PrePersist
    public void prePersist(Facultad facultad) {
        System.out.println("Facultad a ser persistida: " + facultad);
    }

    @PostPersist
    public void postPersist(Facultad facultad) {
        System.out.println("Facultad persistida: " + facultad);
    }

    @PreUpdate
    public void preUpdate(Facultad facultad) {
        System.out.println("Facultad a ser actualizada: " + facultad);
    }

    @PostUpdate
    public void postUpdate(Facultad facultad) {
        System.out.println("Facultad actualizada: " + facultad);
    }

    @PreRemove
    public void preRemove(Facultad facultad) {
        System.out.println("Facultad a ser eliminada: " + facultad);
    }

    @PostRemove
    public void postRemove(Facultad facultad) {
        System.out.println("Facultad eliminada: " + facultad);
    }
}
