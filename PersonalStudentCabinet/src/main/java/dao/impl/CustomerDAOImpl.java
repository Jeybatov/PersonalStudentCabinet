package dao.impl;

import dao.CustomerDAO;
import database.Hash;
import database.Provider;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {

    static Connection connection;
    static PreparedStatement preparedStatement;
    @Override
    public int insertCustomer(Customer customer) {
        String pass = Hash.hash(customer.getPassword());

        int status = 0;
        try{
            connection= Provider.getConnection();
            preparedStatement=connection.prepareStatement("insert into student values(?,?,?,?,?,?)");
            preparedStatement.setString(1,customer.getEmail());
            preparedStatement.setString(2,pass);
            preparedStatement.setString(3,customer.getFirstName());
            preparedStatement.setString(4,customer.getLastName());
            preparedStatement.setInt(5,customer.getAge());
            preparedStatement.setString(6,customer.getGender());

            status = preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return status;
    }

    @Override
    public Customer getCustomer(String userId, String pass) throws SQLException {
        Customer customer = new Customer();
        try{
            connection=Provider.getConnection();
            preparedStatement = connection.prepareStatement("select * from student where userid=? and password=?");
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                customer.setEmail(resultSet.getString(1));
                customer.setPassword(resultSet.getString(2));
                customer.setFirstName(resultSet.getString(3));
                customer.setLastName(resultSet.getString(4));
                customer.setAge(resultSet.getInt(5));
                customer.setGender(resultSet.getString(6));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        connection.close();
        preparedStatement.close();


        return customer;
    }
}
