package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    /**
     * we created an array to put our book. We can add max 20 books to this array
     * in the following I didn`t explain every single line because method, object and variable names are clear enough
     */
    private static Book[] books = new Book[20];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBooks();

        while (true) {
            displayMainMenu();
        }
    }

    private static void initializeBooks() {
        books[0] = new Book(111, "first", "firstbook", true, "Furkan");
        books[1] = new Book(112, "second", "secondebook", true, "Ray");
        books[2] = new Book(113, "third", "thirdbook", true, "Kor");
        books[3] = new Book(114, "4th", "4thtbook", true, "Es");
        books[4] = new Book(115, "5th", "5thbook", true, "Peter");
        books[5] = new Book(116, "6th", "6thbook", true, "Emre");
        books[6] = new Book(117, "7th", "7thbook", true, "Josh");
        books[7] = new Book(118, "8th", "8thbook", true, "Matt");
        books[8] = new Book(119, "9th", "9thbook", true, "Henry");
        books[9] = new Book(121, "10th", "10tbook", true, "Isaac");
        books[10] = new Book(122, "11th", "11thbook", false, " ");
        books[11] = new Book(123, "12th", "12thbook", false, " ");
        books[12] = new Book(124, "13th", "13thbook", false, " ");
        books[13] = new Book(125, "14th", "14thbook", false, " ");
        books[14] = new Book(126, "15th", "15thbook", false, " ");
        books[15] = new Book(127, "16th", "16thbook", false, " ");
        books[16] = new Book(128, "17th", "17thbook", false, " ");
        books[17] = new Book(129, "18th", "18thbook", false, " ");
        books[18] = new Book(130, "19th", "19thbook", false, " ");
        books[19] = new Book(131, "2oth", "20thbook", false, " ");


    }


    private static void displayMainMenu() {
        System.out.println("The Store Home Screen.");
        System.out.println("1- Show Available Books.");
        System.out.println("2- Show Checked Out Books.");
        System.out.println("3- Exit");

        int command = getUserInput();
        switch (command) {
            case 1:
                showAvailableBooks();
                break;
            case 2:
                showCheckedOutBooks();
                break;
            case 3:
                System.out.println("Have a good day!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command, please try again!");
                break;
        }
    }

    private static int getUserInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static void showAvailableBooks() {
        System.out.println("List of available books:");
        for (Book book : books) {
            if (!book.getIsCheckedOut()) {
                System.out.println(book);
            }
        }
        System.out.println("1- Would you like to pick up a book from the list?");
        System.out.println("2- Go to home screen.");

        int selection = getUserInput();
        if (selection == 1) {
            bookCheckingOut();
        } else if (selection == 2) {
            // Simply return to main menu
        } else {
            System.out.println("Invalid selection. Returning to main menu.");
        }
    }

    public static void bookCheckingOut() {
        System.out.println("Please enter your name:");
        String nameOfCustomer = scanner.nextLine();

        System.out.println("Please enter the name of the book:");
        String choosedBook = scanner.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(choosedBook)) {
                if (book.getIsCheckedOut()) {
                    System.out.println("Sorry, this book is already checked out.");
                } else {
                    book.setIsCheckedOut(true);
                    book.setCheckedOutTo(nameOfCustomer);
                    System.out.println(nameOfCustomer + " has taken " + choosedBook);
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public static void showCheckedOutBooks() {
        System.out.println("Checked Out Books:");
        boolean found = false;
        for (Book book : books) {
            if (book.getIsCheckedOut()) {
                System.out.println(book);
                found = true;
                System.out.println("Please enter the book`s id number which you want to check in: ");

            }

            /**
             * couldn`t figured out this section
             */
            if(getUserInput() == 2);
            System.out.println("to checking a book please click C");
            System.out.println("to go to home screen please click X");
        }
        if (!found) {
            System.out.println("No books are currently checked out.");


        }
    }
}

