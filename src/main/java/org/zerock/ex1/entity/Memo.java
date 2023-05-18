package org.zerock.ex1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "memo")
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 200, nullable = false)
    private String memoText;
}