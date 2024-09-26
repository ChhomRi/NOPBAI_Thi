package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.FileHelper;
/*
  Tác giả: Họ tên sinh viên
*/
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    //sinh viên cải đặt cho các phương thức xử lý sau
   
    public void DocKhachHang(String filename) {
        ArrayList<String> data = FileHelper.readFileText(filename);
        dsKhachHang.clear();
        for (String item : data) {
            String[] arr = item.split(";");
            KhachHang kh = new KhachHang();
            kh.setMaso(arr[0]);
            kh.setHoten(arr[1]);
            kh.setChisocu(Double.parseDouble(arr[3]));
            kh.setChisocu(Double.parseDouble(arr[4]));
            dsKhachHang.add(kh);
        }
    }

    public boolean GhiHoaDon(String filename) {
         ArrayList<String> data = new ArrayList<>();
        for (KhachHang kh : dsKhachHang) {
            String info = kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getTieuThu()+ ";" + kh.getTienTra();
            data.add(info);
        }
        return FileHelper.writeFileText(filename, data);
           
    }
   
    public void sapXepTheoLoaiHinh() {
        Comparator<KhachHang> cmp = (kh1,kh2) -> {
            return Double.compare(kh2.getLoai(), kh1.getLoai());
        };
        Collections.sort(dsKhachHang,cmp);
               
    }
    
    public double getTieuThuCaoNhat()
    {
      return 0;    
    }
    
    public double getTieuThuThapNhat()
    {
        double min = 0;
        for(KhachHang kh: dsKhachHang){
            if(kh.getTieuThu()> min)
                min = kh.getTieuThu();
        }
       return 0;  
    }
    
    public double getTieuThuTrungBinh()
    {
        double tong = 0;
        for(KhachHang kh : dsKhachHang){
            tong+= kh.getTieuThu();
        }
      return tong / dsKhachHang.size();   
    }
}