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
import javax.swing.JComboBox;

public class ComboBoxSuggestion<E> extends JComboBox<E> {

    public ComboBoxSuggestion() {
        setUI(new ComboBoxSuggestionUI());
    }
}