/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AddCarItem;

import org.json.simple.JSONObject;

/**
 *
 * @author ANITA-PC
 */
public class AddItemG_S {

    private int Cid;
    private String namemodel;
    private String version;
    private String fuel_type;
    private String mileage;
    private String roadprice;
    private String city;
    private String short_description;
    private int uiid;
    private String date;
    private int rating;
    
    
    private int firstrange;
    private int secondrange;
    private String rangepriceinword;
    private int rto;
    private int insurance;
    private int otherprice;
    private String otherpriceindetail;
    private int actualamount;
    private String color;
    private String summary;
    
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

    public String getRoadprice() {
        return roadprice;
    }

    public void setRoadprice(String roadprice) {
        this.roadprice = roadprice;
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
    

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRto() {
        return rto;
    }

    public void setRto(int rto) {
        this.rto = rto;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public int getOtherprice() {
        return otherprice;
    }

    public void setOtherprice(int otherprice) {
        this.otherprice = otherprice;
    }

    public int getFirstrange() {
        return firstrange;
    }

    public void setFirstrange(int firstrange) {
        this.firstrange = firstrange;
    }

    public int getSecondrange() {
        return secondrange;
    }

    public void setSecondrange(int secondrange) {
        this.secondrange = secondrange;
    }

    public String getRangepriceinword() {
        return rangepriceinword;
    }

    public void setRangepriceinword(String rangepriceinword) {
        this.rangepriceinword = rangepriceinword;
    }

    public String getOtherpriceindetail() {
        return otherpriceindetail;
    }

    public void setOtherpriceindetail(String otherpriceindetail) {
        this.otherpriceindetail = otherpriceindetail;
    }

    public int getActualamount() {
        return actualamount;
    }

    public void setActualamount(int actualamount) {
        this.actualamount = actualamount;
    }
    
    
    
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPic_name() {
        return pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }
    
    public JSONObject getJSONObject1()
    {
        JSONObject retval = new JSONObject();
        
        retval.put("cid", this.getCid());
        retval.put("name", this.getNamemodel());
        retval.put("version", this.getVersion());
        retval.put("fuel", this.getFuel_type());
        retval.put("mileage", this.getMileage());
        
        retval.put("city", this.getCity());
        retval.put("firstrange", this.getFirstrange());
        retval.put("secondrange", this.getSecondrange());
        retval.put("rangeinword", this.getRangepriceinword());
        retval.put("roadprice", this.getRoadprice());
        retval.put("color", this.getColor());
        retval.put("picname", this.getPic_name());

        return retval;
    }
    
    public AddItemG_S() {
    }
    
    
}
