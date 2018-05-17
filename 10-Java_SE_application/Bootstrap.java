import javax.swing.JFrame;

public class Bootstrap {

    public static void main(String[] args) {
        JFrame window = new JFrame("Main Window");
        window.setBounds(100, 100, 400, 300);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }

}
