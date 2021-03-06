package com.example.choi.eattle_prototype;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by choi on 2015-01-21.
 */
//관광지 정보들을 담고 있는 클래스 - DB에서 읽어들인 데이터로 초기화 한다.
public class TouristSpotInfo implements Parcelable, Comparable<TouristSpotInfo> {
    private int _id;
    private String name;
    private String explanation;
    private int resId;
    //위치 정보
    private double latitude; //위도
    private double longitude; //경도
    private double radius; //반경
    private double spotDistanceFromMe; // 현재 위치로 부터 얼마나 떨어져 있는지
    private String[] detailedInfo;
    private int visit;//해당 관광지를 방문하지 않았으면0, 방문했으면 1
    private int isNotified;//notification을 넣지 않았으면 0, 넣었으면 1
    private int favorite;//즐겨찾기가 아니면 0, 맞으면 1
    public TouristSpotInfo() {
    }

    //depth2를 위한 생성자
    public TouristSpotInfo(int _id,String name, String explanation, int resId, double latitude, double longitude) {
        this.name = name;
        this.explanation = explanation;
        this.resId = resId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.visit = 0;
        this.isNotified = 0;
        this.favorite = 0;
    }

    //depth1을 위한 생성자
    public TouristSpotInfo(int _id,String name, String explanation, int resId, double latitude, double longitude, double radius, String spotInfoID) {
        this.name = name;
        this.explanation = explanation;
        this.resId = resId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.detailedInfo =  spotInfoID.split("\\.");// 마침표(.)단위로 파싱한다.
        this.visit = 0;
        this.isNotified = 0;
        this.favorite = 0;
    }

    public TouristSpotInfo(Parcel src) {
        this.name = src.readString();
        this.explanation = src.readString();
        this.resId = src.readInt();
        this.latitude = src.readDouble();
        this.longitude = src.readDouble();
    }

    @SuppressWarnings("unchecked")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public TouristSpotInfo createFromParcel(Parcel in) {
            return new TouristSpotInfo(in);
        }

        public TouristSpotInfo[] newArray(int size) {
            return new TouristSpotInfo[size];
        }

    };


    public int describeContents() {
        return 0;
    }

    /**
     * 데이터를 Parcel 객체로 쓰기
     */

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.explanation);
        dest.writeInt(this.resId);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
    }

    //spotDistanceFromMe를 기준으로 오름차순으로 정렬하기 위한 함수
    public int compareTo(TouristSpotInfo man) {
        if (this.spotDistanceFromMe < man.spotDistanceFromMe) {
            return -1;
        } else if (this.spotDistanceFromMe == man.spotDistanceFromMe) {
            return 0;
        } else {
            return 1;
        }
    }

    // get, set
    int get_id(){
        return _id;
    }
    void set_id(int _id){
        this._id=_id;
    }
    String getName() {
        return this.name;
    }
    String getExplanation() {
        return this.explanation;
    }
    int getResId() {
        return this.resId;
    }

    double getLatitude() {
        return this.latitude;
    }

    double getLongitude() {
        return this.longitude;
    }

    double getSpotDistanceFromMe() {
        return this.spotDistanceFromMe;
    }

    String[] getDetailedInfo(){
        return this.detailedInfo;
    }

    int getVisit(){
        return this.visit;
    }
    void setVisit(int visit){
        this.visit = visit;
    }
    int getFavorite(){ return this.favorite;}
    void setFavorite(int favorite){this.favorite = favorite;}

    void setSpotDistanceFromMe(double spotDistanceFromMe) {
        this.spotDistanceFromMe = spotDistanceFromMe;
    }
    double getRadius(){
        return radius;
    }
    void setRadius(double radius){
        this.radius=radius;
    }
    int getIsNotified(){
        return isNotified;
    }
    void setIsNotified(int isNotified){
        this.isNotified=isNotified;
    }
}