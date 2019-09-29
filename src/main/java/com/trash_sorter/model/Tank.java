package com.trash_sorter.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tanks")
public class Tank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "tank_name")
    private String tankName;

    @Column(name = "qr")
    private String qr;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "tanks_and_cats",
            joinColumns = {@JoinColumn(name="tank_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private Set<Tank> tanks = new HashSet<>();

    public Tank() {
    }

    public Tank(String name) {
        this.tankName = name;
    }

    public Tank(String tankName, String qr) {
        this.tankName = tankName;
        this.qr = qr;
    }

    public String getQr() {
        return qr;
    }

    public long getId() {
        return id;
    }

    public String getTankName() {
        return tankName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tank tank = (Tank) o;
        return id == tank.id &&
                Objects.equals(tankName, tank.tankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tankName);
    }
}
