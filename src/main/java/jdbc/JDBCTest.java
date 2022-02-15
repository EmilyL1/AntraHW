package jdbc;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(JDBCUtils.connectionDetails,JDBCUtils.username,"");
            Statement stmt = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into profile values (?,?)")
                ){
            // Create
//            try{
//                connection.setAutoCommit(false);
//                String create = "create table profile (id int,name char(10), primary key(id))";
//                stmt.execute(create);
//                connection.commit();
//
//            }catch (SQLException e){
//                connection.rollback();
//                System.out.println(e);
//
//            }
            //insert
//            preparedStatement.setInt(1,1);
//            preparedStatement.setString(2,"a");
//            int rows =  preparedStatement.executeUpdate();
//            System.out.println(rows);
//
//            preparedStatement.setInt(1,2);
//            preparedStatement.setString(2,"aa");
//            preparedStatement.addBatch();
//            preparedStatement.setInt(1,3);
//            preparedStatement.addBatch();
//            int[] returncodes = preparedStatement.executeBatch();
//            for (int returncode : returncodes) {
//                System.out.println(returncode);
//            }
            //update
//            String update = "update profile set name = 'b' where name = 'a'";
//            stmt.execute(update);
            //read
//            String read = "select * from profile where name = 'aa'";
//            ResultSet resultSets = stmt.executeQuery(read);
//            while(resultSets.next()){
//                int id = resultSets.getInt("id");
//                String name = resultSets.getString("name");
//                System.out.println(id + " " + name);
//            }
            //delete
//            String delete = "delete from profile where name = 'b'";
//            stmt.execute(delete);
            //drop
//            String drop = "drop table profile";
//            stmt.execute(drop);



        }catch (SQLException e){

        }
    }
}
