
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Save extends JFrame
{
    Save obj=this;
    JButton s=new JButton ("Save");
    JButton sc=new JButton ("Cancel");
    JTextField tf=new JTextField(20);
    JLabel l=new JLabel("Enter File Name");
    public Save(String fnm,String f,boolean b)throws IOException
    {
        super("Save");
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(500,500);
        setResizable(false);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Icon i=new ImageIcon(getClass().getResource("goat.png"));
        if(!b)
        {
            FileWriter fw=new FileWriter(fnm+".txt",true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            pw.print(f);

            JOptionPane.showMessageDialog(this,"File Saved");
            return;
        }
        add(l);
        add(tf);
        add(s);
        add(sc);
        add(new JLabel(" GoatPad Pvt. Ltd."));

        sc.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)  
                {
                    obj.setVisible(false);
                }
            }
        );

        s.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    try
                    {
                        save(f,b);
                    }
                    catch(Exception e)
                    {

                    }
                }
            }
        );
    }

    private void save(String f,boolean b)throws IOException
    {
        //try

        {
            String name=tf.getText();
            FileReader fr=new FileReader("files.txt");
            BufferedReader fbr=new BufferedReader(fr);
            StringTokenizer str=new StringTokenizer(fbr.readLine(),"\t");
            int c=str.countTokens();
            boolean found=false;
            for(int x=1;x<=c;x++)
            {
                String s=str.nextToken();
                if(s.equals(name))
                {
                    found=true;
                    JOptionPane.showMessageDialog(null,"File Already Exists");
                    break;
                }
            }
            if(!found)
            {

                FileWriter fw=new FileWriter("files.txt",true);
                BufferedWriter bw=new BufferedWriter (fw);
                PrintWriter pw=new PrintWriter(bw);
                pw.print("\t"+name);

                FileWriter fw1=new FileWriter(name+".txt",true);
                BufferedWriter bw1=new BufferedWriter (fw1);
                PrintWriter pw1=new PrintWriter(bw1);
                pw1.print(f);

                pw1.close();
                bw1.close();
                fw1.close();

                pw.close();
                bw.close();
                fw.close();

            }
        }
        /*catch(Exception e)
        {
        JOptionPane.showMessageDialog(this,"error");
        }*/

    }
}