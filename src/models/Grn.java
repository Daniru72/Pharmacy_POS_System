/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Rashan
 */
public class Grn {
    private  String barcode;
    private  String expDate;
    private  String index;
    private  String mfDate;
    private  String productName;
    private  String sellingPrice;
    private  String unit;
    private  String unitPrice;
    private  String qty;
    private  String total;

    
    

    public void setBarcode(String value) {
       this.barcode=value;
    }

    public void setexpDate(String value) {
         this.expDate=value;
    }

    public void setindex(String value) {
         this.index=value;
    }

    public void setmfDate(String value) {
         this.mfDate=value;
    }

    public void setproductName(String value) {
         this.productName=value;
    }

    public void setqty(String value) {
         this.qty=value;
    }

    public void setsellingPrice(String value) {
         this.sellingPrice=value;
    }

    public void setunit(String value) {
         this.unit=value;
    }

    public void setunitPrice(String value) {
         this.unitPrice=value;
    }
    
    public void setTotal(String value) {
         this.total=value;
    }
    
    
//-------------
    public String getBarcode() {
        
        return barcode;
    }

    public String getexpDate() {
      return  expDate;
    }

    public String getindex() {
      return  index;
    }

    public String getmfDate() {
      return  mfDate;
    }

    public String getproductName() {
       return productName;
    }

    public String getqty() {
       return qty;
    }

    public String getsellingPrice() {
       return sellingPrice;
    }

    public String getunit() {
       return unit;
    }

    public String getunitPrice() {
       return unitPrice;
    }

    public String getTotal() {
       return total;
    }
    
}
