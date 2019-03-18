package hashtable;

public class HashTable {

    private StudentInfo[] data = new StudentInfo[1000];

    public static void main(String[] args) {

        StudentInfo s1 = new StudentInfo(16,3);
        StudentInfo s2 = new StudentInfo(17,11);
        StudentInfo s3 = new StudentInfo(18,23);
        StudentInfo s4 = new StudentInfo(19,24);
        StudentInfo s5 = new StudentInfo(20,9);

        HashTable hashTable = new HashTable();
        hashTable.put(s1);
        hashTable.put(s2);
        hashTable.put(s3);
        hashTable.put(s4);
        hashTable.put(s5);
        System.out.println(hashTable.get(new StudentInfo(18)));
    }


    public void put(StudentInfo studentInfo){
        int index = studentInfo.hashCode();
        data[index] = studentInfo;
    }

    public StudentInfo get(StudentInfo studentInfo){
        return data[studentInfo.getAge()];
    }
}
