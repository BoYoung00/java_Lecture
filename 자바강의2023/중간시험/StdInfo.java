package 자바강의2023.중간시험;

class StdInfo {
    private String name;
    private int number;
    private String score;

    public StdInfo(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public StdInfo(String name, int number, String score) {
        this.name = name;
        this.number = number;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }


    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = this.score + "\\" + score;
    }

    @Override
    public String toString() {
        return "StdInfo{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", score='" + score + '\'' +
                '}';
    }
}
