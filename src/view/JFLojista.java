/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.ClienteFisicoModel;
import model.CompraModel;
import model.FuncionarioModel;

/**
 *
 * @author Henrique Borges
 */
public class JFLojista extends javax.swing.JFrame {

    /**
     * Creates new form jfLojista
     */
    JIFVendaJuri tela_vendafisi;
    private int idCliente;
    private FuncionarioModel obj_func;
    
    public JFLojista() {
        initComponents();
        jtfNomeFunc.setEnabled(false);
        idCliente = 0;
        obj_func = new FuncionarioModel();
        jtfNomeFunc.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpLojista = new javax.swing.JDesktopPane();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jlIdFunc = new javax.swing.JLabel();
        jtfNomeFunc = new javax.swing.JTextField();
        jlNumIdFunc = new javax.swing.JLabel();
        kbCadCliJuri = new keeptoo.KButton();
        kbCadCliFis = new keeptoo.KButton();
        kbCadMidias = new keeptoo.KButton();
        kbVendaCliJuri = new keeptoo.KButton();
        kbVendaCliFisi = new keeptoo.KButton();
        kButton1 = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1300, 750));

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkGradientFocus(2500);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 0));

        jlIdFunc.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jlIdFunc.setForeground(new java.awt.Color(255, 255, 255));
        jlIdFunc.setText("ID");

        jtfNomeFunc.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jtfNomeFunc.setForeground(new java.awt.Color(255, 255, 255));
        jtfNomeFunc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        jlNumIdFunc.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jlNumIdFunc.setForeground(new java.awt.Color(255, 255, 255));
        jlNumIdFunc.setText("0");

        kbCadCliJuri.setForeground(new java.awt.Color(0, 0, 0));
        kbCadCliJuri.setText("Cadastro de Clientes Jurídicos");
        kbCadCliJuri.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        kbCadCliJuri.setkBackGroundColor(new java.awt.Color(0, 204, 51));
        kbCadCliJuri.setkBorderRadius(30);
        kbCadCliJuri.setkEndColor(new java.awt.Color(204, 255, 102));
        kbCadCliJuri.setkForeGround(new java.awt.Color(0, 0, 0));
        kbCadCliJuri.setkStartColor(new java.awt.Color(102, 0, 102));
        kbCadCliJuri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbCadCliJuriActionPerformed(evt);
            }
        });

        kbCadCliFis.setBorder(null);
        kbCadCliFis.setForeground(new java.awt.Color(0, 0, 0));
        kbCadCliFis.setText("Cadastro de Clientes Físicos");
        kbCadCliFis.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        kbCadCliFis.setkBackGroundColor(new java.awt.Color(0, 102, 102));
        kbCadCliFis.setkBorderRadius(30);
        kbCadCliFis.setkEndColor(new java.awt.Color(153, 153, 255));
        kbCadCliFis.setkForeGround(new java.awt.Color(0, 0, 0));
        kbCadCliFis.setkHoverForeGround(new java.awt.Color(153, 51, 0));
        kbCadCliFis.setkHoverStartColor(new java.awt.Color(51, 255, 102));
        kbCadCliFis.setkIndicatorColor(new java.awt.Color(0, 0, 0));
        kbCadCliFis.setkPressedColor(new java.awt.Color(102, 51, 255));
        kbCadCliFis.setkSelectedColor(new java.awt.Color(0, 102, 102));
        kbCadCliFis.setkStartColor(new java.awt.Color(0, 102, 102));
        kbCadCliFis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbCadCliFisActionPerformed(evt);
            }
        });

        kbCadMidias.setForeground(new java.awt.Color(0, 0, 0));
        kbCadMidias.setText("Cadastro de Mídias");
        kbCadMidias.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        kbCadMidias.setkBorderRadius(30);
        kbCadMidias.setkEndColor(new java.awt.Color(204, 102, 0));
        kbCadMidias.setkForeGround(new java.awt.Color(0, 0, 0));
        kbCadMidias.setkStartColor(new java.awt.Color(255, 255, 0));
        kbCadMidias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbCadMidiasActionPerformed(evt);
            }
        });

        kbVendaCliJuri.setForeground(new java.awt.Color(0, 0, 0));
        kbVendaCliJuri.setText("Vendas - Cliente Juridico");
        kbVendaCliJuri.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        kbVendaCliJuri.setkBorderRadius(30);
        kbVendaCliJuri.setkEndColor(new java.awt.Color(51, 51, 51));
        kbVendaCliJuri.setkForeGround(new java.awt.Color(0, 0, 0));
        kbVendaCliJuri.setkStartColor(new java.awt.Color(204, 0, 204));
        kbVendaCliJuri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbVendaCliJuriActionPerformed(evt);
            }
        });

        kbVendaCliFisi.setForeground(new java.awt.Color(0, 0, 0));
        kbVendaCliFisi.setText("Vendas - Cliente Físico");
        kbVendaCliFisi.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        kbVendaCliFisi.setkBorderRadius(30);
        kbVendaCliFisi.setkEndColor(new java.awt.Color(102, 204, 255));
        kbVendaCliFisi.setkForeGround(new java.awt.Color(0, 0, 0));
        kbVendaCliFisi.setkStartColor(new java.awt.Color(0, 102, 102));
        kbVendaCliFisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbVendaCliFisiActionPerformed(evt);
            }
        });

        kButton1.setForeground(new java.awt.Color(0, 0, 0));
        kButton1.setText("SAIR");
        kButton1.setFont(new java.awt.Font("BankGothic Md BT", 0, 14)); // NOI18N
        kButton1.setkEndColor(new java.awt.Color(255, 0, 0));
        kButton1.setkStartColor(new java.awt.Color(0, 51, 51));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kbCadCliFis, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(kbCadCliJuri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(kbCadMidias, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kbVendaCliFisi, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(kbVendaCliJuri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlNumIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlIdFunc)
                        .addComponent(jlNumIdFunc)
                        .addComponent(jtfNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kbVendaCliFisi, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kbCadCliFis, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kbVendaCliJuri, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(kbCadCliJuri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                        .addComponent(kbCadMidias, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(265, 265, 265))))
        );

        jdpLojista.setLayer(kGradientPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpLojistaLayout = new javax.swing.GroupLayout(jdpLojista);
        jdpLojista.setLayout(jdpLojistaLayout);
        jdpLojistaLayout.setHorizontalGroup(
            jdpLojistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        jdpLojistaLayout.setVerticalGroup(
            jdpLojistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpLojista)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpLojista)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kbCadCliJuriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbCadCliJuriActionPerformed
        jifCadastroClientesJuri janela = new jifCadastroClientesJuri();
        jdpLojista.add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_kbCadCliJuriActionPerformed

    private void kbCadCliFisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbCadCliFisActionPerformed
        JIFCadastroClientesFis janela = new JIFCadastroClientesFis();
        jdpLojista.add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_kbCadCliFisActionPerformed

    private void kbCadMidiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbCadMidiasActionPerformed
        JIFMidias janela = new JIFMidias();
        jdpLojista.add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_kbCadMidiasActionPerformed

    private void kbVendaCliJuriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbVendaCliJuriActionPerformed
        JIFVendaJuri janela = new JIFVendaJuri();
        jdpLojista.add(janela);
        janela.setVisible(true);
        janela.setObj_func(obj_func);
        janela.iniciarInfoFunc();
    }//GEN-LAST:event_kbVendaCliJuriActionPerformed

    private void kbVendaCliFisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbVendaCliFisiActionPerformed
        JIFVendaFisi janela = new JIFVendaFisi();
        jdpLojista.add(janela);
        janela.setVisible(true);
        janela.setObj_func(obj_func);
        janela.iniciarInfoFunc();
    }//GEN-LAST:event_kbVendaCliFisiActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        try{
            if(JOptionPane.showConfirmDialog(this, "Deseja realmente sair?\n",  
                    "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                jfLogin tela_login = new jfLogin();
                dispose();
                tela_login.setVisible(true);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_kButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(jfGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfGerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jdpLojista;
    private javax.swing.JLabel jlIdFunc;
    private javax.swing.JLabel jlNumIdFunc;
    private javax.swing.JTextField jtfNomeFunc;
    private keeptoo.KButton kButton1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KButton kbCadCliFis;
    private keeptoo.KButton kbCadCliJuri;
    private keeptoo.KButton kbCadMidias;
    private keeptoo.KButton kbVendaCliFisi;
    private keeptoo.KButton kbVendaCliJuri;
    // End of variables declaration//GEN-END:variables


    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }
    
    public void iniciar(){
        jtfNomeFunc.setText(obj_func.getNome());
        jlNumIdFunc.setText("" + obj_func.getId());
    }

    public void setObjFunc(FuncionarioModel obj){
        this.obj_func = obj;
    }
    
    public FuncionarioModel getObjFunc(){
        return obj_func;
    }
    
    
}
