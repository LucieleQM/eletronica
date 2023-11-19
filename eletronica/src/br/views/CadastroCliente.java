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

//import controller.CadastroClienteController;
import br.dao.ClienteDAO;
import br.beans.Cliente;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Font;

/**
 *
 * @author adrya
 */
public class CadastroCliente extends javax.swing.JFrame {

   // private final CadastroClienteController controller;
	/**
     * Creates new form NewJFrame
     */
    public CadastroCliente() {
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
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setFont(new Font("Tahoma", Font.BOLD, 11));
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setFont(new Font("Tahoma", Font.BOLD, 11));
        txtNome = new javax.swing.JTextField();
        txtNome.setBackground(new Color(235, 237, 241));
        txtEndereco = new javax.swing.JTextField();
        txtEndereco.setBackground(new Color(235, 237, 241));
        txtCpf = new javax.swing.JTextField();
        txtCpf.setBackground(new Color(235, 237, 241));
        txtEmail = new javax.swing.JTextField();
        txtEmail.setBackground(new Color(235, 237, 241));
        txtTelefone = new javax.swing.JTextField();
        txtTelefone.setBackground(new Color(235, 237, 241));
        txtTelefone.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		jButtonCadastrar.setEnabled(true);
        	}
        });
        jLabel8 = new javax.swing.JLabel();
        jLabel8.setIcon(new ImageIcon(CadastroCliente.class.getResource("/imgsCadastro/cliente.png")));
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBackground(new Color(235, 237, 241));
        jButtonCadastrar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.addFocusListener(new FocusAdapter() {
 
        });
        jButtonAlterar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String nome, cpf, endereco, telefone, email;
        		
        		nome = txtNome.getText();
                cpf = txtCpf.getText();
                endereco = txtEndereco.getText();
                telefone = txtTelefone.getText();
                email = txtEmail.getText();
                
                Cliente cli = new Cliente(0, nome,cpf, endereco, telefone,email);
                
                ClienteDAO cliDAO = new ClienteDAO();
                
                if(cliDAO.atualizarCliente(cli)){
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
        		
        	String nome, cpf, endereco, telefone, email;
                
            nome = txtNome.getText();
            cpf = txtCpf.getText();
            endereco = txtEndereco.getText();
            telefone = txtTelefone.getText();
            email = txtEmail.getText();
  
            Cliente cli = new Cliente(0, nome,cpf, endereco, telefone,email);
                
            ClienteDAO cliDAO = new ClienteDAO();
                
            if(cliDAO.excluirCliente(cli)){
                 JOptionPane.showMessageDialog(null, "EXCLUSÃO EFETUADA com Sucesso!","Resultado",JOptionPane.INFORMATION_MESSAGE);
                 
                 preencherTbl();
            }else{
                 JOptionPane.showMessageDialog(null, "NAO FOI POSSÍVEL EXCLUIR!","Resultado",JOptionPane.ERROR_MESSAGE);
            }
            
        
           jButtonExcluir.setEnabled(false);
      
        	}
        });
        txtBuscarCpf = new javax.swing.JTextField();
        txtBuscarCpf.setToolTipText("Informe um Cpf");
        txtBuscarCpf.setForeground(new Color(0, 0, 0));
        jScrollPane2 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        tableClientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
        tableClientes.setForeground(new Color(240, 240, 240));
        tableClientes.setBackground(new Color(235, 237, 241));
        tableClientes.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		int selectRow = tableClientes.getSelectedRow();
        		
        		txtNome.setText(tableClientes.getValueAt(selectRow, 1).toString());
        		txtCpf.setText(tableClientes.getValueAt(selectRow, 2).toString());
        		txtEndereco.setText(tableClientes.getValueAt(selectRow, 3).toString());
        		txtTelefone.setText(tableClientes.getValueAt(selectRow, 4).toString());
        		txtEmail.setText(tableClientes.getValueAt(selectRow, 5).toString());
        		
        		
        	}
        });
        tableClientes.addFocusListener(new FocusAdapter() {
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
        jLabel1.setText("Cadastro de Cliente");

        jLabel2.setForeground(new Color(55, 52, 95));
        jLabel2.setText("Nome");

        jLabel3.setForeground(new Color(55, 52, 95));
        jLabel3.setText("Endereço");

        jLabel4.setForeground(new Color(55, 52, 95));
        jLabel4.setText("Cpf");

        jLabel5.setForeground(new Color(55, 52, 95));
        jLabel5.setText("Telefone");

        jLabel6.setForeground(new Color(55, 52, 95));
        jLabel6.setText("Email");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setBorder(new LineBorder(new Color(0, 0, 0), 0));

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
        		
        		String cpf = txtBuscarCpf.getText();
        		
        		ClienteDAO cliDao = new ClienteDAO();
        		Cliente cli = new Cliente();
        		
        		cli = cliDao.buscarClientes(cpf);
        		
        		txtNome.setText(cli.getNome());
        		txtCpf.setText(cli.getCpf());
        		txtEndereco.setText(cli.getEndereco());
        		txtTelefone.setText(cli.getTelefone());
        		txtEmail.setText(cli.getEmail());
        		
        		jButtonExcluir.setEnabled(true);
                jButtonAlterar.setEnabled(true);

        	}
        });
        btnBuscar.setIcon(new ImageIcon(CadastroCliente.class.getResource("/imgsCadastro/pesquisar.png")));
       
        btnLimpar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		txtNome.setText(null);
        		txtCpf.setText(null);
        		txtEndereco.setText(null);
        		txtTelefone.setText(null);
        		txtEmail.setText(null);
        		
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
        			.addComponent(txtBuscarCpf, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
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
        				.addComponent(txtBuscarCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnLimpar))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        tableClientes.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"Id", "Nome", "Cpf", "Endereco", "Telefone", "Email"
        	}
        ));
        tableClientes.getColumnModel().getColumn(0).setPreferredWidth(40);
        tableClientes.getColumnModel().getColumn(1).setPreferredWidth(90);
        tableClientes.getColumnModel().getColumn(3).setPreferredWidth(90);
        jScrollPane2.setViewportView(tableClientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(20)
        					.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
        					.addGap(23)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(jLabel2, Alignment.LEADING)
        								.addComponent(jLabel6, Alignment.LEADING)
        								.addComponent(txtNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        								.addComponent(txtEndereco, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        								.addComponent(txtEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
        							.addGap(18))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel3)
        							.addPreferredGap(ComponentPlacement.RELATED)))
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(jLabel4)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel5)
        								.addComponent(txtTelefone, 142, 142, Short.MAX_VALUE)))
        						.addComponent(txtCpf))
        					.addContainerGap())
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(10)
        					.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel2)
        						.addComponent(jLabel4))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(3)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel3)
        						.addComponent(jLabel5))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jLabel6))
        						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(18)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
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

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //executa quando clica no botão
    	String nome, cpf, endereco, telefone, email;
    	
    	nome = txtNome.getText();
    	cpf = txtCpf.getText();
    	endereco = txtEndereco.getText();
    	telefone = txtTelefone.getText();
    	email = txtEmail.getText();
    	
    	
    	long eventMask = 0;
		Cliente cli = new Cliente(eventMask, nome, cpf, endereco, telefone, email);
    	ClienteDAO cliDAO = new ClienteDAO();
    	
    	 if(cliDAO.inserirCliente(cli)){	
    		 
             JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!","Resultado",JOptionPane.INFORMATION_MESSAGE);
             
             txtNome.setText(null);
         	 txtCpf.setText(null);
         	 txtEndereco.setText(null);
         	 txtTelefone.setText(null);
         	 txtEmail.setText(null);
         	 
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
    	ClienteDAO cliDAO = new ClienteDAO();
    	List<Cliente> lista = cliDAO.listarClientes();
    	
    	DefaultTableModel modelo = (DefaultTableModel) tableClientes.getModel();
    	modelo.setRowCount(0);
    	
    	for (Cliente cliente : lista) {
    		modelo.addRow(new Object[]{cliente.getId(),cliente.getNome(), cliente.getCpf(), cliente.getEndereco(), 
    					cliente.getTelefone(), cliente.getEmail()});
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
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCliente().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtBuscarCpf;
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
		return txtEndereco;
	}

	public void setjTextEndereco(javax.swing.JTextField jTextEndereco) {
		this.txtEndereco = jTextEndereco;
	}

	public javax.swing.JTextField getjTextFieldCpf() {
		return txtCpf;
	}

	public void setjTextFieldCpf(javax.swing.JTextField jTextFieldCpf) {
		this.txtCpf = jTextFieldCpf;
	}

	public javax.swing.JTextField getjTextFieldEmail() {
		return txtEmail;
	}

	public void setjTextFieldEmail(javax.swing.JTextField jTextFieldEmail) {
		this.txtEmail = jTextFieldEmail;
	}

	public javax.swing.JTextField getjTextFieldTelefone() {
		return txtTelefone;
	}

	public void setjTextFieldTelefone(javax.swing.JTextField jTextFieldTelefone) {
		this.txtTelefone = jTextFieldTelefone;
	}
}
