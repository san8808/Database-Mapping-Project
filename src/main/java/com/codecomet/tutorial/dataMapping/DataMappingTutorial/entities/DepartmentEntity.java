package com.codecomet.tutorial.dataMapping.DataMappingTutorial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "department")
public class DepartmentEntity extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name = "department_manager")
    EmployeeEntity manager;

    @OneToMany(mappedBy = "workerDepartment")
    private Set<EmployeeEntity> workers;

    @ManyToMany(mappedBy = "freelanceDepartment")
    private Set<EmployeeEntity> freelancers;




    public EmployeeEntity getManager() {
        return manager;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<EmployeeEntity> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<EmployeeEntity> workers) {
        this.workers = workers;
    }

    public Set<EmployeeEntity> getFreelancers() {
        return freelancers;
    }

    public void setFreelancers(Set<EmployeeEntity> freelancers) {
        this.freelancers = freelancers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepartmentEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle());
    }
}
