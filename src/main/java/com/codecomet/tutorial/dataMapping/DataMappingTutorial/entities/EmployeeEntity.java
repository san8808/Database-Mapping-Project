package com.codecomet.tutorial.dataMapping.DataMappingTutorial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Employees")
@Audited
public class EmployeeEntity extends AuditableEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true)
    private String name;

    @OneToOne(mappedBy = "manager")
    @JsonIgnore
    @NotAudited
    private DepartmentEntity managedDepartment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_department_id", referencedColumnName = "id")
    @JsonIgnore
    @NotAudited
    private DepartmentEntity workerDepartment;

    @ManyToMany
    @JoinTable(name = "freelancer_department_mapping",joinColumns = @JoinColumn(name = "employee_id"),
               inverseJoinColumns = @JoinColumn(name = "department_id"))
    @JsonIgnore
    @NotAudited
    private Set<DepartmentEntity> freelanceDepartment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepartmentEntity getManagedDepartment() {
        return managedDepartment;
    }

    public void setManagedDepartment(DepartmentEntity managedDepartment) {
        this.managedDepartment = managedDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentEntity getWorkerDepartment() {
        return workerDepartment;
    }

    public void setWorkerDepartment(DepartmentEntity workerDepartment) {
        this.workerDepartment = workerDepartment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    public Set<DepartmentEntity> getFreelanceDepartment() {
        return freelanceDepartment;
    }

    public void setFreelanceDepartment(Set<DepartmentEntity> freelanceDepartment) {
        this.freelanceDepartment = freelanceDepartment;
    }
}
