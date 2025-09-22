package kr.ac.kopo.kkssmm.springboot_jdbctest1.repository;

import kr.ac.kopo.kkssmm.springboot_jdbctest1.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
