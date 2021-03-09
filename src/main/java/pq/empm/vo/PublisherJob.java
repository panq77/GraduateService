package pq.empm.vo;

public class PublisherJob {
    private String jid;
    private String name;
    private String jarea;
    private String experience;
    private String education;
    private String stat;

    @Override
    public String toString() {
        return "PublisherJob{" +
                "jid='" + jid + '\'' +
                ", name='" + name + '\'' +
                ", jarea='" + jarea + '\'' +
                ", experience='" + experience + '\'' +
                ", education='" + education + '\'' +
                ", stat='" + stat + '\'' +
                '}';
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJarea() {
        return jarea;
    }

    public void setJarea(String jarea) {
        this.jarea = jarea;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
