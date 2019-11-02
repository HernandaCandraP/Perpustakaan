/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;
import java.util.Date;
import backend.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Asus
 */
public class FrmPengembalian extends javax.swing.JFrame {
    int denda = 5000;
    int batas = 7; //batas maksimum peminjaman
    /**
     * Creates new form FormPeminjaman
     */
    public FrmPengembalian() {
        initComponents();
        kosongkan();
        tabelkosong();
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public void kosongkanForm(){
        this.idpeminjaman.setText("0");
        this.cariBuku.setText("");
        this.txtTotal.setText("");
        this.cariBu.setText("");
    }
    
    public void kosongkan(){
        this.idpeminjaman.setText("0");
        this.cariAnggota.setText("");
        this.cariBuku.setText("");
        this.txtTotal.setText("");
        this.tglPinjam.setDate(null);
        this.cariAng.setText("Nama Anggota");
        this.cariBu.setText("Judul Buku");
        this.tglKembali.setDate(null);
        this.txtDenda.setText("");
        this.txtHari.setText("");
    }
    
    public void tabelkosong(){
        String[] kolom = {"Id Peminjaman","Id Buku", "Buku", "Total", "Tanggal Pinjam", "Tanggal Kembali", "Denda","Petugas"};
        Object rowData[] = new Object[8];
        
        tabelData.setModel(new DefaultTableModel(new Object[][] {}, kolom));
    }
    
    public void cari(String keyword){
        String[] kolom = {"Id Peminjaman","Id Buku", "Buku", "Total", "Tanggal Pinjam", "Tanggal Kembali", "Denda","Petugas"};
        ArrayList<Peminjaman> list = new Peminjaman().search(keyword);
        Object rowData[] = new Object[8];
        
        tabelData.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for(Peminjaman A : list){
            rowData[0] = A.getIdpeminjaman();
            rowData[1] = A.getBuku().getIdbuku();
            rowData[2] = A.getBuku().getJudul();
            rowData[3] = A.getTotal();
            rowData[4] = A.getTanggalPinjam();
            rowData[5] = A.getTanggalKembali();
            rowData[6] = A.getDenda();
            rowData[7] = A.getPetugas().getNama();
            
            ((DefaultTableModel)tabelData.getModel()).addRow(rowData);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAng = new javax.swing.JButton();
        cariAng = new javax.swing.JLabel();
        cariBu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idpeminjaman = new javax.swing.JTextField();
        cariAnggota = new javax.swing.JTextField();
        cariBuku = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnRefresh2 = new javax.swing.JButton();
        btnSimpanP = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        tglPinjam = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        tglKembali = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        txtDenda = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtHari = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuHome = new javax.swing.JMenuItem();
        jMenuAnggota = new javax.swing.JMenuItem();
        jMenuBuku = new javax.swing.JMenuItem();
        jMenuKategori = new javax.swing.JMenuItem();
        jMenuPeminjaman = new javax.swing.JMenuItem();
        jMenuPetugas = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        Quit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAng.setBackground(new java.awt.Color(255, 255, 153));
        btnAng.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Text preview.png"))); // NOI18N
        btnAng.setText("Cari");
        btnAng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAngActionPerformed(evt);
            }
        });

        cariAng.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cariAng.setText("Nama Anggota");

        cariBu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cariBu.setText("Judul Buku");

        tabelData.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tabelData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelData);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID Peminjaman");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("ID Anggota");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("ID Buku");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tanggal Pinjam");

        idpeminjaman.setEditable(false);
        idpeminjaman.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cariAnggota.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cariAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariAnggotaActionPerformed(evt);
            }
        });

        cariBuku.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnHapus.setBackground(new java.awt.Color(255, 102, 102));
        btnHapus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/document_delete.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel6.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel6.setText("PERPUSTAKAAN SMa NEGERI 06 MALANG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel6)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        btnRefresh2.setBackground(new java.awt.Color(153, 255, 153));
        btnRefresh2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefresh2.setText("Refresh");
        btnRefresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh2ActionPerformed(evt);
            }
        });

        btnSimpanP.setBackground(new java.awt.Color(153, 102, 255));
        btnSimpanP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSimpanP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/gtk-save-as.png"))); // NOI18N
        btnSimpanP.setText("Simpan Pengembalian");
        btnSimpanP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Total Buku");

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel12.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel12.setText("Pengembalian Buku");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tanggal Kembali");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Denda");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Keterangan");

        jMenuBar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(102, 102, 255), null, new java.awt.Color(153, 0, 255)));

        jMenu1.setText("Menu");

        jMenuHome.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        jMenuHome.setText("Home");
        jMenuHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHomeActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuHome);

        jMenuAnggota.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuAnggota.setText("Anggota");
        jMenuAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAnggotaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuAnggota);

        jMenuBuku.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        jMenuBuku.setText("Buku");
        jMenuBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBukuActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuBuku);

        jMenuKategori.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_MASK));
        jMenuKategori.setText("Kategori");
        jMenuKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuKategoriActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuKategori);

        jMenuPeminjaman.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuPeminjaman.setText("Peminjaman");
        jMenuPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPeminjamanActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuPeminjaman);

        jMenuPetugas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        jMenuPetugas.setText("Petugas");
        jMenuPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPetugasActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuPetugas);

        jMenuBar2.add(jMenu1);

        Edit.setText("Aksi");

        Quit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        Quit.setText("Quit");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        Edit.add(Quit);

        jMenuBar2.add(Edit);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnHapus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSimpanP))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel11))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(idpeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnRefresh2))
                                    .addComponent(jLabel12)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cariAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cariBu)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAng)
                                                .addGap(18, 18, 18)
                                                .addComponent(cariAng)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(tglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDenda, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHari, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idpeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(btnRefresh2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cariAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btnAng)
                            .addComponent(cariAng))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cariBu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(tglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(103, 103, 103)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(tglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtDenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanP)
                    .addComponent(btnHapus))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAngActionPerformed
        // TODO add your handling code here:
        Peminjaman pem = new Peminjaman();
        pem.cariAnggota(Integer.parseInt(this.cariAnggota.getText()));
        this.cariAng.setText((pem.getAng().getNama()));
        
        cari(cariAnggota.getText());
        
        this.idpeminjaman.setText("0");
        this.cariBuku.setText("");
        this.txtTotal.setText("");
        this.tglPinjam.setDate(null);
    }//GEN-LAST:event_btnAngActionPerformed

    private void tabelDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)this.tabelData.getModel();
        int row = this.tabelData.getSelectedRow();

        Peminjaman pem = new Peminjaman().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        int hari = pem.getDenda()/denda;
        idpeminjaman.setText(String.valueOf(pem.getIdpeminjaman()));
        cariAnggota.setText(String.valueOf(pem.getIdanggota()));
        cariBuku.setText(String.valueOf(pem.getIdbuku()));
        cariBu.setText(String.valueOf(pem.getBuku().getJudul()));;
        String date = pem.getTanggalPinjam();
        
        String dateP = pem.getTanggalKembali();
        
        txtTotal.setText(String.valueOf(pem.getTotal()));
        if (date != null) {
            java.util.Date date2;
            try {
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                tglPinjam.setDate(date2);
            } catch (ParseException ex) {
                Logger.getLogger(FrmPengembalian.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }else{
            tglPinjam.setDate(null);
        }
        
        if (dateP != null) {
            java.util.Date date2P;
            try {
                date2P = new SimpleDateFormat("yyyy-MM-dd").parse(dateP);
                tglKembali.setDate(date2P);
            } catch (ParseException ex) {
                Logger.getLogger(FrmPeminjaman.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            tglKembali.setDate(null);
        }
        
        txtDenda.setText(String.valueOf(pem.getDenda()));

        if(hari != 0){
            txtHari.setText("Waktu Pengembalian buku lebih dari "+String.valueOf(hari)+ " hari");
        }else{
            txtHari.setText("Pengembalian buku tepat waktu");
        }
        if (tglKembali.getCalendar() == null) {
            txtHari.setText("Buku belum dikembaikan");
        }       
    }//GEN-LAST:event_tabelDataMouseClicked

    private void cariAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariAnggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariAnggotaActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)this.tabelData.getModel();
        int row = this.tabelData.getSelectedRow();

        Peminjaman pem = new Peminjaman().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        pem.delete();
        cari(cariAnggota.getText());
        kosongkanForm();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jMenuAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAnggotaActionPerformed
        // TODO add your handling code here:
        new FrmAnggota().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuAnggotaActionPerformed

    private void jMenuBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBukuActionPerformed
        // TODO add your handling code here:
        new FrmBuku().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuBukuActionPerformed

    private void jMenuKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuKategoriActionPerformed
        // TODO add your handling code here
        new FrmKategori().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuKategoriActionPerformed

    private void jMenuPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPeminjamanActionPerformed
        // TODO add your handling code here:
        new FrmPeminjaman().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuPeminjamanActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:
        Object options[] = {"Ya", "Tidak"};
        int result = JOptionPane.showOptionDialog(this, "Apakah anda ingin keluar?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, options, options[1]);
        if(result == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_QuitActionPerformed

    private void jMenuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHomeActionPerformed
        // TODO add your handling code here:
        new FrmMenuAwal().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuHomeActionPerformed

    private void jMenuPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPetugasActionPerformed
        // TODO add your handling code here:
        new FrmPetugas().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuPetugasActionPerformed

    private void btnRefresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh2ActionPerformed
        // TODO add your handling code here:
        kosongkan();
        tabelkosong();
    }//GEN-LAST:event_btnRefresh2ActionPerformed

    private void btnSimpanPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPActionPerformed
        // TODO add your handling code here:   
        try {
            String satu = sdf.format(this.tglPinjam.getDate());
            String dua= sdf.format(this.tglKembali.getDate());

            Date awal = (Date) sdf.parse(satu);
            Date akhir = (Date) sdf.parse(dua);
            System.out.println(akhir);
            
            long bedaHari = Math.abs(akhir.getTime() - awal.getTime());
            txtDenda.setText((TimeUnit.MILLISECONDS.toDays(bedaHari)-batas)*denda +"");
            System.out.println(txtDenda.getText());
            
            
            Peminjaman pem = new Peminjaman().getById(Integer.parseInt(this.idpeminjaman.getText()));
            pem.setAng(new Anggota().getById(Integer.parseInt(this.cariAnggota.getText())));
            
            pem.setTanggalPinjam(sdf.format(this.tglPinjam.getDate()));
            pem.setTanggalKembali(sdf.format(this.tglKembali.getDate()));
            pem.setDenda(Integer.parseInt(this.txtDenda.getText()));
            pem.setTotal(Integer.parseInt(this.txtTotal.getText()));
           
            int test = Integer.parseInt(txtDenda.getText());
            if(test/denda > 0){
                txtHari.setText("Waktu Pengembalian buku lebih dari " + (TimeUnit.MILLISECONDS.toDays(bedaHari)-batas) + " hari");
                pem.setDenda(test);
            } else{
                txtDenda.setText("0");
                txtHari.setText("Pengembalian buku tepat waktu");
                pem.setDenda(0);
            }
            
            Buku bk = new Buku().getById(Integer.parseInt(this.cariBuku.getText()));
            
            bk.setTotal(bk.getTotal()+ pem.getTotal());
            bk.save();
            System.out.println("total: "+ bk.getTotal());
        
            pem.save();
            cari(cariAnggota.getText());
        } catch (ParseException ex) {        
            System.out.println(ex);
        }
        kosongkan();
        tabelkosong();
    }//GEN-LAST:event_btnSimpanPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Edit;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JButton btnAng;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh2;
    private javax.swing.JButton btnSimpanP;
    private javax.swing.JLabel cariAng;
    private javax.swing.JTextField cariAnggota;
    private javax.swing.JLabel cariBu;
    private javax.swing.JTextField cariBuku;
    private javax.swing.JTextField idpeminjaman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuAnggota;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuBuku;
    private javax.swing.JMenuItem jMenuHome;
    private javax.swing.JMenuItem jMenuKategori;
    private javax.swing.JMenuItem jMenuPeminjaman;
    private javax.swing.JMenuItem jMenuPetugas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelData;
    private com.toedter.calendar.JDateChooser tglKembali;
    private com.toedter.calendar.JDateChooser tglPinjam;
    private javax.swing.JTextField txtDenda;
    private javax.swing.JTextField txtHari;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}