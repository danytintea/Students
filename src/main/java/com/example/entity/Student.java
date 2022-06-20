package com.example.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NonNull
@Builder
@Entity
@Table(name="t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="lastname")
    private String lastName;

    @Column(name="firstname")
    private String firstName;

    @Column(name="mail")
    private String email;

    @Column(name="year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "id_major")
    private Major major = new Major();
}
