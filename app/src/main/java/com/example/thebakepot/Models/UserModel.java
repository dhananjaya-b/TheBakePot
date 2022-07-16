package com.example.thebakepot.Models;
import android.os.Parcel;
import android.os.Parcelable;
public class UserModel implements Parcelable{
    private String username;
    private String fullname;
    private String phoneNumber;
    private String userUID;

    public UserModel(String currentUid, String userName, String fullName, String phoneNO) {
        this.username=userName;
        this.fullname=fullName;
        this.phoneNumber=phoneNO;
        this.userUID=currentUid;

    }
    public void DonatorData(){

    }
    protected UserModel(Parcel in){
        username=in.readString();
        fullname=in.readString();
        phoneNumber=in.readString();
        userUID=in.readString();

    }
    public static final Parcelable.Creator<UserModel> CREATOR=new Parcelable.Creator<UserModel>(){
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public void setUsername(String username){
        this.username=username;
    }
    public void setFullname(String fullname){
        this.fullname=fullname;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public void setUserUID(String userUID){
        this.userUID=userUID;
    }
    public String getUsername(){
        return username;
    }
    public String getFullname(){
        return fullname;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getUserUID(){
        return userUID;
    }


    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userUID);
        dest.writeString(username);
        dest.writeString(fullname);
        dest.writeString(phoneNumber);
    }
}
