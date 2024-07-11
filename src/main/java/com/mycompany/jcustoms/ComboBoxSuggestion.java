/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jcustoms;

/**
 *
 * @author RAVEN
 */
import com.mycompany.jcustoms.comboBox.ComboBoxSuggestionUI;
import java.awt.Color;
import javax.swing.JComboBox;

public class ComboBoxSuggestion<E> extends JComboBox<E> {

    public ComboBoxSuggestion() {
        setUI(new ComboBoxSuggestionUI(new Color(255,255,204), new Color(128,255,189), new Color(0,0,0),new Color(15,154,155)));
    }
}