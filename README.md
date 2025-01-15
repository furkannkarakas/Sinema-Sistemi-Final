# Sinema-Sistemi-Final

Sinema Sistemi uygulaması, konsol tabanlı bir bilet rezervasyon ve yönetim sistemidir. Kullanıcıların filmleri, salonları ve müşterileri yönetmelerine, salonlara filmler atamalarına ve müşterileri belirli filmlere kaydetmelerine olanak tanır.

Özellikler
-----------------------------------------

Film Ekle: Kullanıcılar, film adı, türü, süresi ve yönetmen gibi bilgileri girerek sistemde film ekleyebilir.

Salon Ekle: Salon adı, kapasitesi, ekran tipi ve ilişkili film gibi özelliklerle yeni salonlar oluşturabilir.

Müşteri Ekle: Müşteri adı, durumu, telefon numarası ve e-posta adresi gibi bilgileri girerek müşteri kaydı yapabilir.

Salona Film Ata: Belirli bir filme bir salon atayabilirsiniz.

Filme Kayıt Ol: Müşterilerin belirli bir salondaki filme kayıt olmalarını sağlar.

Bilgi Göster: Filmler, müşteriler ve salonlar hakkında bilgi görüntüleyin.

Çıkış: Sistemden güvenli bir şekilde çıkış yapar.


Nasıl Çalışır
-------------------------------------------

Sistem, kullanıcıların sayısal girişlerle gezinmesini sağlayan etkileşimli bir menü kullanır. Her menü seçeneği sistemdeki belirli bir işleme karşılık gelir.

Menü Seçenekleri:
-----------------------

Film Ekle: Yeni bir film ekleyin.

Salon Ekle: Yeni bir salon oluşturun ve isteğe bağlı olarak bir filmle ilişkilendirin.

Müşteri Ekle: Yeni bir müşteri kaydedin.

Salona Film Ata: Bir filmi bir salona atayın.

Filme Kayıt Ol: Bir müşteri için bir filme yer ayırtın.

Bilgi Göster: Filmler, müşteriler veya salonların listelerini görüntüleyin.

Çıkış: Sistemden çıkış yapar.


Sınıflar ve Metotlar
-----------------------------------

Main Sınıfı

Uygulamanın ana giriş noktasıdır. Kullanıcı arayüzünü ve menü gezinmesini yönetir.

Yardımcı Metotlar

filmOlustur: Kullanıcıdan film bilgilerini alır ve sisteme ekler.

salonOlustur: Kullanıcıdan salon bilgilerini alır ve salon oluşturur.

musteriOlustur: Kullanıcıdan müşteri bilgilerini alır ve yeni bir müşteri kaydeder.

salonaFilmAta: Bir filmi belirli bir salona atar.

filmeKayitOl: Bir müşterinin bir filme kaydolmasını sağlar.

bilgiGoster: Filmler, müşteriler veya salonların listelerini görüntüler.

ornekVeriEkle: Test için sisteme önceden tanımlanmış örnek veriler ekler.

BiletSistemi Arayüzü
-----------

Sinema sisteminin temel işlevlerini tanımlar:

Film, salon ve müşteri ekleme

Filmleri salonlara atama

Müşterileri filmlere kaydetme

Film, salon ve müşteri listelerini alma

BiletSistemiImpl Sınıfı

BiletSistemi arayüzünü uygular ve sinema sistemini yönetmek için işlevsellik sağlar.

Model Sınıfları

Film: Film adı, türü, süresi ve yönetmeni gibi özellikleri temsil eder.

Salon: Salon adı, kapasite, ekran tipi ve ilişkili film gibi özellikleri temsil eder.

Müşteri: Müşteri adı, durumu, telefon numarası ve e-posta adresi gibi özellikleri temsil eder.


Kullanım
-------------------------------

Main sınıfını çalıştırın.

Sistemle etkileşim kurmak için ekran talimatlarını takip edin.

Menüden film ekleme, salon ekleme, müşteri ekleme, film atama ve müşteri kaydı işlemlerini gerçekleştirin.

Örnek İş Akışı
---------------------------

Film Ekle: Film listesine yeni filmler ekleyin.

Salon Ekle: Salon oluşturun ve filmleri salonlara atayın.

Müşteri Ekle: Müşteri bilgilerini girerek kaydedin.

Salona Film Ata: Filmleri belirli salonlara bağlayın.

Filme Kayıt Ol: Müşterileri salonlardaki filmlere kaydedin.

Bilgi Göster: Kayıtlı tüm filmleri, salonları ve müşterileri görüntüleyin.

Çıkış: Uygulamayı kapatın.

