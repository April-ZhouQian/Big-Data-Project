package com.example.ay.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table( name = "t_user")

public class User {

    @Id
    //@NotNull(message = "ID不能为空")
    //@Column(length = 30)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @NotEmpty(message = "姓名不能为空！")
    @Column(length = 30)
    private  String name;


    @NotEmpty(message = "真实姓名不能为空！")
    @Column(length = 200)
    private String trueName;


    @NotNull(message = "分数不能为空!")
    @Column(length=10)
    private Integer score;

    @NotNull(message = "年龄不能为空！")
    @Min(value=18,message="不满18")
    @Column(length=10)
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }


    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
