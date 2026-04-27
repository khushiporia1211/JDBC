import java.sql.*;
import java.util.Scanner;

public class TransactionHandling {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/lenden";
    private static final String username = "root";
    private static final String password = "k2H@ushi12";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            String debit_query = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
            String credit_query = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
            PreparedStatement debitPS = connection.prepareStatement(debit_query);
            PreparedStatement creditPS = connection.prepareStatement(credit_query);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter account number: ");
            int account_number = sc.nextInt();
            System.out.println("Enter amount: ");
            double amount = sc.nextDouble();

            debitPS.setDouble(1,amount);
            debitPS.setInt(2,account_number);

            creditPS.setDouble(1,amount);
            creditPS.setInt(2,102);

            debitPS.executeUpdate();
            creditPS.executeUpdate();
            if(isSufficient(connection,account_number,amount)){
                connection.commit();
                System.out.println("Transaction successful");
            }else{
                connection.rollback();
                System.out.println("Transaction failed");
            }
            debitPS.close();
            creditPS.close();
            connection.close();
            sc.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    static boolean isSufficient(Connection connection,int account_number,double amount){
        try{
            String query = "SELECT balance FROM accounts WHERE account_number = ?";
            PreparedStatement prestmt = connection.prepareStatement(query);
            prestmt.setInt(1,account_number);
            ResultSet rs = prestmt.executeQuery();
            if(rs.next()){
                double current_balance = rs.getDouble("balance");
                if(amount>current_balance){
                    return false;
                }else{
                    return true;
                }
            }
            rs.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
