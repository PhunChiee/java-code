package bo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import bean.nhansu;
import bean.nhanvien;
import bean.sinhvien;
import dao.nhansudao;

public class nhansubo {
 nhansudao nsdao = new nhansudao();
 ArrayList<nhansu> ds;
 public ArrayList<nhansu> getns() throws Exception{
	 ds = nsdao.getns();
	 return ds;
 }
 public void Hienthi() throws Exception{
	 System.out.println("Danh sach nhan su:");
	 System.out.println("Danh sach sinh vien: ");
	 for(nhansu item: getns()) {
		 if(item instanceof sinhvien) {
			 sinhvien sv = (sinhvien)item;
			 sv.Hienthins();
			 sv.hienthisv();
		 }
		 }
	 System.out.println("Danh sach nhan vien: ");
	 for(nhansu item: getns()) {
		 if(item instanceof nhanvien) {
			 nhanvien nv = (nhanvien)item;
			 nv.Hienthins();
			 nv.hienthinv();
		 }
	 }
 }
 public void Ghi() throws Exception{
	 try {
		FileWriter f1 = new FileWriter("f1.txt");
		PrintWriter p1 = new PrintWriter(f1);
		for(nhansu item: getns()) {
			 if(item instanceof sinhvien) {
				 sinhvien sv = (sinhvien)item;
				 p1.println(sv.getMa() + ";" + sv.getHoten()+";" + sv.getNgaysinh()+ ";" + sv.getDiem1()+";"+ sv.getDiem2() + ";"+ sv.Dtb());
			 }
		}
		p1.close();
		
		FileWriter f2 = new FileWriter("f2.txt");
		PrintWriter p2 = new PrintWriter(f2);
		for(nhansu item: getns()) {
			 if(item instanceof nhanvien) {
				 nhanvien nv = (nhanvien)item;
				 p2.println(nv.getMa()+";"+nv.getHoten()+";"+nv.getNgaysinh()+";"+nv.getHsl()+";"+nv.luong());
			 }
		}
		p2.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
 }
 public void Tim() throws Exception{
	 Scanner sc = new Scanner(System.in);
	 System.out.println("Nhap ho ten sinh vien can tim: ");
	 String ht = sc.nextLine();
	 for(nhansu item: ds) {
		 if(item.getHoten().toLowerCase().trim().contains(ht.toLowerCase().trim())) {
			 if(item instanceof sinhvien) {
				 sinhvien sv = (sinhvien)item;
				 sv.Hienthins();
				 sv.hienthisv();
			 } 
		 }

	 }
 }
 public Long Tongluong() throws Exception{
	 Long sum = (long) 0;
	 System.out.println("Tong luong cua nhan vien: ");
	 for(nhansu item: getns()) {
		 if(item instanceof nhanvien) {
			 nhanvien nv = (nhanvien)item;
			 sum = (long) (sum + nv.luong());
		 }		 
	}return sum;
 }
}
