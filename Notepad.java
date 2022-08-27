import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Notepad extends JFrame 
{
    JButton saveb=new JButton ("Save");
    JButton openb=new JButton("Open");

    {
        /*
        Icon bold1=new ImageIcon(getClass().getResource("Bold1.png"));
        Icon italic1=new ImageIcon(getClass().getResource("Italic1.png"));
        Icon under1=new ImageIcon(getClass().getResource("Under1.png"));    
        Icon bold2=new ImageIcon(getClass().getResource("Bold2.png"));
        Icon italic2=new ImageIcon(getClass().getResource("Italic2.png"));
        Icon under2=new ImageIcon(getClass().getResource("Under2.png"));
        */
    }
    Font f;
    JTextField fnm=new JTextField("New Document");
    
    JButton bold=new JButton ("B");
    JButton italic=new JButton ("I");
    JButton under=new JButton ("U");

    JTextArea ta=new JTextArea(35,100);
    String[] fonts={"Arial","Times New Roman","IMPACT","Tejas","Segoe Script","Verdana"};
    String[] siz={"6","8","10","12","14","16","18","20","22","24","26","28","30"};

    JComboBox size=new JComboBox<>(siz);
    JComboBox cmb=new JComboBox<>(fonts);
    Font[] fn={new Font("Arial",0,12),new Font("Times New Roman",0,12),new Font("Impact",0,12),new Font("Comic san ms",0,12),new Font("Segoe Script",0,12),new Font("Verdana",0,12)};
    JScrollPane sp=new JScrollPane(ta);

    public static void main(String args[])
    {
        System.out.println("Starting GoatPad");
        Notepad ob = new Notepad();
    }


    public Notepad()
    {
        super("GoatPad");
        setVisible(true);
        add(fnm);
        fnm.setEditable(false);
        setLayout(new FlowLayout());
        setSize(1200,700);
        setResizable(false);
        cmb.setSelectedIndex(0);
        
        cmb.setFont(fn[0]);
        bold.setFont(fn[2]);
        italic.setFont(fn[4]);
        saveb.setFont(fn[5]);
        openb.setFont(fn[5]);
        bold.setBackground(new Color(232,251,123));
        italic.setBackground(new Color(232,251,123));
        under.setBackground(new Color(232,251,123));

        bold.setForeground(new Color(122,129,97));
        italic.setForeground(new Color(122,129,97));
        under.setForeground(new Color(122,129,97));

        saveb.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    save();
                }

            }
        );

        openb.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    load();
                }

            }
        );

        cmb.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    String s=evt.getActionCommand();
                    updateFont(s);//error
                }
            }
        );

        bold.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    //ta.setFont(); //set Bold
                }
            }
        );
        italic.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    //ta.setFont(); //set italic
                }
            }
        );

        under.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    //ta.setFont(); //set underline
                }
            }
        );

        add(cmb);
        add(saveb);
        add(openb);
        add(bold);
        add(italic);
        add(under);
        add(size);

        add(sp);
        ta.setFont(fn[0]);
        f=new Font(fonts[0],0,12);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void updateFont(int t,int n)//t=type of Action, n=quantity
    {
        if(t==1)
        {
            ta.setFont(new Font(f.getFamily(),0,n));//changes size of font
        }
        else if(t==0)
        {
            ta.setFont(fn[n]);// change font
        }
    }

    private void updateFont(String s)//t=type of Action, n=quantity
    {
        ta.setFont(new Font(s,0,12));
        f=new Font(s,0,12);
    }

    private void save()
    {
        try
        {
            boolean b=(fnm.getText().equals("New Document"));
            Save ob=new Save(fnm.getText(),ta.getText(),b);
        }
        catch(Exception e)
        {

        }
    }
    Notepad ob=this;
    private void load()
    {
        try
        {
            Load ob1=new Load(ob);
        }
        catch(Exception e)
        {

        }

    }

    public void openFile(String s)
    {
        try
        {
            FileReader fr=new FileReader(s+".txt");
            BufferedReader fbr=new BufferedReader(fr);
            fnm.setText("File  : "+s);
            String add="";
            String line;
            while((line=fbr.readLine())!=null)
            {
                add=add+line+"\n";
            }
            ta.setText(add);
        }
        catch(Exception e)
        {
            
        }
    }

    public static void main ()
    {
    }
}