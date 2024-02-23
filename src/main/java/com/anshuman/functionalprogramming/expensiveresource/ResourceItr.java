package com.anshuman.functionalprogramming.expensiveresource;

public class ResourceItr {
    public ResourceItr() {
        System.out.println("created...");
    }

    public void op1() {
        System.out.println("op1");
    }

    public void op2() {
        System.out.println("op2");
    }

    public void close() {
        System.out.println("cleanup...");
    }

    public static void main(String[] args) {
        ResourceItr res = new ResourceItr();
        res.op1();
        res.op2();
        // you may or may not remember to call close() afterwards.
        res.close();

        // what if you want to ensure that some logic is always called beforehand?
    }
}


