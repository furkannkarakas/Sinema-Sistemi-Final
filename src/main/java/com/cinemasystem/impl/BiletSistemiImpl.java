package com.cinemasystem.impl;

import com.cinemasystem.models.Film;
import com.cinemasystem.models.Musteri;
import com.cinemasystem.models.Salon;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BiletSistemiImpl implements BiletSistemi {

    private ObjectMapper objectMapper;
    private static final String FILM_FILE = "src/main/resources/filmler.json";
    private static final String MUSTERI_FILE = "src/main/resources/musteriler.json";
    private static final String SALON_FILE = "src/main/resources/salonlar.json";

    public BiletSistemiImpl() {
        this.objectMapper = new ObjectMapper();
    }

    private <T> List<T> loadFromFile(String filePath, Class<T> type) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, type));
            } else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private <T> void saveToFile(List<T> list, String filePath) {
        try {
            objectMapper.writeValue(new File(filePath), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filmeKayitOl(Salon salon, Musteri musteri) {
        List<Salon> salonListesi = loadFromFile(SALON_FILE, Salon.class);
        for (Salon existingSalon : salonListesi) {
            if (existingSalon.equals(salon)) { // Compare by reference or some property
                existingSalon.getFilmMusteriListesi().add(musteri);
                break;
            }
        }
        saveToFile(salonListesi, SALON_FILE);
    }

    @Override
    public void salonaFilmiAta(Salon salon, Film film) {
        List<Salon> salonListesi = loadFromFile(SALON_FILE, Salon.class);
        for (Salon existingSalon : salonListesi) {
            if (existingSalon.equals(salon)) {
                existingSalon.setGuncelFilm(film);
                break;
            }
        }
        saveToFile(salonListesi, SALON_FILE);
    }

    @Override
    public void filmListesineEkle(Film film) {
        List<Film> filmListesi = loadFromFile(FILM_FILE, Film.class);
        filmListesi.add(film);
        saveToFile(filmListesi, FILM_FILE);
    }

    @Override
    public List<Film> filmListesiGetir() {
        return loadFromFile(FILM_FILE, Film.class);
    }

    @Override
    public void musteriListesineEkle(Musteri musteri) {
        List<Musteri> musteriListesi = loadFromFile(MUSTERI_FILE, Musteri.class);
        musteriListesi.add(musteri);
        saveToFile(musteriListesi, MUSTERI_FILE);
    }

    @Override
    public List<Musteri> musteriListesiGetir() {
        return loadFromFile(MUSTERI_FILE, Musteri.class);
    }

    @Override
    public void salonListesineEkle(Salon salon) {
        List<Salon> salonListesi = loadFromFile(SALON_FILE, Salon.class);
        salonListesi.add(salon);
        saveToFile(salonListesi, SALON_FILE);
    }

    @Override
    public List<Salon> salonListesiGetir() {
        return loadFromFile(SALON_FILE, Salon.class);
    }
}
