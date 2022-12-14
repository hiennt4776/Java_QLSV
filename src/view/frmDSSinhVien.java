/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.LopHP;
import model.LopSH;
import model.SinhVien;

/**
 *
 * @author My PC
 */
public class frmDSSinhVien extends javax.swing.JFrame {
    List<LopSH> listLopSH = null;
    List<LopHP> listLopHP = null;
    
private void ResetTable(){
          Vector tieuDe = new Vector();
            tieuDe.add("Mã sinh viên");
            tieuDe.add("Tên sinh viên");
            tieuDe.add("Lớp SH");
            tieuDe.add("Giới tính");
            tieuDe.add("Số CMND");
            tieuDe.add("Ngày sinh");
            tieuDe.add("Địa chỉ");
            Vector duLieu = new Vector();
   
            DefaultTableModel model = new DefaultTableModel(duLieu, tieuDe);
            tableSinhVien.setModel(model);
            
            
}
private void Run_DSSinhVien(){
     try {
            List<LopSH> listLopSH = controller.LopSHController.listLopSHID();
            Vector tieuDe = new Vector();
            tieuDe.add("Mã sinh viên");
            tieuDe.add("Tên sinh viên");
            tieuDe.add("Lớp SH");
            tieuDe.add("Giới tính");
            tieuDe.add("Số CMND");
            tieuDe.add("Ngày sinh");
            tieuDe.add("Địa chỉ");
            Vector duLieu = new Vector();
            List<SinhVien> listSinhVien = controller.SinhVienController.listSinhVienID();
            if (listSinhVien != null) {
                for (SinhVien sinhVien : listSinhVien) {
                    Vector tam = new Vector();
                    tam.add(sinhVien.getID_SV());
                    tam.add(sinhVien.getTenSV());
                    for (LopSH lopSH : listLopSH) {
                        if (lopSH.getID_LopSH().equalsIgnoreCase(sinhVien.getLopSH())) {
                            tam.add(lopSH.getTenLopSH());
                            break;
                        }
                    }
                    if (sinhVien.isGioitinhSV()) {
                        tam.add("Nam");
                    } else {
                        tam.add("Nữ");
                    }
                    tam.add(sinhVien.getCMND());
 //                   System.out.println("so CMND:" +sinhVien.getCMND());
 //                   tam.add(sinhVien.getNgaysinhSV());
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String strDate = formatter.format(sinhVien.getNgaysinhSV());
                    tam.add(strDate);
                    tam.add(sinhVien.getDiachiSV());
                    duLieu.add(tam);
                }
            }
            DefaultTableModel model = new DefaultTableModel(duLieu, tieuDe);
            tableSinhVien.setModel(model);
            Label_DSSV.setText("Danh sách tất cả sinh viên");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(frmDSSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    /**
     * Creates new form frmDSSinhVien
     */
    public frmDSSinhVien() {
        initComponents();
        Run_DSSinhVien();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dialog_DSSV_LopSH = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        cmbLopSH_DialogDSSinhVien = new javax.swing.JComboBox<>();
        btn_DSSVLopSinhHoat_Dialog = new javax.swing.JButton();
        Dialog_DSSV_LopHP = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        cmbLopHP_DialogDSSinhVien = new javax.swing.JComboBox<>();
        btn_DSSVLopHocPhan_Dialog = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSinhVien = new javax.swing.JTable();
        Label_DSSV = new javax.swing.JLabel();
        btnDS_TatCaSinhVien = new javax.swing.JButton();
        btn_DSSVLopSH = new javax.swing.JButton();
        btn_DSSVLopHP = new javax.swing.JButton();

        Dialog_DSSV_LopSH.setTitle("Chọn lớp sinh hoạt");

        jLabel1.setText("Lớp sinh hoạt");

        cmbLopSH_DialogDSSinhVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_DSSVLopSinhHoat_Dialog.setText("Xem danh sách");
        btn_DSSVLopSinhHoat_Dialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DSSVLopSinhHoat_DialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Dialog_DSSV_LopSHLayout = new javax.swing.GroupLayout(Dialog_DSSV_LopSH.getContentPane());
        Dialog_DSSV_LopSH.getContentPane().setLayout(Dialog_DSSV_LopSHLayout);
        Dialog_DSSV_LopSHLayout.setHorizontalGroup(
            Dialog_DSSV_LopSHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dialog_DSSV_LopSHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(Dialog_DSSV_LopSHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Dialog_DSSV_LopSHLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_DSSVLopSinhHoat_Dialog)
                        .addGap(177, 177, 177))
                    .addGroup(Dialog_DSSV_LopSHLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbLopSH_DialogDSSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        Dialog_DSSV_LopSHLayout.setVerticalGroup(
            Dialog_DSSV_LopSHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dialog_DSSV_LopSHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Dialog_DSSV_LopSHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLopSH_DialogDSSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(btn_DSSVLopSinhHoat_Dialog)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Dialog_DSSV_LopHP.setTitle("Chọn lớp học phần");

        jLabel2.setText("Lớp học phần:");

        cmbLopHP_DialogDSSinhVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_DSSVLopHocPhan_Dialog.setText("Xem Danh Sách");
        btn_DSSVLopHocPhan_Dialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DSSVLopHocPhan_DialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Dialog_DSSV_LopHPLayout = new javax.swing.GroupLayout(Dialog_DSSV_LopHP.getContentPane());
        Dialog_DSSV_LopHP.getContentPane().setLayout(Dialog_DSSV_LopHPLayout);
        Dialog_DSSV_LopHPLayout.setHorizontalGroup(
            Dialog_DSSV_LopHPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dialog_DSSV_LopHPLayout.createSequentialGroup()
                .addGroup(Dialog_DSSV_LopHPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Dialog_DSSV_LopHPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbLopHP_DialogDSSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Dialog_DSSV_LopHPLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btn_DSSVLopHocPhan_Dialog)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        Dialog_DSSV_LopHPLayout.setVerticalGroup(
            Dialog_DSSV_LopHPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dialog_DSSV_LopHPLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(Dialog_DSSV_LopHPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbLopHP_DialogDSSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_DSSVLopHocPhan_Dialog)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableSinhVien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableSinhVien);

        Label_DSSV.setText("jLabel1");

        btnDS_TatCaSinhVien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDS_TatCaSinhVien.setForeground(new java.awt.Color(255, 153, 51));
        btnDS_TatCaSinhVien.setText("Danh sách tất cả sinh viên");
        btnDS_TatCaSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDS_TatCaSinhVienActionPerformed(evt);
            }
        });

        btn_DSSVLopSH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_DSSVLopSH.setForeground(new java.awt.Color(255, 153, 51));
        btn_DSSVLopSH.setText("Danh sách sinh viên theo lớp sinh hoạt");
        btn_DSSVLopSH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DSSVLopSHActionPerformed(evt);
            }
        });

        btn_DSSVLopHP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_DSSVLopHP.setForeground(new java.awt.Color(255, 153, 51));
        btn_DSSVLopHP.setText("Danh sách sinh viên theo lớp học phần ");
        btn_DSSVLopHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DSSVLopHPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnDS_TatCaSinhVien)
                                .addGap(18, 18, 18)
                                .addComponent(btn_DSSVLopSH)
                                .addGap(18, 18, 18)
                                .addComponent(btn_DSSVLopHP))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Label_DSSV)))
                        .addGap(0, 524, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDS_TatCaSinhVien)
                    .addComponent(btn_DSSVLopSH)
                    .addComponent(btn_DSSVLopHP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_DSSV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDS_TatCaSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDS_TatCaSinhVienActionPerformed
        // TODO add your handling code here:
         Run_DSSinhVien();
          
    }//GEN-LAST:event_btnDS_TatCaSinhVienActionPerformed

    private void btn_DSSVLopSHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DSSVLopSHActionPerformed
        // TODO add your handling code here:
        
         try {
            // TODO add your handling code here
            listLopSH = controller.LopSHController.listLopSHID();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (LopSH lopSH : listLopSH) {
                model.addElement(lopSH.getTenLopSH());
            }
            cmbLopSH_DialogDSSinhVien.setModel(model);
            Dialog_DSSV_LopSH.setSize(350,125);
            Dialog_DSSV_LopSH.setLocationRelativeTo(null);
            Dialog_DSSV_LopSH.setVisible(true);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(frmDSSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_DSSVLopSHActionPerformed

    private void btn_DSSVLopSinhHoat_DialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DSSVLopSinhHoat_DialogActionPerformed
         try {
            String ID_LopSH = new String();
            for (LopSH lopSH : listLopSH) {
                if (lopSH.getTenLopSH().equalsIgnoreCase(cmbLopSH_DialogDSSinhVien.getSelectedItem().toString())) {
                    {
                        ID_LopSH = lopSH.getID_LopSH();
                         Label_DSSV.setText("Danh sách sinh viên lớp "+lopSH.getTenLopSH());
                        break;
                    }
                }
            }
            Vector tieuDe = new Vector();
            tieuDe.add("Mã sinh viên");
            tieuDe.add("Tên sinh viên");
            tieuDe.add("Lớp SH");
            tieuDe.add("Giới tính");
            tieuDe.add("Số CMND");
            tieuDe.add("Ngày sinh");
            tieuDe.add("Địa chỉ");
            Vector duLieu = new Vector();
      
            List<SinhVien> listSinhVien = controller.SinhVienController.listSVLopSH(ID_LopSH);
            if (listSinhVien != null) {
                for (SinhVien sinhVien : listSinhVien) {
                    Vector tam = new Vector();
                    tam.add(sinhVien.getID_SV());
                    tam.add(sinhVien.getTenSV());
                    for (LopSH lopSH : listLopSH) {
                        if (lopSH.getID_LopSH().equalsIgnoreCase(sinhVien.getLopSH())) {
                            tam.add(sinhVien.getLopSH());
                            break;
                        }
                    }
                    if (sinhVien.isGioitinhSV()) {
                        tam.add("Nam");
                    } else {
                        tam.add("Nữ");
                    }
                    tam.add(sinhVien.getCMND());
//                    tam.add(sinhVien.getNgaysinhSV());
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String strDate = formatter.format(sinhVien.getNgaysinhSV());
                    tam.add(strDate);
                    tam.add(sinhVien.getDiachiSV());
                    duLieu.add(tam);
                    DefaultTableModel model = new DefaultTableModel(duLieu, tieuDe);
                    tableSinhVien.setModel(model);
                }
            }else{
                 ResetTable();
            }
            
            Dialog_DSSV_LopSH.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmDSSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmDSSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }//GEN-LAST:event_btn_DSSVLopSinhHoat_DialogActionPerformed

    private void btn_DSSVLopHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DSSVLopHPActionPerformed
        // TODO add your handling code here:
           try {
            // TODO add your handling code here
            listLopHP = controller.LopHPController.listLopHPID();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (LopHP lopHP : listLopHP) {
                model.addElement(lopHP.getTenLopHP());
            }
            cmbLopHP_DialogDSSinhVien.setModel(model);
            Dialog_DSSV_LopHP.setSize(350,125);
            Dialog_DSSV_LopHP.setLocationRelativeTo(null);
            Dialog_DSSV_LopHP.setVisible(true);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(frmDSSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_DSSVLopHPActionPerformed

    private void btn_DSSVLopHocPhan_DialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DSSVLopHocPhan_DialogActionPerformed
        // TODO add your handling code here:
        try {
            List<LopSH> listLopSH = controller.LopSHController.listLopSHID();
            String ID_LopHP = new String();
             for (LopHP lopHP : listLopHP) {
                if (lopHP.getTenLopHP().equalsIgnoreCase(cmbLopHP_DialogDSSinhVien.getSelectedItem().toString())) {
                    {
                        ID_LopHP = lopHP.getID_LopHP();
                         Label_DSSV.setText("Danh sách sinh viên lớp "+lopHP.getTenLopHP());
                        break;
                        }
                    }
                }
            Vector tieuDe = new Vector();
            tieuDe.add("Mã sinh viên");
            tieuDe.add("Tên sinh viên");
            tieuDe.add("Lớp SH");
            tieuDe.add("Giới tính");
            tieuDe.add("Số CMND");
            tieuDe.add("Ngày sinh");
            tieuDe.add("Địa chỉ");
            Vector duLieu = new Vector();
           
            List<SinhVien> listSinhVien = controller.SinhVienController.listSVLopHP(ID_LopHP);
           
            if (listSinhVien != null) {
                
                for (SinhVien sinhVien : listSinhVien) {
                    Vector tam = new Vector();
                    tam.add(sinhVien.getID_SV());
                    tam.add(sinhVien.getTenSV());
                    
                    for (LopSH lopSH : listLopSH) {
                        if (lopSH.getID_LopSH().equalsIgnoreCase(sinhVien.getLopSH())) {
                            tam.add(lopSH.getTenLopSH());
                            break;
                        }
                    }

                    if (sinhVien.isGioitinhSV()) {
                        tam.add("Nam");
                    } else {
                        tam.add("Nữ");
                    }
                    tam.add(sinhVien.getCMND());
//                    tam.add(sinhVien.getNgaysinhSV());
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String strDate = formatter.format(sinhVien.getNgaysinhSV());
                    tam.add(strDate);
                    tam.add(sinhVien.getDiachiSV());
                    
                    duLieu.add(tam);
                }
            DefaultTableModel model = new DefaultTableModel(duLieu, tieuDe);
            tableSinhVien.setModel(model);
            }else{
            ResetTable();
            }
           
            Dialog_DSSV_LopHP.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmDSSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmDSSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_DSSVLopHocPhan_DialogActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDSSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDSSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDSSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDSSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDSSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Dialog_DSSV_LopHP;
    private javax.swing.JDialog Dialog_DSSV_LopSH;
    private javax.swing.JLabel Label_DSSV;
    private javax.swing.JButton btnDS_TatCaSinhVien;
    private javax.swing.JButton btn_DSSVLopHP;
    private javax.swing.JButton btn_DSSVLopHocPhan_Dialog;
    private javax.swing.JButton btn_DSSVLopSH;
    private javax.swing.JButton btn_DSSVLopSinhHoat_Dialog;
    private javax.swing.JComboBox<String> cmbLopHP_DialogDSSinhVien;
    private javax.swing.JComboBox<String> cmbLopSH_DialogDSSinhVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSinhVien;
    // End of variables declaration//GEN-END:variables
}
