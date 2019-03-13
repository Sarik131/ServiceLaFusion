package com.shariq.service_lafusion.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SpDetail implements Parcelable {

    private Long id= Long.valueOf(0);
    private String name="";
    private String email="";
    private String experience="";
    private String phoneno="";
    private String category="";
    private String password="";

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneno() {

        return phoneno;
    }

    public String getCategory() {
        return category;
    }

    public String getPassword() {
        return password;
    }

    public SpDetail(String name, Long id, String experience, String phoneno, String category, String password) {
        this.name = name;
        this.id = id;
        this.experience = experience;
        this.phoneno = phoneno;
        this.category = category;
        this.password = password;
    }

    protected SpDetail(Parcel in) {
        name = in.readString();
        id = in.readLong();
        experience = in.readString();
    }

    public static final Creator<SpDetail> CREATOR = new Creator<SpDetail>() {
        @Override
        public SpDetail createFromParcel(Parcel in) {
            return new SpDetail(in);
        }

        @Override
        public SpDetail[] newArray(int size) {
            return new SpDetail[size];
        }
    };

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public SpDetail(Long id, String text, String experience) {

        this.id=id;
        this.name = text;
        this.experience=experience;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeLong(id);
        dest.writeString(experience);
    }

    public SpDetail(Long id, String name, String email, String experience, String phoneno, String category, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.experience = experience;
        this.phoneno = phoneno;
        this.category = category;
        this.password = password;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getEmail() {

        return email;
    }

    public SpDetail(String email) {

        this.email = email;
    }
}

