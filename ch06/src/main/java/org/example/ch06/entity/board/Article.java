package org.example.ch06.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
// 해당 엔티티에서 관계 설정한 속성(엔티티)은 반드시 제외해야함. 안하면 no session 에러 발생
@ToString(exclude = {"user", "commentList"})
@Builder
@Entity
@Table(name = "board_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private int ano;

    private String title;
    private String content;

    // Article 엔티티 관점에서 User 엔티티는 다대일(N:1), fetch는 엔티티를 로딩하는 시점을 설정하는 속성
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer")
    private User user;

    //  1:N 관계는 List 선언
    @OneToMany(mappedBy = "article",
            fetch = FetchType.LAZY)
    private List<Comment> commentList;

    @CreationTimestamp // 해당 엔티티가 insert 될 때 현재날짜 생성
    private LocalDateTime wdate;


}
