package com.mycompany.jcustoms;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class MyFormatterEmpty extends JPanel {

    private JFormattedTextField campoText;
    private String mask;
    private Integer nColumns;
    private Font font;

    public MyFormatterEmpty(String mask, int nColumns, Font font) {
        
        this.mask = mask;
        this.nColumns = nColumns;
        this.font = font;
        
        // Configuração do campo de Texto
        try {
            
            MaskFormatter formatter = new MaskFormatter(this.mask);
            campoText = new JFormattedTextField(formatter);
            campoText.setValue(""); // Valor inicial (opcional)

            
            campoText.setOpaque(false);
            campoText.setBorder(new EmptyBorder(0, 2, 3, 4));
            
           
            campoText.setColumns(this.nColumns);
            campoText.setFont(this.font);
           
            colorClick = new Color(0, 56, 80);
            borderColor = new Color(0, 56, 64);

            
            
            //  Add event mouse
            addMouseListener(new MouseAdapter() {

                public void focusGained(FocusEvent fe) {
                setColor(new Color(0, 56, 80));
                repaint();
                }
                
                
                public void focusLost(FocusEvent fe) {
                setColor(new Color(0, 56, 64));
                repaint();
                }
                

            });
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        // Adicionando o campo de CPF ao painel
        this.setLayout(new FlowLayout());
        this.add(campoText);
    }
    
        private Shape shape;

    @Override
    protected void paintComponent(Graphics g) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(shape);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getForeground());
        g2.draw(shape);
    }
 
    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public String getMask(){
        return mask;
    }
    
    public void setMask(String mask){
        this.mask = mask;
    }

    private boolean over;
    private Color colorOver;
    public Color colorClick;
    public Color borderColor;
    private int radius = 0;

    private Color color = new Color(0, 56, 64);
   

// Métodos específicos da classe (se necessário)
// Por exemplo, você pode criar um método para obter o valor do Texto digitado.
    public String getText() {
        return campoText.getText().replaceAll("[^0-9]", ""); // Remove caracteres não numéricos
    }
    
    public void setText(String txt){
        campoText.setText(txt);
    }
    
    public void setEditable(boolean t){
        campoText.setEditable(t);
    }
    
}
