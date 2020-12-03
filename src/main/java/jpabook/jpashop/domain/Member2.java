package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member2 {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    //일대다 양방향 매핑을 위해 JoinColumn에 속성 두개 추가(읽기전용으로 만들어줌)
    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member2")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    //@Column(name = "TEAM_ID")
    //private Long teamId;

    /*@ManyToOne //회원(다) 대 팀(일)
    @JoinColumn(name = "TEAM_ID")
    private Team team;*/

    /*public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }*/

    /*public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
