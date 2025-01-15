package com.cinemasystem.models;

import java.util.Objects;

public class Film {
    private String filmAdi;
    private String filmTuru;
    private int filmSuresi;
    private String filmYonetmeni;

    public Film(String filmAdi, String filmTuru, int filmSuresi, String filmYonetmeni) {
        this.filmAdi = filmAdi;
        this.filmTuru = filmTuru;
        this.filmSuresi = filmSuresi;
        this.filmYonetmeni = filmYonetmeni;
    }

    public Film() {
        super();
    }

    public String getFilmAdi() {
        return filmAdi;
    }

    public void setFilmAdi(String filmAdi) {
        this.filmAdi = filmAdi;
    }

    public String getFilmTuru() {
        return filmTuru;
    }

    public void setFilmTuru(String filmTuru) {
        this.filmTuru = filmTuru;
    }

    public int getFilmSuresi() {
        return filmSuresi;
    }

    public void setFilmSuresi(int filmSuresi) {
        this.filmSuresi = filmSuresi;
    }

    public String getFilmYonetmeni() {
        return filmYonetmeni;
    }

    public void setFilmYonetmeni(String filmYonetmeni) {
        this.filmYonetmeni = filmYonetmeni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film film)) return false;
        return getFilmSuresi() == film.getFilmSuresi() && Objects.equals(getFilmAdi(), film.getFilmAdi()) && Objects.equals(getFilmTuru(), film.getFilmTuru()) && Objects.equals(getFilmYonetmeni(), film.getFilmYonetmeni());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFilmAdi(), getFilmTuru(), getFilmSuresi(), getFilmYonetmeni());
    }

    @Override
    public String toString() {
        return "Film Adı: " + filmAdi + "\n" +
                "Film Türü: " + filmTuru + "\n" +
                "Film Süresi: " + filmSuresi + "\n" +
                "Film Yönetmeni: " + filmYonetmeni + "\n";
    }
}
