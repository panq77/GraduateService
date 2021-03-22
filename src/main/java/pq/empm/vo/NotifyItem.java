package pq.empm.vo;

public class NotifyItem {
    private Integer rid;
    private String jid;
    private String jname;
    private  String stat;

    @Override
    public String toString() {
        return "NotifyItem{" +
                "rid=" + rid +
                ", jid='" + jid + '\'' +
                ", jname='" + jname + '\'' +
                ", stat='" + stat + '\'' +
                '}';
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
