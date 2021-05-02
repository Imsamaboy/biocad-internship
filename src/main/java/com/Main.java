package com;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Fibonacci number index: ");
        int number = Integer.parseInt(in.nextLine());
        System.out.println(FibonacciSequence.getFibonacciNumber(number));
        System.out.print("Enter path to JSON file: ");
        String path = in.nextLine(); //"E:\\Java\\biocad_intership\\src\\main\\java\\test.json";
        in.close();
        try {
            JsonFileReader.showJsonData(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
