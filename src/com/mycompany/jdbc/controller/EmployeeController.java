/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jdbc.controller;

import com.mycompany.jdbc.model.EmployeeModel;
import com.mycompany.jdbc.util.ConnectDB;
import com.mycompany.jdbc.view.input.EmployeeInput;
import com.mycompany.jdbc.view.input.Output.EmployeeOuput;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class EmployeeController {

    private EmployeeInput employeeInput = new EmployeeInput();

    public void insert() {
        EmployeeModel employeeModel = employeeInput.infoInput();
        String sql = "INSERT INTO Employee(empCode,empName,empGender,empAge,empAddress) VALUES(?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;
        boolean flag = true;
        try {
            connection = ConnectDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, employeeModel.getId());
            statement.setString(2, employeeModel.getName());
            statement.setInt(3, employeeModel.getGerder());
            statement.setInt(4, employeeModel.getAge());
            statement.setString(5, employeeModel.getAddress());
            flag = statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void delById() {
        String code = employeeInput.getEmployeeCode();
        Connection connection = null;
        Statement statement = null;
        boolean flag = false;
        try {
            connection = ConnectDB.getConnection();
            String sqlDel = "DELETE FROM Employee WHERE empCode = '" + code + "'";
            statement = connection.createStatement();
            statement.execute(sqlDel);
            flag = true;
            if (flag == true) {
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Xóa thất bại");
            }
        } catch (SQLException ex) {           
                System.out.println(ex.getMessage());    
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (flag == true) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }

    public List<EmployeeModel> findAll() {
        List<EmployeeModel> result = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Employee";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String code = resultSet.getString("empCode");
                String name = resultSet.getString("empName");
                int gender = resultSet.getInt("empGender");
                int age = resultSet.getInt("empAge");
                String address = resultSet.getString("empAddress");
                EmployeeModel employeeModel = new EmployeeModel(code, name, gender, age, address);
                result.add(employeeModel);
            }
            return result;
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }

    public boolean updateEmployee() {
        EmployeeModel model = employeeInput.infoInput();
        Connection connection = null;
        PreparedStatement statement = null;
        boolean flag = true;
        try {
            connection = ConnectDB.getConnection();
            String sql = "UPDATE Employee set empCode = ?, empName = ?, empGender = ?, empAge = ?, empAddress = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, model.getId());
            statement.setString(2, model.getName());
            statement.setInt(3, model.getGerder());
            statement.setInt(4, model.getAge());
            statement.setString(5, model.getAddress());
            flag = statement.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return flag;
    }

    public EmployeeModel searchById() {
        String code = employeeInput.getEmployeeCode();
        EmployeeModel employeeModel = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectDB.getConnection();
            String sql = "SELECT * FROM Employee WHERE empCode = '" + code +"'";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String newCode = resultSet.getString("empCode");
                String name = resultSet.getString("empName");
                int gender = resultSet.getInt("empGender");
                int age = resultSet.getInt("empAge");
                String address = resultSet.getString("empAddress");
                employeeModel = new EmployeeModel(newCode, name, gender, age, address);
            }
            return employeeModel;
        } catch (SQLException ex) {
            
                System.out.println(ex.getMessage());
            
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return employeeModel;
    }
}
