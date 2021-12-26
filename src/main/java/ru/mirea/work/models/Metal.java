package ru.mirea.work.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "metal")
public class Metal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Override
    public String toString() {
        return "Metal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
