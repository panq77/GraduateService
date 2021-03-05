package pq.empm.model;

public class Publisher {
    private Integer pid;

    private String name;

    private String pwd;

    private String nickname;

    private String phone;

    private String email;

    private String commpany;

    public Publisher() {
    }

    public Publisher(String name, String pwd) {
    }

    public Integer getPid() {
        return pid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCommpany() {
        return commpany;
    }

    public void setCommpany(String commpany) {
        this.commpany = commpany == null ? null : commpany.trim();
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", commpany='" + commpany + '\'' +
                '}';
    }
}