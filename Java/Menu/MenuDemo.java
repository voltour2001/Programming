import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Java Menu Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Calculate the center position for the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(centerX, centerY);

        frame.setLayout(new BorderLayout());

        // Create a label to display text with HTML and CSS for padding
        JLabel label = new JLabel("<html><div style='padding: 10px; font-size: 18;'>Select from menu to have info regarding the selected item.</div><br><br></html>");
        label.setHorizontalAlignment(JLabel.CENTER);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu
        JMenu menu = new JMenu("Options");

        // Create menu items for each option
        JMenuItem option1MenuItem = new JMenuItem("Option 1");
        JMenuItem option2MenuItem = new JMenuItem("Option 2");
        JMenuItem option3MenuItem = new JMenuItem("Option 3");

        // Add action listeners to the menu items
        option1MenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String menuText = """
                    <html><br>
                        <div style='text-align: center; font-size: 24;'>
                            <strong>Java Intro</strong><br><br>
                        </div>
                        <hr style='width: 50%; border: none; height: 2px; margin-bottom: 20px;'>
                            <div style='padding: 10px;text-align: center; font-size: 12px;'> 
                                Java is a general-purpose, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.<br><br>
                                It is a concurrent language with a simple, object-oriented syntax that enables programmers to write clear, logical code for small and large-scale projects.<br>
                                Java is platform-independent, so code written for one platform can run on any other platform that has a Java Virtual Machine (JVM).<br>
                                This makes Java a popular choice for developing mobile and web applications, as well as enterprise software. 
                            </div>
                        <br><br>
                    </html>" + //
                        """;
                label.setText(menuText);
            }
        });

        option2MenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                String menuText = """
                    <html><br>
                        <div style='text-align: center; font-size: 24;'>
                            <strong>Java Executable</strong><br><br>
                        </div>
                    
                        
                    <hr style='width: 50%; border: none; height: 2px; margin-bottom: 20px;'>
                        <body>
                                
                                <div style='text-align: center; font-size: 18;margin-bottom: 5px;'>
                                    Step 1: Compile Your Java Code
                                </div>

                                <div style='background: #000000;'>
                                    <p style='padding:5px;color:white; font-size:10  px;'>
                                        >> javac MenuDemo.java
                                    </p>
                                </div>
                                
                                <br><br>
                                
                                <div style='text-align: center; font-size: 18;margin-bottom: 5px;'>
                                    Step 2: Create Manifest File
                                </div>
                                <p style='font-size:10px;margin-bottom: 5px;'>This is a simple txt file that has info inside it.</p>
                                <div style='background: #000000;'>
                                    <p style='padding:5px;color:white; font-size:10px;'>
                                        Main-Class: MenuDemo
                                    </p>
                                </div>
                                
                                <br><br>
                                
                                <div style='text-align: center; font-size: 18;margin-bottom: 5px;'>
                                    Step 3: Create Jar
                                </div>

                                <div style='background: #000000;'>
                                    <p style='padding:5px;color:white; font-size:10  px;'>
                                    >> jar cfm MenuDemo.jar manifest.txt *.class
                                    </p>
                                </div>
                                
                                <br><br>

                                <p style='font-size:14px;'> At this point you should have an executable jar file</p>
                                


                            </div>
                        </body>
                        <br><br>
                    </html>" + //
                        """;
                label.setText(menuText);
            }
        });

        option3MenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("<html><div style='padding: 10px;'>Option 3 selected.</div><br><br></html>");
            }
        });

        // Add menu items to the menu
        menu.add(option1MenuItem);
        menu.add(option2MenuItem);
        menu.add(option3MenuItem);

        // Add the menu to the menu bar
        menuBar.add(menu);

        // Create a panel to hold the label
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(label, BorderLayout.NORTH); // Place label at the top

        // Add components to the frame
        frame.setJMenuBar(menuBar);
        frame.add(textPanel, BorderLayout.CENTER); // Place text panel at the center

        frame.setVisible(true);
        }
    }    

