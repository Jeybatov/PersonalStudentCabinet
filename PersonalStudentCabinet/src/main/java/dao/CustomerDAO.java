package dao;

import model.Customer;

import java.sql.SQLException;

public interface CustomerDAO {
    public int insertCustomer(Customer customer);
    public Customer getCustomer(String email,String pass) throws SQLException;
}
