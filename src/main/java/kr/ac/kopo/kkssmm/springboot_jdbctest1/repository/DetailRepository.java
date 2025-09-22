package kr.ac.kopo.kkssmm.springboot_jdbctest1.repository;

import kr.ac.kopo.kkssmm.springboot_jdbctest1.domain.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {
}
