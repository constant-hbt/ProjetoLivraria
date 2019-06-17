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
public class jfGerente extends javax.swing.JFrame {

    /**
     * Creates new form jfLojista
     */
    JIFVendaJuri tela_vendafisi;
    private int idCliente;
    private FuncionarioModel obj_func;
    
    public jfGerente() {
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

        jdpGerente = new javax.swing.JDesktopPane();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jlIdFunc = new javax.swing.JLabel();
        jtfNomeFunc = new javax.swing.JTextField();
        jlNumIdFunc = new javax.swing.JLabel();
        kbCadCliJuri = new keeptoo.KButton();
        kbCadCliFis = new keeptoo.KButton();
        kbCadMidias = new keeptoo.KButton();
        kbVendaCliJuri = new keeptoo.KButton();
        kbVendaCliFisi = new keeptoo.KButton();
        kbCadFunc = new keeptoo.KButton();
        kbSair = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1300, 750));

        kGradientPanel1.setkEndColor(new java.awt.Color(153, 255, 153));
        kGradientPanel1.setkGradientFocus(2500);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 0));

        jlIdFunc.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jlIdFunc.setForeground(new java.awt.Color(255, 255, 255));
        jlIdFunc.setText("ID");

        jtfNomeFunc.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jtfNomeFunc.setForeground(new java.awt.Color(255, 255, 255));
        jtfNomeFunc.setBorder(null);

        jlNumIdFunc.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jlNumIdFunc.setForeground(new java.awt.Color(255, 255, 255));
        jlNumIdFunc.setText("0");

        kbCadCliJuri.setText("Cadastro de Clientes Jurídicos");
        kbCadCliJuri.setkBorderRadius(100);
        kbCadCliJuri.setkEndColor(new java.awt.Color(102, 0, 102));
        kbCadCliJuri.setkStartColor(new java.awt.Color(153, 0, 255));
        kbCadCliJuri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbCadCliJuriActionPerformed(evt);
            }
        });

        kbCadCliFis.setBorder(null);
        kbCadCliFis.setText("Cadastro de Clientes Físicos");
        kbCadCliFis.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        kbCadCliFis.setkBackGroundColor(new java.awt.Color(0, 102, 102));
        kbCadCliFis.setkBorderRadius(100);
        kbCadCliFis.setkEndColor(new java.awt.Color(153, 153, 255));
        kbCadCliFis.setkHoverForeGround(new java.awt.Color(153, 51, 0));
        kbCadCliFis.setkHoverStartColor(new java.awt.Color(51, 255, 102));
        kbCadCliFis.setkPressedColor(new java.awt.Color(102, 51, 255));
        kbCadCliFis.setkSelectedColor(new java.awt.Color(0, 102, 102));
        kbCadCliFis.setkStartColor(new java.awt.Color(0, 102, 102));
        kbCadCliFis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbCadCliFisActionPerformed(evt);
            }
        });

        kbCadMidias.setText("Cadastro de Mídias");
        kbCadMidias.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        kbCadMidias.setkBorderRadius(100);
        kbCadMidias.setkEndColor(new java.awt.Color(153, 153, 0));
        kbCadMidias.setkStartColor(new java.awt.Color(204, 204, 0));
        kbCadMidias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbCadMidiasActionPerformed(evt);
            }
        });

        kbVendaCliJuri.setText("Vendas - Cliente Juridico");
        kbVendaCliJuri.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        kbVendaCliJuri.setkBorderRadius(100);
        kbVendaCliJuri.setkEndColor(new java.awt.Color(102, 0, 255));
        kbVendaCliJuri.setkStartColor(new java.awt.Color(102, 0, 102));
        kbVendaCliJuri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbVendaCliJuriActionPerformed(evt);
            }
        });

        kbVendaCliFisi.setText("Vendas - Cliente Físico");
        kbVendaCliFisi.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        kbVendaCliFisi.setkBorderRadius(100);
        kbVendaCliFisi.setkEndColor(new java.awt.Color(51, 0, 102));
        kbVendaCliFisi.setkStartColor(new java.awt.Color(0, 153, 204));
        kbVendaCliFisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbVendaCliFisiActionPerformed(evt);
            }
        });

        kbCadFunc.setText("Cadastro de Funcionários");
        kbCadFunc.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        kbCadFunc.setkBorderRadius(100);
        kbCadFunc.setkEndColor(new java.awt.Color(0, 51, 51));
        kbCadFunc.setkStartColor(new java.awt.Color(102, 0, 51));
        kbCadFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbCadFuncActionPerformed(evt);
            }
        });

        kbSair.setFont(new java.awt.Font("BankGothic Md BT", 1, 14)); // NOI18N
        kbSair.setkBorderRadius(30);
        kbSair.setkStartColor(new java.awt.Color(204, 0, 0));
        kbSair.setLabel("SAIR");
        kbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kbSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jlIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jlNumIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kbSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kbCadCliJuri, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(kbCadCliFis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(156, 156, 156)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kbCadMidias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kbCadFunc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kbVendaCliJuri, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kbVendaCliFisi, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlIdFunc)
                            .addComponent(jlNumIdFunc)
                            .addComponent(jtfNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(kbSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kbVendaCliFisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kbCadFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kbCadCliFis, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kbVendaCliJuri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kbCadMidias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kbCadCliJuri, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        jdpGerente.setLayer(kGradientPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpGerenteLayout = new javax.swing.GroupLayout(jdpGerente);
        jdpGerente.setLayout(jdpGerenteLayout);
        jdpGerenteLayout.setHorizontalGroup(
            jdpGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        jdpGerenteLayout.setVerticalGroup(
            jdpGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpGerente)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpGerente)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kbCadCliJuriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbCadCliJuriActionPerformed
        jifCadastroClientesJuri janela = new jifCadastroClientesJuri();
        jdpGerente.add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_kbCadCliJuriActionPerformed

    private void kbCadCliFisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbCadCliFisActionPerformed
        JIFCadastroClientesFis janela = new JIFCadastroClientesFis();
        jdpGerente.add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_kbCadCliFisActionPerformed

    private void kbCadMidiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbCadMidiasActionPerformed
        JIFMidias janela = new JIFMidias();
        jdpGerente.add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_kbCadMidiasActionPerformed

    private void kbVendaCliJuriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbVendaCliJuriActionPerformed
        JIFVendaJuri janela = new JIFVendaJuri();
        jdpGerente.add(janela);
        janela.setVisible(true);
        janela.setObj_func(obj_func);
        janela.iniciarInfoFunc();
    }//GEN-LAST:event_kbVendaCliJuriActionPerformed

    private void kbVendaCliFisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbVendaCliFisiActionPerformed
        JIFVendaFisi janela = new JIFVendaFisi();
        jdpGerente.add(janela);
        janela.setVisible(true);
        janela.setObj_func(obj_func);
        janela.iniciarInfoFunc();
    }//GEN-LAST:event_kbVendaCliFisiActionPerformed

    private void kbCadFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbCadFuncActionPerformed
        JIFCadastroFuncionarios janela = new JIFCadastroFuncionarios();
        jdpGerente.add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_kbCadFuncActionPerformed

    private void kbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kbSairActionPerformed
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
    }//GEN-LAST:event_kbSairActionPerformed

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
    private javax.swing.JDesktopPane jdpGerente;
    private javax.swing.JLabel jlIdFunc;
    private javax.swing.JLabel jlNumIdFunc;
    private javax.swing.JTextField jtfNomeFunc;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KButton kbCadCliFis;
    private keeptoo.KButton kbCadCliJuri;
    private keeptoo.KButton kbCadFunc;
    private keeptoo.KButton kbCadMidias;
    private keeptoo.KButton kbSair;
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
