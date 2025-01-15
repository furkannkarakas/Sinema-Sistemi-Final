package com.cinemasystem.models;

import java.util.Objects;

public class Musteri extends BaseEntity {
    private String email;
    private String telefonNo;

    public Musteri(String isim, String durum) {
        super(isim, durum);
    }

    public Musteri() {
        super();
    }

    public Musteri(String isim, String durum, String email, String phoneNumber) {
        super(isim, durum);
        this.email = email;
        this.telefonNo = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    @Override
    public void bilgiGoster() {
        System.out.println("İsim: " + getIsim());
        System.out.println("Durum: " + getDurum());
        System.out.println("Email: " + email);
        System.out.println("Telefon Numarası: " + telefonNo);
        System.out.println("-------------------------");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Musteri musteri)) return false;
        return Objects.equals(getEmail(), musteri.getEmail()) && Objects.equals(getTelefonNo(), musteri.getTelefonNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getTelefonNo());
    }
}
