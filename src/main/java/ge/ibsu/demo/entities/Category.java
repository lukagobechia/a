package ge.ibsu.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @SequenceGenerator(name = "category_category_id_seq", sequenceName = "category_category_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_category_id_seq")
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
