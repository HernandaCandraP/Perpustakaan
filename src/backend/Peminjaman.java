/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Peminjaman {
    private int idpeminjaman, idanggota, idpetugas;
    private Anggota ang = new Anggota();
    private Petugas petugas = new Petugas();
    private String tanggalPinjam;
    private String tanggalKembali;
    private int denda, total;
    
    public Peminjaman(){
        
    }
    
    public Peminjaman(Anggota ang, Petugas petugas, String tanggalPinjam, String tanggalKembali, int denda, int total, int idpetugas){
        this.ang = ang;
        this.petugas = petugas;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.denda = denda;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIdpeminjaman() {
        return idpeminjaman;
    }

    public void setIdpeminjaman(int idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    public int getIdanggota() {
        return idanggota;
    }

    public void setIdanggota(int idanggota) {
        this.idanggota = idanggota;
    }

    public Anggota getAng() {
        return ang;
    }

    public void setAng(Anggota ang) {
        this.ang = ang;
    }

    public Petugas getPetugas() {
        return petugas;
    }

    public void setPetugas(Petugas petugas) {
        this.petugas = petugas;
    } 

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public int getIdpetugas() {
        return idpetugas;
    }

    public void setIdpetugas(int idpetugas) {
        this.idpetugas = idpetugas;
    }

    
    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public int getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }
    
    
    public Peminjaman getById(int id){
        Peminjaman pem = new Peminjaman();
        ResultSet rs = DBHelper.selectQuery("Select "
                + "p.idpeminjaman as idpeminjaman, "
                + "p.tanggalpinjam as tanggalpinjam, "
                + "p.tanggalkembali as tanggalkembali, "
                + "p.denda as denda, "
                + "a.idanggota as idanggota, "
                + "b.idpetugas as idpetugas "
                + "from peminjaman p left join anggota a on p.idanggota = a.idanggota "
                + "left join petugas b on p.idpetugas = b.idpetugas where p.idpeminjaman = '" + id + "'");
        try{
            while(rs.next()){
                pem = new Peminjaman();
                pem.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pem.setIdanggota(rs.getInt("idanggota"));
                pem.setIdpetugas(rs.getInt("idpetugas"));
                pem.setTanggalPinjam(rs.getString("tanggalpinjam"));
                pem.setTanggalKembali(rs.getString("tanggalkembali"));
                pem.setDenda(rs.getInt("denda"));
                pem.setAng(new Anggota().getById(pem.getIdanggota()));
                pem.setPetugas(new Petugas().getById(pem.getIdpetugas()));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return pem;
    }
    
    public ArrayList<Peminjaman> getAll(){
        ArrayList<Peminjaman> ListPinjam = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("Select "
                + "p.idpeminjaman as idpeminjaman, "
                + "p.tanggalpinjam as tanggalpinjam, "
                + "p.tanggalkembali as tanggalkembali, "
                + "p.denda as denda, "
                + "a.idanggota as idanggota, "
                + "b.idpetugas as idpetugas "
                + "from peminjaman p left join anggota a on p.idanggota = a.idanggota "
                + "left join petugas b on p.idpetugas = b.idpetugas");
        try{
            while(rs.next()){
                Peminjaman pem = new Peminjaman();
                pem.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pem.setIdanggota(rs.getInt("idanggota"));
                pem.setIdpetugas(rs.getInt("idpetugas"));
                pem.setTanggalPinjam(rs.getString("tanggalpinjam"));
                pem.setTanggalKembali(rs.getString("tanggalkembali"));
                pem.setDenda(rs.getInt("denda"));
                pem.setAng(new Anggota().getById(pem.getIdanggota()));
                pem.setPetugas(new Petugas().getById(pem.getIdpetugas()));
                
                ListPinjam.add(pem);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ListPinjam;
    }
    
    public void save(){
        if(getById(idpeminjaman).getIdpeminjaman()== 0){
            String sql = "Insert into peminjaman (idanggota, idpetugas, tanggalpinjam, tanggalkembali, denda) "
                    + "values ("
                    + "'" + this.getAng().getIdAnggota() + "', "
                    + "'" + this.getPetugas().getIdPetugas()+ "', "
                    + "'" + this.tanggalPinjam + "', "
                    + "'" +this.tanggalKembali + "', "
                    + "" +this.denda + " "
                    + ")";
            this.idpeminjaman = DBHelper.insertQueryGetId(sql);
        }else{
            String sql = "Update peminjaman set "
                    + " idanggota = '" + this.getAng().getIdAnggota() + "', "
                    + " idpetugas = '" + this.getPetugas().getIdPetugas() + "', "
                    + " tanggalpinjam = '" + this.tanggalPinjam + "', "
                    + " tanggalkembali = '" + this.tanggalKembali + "',"
                    + " denda = " + this.denda + ""
                    + " WHERE idpeminjaman = "+this.idpeminjaman+"";
            DBHelper.executeQuery(sql);
        }
    }
    
    public void saveP(){
        if(getById(idpeminjaman).getIdpeminjaman()== 0){
            String sql = "Insert into peminjaman (idanggota, idpetugas, tanggalpinjam) "
                    + "values ("
                    + "'" + this.getAng().getIdAnggota() + "', "
                    + "'" + this.getPetugas().getIdPetugas()+ "', "
                    + "'" + this.tanggalPinjam + "' "
                    + ");";
            this.idpeminjaman = DBHelper.insertQueryGetId(sql);
            System.out.println(sql);
        }else{
            String sql = "Update peminjaman set "
                    + " idanggota = '" + this.getAng().getIdAnggota() + "', "
                    + " idpetugas = '" + this.getPetugas().getIdPetugas() + "', "
                    + " tanggalpinjam = '" + this.tanggalPinjam + "' "
                    + " WHERE idpeminjaman = "+this.idpeminjaman+"";
            DBHelper.executeQuery(sql);
        }
        
    }
    
    public void cariAnggota(int id){
        ResultSet rs = DBHelper.selectQuery("Select * from anggota where idanggota = '" + id + "'");
        try{
            while(rs.next()){
                getAng().setIdAnggota(rs.getInt("idanggota"));
                getAng().setNama(rs.getString("nama"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void cariPetugas(int id){
        ResultSet rs = DBHelper.selectQuery("Select * from petugas where idpetugas = '" + id + "'");
        try{
            while(rs.next()){
                getPetugas().setIdPetugas(rs.getInt("idpetugas"));
                getPetugas().setNama(rs.getString("nama"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void delete(){
        String sql = "Delete from peminjaman where idpeminjaman = '" + this.idpeminjaman + "'";
        DBHelper.executeQuery(sql);
    }
}
