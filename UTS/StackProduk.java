/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts;

import java.util.Stack;

/**
 *
 * @author Anisa
 */
public class StackProduk {
     Stack<Produk> stack = new Stack<>();

    // tambah produk
    public void tambahProduk(Produk p) {
        stack.push(p);

        System.out.println("Produk masuk: " + p.getNama());
    }

    // hapus produk
    public Produk hapusProduk() throws Exception {

        if(stack.isEmpty()) {
            throw new Exception("Stok kosong!");
        }

        Produk p = stack.pop();

        System.out.println("Produk keluar: " + p.getNama());

        return p;
    }

    // ambil semua data
    public Stack<Produk> getData() {
        return stack;
    }
}
