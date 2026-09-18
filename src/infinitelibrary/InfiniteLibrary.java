package infinitelibrary;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class InfiniteLibrary extends JFrame {

    private JTextField inputField;
    private JTextArea resultArea;

    private final LibraryEngine libraryEngine;

    public InfiniteLibrary() {

        libraryEngine =
                new LibraryEngine();

        setTitle("The Infinite Library");

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLayout(
                new BorderLayout(10, 10)
        );

        // =========================
        // TITLE
        // =========================

        JLabel title =
                new JLabel(
                        "THE INFINITE LIBRARY",
                        SwingConstants.CENTER
                );

        title.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        24
                )
        );

        add(
                title,
                BorderLayout.NORTH
        );

        // =========================
        // INPUT
        // =========================

        JPanel inputPanel =
                new JPanel(
                        new BorderLayout(5, 5)
                );

        inputField =
                new JTextField();

        JButton searchButton =
                new JButton(
                        "Find in Library"
                );

        inputPanel.add(
                new JLabel("Enter text:"),
                BorderLayout.WEST
        );

        inputPanel.add(
                inputField,
                BorderLayout.CENTER
        );

        inputPanel.add(
                searchButton,
                BorderLayout.EAST
        );

        add(
                inputPanel,
                BorderLayout.CENTER
        );

        // =========================
        // RESULTS
        // =========================

        resultArea =
                new JTextArea();

        resultArea.setEditable(false);

        resultArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        12
                )
        );

        add(
                new JScrollPane(resultArea),
                BorderLayout.SOUTH
        );

        // =========================
        // BUTTON
        // =========================

        searchButton.addActionListener(
                e -> search()
        );

        // =========================
        // WINDOW
        // =========================

        setSize(900, 700);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    private void search() {

        String text =
                inputField
                        .getText()
                        .toUpperCase();

        if (text.isEmpty()) {

            resultArea.setText(
                    "Please enter some text."
            );

            return;
        }

        try {

            SearchResult result =
                    libraryEngine.search(text);

            resultArea.setText(

                    "TEXT FOUND\n\n" +

                    "Original text:\n" +
                    result.getText() +

                    "\n\nLIBRARY LOCATION\n" +
                    "────────────────────────\n" +
                    result.getLocation() +

                    "\n\nPAGE\n" +
                    "────────────────────────\n" +
                    result.getPage() +

                    "\n\nDecoded text:\n" +
                    result.getDecoded()
            );

        } catch (IllegalArgumentException ex) {

            resultArea.setText(
                    ex.getMessage()
            );
        }
    }

    public static void main(
            String[] args) {

        SwingUtilities.invokeLater(() -> {

            new InfiniteLibrary();

        });
    }
}