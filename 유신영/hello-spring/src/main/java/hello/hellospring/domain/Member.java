package hello.hellospring.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Id 데이터베이스의 테이블중 유일한 값을 가짐
    // @GeneratedValue PK 컬럼의 데이터 형식은 정해져 있지는 않음, 그러나 유일한 값을 가지고 있어야 데이터 경합 데드락 방지가 가능함
    private Long id;

//    @Column(name = "username")
    private String name;

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
