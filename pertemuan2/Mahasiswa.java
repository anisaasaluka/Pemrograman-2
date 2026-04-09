/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pertemuan2;

/**
 *
 * @author Anisa
 */
public class Mahasiswa {
   String nim;
    String nama;
    String jurusan;

    public Mahasiswa(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public void tampilData() {
        System.out.printf("%-15s %-20s %-20s\n", nim, nama, jurusan);
    }
}
