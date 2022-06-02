import dao.SQLConnect;
import dto.SQLRequests;

public class Main {
    public static void main(String[] args) {
        SQLConnect connection = new SQLConnect();
        SQLRequests requests = new SQLRequests(connection.getConnect());
          requests.getAllStudents();
        requests.findAStudentByForName("Maks");
    }
}
