import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserText {
    private String input;

    public UserText(String input) {
        this.input = input;
    }

    public String getInput(String inPolinom1) {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int alegOperand(String s)
    {
        if(s.indexOf("+",1) == -1) return s.indexOf("-",1);
        else if (s.indexOf("-",1) == -1) return s.indexOf("+",1);
        else
            return Math.min(s.indexOf("+",1), s.indexOf("-",1));
    }
    public int cautIcs(String s)
    {
        if(s.indexOf("^") == s.indexOf("x") + 1) //daca am putere
            return alegOperand(s)-1;
        else return s.indexOf("x");
    }
    public int cautTermenLiber(int piece)
    {
        String re = "[0-9][-+]x";
        Pattern pat = Pattern.compile(re);
        Matcher mat = pat.matcher(input.substring(0,piece+1));
        if(mat.find())
            return Math.max(input.substring(1).indexOf("+")+1,input.substring(1).indexOf("-")+1);
        re = "[0-9][-+][0-9][*]x";
        pat = Pattern.compile(re);
        mat = pat.matcher(input.substring(0,piece+1));
        if(mat.find())
            return Math.max(input.substring(1).indexOf("+")+1,input.substring(1).indexOf("-")+1);
        re = "[+-][0-9]*[-+]x";
        pat = Pattern.compile(re);
        mat = pat.matcher(input.substring(0,piece+1));
        if(mat.find())
            return Math.max(input.substring(1).indexOf("+")+1,input.substring(1).indexOf("-")+1);
        re = "[+-][0-9]*[-+][*]x";
        pat = Pattern.compile(re);
        mat = pat.matcher(input.substring(0,piece+1));
        if(mat.find())
            return Math.max(input.substring(1).indexOf("+")+1,input.substring(1).indexOf("-")+1);
        return 0;
    }
    public Polinom convertUserText(){
        if (!input.equals("")) {
            int piece = cautIcs(input);
            Polinom p = new Polinom(new ArrayList<>());
            while (piece > -1) {
                Monomial m = new Monomial(0, 0);
                int poz = cautTermenLiber(piece);
                if(poz != 0)
                    p.polinom.add(new Monomial(0,Float.parseFloat(input.substring(0,poz))));
                m.recognizeMonoid(input.substring(poz, piece + 1));
                p.polinom.add(m);
                input = input.substring(piece + 1);
                piece = cautIcs(input);
            }
            if (!input.equals("")) {
                Monomial m = new Monomial(0, 0);
                p.polinom.add(m.recognizeMonoid(input));
            }
            p.arrange();
            return p;
        } else return null;
    }
    public void verifyText() throws InvalidTextException
    {
        String s = "[a-zA-Z]x";
        Pattern p = Pattern.compile(s);
        Matcher m = p.matcher(input);
        if(m.find())
            throw new InvalidTextException();
        s = "[-+*^][-+*^]";
        p = Pattern.compile(s);
        m = p.matcher(input);
        if(m.find())
            throw new InvalidTextException();
        s = "x[0-9]+";
        p = Pattern.compile(s);
        m = p.matcher(input);
        if(m.find())
            throw new InvalidTextException();
        s = "[0-9]+x";
        p = Pattern.compile(s);
        m = p.matcher(input);
        if(m.find())
            throw new InvalidTextException();
        s = "[a-wyzA-WYZ][~`!@#$%&()_=}{|?><,]";
        p = Pattern.compile(s);
        m = p.matcher(input);
        if(m.find())
            throw new InvalidTextException();
    }
}
