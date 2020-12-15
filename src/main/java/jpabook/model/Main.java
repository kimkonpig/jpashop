package jpabook.model;

import jpabook.model.entity.Member;
import jpabook.model.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{

            //Member 엔티티 생성 후 proxy 초기화(아래)
            Member member1 = new Member();
            member1.setName("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member findMember1 = em.getReference(Member.class, member1.getId());

            System.out.println("findMember1 Class : " + findMember1.getClass());
            System.out.println("findMember1 Name : " + findMember1.getName());

        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
