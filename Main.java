import java.util.Scanner;
import java.util.ArrayList;
void main() {

    Scanner sc = new Scanner(System.in);
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> artists = new ArrayList<>();
    ArrayList<Integer> ratings = new ArrayList<>();

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

    int choice = 0;
    System.out.println(" ");
    System.out.println("Welcome to the MLM, your personal Music Library Manager!");
    while (choice != 8) {

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

        if (!sc.hasNextInt()) {
            System.out.println("You have not entered a valid number. Please enter a number between (1-8)");
            sc.nextLine();
            choice = 0;
        }
        else {
            choice = sc.nextInt();
            sc.nextLine();
        }
        if (choice == 1) {
            int songsAdded = 0;
            while (songsAdded < 2) {
                System.out.println("-------- ADD SONG --------");

                System.out.println("Enter Song Title");
                String title = sc.nextLine();

                System.out.println("Enter the Artist's Name");
                String artist = sc.nextLine();

                System.out.println("Enter the rating for " + title + " from 0-100");
                int rating = sc.nextInt();
                sc.nextLine();

                titles.add(title);
                artists.add(artist);
                ratings.add(rating);
                songsAdded++;

                if (songsAdded < 2) {
                    System.out.println("Would you like to add another song? (yes/no)");
                    String answer = sc.nextLine();

                    if (answer.equals("no")) {
                        songsAdded = 2;
                    }


                }

            }
            System.out.println();
        } else if (choice == 2) {
            System.out.println("-------- AVERAGE SONG RATING--------");
            double sum = 0;
            for (Integer rating : ratings) {
                sum = sum + rating;
            }
            double average = sum / ratings.size();
            double averageDecimal = (double) Math.round(average * 100) / 100;

            System.out.println("The average rating for your current library is " + averageDecimal + "*");
            System.out.println("# of Current songs in Library: " + ratings.size());

        } else if (choice == 3) {
            System.out.println("-------- HIGHEST AND LOWEST RATED SONGS --------");

            int maxIndex = 0;
            int minIndex = 0;
            for (int i = 1; i < ratings.size(); i++) {
                if (ratings.get(i) > ratings.get(maxIndex)) {
                    maxIndex = i;
                }
                if (ratings.get(i) < ratings.get(minIndex)) {
                    minIndex = i;
                }
            }

            System.out.println("-------- HIGHEST RATED SONG --------");
            System.out.println("Title: " + titles.get(maxIndex));
            System.out.println("Artist: " + artists.get(maxIndex));
            System.out.println("Rating: " + ratings.get(maxIndex) + "*");

            System.out.println("-------- LOWEST RATED SONG --------");
            System.out.println("Title: " + titles.get(minIndex));
            System.out.println("Artist: " + artists.get(minIndex));
            System.out.println("Rating: " + ratings.get(minIndex) + "*");

        } else if (choice == 4) {
            int editChoice = 0;

            while (editChoice != 3) {
                System.out.println("-------- CURRENT SONG LIBRARY --------");
                for (int i = 0; i < ratings.size(); i++) {
                    System.out.println("Song Number: " + (i + 1) + " | Title: " + titles.get(i) + " | Artist: " + artists.get(i) + " | Rating: " + ratings.get(i) + "*");
                }
                System.out.println("-------- EDITOR MENU --------");
                System.out.println("1. Edit a Song");
                System.out.println("2. Remove a Song");
                System.out.println("3. Exit to main menu");
                System.out.println("Enter choice: ");

                editChoice = sc.nextInt();
                sc.nextLine();

                if (editChoice == 1) {
                    System.out.println("Enter the song number of the song you wish to edit");
                    int editNum = sc.nextInt();
                    sc.nextLine();

                    int index = editNum - 1;

                    if (index >= 0 && index < titles.size()) {
                        System.out.println("Enter updated song title: ");
                        String newTitle = sc.nextLine();

                        System.out.println("Enter updated artist name: ");
                        String newArtist = sc.nextLine();

                        System.out.println("Enter updated rating (0-100): ");
                        int newRating = sc.nextInt();
                        sc.nextLine();

                        titles.set(index, newTitle);
                        artists.set(index, newArtist);
                        ratings.set(index, newRating);

                        System.out.println("Song information successfully updated!");
                    } else {
                        System.out.println("Invalid Song Number. Returning to editor menu...");

                    }
                } else if (editChoice == 2) {
                    System.out.println("Enter the song number of the song you wish to remove");
                    int removeNum = sc.nextInt();
                    sc.nextLine();

                    int index = removeNum - 1;

                    if (index >= 0 && index < titles.size()) {
                        titles.remove(index);
                        artists.remove(index);
                        ratings.remove(index);

                        System.out.println("Song successfully removed!");
                    } else {
                        System.out.println("Invalid song number. Returning to editor menu...");
                    }
                } else if (editChoice == 3) {
                    System.out.println(" Returning to Main Menu...");
                } else {
                    System.out.println("Invalid Choice. Please choose 1,2, or 3.");
                }
            }
        } else if (choice == 5) {
            System.out.println("-------- RATING DISTRIBUTION CHART --------");
            int star5 = 0;
            int star4 = 0;
            int star3 = 0;
            int star2 = 0;
            int star1 = 0;

            for (int score : ratings) {

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
            int maxGraph = star5;
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

            for (int row = maxGraph; row >= 1; row--) {
                if (star5 >= row) {
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

            System.out.println("___________________");
            System.out.println("5*  4*  3*  2*  1*");
        }
        else if(choice==6) {
            System.out.println("-------- SEARCH A SONG --------");
            double sum =0;
            for (Integer rating : ratings) {
                sum += rating;
            }
            double average = sum / ratings.size();
            double averageDecimal = Math.round(average * 100.0) / 100.0;



            System.out.println("Enter song title, artist, or keyword: ");
            String search = sc.nextLine().toLowerCase();

            boolean foundMatch = false;
            System.out.println(" Search Results:");
            System.out.println("-----------------------------");

            for (int i = 0; i<titles.size();i++) {
                String currentTitle = titles.get(i).toLowerCase();
                String currentArtist = artists.get(i).toLowerCase();
                if (currentTitle.contains(search) || currentArtist.contains(search)) {
                    foundMatch = true;
                    int score = ratings.get(i);

                    System.out.println("Song Number: " + (i+1));
                    System.out.println("Title: " + titles.get(i));
                    System.out.println("Artist: " + artists.get(i));
                    System.out.println("Rating: " + score );

                    if (score > average) {
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
            if (!foundMatch) {
                System.out.println("No songs or artists matched your search: " + search);
                System.out.println("-----------------------------");
            }


        }
        else if (choice==7) {
            System.out.println("--------- TOP & BOTTOM 20% OF SONGS IN LIBRARY --------");

            int countPercent = (int) Math.ceil(titles.size() * 0.20);
            System.out.println("Displaying the top " + countPercent + " and bottom " + countPercent + " song(s) based on your library size.");

            ArrayList<String> dupeTitles = new ArrayList<>(titles);
            ArrayList<String> dupeArtists = new ArrayList<>(artists);
            ArrayList<Integer> dupeRatings = new ArrayList<>(ratings);

            for (int i = 0; i < dupeRatings.size() - 1; i++) {
                for (int p = i + 1; p < dupeRatings.size(); p++) {
                    if (dupeRatings.get(p) > dupeRatings.get(i)) {
                        int switchRating = dupeRatings.get(i);
                        dupeRatings.set(i, dupeRatings.get(p));
                        dupeRatings.set(p, switchRating);

                        String switchArtist = dupeArtists.get(i);
                        dupeArtists.set(i, dupeArtists.get(p));
                        dupeArtists.set(p, switchArtist);

                        String switchTitle = dupeTitles.get(i);
                        dupeTitles.set(i, dupeTitles.get(p));
                        dupeTitles.set(p, switchTitle);

                    }

                }
            }
            System.out.println(" ");
            System.out.println(" < TOP 20% RATED SONGS > ");
            System.out.println("-----------------------------");
            for (int i = 0; i < countPercent; i++) {
                System.out.println("Title: " + dupeTitles.get(i));
                System.out.println("Artist: " + dupeArtists.get(i));
                System.out.println("Rating: " + dupeRatings.get(i) + "*");

                System.out.println("------------------------------");
            }

            System.out.println(" < BOTTOM 20% RATED SONGS >");
            System.out.println("------------------------------");
            int startIndex = dupeRatings.size() - countPercent;
            for (int i = startIndex; i < dupeRatings.size(); i++) {
                System.out.println("Title: " + dupeTitles.get(i));
                System.out.println("Artist: " + dupeArtists.get(i));
                System.out.println("Rating: " + dupeRatings.get(i) + "*");

                System.out.println("------------------------------");
            }
        }

    }
    System.out.println("------------------------------------------------------------");
    System.out.println("     Thank you for using the MLM, Hope to see you again!");
    System.out.println("------------------------------------------------------------");
}