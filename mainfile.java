

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class mainfile {
    //creates main book List 
    static SinglyLinkedList<book> bookList = new SinglyLinkedList<book>();

    public static void main(String[] args) {
        boolean running = true;
        Scanner input = new Scanner(System.in);
        startup();
        //main program loop. Will run untill the running boolean is false
        while (running) {
            // gets user input
            System.out.println("What would you like to do? see help for possible commands.");
            String command = input.nextLine();
            //compares user input to each possible command
            if (command.compareTo("quit") == 0) {
                // if the command was quit. exit the main loop
                System.out.println("Thank you! Good Bye!");
                try {
                    writeToFile(bookList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                running = false;
            } else if (command.compareTo("help") == 0) {
                // if the command was quit. exit the main loop
                help();
            } else if (command.compareTo("add") == 0) {
                // if the command was quit. exit the main loop
                addBook();
            } else if (command.compareTo("list") == 0) {
                // if the command was quit. exit the main loop
                showList();

            } else if (command.compareTo("remove") == 0) {
                // if the command was quit. exit the main loop
                remove();

            } else {
                System.out.println("Please Enter a valid command!");
            }

        }

    }

    public static void help() {
        System.out.println("Here Is a list of possible commands");
        System.out.println("Add: Adds a book");
        System.out.println("remove: removes specified book from the list");
        System.out.println("List: prints a list of books on the list.");
    }

    public static void addBook() {
        Scanner tempInput = new Scanner(System.in);
        boolean tempRun = true;
        while (tempRun) {
            System.out.println("What is the title of the book?");
            String title = tempInput.nextLine();
            System.out.println("who is the author of the book?");
            String author = tempInput.nextLine();
            System.out.println("when  did you finish reading the book?");
            String date = tempInput.nextLine();
            System.out.println("What do you give the book out of ten?");
            String score = tempInput.nextLine();
            //pushes a new book to the list 
            book tempBook = new book(title, author, score, date, (bookList.size() + 1));
            if (bookList.size() == 0) {
                bookList.addFirst(tempBook);
            } else {
                bookList.addLast(tempBook);
            }
            tempRun = false;
        }
    }

    public static void showList() {
        // 
        // iterate through list
        // print each subelement of each book.
        for (int i = 0; i < bookList.size(); i++) {
            // System.out.println("Book "+(bookList.getAt(i).returnIndex()+1));
            System.out.println(bookList.getAt(i).returnAll(bookList.getAt(i)));
            System.out.println("_____________________________________________________");
        } //prints how many books the user has read
        if (bookList.size() == 0) {
            System.out.println("Please Add books to the list!");
        } else if (bookList.size() == 1) {
            System.out.println("You have read one book!");
        } else {
            System.out.println("You have read " + bookList.size() + " books!");
        }

    }
        //writes file
    public static void writeToFile(SinglyLinkedList list) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("BookList.bin"));
        objectOutputStream.writeObject(list);
    }
    //reads file
    public static void readFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("BookList.Bin"));
        bookList = (SinglyLinkedList<book>) objectInputStream.readObject();
        // System.out.println(test.getAt(0).returnAuthor());
    }

    public static void startup() {
        //checks if user has a saved list
        System.out.println("Do you have a save file? if yes, enter 1, if no enter 2. ");
        Scanner tempInput = new Scanner(System.in);
        String command = tempInput.nextLine();
        if (command.compareTo("1") == 0) {
            try {
                readFile();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    

    // }
    public static void remove() {
        //prints out each book and their id.
        for (int i = 0; i < bookList.size(); i++) {
            book tempBook = bookList.getAt(i);
            System.out.print(tempBook.returnTitle() + ": " + tempBook.returnIndex());
            System.out.println("_____________________________________________________");
        }
        System.out.println("Please enter the ID of the book you want to remove!");
        Scanner tempInput = new Scanner(System.in);
        String id = tempInput.nextLine();
        //removes based on the position of the book
        if (Integer.parseInt(id) == 1) {
            bookList.removeFirst();
        } else if (Integer.parseInt(id) == bookList.size()) {
             bookList.removeLast();
        } else {
            bookList.remove(Integer.parseInt(id));
        }
        updateIndex();

    }
    public static void updateIndex(){
        //updates Id's of books based on the amount of books in the list.
		for(int i = 1;i<bookList.size()+1;i++){
            bookList.getAt(i-1).setIndex(i);
        }
	}
}