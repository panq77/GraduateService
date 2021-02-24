package pq.empm.model;

public class Job {
    private String jid;

    private String name;

    private String typeA;

    private String typeB;

    private String typeC;

    private String salary;

    private String experience;

    private String education;

    private String jcommpanyName;

    private String jcommpanyType;

    private String jcommpanyScale;

    private String jarea;

    private String interviewer;

    private String jobDuty;

    private String jobRequest;

    private String jcommpanyIntro;

    private int pid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid == null ? null : jid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTypeA() {
        return typeA;
    }

    public void setTypeA(String typeA) {
        this.typeA = typeA == null ? null : typeA.trim();
    }

    public String getTypeB() {
        return typeB;
    }

    public void setTypeB(String typeB) {
        this.typeB = typeB == null ? null : typeB.trim();
    }

    public String getTypeC() {
        return typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC == null ? null : typeC.trim();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience == null ? null : experience.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getJcommpanyName() {
        return jcommpanyName;
    }

    public void setJcommpanyName(String jcommpanyName) {
        this.jcommpanyName = jcommpanyName == null ? null : jcommpanyName.trim();
    }

    public String getJcommpanyType() {
        return jcommpanyType;
    }

    public void setJcommpanyType(String jcommpanyType) {
        this.jcommpanyType = jcommpanyType == null ? null : jcommpanyType.trim();
    }

    public String getJcommpanyScale() {
        return jcommpanyScale;
    }

    public void setJcommpanyScale(String jcommpanyScale) {
        this.jcommpanyScale = jcommpanyScale == null ? null : jcommpanyScale.trim();
    }

    public String getJarea() {
        return jarea;
    }

    public void setJarea(String jarea) {
        this.jarea = jarea == null ? null : jarea.trim();
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer == null ? null : interviewer.trim();
    }

    public String getJobDuty() {
        return jobDuty;
    }

    public void setJobDuty(String jobDuty) {
        this.jobDuty = jobDuty == null ? null : jobDuty.trim();
    }

    public String getJobRequest() {
        return jobRequest;
    }

    public void setJobRequest(String jobRequest) {
        this.jobRequest = jobRequest == null ? null : jobRequest.trim();
    }

    public String getJcommpanyIntro() {
        return jcommpanyIntro;
    }

    public void setJcommpanyIntro(String jcommpanyIntro) {
        this.jcommpanyIntro = jcommpanyIntro == null ? null : jcommpanyIntro.trim();
    }

    @Override
    public String toString() {
        return "Job{" +
                "jid='" + jid + '\'' +
                ", name='" + name + '\'' +
                ", typeA='" + typeA + '\'' +
                ", typeB='" + typeB + '\'' +
                ", typeC='" + typeC + '\'' +
                ", salary='" + salary + '\'' +
                ", experience='" + experience + '\'' +
                ", education='" + education + '\'' +
                ", jcommpanyName='" + jcommpanyName + '\'' +
                ", jcommpanyType='" + jcommpanyType + '\'' +
                ", jcommpanyScale='" + jcommpanyScale + '\'' +
                ", jarea='" + jarea + '\'' +
                ", interviewer='" + interviewer + '\'' +
                ", jobDuty='" + jobDuty + '\'' +
                ", jobRequest='" + jobRequest + '\'' +
                ", jcommpanyIntro='" + jcommpanyIntro + '\'' +
                ", pid=" + pid +
                '}';
    }
}