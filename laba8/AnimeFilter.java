package laba8;

import java.util.List;
import java.util.stream.Collectors;

// import laba8.DataProcessor;

public class AnimeFilter {

    @DataProcessor
    public List<Anime> filterByType(List<Anime> anime, String type) {
        return anime.stream() // Преобразование списка фильмов в поток (stream)
                .filter(title -> title.getType().contains(type)) //оставляем только фильмы с указанным актером
                .collect(Collectors.toList()); // Сбор отфильтрованных элементов обратно в список
    }

    @DataProcessor
    public List<Anime> filterByGenre(List<Anime> anime, String genre) {
        return anime.stream()
                .filter(title -> title.getGenre().contains(genre))
                .collect(Collectors.toList());
    }
}

