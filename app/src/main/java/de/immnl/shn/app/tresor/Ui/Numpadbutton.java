package de.immnl.shn.app.tresor.Ui;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.event.*;

import de.immnl.shn.app.tresor.Tresor;

import java.awt.*;
import java.awt.event.*;
import java.awt.*;

public class Numpadbutton extends JButton{
    public Numpadbutton(String text){
        setText(text);
        setFont(new Font(Font.MONOSPACED, Font.PLAIN,  32));
        setBackground(new Color(14, 19, 28));        
        setForeground(new Color(255,255,255));
        setFocusPainted(false);
        setBorder(null);
        addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e){ 
              try{Tresor.input(e.getActionCommand().charAt(0));}
              catch(InterruptedException err){}
            } 
        });
        getModel().addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
        
                if (model.isRollover()) {
                    setBackground(new Color(14, 19, 28).brighter());
                } else if (model.isPressed()) {
                    setBackground(new Color(17,24,34));
                } else {
                    setBackground(new Color(14, 19, 28));
                }
            }
        });
    }
}
