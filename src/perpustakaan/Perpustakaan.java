/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;
import java.util.*;
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;
public class Perpustakaan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     // menggunakan scanner dan menyimpan apa yang diketik di variabel nama
        Login login = new Login();
        login.prosesLogin();

        Buku buku = new Buku();
        boolean exit = true ;

        Scanner input = new Scanner(System.in);

        while(exit) {
           System.out.println("--------MENU-------");
           System.out.println("===================");
           System.out.println("1. Tambah Data Buku");
           System.out.println("2. Edit Data Buku");
           System.out.println("3. Hapus Data Buku");
           System.out.println("4. Tampilkan Data Buku");
           System.out.println("5. Detail Buku");
           System.out.println("6. Exit");
           System.out.println("Ketik Angka Untuk Memilih");
           String pilih = input.nextLine();

           switch(pilih){
               case "1" ->{ 
                   System.out.println("Tambah data Buku : ");
                   String tambah = input.nextLine();
                   buku.tambahBuku(tambah);
                   break;
               }

               case "2" -> {
                   System.out.println("Buku Yang Mau di Edit : ");
                   String bukuLama = input.nextLine();
                   String bukuBaru = input.nextLine();
                   buku.editBuku(bukuLama, bukuBaru);
                   break;
               }


               case  "3"->{ 
                   System.out.println("Hapus Data Buku");
                   String hapus = input.nextLine();
                   buku.hapusBuku(hapus);
                   break;
               }

               case  "4" ->{ 
                   System.out.println("Tampilkan data Buku");
                   buku.tampilDataBuku();
                   break;
               }
               
               case "5" -> {
                   System.out.println("Input Buku untuk melihat detail");
                   String detail = input.nextLine();
                   buku.bukuDB(detail);
                   break;

               }

               default -> {
                   exit = false;
               }
           }
        }  
    }
}   

class Buku extends Database {
    List<String> Buku = new ArrayList<>();
    public Object buku;
    
    
    public Buku()
    {
      Buku.add("Matematika");
      Buku.add("Pancasila");
      Buku.add("Kimia");
    }
    
    public void tambahBuku(String buku)
    {
        Buku.add(buku);
        System.out.println("Berhasil Menambahkan Buku "+buku );
    }
    
    public void hapusBuku(String buku)
    {
        Buku.remove(buku);
        System.out.println("Berhasil Menghapus"+buku );
    }
    
    public void editBuku(String bukuLama , String bukuEdit)
    {
        Buku.remove(bukuLama);
        Buku.add(bukuEdit);
        System.out.println("Edit Buku"+bukuLama+"Menjadi"+bukuEdit);        
    }
    
    public void tampilDataBuku()
    {
        for(String buku : Buku){
            System.out.println(buku+", ");
        }
        
    }
}
class Database {
    
    public boolean loginDB(String username, String password) {
        if(username.equals("adi")) {
            if (password.equals("123")) {
                return true;
            } else {
                System.out.println("Password salah");
            }
        } else if(username.equals("andy")) {
            if (password.equals("12345")) {
                return true;
            } else {
                System.out.println("Password salah");
            }
        } else if(username.equals("raka")) {
            if (password.equals("1111")) {
                return true;
            } else {
                System.out.println("Password salah");
            }
        } else {
            System.out.println("Username tidak terdaftar");
        }
        
        return false;
    }
    
    public void bukuDB(String buku) {
        if (buku.equals("matematika") || buku.equals("Matematika")) {
            System.out.println("Penerbit: Airlangga");
            System.out.println("Harga: Rp. 100,000");
            System.out.println("Tahun Terbit: 2008");
            System.out.println("Author: Pablo Picaso");
        } else if (buku.equals("pancasila") || buku.equals("Pancasila")) {
            System.out.println("Penerbit: Airlangga");
            System.out.println("Harga: Rp. 80,000");
            System.out.println("Tahun Terbit: 2007");
            System.out.println("Author: Denny S.");
        } else if (buku.equals("kimia") || buku.equals("Kimia")) {
            System.out.println("Penerbit: Airlangga");
            System.out.println("Harga: Rp. 95,000");
            System.out.println("Tahun Terbit: 2010");
            System.out.println("Author: Rifky A.D.");
        }
    }
}


class Login extends Database {
   
    public boolean prosesLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("       Login Staff      ");
        boolean notLogin = true;

        while (notLogin) {

            System.out.print("Enter Username : ");
            String username = input.nextLine();

            Scanner input2 = new Scanner(System.in);
            System.out.print("Enter Password : ");
            String password = input2.nextLine();

            if (this.loginDB(username, password) == true) {
                notLogin = false;
            }
           
        }
        
        return true;
 
    }
}