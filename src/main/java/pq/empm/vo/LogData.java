package pq.empm.vo;

public class LogData {
    private int uid=0;
    private String uname=null;
    private int age=0;
    private int gender=0;
    private String expectedJob=null;
    private String expectedArea=null;
    private String education=null;
    private String hasExperience=null;
    private String actType=null;
    private String jid=null;
    private String jname=null;
    private String typeA=null;
    private String typeB=null;
    private String typeC=null;
    private String salary=null;
    private String reqEducation=null;
    private String jcommpanyName=null;
    private String jcommpanyType=null;
    private String jcommpanyScale=null;
    private String jarea=null;
    private int pid=0;
    private String queryKey=null;
    private int isSuccess=0;

    public LogData(int uid, String uname, int age, int gender,
                   String expectedJob, String expectedArea, String education,
                   String hasExperience, String actType, String jid, String jname,
                   String typeA, String typeB, String typeC, String salary, String reqEducation, String jcommpanyName,
                   String jcommpanyType, String jcommpanyScale, String jarea, int pid, String queryKey, int isSuccess) {
        this.uid = uid;
        this.uname = uname;
        this.age = age;
        this.gender = gender;
        this.expectedJob = expectedJob;
        this.expectedArea = expectedArea;
        this.education = education;
        this.hasExperience = hasExperience;
        this.actType = actType;
        this.jid = jid;
        this.jname = jname;
        this.typeA = typeA;
        this.typeB = typeB;
        this.typeC = typeC;
        this.salary = salary;
        this.reqEducation = reqEducation;
        this.jcommpanyName = jcommpanyName;
        this.jcommpanyType = jcommpanyType;
        this.jcommpanyScale = jcommpanyScale;
        this.jarea = jarea;
        this.pid = pid;
        this.queryKey = queryKey;
        this.isSuccess = isSuccess;
    }

    public LogData(int uid, String uname, int age, int gender, String expectedJob, String expectedArea, String education,
                   String hasExperience, String actType, String jid, String jname,String typeC,  String salary,
                    String jcommpanyName, String jcommpanyType, String jcommpanyScale,
                   String jarea, int pid) {
        this.uid = uid;
        this.uname = uname;
        this.age = age;
        this.gender = gender;
        this.expectedJob = expectedJob;
        this.expectedArea = expectedArea;
        this.education = education;
        this.hasExperience = hasExperience;
        this.actType = actType;
        this.jid = jid;
        this.jname = jname;
        this.typeC=typeC;
        this.salary = salary;

        this.jcommpanyName = jcommpanyName;
        this.jcommpanyType = jcommpanyType;
        this.jcommpanyScale = jcommpanyScale;
        this.jarea = jarea;
        this.pid = pid;
    }



    public LogData(int uid, String uname, int age, int gender, String expectedJob, String expectedArea,
                   String education, String hasExperience, String actType, String jid, String jname,String typeC,int pid) {
        this.uid = uid;
        this.uname = uname;
        this.age = age;
        this.gender = gender;
        this.expectedJob = expectedJob;
        this.expectedArea = expectedArea;
        this.education = education;
        this.hasExperience = hasExperience;
        this.actType = actType;
        this.jid = jid;
        this.jname = jname;
        this.typeC=typeC;
        this.pid = pid;
    }



    public LogData(int uid, String uname, int age, int gender, String expectedJob,
                   String expectedArea, String education, String hasExperience,
                   String actType, String typeC, String salary,
                   String jcommpanyType, String jcommpanyScale,
                   String jarea, String queryKey) {
        this.uid = uid;
        this.uname = uname;
        this.age = age;
        this.gender = gender;
        this.expectedJob = expectedJob;
        this.expectedArea = expectedArea;
        this.education = education;
        this.hasExperience = hasExperience;
        this.actType = actType;
        this.typeC = typeC;
        this.salary = salary;
        this.jcommpanyType = jcommpanyType;
        this.jcommpanyScale = jcommpanyScale;
        this.jarea = jarea;
        this.queryKey = queryKey;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getExpectedJob() {
        return expectedJob;
    }

    public void setExpectedJob(String expectedJob) {
        this.expectedJob = expectedJob;
    }

    public String getExpectedArea() {
        return expectedArea;
    }

    public void setExpectedArea(String expectedArea) {
        this.expectedArea = expectedArea;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHasExperience() {
        return hasExperience;
    }

    public void setHasExperience(String hasExperience) {
        this.hasExperience = hasExperience;
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
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

    public String getTypeA() {
        return typeA;
    }

    public void setTypeA(String typeA) {
        this.typeA = typeA;
    }

    public String getTypeB() {
        return typeB;
    }

    public void setTypeB(String typeB) {
        this.typeB = typeB;
    }

    public String getTypeC() {
        return typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getReqEducation() {
        return reqEducation;
    }

    public void setReqEducation(String reqEducation) {
        this.reqEducation = reqEducation;
    }

    public String getJcommpanyName() {
        return jcommpanyName;
    }

    public void setJcommpanyName(String jcommpanyName) {
        this.jcommpanyName = jcommpanyName;
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

    public String getJarea() {
        return jarea;
    }

    public void setJarea(String jarea) {
        this.jarea = jarea;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getQueryKey() {
        return queryKey;
    }

    public void setQueryKey(String queryKey) {
        this.queryKey = queryKey;
    }

    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }

    @Override
    public String toString() {
        return "LogData{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", expectedJob='" + expectedJob + '\'' +
                ", expectedArea='" + expectedArea + '\'' +
                ", education='" + education + '\'' +
                ", hasExperience='" + hasExperience + '\'' +
                ", actType='" + actType + '\'' +
                ", jid='" + jid + '\'' +
                ", jname='" + jname + '\'' +
                ", typeA='" + typeA + '\'' +
                ", typeB='" + typeB + '\'' +
                ", typeC='" + typeC + '\'' +
                ", salary='" + salary + '\'' +
                ", reqEducation='" + reqEducation + '\'' +
                ", jcommpanyName='" + jcommpanyName + '\'' +
                ", jcommpanyType='" + jcommpanyType + '\'' +
                ", jcommpanyScale='" + jcommpanyScale + '\'' +
                ", jarea='" + jarea + '\'' +
                ", pid=" + pid +
                ", queryKey='" + queryKey + '\'' +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
