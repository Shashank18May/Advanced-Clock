import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class MyFrame implements ActionListener {

    //  ---------------------*****STOPWATCH*****--------------------------------




    JFrame frame = new JFrame();
    JFrame ok1 = new JFrame();
    JFrame ok2 = new JFrame();
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timelabel = new JLabel();
    int elaspedTime = 0;
    int miliseconds = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    JPanel tab2 = new JPanel();
    boolean started = false;
    String milisecond_string = String.format("%02d", miliseconds);
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(10, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            elaspedTime+=10;
            hours = (elaspedTime/3600000);
            minutes = (elaspedTime/60000)%60;
            seconds = (elaspedTime/1000)%60;
            miliseconds= (elaspedTime/10)%100;

            milisecond_string = String.format("%02d", miliseconds);
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timelabel.setText(hours_string+":"+minutes_string+":"+seconds_string+":"+milisecond_string);


        }
    });

//   --------------************----------------************--------------**************-------------**************

//  ----------------------------------****COUNTDOWN TIMER*****----------------------------------------------------


    JLabel label = new JLabel();
    JButton Start = new JButton("START");
    JTextField textField;
    long elaspedtime = 0;
    long hour = 0;
    long minute = 0;
    long second = 0;
    long i;
    String hour_string = String.format("%02d", hour);
    String minute_string = String.format("%02d", minute);
    String second_string = String.format("%02d", second);
    JLabel label2 = new JLabel("HEY! TIME OVER ");
    JLabel label3 = new JLabel("HEY! TIME OVER ");
    String text;
    boolean start = false;
    Timer timer2 = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            elaspedtime -= 1000;
            if (elaspedtime == -1000){
                stop2();
                Start.setText("START");
                start = false;
            }
            else {
                hour = (elaspedtime / 3600000);
                minute = (elaspedtime / 60000) % 60;
                second = (elaspedtime / 1000) % 60;

                second_string = String.format("%02d", second);
                minute_string = String.format("%02d", minute);
                hour_string = String.format("%02d", hour);
                label.setText("  " + hour_string + ":" + minute_string + ":" + second_string + "  ");
                    if(second == 0 && minute == 0 && hour ==0){
                        label2.setFont(new Font("Ink Free", Font.BOLD, 35));
                        label3.setFont(new Font("Ink Free", Font.BOLD, 35));
                        ok2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        ok2.setSize(450,100);
                        ok2.setLocation(1000,770);
                        label3.setBackground(new Color(255,0,0));
                        label3.setForeground(new Color(0, 0, 255));
                        label3.setOpaque(true);
                        ok2.add(label3);
                        ok2.setVisible(true);
                        ok1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        ok1.setVisible(true);
                        ok1.setSize(450,100);
                        ok1.setLocation(1000,0);
                        label2.setForeground(new Color(255,0,0));
                        label2.setBackground(new Color(0, 0, 255));
                        label2.setOpaque(true);
                        ok1.add(label2);
                        ok1.setVisible(true);}
            }

        }

    });

//    ********--------------------***********************-------------------------****************

//    ------------------------****CLOCK****-------------------------------------------

    SimpleDateFormat timeFromat;
    JLabel timeName;

//    -----------------------***************************-------------------------------
//     ++++++++++++++++++++++++++ TIMER AND STOPWATCH +++++++++++++++++++++++++++++++++

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton){
            if(!started){
                started = true;
                startButton.setText("STOP");
                start();

            }
            else {
                started = false;
                startButton.setText("START");
                stop();
            }
        }
        if(e.getSource()==resetButton){
            started = false;
            startButton.setText("START");
            reset();

        }
        if(e.getSource()==Start){
            if(elaspedtime<0){
                timer2.stop();
                Start.setText("START");
            }
            else{
            if(!start){
                start = true;
                Start.setText("Dismiss");
                start2();
            }
            else {
                start = false;
                Start.setText("START");
                stop2();
            }
        }
        }
    }

   // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    MyFrame() {
// |||||||||||||||||||||||---------- MAIN FRAME -----------|||||||||||||||||||||||||||||||
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        frame.setSize(400, 200);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.setLocation(0, 0);
        frame.setVisible(true);

// ______________________~~~~~~~~~~~~~~~~~~~~~~~~~~~~________________________________________

//           ================= MAIN CLOCK ===================

        timeFromat = new SimpleDateFormat("  hh:mm:ss a");
        timeName = new JLabel();
        timeName.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeName.setForeground(new Color(0, 0, 204));
        timeName.setBackground(Color.YELLOW);
        timeName.setOpaque(true);

//     -----------------***************-------------------*****************--------------

//     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^  STOPWATCH ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

        timelabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string + ":" + milisecond_string);
        timelabel.setBounds(100, 100, 200, 100);
        timelabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timelabel.setBorder(BorderFactory.createBevelBorder(1));
        timelabel.setOpaque(true);
        timelabel.setForeground(new Color(0, 250, 0));
        timelabel.setBackground(Color.BLACK);
        startButton.setBounds(100, 200, 100, 50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 35));
        startButton.setForeground(new Color(0, 250, 0));
        startButton.setBackground(Color.BLACK);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN, 35));
        resetButton.setForeground(new Color(0, 250, 0));
        resetButton.setBackground(Color.BLACK);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        timelabel.add(startButton);
        timelabel.add(resetButton);
        JPanel tab = new JPanel();
        tab.add(timelabel);
        tab.add(resetButton);
        tab.add(startButton);
        tab.setBackground(Color.cyan);

//  ***********************************************************************************************

//  ----------------------- COUNTDOWN TIMER --------------------------------------

        label.setBounds(100, 100, 200, 100);
        label.setText("  " + hour_string + ":" + minute_string + ":" + second_string + "  ");
        label.setFont(new Font("Verdana", Font.PLAIN, 50));
        label.setBorder(BorderFactory.createBevelBorder(1));
        label.setOpaque(true);
        label.setForeground(new Color(0, 250, 0));
        label.setBackground(Color.yellow);
        Start.setLocation(300,200);
        Start.setSize(100,50);
        Start.setFont(new Font("Ink Free", Font.PLAIN, 35));
        Start.setForeground(Color.BLACK);
        Start.setBackground(new Color(0, 250, 0));
        Start.setFocusable(false);
        Start.addActionListener(this);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 40));
        textField.setBackground(new Color(77, 255, 77));
        textField.setForeground(new Color(77, 77, 225));
        textField.setFont(new Font("Serif",Font.BOLD,35));
        tab2.add(label);
        tab2.add(textField);
        tab2.add(Start);
        tab2.setBackground(Color.PINK);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    text = textField.getText();
                    i = Integer.parseInt(text);
                    elaspedtime = i*1000;
                    start2();
                    Start.setText("Dismiss");
                    textField.setText("");
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        }
        );

        // *************^^^^^^^^^^^^^^^^^^^*******************^^^^^^^^^^^^^^^^^^^^*************

        // ~~~~~~~~~~~~~~~~~~~~~~~~~ TABS SEPARATION ~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        JTabbedPane tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);
        tabbedPane.addTab("clock", timeName);
        tabbedPane.addTab("stopwatch", tab);
        tabbedPane.addTab("timer", tab2);
        setTime();

//   -----------------------------------------------------------------------------------
    }
// ========================TIME SETUP ========================================


    public void setTime() {
        while (true) {
            String time = timeFromat.format(Calendar.getInstance().getTime());
            timeName.setText(time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

//  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

//   ||||||||||||||||||||||| STOPWATCH'S METHODS ||||||||||||||||||||||||||||||||
    void start(){
        timer.start();
    }
    void stop(){
        timer.stop();
    }
    void reset(){
        timer.stop();
        elaspedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        miliseconds = 0;
        milisecond_string = String.format("%02d", miliseconds);
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timelabel.setText(hours_string+":"+minutes_string+":"+seconds_string+":"+milisecond_string);
    }

// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ COUNTDOWN'S METHODS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    void start2(){
        timer2.start();
    }
    void stop2(){
        timer2.stop();
        elaspedtime = 0;
        second = 0;
        minute = 0;
        hour = 0;
        second_string = String.format("%02d", second);
        minute_string = String.format("%02d", minute);
        hour_string = String.format("%02d", hour);
        label.setText("  "+hour_string+":"+minute_string+":"+second_string+"  ");
    }
}
