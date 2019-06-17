package view;

import data.ClienteFisicoData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ClienteFisicoModel;
import model.MidiaModel;
import data.CompraData;
import data.SituacaoData;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.CompraModel;
import model.FuncionarioModel;
import model.ItensCompraModel;
import model.SituacaoModel;

public class JIFVendaFisi extends javax.swing.JInternalFrame {

    ClienteFisicoModel obj;
    ArrayList<ClienteFisicoModel> listaCliFisicos; 
    String acao;
    MidiaModel obj_mid;
    ArrayList<ItensCompraModel> listaItensCompra;
    ArrayList<SituacaoModel> listaSituacoes;
    String acao_mid;
    CompraModel obj_c;
    FuncionarioModel obj_func;
    int idCliente;
    
    public JIFVendaFisi() {
        initComponents();
        try{
            obj = new ClienteFisicoModel();
            listaCliFisicos = new ArrayList();
            acao = new String();
            obj_mid = new MidiaModel();
            listaItensCompra = new ArrayList();
            acao_mid = new String();
            obj_c = new CompraModel();
            obj_func = new FuncionarioModel();
            SituacaoData DAOSituacao = new SituacaoData();
            listaSituacoes = DAOSituacao.carregarCombo();
            idCliente = 0;
        inicializarTela();
        }catch(Exception e ){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpVendas = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jtfNomeFunc = new javax.swing.JTextField();
        jlNome = new javax.swing.JLabel();
        jlidNumFunc = new javax.swing.JLabel();
        jlIdFunc = new javax.swing.JLabel();
        jlDadosVendedor = new javax.swing.JLabel();
        jtfPesqCli = new javax.swing.JTextField();
        jspTabelaCli = new javax.swing.JScrollPane();
        jtTabelaCli = new javax.swing.JTable();
        jlPesqCli = new javax.swing.JLabel();
        jlPesq = new javax.swing.JLabel();
        jtfNomeCli = new javax.swing.JTextField();
        jlDadosCli = new javax.swing.JLabel();
        jlNomeCli = new javax.swing.JLabel();
        jlEmail = new javax.swing.JLabel();
        jtfEmailCli = new javax.swing.JTextField();
        jtfCpfCli = new javax.swing.JTextField();
        jlCpfCli = new javax.swing.JLabel();
        jlIdNumCli = new javax.swing.JLabel();
        jlIdCli = new javax.swing.JLabel();
        jlObsCli = new javax.swing.JLabel();
        jtfObsCli = new javax.swing.JTextField();
        jbHistorico = new javax.swing.JButton();
        jlPesqProd = new javax.swing.JLabel();
        jspTabelaCompra1 = new javax.swing.JScrollPane();
        jtTabelaMid = new javax.swing.JTable();
        jtfPesqMid = new javax.swing.JTextField();
        jlDadosProd = new javax.swing.JLabel();
        jlDadosCompra = new javax.swing.JLabel();
        jtfQuantMid = new javax.swing.JTextField();
        jlQuantMid = new javax.swing.JLabel();
        jbAdicionarMid = new javax.swing.JButton();
        jbRemoverMid = new javax.swing.JButton();
        jspTabelaCompra = new javax.swing.JScrollPane();
        jtTabelaCompra = new javax.swing.JTable();
        jlItenscompra = new javax.swing.JLabel();
        jlValorTotal = new javax.swing.JLabel();
        jlValorTFinal = new javax.swing.JLabel();
        jbNovo = new javax.swing.JButton();
        jbCancelarCompra = new javax.swing.JButton();
        jbFinalizarCompra = new javax.swing.JButton();
        jcbFormapag = new javax.swing.JComboBox<>();
        jlFormapag = new javax.swing.JLabel();
        jlDesconto = new javax.swing.JLabel();
        jtfDesconto = new javax.swing.JTextField();
        jlValorTP = new javax.swing.JLabel();
        jlValorParcial = new javax.swing.JLabel();
        jbVoltar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 768));

        jlNome.setText("Nome");

        jlidNumFunc.setText("0");

        jlIdFunc.setText("ID");

        jlDadosVendedor.setText("Dados do Vendedor ");

        jtfPesqCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPesqCliKeyReleased(evt);
            }
        });

        jtTabelaCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabelaCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTabelaCliMouseClicked(evt);
            }
        });
        jspTabelaCli.setViewportView(jtTabelaCli);

        jlPesqCli.setText("Pesquisar");

        jlPesq.setText("Pesquisar cliente");

        jlDadosCli.setText("Dados do cliente");

        jlNomeCli.setText("Nome");

        jlEmail.setText("E-mail");

        jlCpfCli.setText("CPF");

        jlIdNumCli.setText("0");

        jlIdCli.setText("ID");

        jlObsCli.setText("Observações");

        jbHistorico.setText("Histórico de Compras");
        jbHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHistoricoActionPerformed(evt);
            }
        });

        jlPesqProd.setText("Pesquisar");

        jtTabelaMid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titulo", "Quantidade", "Valor Unitário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTabelaMid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTabelaMidMouseClicked(evt);
            }
        });
        jspTabelaCompra1.setViewportView(jtTabelaMid);

        jtfPesqMid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPesqMidKeyReleased(evt);
            }
        });

        jlDadosProd.setText("Dados dos produtos");

        jlDadosCompra.setText("Dados da compra");

        jlQuantMid.setText("Quantidade");

        jbAdicionarMid.setText("+");
        jbAdicionarMid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarMidActionPerformed(evt);
            }
        });

        jbRemoverMid.setText("-");
        jbRemoverMid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverMidActionPerformed(evt);
            }
        });

        jtTabelaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titulo", "Quantidade", "Preço unitário", "Valor parcial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspTabelaCompra.setViewportView(jtTabelaCompra);

        jlItenscompra.setText("Itens da compra");

        jlValorTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlValorTotal.setText("0.00");

        jlValorTFinal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlValorTFinal.setText("Valor Total");

        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbCancelarCompra.setText("Cancelar");
        jbCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarCompraActionPerformed(evt);
            }
        });

        jbFinalizarCompra.setText("Finalizar Compra");
        jbFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinalizarCompraActionPerformed(evt);
            }
        });

        jcbFormapag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Dinheiro", "Cartão de Crédito", "Cartão de Débito" }));
        jcbFormapag.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbFormapagItemStateChanged(evt);
            }
        });

        jlFormapag.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlFormapag.setText("Forma de pagamento");

        jlDesconto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlDesconto.setText("Desconto");

        jtfDesconto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfDescontoMouseClicked(evt);
            }
        });
        jtfDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescontoActionPerformed(evt);
            }
        });
        jtfDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDescontoKeyReleased(evt);
            }
        });

        jlValorTP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlValorTP.setText("Valor Parcial");

        jlValorParcial.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlValorParcial.setText("0.00");

        jbVoltar.setText("Voltar");
        jbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPesq)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jlPesqCli)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfPesqCli, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jspTabelaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlDadosCli)
                            .addComponent(jlDadosVendedor)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlIdFunc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlidNumFunc)
                                .addGap(18, 18, 18)
                                .addComponent(jlNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(jlIdCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlIdNumCli))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jlEmail)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtfEmailCli, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jlNomeCli)
                                    .addGap(325, 325, 325)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jtfNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jlCpfCli)
                        .addGap(18, 18, 18)
                        .addComponent(jtfCpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfObsCli, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(248, 248, 248)
                                .addComponent(jlObsCli))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jbHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(292, 292, 292)
                                .addComponent(jlItenscompra)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlDadosProd)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGap(141, 141, 141)
                                            .addComponent(jlPesqProd)
                                            .addGap(18, 18, 18)
                                            .addComponent(jtfPesqMid, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(97, 97, 97))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jspTabelaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jspTabelaCompra1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlDadosCompra)
                                        .addGap(221, 221, 221))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlQuantMid)
                                        .addGap(10, 10, 10)
                                        .addComponent(jtfQuantMid, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbAdicionarMid, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(jbRemoverMid, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(131, 131, 131))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jlValorTFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlFormapag)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbFormapag, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(71, 71, 71)
                                    .addComponent(jlDesconto)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jlValorTP)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jlValorParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(34, 34, 34))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jbCancelarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jbFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(408, 408, 408))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDadosVendedor)
                    .addComponent(jlDadosProd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdFunc)
                    .addComponent(jlidNumFunc)
                    .addComponent(jlNome)
                    .addComponent(jtfNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPesqProd)
                    .addComponent(jtfPesqMid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jspTabelaCompra1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jlDadosCompra)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jlQuantMid))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jtfQuantMid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbAdicionarMid, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbRemoverMid, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addComponent(jlItenscompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jspTabelaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlValorTFinal))
                                .addGap(21, 21, 21))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlFormapag)
                                    .addComponent(jcbFormapag, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlDesconto))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlValorTP)
                                    .addComponent(jlValorParcial))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlPesq)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlPesqCli)
                            .addComponent(jtfPesqCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jspTabelaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlDadosCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlIdCli)
                            .addComponent(jlIdNumCli))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlNomeCli)
                            .addComponent(jtfNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlCpfCli)
                            .addComponent(jtfCpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlEmail)
                            .addComponent(jtfEmailCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlObsCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfObsCli, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jbCancelarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbFinalizarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jdpVendas.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpVendasLayout = new javax.swing.GroupLayout(jdpVendas);
        jdpVendas.setLayout(jdpVendasLayout);
        jdpVendasLayout.setHorizontalGroup(
            jdpVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpVendasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jdpVendasLayout.setVerticalGroup(
            jdpVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpVendasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfPesqCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesqCliKeyReleased
        try{
            String pesq = jtfPesqCli.getText();
            DefaultTableModel mp = (DefaultTableModel) jtTabelaCli.getModel();
            while(jtTabelaCli.getRowCount() > 0)
                    mp.removeRow(0);
            if(pesq.length() > 2){
                ClienteFisicoData DAO = new ClienteFisicoData();
                listaCliFisicos = DAO.pesquisar(pesq);
                mp.setNumRows(0);
                for(ClienteFisicoModel u: listaCliFisicos){
                    mp.addRow(new String[]{"" + u.getId(), u.getNome(), u.getCpf(), u.getEmail()});
                }
            }
        }catch(Exception erro){
            JOptionPane.showMessageDialog(this, "Erro: "+erro.getMessage(), "Salvar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtfPesqCliKeyReleased

    private void jtTabelaCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaCliMouseClicked
        try{
            int linha = jtTabelaCli.getSelectedRow();
            if(linha>-1){
                jlIdNumCli.setText("" + listaCliFisicos.get(linha).getId());
                jtfNomeCli.setText(listaCliFisicos.get(linha).getNome());
                jtfCpfCli.setText(listaCliFisicos.get(linha).getCpf());
                jtfEmailCli.setText(listaCliFisicos.get(linha).getEmail());
                jtfObsCli.setText(listaCliFisicos.get(linha).getObservacoes());
                idCliente = listaCliFisicos.get(linha).getId();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jtTabelaCliMouseClicked

    private void jtfPesqMidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesqMidKeyReleased
        try{
            String pesq = jtfPesqMid.getText();
            DefaultTableModel tabela = (DefaultTableModel) jtTabelaMid.getModel();
            if(pesq.length() > 2){
                ArrayList<MidiaModel> listaMidias = new ArrayList<>();
                CompraData DAO = new CompraData();
                listaMidias = DAO.pesquisarMid(pesq);
                while(jtTabelaMid.getRowCount() > 0)
                    tabela.removeRow(0);
                for(int i=0; i<listaMidias.size(); i++){
                    if(!listaMidias.get(i).getSituacao().getDescricao().equalsIgnoreCase("Não comercializado"))
                        tabela.addRow(new String[]{"" + listaMidias.get(i).getId(), listaMidias.get(i).getTitulo(), "" + listaMidias.get(i).getQuant(), "" + listaMidias.get(i).getPreco_unit()});
                }
            }else
                while(jtTabelaMid.getRowCount() > 0)
                    tabela.removeRow(0);
        }catch(Exception erro){
            JOptionPane.showMessageDialog(this, "Erro: "+erro.getMessage(), "Salvar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtfPesqMidKeyReleased

    private void jbAdicionarMidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarMidActionPerformed
      try{
            if(Integer.parseInt(jtfQuantMid.getText()) > 0 || !jtfQuantMid.equals("")){
                DefaultTableModel origem = (DefaultTableModel) jtTabelaMid.getModel();
                int linha_selecionada = jtTabelaMid.getSelectedRow();
                if(comparar()){
                    if(linha_selecionada > -1){
                        DefaultTableModel destino = (DefaultTableModel) jtTabelaCompra.getModel();
                        boolean flag = false;
                        ItensCompraModel obj_itens = new ItensCompraModel();
                        for(int i = 0; i<listaItensCompra.size(); i++){
                            if(listaItensCompra.get(i).getIdMidia() == Integer.parseInt((String) origem.getValueAt(linha_selecionada, 0))){
                                obj_itens.setIdMidia(Integer.parseInt((String) origem.getValueAt(linha_selecionada, 0)));
                                obj_itens.setQuant(Integer.parseInt(jtfQuantMid.getText()) + Integer.parseInt((String)  destino.getValueAt(i, 2)));
                                obj_itens.setPreco(Double.parseDouble((String) origem.getValueAt(linha_selecionada, 3)));
                                obj_itens.setValorparcial(obj_itens.getQuant() * obj_itens.getPreco());
                                String[] tabela = {"" + obj_itens.getIdMidia(), 
                                    (String) origem.getValueAt(linha_selecionada, 1), "" + obj_itens.getQuant(), "" + obj_itens.getPreco(), "" + obj_itens.getValorparcial()};
                                destino.removeRow(i);
                                destino.addRow(tabela);
                                listaItensCompra.remove(i);
                                listaItensCompra.add(obj_itens);
                                flag = true;
                            }
                        }
                        if(flag == false){
                            obj_itens.setIdMidia(Integer.parseInt((String) origem.getValueAt(linha_selecionada, 0)));
                            obj_itens.setQuant(Integer.parseInt(jtfQuantMid.getText()));
                            obj_itens.setPreco(Double.parseDouble((String) origem.getValueAt(linha_selecionada, 3)));
                            obj_itens.setValorparcial(obj_itens.getQuant() * obj_itens.getPreco());
                            String[] tabela = (new String[]{"" + obj_itens.getIdMidia(), 
                                    (String) origem.getValueAt(linha_selecionada, 1), "" + obj_itens.getQuant(), "" + obj_itens.getPreco(), "" + obj_itens.getValorparcial()});
                        destino.addRow(tabela);
                        listaItensCompra.add(obj_itens);
                        jbAdicionarMid.setEnabled(false);
                        jtTabelaMid.clearSelection();
                        }
                        Double valor_total = 0.0;
                        for(int j=0; j<listaItensCompra.size(); j++){
                            valor_total += listaItensCompra.get(j).getValorparcial();
                        }
                        jlValorParcial.setText("" + valor_total);
                        atualizaValTotal();
                        jcbFormapag.setEnabled(true);
                        jtfQuantMid.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Quantidade maior do que existe do produto em estoque!");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Informe a quantidade!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }

    }//GEN-LAST:event_jbAdicionarMidActionPerformed

    private void jbRemoverMidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverMidActionPerformed
        try{
            if(jtTabelaCompra.getSelectedRowCount() > 0){
                int linha = jtTabelaCompra.getSelectedRow();
                DefaultTableModel tabela = (DefaultTableModel) jtTabelaCompra.getModel();
                int idMidia = Integer.parseInt((String) tabela.getValueAt(linha, 0));
                tabela.removeRow(linha);
                for(int i=0; i<listaItensCompra.size(); i++){
                    if(listaItensCompra.get(i).getIdMidia() == idMidia){
                        jlValorParcial.setText("" + (Double.parseDouble(jlValorParcial.getText()) - listaItensCompra.get(i).getValorparcial()));
                        atualizaValTotal();
                        listaItensCompra.remove(i);
                        JOptionPane.showMessageDialog(this, "Item removido com sucesso!");
                        if(listaItensCompra.isEmpty())
                            jcbFormapag.setEnabled(false);
                    }
                }
            }else
                JOptionPane.showMessageDialog(this, "Selecione o item que deseja remover");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jbRemoverMidActionPerformed

    private void jbFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarCompraActionPerformed
        try{
            if(validarDados()){
                if(preencherObj()){
                    CompraData DAO = new CompraData();
                        if(DAO.finalizarCompra(obj_c)){
                            JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso!");
                            jbCancelarCompraActionPerformed(evt);
                        }   
                        else{
                        JOptionPane.showMessageDialog(null, "Erro ao finalizar a compra!");
                        }
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jbFinalizarCompraActionPerformed

    private void jbCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarCompraActionPerformed
        try{
            jtfPesqMid.setText("");
            jtfPesqMid.setEnabled(false);
            DefaultTableModel tabela = (DefaultTableModel) jtTabelaMid.getModel();
            DefaultTableModel tabCompra = (DefaultTableModel) jtTabelaCompra.getModel();
            while(jtTabelaMid.getRowCount() > 0)
                tabela.removeRow(0);
            while(jtTabelaCompra.getRowCount() > 0)
                tabCompra.removeRow(0);
            inicializarTela();
            jbNovo.setEnabled(true);
            jcbFormapag.setSelectedIndex(0);
            jtfDesconto.setEnabled(false);
            jbFinalizarCompra.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jbCancelarCompraActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        jbNovo.setEnabled(false);
        jtfPesqMid.setEnabled(true);
        jbCancelarCompra.setEnabled(true);
        jtfDesconto.setEnabled(true);
        jbFinalizarCompra.setEnabled(true);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jtTabelaMidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTabelaMidMouseClicked
        try{
            int linha = jtTabelaMid.getSelectedRow();
            if(linha>-1){
                jbAdicionarMid.setEnabled(true);
                jbRemoverMid.setEnabled(true);
                jtfQuantMid.setEnabled(true);
                jtfQuantMid.requestFocus();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jtTabelaMidMouseClicked

    private void jcbFormapagItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFormapagItemStateChanged
        jbFinalizarCompra.setEnabled(true);
    }//GEN-LAST:event_jcbFormapagItemStateChanged

    private void jbHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHistoricoActionPerformed
        try{
            if(jtTabelaCli.getSelectedRow() > -1){
                jifHistorico janela = new jifHistorico();
                jdpVendas.add(janela);
                janela.setVisible(true);
                janela.setIdCliente(idCliente);
                janela.setIdFunc(obj_func.getId());
                janela.iniciarTabela();
            }
            else
            JOptionPane.showMessageDialog(this, "Selecione um cliente para ver seu histórico de compras!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jbHistoricoActionPerformed

    private void jtfDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescontoActionPerformed

    private void jbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jbVoltarActionPerformed

    private void jtfDescontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescontoKeyReleased
        try{
            if(jtfDesconto.equals(","))
                JOptionPane.showMessageDialog(this, "Utilize o ponto ao invés da vírgula!");
            if(!atualizarValTotal())
                JOptionPane.showMessageDialog(this, "Verifique o desconto");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jtfDescontoKeyReleased

    private void jtfDescontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfDescontoMouseClicked
        jtfDesconto.setText("");
    }//GEN-LAST:event_jtfDescontoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAdicionarMid;
    private javax.swing.JButton jbCancelarCompra;
    private javax.swing.JButton jbFinalizarCompra;
    private javax.swing.JButton jbHistorico;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbRemoverMid;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JComboBox<String> jcbFormapag;
    private javax.swing.JDesktopPane jdpVendas;
    private javax.swing.JLabel jlCpfCli;
    private javax.swing.JLabel jlDadosCli;
    private javax.swing.JLabel jlDadosCompra;
    private javax.swing.JLabel jlDadosProd;
    private javax.swing.JLabel jlDadosVendedor;
    private javax.swing.JLabel jlDesconto;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlFormapag;
    private javax.swing.JLabel jlIdCli;
    private javax.swing.JLabel jlIdFunc;
    private javax.swing.JLabel jlIdNumCli;
    private javax.swing.JLabel jlItenscompra;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlNomeCli;
    private javax.swing.JLabel jlObsCli;
    private javax.swing.JLabel jlPesq;
    private javax.swing.JLabel jlPesqCli;
    private javax.swing.JLabel jlPesqProd;
    private javax.swing.JLabel jlQuantMid;
    private javax.swing.JLabel jlValorParcial;
    private javax.swing.JLabel jlValorTFinal;
    private javax.swing.JLabel jlValorTP;
    private javax.swing.JLabel jlValorTotal;
    private javax.swing.JLabel jlidNumFunc;
    private javax.swing.JScrollPane jspTabelaCli;
    private javax.swing.JScrollPane jspTabelaCompra;
    private javax.swing.JScrollPane jspTabelaCompra1;
    private javax.swing.JTable jtTabelaCli;
    private javax.swing.JTable jtTabelaCompra;
    private javax.swing.JTable jtTabelaMid;
    private javax.swing.JTextField jtfCpfCli;
    private javax.swing.JTextField jtfDesconto;
    private javax.swing.JTextField jtfEmailCli;
    private javax.swing.JTextField jtfNomeCli;
    private javax.swing.JTextField jtfNomeFunc;
    private javax.swing.JTextField jtfObsCli;
    private javax.swing.JTextField jtfPesqCli;
    private javax.swing.JTextField jtfPesqMid;
    private javax.swing.JTextField jtfQuantMid;
    // End of variables declaration//GEN-END:variables

    public void reiniciarCompra(){
        DefaultTableModel tabela = (DefaultTableModel) jtTabelaCompra.getModel();
        while(jtTabelaMid.getRowCount() > 0)
            tabela.removeRow(0);
        for(int i = listaItensCompra.size() - 1; i>-1; i--)
            listaItensCompra.remove(i);
        jlValorTotal.setText("0.00");
        jtfQuantMid.setText("");
    }
    
    public void reiniciarMid(){
        DefaultTableModel tabela = (DefaultTableModel) jtTabelaMid.getModel();
        while(tabela.getRowCount() > 0)
            tabela.removeRow(0);
        jtfPesqMid.setText("");
    }
    
    public void reiniciarCli(){
        DefaultTableModel tabela = (DefaultTableModel) jtTabelaCli.getModel();
        while(tabela.getRowCount() > 0)
            tabela.removeRow(0);
        jtfPesqCli.setText("");
        jlIdNumCli.setText("0");
        jtfNomeCli.setText("");
        jtfCpfCli.setText("");
        jtfEmailCli.setText("");
        jtfObsCli.setText("");
    }
    
    public void inicializarTela(){
        jtfNomeFunc.setEnabled(false);
        jbCancelarCompra.setEnabled(false);
        jbFinalizarCompra.setEnabled(false);
        jlValorTotal.setText("0.00");
        jlValorParcial.setText("0.00");
        jtfNomeCli.setEnabled(false);
        reiniciarCli();
        reiniciarCompra();
        reiniciarMid();
        jtfPesqMid.setEnabled(false);
        jbAdicionarMid.setEnabled(false);
        jbRemoverMid.setEnabled(false);
        jtfQuantMid.setEnabled(false);
        jtfCpfCli.setEnabled(false);
        jtfEmailCli.setEnabled(false);
        jtfObsCli.setEnabled(false);
        jlIdNumCli.setText("0");
        jcbFormapag.setEnabled(false);
        jtfDesconto.setEnabled(false);
        jtfDesconto.setText("0.00");
    }
    
    public boolean validarDados(){
        String msg = "";
        if(listaItensCompra.isEmpty())
            msg += "Verifique os itens da compra";
        if(jcbFormapag.getSelectedIndex() == 0)
            msg += "Verifique a forma de pagamento";
        if(Integer.parseInt(jlidNumFunc.getText()) == 0)
            msg += "Verifique o ID do funcionario";
        if(Integer.parseInt(jlIdNumCli.getText()) == 0)
            msg += "Verifique o cliente";
        if(Double.parseDouble(jlValorTotal.getText()) == 0.0)
            msg += "Verifique o valor total da compra";
        if(jtfDesconto.getText().equals(""))
            jtfDesconto.setText("0.00");
        if((Double.parseDouble(jtfDesconto.getText()) < 0))
            msg += "Verifique o desconto"; 
        if((Double.parseDouble(jtfDesconto.getText()) > Double.parseDouble(jlValorParcial.getText())))
            msg += "Verifique o desconto"; 
        if(msg.isEmpty())
            return true;
        else{
            JOptionPane.showMessageDialog(this, msg);
            return false;
        }
            
    }
    

    public FuncionarioModel getObj_func() {
        return obj_func;
    }

    public void setObj_func(FuncionarioModel obj_func) {
        this.obj_func = obj_func;
    }
    
    public void iniciarInfoFunc(){
        jtfNomeFunc.setText(obj_func.getNome());
        jlidNumFunc.setText("" + obj_func.getId());
    }
    
    public boolean validarCompra(){
        String msg = "";
        if(idCliente == 0)
            msg += "Selecione um cliente! \n";
        if(listaItensCompra.isEmpty())
            msg += "Não existe nenhum item na compra! \n";
        if(jcbFormapag.getSelectedIndex() == 0)
            msg += "Selecione uma forma de pagamento \n";
        if(msg.equals("")){
            JOptionPane.showMessageDialog(this, msg);
            return false;
        }   
        return true;
    }
    
    public boolean preencherObj() throws Exception{
        obj_c.setIdPessoa(Integer.parseInt(jlIdNumCli.getText()));
        obj_c.setIdFuncionario(Integer.parseInt(jlidNumFunc.getText()));
        obj_c.setValortotal(Double.parseDouble(jlValorTotal.getText()));
        obj_c.setFormapag(jcbFormapag.getSelectedItem().toString());
        obj_c.setItensCompra(listaItensCompra);
        obj_c.setDesconto(Double.parseDouble(jtfDesconto.getText()));
        return true;
    }
    
    public boolean comparar(){
        int linha = jtTabelaMid.getSelectedRow();
        int quant = Integer.parseInt(jtfQuantMid.getText());
        DefaultTableModel tabmidias = (DefaultTableModel) jtTabelaMid.getModel();
        DefaultTableModel tabitens = (DefaultTableModel) jtTabelaCompra.getModel();
        int idmidia = Integer.parseInt((String) tabmidias.getValueAt(linha, 0));
        int quant_midia = Integer.parseInt((String) tabmidias.getValueAt(linha, 2));
        for(int i=0; i<jtTabelaCompra.getRowCount(); i++){
            if(idmidia == Integer.parseInt((String) tabitens.getValueAt(i, 0))){
                int result = quant_midia - Integer.parseInt((String) tabitens.getValueAt(i, 2)) - quant;
                if(result < 0)
                    return false;
            }
        }
        if((quant_midia - quant) < 0)
            return false;
        return true;
    }
    
    public boolean atualizarValTotal(){
        if(jtfDesconto.getText().equals("") || jtfDesconto.getText().equals("")){
            jlValorTotal.setText("" + Double.parseDouble(jlValorParcial.getText()));
            return true;
        }else{
            Double desconto = Double.parseDouble(jtfDesconto.getText());
            Double valorparcial = Double.parseDouble(jlValorParcial.getText());
            if(jtfDesconto.getText().length() >= 0 && desconto > 0 && desconto <= valorparcial){
                jlValorTotal.setText("" + (valorparcial - desconto));
                return true;
            }
        }
        return false;
    }
    
    public void atualizaValTotal(){
        if(jtfDesconto.getText().equals("") || jtfDesconto.getText().equals("0.00")){
            jlValorTotal.setText("" + Double.parseDouble(jlValorParcial.getText()));
        }else{
            Double desconto = Double.parseDouble(jtfDesconto.getText());
            Double valorparcial = Double.parseDouble(jlValorParcial.getText());
            if(jtfDesconto.getText().length() >= 0 && desconto > 0 && desconto <= valorparcial){
                jlValorTotal.setText("" + (valorparcial - desconto));
            }
        }
    }
}
