package pq.empm.model;

public class User {

    private Integer uid;

    private String uname;

    private String pwd;

    private Integer age;

    private Integer gender;

    private Integer phone;

    private String email;

    private String expectedJob;

    private String expectedEara;

    private String education;

    private Integer hasExperience;


    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", expectedJob='" + expectedJob + '\'' +
                ", expectedEara='" + expectedEara + '\'' +
                ", education='" + education + '\'' +
                ", hasExperience=" + hasExperience +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getExpectedJob() {
        return expectedJob;
    }

    public void setExpectedJob(String expectedJob) {
        this.expectedJob = expectedJob == null ? null : expectedJob.trim();
    }

    public String getExpectedEara() {
        return expectedEara;
    }

    public void setExpectedEara(String expectedEara) {
        this.expectedEara = expectedEara == null ? null : expectedEara.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public Integer getHasExperience() {
        return hasExperience;
    }

    public void setHasExperience(Integer hasExperience) {
        this.hasExperience = hasExperience;
    }
}
