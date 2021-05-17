package com.mustafa.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Book implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_aut_book",allocationSize = 1)
    @GeneratedValue(generator ="seq_aut_book",strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "bookName")
    private String bookName;

    @Column(name = "publishDate")
    private Date publishDate;

    @ManyToOne
    @JoinColumn(name = "author_books_id")
    private Author author;

    @Enumerated
    BookType bookType;

  public enum BookType {
        STORY,
        NOVEL,
        TALE
    }
}
