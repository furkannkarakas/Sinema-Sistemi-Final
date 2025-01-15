package com.cinemasystem.models;

public abstract class BaseEntity {
    private String isim;
    private String durum;

    public BaseEntity() {
    }

    public BaseEntity(String isim, String durum) {
        this.isim = isim;
        this.durum = durum;
    }

    public abstract void bilgiGoster();

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
}
