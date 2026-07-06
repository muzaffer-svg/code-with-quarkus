package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;


@Entity
@Table(name = "campuses")
public class CampusStudent extends PanacheEntityBase {
 
  @Id
  @GeneratedValue
  @Column(name = "id", updatable = false, nullable = false)
  public UUID id;

  @Column(name = "first_name", nullable = false)
  public String name;

  @Column(name="last_name", nullable = false)
  public String lastname;


  @Column(name = "email", nullable = false, unique = true)
  public String email;

  @Column(name = "phone_number", nullable = false)
  public String phoneNumber;


  @Column(name = "student_number", nullable = false, unique = true)
  public String studentNumber;
}
  
