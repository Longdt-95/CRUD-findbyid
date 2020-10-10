/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jdbc.IO;

import com.mycompany.jdbc.controller.EmployeeController;
import com.mycompany.jdbc.model.EmployeeModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SaveListToFile {

    public boolean saveToFile() {
        EmployeeController controller = new EmployeeController();
        List<EmployeeModel> employees = controller.findAll();
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        FileOutputStream fos = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fos = new FileOutputStream(path);

            try {
                objectOutputStream = new ObjectOutputStream(fos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (EmployeeModel model : employees) {
                try {
                    objectOutputStream.writeObject(model);
                    objectOutputStream.write("\n".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(SaveListToFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
