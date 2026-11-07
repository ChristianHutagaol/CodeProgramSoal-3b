public class RiwayatKunjungan {

    // Node buatan sendiri
    private static class Node {
        String catatan;
        Node prev;
        Node next;

        Node(String catatan) {
            this.catatan = catatan;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node saatIni;
    private int ukuran;

    public RiwayatKunjungan() {
        head = null;
        tail = null;
        saatIni = null;
        ukuran = 0;
    }

    // Menambahkan kunjungan di akhir
    public void tambahKunjungan(String catatan) {

        if (catatan == null || catatan.trim().isEmpty()) {
            System.out.println("Catatan tidak boleh kosong.");
            return;
        }

        Node baru = new Node(catatan);

        if (head == null) {
            head = baru;
            tail = baru;
        } else {
            baru.prev = tail;
            tail.next = baru;
            tail = baru;
        }

        saatIni = baru;
        ukuran++;

        System.out.println("Tambah kunjungan: " + catatan);
        tampilkanSaatIni();
    }

    // Navigasi ke kunjungan sebelumnya
    public void sebelumnya() {

        if (saatIni == null) {
            System.out.println("Riwayat masih kosong.");
            return;
        }

        if (saatIni.prev == null) {
            System.out.println("Tidak ada kunjungan sebelumnya.");
            return;
        }

        saatIni = saatIni.prev;

        System.out.println("Navigasi: sebelumnya");
        tampilkanSaatIni();
    }

    // Navigasi ke kunjungan berikutnya
    public void berikutnya() {

        if (saatIni == null) {
            System.out.println("Riwayat masih kosong.");
            return;
        }

        if (saatIni.next == null) {
            System.out.println("Tidak ada kunjungan berikutnya.");
            return;
        }

        saatIni = saatIni.next;

        System.out.println("Navigasi: berikutnya");
        tampilkanSaatIni();
    }

    // Menampilkan kunjungan saat ini
    public void tampilkanSaatIni() {

        if (saatIni == null) {
            System.out.println("Belum ada kunjungan.");
        } else {
            System.out.println(
                "Saat ini [" + ukuran + " kunjungan tersimpan]: "
                + saatIni.catatan
            );
        }

        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {

        RiwayatKunjungan riwayat =
            new RiwayatKunjungan();

        System.out.println(
            "=== SIMULASI RIWAYAT KUNJUNGAN PASIEN ==="
        );

        // Menambahkan empat kunjungan
        riwayat.tambahKunjungan(
            "Kunjungan 1 - Pemeriksaan awal"
        );

        riwayat.tambahKunjungan(
            "Kunjungan 2 - Pemeriksaan laboratorium"
        );

        riwayat.tambahKunjungan(
            "Kunjungan 3 - Konsultasi dokter"
        );

        riwayat.tambahKunjungan(
            "Kunjungan 4 - Kontrol lanjutan"
        );

        // Navigasi mundur dua kali
        riwayat.sebelumnya();
        riwayat.sebelumnya();

        // Navigasi maju satu kali
        riwayat.berikutnya();

        System.out.println("=== POSISI AKHIR ===");
        riwayat.tampilkanSaatIni();
    }
}