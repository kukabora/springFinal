package kz.iitu.itse1908.springfinalproject.Entities;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity
@Table(name = "testquestions")
public class Testquestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "testid", nullable = false)
    @RestResource(path = "testid", rel="testid")
    private Test testid;

    @Column(name = "questiontext", nullable = false)
    private String questiontext;

    @Column(name = "answer1", nullable = false)
    private String answer1;

    @Column(name = "answer2", nullable = false)
    private String answer2;

    @Column(name = "answer3", nullable = false)
    private String answer3;

    @Column(name = "correctanswer", nullable = false)
    private String correctanswer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestid() {
        return testid.getId();
    }

    public void setTestid(Test testid) {
        this.testid = testid;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(String correctanswer) {
        this.correctanswer = correctanswer;
    }

}