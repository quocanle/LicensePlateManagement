/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.congan;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import model.CongAn;
import view.Congdan.CapnhatCongdan;

/**
 *
 * @author LENOVO
 */
public class MenuCongan extends javax.swing.JInternalFrame {
    controller.Controller controller = Controller.getInstance();

    /**
     * Creates new form congan
     */
    public MenuCongan() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);

        start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        searchComboBox = new javax.swing.JComboBox<>();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(957, 572));

        jDesktopPane2.setPreferredSize(new java.awt.Dimension(957, 572));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 204, 255));
        jLabel4.setText("Công an");

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search_40px.png"))); // NOI18N

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 153, 255));
        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Thêm    +");
        jButton4.setPreferredSize(new java.awt.Dimension(109, 29));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã công an", "Họ", "Tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Cấp bậc", "Mã đơn vị", "Địa chỉ"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        searchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã công an", "Họ", "Tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Cấp bậc", "Mã đơn vị", "Địa chỉ" }));

        jDesktopPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel30, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jTextField4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(searchComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 142, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(searchComboBox)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jDesktopPane2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new ThemCongan().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            updateTable(searchMode());
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        int index = jTable3.getSelectedRow();
        TableModel model = jTable3.getModel();
        String maCongAn = model.getValueAt(index, 0).toString();
        String ho = model.getValueAt(index, 1).toString();
        String ten = model.getValueAt(index, 2).toString();
        String gioiTinh = model.getValueAt(index, 3).toString();
        String ngaySinh = model.getValueAt(index, 4).toString();
        String soDT = model.getValueAt(index, 5).toString();
        String capBac = model.getValueAt(index, 6).toString();
        String maDonVi = model.getValueAt(index, 7).toString();
        String diaChi = model.getValueAt(index, 8).toString();
        CapnhatCongan capnhatCongan = new CapnhatCongan();
        capnhatCongan.setVisible(true);
        capnhatCongan.pack();
        capnhatCongan.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        capnhatCongan.oldID = maCongAn;
        capnhatCongan.maCATextField.setText(maCongAn);
        capnhatCongan.hoTextField.setText(ho);
        capnhatCongan.tenTextFIeld.setText(ten);
        if (gioiTinh.equals("Nam")) {
            capnhatCongan.gioiTinhComboBox.setSelectedIndex(0);
        } else {
            capnhatCongan.gioiTinhComboBox.setSelectedIndex(1);
        }
        capnhatCongan.ngaySinhTextField.setText(ngaySinh);
        capnhatCongan.soDTTextFIeld.setText(soDT);
        capnhatCongan.capBacTextField.setText(capBac);
        capnhatCongan.donViTextField.setText(maDonVi);
        capnhatCongan.diaChiTextField.setText(diaChi);

    }//GEN-LAST:event_jTable3MouseClicked

    public void start() {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        for (CongAn ca : controller.getAllCongAn()) {
            String ngaySinh = ca.getNgaySinh().toString();
            String[] date = ngaySinh.split("-");
            ngaySinh = date[2] + "-" + date[1] + "-" + date[0];
            model.addRow(new Object[]{ca.getMaCongAn(), ca.getHo(), ca.getTen(), ca.getGioiTinh(), ngaySinh, ca.getSoDT(), ca.getCapBac(), ca.getMaDonVi(), ca.getDiaChi()});
        }
    }
    
    private void updateTable(ArrayList<CongAn> list) {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        for (CongAn ca : list) {
            String ngaySinh = ca.getNgaySinh().toString();
            String[] date = ngaySinh.split("-");
            ngaySinh = date[2] + "-" + date[1] + "-" + date[0];
            model.addRow(new Object[]{ca.getMaCongAn(), ca.getHo(), ca.getTen(), ca.getGioiTinh(), ngaySinh, ca.getSoDT(), ca.getCapBac(), ca.getMaDonVi(), ca.getDiaChi()});
        }
    }
    
    private ArrayList<CongAn> searchMode() {
        ArrayList<CongAn> listCongAn = controller.getAllCongAn();
        ArrayList<CongAn> congAnSearched = new ArrayList<>();
        String keyword = jTextField4.getText().toLowerCase();
        String mode = searchComboBox.getSelectedItem().toString();
        switch (mode) {
            case "Mã công an":
                for (CongAn ca : listCongAn) {
                    if (ca.getMaCongAn().toLowerCase().contains(keyword)) {
                        congAnSearched.add(ca);
                    }
                }
                break;
            case "Họ":
                for (CongAn ca : listCongAn) {
                    if (ca.getHo().toLowerCase().contains(keyword)) {
                        congAnSearched.add(ca);
                    }
                }
                break;
            case "Tên":
                for (CongAn ca : listCongAn) {
                    if (ca.getTen().toLowerCase().contains(keyword)) {
                        congAnSearched.add(ca);
                    }
                }
                break;
            case "Giới tính":
                for (CongAn ca : listCongAn) {
                    if (ca.getGioiTinh().toLowerCase().contains(keyword)) {
                        congAnSearched.add(ca);
                    }
                }
                break;
            case "Ngày sinh":
                for (CongAn ca : listCongAn) {
                    String ngaySinh = ca.getNgaySinh().toString();
                    String[] date = ngaySinh.split("-");
                    ngaySinh = date[2] + "-" + date[1] + "-" + date[0];
                    
                    if (ngaySinh.toLowerCase().contains(keyword)) {
                        congAnSearched.add(ca);
                    }
                }
                break;
            case "SĐT":
                for (CongAn ca : listCongAn) {
                    if (ca.getSoDT().toLowerCase().contains(keyword)) {
                        congAnSearched.add(ca);
                    }
                }
                break;
            case "Cấp bậc":
                for (CongAn ca : listCongAn) {
                    if (ca.getCapBac().toLowerCase().contains(keyword)) {
                        congAnSearched.add(ca);
                    }
                }
                break;
            case "Mã đơn vị":
                for (CongAn ca : listCongAn) {
                    if (ca.getMaDonVi().toLowerCase().contains(keyword)) {
                        congAnSearched.add(ca);
                    }
                }
                break;
            case "Địa chỉ":
                for (CongAn ca : listCongAn) {
                    if (ca.getMaCongAn().toLowerCase().contains(keyword)) {
                        congAnSearched.add(ca);
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
        return congAnSearched;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JComboBox<String> searchComboBox;
    // End of variables declaration//GEN-END:variables
}
