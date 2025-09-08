package kr.ac.kopo.kkssmm.springboot_jdbctest1.repository;


import kr.ac.kopo.kkssmm.springboot_jdbctest1.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository02 extends JpaRepository<Member,Integer> {

}
