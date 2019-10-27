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
public class Transaksi {
    private int idtransaksi, idpeminjaman, idbuku, totalbuku;
    private Peminjaman pem = new Peminjaman();
    private Buku bk = new Buku();
    private int total;
    
    public Transaksi(){
        
    }

    public Transaksi(int idtransaksi, int idpeminjaman, int idbuku, int totalbuku) {
        this.idtransaksi = idtransaksi;
        this.idpeminjaman = idpeminjaman;
        this.idbuku = idbuku;
        this.totalbuku = totalbuku;
    }

    public int getIdtransaksi() {
        return idtransaksi;
    }

    public void setIdtransaksi(int idtransaksi) {
        this.idtransaksi = idtransaksi;
    }

    public int getIdpeminjaman() {
        return idpeminjaman;
    }

    public void setIdpeminjaman(int idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    public int getIdbuku() {
        return idbuku;
    }

    public void setIdbuku(int idbuku) {
        this.idbuku = idbuku;
    }

    public int getTotalbuku() {
        return totalbuku;
    }

    public void setTotalbuku(int totalbuku) {
        this.totalbuku = totalbuku;
    }

    public Peminjaman getPem() {
        return pem;
    }

    public void setPem(Peminjaman pem) {
        this.pem = pem;
    }

    public Buku getBk() {
        return bk;
    }

    public void setBk(Buku bk) {
        this.bk = bk;
    }
        
    public Transaksi getById(int id){
        Transaksi pem = new Transaksi();
        ResultSet rs = DBHelper.selectQuery("Select "
                + "p.idtransaksi as idtransaksi, "
                + "p.idpeminjaman as idpeminjaman, "
                + "p.idbuku as idbuku, "
                + "p.totalbuku as totalbuku "
                + "from transaksi p left join peminjaman a on p.idpeminjaman = a.idpeminjaman "
                + "left join buku b on p.idbuku = b.idbuku where p.idtransaksi = '" + id + "'");
        try{
            while(rs.next()){
                pem = new Transaksi();
                pem.setIdtransaksi(rs.getInt("idtransaksi"));
                pem.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pem.setIdbuku(rs.getInt("idbuku"));
                pem.setTotalbuku(rs.getInt("totalbuku"));
                pem.setPem(new Peminjaman().getById(pem.getIdpeminjaman()));
                pem.setBk(new Buku().getById(pem.getIdbuku()));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return pem;
    }
    
    public ArrayList<Transaksi> getAll(){
        ArrayList<Transaksi> ListTransaksi = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("Select "
                + "p.idtransaksi as idtransaksi, "
                + "p.idpeminjaman as idpeminjaman, "
                + "p.idbuku as idbuku, "
                + "p.totalbuku as totalbuku "
                + "from transaksi p left join peminjaman a on p.idpeminjaman = a.idpeminjaman "
                + "left join buku b on p.idbuku = b.idbuku");
        try{
            while(rs.next()){
                Transaksi pem = new Transaksi();        
                pem.setIdtransaksi(rs.getInt("idtransaksi"));
                pem.setIdpeminjaman(rs.getInt("idpeminjaman"));
                pem.setIdbuku(rs.getInt("idbuku"));
                pem.setTotalbuku(rs.getInt("totalbuku"));
                pem.setPem(new Peminjaman().getById(pem.getIdpeminjaman()));
                pem.setBk(new Buku().getById(pem.getIdbuku()));
                
                ListTransaksi.add(pem);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ListTransaksi;
    }
    
    public void save(){
        if(getById(idtransaksi).getIdtransaksi()== 0){
            String sql = "Insert into transaksi (idpeminjaman, idbuku, totalbuku) "
                    + "values ("
                    + "'" + this.getPem().getIdpeminjaman()+ "', "
                    + "'" + this.getBk().getIdbuku()+ "', "
                    + "" +this.totalbuku + " "
                    + ")";
            this.idtransaksi = DBHelper.insertQueryGetId(sql);
        }else{
            String sql = "Update transaksi set "
                    + " idpeminjaman = '" + this.getPem().getIdpeminjaman()+ "', "
                    + " idbuku = '" + this.getBk().getIdbuku()+ "', "
                    + " totalbuku = " + this.totalbuku + ""
                    + " WHERE idtransaksi = "+this.idtransaksi+"";
            DBHelper.executeQuery(sql);
        }
    }
    
    public void cariBuku(int id){
        ResultSet rs = DBHelper.selectQuery("Select * from buku where idbuku = '" + id + "'");
        try{
            while(rs.next()){
                getBk().setIdbuku(rs.getInt("idbuku"));
                getBk().setJudul(rs.getString("judul"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void cariPeminjaman(int id){
        ResultSet rs = DBHelper.selectQuery("Select * from peminjaman where idpeminjaman = '" + id + "'");
        try{
            while(rs.next()){
                getPem().setIdpeminjaman(rs.getInt("idpeminjaman"));
                getPem().setIdanggota(rs.getInt("idanggota"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void delete(){
        String sql = "Delete from transaksi where idtransaksi = '" + this.idtransaksi + "'";
        DBHelper.executeQuery(sql);
    }
}
