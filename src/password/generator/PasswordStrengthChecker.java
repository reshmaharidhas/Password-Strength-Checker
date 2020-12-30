package password.strength.checker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Reshma
 */
public class PasswordStrengthChecker extends JFrame implements ActionListener{
    JLabel label,result,suggestion;
    JTextField passwordfield;
    JButton btnCheck;
    ImageIcon icon;
    PasswordStrengthChecker(){
        icon = new ImageIcon("C:\\Documents\\NetBeansProjects\\Password Strength Checker\\src\\icons\\password.png");
        label = new JLabel("Enter your password to check its strength");
        label.setBounds(70,60,260,30);
        label.setForeground(Color.white);
        passwordfield = new JTextField();
        passwordfield.setBounds(100,100,200,30);
        btnCheck = new JButton("How strong is your password?",icon);
        btnCheck.setBounds(90,150,240,30);
        btnCheck.addActionListener(this);
        result = new JLabel();
        result.setBounds(170,200,150,30);
        result.setForeground(Color.red);
        suggestion = new JLabel();
        suggestion.setBounds(130,230,150,30);
        suggestion.setForeground(Color.red);
        add(label);
        add(passwordfield);
        add(btnCheck);
        add(result);
        add(suggestion);
        setSize(400,400);
        this.getContentPane().setBackground(Color.BLACK);
        setTitle("Password Strength Checker");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        PasswordStrengthChecker object = new PasswordStrengthChecker();       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = passwordfield.getText();
        if(password.matches("(\\s)*")){
            suggestion.setText("EMPTY SPACES");
            suggestion.setForeground(Color.red);
            result.setText("");
        }
        else if(password.matches("(.)*(\\s)+(.)*")){
            suggestion.setText("Whitespace not allowed");
            suggestion.setForeground(Color.red);
            result.setText("");
        }
        else if(password.length()<8){
            result.setText("WEAK!");
            result.setForeground(Color.red);
            suggestion.setText("Add more characters");
            suggestion.setForeground(Color.red);
        }
        else if(password.length()>30){
            result.setText("Password too long");
            result.setForeground(Color.red);
            suggestion.setText("Reduce 8-30 characters");
            suggestion.setForeground(Color.red);
        }
        else{
            boolean hasNumber = password.matches("(.)*(\\d)(.)*");
            if(!hasNumber){
                result.setText("WEAK!");
                result.setForeground(Color.red);
                suggestion.setText("Add any digit");
                suggestion.setForeground(Color.red);
            }
            else{
                boolean hasSymbol = password.matches("(.)*[\\*\\!\\@\\#\\$\\%\\^\\&\\_\\-\\+\\=\\.\\'\\~\\,\\(\\)\\:\\;\\<\\>\\[\\]\\|\\}\\{\\/]+(.)*");
                if(hasSymbol){
                    result.setText("STRONG");
                    result.setForeground(Color.GREEN);
                    suggestion.setText("");
                }
                else{
                    result.setText("WEAK!");
                    result.setForeground(Color.red);
                    suggestion.setText("Add any symbol");
                }
            }
        }
    }
    
}
