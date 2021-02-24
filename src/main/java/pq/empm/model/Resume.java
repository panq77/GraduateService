package pq.empm.model;

public class Resume {
    private Integer rid;

    private String newname;

    private String name;

    private Integer uid;

    private Integer pid;

    private String jid;

    private String jname;

    private String url;

    private String stat;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getNewname() {
        return newname;
    }

    public void setNewname(String newname) {
        this.newname = newname == null ? null : newname.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    @Override
    public String toString() {
        return "Resume{" +
                "rid=" + rid +
                ", newname='" + newname + '\'' +
                ", name='" + name + '\'' +
                ", uid=" + uid +
                ", pid=" + pid +
                ", jid='" + jid + '\'' +
                ", jname='" + jname + '\'' +
                ", url='" + url + '\'' +
                ", stat='" + stat + '\'' +
                '}';
    }
}