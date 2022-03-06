
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolynomController {
    private PolynomModel m_model;
    private PolynomView m_view;

    PolynomController(PolynomModel model, PolynomView view) {
        m_model = model;
        m_view = view;

        view.addMultiplyListener(new MultiplyListener());
        view.addAddListener(new AddListener());
        view.addSubstractListener(new SubstractListener());
        view.addMultiplyListener(new MultiplyListener());
        view.addDerivateListener(new DerivateListener());
        view.addIntegrateListener(new IntegrateListener());
        view.addClearListener(new ClearListener());
        view.addBtnNumberListener(new BtnNumberListener());
        view.addDivideListener(new DivideListener());
    }

    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                UserText u1 = new UserText("");
                u1.setInput(m_view.getInPolinom1());
                Polinom p1 = m_model.makePolynom(u1);

                UserText u2 = new UserText("");
                u2.setInput(m_view.getInPolinom2());
                Polinom p2 = m_model.makePolynom(u2);

                m_view.setTotal(m_model.multiplyBy(p1, p2).toString());
            } catch (NullPointerException nfex) {
                m_view.showError("Ati uitat sa introduceti ambii operanzi");
            }
            catch (NumberFormatException | InvalidTextException nfex) {
                m_view.showError("Polinomul introdus e invalid. Corectati !");
            }
        }
        }
    class DivideListener implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                UserText u1 = new UserText("");
                u1.setInput(m_view.getInPolinom1());
                Polinom p1 = m_model.makePolynom(u1);

                UserText u2 = new UserText("");
                u2.setInput(m_view.getInPolinom2());
                Polinom p2 = m_model.makePolynom(u2);

                m_view.setTotal(m_model.divideBy(p1, p2).toString() + ",    r = " + p1.toString());
            } catch (NullPointerException nfex) {
                m_view.showError("Ati uitat sa introduceti ambii operanzi");
            }
            catch (NumberFormatException | InvalidTextException nfex) {
                m_view.showError("Polinomul introdus e invalid. Corectati !");
            }

        }
    }
    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                UserText u1 = new UserText("");
                u1.setInput(m_view.getInPolinom1());
                Polinom p1 = m_model.makePolynom(u1);

                UserText u2 = new UserText("");
                u2.setInput(m_view.getInPolinom2());
                Polinom p2 = m_model.makePolynom(u2);

                m_view.setTotal(m_model.addBy(p1, p2).toString());
            } catch (NullPointerException nfex) {
                m_view.showError("Ati uitat sa introduceti ambii operanzi");
            } catch (NumberFormatException | InvalidTextException nfex) {
                m_view.showError("Unul din polinomii introdusi e invalid. Corectati !");
            }
        }
    }
    class SubstractListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try {
                UserText u1 = new UserText("");
                u1.setInput(m_view.getInPolinom1());
                Polinom p1 = m_model.makePolynom(u1);

                UserText u2 = new UserText("");
                u2.setInput(m_view.getInPolinom2());
                Polinom p2 = m_model.makePolynom(u2);

                m_view.setTotal(m_model.substractBy(p1, p2).toString());
            } catch (NullPointerException nfex) {
                m_view.showError("Ati uitat sa introduceti unul din operanzi");
            }
            catch (NumberFormatException | InvalidTextException nfex) {
                m_view.showError("Polinomul introdus e invalid. Corectati !");
            }
        }
    }
    class DerivateListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                UserText u1 = new UserText("");
                u1.setInput(m_view.getInPolinom1());
                Polinom p1 = m_model.makePolynom(u1);
                m_view.setTotal(m_model.derivateBy(p1).toString());
            }
            catch(NullPointerException nfex){
                m_view.showError("Ati uitat sa introduceti Polinom 1");
            }
            catch (NumberFormatException | InvalidTextException nfex) {
                m_view.showError("Polinomul introdus e invalid. Corectati !");
            }
        }
    }
    class IntegrateListener implements  ActionListener{
        public void actionPerformed(ActionEvent e) {
            try {
                UserText u1 = new UserText("");
                u1.setInput(m_view.getInPolinom1());
                Polinom p1 = m_model.makePolynom(u1);
                p1 = m_model.integrateBy(p1);
                m_view.setTotal(p1.toString() + " +c");
            } catch (NullPointerException nfex) {
                m_view.showError("Ati uitat sa introduceti Polinom 1");
            }
            catch (NumberFormatException | InvalidTextException nfex) {
                m_view.showError("Polinomul introdus e invalid. Corectati !");
            }
        }
    }
    class BtnNumberListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton o = (JButton) e.getSource();
           if(m_view.getCarePolinom().getSelectedItem() == "Polinom 1")
           {
               if(o.getName().equals("del")) {
                   int len = m_view.getInPolinom1().length();
                   if(len == 0)
                       len ++;
                   String sub = m_view.getInPolinom1().substring(0, len - 1);
                   m_view.setPolinom1(sub);
               }
               else
                   m_view.setPolinom1(m_view.getInPolinom1() + o.getName());
           }
           else {
               if(o.getName().equals("del")) {
                   int len = m_view.getInPolinom2().length();
                   if(len == 0)
                       len ++;
                   String sub = m_view.getInPolinom2().substring(0, len - 1);
                   m_view.setPolinom2(sub);
               }
               else
                     m_view.setPolinom2(m_view.getInPolinom2() + o.getName());
           }
        }
    }
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    }
}