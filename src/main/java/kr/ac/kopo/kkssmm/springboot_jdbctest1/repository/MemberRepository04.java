package kr.ac.kopo.kkssmm.springboot_jdbctest1.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import kr.ac.kopo.kkssmm.springboot_jdbctest1.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository04 {

    @PersistenceContext
    private EntityManager entitymanager;

    public List<Member> selectMethod(){
        String jpql = "select entity from Member entity";
        Query query = entitymanager.createQuery(jpql);
        List<Member> memberList = query.getResultList();
        return memberList;
    }

    @Transactional
    public void insertMethod(Member member) {
        String jpql = "insert into Member(name, age, email) values (:e_name, :e_age, :e_email)";
        Query query = entitymanager.createQuery(jpql);
        query.setParameter("e_name", member.getName());
        query.setParameter("e_age", member.getAge());
        query.setParameter("e_email", member.getEmail());
        query.executeUpdate();
    }

    public Member selectMethodById(int id) {
        String jpql = "select entity from Member entity where id = :e_id";
        Query query = entitymanager.createQuery(jpql);
        query.setParameter("e_id", id);
        Member member = (Member) query.getSingleResult();
        return member;
    }

    @Transactional
    public void updateMethod(Member member) {
        String jpql = "update Member set name = :e_name, age = :e_age, email = :e_email where id = :e_id";
        Query query = entitymanager.createQuery(jpql);
        query.setParameter("e_name", member.getName());
        query.setParameter("e_age", member.getAge());
        query.setParameter("e_email", member.getEmail());
        query.setParameter("e_id", member.getId());
        query.executeUpdate();
    }

    @Transactional
    public void deleteMethod(int id) {
        String jpql = "delete from Member where id = :e_id";
        Query query = entitymanager.createQuery(jpql);
        query.setParameter("e_id", id);
        query.executeUpdate();
    }
}