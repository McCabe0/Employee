//package com.sparta.jm.controller;
//
//import com.sparta.jm.employees.Employee;
//import com.sparta.jm.employees.InsertingUsers;
//import com.sparta.jm.employees.ReadingCVSFile;
//
//import java.util.Arrays;
//import java.util.Map;
//
//public class ThreadManger {
//
//    //Create an array of threads
//    // Create an array to go through it all
//    //
//
//    public void readWithThread(){
//
////        Thread thread1 = new Thread(new InsertingUsers());
////        thread1.start();
////       // Thread threadtwo =  new Thread(new InsertingUsers());
////       // threadtwo.start();
//    }
//
//    public void addEmpsToDB(Map<String, Employee> employeeMap){
//        Employee[] arrayofEmps = employeeMap.values().toArray(new Employee[employeeMap.size()]);
//        Thread[] threadsArray = new Thread[100];
//        int employeeCount = arrayofEmps.length;
//        int threadCount = threadsArray.length;
//        int factor = employeeCount/threadCount;
//        for (int i = 0; i < threadsArray.length; i++){
//            final  int j = i;
//            Runnable run = () -> insert(Arrays.copyOfRange(arrayofEmps, factor*j , factor*(j+1)));
//            threadsArray[i] = new Thread(run);
//            threadsArray[i].start();
//        }
//    }
//    public void insert(Employee[] employees){
//
//    }
//
//}
