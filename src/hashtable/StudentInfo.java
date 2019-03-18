package hashtable;

public class StudentInfo {

    private int age;

    private int count;

    public StudentInfo(){}

    public StudentInfo(int age) {
        this.age = age;
    }

    public StudentInfo(int age, int count) {
        this.age = age;
        this.count = count;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public int hashCode(){
        return age;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "age=" + age +
                ", count=" + count +
                '}';
    }
}
