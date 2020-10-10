/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jdbc.controller;

import com.mycompany.jdbc.IO.LoadAndShowList;
import com.mycompany.jdbc.IO.SaveListToFile;
import com.mycompany.jdbc.model.EmployeeModel;
import com.mycompany.jdbc.view.input.Output.EmployeeOuput;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MainController {

    private Scanner scanner = null;
    private EmployeeController employeeController = new EmployeeController();

    void showMenu() {
        scanner = new Scanner(System.in);
        System.out.println("1. Thêm mới nhân viên");
        System.out.println("2. Tìm nhân viên theo mã nhân viên");
        System.out.println("3. cập nhật nhân viên theo mã nhân viên");
        System.out.println("4. Xóa nhân viên theo mã nhân viên");
        System.out.println("5. Lấy tất cả nhân viên có trong danh sách");
        System.out.println("6. Lưu tất cả nhân viên vào file theo đường dẫn chỉ định");
        System.out.println("7. Lấy tất cả nhân viên từ File theo đường dẫn chỉ định");
        System.out.println("8. Thoát chương trình");
        System.out.println("Vui lòng nhận số tương ứng");
        int option = Integer.MAX_VALUE;
        do {
            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("kí tự bạn nhập không phải sô. vui lòng nhập lại");
                scanner = new Scanner(System.in);
            }
            if ((option <= 0 || option >= 8) && option != Integer.MAX_VALUE) {
                System.out.println("Số bạn nhập không nằm trong danh mục. Vui lòng nhập lại");
                scanner = new Scanner(System.in);
            }
        } while (option < 0 || option > 8);
        switch (option) {
            case 1:
                employeeController.insert();
                break;
            case 2:
                employeeController.searchById();
                
                break;
            case 3:
                employeeController.updateEmployee();
                break;
            case 4:
                employeeController.delById();
                break;
            case 5:
                List<EmployeeModel> result = employeeController.findAll();
                EmployeeOuput output = new EmployeeOuput();
                output.display(result);
                break;
            case 6:
                SaveListToFile saveListToFile = new SaveListToFile();
                saveListToFile.saveToFile();
                break;
            case 7:
                LoadAndShowList loadAndShow = new LoadAndShowList();
                loadAndShow.readFile();
                break;
            case 8:
                System.out.println("bye bye");
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        MainController mainController = new MainController();
        while (true) {
            mainController.showMenu();
        }
    }

}
