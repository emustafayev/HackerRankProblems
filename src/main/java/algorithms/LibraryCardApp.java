package algorithms;

import java.io.FileReader;
import java.io.IOException;

public class LibraryCardApp {




    private static class LibraryCard {
        private static LibraryCard instance;
        private static boolean isBusy = false;

        // Private constructor to prevent instantiation from outside
        private LibraryCard() {}

        // Static method to get the singleton instance
        public static LibraryCard getInstance() {
            if (instance == null) {
                instance = new LibraryCard();
            }
            return instance;
        }

        // Method to simulate using the library card
        public synchronized void borrowBook(String user) {
            if (!isBusy) {
                isBusy = true;
                System.out.println(user + " is using the library card to borrow a book.");
                try {
                    // Simulating some work being done with the library card
                    Thread.sleep(2000); // Sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isBusy = false;
                System.out.println(user + " has finished using the library card.");
            } else {
                System.out.println(user + " is waiting for others to finish using the library card.");
            }
        }
    }

    private static class LibraryUser implements Runnable {
        private final String name;
        private final LibraryCard libraryCard;

        public LibraryUser(String name, LibraryCard libraryCard) {
            this.name = name;
            this.libraryCard = libraryCard;
        }

        @Override
        public void run() {
            libraryCard.borrowBook(name);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        LibraryCard libraryCard = LibraryCard.getInstance();

        // Create multiple users
        Thread user1 = new Thread(new LibraryUser("User 1", libraryCard));
        Thread user2 = new Thread(new LibraryUser("User 2", libraryCard));
        Thread user3 = new Thread(new LibraryUser("User 3", libraryCard));

        // Start the threads
        user1.start();
        user2.start();
        user3.start();

        user1.join();
        user2.join();
        user3.join();
    }



}
