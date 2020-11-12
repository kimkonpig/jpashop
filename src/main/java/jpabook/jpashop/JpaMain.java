package jpabook.jpashop;

import jpabook.jpashop.domain.Member2;
import jpabook.jpashop.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){

        //연관관계 매핑 기초 강의 직전 코드(Member.class 사용)
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();

            Member member = em.find(Member.class, memberId);

            Member findMember = order.getMember();

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();*/

        //연관관계 매핑 기초 - 단방향 연관관계 코드(Member2.class 사용)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member2 member2 = new Member2();
            member2.setUsername("member1");
            member2.setTeam(team);
            em.persist(member2);
            
            //영속성 컨텍스트 비워내고 초기화
            /*em.flush();
            em.clear();*/

            Member2 findMember = em.find(Member2.class, member2.getId());
            /*Team findTeam = findMember.getTeam();
            System.out.println("findTeamName = " + findTeam.getName());*/

            List<Member2> members = findMember.getTeam().getMembers();
            //member -> team -> member

            for(Member2 m : members){
                System.out.println("m = " + m.getUsername());
            }



            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();


    }
}
