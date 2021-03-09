package pq.empm.vo;

import io.searchbox.annotations.JestId;

public class EsJob {
    @JestId
    private String jid;
    private String jname;
    private String TypeC;
    private String education;
    private String jarea;
    private String salary;
    private String jcommpanyType;
    private String jcommpanyScale;
    private String data;

    public String getTypeC() {
        return TypeC;
    }

    public void setTypeC(String typeC) {
        TypeC = typeC;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJarea() {
        return jarea;
    }

    public void setJarea(String jarea) {
        this.jarea = jarea;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJcommpanyType() {
        return jcommpanyType;
    }

    public void setJcommpanyType(String jcommpanyType) {
        this.jcommpanyType = jcommpanyType;
    }

    public String getJcommpanyScale() {
        return jcommpanyScale;
    }

    public void setJcommpanyScale(String jcommpanyScale) {
        this.jcommpanyScale = jcommpanyScale;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public EsJob(String jid, String jname, String typeC, String education, String jarea, String salary, String jcommpanyType, String jcommpanyScale, String data) {
        this.jid = jid;
        this.jname = jname;
        TypeC = typeC;
        this.education = education;
        this.jarea = jarea;
        this.salary = salary;
        this.jcommpanyType = jcommpanyType;
        this.jcommpanyScale = jcommpanyScale;
        this.data = data;
    }

    @Override
    public String toString() {
        return "EsJob{" +
                "jid='" + jid + '\'' +
                ", jname='" + jname + '\'' +
                ", TypeC='" + TypeC + '\'' +
                ", education='" + education + '\'' +
                ", jarea='" + jarea + '\'' +
                ", salary='" + salary + '\'' +
                ", jcommpanyType='" + jcommpanyType + '\'' +
                ", jcommpanyScale='" + jcommpanyScale + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
