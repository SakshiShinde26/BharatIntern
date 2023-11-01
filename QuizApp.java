import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame {

    private JTextArea questionTextArea;
    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private JRadioButton optionD;
    private JButton nextButton;

    private int questionIndex = 0;
    private int score = 0;

    // Questions for the quiz 
    private String[][] questions = {
            {"What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "Paris"},
            {"Which planet is known as the Red Planet?", "Earth", "Mars", "Venus", "Jupiter", "Mars"},
            {"Who painted the Mona Lisa?", "Vincent van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Michelangelo", "Leonardo da Vinci"}
    };

    public QuizApp() {
        setTitle("Simple Quiz App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        questionTextArea = new JTextArea(5, 20);
        questionTextArea.setLineWrap(true);
        questionTextArea.setWrapStyleWord(true);
        questionTextArea.setFont(new Font("Arial", Font.PLAIN, 18)); 
        questionTextArea.setEditable(false);
        panel.add(questionTextArea);

        optionA = new JRadioButton();
        optionB = new JRadioButton();
        optionC = new JRadioButton();
        optionD = new JRadioButton();

        ButtonGroup group = new ButtonGroup();
        group.add(optionA);
        group.add(optionB);
        group.add(optionC);
        group.add(optionD);

        Font radioButtonFont = new Font("Arial", Font.PLAIN, 16); 

        optionA.setFont(radioButtonFont);
        optionB.setFont(radioButtonFont);
        optionC.setFont(radioButtonFont);
        optionD.setFont(radioButtonFont);

        panel.add(optionA);
        panel.add(optionB);
        panel.add(optionC);
        panel.add(optionD);

        nextButton = new JButton("Next");
        panel.add(nextButton);

        add(panel);

        displayQuestion(questionIndex);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(questionIndex);
                questionIndex++;
                if (questionIndex < questions.length) {
                    displayQuestion(questionIndex);
                } else {
                    showResult();
                }
            }
        });
    }

    private void displayQuestion(int index) {
        questionTextArea.setText(questions[index][0]);
        optionA.setText(questions[index][1]);
        optionB.setText(questions[index][2]);
        optionC.setText(questions[index][3]);
        optionD.setText(questions[index][4]);
        optionA.setSelected(false);
        optionB.setSelected(false);
        optionC.setSelected(false);
        optionD.setSelected(false);
    }

    private void checkAnswer(int index) {
        if (optionA.isSelected() && optionA.getText().equals(questions[index][5])) {
            score++;
        } else if (optionB.isSelected() && optionB.getText().equals(questions[index][5])) {
            score++;
        } else if (optionC.isSelected() && optionC.getText().equals(questions[index][5])) {
            score++;
        } else if (optionD.isSelected() && optionD.getText().equals(questions[index][5])) {
            score++;
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Quiz completed!\nYour score is: " + score + "/" + questions.length);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuizApp app = new QuizApp();
            app.setVisible(true);
        });
    }
}
