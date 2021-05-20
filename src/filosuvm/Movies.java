/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosuvm;

import static filosuvm.Home.movie;
import java.awt.Cursor;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author luisn
 */
public class Movies extends java.awt.Frame {
    int index = 1;
    int availableSeats;
    /**
     * Creates new form Movies
     */
    public Movies() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setInfoMovie();
        btnReturn.setCursor(new Cursor(HAND_CURSOR));
        lblClose.setCursor(new Cursor(HAND_CURSOR));
        lblPrice.setVisible(false);
    }
    
    
    public void setInfoMovie(){
        Movie movie = Home.movie;
        lblTitle.setText(movie.getName());
        ImageIcon icon = new ImageIcon(new ImageIcon(movie.getImage()).getImage().getScaledInstance(lblImage.getWidth(),lblImage.getHeight(), Image.SCALE_SMOOTH));
        lblImage.setIcon(icon);
        txtDescription.setEditable(false);
        txtDescription.setText(movie.getDescription());
    }
    
    public void getAvailableSeats(int index){
      ConnectionDB conn = new ConnectionDB();
      availableSeats = conn.getSeats(index);
      txtAvailableSeats.setText(String.valueOf(availableSeats));
      conn.connectionClose();
    }
    
    public void getSchedule(){
        ArrayList<String> schedules = new ArrayList<>();
        ConnectionDB conn = new ConnectionDB();
        schedules = conn.getSchedule(movie.getId());
        jcmbSchedule.removeAllItems();
        try{
            for(int i=0; i<schedules.size(); i++){
                if(i == 0) jcmbSchedule.addItem("----Seleccione una opcion----");
                jcmbSchedule.addItem(schedules.get(i));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRoot = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        icontoolbar = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnReturn = new javax.swing.JButton();
        BuyInfo = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TicketInfo = new javax.swing.JPanel();
        txtSeats = new javax.swing.JTextField();
        txtAvailableSeats = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblPrice = new javax.swing.JLabel();
        jcmbSchedule = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        pnlRoot.setLayout(new java.awt.BorderLayout());

        Header.setBackground(new java.awt.Color(28, 34, 43));
        Header.setPreferredSize(new java.awt.Dimension(100, 60));
        Header.setLayout(new java.awt.BorderLayout());

        icontoolbar.setBackground(new java.awt.Color(28, 34, 43));
        icontoolbar.setPreferredSize(new java.awt.Dimension(400, 100));
        icontoolbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filosuvm/icons/delete_32px.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        icontoolbar.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 50, 60));

        Header.add(icontoolbar, java.awt.BorderLayout.EAST);

        jPanel3.setBackground(new java.awt.Color(28, 34, 43));
        jPanel3.setForeground(new java.awt.Color(28, 34, 43));
        jPanel3.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanel3.setLayout(new java.awt.BorderLayout());

        btnReturn.setBackground(new java.awt.Color(28, 34, 43));
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filosuvm/icons/left-arrow.png"))); // NOI18N
        btnReturn.setBorder(null);
        btnReturn.setPreferredSize(new java.awt.Dimension(100, 23));
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        jPanel3.add(btnReturn, java.awt.BorderLayout.WEST);

        Header.add(jPanel3, java.awt.BorderLayout.CENTER);

        pnlRoot.add(Header, java.awt.BorderLayout.PAGE_START);

        BuyInfo.setBackground(new java.awt.Color(246, 19, 64));
        BuyInfo.setPreferredSize(new java.awt.Dimension(600, 100));
        BuyInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImage.setPreferredSize(new java.awt.Dimension(600, 1020));
        BuyInfo.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 450, 420));

        lblTitle.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Titulo");
        BuyInfo.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 600, -1));

        txtDescription.setBackground(new java.awt.Color(246, 19, 64));
        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(255, 255, 255));
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setBorder(null);
        jScrollPane2.setViewportView(txtDescription);

        BuyInfo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 760, 460, 240));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A");
        BuyInfo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 590, 40, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Descripcion");
        BuyInfo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 710, 460, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("180 min");
        BuyInfo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 650, 110, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Duracion:");
        BuyInfo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, 120, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Clasificacion:");
        BuyInfo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 160, -1));

        pnlRoot.add(BuyInfo, java.awt.BorderLayout.WEST);

        TicketInfo.setBackground(new java.awt.Color(255, 255, 255));
        TicketInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        TicketInfo.add(txtSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 320, 40));

        txtAvailableSeats.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtAvailableSeats.setText("Asientos Disponibles");
        TicketInfo.add(txtAvailableSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 330, 230, -1));

        jButton1.setBackground(new java.awt.Color(28, 34, 43));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Comprar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        TicketInfo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 730, 590, 100));

        lblPrice.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        lblPrice.setText("240");
        TicketInfo.add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, 330, -1));

        jcmbSchedule.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00 ---------- Sala1", "16:00 ---------- Sala2", "21:00 ---------- Sala3" }));
        jcmbSchedule.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbScheduleItemStateChanged(evt);
            }
        });
        jcmbSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbScheduleActionPerformed(evt);
            }
        });
        TicketInfo.add(jcmbSchedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 320, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel10.setText("Horario");
        TicketInfo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 350, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel11.setText("No. Boletos");
        TicketInfo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 350, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel12.setText("Asientos Disponibles:");
        TicketInfo.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 260, 230, -1));

        pnlRoot.add(TicketInfo, java.awt.BorderLayout.CENTER);

        add(pnlRoot, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     int seats;
      int price = 85;
      index = jcmbSchedule.getSelectedIndex();
      if(!(txtSeats.getText().matches("^[0-9]*$"))){
          JOptionPane.showMessageDialog(null,"El campo duracion solo acepta numeros ");
       }else{
          seats = Integer.parseInt(txtSeats.getText());
          if (seats > availableSeats ){
          JOptionPane.showMessageDialog(null,"No hay asientos disponibles");
            }else if(seats <= 0 ){ 
                  JOptionPane.showMessageDialog(null,"Valor de asientos invalido");
            }else{
                price *= seats;
                lblPrice.setText("Total: " + price);
                lblPrice.setVisible(true);
                Date date = new Date();
                int reply = JOptionPane.showConfirmDialog(null,"El total es de " + price,"Confirmacion",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE );
                if(reply == JOptionPane.YES_OPTION){
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dateSQL = dateFormat.format(date);
                    availableSeats -=seats;
                    ConnectionDB conn = new ConnectionDB();
                    conn.setTicket("Pelicula: " + movie.getName(),seats,dateSQL,price);
                    conn.updateSeats(availableSeats,index+1);
                    this.getAvailableSeats(index+1);
                }   
            }
      }
      
    
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void jcmbScheduleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbScheduleItemStateChanged
  
    }//GEN-LAST:event_jcmbScheduleItemStateChanged

    private void jcmbScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbScheduleActionPerformed
        index = jcmbSchedule.getSelectedIndex();
        this.getAvailableSeats(index);
    }//GEN-LAST:event_jcmbScheduleActionPerformed
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Movies().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BuyInfo;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel TicketInfo;
    private javax.swing.JButton btnReturn;
    private javax.swing.JPanel icontoolbar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcmbSchedule;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlRoot;
    private javax.swing.JLabel txtAvailableSeats;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtSeats;
    // End of variables declaration//GEN-END:variables
}
