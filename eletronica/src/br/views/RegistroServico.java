/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.views;
import javax.swing.ImageIcon;


import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import br.dao.ServicoDAO;
import br.beans.Servico;

import java.awt.Color;
import java.awt.event.ActionListener;

import java.util.List;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Font;
import javax.swing.JTextArea;

/**
 *
 * @author adrya
 */
public class RegistroServico extends javax.swing.JFrame {

   // private final CadastroClienteController controller;
	/**
     * Creates new form NewJFrame
     */
    public RegistroServico() {
        initComponents();
       // controller = new CadastroClienteController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setFont(new Font("Tahoma", Font.BOLD, 11));
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setFont(new Font("Tahoma", Font.BOLD, 11));
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setFont(new Font("Tahoma", Font.BOLD, 11));
        txtNome = new javax.swing.JTextField();
        txtNome.setBackground(new Color(235, 237, 241));
        txtPreco = new javax.swing.JTextField();
        txtPreco.setBackground(new Color(235, 237, 241));
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBackground(new Color(235, 237, 241));
        jButtonCadastrar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.addFocusListener(new FocusAdapter() {
 
        });
        jButtonAlterar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String nome, descricao;
        		
        		nome = txtNome.getText();
                descricao = txtDescricao.getText();
                double preco = Double.parseDouble(txtPreco.getText());
                
                Servico sev = new Servico();
                ServicoDAO sevDAO = new ServicoDAO();
                
                if(sevDAO.atualizarServico(sev)){
                    JOptionPane.showMessageDialog(null, "Alteração EFETUADA com Sucesso!","Resultado",JOptionPane.INFORMATION_MESSAGE);
                    preencherTbl();
               }else{
                    JOptionPane.showMessageDialog(null, "NAO FOI POSSÍVEL ALTERAR!","Resultado",JOptionPane.ERROR_MESSAGE);
               }
        	}
        });
        jButtonExcluir = new javax.swing.JButton();
        jButtonExcluir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	String nome, descricao;
                
            nome = txtNome.getText();
            descricao = txtDescricao.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            
  
            Servico sev = new Servico();
         
            ServicoDAO sevDAO = new ServicoDAO();
                
            if(sevDAO.excluirServico(sev)){
                 JOptionPane.showMessageDialog(null, "EXCLUSÃO EFETUADA com Sucesso!","Resultado",JOptionPane.INFORMATION_MESSAGE);
                 
                 preencherTbl();
            }else{
                 JOptionPane.showMessageDialog(null, "NAO FOI POSSÍVEL EXCLUIR!","Resultado",JOptionPane.ERROR_MESSAGE);
            }
            
        
           jButtonExcluir.setEnabled(false);
      
        	}
        });
        txtBuscarId = new javax.swing.JTextField();
        txtBuscarId.setToolTipText("Informe um Id");
        txtBuscarId.setForeground(new Color(0, 0, 0));
        jScrollPane2 = new javax.swing.JScrollPane();
        tableServicos = new javax.swing.JTable();
        tableServicos.setFont(new Font("Tahoma", Font.PLAIN, 12));
        tableServicos.setForeground(new Color(0, 0, 0));
        tableServicos.setBackground(new Color(235, 237, 241));
        tableServicos.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		int selectRow = tableServicos.getSelectedRow();
        		
        		txtNome.setText(tableServicos.getValueAt(selectRow, 1).toString());
        		txtDescricao.setText(tableServicos.getValueAt(selectRow, 2).toString());
        		txtPreco.setText(tableServicos.getValueAt(selectRow, 3).toString());
        		
        	}
        });
        tableServicos.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		jButtonExcluir.setEnabled(true);
        		jButtonAlterar.setEnabled(true);
        		btnLimpar.setEnabled(true);
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(226, 255, 128));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setForeground(new Color(55, 52, 95));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Serviço");

        jLabel2.setForeground(new Color(55, 52, 95));
        jLabel2.setText("Nome");

        jLabel3.setForeground(new Color(55, 52, 95));
        jLabel3.setText("Preço");

        jLabel4.setForeground(new Color(55, 52, 95));
        jLabel4.setText("Descrição");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButtonCadastrar.setText("Salvar");
        jButtonCadastrar.setEnabled(false);
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setEnabled(false);

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        
        JButton btnBuscar = new JButton("");
        btnBuscar.setBackground(new Color(240, 240, 240));
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		long id = Long.parseLong(txtBuscarId.getText());
        		
        		ServicoDAO sevDao = new ServicoDAO();
        		Servico sev = new Servico();
        		
        		sev = sevDao.buscarServicos(id);
        		
        		txtNome.setText(sev.getNome());
        		txtDescricao.setText(sev.getDescricao());
        		txtPreco.setText(String.valueOf(sev.getPreco()));
        		
        		
        		jButtonExcluir.setEnabled(true);
                jButtonAlterar.setEnabled(true);

        	}
        });
        btnBuscar.setIcon(new ImageIcon(RegistroServico.class.getResource("/imgsCadastro/pesquisar.png")));
       
        btnLimpar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		txtNome.setText(null);
        		txtPreco.setText(null);
        		txtDescricao.setText(null);
        		
        		btnLimpar.setEnabled(false);
        	}
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(27)
        			.addComponent(jButtonCadastrar)
        			.addGap(18)
        			.addComponent(jButtonAlterar)
        			.addGap(18)
        			.addComponent(jButtonExcluir)
        			.addGap(18)
        			.addComponent(btnLimpar)
        			.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
        			.addComponent(btnBuscar)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtBuscarId, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
        			.addGap(19))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButtonCadastrar)
        				.addComponent(jButtonAlterar)
        				.addComponent(jButtonExcluir)
        				.addComponent(txtBuscarId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnLimpar))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        tableServicos.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        	},
        	new String[] {
        		"Nome", "Pre\u00E7o", "Descri\u00E7\u00E3o"
        	}
        ));
        tableServicos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tableServicos.getColumnModel().getColumn(0).setMinWidth(50);
        tableServicos.getColumnModel().getColumn(1).setPreferredWidth(60);
        tableServicos.getColumnModel().getColumn(1).setMinWidth(60);
        jScrollPane2.setViewportView(tableServicos);
        
        txtDescricao = new JTextArea();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(jLabel2)
        						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel3))
        					.addGap(259))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        					.addContainerGap())))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel4)
        			.addContainerGap(505, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(jLabel3))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel4)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
        			.addGap(26)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //executa quando clica no botão
    	String nome, descricao;
    	
  
    	nome = txtNome.getText();
    	descricao = txtDescricao.getText();
    	double preco = Double.parseDouble(txtPreco.getText());
    	
    	
    	long eventMask = 0;
		Servico sev = new Servico(eventMask, nome, descricao, preco);
		ServicoDAO sevDAO = new ServicoDAO();
    	
    	 if(sevDAO.inserirServico(sev)){	
    		 
             JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!","Resultado",JOptionPane.INFORMATION_MESSAGE);
             
             txtNome.setText(null);
             txtDescricao.setText(null);
         	 txtPreco.setText(null);
         
         	 preencherTbl();
         	
         }else{
             JOptionPane.showMessageDialog(null, "NAO FOI POSSÍVEL CADASTRAR!","Resultado",JOptionPane.ERROR_MESSAGE);
         }
    	 
    	 jButtonCadastrar.setEnabled(true);
    	
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */     
    public void preencherTbl() {
    	ServicoDAO sevDAO = new ServicoDAO();
    	List<Servico> lista = sevDAO.listarServicos();
    	
    	DefaultTableModel modelo = (DefaultTableModel) tableServicos.getModel();
    	modelo.setRowCount(0);
    	
    	for (Servico sev : lista) {
    		modelo.addRow(new Object[]{sev.getId(),sev.getNome(), sev.getDescricao(), sev.getPreco()});
    	}
    }
    
    
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
            java.util.logging.Logger.getLogger(RegistroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableServicos;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtBuscarId;
    private JTextArea txtDescricao;
    // End of variables declaration//GEN-END:variables
	public void exibeMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public javax.swing.JTextField getjTextFieldNome() {
		return txtNome;
	}

	public void setjTextFieldNome(javax.swing.JTextField jTextFieldNome) {
		this.txtNome = jTextFieldNome;
	}

	public javax.swing.JTextField getjTextEndereco() {
		return txtPreco;
	}

	public void setjTextEndereco(javax.swing.JTextField jTextEndereco) {
		this.txtPreco = jTextEndereco;
	}

	public JTextArea getTxtDescricao() {
		return txtDescricao;
	}

	public void setTxtDescricao(JTextArea txtDescricao) {
		this.txtDescricao = txtDescricao;
	}


}
