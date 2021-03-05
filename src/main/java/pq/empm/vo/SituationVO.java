package pq.empm.vo;

public class SituationVO {
    private String typeC;

    private String education;

    private Integer mailing;
    private Integer clickTimes;

    @Override
    public String toString() {
        return "SituationVO{" +
                "typeC='" + typeC + '\'' +
                ", education='" + education + '\'' +
                ", mailing=" + mailing +
                ", clickTimes=" + clickTimes +
                '}';
    }

    public String getTypeC() {
        return typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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
