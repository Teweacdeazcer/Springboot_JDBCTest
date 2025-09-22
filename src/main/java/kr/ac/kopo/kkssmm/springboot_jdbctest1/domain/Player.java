package kr.ac.kopo.kkssmm.springboot_jdbctest1.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
