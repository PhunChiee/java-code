package bean;

import java.util.Date;

public class nhansu {
 private String ma;
 private String hoten;
 private Date ngaysinh;
 
public nhansu() {
	super();
	// TODO Auto-generated constructor stub
}

public nhansu(String ma, String hoten, Date ngaysinh) {
	super();
	this.ma = ma;
	this.hoten = hoten;
	this.ngaysinh = ngaysinh;
}

public String getMa() {
	return ma;
}

public void setMa(String ma) {
	this.ma = ma;
}

public String getHoten() {
	return hoten;
}
public void setHoten(String hoten) {
	this.hoten = hoten;
}
public Date getNgaysinh() {
	return ngaysinh;
}
public void setNgaysinh(Date ngaysinh) {
	this.ngaysinh = ngaysinh;
}
 
public void Hienthins() {
	System.out.print(ma +";" + hoten + ";" + ngaysinh);
}
 
}
