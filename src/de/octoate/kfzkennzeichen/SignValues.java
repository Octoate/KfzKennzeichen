/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.octoate.kfzkennzeichen;

/**
 *
 * @author Octoate
 */
public class SignValues {
    private String sign = "";
    private String city = "";

    public SignValues() {
    }
    
    public SignValues(String sign, String city) {
        this.sign = sign;
        this.city = city;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
