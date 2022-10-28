import java.sql.*;
import java.util.Scanner;
//LOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
//OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
public class Main {
    public static Connection connect(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Could Not Connect to Server!");
            e.getCause();
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            e.printStackTrace();
        }
        return connection;
    }

    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/movie";
    private static final String QUERY = "SELECT ID, Firstname, Lastname FROM ACTOR";


    public static void main(String[] args) throws SQLException {

        Connection con= connect();
        Statement stmt  = con.createStatement();
        ResultSet rs =stmt.executeQuery(QUERY);
        //3)
        while (rs.next()){
            System.out.print("ID: " + rs.getInt("ID"));
            System.out.print(", First: " + rs.getString("Firstname"));
            System.out.println(", Last: " + rs.getString("Lastname"));
        }
        Scanner myObj = new Scanner(System.in);


     //2)
        /*
        stmt.executeUpdate("insert into ACTOR (Firstname, Lastname) VALUES" +
                "('"+myObj.nextLine()+"','"+myObj.nextLine()+"')");
        stmt.executeUpdate("insert into ACTOR (Firstname, Lastname) VALUES" +
                "('"+myObj.nextLine()+"','"+myObj.nextLine()+"')");
        stmt.executeUpdate("insert into ACTOR (Firstname, Lastname) VALUES" +
                "('"+myObj.nextLine()+"','"+myObj.nextLine()+"')");
        */
        //4) increase budget by one
        /*
        stmt.executeUpdate("update STUDIO set Budget=Budget+1;");



         */
        //3), 5)
        ResultSet rs1 =stmt.executeQuery("SELECT ID, Studioname, Budget, Foundationdate FROM STUDIO WHERE Budget>7");
        while (rs1.next()){
            System.out.print("ID: " + rs1.getInt("ID"));
            System.out.print(", Studioname: " + rs1.getString("Studioname"));
            System.out.println(", Budget: " + rs1.getString("Budget"));
            System.out.println(", Foundationdate: " + rs1.getString("Foundationdate"));
        }



    }

}