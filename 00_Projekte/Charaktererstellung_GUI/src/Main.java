import view.CharaktererstellungView;

import javax.swing.*;

public class Main {
    // 1
    public static void main(String[] args) {

        // 3

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CharaktererstellungView();
            }
        });
        /*
        SwingUtilities.invokeLater принимает объект Runnable и запускает его метод run() на графическом потоке событий (Event Dispatch Thread, EDT).
        Использование SwingUtilities.invokeLater гарантирует, что все операции с графическим интерфейсом будут выполнены правильно и безопасно. Это особенно важно для крупных приложений, где графический интерфейс может обновляться из разных потоков. Метод invokeLater добавляет задачу в очередь событий, которая будет обработана графическим потоком, обеспечивая корректное и безопасное выполнение операций с графическим интерфейсом.
invoke later (engl.) - вызвать позже
*/


    }
}
