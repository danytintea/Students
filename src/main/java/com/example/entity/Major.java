package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NonNull
@Builder
@Entity
@Table(name="t_major")
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="university")
    private String university;

    @Column(name="college")
    private String college;

    @Column(name="office")
    private String office;

    @OneToMany(mappedBy = "major", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Student> studentList;
}
