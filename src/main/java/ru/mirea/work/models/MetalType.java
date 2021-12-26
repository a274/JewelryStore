package ru.mirea.work.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "types_metal")
public class MetalType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="types_id")
    private int typesId;

    @Column(name="metal_id")
    private int metalId;

    @Override
    public String toString() {
        return "MetalType{" +
                "id=" + id +
                ", typesId=" + typesId +
                ", metalId=" + metalId +
                '}';
    }
}
