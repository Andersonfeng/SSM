package demo.anderson.po;

import java.math.BigDecimal;
import java.util.List;

public class Sc extends ScKey {

    private BigDecimal score;
    private Course course;

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
