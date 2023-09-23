package com.example.bankdemoproject.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull(message = "Cannot be null!")
    String name;
    @NotNull(message = "Cannot be null!")
    String surname;
    String pin;
    String seria;
    Date dob;
    String phone;
    String address;
    String cif;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
    @ColumnDefault(value = "1")
    Integer active;
}
