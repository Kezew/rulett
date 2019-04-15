/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rulettproject;

/**
 *
 * @author Roth Reka
 */
public class Number {

    private int id;
    private Color color;
    private Parity parity;

    public Number(int id, Color color, Parity parity) {
        this.id = id;
        this.color = color;
        this.parity = parity;
    }

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public Parity getParity() {
        return parity;
    }

}
