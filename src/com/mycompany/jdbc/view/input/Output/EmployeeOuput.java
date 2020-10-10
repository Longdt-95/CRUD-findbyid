/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jdbc.view.input.Output;

import com.mycompany.jdbc.model.EmployeeModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class EmployeeOuput {
   public void display(List<EmployeeModel> employeeModel) {
        for (EmployeeModel model : employeeModel) {
            System.out.println("tên nhân viên: " + model.getName());
            System.out.println("ma nhân viên: " + model.getId());
        }
    }
}
