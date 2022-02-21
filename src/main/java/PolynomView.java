import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PolynomView extends JFrame {
    private JTextField inPolinom1= new JTextField(5);
    private JTextField inPolinom2 = new JTextField(5);
    private JTextField m_totalTf = new JTextField(10);
    private JButton m_multiplyBtn = new JButton("Multiply");
    private JButton m_addBtn = new JButton("Add");
    private JButton m_substractBtn = new JButton("Substract");
    private JButton m_divideBtn = new JButton("Divide");
    private JButton m_deriveBtn = new JButton("Derive");
    private JButton m_integrateBtn = new JButton("Integrate");
    private JButton m_clearBtn = new JButton("Clear");

    private PolynomModel m_model;

    //======================================================= constructor

    /**
     * Constructor
     */
    PolynomView(PolynomModel model) {
        //... Set up the logic
        m_model = model;
        m_model.setValue(PolynomModel.INITIAL_VALUE);

        //... Initialize components
        m_totalTf.setText(m_model.getValue());
        m_totalTf.setEditable(false);

        //... Layout the components.
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(7,2,5,10));
        JLabel p1;
        content.add( p1 = new JLabel("Polinom 1"));
        content.add(inPolinom1);
        content.add(new JLabel("Polinom 2"));
        content.add(inPolinom2);
        content.add(m_addBtn);
        content.add(m_substractBtn);
        content.add(m_multiplyBtn);
        content.add(m_divideBtn);
        content.add(m_deriveBtn);
        content.add(m_integrateBtn);
        content.add(new JLabel("Total"));
        content.add(m_totalTf);
        content.add(m_clearBtn);

        //... finalize layout
        this.setContentPane(content);
        this.pack();

        this.setTitle("Simple Calc - MVC");
        // The window closing event should probably be passed to the
        // Controller in a real program, but this is a short example.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void reset() {
        m_totalTf.setText(PolynomModel.INITIAL_VALUE);
    }

    String getInPolinom1() {
        return inPolinom1.getText();
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

    void addAddListener(ActionListener mal)
    {
        m_addBtn.addActionListener(mal);
    }

    void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
}
