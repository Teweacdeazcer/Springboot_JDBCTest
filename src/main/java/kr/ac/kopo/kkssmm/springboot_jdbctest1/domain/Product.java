package kr.ac.kopo.kkssmm.springboot_jdbctest1.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;

    // 단방향 참조
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "detail_id")
//    private Detail detail;

    // 공유기본키를 사용한 양방향
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn // 엔티티의 기본키를 외래키로
    private Detail detail;
}
