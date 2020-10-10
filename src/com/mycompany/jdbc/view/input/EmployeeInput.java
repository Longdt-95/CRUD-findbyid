/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jdbc.view.input;

import com.mycompany.jdbc.model.EmployeeModel;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class EmployeeInput {
    
    private Scanner scanner = null;
    
    public EmployeeModel infoInput() {
        System.out.println("Nhập mã nhân viên:");
        scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        System.out.println("Nhập tên nhân viên:");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính nhân viên:");
        scanner = new Scanner(System.in);
        int gender = scanner.nextInt();
        System.out.println("Nhập tuổi nhân viên:");
        scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        System.out.println("Nhập địa chỉ:");
        scanner = new Scanner(System.in);
        String address = scanner.nextLine();
        EmployeeModel employeeMode = new EmployeeModel(id, name, gender, age, address);
        return employeeMode;
    }
    
    public String getEmployeeCode() {
        System.out.println("Mời bạn nhập mã nhân viên");
        scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        return code;
    }
}
