package model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table
@Entity
public class GiaoVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Date ngaySinh;
	@Column(nullable = false, length=50)
	private String hoTen;
	@Column(nullable = false, length=50)
	private String nguoiTao;
	@Column(nullable = false, length=50)
	
	private String nguoiSuaCuoi;
	@Column(nullable = false, length=50)
	private String moTa;
	@Column(nullable = false, length=50)
	private String chuyenNganh;
	@Column
	private Float canNang;
	
	@Column
	private LocalDate ngayTao;
	@Column
	private LocalDate ngaySuaCuoi;
	@Column
	private Boolean tinhTrangXoa;
	@Column
	private Boolean gioiTinh;
	
	public GiaoVien() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTeni) {
		this.hoTen = hoTeni;
	}
	public String getNguoiTao() {
		return nguoiTao;
	}
	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}
	public String getNguoiSuaCuoi() {
		return nguoiSuaCuoi;
	}
	public void setNguoiSuaCuoi(String nguoiSuaCuoi) {
		this.nguoiSuaCuoi = nguoiSuaCuoi;
	}

	public LocalDate getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(LocalDate ngayTao) {
		this.ngayTao = ngayTao;
	}
	public LocalDate getNgaySuaCuoi() {
		return ngaySuaCuoi;
	}
	public void setNgaySuaCuoi(LocalDate ngaySuaCuoi) {
		this.ngaySuaCuoi = ngaySuaCuoi;
	}
	public Boolean getTinhTrangXoa() {
		return tinhTrangXoa;
	}
	public void setTinhTrangXoa(Boolean tinhTrangXoa) {
		this.tinhTrangXoa = tinhTrangXoa;
	}
	public Boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getChuyenNganh() {
		return chuyenNganh;
	}
	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
	public Float getCanNang() {
		return canNang;
	}
	public void setCanNang(Float canNang) {
		this.canNang = canNang;
	}
	@Override
	public String toString() {
		return "GiaoVien [id=" + id + ", ngaySinh=" + ngaySinh + ", hoTen=" + hoTen + ", nguoiTao=" + nguoiTao
				+ ", nguoiSuaCuoi=" + nguoiSuaCuoi + ", moTa=" + moTa + ", chuyenNganh=" + chuyenNganh + ", canNang="
				+ canNang + ", ngayTao=" + ngayTao + ", ngaySuaCuoi=" + ngaySuaCuoi + ", tinhTrangXoa=" + tinhTrangXoa
				+ ", gioiTinh=" + gioiTinh + "]";
	}

	
	
	
	
	

}
