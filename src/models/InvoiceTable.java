/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Rashan
 */
public class InvoiceTable {
    
    private  String barcode;
    private  String index;
    private  String name;
    private  String qty;
    private  String unitPrice;
    private  String total;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String value) {
        barcode = value;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String value) {
        index= value;
    }

    public String getpName() {
        return name;
    }

    public void setpName(String value) {
        name=value;;
    }

    public String getQty() {
        return qty ;
    }

    public void setQty(String value) {
        qty =value;
    }

    public String getUnitPrice() {
        return unitPrice ;
    }

    public void setUnitPrice(String value) {
        unitPrice =value;
    }

    public String getTotal() {
        return total ;
    }

    public void setTotal(String value) {
        total =value;
    }

}
