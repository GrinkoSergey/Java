package aufgaben.auf00_interfaces_sv01;

public class Musiker implements IGitarrenspieler, ISaenger {
    @Override
    public void gitarreSpielen() {
        System.out.println("Ich kann Gitarre spielen.");
    }

    @Override
    public void singen() {
        System.out.println("Ich kann auch singen.");
    }

}
