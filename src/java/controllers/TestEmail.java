/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Tutus W
 */
public class TestEmail {
    public static void main(String[] args) {
        try {
//            JavaMailUtil.sendMail("tutuswidiyaningtyas@gmail.com", "");
            JavaMailUtil.sendMail("tutuswidiyaningtyas@gmail.com", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
