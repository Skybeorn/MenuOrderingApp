/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Skybeorn
 */
public class ComboOne {

    private String name = "Nachos with Chorizo";
    private String description = "Medium heat, but good eats";
    public static final double PRICE = 10.00;

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }
}
