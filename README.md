## JANJI
Saya Shidqi Rasyad Firjatulah dengan NIM 2408156 mengerjakan TP6 pada mata kuliah DPBO untuk keberkahannya saya menyatakan bahwa saya tidak melakukan kecurangan sebagaimana yang dispesifikasikan.


---

## Desain Program
### `Class APP`
Main class yang menjalankan program (menampilkan dan memulai game)
 - Membuat Jframe tempat game dijalankan.
 - Menentukan ukuran, posisi, dan pengaturan tampilan
 - Menampilkan tampilan Menu.
   
### `Class Logic`
Mengatur Logika permainan, meliputi:
 - Mengatur gravitasi dan gerakan player.
 - mengatur pembuatan pipa dan menggerakan pipa.
 - Mengecek burung jatuh atau tabrakan antara burung dan pipa.
 - menambahkan skor saat melewati pipa.
 - Mengatur kondisi Game Over, restart, dan kembali ke Menu.
   
### `Class View`
Mengatur tampilan visual permainan.
Fungsinya:
- menggambar background, burung, pipa, dan skor ke layar.
- Menampilkan teks saat Game Over, seperti :
  - "Game Over"
  - "Final Score" -> Menampilkan score akhir
  - "press R for restart" -> memuat ulang game
  - "press M for menu " -> kembali ke menu utama
    
### `Class Player`
Merepresentasikan burung/player.
Menyimpan:
 - Posisi player
 - Ukuran player
 - Kecepatan jatuh
 - GambarBurung
   
### `Class Pipe`
Merepresentasikan pipa.
Menyimpan:
 - Posisi pipa
 - Ukuran pipa
 - Gambar pipa
 - Pergerakan Pipa
   
### `Class Menu`
Menampilkan tampilan utama saat App dijalankan.
Fungsi :
 - Menampilkan teks judul game
 - Menyediakan tombol:
   Mulai -> Memulai permainan
   Keluar -> Menutup Program

    ---
   
## Alur
1. Saat program dijalankan -> `APP` menampilkan `Menu`.
2. Pemain menekan mulai -> `Logic` dan `View` dijalankan (game dimulai)
3. burung bergerak naik-turun, pipa bergerak ke kiri.
4. Pemain mendapatkan skor saat berhasil melewati pipa.
5. jika burung jatuh atau menabrak pipa -> Game Over.
6. Pemain Bisa
    - Press R -> memulai ulang game
    - Press M -> Kembali ke menu utama.

       ---
   
# Dokumentasi
https://github.com/user-attachments/assets/59f16790-3ea2-4183-b984-abf984603a41









