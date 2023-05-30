import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
//        writeDataToFile("student.txt",students);
        List<Student> results = readDataToFile("student.txt");
        for (Student s:results){
            System.out.println(s);
        }
    }

    public static void writeDataToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readDataToFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fos=new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fos);
            students =(List<Student>) ois.readObject();
            fos.close();
            ois.close();
        }catch (IOException | ClassNotFoundException e){
            e.getMessage();
        }
        return students;
    }
}