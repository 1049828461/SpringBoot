package cn.grace.dto;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

@Repository
public class StudentDTO implements Serializable {

    private Integer stuId;

    private String stuName;

    private Integer stuAge;

    private double stuScore;

    private Date stuTime;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public double getStuScore() {
        return stuScore;
    }

    public void setStuScore(double stuScore) {
        this.stuScore = stuScore;
    }

    public Date getStuTime() {
        return stuTime;
    }

    public void setStuTime(Date stuTime) {
        this.stuTime = stuTime;
    }

    public StudentDTO() {
        super();
    }

    public StudentDTO(Integer stuId, String stuName, Integer stuAge, double stuScore, Date stuTime) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuScore = stuScore;
        this.stuTime = stuTime;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", stuScore=" + stuScore +
                ", stuTime=" + stuTime +
                '}';
    }
}
