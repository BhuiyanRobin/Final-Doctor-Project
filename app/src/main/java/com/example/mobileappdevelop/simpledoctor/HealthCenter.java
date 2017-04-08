package com.example.mobileappdevelop.simpledoctor;

/**
 * Created by bhuiy on 4/6/2017.
 */

public class HealthCenter {
    private int pescription;
    private  int docId;
    private String details;
    private String date;
    private int id;

    //region Costructor


    public HealthCenter(int pescription, int docId, String details, String date, int id) {
        this.pescription = pescription;
        this.docId = docId;
        this.details = details;
        this.date = date;
        this.id = id;
    }

    public HealthCenter() {
    }
    //endregion

    //region Getter

    public int getPescription() {
        return pescription;
    }

    public int getId() {
        return id;
    }

    public int getDocId() {
        return docId;
    }

    public String getDetails() {
        return details;
    }

    public String getDate() {
        return date;
    }

    //endregion

    //region Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setPescription(int pescription) {
        this.pescription = pescription;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDate(String date) {
        this.date = date;
    }

    //endregion

    //region Method
    //endregion

}
