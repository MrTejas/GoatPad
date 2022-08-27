import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Load extends JFrame
{
    int c;
    JLabel[] l=new JLabel[c];
    JButton bc=new JButton("Close");
    Load obj=this;
    public Load(Notepad ob)throws IOException
    {
        super("Load");
        setLocation(500,200);
        FileReader fr=new FileReader("files.txt");
        BufferedReader fbr=new BufferedReader(fr);
        StringTokenizer str=new StringTokenizer(fbr.readLine(),"\t");
        c=str.countTokens();
        JButton b;
        setVisible(true);
        setLayout(new GridLayout(c+4,2));

        add(new JLabel("Files"));
        add(new JLabel("Open"));
        for(int x=1;x<=2;x++)
        {
            add(new JLabel(""));
        }
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        for(int x=0;x<c;x++)
        {
            String s=str.nextToken();
            JTextField tf=new JTextField(s+".gpd");
            add(tf);
            tf.setEditable(false);
            b=new JButton("OPEN");
            add(b);
            b.addActionListener
            (
                new ActionListener()
                {
                    public void actionPerformed (ActionEvent evt)
                    {

                        ob.openFile(s);
                        obj.setVisible(false);
                    }

                }
            );
        }
        
        for(int x=1;x<=2;x++)
        {
            add(new JLabel(""));
        }
        
        add(bc);
        bc.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)  
                {
                    obj.setVisible(false);
                }
            }
        );
        pack();
    }
}
