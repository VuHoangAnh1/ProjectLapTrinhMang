package socket;

import Models.ThongTinND;
import Models.IP;
import Models.Check;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DoanNhatNam
 */
public class frmAdmin extends javax.swing.JFrame {

    //private DefaultTableModel dtm;

    public frmAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        //showuser();
    }
    public boolean kiemtrathongtin() {
        Check c = new Check();
        if (!c.checkID(MaSV1.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập mã SV sai...yêu cầu nhập đúng 10 ký tự  ", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            MaSV1.setText("");
            MaSV1.requestFocus();
            return false;
        } else if (!c.check_hoten(TenSV.getText()) || !c.checkSpace(TenSV.getText())) {
            //else if (!c.checkSpace(TenSV1.getText()) || !c.check(TenSV1.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn nhập tên sinh viên chua dung... yeu cau nhap tu 5->20 ky tu..", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            TenSV.setText("");
            TenSV.requestFocus();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        thongbao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MaSV1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TenSV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        MonHoc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        DIem1 = new javax.swing.JComboBox();
        them = new javax.swing.JButton();
        sua = new javax.swing.JButton();
        nut_xoa_ = new javax.swing.JButton();
        lammoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ban = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("đoàn cư");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jPanel7.setLayout(new java.awt.GridLayout(0, 3));
        jPanel7.add(thongbao);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/system.png"))); // NOI18N
        jLabel2.setText("Mã Sinh Viên");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/graduated-icon (1).png"))); // NOI18N
        jLabel3.setText("Tên Sinh viên");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/calculate.png"))); // NOI18N
        jLabel4.setText("Môn Học");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/calculate.png"))); // NOI18N
        jLabel6.setText("Điểm Sinh Viên");

        DIem1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        DIem1.setLightWeightPopupEnabled(false);

        them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/ListMenuPatient1.png"))); // NOI18N
        them.setText("Thêm ");
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });

        sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/bill.png"))); // NOI18N
        sua.setText("Sửa");
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaActionPerformed(evt);
            }
        });

        nut_xoa_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/Remove.png"))); // NOI18N
        nut_xoa_.setText("xóa");
        nut_xoa_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nut_xoa_ActionPerformed(evt);
            }
        });

        lammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/reset.png"))); // NOI18N
        lammoi.setText("Clear");
        lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lammoiActionPerformed(evt);
            }
        });

        ban.setBorder(new javax.swing.border.MatteBorder(null));
        ban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sinh Viên", "Tên Sinh Viên", "Môn Học", "Điểm"
            }
        ));
        ban.setRowHeight(30);
        ban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                banMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ban);

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/Search-icon.png"))); // NOI18N
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("QUẢN LÝ ĐIỂM SINH VIÊN");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jMenu1.setText("Thông Tin");

        jMenuItem1.setText("Thông tin người dùng");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Đổi mật khẩu");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Đăng xuất");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Thoát");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TenSV, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MaSV1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nut_xoa_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(DIem1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(41, 41, 41)
                                        .addComponent(MonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(sua, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(299, 299, 299)
                                .addComponent(lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(them)
                            .addComponent(MaSV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nut_xoa_))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sua)
                            .addComponent(jLabel4)
                            .addComponent(MonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lammoi)
                            .addComponent(DIem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(51, 51, 51)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void banMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_banMouseClicked
        int row = ban.getSelectedRow();
        if (row != -1) {
            String id = ban.getValueAt(row, 0).toString();
            MaSV1.setText(id);
            TenSV.setText(ban.getValueAt(row, 1).toString());
            DIem1.setSelectedItem(ban.getValueAt(row, 2).toString());
            MonHoc.setText(ban.getValueAt(row, 3).toString());
        }

    }//GEN-LAST:event_banMouseClicked

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
        // TODO add your handling code here:
        if (!kiemtrathongtin()) {
            return;
        }
        //kiem tra masv ten sv khong dc rong
        if (!MaSV1.getText().trim().equals("") && !TenSV.getText().trim().equals("")) {
            //DefaultTableModel model = (DefaultTableModel) ban.getModel();//xuat ra tabe
            //model.addRow(new Object[]{MaSV1.getText(), TenSV1.getText(), DIem1.getSelectedItem().toString()});//xuat ra tabe
            try {
                accept_Client(MaSV1.getText(), TenSV.getText(), DIem1.getSelectedItem().toString(), MonHoc.getText());
            } catch (Exception ex) {
                Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.resetForm();
            thongbao.setText("Đã gửi lên server...");
    }                                    
        else
            thongbao.setText("Xin mời bạn nhập thông tin đầy đủ...");
    }//GEN-LAST:event_themActionPerformed

    private void nut_xoa_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nut_xoa_ActionPerformed
        // TODO add your handling code here:
        //tao thong bao
        if (!kiemtrathongtin()) {
            return;
        }
        int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            try {
                xoa(MaSV1.getText(), TenSV.getText(), DIem1.getSelectedItem().toString(),MonHoc.getText());
                //this.resetForm();
            } catch (Exception ex) {
                Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.resetForm();
            thongbao.setText("Yêu cầu xóa của bạn đã được chuyển lên server...");
    }                                        
    }//GEN-LAST:event_nut_xoa_ActionPerformed

    private void lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lammoiActionPerformed
        // TODO add your handling code here:
         this.resetForm();
    }//GEN-LAST:event_lammoiActionPerformed

    private void suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaActionPerformed
      // TODO add your handling code here:
        if (!kiemtrathongtin()) {
            return;
        }
        int b = JOptionPane.showConfirmDialog(null, "Chắc chắn bạn có muốn sửa dữ liệu này?", "Thông Báo", JOptionPane.YES_NO_OPTION);
        if (b == JOptionPane.YES_OPTION) {
            try {
                suadulieu(MaSV1.getText(), TenSV.getText(), DIem1.getSelectedItem().toString(),MonHoc.getText());
            } catch (Exception ex) {
                Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.resetForm();
            thongbao.setText("Đã gửi yêu cầu sửa dữ liệu lên server...");
    }            
    }//GEN-LAST:event_suaActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String txt = txtTimKiem.getText();
        if(!txt.equals("")){
            try {
                    Search(txtTimKiem.getText());
                } catch (Exception ex) {
                    Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else
            try{
                showall();
            }catch (Exception ex) {
                    Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnTimActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        ThongTinND tt = new ThongTinND();
        try {
                xemTT(tt.getMasv());
                frmThongTin frm = new frmThongTin();
                frm.setVisible(true);
                this.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        frmDoiMK frm = new frmDoiMK();
        frm.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        frmDangNhap frm = new frmDangNhap();
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdmin().setVisible(true);
            }
        });
    }

    public void resetForm() {
        DIem1.getSelectedItem();
        MaSV1.setText("");
        TenSV.setText("");
        thongbao.setText("");
        MonHoc.setText("");
    }
    public Socket connect() throws Exception {
        //1.client: tao socket ket noi den server cho phep ket noi o cong 8080
        String addip;
        IP ip1 = new IP();
        addip = ip1.getIp();
        Socket sk = new Socket(addip, 1234);
        System.out.println("Client da duoc tao...");

        return sk;
    }
    
    public void showall() throws Exception {

        Socket sk = connect();

        //3.3 tao luon ket noiw den sever
        DataOutputStream gui_server = new DataOutputStream(sk.getOutputStream());// tao luon gui di
        DataInputStream nhan_server = new DataInputStream(sk.getInputStream());// tao luon nhan vao

        gui_server.writeUTF("showAll");// gui du lieu len server

        String ketqua = nhan_server.readUTF();
        System.out.println("Client gui:" + ketqua);//doc tu sever
        sk.close();

        handleReturnData(ketqua);
    }

    public void accept_Client(String masv, String tensv, String diem, String monhoc) throws Exception {
        //1.client: tao socket ket noi den server cho phep ket noi o cong 8080
        FrmIP frmip = new FrmIP();
        Socket sk = connect();
        String chen = "add";

        //3.3 tao luon ket noi den sever
        DataOutputStream gui_server = new DataOutputStream(sk.getOutputStream());// tao luon gui di
        DataInputStream nhan_server = new DataInputStream(sk.getInputStream());// tao luon nhan vao

        gui_server.writeUTF(masv + "#" + tensv + "#" + diem + "#" + monhoc + "#" + chen);// gui du lieu len server
        String result = nhan_server.readUTF();
        System.out.println("Client gui:" + result);//doc tu sever
        sk.close();
        handleReturnData(result);
    }
    public void xemTT(String TT) throws Exception {
        //1.client: tao socket ket noi den server cho phep ket noi o cong 8080
        FrmIP frmip = new FrmIP();
        Socket sk = connect();
        String chen = "LayThongTin";

        //3.3 tao luon ket noi den sever
        DataOutputStream gui_server = new DataOutputStream(sk.getOutputStream());// tao luon gui di
        DataInputStream nhan_server = new DataInputStream(sk.getInputStream());// tao luon nhan vao

        gui_server.writeUTF(TT +"#"+ chen);// gui du lieu len server
        String result = nhan_server.readUTF();
        
        System.out.println("Client gui:" + result);//doc tu sever
        sk.close();
        ketquaTT(result);
    }
    
    public void ketquaTT(String result){
        ThongTinND tt = new ThongTinND();
        if (null != result
                && !result.isEmpty()
                && !result.equalsIgnoreCase("OK")
                && !result.equals("DBError")) {
            String[] students = result.split(";");
            if (null != students && students.length != 0) {
                for (int i = 0; i < students.length; i++) {
                    String student = students[i];
                    if (null != student && !student.isEmpty()) {
                        String[] parts = student.split(",");
                        tt.setMasv(parts[0]);
                        tt.setTennd(parts[1]);
                        tt.setEmail(parts[2]);
                        tt.setSdt(parts[3]);
                        tt.setLop(parts[4]);
                    }
                }
            }
        }
    }
    
    public void Search(String thongtin) throws Exception {
        //1.client: tao socket ket noi den server cho phep ket noi o cong 8080
        FrmIP frmip = new FrmIP();
        Socket sk = connect();
        String chen = "search";

        //3.3 tao luon ket noi den sever
        DataOutputStream gui_server = new DataOutputStream(sk.getOutputStream());// tao luon gui di
        DataInputStream nhan_server = new DataInputStream(sk.getInputStream());// tao luon nhan vao

        gui_server.writeUTF(thongtin + "#" + chen);// gui du lieu len server
        
        String result = nhan_server.readUTF();
        System.out.println("Client gui:" + result);//doc tu sever
        sk.close();
        handleReturnData(result);
    }

    public void xoa(String masv, String tensv, String diem, String monhoc) throws Exception {
        //1.client: tao socket ket noi den server cho phep ket noi o cong 6789

        String chen = "xoa";
        FrmIP frmip = new FrmIP();
        Socket sk = connect();

        //3.3 tao luon ket noi den sever
        DataOutputStream dos = new DataOutputStream(sk.getOutputStream());// tao luon gui di
        DataInputStream din = new DataInputStream(sk.getInputStream());// tao luon nhan vao

        dos.writeUTF(masv + "#" + tensv + "#" + diem + "#" + monhoc + "#" + chen);// gui du lieu len server
        String result = din.readUTF();
        System.out.println("Du lieu nhan duoc tu server: " + result);//doc tu sever
        sk.close();
        handleReturnData(result);
    }

    public void suadulieu(String masv, String tensv, String diem, String monhoc) throws Exception {
        //1.client: tao socket ket noi den server cho phep ket noi o cong 6789
        String chen = "suadl";
        FrmIP frmip = new FrmIP();
        Socket sk = connect();

        //3.3 tao luon ket noi den sever
        DataOutputStream dos = new DataOutputStream(sk.getOutputStream());// tao luon gui di
        DataInputStream din = new DataInputStream(sk.getInputStream());// tao luon nhan vao

        dos.writeUTF(masv + "#" + tensv + "#" + diem + "#" + monhoc + "#" + chen);// gui du lieu len server
        String result = din.readUTF();
        System.out.println("Du lieu nhan duoc tu server: " + result);//doc tu sever
        sk.close();
        handleReturnData(result);
    }

    public void handleReturnData(String result) {

        DefaultTableModel model = (DefaultTableModel) ban.getModel();//xuat ra tabe
        model.getDataVector().clear();
        if (null != result
                && !result.isEmpty()
                && !result.equalsIgnoreCase("OK")
                && !result.equals("DBError")) {
            String[] students = result.split(";");
            if (null != students && students.length != 0) {
                for (int i = 0; i < students.length; i++) {
                    String student = students[i];
                    if (null != student && !student.isEmpty()) {
                        String[] parts = student.split(",");
                        model.addRow(new Object[]{parts[0], parts[1], parts[2],parts[3]});
                    }
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox DIem1;
    private javax.swing.JTextField MaSV1;
    private javax.swing.JTextField MonHoc;
    private javax.swing.JTextField TenSV;
    private javax.swing.JTable ban;
    private javax.swing.JButton btnTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lammoi;
    private javax.swing.JButton nut_xoa_;
    private javax.swing.JButton sua;
    private javax.swing.JButton them;
    private javax.swing.JLabel thongbao;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
