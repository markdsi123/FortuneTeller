import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Random;
import static java.awt.BorderLayout.NORTH;
public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl, titlePnl, displayPnl, buttonPnl;
    ImageIcon icon;
    JScrollPane scroll;
    JLabel titleLbl;
    JButton quitBtn, fortuneBtn;
    JTextArea fortuneTextArea;
    int newEntry = 1;
    int currentFortunes = -1;
    String[] fortunes =
            {       "You will be a millionaire in the next 10 years",
                    "You will be hired tomorrow",
                    "You will do well in the exam",
                    "Your aunt will call you today",
                    "You will be called a genius by your friend tomorrow",
                    "You will have a huge mansion",
                    "Be careful on Tuesday.",
                    "You will go to a class very soon.",
                    "You will soon be engaged in social working.",
                    "You will have broccoli for lunch",
                    "You will have very good luck today.",
                    "You will do good in programming for rest of your life"
            };
    Random rnd = new Random();
    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);
        createTitlePanel();
        createDisplayPanel();
        createCommandPanel();
        setVisible(true);
    }
    public void createTitlePanel() {
        titlePnl = new JPanel();
        icon = new ImageIcon("src\\fortuneteller.jpg", "fortune teller image");
        this.setIconImage(icon.getImage());
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setFont(new Font("Comic Sans Ms", Font.BOLD, 50));
        mainPnl.add(titleLbl, NORTH);
    }

    public void createCommandPanel() {
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1, 2));

        quitBtn = new JButton("Quit");
        fortuneBtn = new JButton("Get A Fortune");
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
            do
            {
                newEntry = rnd.nextInt(fortunes.length);
            }
            while (newEntry == currentFortunes);

            currentFortunes = newEntry;
            fortuneTextArea.append(fortunes[currentFortunes] + "\n");
        });

        buttonPnl.add(fortuneBtn);
        buttonPnl.add(quitBtn);
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        mainPnl.add(buttonPnl, BorderLayout.SOUTH);
    }

    private void createDisplayPanel() {
        displayPnl = new JPanel();
        fortuneTextArea = new JTextArea(10, 60);
        scroll = new JScrollPane(fortuneTextArea);
        displayPnl.add(scroll);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
    }
}