package bean;

import java.util.Date;

public class sinhvien extends nhansu {
private Double diem1;
private Double diem2;
public sinhvien(String ma,String hoten, Date ngaysinh, Double diem1, Double diem2) {
	super(ma,hoten,ngaysinh);
	this.diem1 = diem1;
	this.diem2 = diem2;
}

public sinhvien() {
	// TODO Auto-generated constructor stub
}

public Double getDiem1() {
	return diem1;
}
public void setDiem1(Double diem1) {
	this.diem1 = diem1;
}
public Double getDiem2() {
	return diem2;
}
public void setDiem2(Double diem2) {
	this.diem2 = diem2;
}

public Double Dtb() {
	return (diem1 + diem2)/2;
}
public void hienthisv() {
	System.out.println(";" + diem1 +";" + diem2+";"+ Dtb());
}
}
