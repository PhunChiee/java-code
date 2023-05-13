package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.nhansu;
import bean.nhanvien;
import bean.sinhvien;

public class nhansudao {
 public ArrayList<nhansu> getns() throws Exception{
	 ArrayList<nhansu> ds = new ArrayList<nhansu>();
	 FileReader f = new FileReader("ds.txt");
	 BufferedReader b = new BufferedReader(f);
	 while(true) {
			String s = b.readLine();
			if(s == null || s == "") break;
			String[] t = s.split("[;]");
			if(t.length == 5) {
				sinhvien sv = new sinhvien();
				sv.setMa(t[0]);
				sv.setHoten(t[1]);
				SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
				Date date = d.parse(t[2]);
				sv.setNgaysinh(date);
				sv.setDiem1(Double.parseDouble(t[3]));
				sv.setDiem2(Double.parseDouble(t[4]));
				
				
				ds.add(sv);
			}
			if(t.length == 4) {
				nhanvien nv = new nhanvien();
				nv.setMa(t[0]);
				nv.setHoten(t[1]);
				SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
				Date date = d.parse(t[2]);
				nv.setNgaysinh(date);
				nv.setHsl(Double.parseDouble(t[3]));
				
				
				ds.add(nv);
				
			}
	 }
	 b.close();
	 return ds;
 }
}
