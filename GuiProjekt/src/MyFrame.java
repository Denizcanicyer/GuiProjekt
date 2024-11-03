import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyFrame extends JFrame implements ActionListener, MouseMotionListener, MouseListener {


    static int x = 100;
    static int y = 400;
    JTextField jTextFieldGroeße;
    JTextField jTextFieldGewicht;
    JTextField jTextFieldx;
    JTextField jTextFieldy;
    JButton jButton;
    JButton jButton1;
    JButton jButton2;
    JLabel jLabel;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel picLabel;
    JLabel picLabel1;
    JLabel picLabel2;
    JLabel picLabel3;
    JLabel picLabel4;
    JMenuItem bmibestimmen;
    JMenuItem beenden;
    JMenuItem position;
    Circle circle = new Circle();
    int xpos = 100;
    int ypos = 100;
    float groeßee = (float) 1.85;
    float gewicht = 70;
    int timer = 1;
    JDialog postionFenster = new JDialog();
    JPanel panel = new JPanel() {
        public void paintComponent(Graphics g) {
            g.drawString("string", xpos, ypos);
        }
    };

    MyFrame() throws IOException {

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                String s = "Zieh mich";
                int centerpoint = circle.getX()-30;
                int cent = circle.getY()-30;
                int stringWidth = (int) Math.floor(g.getFontMetrics().getStringBounds(s, g).getWidth());
                FontMetrics fm = g.getFontMetrics();
                g.drawString(s, centerpoint + stringWidth / 2, cent + fm.getMaxAscent() / 2);
            }
        };
        this.add(panel);


        JDialog bmiFenster = new JDialog();

        JMenuBar menuBar = new JMenuBar();
        jLabel = new JLabel();
        JMenu menuFile = new JMenu("Menü");
        JMenu submenu = new JMenu("Datei");
        bmibestimmen = new JMenuItem("BMI bestimmen");
        beenden = new JMenuItem("Datei Schließen");
        position = new JMenuItem("Position wähelen");
        bmibestimmen.addActionListener(this);
        beenden.addActionListener(this);
        position.addActionListener(this);

        ;
        menuFile.add(bmibestimmen);
        submenu.add(position);
        submenu.add(beenden);
        menuFile.add(submenu);
        menuBar.add(menuFile);

        jTextFieldGroeße = new JTextField();
        jTextFieldGroeße.setText(String.valueOf(groeßee));
        jTextFieldGroeße.setSize(new Dimension(100, 40));
        jTextFieldGroeße.setLocation(75, 100);
        jTextFieldGroeße.setVisible(true);


        jTextFieldGewicht = new JTextField();
        jTextFieldGewicht.setText(String.valueOf(gewicht));
        jTextFieldGewicht.setSize(new Dimension(100, 40));
        jTextFieldGewicht.setLocation(75, 180);
        jTextFieldGewicht.setVisible(true);

        jButton = new JButton("BMI bestimmen");
        jButton.setBounds(75, 250, 150, 20);
        jButton.addActionListener(this);
        jButton.setVisible(true);

        jLabel = new JLabel("Körpergröße eingeben");
        jLabel.setBounds(75, 10, 300, 150);
        jLabel.setVisible(true);

        jLabel1 = new JLabel("Gewicht eingeben");
        jLabel1.setBounds(75, 80, 300, 150);
        jLabel1.setVisible(true);

        jLabel2 = new JLabel();
        jLabel2.setBounds(75, 270, 300, 150);
        jLabel2.setVisible(true);


        BufferedImage myPicture = ImageIO.read(new File("BMIGrafik1.jpg"));
        picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(275, 100, 300, 600);
        picLabel.setVisible(false);

        BufferedImage myPicture1 = ImageIO.read(new File("BMIGrafik2.jpg"));
        picLabel1 = new JLabel(new ImageIcon(myPicture1));
        picLabel1.setBounds(275, 100, 300, 600);
        picLabel1.setVisible(false);

        BufferedImage myPicture2 = ImageIO.read(new File("BMIGrafik3.jpg"));
        picLabel2 = new JLabel(new ImageIcon(myPicture2));
        picLabel2.setBounds(275, 100, 300, 600);
        picLabel2.setVisible(false);

        BufferedImage myPicture3 = ImageIO.read(new File("BMIGrafik4.jpg"));
        picLabel3 = new JLabel(new ImageIcon(myPicture3));
        picLabel3.setBounds(275, 100, 300, 600);
        picLabel3.setVisible(false);

        BufferedImage myPicture4 = ImageIO.read(new File("BMIGrafik5.jpg"));
        picLabel4 = new JLabel(new ImageIcon(myPicture4));
        picLabel4.setBounds(275, 100, 300, 600);
        picLabel4.setVisible(false);

        jTextFieldx = new JTextField();
        jTextFieldx.setText(String.valueOf(xpos));
        jTextFieldx.setSize(new Dimension(100, 40));
        jTextFieldx.setLocation(275, 100);
        jTextFieldx.setVisible(true);

        jLabel3 = new JLabel("X Position eingeben");
        jLabel3.setBounds(275, 10, 300, 150);
        jLabel3.setVisible(true);

        jTextFieldy = new JTextField();
        jTextFieldy.setText(String.valueOf(ypos));
        jTextFieldy.setSize(new Dimension(100, 40));
        jTextFieldy.setLocation(275, 180);
        jTextFieldy.setVisible(true);

        jLabel4 = new JLabel("Y Position eingeben");
        jLabel4.setBounds(275, 80, 300, 150);
        jLabel4.setVisible(true);

        jButton1 = new JButton("Übernehmen");
        jButton1.setBounds(275, 250, 150, 20);
        jButton1.addActionListener(this);
        jButton1.setVisible(true);

        jButton2 = new JButton("Ok");
        jButton2.setBounds(275, 300, 150, 20);
        jButton2.addActionListener(this);
        jButton2.setVisible(true);


        ImageIcon image1 = new ImageIcon("BMIGrafik1");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setJMenuBar(menuBar);
        this.setLocationRelativeTo(null);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.setLayout(null);
        this.add(panel);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Möchten Sie das Programm beenden?", "Warning", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    // Saving code here
                    System.exit(0);
                }

            }


        });

        bmibestimmen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent q) {

                bmiFenster.setSize(750, 750);
                bmiFenster.setVisible(true);
                bmiFenster.add(jTextFieldGroeße);
                bmiFenster.add(jTextFieldGewicht);
                bmiFenster.add(jButton);
                bmiFenster.add(jLabel);
                bmiFenster.add(jLabel1);
                bmiFenster.add(jLabel2);
                bmiFenster.add(picLabel);
                bmiFenster.add(picLabel1);
                bmiFenster.add(picLabel2);
                bmiFenster.add(picLabel3);
                bmiFenster.add(picLabel4);
                bmiFenster.getContentPane().setLayout(null);
                if (q.getSource() == beenden) {
                    ende();


                }


            }

        });


        jTextFieldGewicht.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {

                    double groeßeZahl = 0;
                    double gewichtZahl = 0;
                    jLabel2.setVisible(true);
                    String groeße = jTextFieldGroeße.getText();
                    String gewicht = jTextFieldGewicht.getText();

                    try {

                        groeßeZahl = Double.parseDouble(groeße);
                        gewichtZahl = Double.parseDouble(gewicht);
                    } catch (NumberFormatException q) {
                        JOptionPane.showMessageDialog(null, "Fehlerhafte Eingabe", "Titel", JOptionPane.ERROR_MESSAGE);
                    }

                    if (groeßeZahl <= 0 || gewichtZahl <= 0) {
                        JOptionPane.showMessageDialog(null, "Fehlerhafte Eingabe", "Titel", JOptionPane.ERROR_MESSAGE);

                    }


                    double rechnung = gewichtZahl / (groeßeZahl * groeßeZahl);
                    jLabel2.setText("BMI : " + round(rechnung, 2));
                    if (rechnung > 5 && rechnung < 18) {
                        picLabel.setVisible(true);
                        picLabel1.setVisible(false);
                        picLabel2.setVisible(false);
                        picLabel3.setVisible(false);
                        picLabel4.setVisible(false);
                    } else if (rechnung > 18.5 && rechnung < 24.5) {
                        picLabel.setVisible(false);
                        picLabel1.setVisible(true);
                        picLabel2.setVisible(false);
                        picLabel3.setVisible(false);
                        picLabel4.setVisible(false);
                    } else if (rechnung > 25 && rechnung < 29) {
                        picLabel.setVisible(false);
                        picLabel1.setVisible(false);
                        picLabel2.setVisible(true);
                        picLabel3.setVisible(false);
                        picLabel4.setVisible(false);
                    } else if (rechnung > 30 && rechnung < 34) {
                        picLabel.setVisible(false);
                        picLabel1.setVisible(false);
                        picLabel2.setVisible(false);
                        picLabel3.setVisible(true);
                        picLabel4.setVisible(false);
                    } else if (rechnung > 35) {
                        picLabel.setVisible(false);
                        picLabel1.setVisible(false);
                        picLabel2.setVisible(false);
                        picLabel3.setVisible(false);
                        picLabel4.setVisible(true);
                    }
                }
            }
        });

        jTextFieldGroeße.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    double groeßeZahl = 0;
                    double gewichtZahl = 0;
                    jLabel2.setVisible(true);
                    String groeße = jTextFieldGroeße.getText();
                    String gewicht = jTextFieldGewicht.getText();

                    try {

                        groeßeZahl = Double.parseDouble(groeße);
                        gewichtZahl = Double.parseDouble(gewicht);
                    } catch (NumberFormatException q) {
                        JOptionPane.showMessageDialog(null, "Fehlerhafte Eingabe", "Titel", JOptionPane.ERROR_MESSAGE);
                    }

                    if (groeßeZahl <= 0 || gewichtZahl <= 0) {
                        JOptionPane.showMessageDialog(null, "Fehlerhafte Eingabe", "Titel", JOptionPane.ERROR_MESSAGE);

                    }


                    double rechnung = gewichtZahl / (groeßeZahl * groeßeZahl);
                    jLabel2.setText("BMI : " + round(rechnung, 2));
                    if (rechnung > 5 && rechnung < 18) {
                        picLabel.setVisible(true);
                        picLabel1.setVisible(false);
                        picLabel2.setVisible(false);
                        picLabel3.setVisible(false);
                        picLabel4.setVisible(false);
                    } else if (rechnung > 18.5 && rechnung < 24.5) {
                        picLabel.setVisible(false);
                        picLabel1.setVisible(true);
                        picLabel2.setVisible(false);
                        picLabel3.setVisible(false);
                        picLabel4.setVisible(false);
                    } else if (rechnung > 25 && rechnung < 29) {
                        picLabel.setVisible(false);
                        picLabel1.setVisible(false);
                        picLabel2.setVisible(true);
                        picLabel3.setVisible(false);
                        picLabel4.setVisible(false);
                    } else if (rechnung > 30 && rechnung < 34) {
                        picLabel.setVisible(false);
                        picLabel1.setVisible(false);
                        picLabel2.setVisible(false);
                        picLabel3.setVisible(true);
                        picLabel4.setVisible(false);
                    } else if (rechnung > 35) {
                        picLabel.setVisible(false);
                        picLabel1.setVisible(false);
                        picLabel2.setVisible(false);
                        picLabel3.setVisible(false);
                        picLabel4.setVisible(true);
                    }
                }
            }
        });

        position.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postionFenster.setSize(750, 750);
                postionFenster.setVisible(true);
                postionFenster.add(jTextFieldx);
                postionFenster.add(jTextFieldy);
                postionFenster.add(jButton1);
                postionFenster.add(jButton2);
                postionFenster.add(jLabel3);
                postionFenster.add(jLabel4);
                postionFenster.getContentPane().setLayout(null);

            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent q) {
        if (q.getSource() == jButton) {
            double groeßeZahl = 0;
            double gewichtZahl = 0;
            jLabel2.setVisible(true);
            String groeße = jTextFieldGroeße.getText();
            String gewicht = jTextFieldGewicht.getText();

            try {

                groeßeZahl = Double.parseDouble(groeße);
                gewichtZahl = Double.parseDouble(gewicht);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Fehlerhafte Eingabe", "Titel", JOptionPane.ERROR_MESSAGE);
            }

            if (groeßeZahl <= 0 || gewichtZahl <= 0) {
                JOptionPane.showMessageDialog(null, "Fehlerhafte Eingabe", "Titel", JOptionPane.ERROR_MESSAGE);

            }


            double rechnung = gewichtZahl / (groeßeZahl * groeßeZahl);
            jLabel2.setText("BMI : " + round(rechnung, 2));
            if (rechnung > 5 && rechnung < 18) {
                picLabel.setVisible(true);
                picLabel1.setVisible(false);
                picLabel2.setVisible(false);
                picLabel3.setVisible(false);
                picLabel4.setVisible(false);
            } else if (rechnung > 18.5 && rechnung < 24.5) {
                picLabel.setVisible(false);
                picLabel1.setVisible(true);
                picLabel2.setVisible(false);
                picLabel3.setVisible(false);
                picLabel4.setVisible(false);
            } else if (rechnung > 25 && rechnung < 29) {
                picLabel.setVisible(false);
                picLabel1.setVisible(false);
                picLabel2.setVisible(true);
                picLabel3.setVisible(false);
                picLabel4.setVisible(false);
            } else if (rechnung > 30 && rechnung < 34) {
                picLabel.setVisible(false);
                picLabel1.setVisible(false);
                picLabel2.setVisible(false);
                picLabel3.setVisible(true);
                picLabel4.setVisible(false);
            } else if (rechnung > 35) {
                picLabel.setVisible(false);
                picLabel1.setVisible(false);
                picLabel2.setVisible(false);
                picLabel3.setVisible(false);
                picLabel4.setVisible(true);
            }

        }
        if (q.getSource() == jButton1) {
            String x = jTextFieldx.getText();
            String y = jTextFieldy.getText();

            int zahlx = Integer.parseInt(x);
            int zahly = Integer.parseInt(y);

            xpos = zahlx;
            ypos = zahly;
            moveOval(zahlx, zahly);
        }
        if (q.getSource() == jButton2) {
            postionFenster.dispose();
        }
        if (q.getSource() == beenden) {
            ende();

        }

    }

    public void paint(Graphics g) {
        super.paint(g);


        circle.paintSquare(g);


    }

    public void ende() {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Möchten Sie das Programm beenden?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // Saving code here
            System.exit(0);
        }


    }

    private double round(double value, int decimalPoints) {
        double d = Math.pow(10, decimalPoints);
        return Math.round(value * d) / d;
    }


    public void moveString(int x1, int y1) {

        x = x1;
        y = y1;
        panel.repaint();

    }

    @Override
    public void mouseDragged(MouseEvent e) {


        if (timer == 1) {


            moveOval(e.getX(), e.getY());
            moveString(e.getX() + (circle.getWidth() / 2) - (24 / 2), e.getY() + (circle.getWidth() / 2));

        }

    }


    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON3) {

            if (e.getClickCount() == 2) {
                if (timer == 0) {


                    timer = 1;
                } else {

                    timer = 0;
                }

            }


        }

        if (e.getButton() == MouseEvent.BUTTON1) {


            if (e.getClickCount() == 1) {
                if (timer == 1) {

                    if (e.getX() >= circle.getX() - (circle.getWidth() / 10) && e.getY() >= circle.getY() - (circle.getWidth() / 10) && e.getX() <= circle.getX() + circle.getHeight() && e.getY() <= circle.getY() + circle.getWidth()) {

                        try {
                            new Robot().mouseMove(this.getX() + (circle.getX() + (circle.getWidth() / 2)), this.getY() + circle.getY() + (circle.getWidth() / 2));
                        } catch (AWTException awtException) {
                            awtException.printStackTrace();
                        }
                    }
                }

            }

            if (e.getClickCount() == 2) {
                if (timer == 1) {
                    moveOval(xpos, ypos);
                }


            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void moveOval(int x, int y) {


        final int CURR_X = circle.getX();
        final int CURR_Y = circle.getY();


        if ((CURR_X != x) || (CURR_Y != y)) {


            circle.setX(x);
            circle.setY(y);
            repaint();


        }

    }

    class Circle {

        private int xPos = 100;
        private int yPos = 100;
        private int width = 60;
        private int height = 60;

        public int getX() {
            return xPos;
        }

        public void setX(int xPos) {
            this.xPos = xPos;
        }

        public int getY() {
            return yPos;
        }

        public void setY(int yPos) {
            this.yPos = yPos;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }


        public void paintSquare(Graphics g) {

            g.setColor(Color.BLACK);
            g.drawOval(xPos, yPos, width, height);

        }

    }


}

