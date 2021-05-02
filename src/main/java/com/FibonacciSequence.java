package com;

import java.math.BigInteger;

public class FibonacciSequence {
    public static BigInteger[] getFibonacciSequence(int n) throws Exception {
        if (n < 0) throw new Exception("Number mustn't be negative");
        else if (n == 0) return new BigInteger[]{new BigInteger("0")};
        else if (n == 1) return new BigInteger[]{new BigInteger("0"), new BigInteger("1")};
        else {
            BigInteger[] array = new BigInteger[n+1];
            array[0] = new BigInteger("0");
            array[1] = new BigInteger("1");
            for (int i = 2; i <= n; i++) {
                array[i] = array[i-1].add(array[i-2]);
            }
            return array;
        }
    }

    public static BigInteger getFibonacciNumber(int n) throws Exception {
        if (n < 0) throw new Exception("Number mustn't be negative");
        else if (n == 0) return new BigInteger("0");
        else if (n == 1) return new BigInteger("1");
        else {
            BigInteger[] array = new BigInteger[n+1];
            array[0] = new BigInteger("0");
            array[1] = new BigInteger("1");
            for (int i = 2; i <= n; i++) {
                array[i] = array[i-1].add(array[i-2]);
            }
            return array[n];
        }
    }
}
