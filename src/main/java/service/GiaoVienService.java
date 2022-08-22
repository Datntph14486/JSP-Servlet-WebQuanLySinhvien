package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.GiaoVien;
import model.Userr;
import respository.GiaoVienRespository;
import utility.HibernateUtil;

public class GiaoVienService {
	private GiaoVienRespository giaoVienRespository = new GiaoVienRespository();
	public static void add(GiaoVien giaoVien) {
		GiaoVienRespository.add(giaoVien);
	}

	public static List<GiaoVien> readAll() {

		List<GiaoVien> giaviens = GiaoVienRespository.getAll();

		return giaviens;
	}

	public static GiaoVien getById(long i) {
		GiaoVien giaoVien = GiaoVienRespository.getByid(i);
		return giaoVien;
	}
	public static List<GiaoVien> getDeleted(){
		List<GiaoVien> giaviens = GiaoVienRespository.getDeleted();

		return giaviens;
	}
	public static List<GiaoVien> getDelete(){
		List<GiaoVien> giaviens = GiaoVienRespository.getDelete();

		return giaviens;
	}
	public static void update(GiaoVien giaoVien) {
		GiaoVienRespository.update(giaoVien);
	}
	public static List<GiaoVien> find(String ten, String cannang, String tinhtrang){
	List<GiaoVien> giaoViens=	GiaoVienRespository.find(tinhtrang, ten, cannang);
	return giaoViens;
	}
	
}
