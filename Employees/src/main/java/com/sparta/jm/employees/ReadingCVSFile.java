package com.sparta.jm.employees;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class ReadingCVSFile {
    private final String samplefileName = "Resources/EmployeeRecords.csv";
    private final String fileName = "Resources/FullEmployeeRecords.csv";
    private Employee employee;
    private static Map<String, Employee> employees = new HashMap<>();
    private static Map<String, Employee> employeesDuplicateList = new HashMap<>();


    public Map<String, Employee> readFile() {
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(fileName));
            bufferedReader.readLine();
            bufferedReader.lines()
                    .map(elementsOfEmployee -> elementsOfEmployee.split(","))
                    .forEach(elementsOfEmployee -> employees.put(elementsOfEmployee[0], new Employee(elementsOfEmployee[0], elementsOfEmployee[1],
                            elementsOfEmployee[2], elementsOfEmployee[3], elementsOfEmployee[4], elementsOfEmployee[5], elementsOfEmployee[6],
                            formateDate(elementsOfEmployee[7]), formateDate(elementsOfEmployee[8]), Integer.parseInt(elementsOfEmployee[9]))));
//           String line;
//           while((line = bufferedReader.readLine()) != null){
//               String[] elementsOfEmployee = line.split(",");
//               Employee employee = employees.put(elementsOfEmployee[0], new Employee(elementsOfEmployee[0], elementsOfEmployee[1], elementsOfEmployee[2], elementsOfEmployee[3], elementsOfEmployee[4], elementsOfEmployee[5], elementsOfEmployee[6],
//                            formateDate(elementsOfEmployee[7]), formateDate(elementsOfEmployee[8]), Integer.parseInt(elementsOfEmployee[9])));
//               if (employees.containsKey(elementsOfEmployee[0])){
//                   employeesDuplicateList.put(elementsOfEmployee[0], employee);
//               }else {
//                   employees.put(elementsOfEmployee[0],employee);
//               }
//            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '" + fileName + "'");
        }
        return employees;
    }
    private LocalDate formateDate(String formatter) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate localDate = LocalDate.parse(formatter, dateTimeFormatter);
        return localDate;
    }
}


