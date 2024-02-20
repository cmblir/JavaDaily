package hello.core.member;

public class Member {
    private Long id;
    private String name;
    private Grade graed;
    public Member(Long id, String name, Grade graed) {
        this.id = id;
        this.name = name;
        this.graed = graed;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Grade getGraed() {
        return graed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGraed(Grade graed) {
        this.graed = graed;
    }
}
