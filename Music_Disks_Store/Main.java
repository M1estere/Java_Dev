import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Store store = new Store("Disks Store", "Baker Street, 221B");

        Audio firstAudio = new Audio("80's best hits", "Action", "Greatest Artists", "80's superheroes", 15);
        Audio secondAudio = new Audio("Whaaaaaat the album", "Pop", "Backstreet Boys", "2000's men", 35);
        Audio thirdAudio = new Audio("Best Hits", "Pop", "Maroon 5", "BBC", 15);

        DVD firstFilm = new DVD("Godzilla", "Comedy", "Who", "Same shit", 184);
        DVD secondFilm = new DVD("Spider-Man", "Drama", "IDK", "HZ", 123);
        DVD thirdFilm = new DVD("1+1", "Horror", "Don't remember", "Who knows", 147);

        store.AddAudio(firstAudio);
        store.AddAudio(secondAudio);
        store.AddAudio(thirdAudio);

        store.AddFilm(firstFilm);
        store.AddFilm(secondFilm);
        store.AddFilm(thirdFilm);

        System.out.println(store.toString());

        store.Audios.get(1).Burn(new String[]{"Beat My Soul", "Fighting", "Mike Tyson", "HDStudio", "83"});
        store.Films.get(0).Burn(new String[]{"Mary Poppins", "Fighting", "No Idea", "No Idea x2", "153"});
        System.out.printf("\n");

        store.RemoveFilm(secondFilm);
        store.RemoveAudio(thirdAudio);

        System.out.printf("All disks info of store %s on %s\n", store.StoreName, store.Address);
        System.out.printf("Audio Disks:\n\tTitle -> Size\n");
        int counter = 1;
        for (Audio audio: store.Audios) {
            System.out.printf("\t%d. %s -> %d\n", counter, audio.Name, audio.DiskSize());
            counter++;
        }

        counter = 1;
        System.out.printf("DVD Disks:\n\tTitle -> Size\n");

        for (DVD dvd : store.Films)
        {
            System.out.printf("\t%d. %s -> %d\n", counter, dvd.Name, dvd.DiskSize());
            counter++;
        }
    }
}

interface StoreItem {
    double Price = 0;
    void DiscountPrice(int percent);
}

class Disk implements StoreItem {
    public String Name;
    public String Genre;

    public int BurnCount;

    public double Price;

    public Disk(String name, String genre) {
        Name = name;
        Genre = genre;
    }

    public void Burn(String[] values) { }

    @Override
    public void DiscountPrice(int percent) {
        Price = ((100 - percent) * Price) / 100;
    }
}

class Audio extends Disk {
    private String artist;
    private String recordingStudio;

    private int songsNumber;

    public int DiskSize() { return songsNumber * 8; }

    public Audio(String name, String genre, String artist, String recordingStudio, int songsNumber) {
        super(name, genre);

        this.artist = artist;
        this.recordingStudio = recordingStudio;
        this.songsNumber = songsNumber;
    }

    @Override
    public void Burn(String[] values) {
        if (values.length < 5)
        {
            System.out.println("!Attention: cannot burn this Audio Disk, too less parameters given!");
            return;
        }
        System.out.printf("!%s was burnt with %s by %s\n", Name, values[0], values[2]);

        Name = values[0];
        Genre = values[1];

        artist = values[2];
        recordingStudio = values[3];

        songsNumber = Integer.parseInt(values[4]);

        BurnCount++;
    }

    @Override
    public String toString() {
        return String.format("Audio Disk:\n\tName: %s,\n\tGenre: %s,\n\tArist: %s,\n\t" +
                                "Recording Studio: %s,\n\tSongs amount: %d,\n\tBurns: %d",
                                    Name, Genre, artist, recordingStudio, songsNumber, BurnCount);
    }
}

class DVD extends Disk {
    private String producer;
    private String filmCompany;

    private int minutesCount;

    public DVD(String name, String genre, String producer, String filmCompany, int minutesCount) {
        super(name, genre);

        this.producer = producer;
        this.filmCompany = filmCompany;
        this.minutesCount = minutesCount;
    }

    public int DiskSize() {
        return (minutesCount / 64) * 2;
    }

    @Override
    public void Burn(String[] values) {
        if (values.length < 5)
        {
            System.out.println("!Attention: cannot burn this DVD Disk, too less parameters given!");
            return;
        }
        System.out.printf("!%s was burnt with %s by %s\n", Name, values[0], values[2]);

        Name = values[0];
        Genre = values[1];
        producer = values[2];
        filmCompany = values[3];

        minutesCount = Integer.parseInt(values[4]);

        BurnCount++;
    }

    @Override
    public String toString() {
        return String.format("Audio Disk:\n\tName: %s,\n\tGenre: %s,\n\tProducer: %s,\n\t" +
                        "Film Company: %s,\n\tLength: %d min,\n\tBurns: %d",
                            Name, Genre, producer, filmCompany, minutesCount, BurnCount);
    }
}

class Store {
    public String StoreName;
    public String Address;

    public ArrayList<Audio> Audios = new ArrayList<Audio>();
    public ArrayList<DVD> Films = new ArrayList<DVD>();

    public Store(String storeName, String address) {
        StoreName = storeName;
        Address = address;
    }

    public void AddAudio(Audio audio) {
        if (Audios.contains(audio) == false) {
            Audios.add(audio);
            return;
        }

        System.out.printf("!%s is already here!", audio.Name);
    }

    public void RemoveAudio(Audio audio) {
        if (Audios.contains(audio) == true) {
            Audios.remove(audio);
            return;
        }

        System.out.printf("!%s is not here!", audio.Name);
    }

    public void AddFilm(DVD film) {
        if (Films.contains(film) == false) {
            Films.add(film);
            return;
        }

        System.out.printf("!%s is already here!", film.Name);
    }

    public void RemoveFilm(DVD film) {
        if (Films.contains(film) == true) {
            Films.remove(film);
            return;
        }

        System.out.printf("!%s is not here!", film.Name);
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();

        resultString.append(String.format("Store: %s on %s\n", StoreName, Address));
        resultString.append("Audios:\n");

        int counter = 0;
        for (Audio audio : Audios)
        {
            counter++;
            resultString.append(String.format("\t%d. %s, %s", counter, audio.Name, audio.Genre));
            resultString.append("\n");
        }

        counter = 0;
        resultString.append("Films:\n");
        for (DVD dvd : Films)
        {
            counter++;
            resultString.append(String.format("\t%d. %s, %s", counter, dvd.Name, dvd.Genre));
            resultString.append("\n");
        }

        return resultString.toString();
    }
}