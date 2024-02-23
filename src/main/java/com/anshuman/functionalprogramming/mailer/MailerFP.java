package com.anshuman.functionalprogramming.mailer;

import java.util.function.Consumer;

public class MailerFP {

    public static void print(String msg) {
        System.out.println(msg);
    }

    public MailerFP from(String addr) {
        print(addr);
        return this;
    }

    public MailerFP to(String addr) {
        print(addr);
        return this;
    }

    public MailerFP subject(String line) {
        print(line);
        return this;
    }

    public MailerFP body(String msg) {
        print(msg);
        return this;
    }

    //NOTICE: WE ARE USING A FUNCTION as the method argument
    public static void send(Consumer<MailerFP> block) {
        MailerFP mailer = new MailerFP(); // mailer object is not created until you are sending the mail.
        System.out.println("sending... ");
        block.accept(mailer); // The function supplied in the method argument is called here.
    }

    public static void main(String[] args) {

        /* Why this is better:
         * 1. You are not allowing to create the mailer object directly. Mailer cannot exist outside the scope of the "send" function.
         * 2. Solves the issue of worrying about use/reuse of an existing object and maintaining its state.
         * 3. You don't have to write mailer again and again.
         */
        MailerFP.send(
                mailer -> mailer.from("everyone@theworld.com")
                        .to("you@yourcompany.com")
                        .subject("your code sucks")
                        .body("but not as much today")
        );

    }
}
