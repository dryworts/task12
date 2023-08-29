import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    //тестируем пустой массив
    public void testEmpty() {
        MovieManager manager = new MovieManager();

        String[] actual = manager.findAll();
        String[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    //тестируем добавление одного фильма
    public void testOneMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film I");
        String[] actual = manager.findAll();
        String[] expected = {"Film I"};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    //тестируем добавление трех фильмов
    public void testAddSomeMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");
        String[] actual = manager.findAll();
        String[] expected = {"Film I", "Film II", "Film III",};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    //тестируем показать в обратном порядке
    public void testShowLastFilms() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");
        String[] actual = manager.findLast();
        String[] expected = {"Film III", "Film II", "Film I",};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    //тестируем показать в обратном порядке с конструктором с 3 фильмами
    //меньше, чем лимит
    public void testShowThreeLastFilmsButLessLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Film I");

        String[] actual = manager.findLast();
        String[] expected = {"Film I"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    //тестируем показать в обратном порядке с конструктором с 3 фильмами
    //больше, чем лимит
    public void testShowThreeLastFilmsButMoreThanLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");
        //короче здесь ниже произойдет перезапись с конца и вместо Film III будет Film IV"
        //а далее по порядку, обратному конечно же
        manager.addMovie("Film IV");
        String[] actual = manager.findLast();
        String[] expected = {"Film IV", "Film III", "Film II"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    //тестируем показать в обратном порядке с конструктором с 3 фильмами
    //столько же, как в конструкторе
    public void testShowThreeLastFilms() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");
        String[] actual = manager.findLast();
        String[] expected = {"Film III", "Film II", "Film I",};

        Assertions.assertArrayEquals(expected, actual);
    }


}
