/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan2;

import java.util.Scanner;

/**
 *
 * @author Anisa
 */
public class LatConsole {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("        INPUT DATA MAHASISWA        ");
        System.out.println("====================================");

        System.out.print("Masukkan NIM     : ");
        String nim = input.nextLine();

        System.out.print("Masukkan Nama    : ");
        String nama = input.nextLine();

        System.out.print("Masukkan Jurusan : ");
        String jurusan = input.nextLine();

        Mahasiswa mhs = new Mahasiswa(nim, nama, jurusan);

        System.out.println("\n==============================================");
        System.out.println("              DATA MAHASISWA                  ");
        System.out.println("==============================================");

        System.out.printf("%-15s %-20s %-20s\n", "NIM", "NAMA", "JURUSAN");
        System.out.println("------------------------------------------------------------");

        mhs.tampilData();
    }
}
