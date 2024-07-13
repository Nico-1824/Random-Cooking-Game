import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Window implements ActionListener {
    JFrame f;
    JLabel team1Label, team2Label, add_nation_label, team1_ptslabel,
    team2_ptslabel, iconLabel;
    JButton randombt, addbt, team1_addbt, team2_addbt, team1_reward1, team1_reward2;
    JTextField team1tf, team2tf, add_nation_tf;
    FileIO fio = new FileIO();
    String temp = fio.readFile(fio.pointsPath);


    Main_Window() {
        f = new JFrame("Cooking App");

        //Labels
        team1Label = new JLabel("Team Lico:");
        team1Label.setBounds(0, 150, 100, 50);
        team2Label = new JLabel("Team Micardo:");
        team2Label.setBounds(0, 175, 100, 50);
        add_nation_label = new JLabel("Add Nation:");
        add_nation_label.setBounds(0, 200, 100 ,50);
        team1_ptslabel = new JLabel("Points: " + temp.charAt(0));
        team1_ptslabel.setBounds(245, 150, 100, 50);
        team2_ptslabel = new JLabel("Points: " + temp.charAt(2));
        team2_ptslabel.setBounds(245, 175, 100, 50);
        iconLabel = new JLabel(new ImageIcon("/Users/nicobrizuela/Downloads/CookingApp/Untitled_Artwork.png"));
        iconLabel.setBounds(100, 300, 210, 110);

        //TextFields
        team1tf = new JTextField();
        team1tf.setBounds(70, 165, 150, 20);
        team1tf.setEditable(false);
        team2tf = new JTextField();
        team2tf.setBounds(90, 190, 130, 20);
        team2tf.setEditable(false);
        add_nation_tf = new JTextField();
        add_nation_tf.setBounds(75, 215, 145, 20);

        //Buttons
        randombt = new JButton("Randomize");
        randombt.setBounds(175, 100, 150, 50);
        randombt.addActionListener(this);
        addbt = new JButton("Add");
        addbt.setBounds(230, 215, 100, 20);
        addbt.addActionListener(this);
        team1_addbt = new JButton("+");
        team2_addbt = new JButton("+");
        team1_addbt.setBounds(220, 165, 20, 20);
        team2_addbt.setBounds(220, 190, 20, 20);
        team1_addbt.addActionListener(this);
        team2_addbt.addActionListener(this);

        //Adding to Frame
        f.add(randombt); f.add(team1Label); f.add(team1tf); f.add(team2tf);
        f.add(team2Label); f.add(add_nation_tf);f.add(add_nation_label);
        f.add(addbt); f.add(team1_addbt); f.add(team2_addbt);
        f.add(team1_ptslabel); f.add(team2_ptslabel); f.add(iconLabel);

        f.setBounds(0, 40, 500, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == randombt) { //randomize button
            RandomCuisine rc = new RandomCuisine();
            String cuisine = rc.nation();
            String[] arr = rc.cookingArea();
            team1tf.setText(arr[0] + ": " + cuisine);
            team2tf.setText(arr[1] + ": " + cuisine);
        } else if(e.getSource() == addbt) { //adding nations button
            fio.writeToFile( fio.nationsPath, fio.readFile(fio.nationsPath) + " " + add_nation_tf.getText());
            add_nation_tf.setText("");
            System.out.println("Button 2 pressed");
        } else if(e.getSource() == team1_addbt) { //adding points to team 1
            int a = Integer.parseInt(String.valueOf(temp.charAt(0)));
            a += 1;
            String input = a + " " + temp.charAt(2);
            fio.writeToFile(fio.pointsPath, input);
            //team1_ptslabel.setText("Points: " + temp.charAt(0));
        } else if(e.getSource() == team2_addbt) { //adding points to team 2
            String temp = fio.readFile(fio.pointsPath);
            int a = Integer.parseInt(String.valueOf(temp.charAt(2)));
            a += 1;
            String input = a + " " + temp.charAt(0);
            fio.writeToFile(fio.pointsPath, input);
            //team2_ptslabel.setText("Points: " + temp.charAt(2));
        }
    }
}
