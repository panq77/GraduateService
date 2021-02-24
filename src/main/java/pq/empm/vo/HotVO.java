package pq.empm.vo;

import java.util.Date;

public class HotVO {
    private Long id;

    private String jid;

    private String jname;

    private String jcommpanyName;

    private String typeC;

    private String jcommpanyType;

    private String jarea;

    private Integer clickTimes;

    private Date time;

    private Integer sum;

    public HotVO() {
    }

    public HotVO(Long id, String jid, String jname, String jcommpanyName,
                 String typeC, String jcommpanyType,
                 String jarea, Integer clickTimes, Date time, Integer sum) {
        this.id = id;
        this.jid = jid;
        this.jname = jname;
        this.jcommpanyName = jcommpanyName;
        this.typeC = typeC;
        this.jcommpanyType = jcommpanyType;
        this.jarea = jarea;
        this.clickTimes = clickTimes;
        this.time = time;
        this.sum = sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getJcommpanyName() {
        return jcommpanyName;
    }

    public void setJcommpanyName(String jcommpanyName) {
        this.jcommpanyName = jcommpanyName;
    }

    public String getTypeC() {
        return typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC;
    }

    public String getJcommpanyType() {
        return jcommpanyType;
    }

    public void setJcommpanyType(String jcommpanyType) {
        this.jcommpanyType = jcommpanyType;
    }

    public String getJarea() {
        return jarea;
    }

    public void setJarea(String jarea) {
        this.jarea = jarea;
    }

    public Integer getClickTimes() {
        return clickTimes;
    }

    public void setClickTimes(Integer clickTimes) {
        this.clickTimes = clickTimes;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "HotVO{" +
                "id=" + id +
                ", jid='" + jid + '\'' +
                ", jname='" + jname + '\'' +
                ", jcommpanyName='" + jcommpanyName + '\'' +
                ", typeC='" + typeC + '\'' +
                ", jcommpanyType='" + jcommpanyType + '\'' +
                ", jarea='" + jarea + '\'' +
                ", clickTimes=" + clickTimes +
                ", time=" + time +
                ", sum=" + sum +
                '}';
    }
}
