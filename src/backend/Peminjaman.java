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
    private int idpeminjaman, idanggota, idbuku, idpetugas;
    private Anggota ang = new Anggota();
    private Buku buku = new Buku();
    private Petugas petugas = new Petugas();
    private String tanggalPinjam;
    private String tanggalKembali;
    private int denda, total;
    
    public Peminjaman(){
        
    }
    
    public Peminjaman(Anggota ang, Buku buku, String tanggalPinjam, String tanggalKembali, int denda, int total, Petugas petugas){
        this.ang = ang;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.denda = denda;
        this.total = total;
        this.petugas = petugas;
    }

    public Petugas getPetugas() {
        return petugas;
    }

    public void setPetugas(Petugas petugas) {
        this.petugas = petugas;
    }

    public int getIdpetugas() {
        return idpetugas;
    }

    public void setIdpetugas(int idpetugas) {
        this.idpetugas = idpetugas;
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

    public int getIdbuku() {
        return idbuku;
    }

    public void setIdbuku(int idbuku) {
        this.idbuku = idbuku;
    }

    public Anggota getAng() {
        return ang;
    }

    public void setAng(Anggota ang) {
        this.ang = ang;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
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
                + "p.total AS total, "
                + "a.idanggota as idanggota, "
                + "b.idbuku as idbuku, "
                + "pg.idpetugas as idpetugas "
                + "from peminjaman p left join anggota a on p.idanggota = a.idanggota "
                + "left join buku b on p.idbuku = b.idbuku "
                + "left join petugas pg on p.idpetugas = pg.idpetugas where p.idpeminjaman = '" + id + "'");
        try{
            while(rs.next()){
                pem = new Peminjaman();
                pem.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pem.setIdanggota(rs.getInt("idanggota"));
                pem.setIdbuku(rs.getInt("idbuku"));
                pem.setTanggalPinjam(rs.getString("tanggalpinjam"));
                pem.setTanggalKembali(rs.getString("tanggalkembali"));
                pem.setDenda(rs.getInt("denda"));
                pem.setTotal(rs.getInt("total"));
                pem.setIdpetugas(rs.getInt("idpetugas"));
                pem.setPetugas(new Petugas().getById(pem.getIdpetugas()));
                pem.setAng(new Anggota().getById(pem.getIdanggota()));
                pem.setBuku(new Buku().getById(pem.getIdbuku()));
                
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
                + "p.total AS total, "
                + "a.idanggota as idanggota, "
                + "b.idbuku as idbuku, "
                + "pg.idpetugas as idpetugas "
                + "from peminjaman p left join anggota a on p.idanggota = a.idanggota "
                + "left join buku b on p.idbuku = b.idbuku "
                + "left join petugas pg on p.idpetugas = pg.idpetugas");
        try{
            while(rs.next()){
                Peminjaman pem = new Peminjaman();
                pem.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pem.setIdanggota(rs.getInt("idanggota"));
                pem.setIdbuku(rs.getInt("idbuku"));
                pem.setTanggalPinjam(rs.getString("tanggalpinjam"));
                pem.setTanggalKembali(rs.getString("tanggalkembali"));
                pem.setDenda(rs.getInt("denda"));
                pem.setTotal(rs.getInt("total"));
                pem.setIdpetugas(rs.getInt("idpetugas"));
                pem.setAng(new Anggota().getById(pem.getIdanggota()));
                pem.setBuku(new Buku().getById(pem.getIdbuku()));
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
            String sql = "Insert into peminjaman (idanggota, idbuku, tanggalpinjam, tanggalkembali, denda, idpetugas) "
                    + "values ("
                    + "'" + this.getAng().getIdAnggota() + "', "
                    + "'" + this.getBuku().getIdbuku()+ "', "
                    + "'" + this.tanggalPinjam + "', "
                    + "'" +this.tanggalKembali + "', "
                    + "" +this.denda + ", "
                    + "'" +this.getPetugas().getIdPetugas() + "' "
                    + ")";
            this.idpeminjaman = DBHelper.insertQueryGetId(sql);
        }else{
            String sql = "Update peminjaman set "
                    + " idanggota = '" + this.getAng().getIdAnggota() + "', "
                    + " idbuku = '" + this.getBuku().getIdbuku() + "', "
                    + " tanggalpinjam = '" + this.tanggalPinjam + "', "
                    + " tanggalkembali = '" + this.tanggalKembali + "',"
                    + " denda = " + this.denda + ", "
                    + " idpetugas = " + this.getPetugas().getIdPetugas() + " "
                    + " WHERE idpeminjaman = "+this.idpeminjaman+"";
            DBHelper.executeQuery(sql);
        }
    }
    
    public void saveP(){
        if(getById(idpeminjaman).getIdpeminjaman()== 0){
            String sql = "Insert into peminjaman (idanggota, idbuku, tanggalpinjam, total, idpetugas) "
                    + "values ("
                    + "'" + this.getAng().getIdAnggota() + "', "
                    + "'" + this.getBuku().getIdbuku()+ "', "
                    + "'" + this.tanggalPinjam + "', "
                    + " " + this.total + ", "
                    + " " + this.getPetugas().getIdPetugas() + " "
                    + ");";
            this.idpeminjaman = DBHelper.insertQueryGetId(sql);
            System.out.println(sql);
        }else{
            String sql = "Update peminjaman set "
                    + " idanggota = '" + this.getAng().getIdAnggota() + "', "
                    + " idbuku = '" + this.getBuku().getIdbuku() + "', "
                    + " tanggalpinjam = '" + this.tanggalPinjam + "', "
                    + " total = " + this.total + ", "
                    + " idpetugas = '" +this.getPetugas().getIdPetugas() + "' "
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
    
    public void cariBuku(int id){
        ResultSet rs = DBHelper.selectQuery("Select * from buku where idbuku = '" + id + "'");
        try{
            while(rs.next()){
                getBuku().setIdbuku(rs.getInt("idbuku"));
                getBuku().setJudul(rs.getString("judul"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void cariPetugas(int id){
        ResultSet rs = DBHelper.selectQuery("Select * from Petugas where idpetugas = '" + id + "'");
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
    
    public ArrayList<Peminjaman> search(String keyword){
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("Select "
                + "p.idpeminjaman as idpeminjaman, "
                + "p.tanggalpinjam as tanggalpinjam, "
                + "p.tanggalkembali as tanggalkembali, "
                + "p.denda as denda, "
                + "p.total AS total, "
                + "a.idanggota as idanggota, "
                + "a.nama as nama, "
                + "b.idbuku as idbuku, "
                + "b.judul AS judul, "
                + "pg.idpetugas as idpetugas, "
                + "pg.nama as namaP "
                + "from peminjaman p left join anggota a on p.idanggota = a.idanggota "
                + "left join buku b on p.idbuku = b.idbuku "
                + "left join petugas pg on p.idpetugas = pg.idpetugas "
                + "WHERE a.idanggota LIKE '%" +keyword+ "%' ");
        
        try{
            while(rs.next()){
                Peminjaman kat = new Peminjaman();
                kat.setIdpeminjaman(rs.getInt("idpeminjaman"));
                kat.getAng().setNama(rs.getString("nama"));
                kat.getAng().setIdAnggota(rs.getInt("idanggota"));
                kat.getBuku().setJudul(rs.getString("judul"));
                kat.getBuku().setIdbuku(rs.getInt("idbuku"));
                kat.setTanggalPinjam(rs.getString("tanggalpinjam"));
                kat.setTanggalKembali(rs.getString("tanggalkembali"));
                kat.setDenda(rs.getInt("denda"));
                kat.setTotal(rs.getInt("total"));
                kat.getPetugas().setNama(rs.getString("namaP"));
                
                ListPeminjaman.add(kat);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ListPeminjaman;
    }
}