package bean;

import java.util.Date;

public class nhanvien extends nhansu {
private Double hsl;

public nhanvien(String ma,String hoten, Date ngaysinh, Double hsl) {
	super(ma,hoten, ngaysinh);
	this.hsl = hsl;
}
public nhanvien() {
	// TODO Auto-generated constructor stub
}

public Double getHsl() {
	return hsl;
}
public void setHsl(Double hsl) {
	this.hsl = hsl;
}

 public Double luong() {
	 return hsl * 1600000;
 }

public void hienthinv() {
	System.out.println(";"+hsl + ";"+ luong());
}
}
