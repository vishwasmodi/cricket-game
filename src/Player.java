public class Player {
    private Integer id;
    private String name;
    private Integer battingSkill;
    private Integer ballingSkill;

    void setId(Integer id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}