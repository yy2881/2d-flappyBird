import javax.swing.*;



public class Main {

    public static void main(String[] args) {
        JFrame j = new JFrame();

        Stage s = new Stage();

        j.setBounds(10,10,800,600);
        j.setTitle("Flappy bird");
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        j.add(s);

        j.setVisible(true);

    }

}
