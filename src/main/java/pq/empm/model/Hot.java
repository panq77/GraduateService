package pq.empm.model;

import java.util.Date;

public class Hot {
    private Long id;

    private String jid;

    private String jname;

    private String jcommpanyName;

    private String typeC;

    private String jcommpanyType;

    private String jarea;

    private Integer clickTimes;

    private Date time;

    @Override
    public String toString() {
        return "Hot{" +
                "id=" + id +
                ", jid='" + jid + '\'' +
                ", jname='" + jname + '\'' +
                ", jcommpanyName='" + jcommpanyName + '\'' +
                ", typeC='" + typeC + '\'' +
                ", jcommpanyType='" + jcommpanyType + '\'' +
                ", jarea='" + jarea + '\'' +
                ", clickTimes=" + clickTimes +
                ", time=" + time +
                '}';
    }

    public Hot(Long id, String jid, String jname, String jcommpanyName,
               String typeC, String jcommpanyType,
               String jarea, Integer clickTimes, Date time) {
        this.id = id;
        this.jid = jid;
        this.jname = jname;
        this.jcommpanyName = jcommpanyName;
        this.typeC = typeC;
        this.jcommpanyType = jcommpanyType;
        this.jarea = jarea;
        this.clickTimes = clickTimes;
        this.time = time;
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
        this.jid = jid == null ? null : jid.trim();
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname == null ? null : jname.trim();
    }

    public String getJcommpanyName() {
        return jcommpanyName;
    }

    public void setJcommpanyName(String jcommpanyName) {
        this.jcommpanyName = jcommpanyName == null ? null : jcommpanyName.trim();
    }

    public String getTypeC() {
        return typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC == null ? null : typeC.trim();
    }

    public String getJcommpanyType() {
        return jcommpanyType;
    }

    public void setJcommpanyType(String jcommpanyType) {
        this.jcommpanyType = jcommpanyType == null ? null : jcommpanyType.trim();
    }

    public String getJarea() {
        return jarea;
    }

    public void setJarea(String jarea) {
        this.jarea = jarea == null ? null : jarea.trim();
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
}