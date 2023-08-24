public class MovieManager {
    //создаем пустой массив
    private String[] movies = new String[0];
    private int limit;
    //создаем конструктор

    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void addMovie(String movie) {
//создаем временный массив, но на единицу больше
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        this.movies = tmp;
    }

    //показать все фильмы
    public String[] findAll() {
        return movies;
    }

    //показать последние добавленные фильмы
    public String[] findLast() {
        //заводим переменную для вычисления последних фильмов, т.е. сколько надо показать
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }
        String[] answer = new String[resultLength];
        for (int i = 0; i < answer.length; i++) {
            //чтобы скопировать элемент с конца другого массива делай так:
            answer[i] = movies[movies.length - 1 - i];
        }
        return answer;
    }
}