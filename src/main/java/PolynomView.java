import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class PolynomView extends JFrame {
    private JTextField inPolinom1= new JTextField(100);
    private JTextField inPolinom2 = new JTextField(100);
    private JTextField m_totalTf = new JTextField(100);
    private JComboBox m_carePoli = new JComboBox(new String[]{"Polinom 1", "Polinom 2"});
    private JButton m_multiplyBtn = new JButton("Multiply");
    private JButton m_addBtn = new JButton("Add");
    private JButton m_substractBtn = new JButton("Substract");
    private JButton m_divideBtn = new JButton("Divide");
    private JButton m_deriveBtn = new JButton("Derive");
    private JButton m_integrateBtn = new JButton("Integrate");
    private JButton m_clearBtn = new JButton("Clear");
    private ArrayList<JButton> numbersNsigns = new ArrayList<>(18);

    private PolynomModel m_model;

    //======================================================= constructor

    /**
     * Constructor
     */
    PolynomView(PolynomModel model) {
        //... Set up the logic
        m_model = model;
        m_model.setValue(PolynomModel.INITIAL_VALUE);

        JPanel content = new JPanel();
        m_totalTf.setText(m_model.getValue());
        m_totalTf.setEditable(false);
        content.setLayout(null);
        JLabel p1; JLabel p2;

        content.add( p1 = new JLabel("Polinom 1"));
        p1.setBounds(20,20,80,20);
        inPolinom1.setBounds(100,20,200,20);
        content.add(inPolinom1);

        content.add(p2 = new JLabel("Polinom 2"));
        p2.setBounds(380,20,80,20);
        inPolinom2.setBounds(450,20,200,20);
        content.add(inPolinom2);

        m_addBtn.setBounds(50,50,60,30);
        m_substractBtn.setBounds(120,50,100,30);
        m_multiplyBtn.setBounds(235,50,80,30);
        m_divideBtn.setBounds(335,50,80,30);
        m_deriveBtn.setBounds(430,50,80,30);
        m_integrateBtn.setBounds(520,50,100,30);

        content.add(m_addBtn);
        content.add(m_substractBtn);
        content.add(m_multiplyBtn);
        content.add(m_divideBtn);
        content.add(m_deriveBtn);
        content.add(m_integrateBtn);

        JLabel comboPolinom = new JLabel("Alegeti polinomul pe care sa-l introduceti");
        comboPolinom.setBounds(50,100,250,20);
        m_carePoli.setBounds(50,130,100,20);
        content.add(m_carePoli);
        content.add(comboPolinom);

        int x = 50;
        int y = 180;
        int i =0;
            ArrayList<String> numbers = new ArrayList<>(Arrays.asList("1", "2","3","4","5","6","7","8","9","0",
                    "+","-","/","*","^",".","x","del"));
        for(i=0;i<18;i++) {
            JButton b;
            b = new JButton(numbers.get(i) + "");
            numbersNsigns.add(b);
        }
        for(JButton b: numbersNsigns){
            b.setBounds(x,y,60,50);
            b.setName(b.getText() + "");
            x = x + 70;
            if(x >= 540) {
                y += 60;
                x= 50;
            }
            content.add(b);
        }

        JLabel t;
        content.add(t = new JLabel("Total"));
        t.setBounds(70, 400, 30, 20);
        m_totalTf.setBounds(150,400,350,20);
        content.add(m_totalTf);

        content.add(m_clearBtn);
        m_clearBtn.setBounds(500,400,80,20);

        content.add(m_addBtn);
        this.setContentPane(content);
        this.pack();
        this.setTitle("Polynomial Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,500);
    }

    void reset() {
        m_totalTf.setText(PolynomModel.INITIAL_VALUE);
    }

    String getInPolinom1() {
        return inPolinom1.getText();
    }

    String getInPolinom2() {
        return inPolinom2.getText();
    }

    public void setInPolinom1(JTextField inPolinom1) {
        this.inPolinom1 = inPolinom1;
    }
    void setPolinom1(String newText) {
        inPolinom1.setText(newText);
    }
    void setPolinom2(String newText) {
        inPolinom2.setText(newText);
    }

    public ArrayList<JButton> getNumbersNsigns() {
        return numbersNsigns;
    }

    public void setNumbersNsigns(ArrayList<JButton> numbersNsigns) {
        this.numbersNsigns = numbersNsigns;
    }

    void setTotal(String newTotal) {
        m_totalTf.setText(newTotal);
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    void addMultiplyListener(ActionListener mal) {
        m_multiplyBtn.addActionListener(mal);
    }

    void addDivideListener(ActionListener mal)
    {
        m_divideBtn.addActionListener(mal);
    }

    void addAddListener(ActionListener mal)
    {
        m_addBtn.addActionListener(mal);
    }

    void addSubstractListener(ActionListener mal)
    {
        m_substractBtn.addActionListener(mal);
    }
    void addDerivateListener(ActionListener mal)
    {
        m_deriveBtn.addActionListener(mal);
    }
    void addIntegrateListener(ActionListener mal)
    {
        m_integrateBtn.addActionListener(mal);
    }
    void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
    void addBtnNumberListener(ActionListener mal){
        for(int i=0;i<18;i++)
        numbersNsigns.get(i).addActionListener(mal);
    }

    public JComboBox getCarePolinom() {
        return m_carePoli;
    }
}
