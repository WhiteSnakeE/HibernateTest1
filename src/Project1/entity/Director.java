package Project1.entity;

import javax.persistence.*;

@Entity
@Table(name = "director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surName")
    private String surName;

    @OneToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH})
    @JoinColumn(name = "id_company")
    private Company company;

    public Director() {
    }

    public Director(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public int getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
