package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team") //일대다 매핑에서 어떤거랑 매핑 되어있는지 알려줌
    private List<Member2> members = new ArrayList<>();

    public List<Member2> getMembers() {
        return members;
    }
    
    public void addMember(Member2 member2){
        member2.setTeam(this);
        members.add(member2);
    }

    public void setMembers(List<Member2> members) {
        this.members = members;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
