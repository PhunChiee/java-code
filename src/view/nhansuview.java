package view;

import java.util.ArrayList;

import bean.nhansu;
import bo.nhansubo;
import dao.nhansudao;

public class nhansuview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nhansudao nvdao = new nhansudao();
		nhansubo nvbo = new nhansubo();
		try {
			ArrayList<nhansu> ds = nvdao.getns();
			nvbo.Hienthi();
			nvbo.Ghi();
			nvbo.Tim();
			System.out.println(nvbo.Tongluong());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
