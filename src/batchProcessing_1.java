import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class batchProcessing_1 {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/mydb";
    private static final String username="root";
    private static final String password = "your paasword";

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.print("Enter name: ");
                String name = sc.next();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                System.out.print("Enter Marks: ");
                Double marks = sc.nextDouble();
                System.out.print("Enter More Data(Y/N): ");
                String choice = sc.next();

                String query = String.format("INSERT INTO students(name,age,marks) VALUES('%s',%d,%f)",name,age,marks);
                statement.addBatch(query);
                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }
            int[] arr = statement.executeBatch();
            for(int i = 0; i <arr.length; i++){
                if(arr[i]==0){
                    System.out.println("Query "+i+" not executed successfully");
                }
            }


        }catch(SQLException e){
            System.out.println(e.getMessage());

        }
    }

}
