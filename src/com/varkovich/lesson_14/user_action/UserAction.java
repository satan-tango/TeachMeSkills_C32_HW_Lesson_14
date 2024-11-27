package com.varkovich.lesson_14.user_action;

import java.util.Scanner;

public class UserAction {

    public static String getFilePathFromUser() {
        Scanner console = new Scanner(System.in);
        String filePath = "";

        System.out.print("Enter file path: ");
        filePath = console.next();

        return filePath;
    }
}
