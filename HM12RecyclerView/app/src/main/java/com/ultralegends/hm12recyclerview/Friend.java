package com.ultralegends.hm12recyclerview;

public class Friend {
    private int id;
    private int imageID;
    private String name;
    private int dob;
    private String city;

    public Friend(int id, int imageID, String name, int dob, String city) {
        this.id = id;
        this.imageID = imageID;
        this.name = name;
        this.dob = dob;
        this.city = city;
    }

    public Friend() {
        this.id = 0;
        this.imageID = 0;
        this.name = "";
        this.dob = 0;
        this.city = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", imageID=" + imageID +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", city='" + city + '\'' +
                '}';
    }
}
