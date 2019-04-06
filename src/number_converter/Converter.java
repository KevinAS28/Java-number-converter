/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class Converter {
    
    public Converter()
    {
        this.convert();
    }
            private String list_symb0[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
    private String list_symb1[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35" };
    private String list_symb0b[] = list_symb0;
    private String list_symb1b[] = list_symb1;
    private String temp = "";
    String universal[] = this.list_symb1;
    String list_of_list[][] = {list_symb0, list_symb1};
    private String cutStr(String x, int start, int stop, int step)
    {
        String to_return = "";
        for (int i = start; i < stop;i+=step)
        {
            to_return += String.valueOf(x.charAt(i));
        }
        return to_return;
    }
    public String to_universal(String var)
    {
        String to_return = "";
        for (int i = 0 ; i < this.list_of_list.length;i++)
        {
            try{
                to_return = this.changeSymb(var, this.list_of_list[i], this.universal);
            }
            catch(Exception err){
                continue;
            }
        }
        return to_return;
    }
    private double pow(double a, double b)
    {
        int result = 1;
        for (int i = 0; i < b; i++)
        {
            result *= a;
        }
        return result;
    }
    private void writeProc(String x)
    {
        this.temp += x + "\n";
        System.out.print(this.temp);
    }
    protected void setSymb() {

//        EditText list0[] = {};//(EditText) findViewById(R.id.List_symb0)};
//        String list1[][] = {this.list_symb0, this.list_symb1};
//        String toprint = "";
//        for (int i = 0; i < list0.length; i++) {
//            for (int a = 0; a < (this.list_symb0.length); a = a + 1) {
//                toprint += list1[i][a];
//            }
//            list0[i].setText(toprint);
//            toprint = "";
//        }
    }

    String index_symb(String symb, String list[]) {
        String to_return = "";
        for (int i = 0; i < list.length; i++) {
            if (list[i] == symb) {
                to_return = String.valueOf(i);
            }
        }
        return to_return;
    }

    private void printResult(String x) {
        System.out.println("Result: " + x);
    }
    private String inBase(String value, int base)
    {
        value = this.to_universal(value);
        if (!(Integer.parseInt(value) > (base-1)))
        {
            return value;
        }
        String univ = this.arrtostr(this.universal);
        univ = this.cutStr(univ, 0, base, 1);
        int sisa =  Integer.parseInt(value) % base;
        String putaran = String.valueOf(((Integer.parseInt(value)-sisa))/base) + String.valueOf(sisa);
        return putaran;
        //return putaran;
    }
    private String[] star(String x)
    {
        String to_return[] = new String[x.length()];
        for (int i = 0; i < x.length(); i++)
        {
            to_return[i] = String.valueOf(x.charAt(i));
        }
        return to_return;
    }
    private String Lformula(String nilai, int base) {
        this.writeProc("Konversi " + nilai + " ke basis: " + String.valueOf(base));
        this.writeProc("Simpanan: 0");
        this.universal = this.list_symb1;
        int value = Integer.parseInt(this.to_universal(nilai));
        String to_return = "";
        while (value>0)
        {
            String ori = this.inBase(this.to_universal(String.valueOf(value % base)), base);
            this.writeProc(String.valueOf(value) + " % " + String.valueOf(base) + " = " + String.valueOf(value%base));
            this.writeProc("dalam basis " + String.valueOf(base) + " angka " + String.valueOf(value%base) + " adalah " + ori);

            this.universal = this.star(this.cutStr((this.arrtostr(this.list_symb0)), 0, base, 1));

            ori = this.to_universal(ori);

            to_return = ori + to_return;
            this.writeProc(ori + " tambahkan simpanan menjadi " + to_return);
            value/=base;
            this.universal = this.list_symb1;
        }
        //this.universal = this.list_symb0;
        //to_return = this.to_universal(to_return);
        //this.universal = this.list_symb1;
        this.writeProc("Hasil: " + to_return + "\n\n");
        return to_return;
    }
    private int arrtostr(int arr[])
    {
        int to_return = 0;
        for (int i = 0; i < arr.length; i++)
        {
            to_return += arr[i];
        }
        return to_return;
    }
    private String arrtostr(String arr[])
    {
        String to_return = "";
        for (int i = 0; i < arr.length; i++)
        {
            to_return += arr[i];
        }
        return to_return;
    }

    private String Xformula(String x, int base, int tobase)
    {
        this.writeProc("Konversi " + x + " kedalam basis puluhan");
        int length = x.length();
        int len = x.length()-1;
        int list_result[] = new int[length];
        int buatproses = 0;
        for (int i = 0; i < length; i++)
        {
            if (buatproses==1)
            {
                this.writeProc(" + ");
            }
            int to_attent = Integer.parseInt(this.to_universal(String.valueOf(x.charAt(i))));

            int to_mul = (int) this.pow(base, len);
            int ori = (to_attent * to_mul);

            list_result[i] = ori;
            this.writeProc("(" + to_attent + "x (" + String.valueOf(base) + "^" + String.valueOf(len) + "))" + " = " + String.valueOf(ori));
            len--;
            buatproses = 1;

        }
        this.universal = this.list_symb0;
        //this.universal = this.star(this.cutStr((this.arrtostr(this.list_symb0)), 0, tobase, 1));
        String to_return = this.to_universal(String.valueOf(this.arrtostr(list_result)));
        this.universal = this.list_symb1;
        this.writeProc("Hasil = " + to_return + "\n\n");
        return to_return;
    }
    private int longest_array(String arr[])
    {
        int max = 0;
        for (int i = 0; i < arr.length; i++)
        {
            int len = (arr[i].length());
            if (len > max)
            {
                max = len;
            }
        }
        return max;
    }
    private String rmstr(String x, int to_remove)
    {
        String to_return = "";
        for (int i = 0; i < (x.length()); i++)
        {
            if (i==to_remove){continue;}
            to_return += String.valueOf(x.charAt(i));
        }
        return to_return;
    }
    private String changeSymb(String x, String from_list[], String to_list[]) {
        String to_return = "";
        int max0 = this.longest_array(from_list);
        int max1 = this.longest_array(to_list);
        //for (int i = 0; i < (x.length()/ max0 ); i++)
        while (x.length() > 0)
        {
            int sudahbrp = 0;
            String to_replace = "";
            while (sudahbrp < max0)
            {
                to_replace += String.valueOf(x.charAt(0));
                x = this.rmstr(x, 0);
                sudahbrp++;
            }
            //index to_replace to to_list
            int ke = Arrays.asList(from_list).indexOf(to_replace);
            to_return += to_list[ke];
        }
        return to_return;

        /*
        for (int i = 0; i < x.length(); i++) {
            String toFind = String.valueOf((x.charAt(i))).toLowerCase();
            try {
                //int ke = Integer.parseInt(this.index_symb(toFind, from_list));
                int ke = Arrays.asList(from_list).indexOf(toFind);
                to_return += to_list[ke];
            } catch (Exception err) {
                return toFind + " " + err;
            }
        }
        return to_return;
        */
    }


    public void convert() {
        try
        {
            String fromBase0 = JOptionPane.showInputDialog("from base: ").toLowerCase();
            String toBase0 = JOptionPane.showInputDialog("to base ").toLowerCase();
            String toconvert0 = JOptionPane.showInputDialog("the number to convert: ").toLowerCase();

            String hasil;

            this.temp = "";
            //decide Formula to use
            if ((Integer.parseInt(toBase0) % 10) == 0) {
                hasil = this.Xformula(toconvert0, Integer.parseInt(fromBase0), Integer.parseInt(toBase0));
            } else {
                toconvert0 = this.Xformula(toconvert0, Integer.parseInt(fromBase0), Integer.parseInt(toBase0));
                hasil = this.Lformula(toconvert0, Integer.parseInt(toBase0));
            }
            this.printResult(hasil);
        }
        catch (Exception error)
        {
            this.printResult("Error. tolong periksa angka yang dimasukkan. semua harus terisi");
            //this.printResult(String.valueOf(error));
        }

    }
}
