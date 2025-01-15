package com.cinemasystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Salon extends BaseEntity {
    private int oturmaKapasitesi;
    private String ekranTipi;
    private Film guncelFilm;
    private List<Musteri> filmMusteriListesi;

    public Salon(String isim, String durum, int oturmaKapasitesi, String ekranTipi, Film guncelFilm) {
        super(isim, durum);
        this.oturmaKapasitesi = oturmaKapasitesi;
        this.ekranTipi = ekranTipi;
        this.guncelFilm = guncelFilm;
        this.filmMusteriListesi = new ArrayList<>();
    }

    public Salon() {
        super();
    }

    public Salon(String isim, String durum) {
        super(isim, durum);
    }

    public Film getGuncelFilm() {
        return guncelFilm;
    }

    public void setGuncelFilm(Film guncelFilm) {
        this.guncelFilm = guncelFilm;
    }

    public List<Musteri> getFilmMusteriListesi() {
        return filmMusteriListesi;
    }

    public void setFilmMusteriListesi(List<Musteri> filmMusteriListesi) {
        this.filmMusteriListesi = filmMusteriListesi;
    }

    public int getOturmaKapasitesi() {
        return oturmaKapasitesi;
    }

    public void setOturmaKapasitesi(int oturmaKapasitesi) {
        this.oturmaKapasitesi = oturmaKapasitesi;
    }

    public String getEkranTipi() {
        return ekranTipi;
    }

    public void setEkranTipi(String ekranTipi) {
        this.ekranTipi = ekranTipi;
    }

    @Override
    public void bilgiGoster() {
        System.out.println("İsim: " + getIsim());
        System.out.println("Durum: " + getDurum());
        System.out.println("Oturma Kapasitesi: " + oturmaKapasitesi);
        System.out.println("Ekran Tipi: " + ekranTipi);
        System.out.println("Güncel Film: " + guncelFilm.getFilmAdi());
        System.out.println("Film Musteri Listesi: ");
        for (Musteri musteri : filmMusteriListesi) {
            System.out.print(musteri.getIsim() + ", ");
            if (musteri.equals(filmMusteriListesi.get(filmMusteriListesi.size() - 1))) {
                System.out.print(musteri.getIsim());
            }
        }
        System.out.println();
        System.out.println("-------------------------");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salon salon)) return false;
        return getOturmaKapasitesi() == salon.getOturmaKapasitesi() && Objects.equals(getEkranTipi(), salon.getEkranTipi()) && Objects.equals(getGuncelFilm(), salon.getGuncelFilm()) && Objects.equals(getFilmMusteriListesi(), salon.getFilmMusteriListesi());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOturmaKapasitesi(), getEkranTipi(), getGuncelFilm(), getFilmMusteriListesi());
    }
}
