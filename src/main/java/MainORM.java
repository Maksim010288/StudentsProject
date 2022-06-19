import db.orm.entity.MySessionFactory;
import db.orm.entity.StudentEntity;
import org.hibernate.Session;
import service.converter.StudentConverter;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainORM {
   private static List<StudentEntity> outList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MySessionFactory factory = new MySessionFactory();
        Session session = factory.getSessionOpen();
        outList = getStudentEntityLis(studentEntity(scanner));
        students(outList, factory, session);
        factory.getSessionClose(session);
    }

    private static StudentEntity studentEntity(Scanner scanner) {
        System.out.print("Введіть імя - ");
        String name = scanner.next();
        System.out.print("Введіть фамілію - ");
        String surName = scanner.next();
        System.out.print("Введіть курс - ");
        int course = scanner.nextInt();
        return new StudentEntity(name, surName, course);
    }

    private static List<StudentEntity> getStudentEntityLis(StudentEntity studentEntity) {
        List<StudentEntity> list = new LinkedList<>();
        list.add(studentEntity);
        return list;
    }


    public static MySessionFactory students(List<StudentEntity> outList,
                                            MySessionFactory factory,
                                            Session session) {
        for (StudentEntity student : outList) {
            factory.getSave(session, student);
        }
        return factory;
    }
}
