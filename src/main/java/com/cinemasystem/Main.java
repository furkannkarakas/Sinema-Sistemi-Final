package com.cinemasystem;

import com.cinemasystem.impl.BiletSistemi;
import com.cinemasystem.impl.BiletSistemiImpl;
import com.cinemasystem.models.Film;
import com.cinemasystem.models.Musteri;
import com.cinemasystem.models.Salon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BiletSistemi biletSistemi = new BiletSistemiImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sinema Sistemine Hoşgeldiniz!");



        while (true) {
            System.out.println("İşlem seçiniz: ");
            System.out.println("1. Film Ekle");
            System.out.println("2. Salon Ekle");
            System.out.println("3. Müşteri Ekle");
            System.out.println("4. Salona Filmi Ata");
            System.out.println("5. Filme Kayıt Ol");
            System.out.println("6. Bilgi Göster");
            System.out.println("7. Çıkış");

            System.out.print("Seçiminiz: ");
            String input = scanner.nextLine();

            if (input.equals("7")) {
                System.out.println("Sistemden çıkılıyor...");
                break;
            }

            try {
                int secim = Integer.parseInt(input);

                switch (secim) {
                    case 1:
                        filmOlustur(scanner, biletSistemi);
                        break;
                    case 2:
                        salonOlustur(scanner, biletSistemi);
                        break;
                    case 3:
                        musteriOlustur(scanner, biletSistemi);
                        break;
                    case 4:
                        salonaFilmAta(scanner, biletSistemi);
                        break;
                    case 5:
                        filmeKayitOl(scanner, biletSistemi);
                        break;
                    case 6:
                        bilgiGoster(scanner, biletSistemi);
                        break;
                    case 7:
                        System.out.println("Sistemden çıkılıyor...");
                        break;
                    default:
                        System.out.println("Geçersiz seçim. Lütfen tekrar deneyiniz.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz giriş. Lütfen bir sayı giriniz.");
            }
        }
        scanner.close();
    }

    private static void musteriOlustur(Scanner scanner, BiletSistemi biletSistemi) {
        System.out.println("Müşteri adını giriniz: ");
        String isim = scanner.nextLine();

        System.out.println("Müşteri durumunu giriniz (aktif/pasif): ");
        String durum = scanner.nextLine();

        System.out.println("Müşteri telefon numarasını giriniz: ");
        String telefonNo = scanner.nextLine();

        System.out.println("Müşteri e-posta adresini giriniz: ");
        String email = scanner.nextLine();

        Musteri musteri = new Musteri(isim, durum, telefonNo, email);
        biletSistemi.musteriListesineEkle(musteri);
        System.out.println("Müşteri eklendi: " + musteri.getIsim());
    }

    private static void salonOlustur(Scanner scanner, BiletSistemi biletSistemi) {
        System.out.println("Salon adını giriniz: ");
        String isim = scanner.nextLine();

        System.out.println("Salon durumunu giriniz (aktif/pasif vb.): ");
        String durum = scanner.nextLine();

        System.out.println("Salon kapasitesini giriniz: ");
        int kapasite = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Salon ekran tipini giriniz: ");
        String ekranTipi = scanner.nextLine();

        System.out.println("Listeden film seçiniz: ");

        if (biletSistemi.filmListesiGetir().isEmpty()) {
            System.out.println("Henüz film eklenmemiş. Önce film ekleyiniz.");
            return;
        }

        for (int i = 0; i < biletSistemi.filmListesiGetir().size(); i++) {
            System.out.println(i + 1 + ". " + biletSistemi.filmListesiGetir().get(i).getFilmAdi());
        }

        int secim = scanner.nextInt();
        Film secilenFilm = biletSistemi.filmListesiGetir().get(secim - 1);

        var salon = new Salon(isim, durum, kapasite, ekranTipi, secilenFilm);
        biletSistemi.salonListesineEkle(salon);
        System.out.println("Salon eklendi: " + salon.getIsim());
        scanner.nextLine();
    }

    private static void filmOlustur(Scanner scanner, BiletSistemi biletSistemi) {
        System.out.println("Film adını giriniz: ");
        String filmAdi = scanner.nextLine();

        System.out.println("Film türünü giriniz: ");
        String tur = scanner.nextLine();

        System.out.println("Film süresini giriniz (dakika cinsinden): ");
        int sure = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Film yönetmenini giriniz: ");
        String yonetmen = scanner.nextLine();

        Film film = new Film(filmAdi, tur, sure, yonetmen);

        biletSistemi.filmListesineEkle(film);

        System.out.println("Film eklendi: " + film.getFilmAdi());
    }

    private static void salonaFilmAta(Scanner scanner, BiletSistemi biletSistemi) {
        System.out.println("Salon seçiniz: ");

        if (biletSistemi.salonListesiGetir().isEmpty()) {
            System.out.println("Henüz salon eklenmemiş. Önce salon ekleyiniz.");
            return;
        }

        for (int i = 0; i < biletSistemi.salonListesiGetir().size(); i++) {
            System.out.println(i + 1 + ". " + biletSistemi.salonListesiGetir().get(i).getIsim());
        }

        int salonSecim = scanner.nextInt();

        System.out.println("Film seçiniz: ");

        if (biletSistemi.filmListesiGetir().isEmpty()) {
            System.out.println("Henüz film eklenmemiş. Önce film ekleyiniz.");
            return;
        }

        for (int i = 0; i < biletSistemi.filmListesiGetir().size(); i++) {
            System.out.println(i + 1 + ". " + biletSistemi.filmListesiGetir().get(i).getFilmAdi());
        }

        int filmSecim = scanner.nextInt();

        var salon = biletSistemi.salonListesiGetir().get(salonSecim - 1);
        var film = biletSistemi.filmListesiGetir().get(filmSecim - 1);

        biletSistemi.salonaFilmiAta(salon, film);

        System.out.println("Film salona atandı: " + film.getFilmAdi() + " -> " + salon.getIsim());
        scanner.nextLine();
    }

    private static void filmeKayitOl(Scanner scanner, BiletSistemi biletSistemi) {
        System.out.println("Film seçiniz: ");

        if (biletSistemi.filmListesiGetir().isEmpty()) {
            System.out.println("Henüz film eklenmemiş. Önce film ekleyiniz.");
            return;
        }

        for (int i = 0; i < biletSistemi.salonListesiGetir().size(); i++) {
            System.out.println(i + 1 + ". " + biletSistemi.salonListesiGetir().get(i).getGuncelFilm().getFilmAdi() + " -> " + biletSistemi.salonListesiGetir().get(i).getIsim());
        }

        int filmSecim = scanner.nextInt();

        System.out.println("Müşteri seçiniz: ");

        if (biletSistemi.musteriListesiGetir().isEmpty()) {
            System.out.println("Henüz müşteri eklenmemiş. Önce müşteri ekleyiniz.");
            return;
        }

        for (int i = 0; i < biletSistemi.musteriListesiGetir().size(); i++) {
            System.out.println(i + 1 + ". " + biletSistemi.musteriListesiGetir().get(i).getIsim());
        }

        int musteriSecim = scanner.nextInt();

        var salon = biletSistemi.salonListesiGetir().get(filmSecim - 1);
        var musteri = biletSistemi.musteriListesiGetir().get(musteriSecim - 1);

        biletSistemi.filmeKayitOl(salon, musteri);

        System.out.println("Müşteri filme kayıt oldu: " + musteri.getIsim() + " -> " + salon.getGuncelFilm().getFilmAdi());
        scanner.nextLine();
    }

    public static void bilgiGoster(Scanner scanner, BiletSistemi biletSistemi) {
        System.out.println("Görmek istediğiniz bilgiyi seçiniz");

        System.out.println("1. Film Bilgileri");
        System.out.println("2. Müşteri Bilgileri");
        System.out.println("3. Salon Bilgileri");

        System.out.print("Seçiminiz: ");
        String input = scanner.nextLine();

        try {
            int secim = Integer.parseInt(input);

            switch (secim) {
                case 1:
                    System.out.println("Filmler: ");
                    for (var film : biletSistemi.filmListesiGetir()) {
                        System.out.println(film.toString());
                    }
                    break;
                case 2:
                    System.out.println("Müşteriler: ");
                    for (var musteri : biletSistemi.musteriListesiGetir()) {
                        musteri.bilgiGoster();
                    }
                    break;
                case 3:
                    System.out.println("Salonlar: ");
                    for (var salon : biletSistemi.salonListesiGetir()) {
                        salon.bilgiGoster();
                    }
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyiniz.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Geçersiz giriş. Lütfen bir sayı giriniz.");
        }

    }

    public static void ornekVeriEkle(BiletSistemi biletSistemi) {
        var film1 = new Film("Arog", "Bilim Kurgu", 169, "Christopher Nolan");
        var film2 = new Film("GORA", "Bilim Kurgu", 148, "Christopher Nolan");
        var film3 = new Film("Mafya", "Aksiyon", 152, "Christopher Nolan");

        biletSistemi.filmListesineEkle(film1);
        biletSistemi.filmListesineEkle(film2);
        biletSistemi.filmListesineEkle(film3);

        var musteri1 = new Musteri("Furkan", "Aktif", "f@g.com", "1234567890");
        var musteri2 = new Musteri("Arda", "Pasif", "abc@g.com", "0987654321");

        biletSistemi.musteriListesineEkle(musteri1);
        biletSistemi.musteriListesineEkle(musteri2);

        var salon1 = new Salon("Salon 1", "Aktif", 100, "IMAX", film1);
        var salon2 = new Salon("Salon 2", "Pasif", 150, "4DX", film2);

        biletSistemi.salonListesineEkle(salon1);
        biletSistemi.salonListesineEkle(salon2);

        biletSistemi.salonaFilmiAta(salon1, film1);
        biletSistemi.salonaFilmiAta(salon2, film2);

        biletSistemi.filmeKayitOl(salon1, musteri1);
        biletSistemi.filmeKayitOl(salon2, musteri2);
    }
}
