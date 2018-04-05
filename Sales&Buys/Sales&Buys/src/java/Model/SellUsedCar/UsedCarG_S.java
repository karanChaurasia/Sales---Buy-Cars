/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.SellUsedCar;

import org.json.simple.JSONObject;





/**
 *
 * @author badree.tiwari
 */
public class UsedCarG_S {
    private int Cid;
    private String namemodel;
    private String version;
    private String fuel_type;
    private String mileage;
    private String amount;
    private String city;
    private String short_description;
    private int uiid;
    private String date;
    private int rating;

    private String location;
    private String year_manufacture;
    private String No_of_owner;
    private String amountinword;
    
    private String pic_name; 

    
    public int getCid() {
        return Cid;
    }

    public void setCid(int Cid) {
        this.Cid = Cid;
    }

    public String getNamemodel() {
        return namemodel;
    }

    public void setNamemodel(String namemodel) {
        this.namemodel = namemodel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public int getUiid() {
        return uiid;
    }

    public void setUiid(int uiid) {
        this.uiid = uiid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getYear_manufacture() {
        return year_manufacture;
    }

    public void setYear_manufacture(String year_manufacture) {
        this.year_manufacture = year_manufacture;
    }

    public String getNo_of_owner() {
        return No_of_owner;
    }

    public void setNo_of_owner(String No_of_owner) {
        this.No_of_owner = No_of_owner;
    }

    public String getPic_name() {
        return pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }

    public String getAmountinword() {
        return amountinword;
    }

    public void setAmountinword(String amountinword) {
        this.amountinword = amountinword;
    }
    
    public JSONObject getJSONObject()
    {
        JSONObject retval = new JSONObject();
        
        retval.put("cid", this.getCid());
        retval.put("name", this.getNamemodel());
        retval.put("version", this.getVersion());
        retval.put("fuel", this.getFuel_type());
        retval.put("mileage", this.getMileage());
        retval.put("amount", this.getAmount());
        retval.put("city", this.getCity());
        retval.put("sd", this.getShort_description());
        retval.put("rating", this.getRating());
        retval.put("amountinword", this.getAmountinword());
        retval.put("location", this.getLocation());
        retval.put("manufacture", this.getYear_manufacture());
        retval.put("noofowner", this.getNo_of_owner());
        retval.put("picname", this.getPic_name());

        return retval;
    }

    
}
