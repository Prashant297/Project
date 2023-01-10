package core_java_problem_solution.exam_result;

public class Subject {

    String name;
    int rollNo;
    int englishMark;
    int scienceMark;
    int hindiMark;
    int mathMark;
    double percentage;

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getEnglishMark() {
        return englishMark;
    }

    public void setEnglishMark(int englishMark) {
        this.englishMark = englishMark;
    }

    public int getScienceMark() {
        return scienceMark;
    }

    public void setScienceMark(int scienceMark) {
        this.scienceMark = scienceMark;
    }

    public int getHindiMark() {
        return hindiMark;
    }

    public void setHindiMark(int hindiMark) {
        this.hindiMark = hindiMark;
    }

    public int getMathMark() {
        return mathMark;
    }

    public void setMathMark(int mathMark) {
        this.mathMark = mathMark;
    }
}
