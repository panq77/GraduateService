package pq.empm.vo;

public class ReceiveItem {
    private int rid;
    private String jname;
    private String name;

    public ReceiveItem(int rid, String jname, String name) {
        this.rid = rid;
        this.jname = jname;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReceiveItem{" +
                "rid=" + rid +
                ", jname='" + jname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
