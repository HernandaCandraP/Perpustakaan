/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;
import backend.*;
import backend.Koneksi;
import com.mysql.jdbc.Connection;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Muhammad Alfarizi
 */
public class FrmBuku extends javax.swing.JFrame {
Connection koneksi;
    /***
     * Creates new form 
     */
    public FrmBuku() {
        initComponents();
        tampilkanData();
        tampilkanCmbKategori();
        kosongkanForm();
        cmbKategori.requestFocusInWindow();
        koneksi = (Connection) Koneksi.getKoneksi("localhost","3306","root","","perpusproyek");
    }
    
    public void kosongkanForm(){
        txtIdBuku.setText("0");
        cmbKategori.setSelectedItem("");
        txtJudul.setText("");
        txtPenulis.setText("");
        txtPenerbit.setText("");
        txtTerbit.setText("");
        txtTotal.setText("");
        txtLoker.setText("");
    }
    
    public void tampilkanData(){
        String[] kolom = {"ID", "Kategori", "Judul", "Penulis", "Penerbit", "Tahun terbit", "Total", "loker"};
        ArrayList<Buku> list = new Buku().getAll();
        Object rowData[] = new Object[8];
        
        tblBuku.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for(int i =0; i<list.size(); i++){
            rowData[0] = list.get(i).getIdbuku();
            rowData[1] = list.get(i).getKategori().getNama();
            rowData[2] = list.get(i).getJudul();
            rowData[3] = list.get(i).getPenulis();
            rowData[4] = list.get(i).getPenerbit();
            rowData[5] = list.get(i).getTahun_terbit();
            rowData[6] = list.get(i).getTotal();
            rowData[7] = list.get(i).getLoker();
            
            ((DefaultTableModel)tblBuku.getModel()).addRow(rowData);
        }
    }
    
    public void cari(String keyword){
        String[] kolom = {"ID", "Kategori", "Judul", "Penulis", "Penerbit", "Tahun terbit", "Total", "loker"};
        ArrayList<Buku> list = new Buku().search(keyword);
        Object rowData[] = new Object[8];
        
        tblBuku.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        
        for(Buku buku : list){
            rowData[0] = buku.getIdbuku();
            rowData[1] = buku.getKategori().getNama();
            rowData[2] = buku.getJudul();
            rowData[3] = buku.getPenulis();
            rowData[4] = buku.getPenerbit();
            rowData[5] = buku.getTahun_terbit();
            rowData[6] = buku.getTotal();
            rowData[7] = buku.getLoker();
            
            ((DefaultTableModel)tblBuku.getModel()).addRow(rowData);
        }
    }
    
    public void tampilkanCmbKategori(){
        cmbKategori.setModel(new DefaultComboBoxModel(new Kategori().getAll().toArray()));
    }
    


    public void FrmBuku(){
        initComponents();
        tampilkanData();
        tampilkanCmbKategori();
        kosongkanForm();
    }
    
    public void simpan(){
        Buku buku = new Buku();
        buku.setIdbuku(Integer.parseInt(txtIdBuku.getText()));
        buku.setKategori((Kategori)cmbKategori.getSelectedItem());
        buku.setJudul(txtJudul.getText());
        buku.setPenulis(txtPenulis.getText());
        buku.setPenerbit(txtPenerbit.getText());
        buku.setTahun_terbit(Integer.parseInt(txtTerbit.getText()));
        buku.setTotal(Integer.parseInt(txtTotal.getText()));
        buku.setLoker(txtLoker.getText());
        buku.save();
        
        txtIdBuku.setText(Integer.toString(buku.getIdbuku()));
        tampilkanData();
    }
    public void edit(){
        DefaultTableModel model = (DefaultTableModel)tblBuku.getModel();
        int row = tblBuku.getSelectedRow();
        Buku buku = new Buku();
        
        buku = buku.getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        txtIdBuku.setText(String.valueOf(buku.getIdbuku()));
        cmbKategori.getModel().setSelectedItem(buku.getKategori());
        txtJudul.setText(buku.getJudul());
        txtPenerbit.setText(buku.getPenerbit());
        txtPenulis.setText(buku.getPenulis());
        txtTerbit.setText(String.valueOf(buku.getTahun_terbit()));
        txtTotal.setText(String.valueOf(buku.getTotal()));
        txtLoker.setText(buku.getLoker());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdBuku = new javax.swing.JTextField();
        txtJudul = new javax.swing.JTextField();
        txtPenerbit = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnTambahBaru = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBuku = new javax.swing.JTable();
        txtPenulis = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbKategori = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnRefresh2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTerbit = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtLoker = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuHome = new javax.swing.JMenuItem();
        jMenuAnggota = new javax.swing.JMenuItem();
        jMenuPetugas = new javax.swing.JMenuItem();
        jMenuBuku = new javax.swing.JMenuItem();
        jMenuKategori = new javax.swing.JMenuItem();
        jMenuPeminjaman = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        Quit = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID Buku");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Judul");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Penerbit");

        txtIdBuku.setEditable(false);
        txtIdBuku.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtIdBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdBukuActionPerformed(evt);
            }
        });

        txtJudul.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJudulActionPerformed(evt);
            }
        });
        txtJudul.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJudulKeyPressed(evt);
            }
        });

        txtPenerbit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPenerbitActionPerformed(evt);
            }
        });
        txtPenerbit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPenerbitKeyPressed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(153, 102, 255));
        btnSimpan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/gtk-save-as.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnTambahBaru.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTambahBaru.setText("Tambah Baru");
        btnTambahBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBaruActionPerformed(evt);
            }
        });

        btnCari.setBackground(new java.awt.Color(255, 255, 153));
        btnCari.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Text preview.png"))); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 102, 102));
        btnHapus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/document_delete.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        txtCari.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });

        tblBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBukuMouseClicked(evt);
            }
        });
        tblBuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblBukuKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblBuku);

        txtPenulis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPenulis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPenulisActionPerformed(evt);
            }
        });
        txtPenulis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPenulisKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Penulis");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Kategori");

        cmbKategori.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });
        cmbKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbKategoriKeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel7.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel7.setText("PERPUSTAKAAN SMA NEGERI 06 MALANG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnRefresh2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefresh2.setText("Refresh");
        btnRefresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tahun Terbit");

        txtTerbit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTerbitActionPerformed(evt);
            }
        });
        txtTerbit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTerbitKeyPressed(evt);
            }
        });

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Total");

        jLabel9.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel9.setText("Menu BUKU");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Loker");

        txtLoker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLokerKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Cetak");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        jMenuPetugas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        jMenuPetugas.setText("Petugas");
        jMenuPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPetugasActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuPetugas);

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)))
                                                .addGap(52, 52, 52))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(53, 53, 53)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtIdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTerbit)
                                            .addComponent(txtPenulis)
                                            .addComponent(txtPenerbit)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                            .addComponent(txtLoker))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnRefresh2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnHapus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCari))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambahBaru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCari)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus)
                            .addComponent(btnRefresh2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJudul, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtLoker, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSimpan)
                        .addComponent(btnTambahBaru)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdBukuActionPerformed

    private void txtJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJudulActionPerformed

    private void txtPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPenerbitActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        Buku buku = new Buku();
        if (txtJudul.getText().equals("")||txtPenulis.getText().equals("")||txtPenerbit.getText().equals("")||txtTerbit.getText().equals("")||txtTotal.getText().equals("")||txtLoker.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Field Harus Diisi Semua");
        }else{
        buku.setIdbuku(Integer.parseInt(txtIdBuku.getText()));
        buku.setKategori((Kategori)cmbKategori.getSelectedItem());
        buku.setJudul(txtJudul.getText());
        buku.setPenulis(txtPenulis.getText());
        buku.setPenerbit(txtPenerbit.getText());
        buku.setTahun_terbit(Integer.parseInt(txtTerbit.getText()));
        buku.setTotal(Integer.parseInt(txtTotal.getText()));
        buku.setLoker(txtLoker.getText());
        buku.save();
        
        txtIdBuku.setText(Integer.toString(buku.getIdbuku()));
        tampilkanData();
        }
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTambahBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBaruActionPerformed
        // TODO add your handling code here:
        kosongkanForm();
    }//GEN-LAST:event_btnTambahBaruActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cari(txtCari.getText());
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        
        
        Object options[] = {"Ya", "Tidak"};
        int result = JOptionPane.showOptionDialog(this, "Apakah anda ingin Menghapus?", "Hapus",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, options, options[1]);
        if(result == JOptionPane.YES_OPTION){
            DefaultTableModel model = (DefaultTableModel)tblBuku.getModel();
            int row = tblBuku.getSelectedRow();

            Buku buku = new Buku().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
            buku.delete();
            kosongkanForm();
            tampilkanData();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void tblBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBukuMouseClicked
         // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_tblBukuMouseClicked

    private void txtPenulisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPenulisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPenulisActionPerformed

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKategoriActionPerformed

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
        tampilkanData();
    }//GEN-LAST:event_btnRefresh2ActionPerformed

    private void txtTerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTerbitActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void tblBukuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblBukuKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            DefaultTableModel model = (DefaultTableModel)tblBuku.getModel();
            int row = tblBuku.getSelectedRow();
            edit();
            simpan();
        }
        
    }//GEN-LAST:event_tblBukuKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String reportSource = null;
        String reportDest = null;
        
        try{
            com.mysql.jdbc.Connection c = (com.mysql.jdbc.Connection) koneksi;
            reportSource = System.getProperty("user.dir") + "/laporan/reportBuku.jrxml";
            reportDest = System.getProperty("user.dir") + "/laporan/reportBuku.jasper";
            
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,c);
            JasperExportManager.exportReportToHtmlFile(jasperPrint, reportDest);
            JasperViewer.viewReport(jasperPrint,false);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbKategoriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbKategoriKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtJudul.requestFocusInWindow();
        }
    }//GEN-LAST:event_cmbKategoriKeyPressed

    private void txtJudulKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJudulKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            if (txtJudul.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Masukkan Judul");
            }else{
                txtPenerbit.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_txtJudulKeyPressed

    private void txtPenerbitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPenerbitKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            if (txtPenerbit.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Masukkan Penerbit");
            }else{
                txtPenulis.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_txtPenerbitKeyPressed

    private void txtPenulisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPenulisKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            if (txtPenulis.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Masukkan Penulis");
            }else{
                txtTerbit.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_txtPenulisKeyPressed

    private void txtTerbitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTerbitKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            String input = txtTerbit.getText();
            if (input.matches("[0-9]*")) {
                if (txtTerbit.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Masukkan Tahun Terbit");
                }else{
                     txtTotal.requestFocusInWindow();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Masukkan dengan Format Angka");                
                txtTerbit.setText("");
            }
        }
    }//GEN-LAST:event_txtTerbitKeyPressed

    private void txtTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            String input = txtTotal.getText();
            if (input.matches("[0-9]*")) {
                if (txtTotal.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Masukkan Total Buku");
                }else{
                    txtLoker.requestFocusInWindow();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Masukkan dengan Format Angka");                
                txtTotal.setText("");
            }
        }
    }//GEN-LAST:event_txtTotalKeyPressed

    private void txtLokerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLokerKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            if (txtLoker.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Masukkan Loker");
            }else{
                simpan();
            }
        }
    }//GEN-LAST:event_txtLokerKeyPressed

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
            java.util.logging.Logger.getLogger(FrmBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Edit;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh2;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahBaru;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuAnggota;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuBuku;
    private javax.swing.JMenuItem jMenuHome;
    private javax.swing.JMenuItem jMenuKategori;
    private javax.swing.JMenuItem jMenuPeminjaman;
    private javax.swing.JMenuItem jMenuPetugas;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblBuku;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdBuku;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtLoker;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtPenulis;
    private javax.swing.JTextField txtTerbit;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
