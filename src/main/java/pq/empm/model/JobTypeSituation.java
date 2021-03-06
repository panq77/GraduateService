package pq.empm.model;

public class JobTypeSituation {
    private Long id;

    private String typeC;

    private String education;

    private Integer mailing;

    private Integer clickTimes;

    public JobTypeSituation() {
    }

    public JobTypeSituation(Long id, String typeC, String education, Integer mailing, Integer clickTimes) {
        this.id = id;
        this.typeC = typeC;
        this.education = education;
        this.mailing = mailing;
        this.clickTimes = clickTimes;
    }

    @Override
    public String toString() {
        return "JobTypeSituation{" +
                "id=" + id +
                ", typeC='" + typeC + '\'' +
                ", education='" + education + '\'' +
                ", mailing=" + mailing +
                ", clickTimes=" + clickTimes +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeC() {
        return typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC == null ? null : typeC.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public Integer getMailing() {
        return mailing;
    }

    public void setMailing(Integer mailing) {
        this.mailing = mailing;
    }

    public Integer getClickTimes() {
        return clickTimes;
    }

    public void setClickTimes(Integer clickTimes) {
        this.clickTimes = clickTimes;
    }
}