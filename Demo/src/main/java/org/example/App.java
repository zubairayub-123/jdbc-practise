package org.example;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//       System.out.println( "Hello World!" );

        try {
            //step 1: register the driver
            Class.forName("com.mysql.jdbc.Driver");

            //step 2: connection object creation
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store","root", "pass@word1");

            //step 3:statement object creation
            Statement statement = connection.createStatement();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into Customers(first_name, last_name, birth_date, address, city, state)\n" +
                    "Values (?, ?, ?, ?,?, ?)");
            preparedStatement.setString(1,"nkdebug");
            preparedStatement.setString(2,"blr");
            preparedStatement.setString(3,"1990-01-01");
            preparedStatement.setString(4,"2nd Main Road Kasturi Nagar");
            preparedStatement.setString(5,"blr");
            preparedStatement.setString(6,"KA");


            //step 4: execution of query

             int res = preparedStatement.executeUpdate();
            System.out.println(res + " "+ "records updated");

//            PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE Customers set first_name=? where customer_id=?");
//            preparedStatement1.setString(1, "pkdebug");
//            preparedStatement1.setInt(2, 13);
//            int res = preparedStatement1.executeUpdate();
//            System.out.println(res + " "+ "records updated");


//            int result = statement.executeUpdate("ALTER TABLE customers\n" + " add Email varchar(255);");
//            System.out.println(result + " "+ "records updated");

            // scrollable resultset
//            ResultSet resultSet = statement.executeQuery("select * from customers");
//            resultSet.absolute(6);
//            System.out.println(resultSet.getInt(1) + " "+ resultSet.getString(2) + " "+ resultSet.getString(8));

            // DELETE
//            int result = statement.executeUpdate("DELETE from Customers where customer_id=12");
//            System.out.println(result + " "+ "records updated");

            // UPDATE

//            int result = statement.executeUpdate("UPDATE Customers set first_name='virat' where customer_id=13");
//            System.out.println(result + " "+ "records updated");

//            int result = statement.executeUpdate("UPDATE Customers set Email='rohitt@18' where customer_id=13");
//           System.out.println(result + " "+ "records updated");



            // CREATE
//            int result = statement.executeUpdate("INSERT into Customers(first_name, last_name, birth_date, address, city, state, Email)\n" +
//                    "Values ('rohit', 'sharma', '1992-10-30', 'mumbai','city', 'IN', 'Virat@18')");
//            System.out.println(result + " "+ "records updated");

            //read
//            ResultSet resultSet = statement.executeQuery("select * from customers");
//            while(resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + " "+ resultSet.getString(2) + " "+ resultSet.getString(8));
//            }

            //step 5: close connection
            connection.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
