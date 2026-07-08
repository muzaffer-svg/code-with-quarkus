# AYBÜ Kampüs Portalı 🎓

Bu proje, üniversite öğrencileri ve görevlileri için geliştirilmiş tam yığın (full-stack) bir kayıt ve yönetim sistemidir. Güçlü bir Java backend mimarisi ile modern bir önyüz tasarımını bir araya getirir.

##  Proje Hakkında

Kampüs Portalı, sistemdeki farklı rollerin (Öğrenci ve Üniversite Görevlisi) kendilerine ait şık arayüzler üzerinden sisteme kaydolmalarını ve bu verilerin güvenli bir şekilde ilişkisel veri tabanına yazılmasını sağlar. Projede "Separation of Concerns" (Sorumlulukların Ayrılığı) prensibi benimsenmiş, statik web dosyaları ile veri işleyen API uçları birbirinden izole edilmiştir.

##  Özellikler

* **Rol Bazlı Kayıt Arayüzleri:** Öğrenciler ve personeller için özel tasarlanmış, modern ve duyarlı (responsive) HTML/CSS formları.
* **RESTful API Mimarisi:** İstemciden gelen JSON verilerini işleyen standartlara uygun API rotaları (`/api/studentss` ve `/api/officials`).
* **Otomatik Veri Tabanı Yönetimi:** Hibernate ORM with Panache sayesinde SQL yazmadan, doğrudan Java sınıfları (`CampusStudent` ve `CampusOfficial`) üzerinden veri tabanı işlemleri.
* **Güvenli Kimliklendirme:** Veri bütünlüğü ve güvenliği için `UUID` (Evrensel Benzersiz Tanımlayıcı) tabanlı otomatik ID üretimi.


## Veri Tabanı Yapılandırması

Uygulama, veritabanı bağlantısı için Quarkus'un sunduğu modern yapılandırmaları kullanır:

* **Geliştirici Modu (Sıfır Ayar):** Projeyi `quarkus:dev` modunda başlattığınızda, eğer sisteminizde Docker kuruluysa, Quarkus **Dev Services** özelliği sayesinde arka planda otomatik olarak geçici bir veritabanı ayağa kaldırır ve tabloları otomatik oluşturur (Ekstra bir veritabanı kurulumuna gerek yoktur).
* **Manuel Yapılandırma:** Kendi yerel veritabanınızı kullanmak isterseniz, `src/main/resources/application.properties` dosyasındaki veritabanı URL, kullanıcı adı ve şifre bilgilerini kendi ortamınıza göre güncelleyebilirsiniz.



##  Kullanılan Teknolojiler

**Backend (Arka Plan)**
* Java
* Quarkus Framework
* Hibernate ORM with Panache
* REST (JAX-RS)

**Frontend (Ön Yüz)**
* HTML5
* CSS3 (Glassmorphism & Modern Gradient Tasarım)
* Vanilla JavaScript (Fetch API)

## ⚙️ Kurulum ve Çalıştırma

Projeyi kendi bilgisayarında çalıştırmak için aşağıdaki adımları izleyebilirsin:

1. Depoyu klonlayın:

   ```bash
   git clone https://github.com/muzaffer-svg/code-with-quarkus
   ```

2. Proje dizinine gidin:

   ```bash
   cd code-with-quarkus
   ```

3. Quarkus geliştirici modunda uygulamayı başlatın:

   ```bash
   ./mvnw compile quarkus:dev
   ```

4. Tarayıcınızda uygulamayı görüntüleyin:

   ```
   http://localhost:8080/campus/index.html
   ```

## 👨‍💻 Geliştirici

Muzaffer Batmaz
