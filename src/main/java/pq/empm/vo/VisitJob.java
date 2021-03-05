package pq.empm.vo;

public class VisitJob {
    private String jid;
    private String jname;
    private String jcommanyName;

    public VisitJob() {
    }

    public String getJid() {
        return jid;
    }

    @Override
    public String toString() {
        return "VisitJob{" +
                "jid='" + jid + '\'' +
                ", jname='" + jname + '\'' +
                ", jcommanyName='" + jcommanyName + '\'' +
                '}';
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

    public String getJcommanyName() {
        return jcommanyName;
    }

    public void setJcommanyName(String jcommanyName) {
        this.jcommanyName = jcommanyName;
    }

    public VisitJob(String jid, String jname, String jcommanyName) {
        this.jid = jid;
        this.jname = jname;
        this.jcommanyName = jcommanyName;
    }
}
