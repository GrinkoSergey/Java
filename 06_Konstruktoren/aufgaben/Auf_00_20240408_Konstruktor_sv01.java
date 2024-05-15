package aufgaben;

public class Auf_00_20240408_Konstruktor_sv01 {
    public static void main(String[] args) {
        Auf_00_Song_sv01 song01 = new Auf_00_Song_sv01();
        Auf_00_Song_sv01 song02 = new Auf_00_Song_sv01("Song2", 200, "Interpret2");

        song01.spielen();
        song02.spielen();

        System.out.println(Auf_00_Song_sv01.songsListe);
        int i = 0;
        for (Auf_00_Song_sv01 s : Auf_00_Song_sv01.songsListe){
            System.out.println("Dauer des " + i + ". Songs" + s.getDauerSekunden());
            i++;
        }
    }
}
