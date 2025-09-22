package kr.ac.kopo.kkssmm.springboot_jdbctest1.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private float weight;
    private float width;
    private float height;

    @OneToOne
    @JoinColumn(name = "product_id")
    @MapsId // 외래키를 기본키로
    private Product product;
}
