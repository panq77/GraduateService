package pq.empm.util;

public class SearchCondition {
    private String text;
    private String type;
    private String salary;
    private String education;
    private String jcommpanyType;
    private String jcommpanyScale;
    private String jarea;
    private Integer page=1;
    private Integer rows=5;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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


    @Override
    public String toString() {
        return "SearchCondition{" +
                "text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", salary='" + salary + '\'' +
                ", education='" + education + '\'' +
                ", jcommpanyType='" + jcommpanyType + '\'' +
                ", jcommpanyScale='" + jcommpanyScale + '\'' +
                ", jarea='" + jarea + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
