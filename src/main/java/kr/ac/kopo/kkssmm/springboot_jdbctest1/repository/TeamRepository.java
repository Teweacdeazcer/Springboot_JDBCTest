package kr.ac.kopo.kkssmm.springboot_jdbctest1.repository;


import kr.ac.kopo.kkssmm.springboot_jdbctest1.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
