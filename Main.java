import java.util.*;

class Show{
    String title;
    String genre;
    int length;

    public Show(String title, String genre, int length){
        this.title = title;
        this.genre = genre;
        this.length = length;
    }

    @Override
    public String toString(){
        return title + "(" + genre + ") - Num. Episodes: " + length;
    } 
}

class Recommendations{
    private final List<Show> finishedShows;
    private final List<Show> newShows;

    public Recommendations(){
        finishedShows = new ArrayList<>();
        newShows = new ArrayList<>();
    }

    public void addToFinishedList(Show show){
        finishedShows.add(show);
    }

    public void addToNewList(Show show){
        newShows.add(show);
    }


    public List<Show> getRecommendations(){
        List<Show> recommendations = new ArrayList<>();
        Set<String> seenGenres = new HashSet<>();

        for(Show show : finishedShows){
            seenGenres.add(show.genre);
        }

        for(Show show : newShows){
            if(seenGenres.contains(show.genre)){
                recommendations.add(show);
            }
        }
        return recommendations;
    }
}

public class Main {
    public static void main(String[] args) {
        Recommendations recommender = new Recommendations();

        // add finished shows
        recommender.addToFinishedList(new Show("Full Metal Alchemist Brotherhood", "Shonen", 68));
        recommender.addToFinishedList(new Show("Cowboy Bebop", "Action", 26));

        // add new shows
        recommender.addToNewList(new Show("Friren: Beyond Journey's End", "Fantasy", 28));
        recommender.addToNewList(new Show("Edens Zero", "Shonen", 50));

        // getting recommended shows
        System.out.println("Your Recommendations are: ");
        for(Show show : recommender.getRecommendations()){
            System.out.println(show);
        }
    }
}