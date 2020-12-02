package jpabook.jpashop;

import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){

        //연관관계 매핑 기초 - 단방향 연관관계 코드(Member2.class 사용)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            /*Order order = new Order(); //주문 객체 생성
            order.addOrderItem(new OrderItem()); //원하는 orderItem 추가*/

            /*Order order = new Order();
            em.persist(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            em.persist(orderItem);*/

            Member2 member2 = new Member2();
            member2.setUsername("member1");
            em.persist(member2);

            Team team = new Team();;
            team.setName("team");
            team.getMembers().add(member2);
            em.persist(team);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();


    }
}
