package laba8;


public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new AnimeFilter());
        
        dataManager.loadData("C:\\java\\first_block\\laba8\\anime.csv");
        dataManager.processData("filterByGenre", "Comedy");
        dataManager.saveData("C:\\java\\first_block\\laba8\\Comedy.csv");

        dataManager.shutdown();   
}

}
