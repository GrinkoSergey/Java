package view;

import controller.KlasseController;
import controller.VolkController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 2
/*
В данном коде создается класс CharaktererstellungView, который расширяет класс JFrame. Это означает, что CharaktererstellungView является окном приложения, построенного на основе Swing, библиотеки для создания графических интерфейсов в Java.
 */

public class CharaktererstellungView extends JFrame {

    // 4.4.1
    JLabel labelAvatar;
    // 4.5.2
    JSpinner avatarSpinner;
    // 7.1
    JTextField textFieldCharakterName;
    // 7.1 Ende

    //12.1
    JComboBox<String> jComboBoxVolkAuswahl;
    JComboBox<String> jComboBoxKlasseAuswahl;
    //12.1 Ende

    //13.1
    JCheckBox jCheckBoxKorrekt;
    //13.1 Ende

    // 18.1
    DefaultListModel<JPanel> listModel;
    // 18.1 Ende

    // 21.2
    JPanel panelCharakterAusgabe;
    // 21.2 Ende

    public CharaktererstellungView() {
        //18.2
        listModel = new DefaultListModel<>();
        //18.2 Ende
        init();
    }

    private void init() {
        setTitle("View Charaktererstellung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width * 2 / 3, Toolkit.getDefaultToolkit().getScreenSize().height * 2 / 3); /*
    1. Получение размеров экрана: Метод Toolkit.getDefaultToolkit().getScreenSize() возвращает объект Dimension, который содержит текущую ширину (width) и высоту (height) экрана.
    2. Установка размера окна: Величины width * 2/3 и height * 2/3 определяют новую ширину и высоту окна, равные двум третям ширины и высоты экрана соответственно.
    */
        setResizable(false);
        setLocationRelativeTo(null);
        addSplitPane(); // selbstgeschriebene Methode (die Methode ist unten)
        setVisible(true);
        // pack() // passt das Fenster an den Inhalt. dafür muss setResizable(true); oben "true" sein
        //2 Ende -------------------------------------------------------------------

    }

    // 4
    private void addSplitPane() {
        /*
        После выполнения этого метода главное окно будет содержать две панели, разделенные по горизонтали, с фиксированным разделителем. Это обеспечивает удобный и интуитивно понятный интерфейс для взаимодействия с формой и отображаемой информацией.
        */
        // 4.1
        getContentPane().setLayout(new GridLayout()); // Устанавливает Layout окна на GridLayout. Это означает, что компоненты будут размещаться в виде сетки.
        // grid (engl.) - сетка

        JPanel panelLinks_Formular = erstelleCharakterFormular(); // die Methode erstelleCharakterFormular() ist unten  // Создает левую панель, которая содержит форму для создания персонажа. Метод erstelleCharakterFormular() возвращает объект JPanel.
        JPanel panelRechts_Ausgabe = erstelleAusgabe(); // die Methode erstelleCharakterFormular() ist unten // Создает правую панель, которая используется для отображения информации. Метод erstelle-Ausgabe() возвращает объект JPanel.

        /*
        Использование JSplitPane позволяет организовать интерфейс таким образом, чтобы обе панели были видимы одновременно
        */
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); // Создает разделенную панель с горизонтальным разделением. JSplitPane позволяет разделять пространство между двумя компонентами
        splitPane.setLeftComponent(panelLinks_Formular); // Устанавливает левую компоненту разделенной панели.
        splitPane.setRightComponent(panelRechts_Ausgabe); // Устанавливает правую компоненту разделенной панели.
        splitPane.setEnabled(false); // wenn false -> kann man NICHT ziehen, wenn true -> kann man ziehen // Отключает возможность изменения размера разделенной панели пользователем (если false). Если установить в true, пользователь сможет изме-нять размер панелей, перетаскивая разделитель.
        // enabled (engl.) – включенный, задействованный

        add(splitPane);

    }

    private JPanel erstelleCharakterFormular() {
        JPanel panelCharakterFormular = new JPanel(); // Создается главная панель для формы создания персонажа.
        // 4.2
        JPanel panelControls = new JPanel(); // Создается вспомогательная панель для размещения элементов управления. та, что у нас слева. в которую записывали, выбирали, подтверждали
        panelControls.setLayout(new GridBagLayout()); // Устанавливается Layout на GridBagLayout, который предоставляет гибкий способ размещения компонентов в сетке с различными настройками выравнивания и размеров. теперь нам нужно каждый раз передавать "настройки" в panelControls с помощью add(). мы это делали с помощью объекта, который объявили в следующей строке
        GridBagConstraints gbc = new GridBagConstraints(); // Создается объект GridBagConstraints, который будет использоваться для задания настроек размещения компонентов в GridBagLayout.
        // constraint (engl.) - ограничение
        panelControls.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // eine Umrandung // Устанавливается пустая граница вокруг панели с отступом 10 пикселей со всех сторон, чтобы обеспечить внутренний отступ между краями панели и её содержимым.

        JLabel labelHeader = new JLabel("Charaktererstellung"); // Создается метка для заголовка с текстом "Charaktererstellung".
        labelHeader.setFont(new Font("Arial", Font.PLAIN, 25)); // Устанавливается шрифт метки: Arial, обычный стиль, размер 25.
        // font (engl.) - шрифт
        labelHeader.setPreferredSize(new Dimension(300, 30)); // Устанавливается предпочтительный размер метки: 300 пикселей в ширину и 30 пикселей в высоту. Однако, это всего лишь рекомендация, и фактический размер компонента может отличаться в зависимости от менеджера компоновки и других компонентов в контейнере. Метод setSize напрямую устанавливает текущий размер компонента, независимо от предпочтений менеджера компоновки.

        labelHeader.setHorizontalAlignment(JLabel.CENTER); // Устанавливается выравнивание текста в метке по центру.
        // alignment (engl.) - выравнивание
        gbc.insets = new Insets(10, 0, 0, 0); // so wird der Abstand für alle Komponenten eingesetzt // Устанавливается внутренний отступ сверху в 10 пикселей, чтобы создать промежуток между верхним краем панели и меткой.
        gbc.gridx = 0; // Устанавливается положение по горизонтали (столбец) на 0.
        gbc.gridy = 0; // Устанавливается положение по вертикали (строка) на 0.
        gbc.gridwidth = 2; // es läuft über 2 Felder // Устанавливается ширина компонента в 2 ячейки сетки, чтобы метка занимала две ячейки по горизонтали.

        panelControls.add(labelHeader, gbc); // Метка labelHeader добавляется на панель panelControls с использованием настроек GridBagConstraints.

        // 4.3
        JLabel labelAvatarText = new JLabel("Avatar:");
        labelAvatarText.setFont(new Font("Arial", Font.PLAIN, 20));
        labelAvatarText.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;

        panelControls.add(labelAvatarText, gbc);

        // 4.3 Ende

        // 4.4.2
        labelAvatar = new JLabel();
        labelAvatar.setPreferredSize(new Dimension(160, 160));
        labelAvatar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));// устанавливает рамку для labelAvatar. В данном случае создается черная рамка толщиной 1 пиксель. Это помогает выделить компонент на экране и сделать его более заметным.

        // labelAvatar.setIcon(null); // zunächst haben wir so geschrieben, da wir noch keine Bilder hatten. dann haben wir darauf geändert, was unten ist // Устанавливает иконку компонента JLabel в значение null, то есть убирает любую текущую иконку (изображение), которая может быть установлена. Это полезно, если изображение аватара еще не загружено или еще не выбрано.
        labelAvatar.setIcon(new ImageIcon(Avatare.DEFAULT.getAvatar()));
        labelAvatar.setHorizontalAlignment(JLabel.CENTER); // hier und nächste
        labelAvatar.setVerticalAlignment(JLabel.CENTER); // Устанавливают горизонтальное и вертикальное выравнивание содержимого JLabel по центру. Это гарантирует, что даже если в компоненте будет установле-но изображение меньшего размера, оно будет отображаться по центру компо-нента.

        gbc.gridx = 1;
        panelControls.add(labelAvatar, gbc);

        // 4.4.2 Ende

        // 4.5.3
        /*
        В этом фрагменте кода создается и настраивается компонент JSpinner, который используется для выбора аватара персонажа из списка доступных аватаров.
        */

        avatarSpinner = new JSpinner(new SpinnerListModel(Avatare.getArrayAvatare())); // Создается новый экземпляр JSpinner с моделью SpinnerListModel, которая инициализируется массивом аватаров, возвращаемым методом Avatare.getArrayAvatare(). Таким образом, JSpinner будет отображать список доступных аватаров для выбора.
        // spinner (engl.) - волчок, спиннер
        avatarSpinner.setFont(new Font("Arial", Font.PLAIN, 20));
        avatarSpinner.setPreferredSize(new Dimension(300, 30));
        JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) avatarSpinner.getEditor(); // Создается объект spinnerEditor, который представляет собой редактор по умолчанию для JSpinner. В данном случае это будет текстовое поле.
        spinnerEditor.getTextField().setEditable(false); // können nicht mehr reinschreiben // Устанавливается, что текстовое поле в редакторе JSpinner не редактируемое, то есть пользователи не смогут вводить текст вручную.
        spinnerEditor.getTextField().setHorizontalAlignment(JTextField.LEFT); // Schrift links haben
        spinnerEditor.getTextField().setCaretColor(getBackground()); // um den Kursor nicht mehr zu sehen  // Устанавливается цвет курсора (каретки) текстового поля такой же, как цвет фона, чтобы сделать курсор невидимым.


        //6.1
        /*
        Этот код на языке Java добавляет слушателя изменений (ChangeListener) к элементу avatarSpinner, который является компонентом типа JSpinner. Слушатель отслеживает изменения в выборе аватара и обновляет отображение соответствующего изображения в labelAvatar.
         */
        avatarSpinner.addChangeListener(new ChangeListener() { // Добавляется слушатель изменений к avatarSpinner с помощью метода addChangeListener().
            @Override // Внутри анонимного класса ChangeListener переопределяется метод stateChanged(ChangeEvent e).
            public void stateChanged(ChangeEvent e) { // Когда состояние avatarSpinner изменяется, вызывается метод stateChanged().
                String selectedAvatar = (String) avatarSpinner.getValue(); // Из avatarSpinner извлекается текущее выбранное значение с помощью метода getValue(), которое приводится к строковому типу и сохраняется в переменной selectedAvatar.
                for (Avatare a : Avatare.values()) { // Далее цикл проходит  по всем значениям перечисления Avatare (которое содержит различные аватары).
                    if (selectedAvatar.equals(a.toString())) { // Для каждого элемента a из Avatare проверяется, совпадает ли строковое представление текущего элемента с выбранным значением selectedAvatar.
                        ImageIcon imageIcon = new ImageIcon(a.getAvatar()); // С помощью метода getAvatar() текущего элемента a загружается соответствующее изображение. // Создается объект ImageIcon с загруженным изображением.
                        labelAvatar.setIcon(imageIcon); // Устанавливается иконка для labelAvatar с помощью метода setIcon(ImageIcon icon).
                    }
                }
            }
        });
        /*
        Таким образом, достигается следующее:
        При изменении значения в avatarSpinner автоматически обновляется отображаемый аватар в labelAvatar.
        Это позволяет пользователю выбрать аватар из avatarSpinner, и соответствующее изображение сразу же отображается на интерфейсе.
         */

        //6.2 Ende


        gbc.gridx = 1;
        gbc.gridy = 2;
        panelControls.add(avatarSpinner, gbc);
        // 4.5.3 Ende

        //6.2

        JLabel labelCharakterName = new JLabel("Charaktername: ");
        labelCharakterName.setFont(new Font("Arial", Font.PLAIN, 20));
        labelCharakterName.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelControls.add(labelCharakterName, gbc);

        //6.2 Ende

        // 7.2
        textFieldCharakterName = new JTextField();
        textFieldCharakterName.setFont(new Font("Arial", Font.PLAIN, 20));
        textFieldCharakterName.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 1;
        panelControls.add(textFieldCharakterName, gbc);
        // 7.2 Ende

        //12.2
        jComboBoxVolkAuswahl = new JComboBox<String>(VolkController.getVoelker());
        jComboBoxVolkAuswahl.setFont(new Font("Arial", Font.PLAIN, 20));
        jComboBoxVolkAuswahl.setPreferredSize(new Dimension(300, 30));
        jComboBoxVolkAuswahl.setSelectedIndex(0); // Устанавливается начальный выбранный элемент на первый элемент списка
        // Что это дает пользователю:
        //Когда пользователь впервые видит выпадающий список, уже выбран первый элемент из списка. Это может быть полезно, если мы хотим, чтобы по умолчанию был установлен какой-то конкретный вариант, который является наиболее распространенным или наиболее вероятным выбором для пользователя.
        //Если пользователь не сделает никакого выбора, то этот первый элемент будет считаться выбранным, что предотвращает ситуацию, когда ничего не выбрано, что может вызвать ошибки или непредвиденное поведение в программе.
        gbc.gridx = 1;
        gbc.gridy = 4;
        panelControls.add(jComboBoxVolkAuswahl, gbc);

        jComboBoxKlasseAuswahl = new JComboBox<String>(KlasseController.getKlassen());
        jComboBoxKlasseAuswahl.setFont(new Font("Arial", Font.PLAIN, 20));
        jComboBoxKlasseAuswahl.setPreferredSize(new Dimension(300, 30));
        jComboBoxKlasseAuswahl.setSelectedIndex(0);
        gbc.gridy = 5;
        panelControls.add(jComboBoxKlasseAuswahl, gbc);
        //12.2 Ende

        // 13.2
        jCheckBoxKorrekt = new JCheckBox("Eingaben korrekt");
        jCheckBoxKorrekt.setFont(new Font("Arial", Font.PLAIN, 20));
        jCheckBoxKorrekt.setPreferredSize(new Dimension(300, 30));
        gbc.gridy = 6;
        panelControls.add(jCheckBoxKorrekt, gbc);

        // 13.2 Ende

        // 14
        /*
        Этот код (14, 15, 16, 17) создает панель с кнопками, добавляет кнопки на эту панель и затем размещает эту панель на основную панель управления.
         */
        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout()); // Устанавливается менеджер компоновки FlowLayout, который располагает компоненты последовательно друг за другом по горизонтали или вертикали.
        jPanelButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        // 14 Ende

        // 15.2
        JButton jButtonBestaetigen = getButtonBestaetigen();
        jPanelButton.add(jButtonBestaetigen);

        JLabel jLabelDummy = new JLabel(); // um 2 Buttons auseinander zu halten // Добавление разделителя
        jLabelDummy.setPreferredSize(new Dimension(10, 0));
        jPanelButton.add(jLabelDummy);

        // 15.2 Ende

        // 16.1
        /*
        Этот код реализует функциональность кнопки "Отмена" (jButtonCancel), которая при нажатии на нее вызывает метод clearCharakterFormular() <- 23.2 und 23.1.
         */
        JButton jButtonCancel = new JButton("Zurücksetzen");
        jButtonCancel.setFont(new Font("Arial", Font.PLAIN, 20));
        jButtonCancel.setPreferredSize(new Dimension(200, 30));
        jButtonCancel.setFocusPainted(false);
        //23.2
        jButtonCancel.addActionListener(new ActionListener() { // Этот ActionListener добавляется к кнопке "Отмена" с помощью метода addActionListener(). Таким образом, когда пользователь нажимает на кнопку "Отмена", выполняется действие, определенное внутри actionPerformed().
            @Override // Создается анонимный класс ActionListener, который реализует метод actionPerformed(ActionEvent e).
            public void actionPerformed(ActionEvent e) {
                clearCharakterFormular(); // unten 23.1
            }
        });
        //23.2 Ende

        jPanelButton.add(jButtonCancel);

        // 16.1 Ende

        // 17 jPanelButton mit 2 Buttons hinzufügen
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        panelControls.add(jPanelButton, gbc);
        // 17 Ende


        panelCharakterFormular.add(panelControls);
        // 4.2 Ende

        return panelCharakterFormular;
    }

    //23.1
    private void clearCharakterFormular() {
        /*
        код позволяет сбросить введенные данные в форме на исходное состояние. Когда пользователь нажимает на кнопку "Отмена", вызывается метод clearCharakterFormular(), который очищает все поля и сбрасывает выбранные значения в форме, делая ее готовой для нового ввода данных.
         */

        avatarSpinner.setValue(Avatare.DEFAULT.toString());
        ImageIcon image = new ImageIcon(Avatare.DEFAULT.getAvatar());
        labelAvatar.setIcon(image);
        textFieldCharakterName.setText("");
        jComboBoxVolkAuswahl.setSelectedIndex(0);
        jComboBoxKlasseAuswahl.setSelectedIndex(0);
        jCheckBoxKorrekt.setSelected(false);
    }
    //23.1 Ende

    // 15.1
    private JButton getButtonBestaetigen() {
        JButton button = new JButton("Bestätigen");
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.setPreferredSize(new Dimension(200, 30));
        button.setFocusPainted(false);

        // 21.1
        /* das unten VERKÜRZEN
        В языке программирования Java метод addActionListener используется для регистрации слушателя событий (или обработчика событий) на определенном компоненте, обычно кнопке. Этот метод является частью библиотеки Java Swing, которая используется для создания графических пользовательских интерфейсов (GUI).

Вот что происходит, когда используется button.addActionListener:

1. Регистрация обработчика событий:
   Когда вы вызываете button.addActionListener, вы передаете ему объект, который реализует интерфейс ActionListener. Этот объект обычно создается с помощью анонимного внутреннего класса или с использованием лямбда-выражения (начиная с Java 8).

2. Интерфейс ActionListener:
   Интерфейс ActionListener содержит один метод actionPerformed(ActionEvent e). Этот метод должен быть реализован в вашем обработчике событий, чтобы определить, какие действия должны быть выполнены, когда событие происходит (в данном случае, когда пользователь нажимает на кнопку).

3. Обработка события:
   Когда пользователь нажимает на кнопку, система вызывает метод actionPerformed у всех зарегистрированных слушателей событий для этой кнопки. Код внутри этого метода выполняется, и в нем можно определить любое поведение, которое необходимо при нажатии кнопки.

Пример использования button.addActionListener:

JButton button = new JButton("Click Me");

button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button was clicked!");
    }
});
В этом примере создается кнопка с текстом "Click Me". Затем к этой кнопке добавляется слушатель событий с помощью метода addActionListener. Слушатель представляет собой анонимный внутренний класс, который реализует интерфейс ActionListener. Когда кнопка нажимается, метод actionPerformed выводит в консоль сообщение "Button was clicked!".

Основные моменты:

- button.addActionListener регистрирует объект, реализующий интерфейс ActionListener, как слушателя событий для кнопки.
- Когда кнопка нажимается, вызывается метод actionPerformed у всех зарегистрированных слушателей.
- В методе actionPerformed определяется, что должно произойти в ответ на нажатие кнопки.

Это ключевой механизм для обработки событий в графических пользовательских интерфейсах на Java.
         */
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jCheckBoxKorrekt.isSelected()) { // Если флажок jCheckBoxKorrekt не выбран, то создается новое диалоговое окно, используя класс Dialog. Иначе выполняется оставшаяся часть кода.
                    new Dialog();
                } else {
                    /*
                    Этот участок кода (bis 21.3 Ende) создает панель вывода персонажа, содержащую изображение персонажа (полученное из avatarSpinner), имя персонажа, выбранные национальность и класс. Затем созданная панель добавляется в listModel.
                     */
                    String selectedAvatar = (String) avatarSpinner.getValue();
                    String charakterName = textFieldCharakterName.getText();
                    String volksAuswahl = (String) jComboBoxVolkAuswahl.getSelectedItem();
                    String klassenAuswahl = (String) jComboBoxKlasseAuswahl.getSelectedItem();

                    // 21.3
                    // Создание панели вывода персонажа
                    panelCharakterAusgabe = new JPanel(new BorderLayout());
                    panelCharakterAusgabe.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
                    JLabel avatarLabel = null;
                    for (Avatare a : Avatare.values()) {
                        if (selectedAvatar.equals(a.toString())) {
                            ImageIcon imageIcon = new ImageIcon(a.getAvatar());
                            avatarLabel = new JLabel(imageIcon);
                            avatarLabel.setPreferredSize(new Dimension(160, 160));
                            avatarLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                        }
                    }
                    panelCharakterAusgabe.add(avatarLabel, BorderLayout.WEST);

                    JPanel textPanel = new JPanel(new GridLayout(3, 1));
                    textPanel.add(new JLabel("    Charaktername: " + charakterName));
                    textPanel.add(new JLabel("    Volk: " + volksAuswahl));
                    textPanel.add(new JLabel("    Klasse: " + klassenAuswahl));
                    panelCharakterAusgabe.add(textPanel, BorderLayout.CENTER);

                    listModel.addElement(panelCharakterAusgabe);
                    // 21.3 Ende
                }
            }
        });
        /*
        при нажатии на кнопку "Bestätigen" программа проверяет состояние флажка. Если флажок не выбран, открывается новое диалоговое окно, предупреждающее пользователя. Если флажок выбран, программа создает панель вывода персонажа с данными, введенными пользователем, и добавляет ее в listModel.
         */
        // 21.1 Ende

        return button;

    }

    // 15.1 Ende

    private JPanel erstelleAusgabe() {
        JPanel panelAusgabe = new JPanel(new BorderLayout());

        // 19
        /* das unten VERKÜRZEN
        В данном фрагменте кода на языке Java создается список (JList), который отображает элементы типа JPanel, и устанавливается пользовательский рендерер ячеек для этого списка. Далее список помещается в компонент прокрутки (JScrollPane). Вот что происходит пошагово:

1. Создание JList с моделью данных:

   JList<JPanel> listAusgabe = new JList<>(listModel);

   Здесь создается объект JList, который принимает модель данных listModel. Модель данных (предположительно) представляет собой список объектов типа JPanel.

2. Установка рендерера ячеек:

   listAusgabe.setCellRenderer(new ListCellRenderer<JPanel>() {
       @Override
       public Component getListCellRendererComponent(JList<? extends JPanel> list, JPanel panel, int index, boolean isSelected, boolean cellHasFocus) {
           return panel;
       }
   });

   Этот блок кода устанавливает пользовательский рендерер для ячеек списка с помощью метода setCellRenderer. Рендерер — это объект, реализующий интерфейс ListCellRenderer. В данном случае используется анонимный внутренний класс, который реализует метод getListCellRendererComponent.

   - Метод getListCellRendererComponent принимает несколько параметров:
     - list: сам список JList.
     - panel: объект JPanel, который является элементом списка и который нужно отрендерить.
     - index: индекс текущего элемента в списке.
     - isSelected: булево значение, указывающее, выбрана ли данная ячейка.
     - cellHasFocus: булево значение, указывающее, имеет ли ячейка фокус.

   В данном методе просто возвращается переданный panel, что означает, что каждый элемент списка будет отображаться как есть, без каких-либо изменений или дополнений.

3. Добавление списка в компонент прокрутки:

   JScrollPane scrollPane = new JScrollPane(listAusgabe);

   Этот шаг создает объект JScrollPane, в который помещается ранее созданный JList (listAusgabe). Это позволяет сделать список прокручиваемым, если количество элементов превышает видимую область списка.

Основные моменты:

- Создается список JList, элементы которого являются объектами типа JPanel.
- Устанавливается пользовательский рендерер для ячеек списка, который просто возвращает сами панели (JPanel) без изменений.
- Список помещается в прокручиваемый контейнер (JScrollPane), что позволяет пользователю прокручивать список, если он выходит за пределы видимой области.

Таким образом, этот код подготавливает список графических панелей для отображения в графическом интерфейсе с возможностью прокрутки.
         */
        JList<JPanel> listAusgabe = new JList<>(listModel);

        listAusgabe.setCellRenderer(new ListCellRenderer<JPanel>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends JPanel> list, JPanel panel, int index, boolean isSelected, boolean cellHasFokus) {
                return panel;
            }
        });

        JScrollPane scrollPane = new JScrollPane(listAusgabe);
        JPanel panelCharakter = new JPanel(new BorderLayout());
        panelCharakter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCharakter.add(scrollPane, BorderLayout.CENTER);
        panelAusgabe.add(panelCharakter, BorderLayout.CENTER);

        JPanel panelButtonLoeschen = new JPanel(new BorderLayout());
        panelButtonLoeschen.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JButton jButtonLoeschen = new JButton("Liste löschen");
        jButtonLoeschen.setFont(new Font("Arial", Font.PLAIN, 20));
        jButtonLoeschen.setPreferredSize(new Dimension(200, 30));
        jButtonLoeschen.setFocusPainted(false);
        // 22
        jButtonLoeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.clear();
            }
        });
        // 22 Ende

        panelButtonLoeschen.add(jButtonLoeschen, BorderLayout.EAST);
        panelAusgabe.add(panelButtonLoeschen, BorderLayout.SOUTH);
        // 19 Ende

        return panelAusgabe;
    } // 4.1 Ende

}
