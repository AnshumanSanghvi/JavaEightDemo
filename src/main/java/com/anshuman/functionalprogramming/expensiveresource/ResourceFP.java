package com.anshuman.functionalprogramming.expensiveresource;

import java.util.function.Consumer;

public class ResourceFP {
    private ResourceFP(String bucketName) {
        System.out.println("created...");
    }

    public ResourceFP op1() {
        System.out.println("op1");
        return this;
    }

    public ResourceFP op2() {
        System.out.println("op2");
        return this;
    }

    private void close() {
        System.out.println("cleanup...");
    }

    public static void use(Consumer<ResourceFP> block, String bucketName) {

        // FORCE "Before" behaviour, e.g: instantiate resource, establish client connection, validate bucket name etc.
        ResourceFP resourceFP = new ResourceFP(bucketName);
        try {
            block.accept(resourceFP);
        } finally {
            // FORCE "After" behaviour, e.g: close the resource client gracefully.
            resourceFP.close();
        }
    }

    public static void main(String[] args) {
        // Resource object cannot be directly created by the user
        // Great for exception handling, closing resources gracefully
        //
        ResourceFP.use(res -> res.op1().op2(), "MyS3Bucket");

    }

}
