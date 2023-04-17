package myPresentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Color.BLACK;

public class Main extends JFrame {
    //atributos
    private JButton myPhoto, myHobby, myExpectations;
    private Title title;
    private JPanel containerButtons, containerImage;
    private JLabel imageLabel;
    private Listener listener;
    private JTextArea expectations;

    //metodos
    public Main() {
        initGUI();
        this.setTitle("My Presentation");
        this.setSize(800, 650);//Tamano de ventana
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initGUI() {
        title = new Title("Hi..stranger", BLACK);
        myPhoto = new JButton("This is me");
        myHobby = new JButton("This is my hobby");
        myExpectations = new JButton("What I expected");
        containerButtons = new JPanel();
        containerImage = new JPanel();
        listener = new Listener();
        imageLabel = new JLabel();
        expectations = new JTextArea(12, 12);


        containerImage.setBorder(BorderFactory.createTitledBorder(null, "This is a little bit about me:", TitledBorder.CENTER,
                TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.MONOSPACED, Font.PLAIN, 20), BLACK));
        containerImage.add(imageLabel);
        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);
        containerButtons.add(myExpectations);

        //Actions performed
        myPhoto.addActionListener(listener);
        myHobby.addActionListener(listener);
        myExpectations.addActionListener(listener);

        //Mouse Events
        myHobby.addMouseListener(listener);
        myExpectations.addMouseListener(listener);
        myPhoto.addMouseListener(listener);

        //Key Listener
        myPhoto.addKeyListener(listener);
        myHobby.addKeyListener(listener);
        myExpectations.addKeyListener(listener);

        this.add(title, BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerImage, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main myGui = new Main();
            }
        });
    }

    private class Listener implements ActionListener, MouseListener, KeyListener {

        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == myPhoto) {
                containerImage.remove(expectations);
                imageLabel.setIcon(null);
                this.image = new ImageIcon(getClass().getResource("/myPresentation/recursos/barbie.jpg"));
                imageLabel.setIcon(image);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == myHobby && e.getClickCount() == 2){
                containerImage.remove(expectations);
                imageLabel.setIcon(null);
                this.image = new ImageIcon(getClass().getResource("/myPresentation/recursos/jake.gif"));
                imageLabel.setIcon(image);
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            //JOptionPane.showMessageDialog(null,"pressed");
            if(e.getKeyCode() == 77){
                imageLabel.setIcon(null);
                expectations.setText("Learn enough to charge my boss more...I also want to have a good internship as a software developer and improve my skills");
                expectations.setBackground(null);
                expectations.setForeground(Color.BLACK);
                containerImage.add(expectations);
                repaint();
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}