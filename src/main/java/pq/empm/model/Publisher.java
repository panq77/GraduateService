package pq.empm.model;

public class Publisher {
    private Integer pid;

    private String name;

    private String pwd;

    private String nickName;

    private String phone;

    private String email;

    private String commpany;

    public Publisher() {
    }

    public Publisher(String name, String pwd) {
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", commpany='" + commpany + '\'' +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommpany() {
        return commpany;
    }

    public void setCommpany(String commpany) {
        this.commpany = commpany;
    }
}