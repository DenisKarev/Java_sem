import java.util.ArrayList;

public class AppNa {

  public static void main(String[] args) {
    Infrastructure infrastructure = new Infrastructure();

    // System.out.println(infrastructure.getAllInfo(1));
    // System.out.println(infrastructure.getAllInfo(2));
    // System.out.println(infrastructure.getAllInfo(3));
    // System.out.println(infrastructure.getAllInfo(4));

    ArrayList<String> result = infrastructure.findAll("Особ");
    System.out.println(result);
  }
}

/**
 * Infrastructure (класс отвечающий за создание приложения)
 */
class Infrastructure {
  /**
   * запуск создания БД
   */
  public Infrastructure() {
    init();
  }

  Db db;

  /**
   * готовая база данных
   * 
   * @return база данных
   */
  public Db getDb() {
    return db;
  }

  /**
   * 
   * @param idCinema id фильма
   * @return данные в формате(жанр и компания обращаются к соответствующим
   *         таблицам)
   */
  public String getAllInfo(int idCinema) {
    Cinema c = db.films.get(idCinema - 1);

    return String.format("%d %s %s %s",
        c.id,
        c.name,
        db.genres.get(c.genre - 1).name,
        db.prod.get(c.filmProd - 1).titleName);
  }

  public ArrayList<String> findAll(String searchData) {
    ArrayList<String> findAll = new ArrayList<String>();
    for (int idCinema = 0; idCinema < 4; idCinema++) {
      Cinema c = db.films.get(idCinema);
      if (c.name.toLowerCase().contains(searchData.toLowerCase())) {
        findAll.add(String.format("%d %s %s %s",
            c.id,
            c.name,
            db.genres.get(c.genre-1).name,
            db.prod.get(c.filmProd-1).titleName));
      }
    }
    return findAll;
  }

  /**
   * создание БД, наполнение, добавление в БД, добавление жанров, заполнение
   * компаний
   * 
   * @return база данных
   */
  Db init() {
    db = new Db();
    Cinema c1 = new Cinema(1, "Тьма", 1, 1);
    Cinema c2 = new Cinema(2, "Свет", 1, 2);
    Cinema c3 = new Cinema(3, "Особенности нац...", 3, 4);
    Cinema c4 = new Cinema(4, "Человек паук", 3, 3);

    db.films.add(c1);
    db.films.add(c2);
    db.films.add(c3);
    db.films.add(c4);

    db.genres.add(new Genre(1, "Ужасы"));
    db.genres.add(new Genre(2, "Комедия"));
    db.genres.add(new Genre(3, "Драмма"));
    FilmProducerFactory pf = new FilmProducerFactory();
    db.addFilmProducer(pf.getFilmProducer("Ленфильм"));
    db.addFilmProducer(pf.getFilmProducer("Марвел"));
    db.addFilmProducer(pf.getFilmProducer("Мосфильм"));
    db.addFilmProducer(pf.getFilmProducer("DC"));

    return db;
  }

}

/**
 * Db (база данных, создание списков: фильмы, компания, жанры)
 */
class Db {
  ArrayList<Cinema> films = new ArrayList<>();
  ArrayList<FilmProducer> prod = new ArrayList<>();
  ArrayList<Genre> genres = new ArrayList<>();

  /**
   * метод добавление компании
   * 
   * @param producer
   */
  public void addFilmProducer(FilmProducer producer) {
    prod.add(producer);
  }
}

/**
 * Cinema (модель фильмов)
 * id, компания, название, жанр
 */
class Cinema {
  int id;
  int filmProd;
  String name;
  int genre;

  /**
   * сгенерированный конструктор(для создания выделяем строки 124-127 ПКМ ->
   * действие с исходным кодом -> Generate Constructors)
   */
  public Cinema(int id, String name, int genre, int filmProd) {
    this.id = id;
    this.filmProd = filmProd;
    this.name = name;
    this.genre = genre;
  }
}

/**
 * FilmProducer (модель киностудий)
 * id, наименование
 */
class FilmProducer {
  int id;
  String titleName;
}

/**
 * Genre (модель жанров)
 * id, жанр
 */
class Genre {
  int id;
  String name;

  /**
   * сгенерированный конструктор
   */
  public Genre(int id, String name) {
    this.id = id;
    this.name = name;
  }
}

/**
 * FilmProducerFactory ( таблица с компаниями)
 */
class FilmProducerFactory {
  int count = 1;

  /**
   * создание компании
   * 
   * @param name
   * @return
   */
  public FilmProducer getFilmProducer(String name) {
    FilmProducer fp = new FilmProducer();
    fp.id = count++;
    fp.titleName = name;
    return fp;
  }
}
