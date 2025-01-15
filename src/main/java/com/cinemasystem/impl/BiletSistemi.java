package com.cinemasystem.impl;

import com.cinemasystem.models.Film;
import com.cinemasystem.models.Musteri;
import com.cinemasystem.models.Salon;

import java.util.List;

public interface BiletSistemi {
    void filmeKayitOl(Salon salon, Musteri musteri);
    void salonaFilmiAta(Salon salon, Film film);
    void filmListesineEkle(Film film);
    List<Film> filmListesiGetir();
    void musteriListesineEkle(Musteri musteri);
    List<Musteri> musteriListesiGetir();
    void salonListesineEkle(Salon salon);
    List<Salon> salonListesiGetir();
}
