package view;
// 4.5.1


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public enum Avatare {

    DEFAULT("default.png", "Wähle Avatar"),
    MAGIER("magier.jpg", "Magier"),
    PALADIN("paladin.jpg", "Paladin"),
    RITTER("ritter.jpg", "Ritter"),
    WALKÜRE("walkuere.jpg", "Walküre");

    private String path;
    private String name;

    Avatare(String path, String name) {
        this.path = path;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    // 5
    /*
    Этот код выполняет загрузку изображения (аватара) из определенного пути и масштабирование его до размера 150x150 пикселей.
     */
    public Image getAvatar() { // Метод getAvatar() объявлен для получения объекта типа Image, представляющего аватар пользователя.
        URL url = getClass().getResource("/" + path); // В первой строке метода используется метод getResource() класса Class для получения URL-адреса ресурса, путь к которому указан в переменной path. Этот ресурс должен находиться в том же пакете, что и класс, или в подпакете. Результат сохраняется в переменной url.
        // das war in die Variable url in unserem Fall gespeichert: file:/C:/Users/Sergey/Desktop/Sergey/01_01_Umschulung/19_TF_US_OP2_Komplexere%20Anwendungen%20mit%20UML%20entwerfen%20und%20entwickeln/Java/TF_US_OPX/out/production/62_GUI_Entwicklung/default.png
        Image image; // Затем создается переменная image для хранения изображения.
        if(url != null) { // Проверяется, что url не равен null, то есть ресурс действительно найден по указанному пути.
            try { // Если url не равен null, то внутри блока try:
                image = ImageIO.read(url); // Считывается изображение с помощью метода ImageIO.read(URL url) и сохраняется в переменную image.
                image = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Далее изображение масштабируется до размера 150x150 пикселей с использованием метода getScaledInstance(int width, int height, int hints), где Image.SCALE_SMOOTH указывает, что масштабирование должно быть выполнено с использованием высокого качества сглаживания.
                return image; // Возвращается масштабированное изображение.
            } catch (IOException ex) {
                return null;
            }
        }
        return null;
    }

    // 5 Ende

    public static String[] getArrayAvatare() {
        String[] namen = new String[Avatare.values().length];
        int count = 0;
        for (Avatare avatare : Avatare.values()) {
            namen[count] = avatare.toString();
            count ++;
        }
        return namen;
    }

    // 4.5.1 Ende
}
