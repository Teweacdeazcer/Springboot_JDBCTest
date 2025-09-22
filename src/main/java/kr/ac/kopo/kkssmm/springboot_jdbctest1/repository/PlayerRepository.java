package kr.ac.kopo.kkssmm.springboot_jdbctest1.repository;


import kr.ac.kopo.kkssmm.springboot_jdbctest1.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
