package com.anshuman.functionalprogramming.fluent;

class MailerItr {
    public static void print(String msg) {
        System.out.println(msg);
    }

    public void from(String addr) {
        print(addr);
    }

    public void to(String addr) {
        print(addr);
    }

    public void subject(String line) {
        print(line);
    }

    public void body(String msg) {
        print(msg);
    }

    public void send() {
        System.out.println("sending... ");
    }

    public static void main(String[] args) {

        /*
         * Why this is bad:
         * 1. You don't know the state of the mailer object. If you want to send another mail, do you create a new object? or reuse the existing one?
         * 2. It's annoying to write mailer over and over.
         *
         */
        MailerItr mailer = new MailerItr();
        mailer.from("everyone@theworld.com");
        mailer.to("you@yourcompany.com");
        mailer.subject("your code sucks");
        mailer.body("for this reason today");
        mailer.send();

    }

}
