package laba8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static List<Anime> readAnimeFromCsv(String fileName) {
        List<Anime> animeList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Пропускаем заголовок

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                animeList.add(parseAnime(values));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return animeList;
    }

    private static Anime parseAnime(String[] data) {
        Anime anime = new Anime();
        anime.setAnimeId(parseInteger(data[0]));
        anime.setName(data[1]);
        anime.setGenre(data[2]);
        anime.setType(data[3]);
        anime.setEpisodes(parseInteger(data[4]));
        anime.setRating(parseDouble(data[5]));
        anime.setMembers(parseInteger(data[6]));
        return anime;
    }
    
    private static Integer parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // Обработка случая, когда значение не является числом
            return 0;
        }
    }
    
    private static Double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            // Обработка случая, когда значение не является числом
            return 0.0; 
        }
    }
    
}
