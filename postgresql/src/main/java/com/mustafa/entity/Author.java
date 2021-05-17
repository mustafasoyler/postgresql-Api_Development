package com.mustafa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Author {
    @Id
    @SequenceGenerator(name = "seq_aut",allocationSize = 1)
    @GeneratedValue(generator ="seq_aut",strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToMany
    @JoinColumn(name = "author_books_id")
    private List<Book> bookList;

}
