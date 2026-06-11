import java.util.Scanner;
import java.util.ArrayList;
void main() {

    //NAME: Seth Titherington

    Scanner sc = new Scanner(System.in);
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> artists = new ArrayList<>();
    ArrayList<Integer> ratings = new ArrayList<>();
    // Adding 5 songs to begin song library
    titles.add("Self Control");
    artists.add("YoungBoy Never Broke Again");
    ratings.add(99);

    titles.add("Swimming Pools");
    artists.add("Kendrick Lamar");
    ratings.add(91);

    titles.add("Swervin'");
    artists.add("A Boogie Wit da Hoodie");
    ratings.add(78);

    titles.add("Thick Of It");
    artists.add("KSI");
    ratings.add(1);

    titles.add("Starships");
    artists.add("Nicki Minaj");
    ratings.add(72);

    int choice = 0; // User's Menu Selection
    System.out.println(" ");
    System.out.println("Welcome to the MLM, your personal Music Library Manager!");
    while (choice != 8) {
        // Loop ensures menu appears each time user doesn't enter 8 (exit the program)
        System.out.println("-------- MENU --------");

        System.out.println("Select an option below  ");
        System.out.println("1. Add a Song");
        System.out.println("2. Average Rating of the Library");
        System.out.println("3. Highest & Least Rated Song in Library");
        System.out.println("4. Song List & Song Editor");
        System.out.println("5. Song Rating Distribution");
        System.out.println("6. Song Search");
        System.out.println("7. Top/Bottom 20% rated songs");
        System.out.println("8. Exit.");
        System.out.println("Enter Your Choice (1-8)");
        // If value entered by user is not an integer, user is asked to reenter a number between 1-8
        if (!sc.hasNextInt()) {
            System.out.println("You have not entered a valid number/data type. Please enter a number between (1-8)");
            sc.nextLine(); // clear invalid answer
            choice = 0; // resets choice
        }
        else if (choice <0 || choice > 8) { // error code if number entered is not 1-8
            System.out.println("Invalid number. Please try again.");
            sc.nextLine(); // scanner buffer
            choice = 0;
        }
        else {
            choice = sc.nextInt();
            sc.nextLine(); // clear answer
        }
        if (choice == 1) {
            int songsAdded = 0;
            while (songsAdded < 2) { // continues until 2 songs have been added as song adding limit is 2 at a time
                System.out.println("-------- ADD SONG --------");

                System.out.println("Enter Song Title");
                String title = sc.nextLine();

                System.out.println("Enter the Artist's Name");
                String artist = sc.nextLine();

                System.out.println("Enter the rating for " + title + " from 0-100");
                int rating = sc.nextInt();
                if (rating < 0 || rating > 100){
                    System.out.println("You have entered an invalid rating. Please try again.");
                    songsAdded = 2;
                }
                sc.nextLine();

                titles.add(title); // adding new song to arrays
                artists.add(artist);
                ratings.add(rating);
                songsAdded++;

                if (songsAdded < 2) { // checking if song adding limit of 2 is reached yet
                    System.out.println("Would you like to add another song? (yes/no)"); // user prompted to add another song or not
                    String answer = sc.nextLine().toLowerCase();

                    if (answer.equals("no")) {
                        songsAdded = 2;
                    }


                }

            }
            System.out.println();
        } else if (choice == 2) {
            System.out.println("-------- AVERAGE SONG RATING--------");
            double sum = 0;
            for (Integer rating : ratings) { // loop to add up all song scores/ratings
                sum = sum + rating;
            }
            double average = sum / ratings.size(); // average rating calculated
            double averageDecimal = (double) Math.round(average * 100) / 100; //  number rounded to nearest 2 decimals

            System.out.println("The average rating for your current library is " + averageDecimal + "*");
            System.out.println("# of Current songs in Library: " + ratings.size());

        } else if (choice == 3) {
            System.out.println("-------- HIGHEST AND LOWEST RATED SONGS --------");

            int maxIndex = 0; // set max num
            int minIndex = 0; // set min num
            for (int i = 1; i < ratings.size(); i++) {
                if (ratings.get(i) > ratings.get(maxIndex)) {
                    maxIndex = i; // get max index by running through all ratings
                }
                if (ratings.get(i) < ratings.get(minIndex)) {
                    minIndex = i; // get min index by running through all ratings
                }
            }

            System.out.println("-------- HIGHEST RATED SONG --------"); // prints highest rated song and song details
            System.out.println("Title: " + titles.get(maxIndex));
            System.out.println("Artist: " + artists.get(maxIndex));
            System.out.println("Rating: " + ratings.get(maxIndex) + "*");

            System.out.println("-------- LOWEST RATED SONG --------"); // prints lowest rated song and song details
            System.out.println("Title: " + titles.get(minIndex));
            System.out.println("Artist: " + artists.get(minIndex));
            System.out.println("Rating: " + ratings.get(minIndex) + "*");

        } else if (choice == 4) {
            int editChoice = 0; // initializes editor menu choice

            while (editChoice != 3) { // runs until user enters 3 to exit
                System.out.println("-------- CURRENT SONG LIBRARY --------");
                for (int i = 0; i < ratings.size(); i++) { // cycles through all arrays to display each song, the artist, and the rating
                    System.out.println("Song Number: " + (i + 1) + " | Title: " + titles.get(i) + " | Artist: " + artists.get(i) + " | Rating: " + ratings.get(i) + "*");
                }
                System.out.println("-------- EDITOR MENU --------"); // song editing menu for library
                System.out.println("1. Edit a Song");
                System.out.println("2. Remove a Song");
                System.out.println("3. Exit to main menu");
                System.out.println("Enter choice (1-3): ");

                editChoice = sc.nextInt();
                sc.nextLine();

                if (editChoice == 1) {
                    System.out.println("Enter the song number of the song you wish to edit");
                    int editNum = sc.nextInt();
                    sc.nextLine();

                    int index = editNum - 1; // index will be one less than the song number (index starts at 0)

                    if (index >= 0 && index < titles.size()) {
                        System.out.println("Enter updated song title: ");
                        String newTitle = sc.nextLine(); // option to update title

                        System.out.println("Enter updated artist name: ");
                        String newArtist = sc.nextLine(); // option to update artist

                        System.out.println("Enter updated rating (0-100): ");
                        int newRating = sc.nextInt(); // option to update rating
                        sc.nextLine();

                        titles.set(index, newTitle); // takes place of old title in array
                        artists.set(index, newArtist); // takes place of old artists in array
                        ratings.set(index, newRating); // takes place of old rating in array

                        System.out.println("Song information successfully updated!");
                    } else {
                        System.out.println("Invalid Song Number. Returning to editor menu...");

                    }
                } else if (editChoice == 2) {
                    System.out.println("Enter the song number of the song you wish to remove");
                    int removeNum = sc.nextInt();
                    sc.nextLine();

                    int index = removeNum - 1; // song number is 1 more than index

                    if (index >= 0 && index < titles.size()) { // conditional for if song number given actually falls within array
                        titles.remove(index); // remove from all arrays
                        artists.remove(index);
                        ratings.remove(index);

                        System.out.println("Song successfully removed!");
                    } else {
                        System.out.println("Invalid song number. Returning to editor menu...");
                    }
                } else if (editChoice == 3) { // exit editor menu
                    System.out.println(" Returning to Main Menu...");
                } else {
                    System.out.println("Invalid Choice. Please choose 1,2, or 3.");
                }
            }
        } else if (choice == 5) {
            System.out.println("-------- RATING DISTRIBUTION CHART --------");
            int star5 = 0; // initialize star count for song ratings
            int star4 = 0;
            int star3 = 0;
            int star2 = 0;
            int star1 = 0;

            for (int score : ratings) { // all songs are assigned stars 1-5 based on song score given

                if (score >= 90 && score <= 100) {
                    star5++;
                } else if (score >= 75 && score < 90){
                    star4++;
                } else if (score >= 60 && score < 75) {
                    star3++;
                } else if (score >= 40 && score < 60) {
                    star2++;
                } else {
                    star1++;
                }

            }
            int maxGraph = star5; // sets height of the distribution chart
            if (star4 > maxGraph) {
                maxGraph = star4;
            }
            if (star3 > maxGraph) {
                maxGraph = star3;
            }
            if (star2 > maxGraph) {
                maxGraph = star2;
            }
            if (star1 > maxGraph) {
                maxGraph = star1;
            }

            System.out.println();

            for (int row = maxGraph; row >= 1; row--) { // prints hashtags in the appropriate columns
                if (star5 >= row) { // loops through all star variables and prints a hashtag for each song with such rating
                    System.out.print("#   ");
                } else {
                    System.out.print("  ");
                }
                if (star4 >= row) {
                    System.out.print("#   ");
                } else {
                    System.out.print("  ");
                }
                if (star3 >= row) {
                    System.out.print("#   ");
                } else {
                    System.out.print("  ");
                }
                if (star2 >= row) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
                if (star1 >= row) {
                    System.out.print("  #  ");
                } else {
                    System.out.print("  ");
                }
                System.out.println();
            }

            System.out.println("___________________"); // x-axis of graph
            System.out.println("5*  4*  3*  2*  1*");
        }
        else if(choice==6) {
            System.out.println("-------- SEARCH A SONG --------");
            double sum =0;
            for (Integer rating : ratings) { // calculate current library average rating
                sum += rating;
            }
            double average = sum / ratings.size();
            double averageDecimal = Math.round(average * 100.0) / 100.0;



            System.out.println("Enter song title, artist, or keyword: ");
            String search = sc.nextLine().toLowerCase(); // make input lowercase to prevent misread of capital letters

            boolean foundMatch = false; // set boolean to false
            System.out.println(" Search Results:");
            System.out.println("-----------------------------");

            for (int i = 0; i<titles.size();i++) { // loop through library for search
                String currentTitle = titles.get(i).toLowerCase();
                String currentArtist = artists.get(i).toLowerCase();
                if (currentTitle.contains(search) || currentArtist.contains(search)) { // the checking of search word within song artist or title
                    foundMatch = true;
                    int score = ratings.get(i);

                    System.out.println("Song Number: " + (i+1)); // prints details of the searched song
                    System.out.println("Title: " + titles.get(i));
                    System.out.println("Artist: " + artists.get(i));
                    System.out.println("Rating: " + score );

                    if (score > average) { // displays to user whether the song is rated above, below, or the same as the library average
                        System.out.println("This song is rated ABOVE the library average of " + averageDecimal + ".");
                    }
                    else if (score < average){
                        System.out.println("This song is rated BELOW the library average of " + averageDecimal + ".");
                    }
                    else {
                        System.out.println("This song is rated EQUAL to the library average of " + averageDecimal + ".");
                    }
                    System.out.println("-----------------------------");
                }
            }
            if (!foundMatch) { // if search result was not found within the title or artist name, no match found is displayed
                System.out.println("No songs or artists matched your search: " + search);
                System.out.println("-----------------------------");
            }


        }
        else if (choice==7) {
            System.out.println("--------- TOP & BOTTOM 20% OF SONGS IN LIBRARY --------");

            int countPercent = (int) Math.ceil(titles.size() * 0.20); // rounds numbers up to ensure small libraries still have a top & bottom 20%
            System.out.println("Displaying the top " + countPercent + " and bottom " + countPercent + " song(s) based on your library size.");

            ArrayList<String> dupeTitles = new ArrayList<>(titles); // initialization of new temporary arrays for songs so they are displayed without change
            ArrayList<String> dupeArtists = new ArrayList<>(artists);
            ArrayList<Integer> dupeRatings = new ArrayList<>(ratings);

            for (int i = 0; i < dupeRatings.size() - 1; i++) {  // arranges library songs from lowest to highest score
                for (int p = i + 1; p < dupeRatings.size(); p++) {
                    if (dupeRatings.get(p) > dupeRatings.get(i)) {
                        int switchRating = dupeRatings.get(i); // swapping of ratings to be put in order
                        dupeRatings.set(i, dupeRatings.get(p));
                        dupeRatings.set(p, switchRating);

                        String switchArtist = dupeArtists.get(i); // swapping of artists to be put in order
                        dupeArtists.set(i, dupeArtists.get(p));
                        dupeArtists.set(p, switchArtist);

                        String switchTitle = dupeTitles.get(i); // swapping of title to be put in order
                        dupeTitles.set(i, dupeTitles.get(p));
                        dupeTitles.set(p, switchTitle);

                    }

                }
            }
            System.out.println(" ");
            System.out.println(" < TOP 20% RATED SONGS > "); // print all songs that fall in top 20% of library rating
            System.out.println("-----------------------------");
            for (int i = 0; i < countPercent; i++) { // enter loop when I is < countPercent which is when songs begin to fall in top 20%
                System.out.println("Title: " + dupeTitles.get(i));
                System.out.println("Artist: " + dupeArtists.get(i));
                System.out.println("Rating: " + dupeRatings.get(i) + "*");

                System.out.println("------------------------------");
            }

            System.out.println(" < BOTTOM 20% RATED SONGS >"); // print all songs that fall in bottom 20% of library rating
            System.out.println("------------------------------");
            int startIndex = dupeRatings.size() - countPercent;
            for (int i = startIndex; i < dupeRatings.size(); i++) { // start printing songs from least to most rated, until condition is met (songs are no longer rated bottom 20%)
                System.out.println("Title: " + dupeTitles.get(i));
                System.out.println("Artist: " + dupeArtists.get(i));
                System.out.println("Rating: " + dupeRatings.get(i) + "*");

                System.out.println("------------------------------");
            }
        }

    } // exit screen message (when 8 is pressed)
    System.out.println("------------------------------------------------------------");
    System.out.println("     Thank you for using the MLM, Hope to see you again!");
    System.out.println("------------------------------------------------------------");
}