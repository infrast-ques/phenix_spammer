package help.phenix.mainScript;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {

    private JButton buttonStart = new JButton("Ёкарный бабай, жми!");
    private JTextField textField = new JTextField("Сюда введи количество потоков (сколько браузеров у тебя откроется)", 25);
    private JTextField textFieldTile = new JTextField("Сюда нужно ввести заголовок", 25);
    private JTextField textFieldDescription = new JTextField("Сюда нужно ввести описание (рекламное сообщение), которое будет отправляться", 25);
    private JLabel labelAmountThread = new JLabel("Заполни поля ниже, (в первое поле введи цифру) затем нажми кнопку только 1 раз, и больше не нажимай на нее, а то будет взрыв.");
    private JLabel labelAmountThread1 = new JLabel("Браузеры которые откроются лучше не трогать), если будут вопросы то спрашивай");
    private JLabel labelAmountThread2 = new JLabel("Завершить прогу можно нажав крестик в этом окне, но лучше этого не делать раньше времени");

    public GUI() {
        super("Тададам");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 75, 815, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(7, 1, 2, 2));
        p.add(labelAmountThread);
        p.add(labelAmountThread1);
        p.add(labelAmountThread2);
        p.add(textField);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer.parseInt(textField.getText());
            }
        });
        p.add(textFieldTile);
        textFieldTile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldTile.getText();
            }
        });
        p.add(textFieldDescription);
        textFieldDescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldDescription.getText();
            }
        });

        p.add(buttonStart);
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Methods().startTread(Integer.parseInt(textField.getText()), textFieldTile.getText(), textFieldDescription.getText());
            }
        });

        this.add(p);
    }
}
