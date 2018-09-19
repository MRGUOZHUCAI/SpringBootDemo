package Serializable;

import java.io.Serializable;

/**
 * @author YCKJ0750
 * @date 2018/8/28 10:21
 */
public class User implements Serializable {

   private static final long serialVersionUID= 1L;

    private String userId;
   // private String name;
    private Integer age;
    private  String job;

    private String remark;

    public User(){}

    public User(String userId, Integer age, String job) {
        this.userId = userId;
        //this.name = name;
        this.age = age;
        this.job = job;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

  /*  public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                //", name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
