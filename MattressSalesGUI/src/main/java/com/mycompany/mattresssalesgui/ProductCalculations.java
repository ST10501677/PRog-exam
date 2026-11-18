/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mattresssalesgui;

/**
 *
 * @author njabu
 */
public class ProductCalculations implements IProductCalculations {
     
   
    @Overridepublic  
             GetVat() {
           
                 double vat = ProductPrice * 0.15;
                 return  vat;
            }
    @Overridepublic  
        double GetCommission() {
        double Commission =
                double Commission = ProductPrice * 0.5;
                return Commission;
    }
        
    @Overridepublic  
        double GetTotal() {
        double Total =
                double total = ProductPrice + vat + Commission ;
                return total;
        

}


    

