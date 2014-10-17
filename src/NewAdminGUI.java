
import java.awt.BorderLayout;

import javax.swing.JScrollPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class NewAdminGUI extends javax.swing.JFrame {

	private ProjectTableController projectTableController; 
	private FilesTableController fileTableController; 
	private PeopleTableController peopleTableController; 

    public NewAdminGUI() {
        
        projectTableController = new ProjectTableController(this);
        fileTableController = new FilesTableController(this);
        peopleTableController = new PeopleTableController(this);
        initComponents();
        addProjectTable();
        addFileTable();
        addPeopleTable();
    }

    public void addProjectTable() {
    	// add the data and column names to a JTable  
	    projectTable = new javax.swing.JTable(projectTableController.getTableModel());
    	projectTable.removeColumn(projectTable.getColumnModel().getColumn(0));
    	projectTable.removeColumn(projectTable.getColumnModel().getColumn(8));
	    
		// add a ListSelectionListener to the table
	    projectTable.getSelectionModel().addListSelectionListener(projectTableController);
		
		// add the table to a scrollpane
		JScrollPane scrollpane = new JScrollPane(projectTable);
	
		// create a window
		projectTablePanel.setLayout(new BorderLayout());
		projectTablePanel.add(scrollpane, BorderLayout.CENTER);
	}
    
    public void addFileTable() {
    	// add the data and column names to a JTable  
	    fileTable = new javax.swing.JTable(fileTableController.getTableModel());
	    
		// add a ListSelectionListener to the table
	    fileTable.getSelectionModel().addListSelectionListener(fileTableController);
		
		// add the table to a scrollpane
		JScrollPane scrollpane = new JScrollPane(fileTable);
	
		// create a window
		fileTablePanel.setLayout(new BorderLayout());
		fileTablePanel.add(scrollpane, BorderLayout.CENTER);
	}
    
    public void addPeopleTable() {
    	// add the data and column names to a JTable  
	    peopleTable = new javax.swing.JTable(peopleTableController.getTableModel());
	    
		// add a ListSelectionListener to the table
	    peopleTable.getSelectionModel().addListSelectionListener(peopleTableController);
		
		// add the table to a scrollpane
		JScrollPane scrollpane = new JScrollPane(peopleTable);
	
		// create a window
		peopleTablePanel.setLayout(new BorderLayout());
		peopleTablePanel.add(scrollpane, BorderLayout.CENTER);
	}
    
    public void updateTable() {
    	projectTable.setModel(projectTableController.getTableModel());
    	projectTable.removeColumn(projectTable.getColumnModel().getColumn(0));
    	projectTable.removeColumn(projectTable.getColumnModel().getColumn(8));
    }
    
    public void updateFileTable() {
    	fileTable.setModel(fileTableController.getTableModel());
    }
    
    public void updatePeopleTable() {
    	peopleTable.setModel(peopleTableController.getTableModel());
    }

    public void updateFileComboBox() {
    	fileprojectNameComboBox.removeAllItems();
    	String[] file_projName_strArray = projectTableController.getProjNameComboBoxesData();
    	for(String str : file_projName_strArray) {
    		fileprojectNameComboBox.addItem(str);
    	}
    }
    
    public void updatePeopleComboBox() {
    	peopleProjectComboBox.removeAllItems();
    	String[] people_projName_strArray = projectTableController.getProjNameComboBoxesData();
    	for(String str : people_projName_strArray) {
    		peopleProjectComboBox.addItem(str);
    	}
    }
    
    public void setProjNameTextField(String value) {
    	projectNameTextField.setText(value);
    }
    
    public void setCategoryTextField(String value) {
    	categoryTextField.setText(value);
    }

    public void setStatusComboBox(String value) {
    	statusComboBox.setSelectedItem(value);
    }
    
    public void setOutcomeTextField(String value) {
    	outcomeTextField.setText(value);
    }
    
    public void setScopeTextField(String value) {
    	scopeTextField.setText(value);
    }
    
    public void setFromDateTextField(String value) {
    	fromDateTextField.setText(value);
    }
    
    public void setToDateTextField(String value) {
    	toDateTextField.setText(value);
    }
    
 // file tab
    public void setFile_projNameComboBox(String projID) {
    	//int index = fileprojectNameComboBox.getSelectedIndex();
    	//fileprojectNameComboBox.setSelectedItem(projectTableController.getTableModel().getValueAt(index,1).toString());
    }
    
    public void setFile_fileNameTextField(String value) {
    	fileNameTextField.setText(value);
    }
    
    public void setFile_fileFormatTextField(String value) {
    	fileFormatTextField.setText(value);
    }
    
    public void setFile_fileLocationTextField(String value) {
    	fileLocationTextField.setText(value);
    }
    
 // people tab
    public void setPeople_projNameComboBox(String projID) {
    	//int index = fileprojectNameComboBox.getSelectedIndex();
    	//fileprojectNameComboBox.setSelectedItem(projectTableController.getTableModel().getValueAt(index,1).toString());
    }
    
    public void setPeople_peopleNameTextField(String value) {
    	peopleNameTextField.setText(value);
    }
    
    public void setPeople_peopleRoleTextField(String value) {
    	roleTextField.setText(value);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        FooterPanel = new javax.swing.JPanel();
        HeaderPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TabPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        projectNameLabel = new javax.swing.JLabel();
        projectNameTextField = new javax.swing.JTextField();
        categoryLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox();
        fromDateLabel = new javax.swing.JLabel();
        fromDateTextField = new javax.swing.JTextField();
        scopeLabel = new javax.swing.JLabel();
        categoryTextField = new javax.swing.JTextField();
        scopeTextField = new javax.swing.JTextField();
        outcomeLabel = new javax.swing.JLabel();
        outcomeTextField = new javax.swing.JTextField();
        toDateLabel = new javax.swing.JLabel();
        toDateTextField = new javax.swing.JTextField();
        projectAddButton = new javax.swing.JButton();
        projectEditButton = new javax.swing.JButton();
        projectDeleteButton = new javax.swing.JButton();
        projectTablePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        project_fileNameLabel = new javax.swing.JLabel();
        fileNameLabel = new javax.swing.JLabel();
        fileFormatTextField = new javax.swing.JTextField();
        fileFormatLabel = new javax.swing.JLabel();
        fileNameTextField = new javax.swing.JTextField();
        fileAddButton = new javax.swing.JButton();
        fileEditButton = new javax.swing.JButton();
        fileDeleteButton = new javax.swing.JButton();
        fileLocationLabel = new javax.swing.JLabel();
        fileLocationTextField = new javax.swing.JTextField();
        fileprojectNameComboBox = new javax.swing.JComboBox();
        fileTablePanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        project_peopleNameLabel = new javax.swing.JLabel();
        peopleNameLabel = new javax.swing.JLabel();
        peopleNameTextField = new javax.swing.JTextField();
        peopleRoleLabel = new javax.swing.JLabel();
        roleTextField = new javax.swing.JTextField();
        peopleProjectComboBox = new javax.swing.JComboBox();
        peopleAddButton = new javax.swing.JButton();
        peopleEditButton = new javax.swing.JButton();
        peopleDeleteButton = new javax.swing.JButton();
        peopleTablePanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        adminsearchButton = new javax.swing.JButton();
        adminCancelButton = new javax.swing.JButton();
        adminLogoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        HeaderPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Candara", 1, 48)); // NOI18N
        jLabel5.setText("FrugaInnovation");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header.PNG")));

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addGap(10, 10, 10)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scu_footer.PNG"))); // NOI18N
        jLabel7.setText("jLabel3");

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N

        projectNameLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        projectNameLabel.setText("Project Name");

        projectNameTextField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        projectNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectNameTextFieldActionPerformed(evt);
            }
        });

        categoryLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        categoryLabel.setText("Category");

        categoryTextField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        //categoryTextField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categoryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryTextFieldActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        statusLabel.setText("Status");

        statusComboBox.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        statusComboBox.setPreferredSize(new java.awt.Dimension(56, 24));

        fromDateLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        fromDateLabel.setText("Start Date");

        fromDateTextField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        fromDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromDateTextFieldActionPerformed(evt);
            }
        });

        scopeLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        scopeLabel.setText("Scope");

        scopeTextField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        //scopeTextField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        scopeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scopeTextFieldActionPerformed(evt);
            }
        });

        outcomeLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        outcomeLabel.setText("Outcome");

        outcomeTextField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N

        toDateLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        toDateLabel.setText("End Date");

        toDateTextField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N

        projectAddButton.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        projectAddButton.setText("Add");
        projectAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectAddButtonActionPerformed(evt);
            }
        });

        projectEditButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        projectEditButton.setText("Update");
        projectEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectEditButtonActionPerformed(evt);
            }
        });

        projectDeleteButton.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        projectDeleteButton.setText("Delete");
        projectDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectDeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout projectTablePanelLayout = new javax.swing.GroupLayout(projectTablePanel);
        projectTablePanel.setLayout(projectTablePanelLayout);
        projectTablePanelLayout.setHorizontalGroup(
            projectTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        projectTablePanelLayout.setVerticalGroup(
            projectTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
		
        jPanel1.setBackground(new java.awt.Color(150, 170, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        	.addComponent(projectNameLabel)
                            .addComponent(categoryLabel)
                        	.addComponent(statusLabel)
                            .addComponent(outcomeLabel)
                            .addComponent(scopeLabel)
                            .addComponent(fromDateLabel)
                            .addComponent(toDateLabel))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        	.addComponent(projectNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        	.addComponent(categoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        	.addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        	.addComponent(outcomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scopeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fromDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(projectTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                        	.addGap(20, 20, 20)
                    		.addComponent(projectAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
	                		.addGap(20, 20, 20)
	                		.addComponent(projectEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
	                	.addGroup(jPanel1Layout.createSequentialGroup()
                			.addGap(20, 20, 20)
	                		.addComponent(projectDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                    	.addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(projectNameLabel)
                                    .addComponent(projectNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            		.addComponent(categoryLabel)
                                    .addComponent(categoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            		.addComponent(statusLabel)
                                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            		.addComponent(outcomeLabel)
                                    .addComponent(outcomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            		.addComponent(scopeLabel)
                                    .addComponent(scopeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            		.addComponent(fromDateLabel)
                            		.addComponent(fromDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))       
                        		.addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            		.addComponent(toDateLabel)
                                    .addComponent(toDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            		.addComponent(projectAddButton)
                                    .addComponent(projectEditButton))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            		.addComponent(projectDeleteButton)))
                            .addComponent(projectTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            )))));

        jTabbedPane2.addTab("Project Details", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        project_fileNameLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        project_fileNameLabel.setText("Project Name");

        fileNameLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        fileNameLabel.setText("File Name");

        fileFormatTextField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        fileFormatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileFormatTextFieldActionPerformed(evt);
            }
        });

        fileFormatLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        fileFormatLabel.setText("File Format");

        fileNameTextField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        fileNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileNameTextFieldActionPerformed(evt);
            }
        });

        fileAddButton.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        fileAddButton.setText("Add");
        fileAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileAddButtonActionPerformed(evt);
            }
        });

        fileEditButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        fileEditButton.setText("Update");
        fileEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileEditButtonActionPerformed(evt);
            }
        });

        fileDeleteButton.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        fileDeleteButton.setText("Delete");
        fileDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileDeleteButtonActionPerformed(evt);
            }
        });

        fileLocationLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        fileLocationLabel.setText("File Location");

        fileLocationTextField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        fileLocationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileLocationTextFieldActionPerformed(evt);
            }
        });

        fileprojectNameComboBox.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        fileprojectNameComboBox.setPreferredSize(new java.awt.Dimension(56, 24));
        
        String[] file_projName_strArray = projectTableController.getProjNameComboBoxesData();

    	for(String str : file_projName_strArray) {
    		fileprojectNameComboBox.addItem(str);
    	}
    	
    	fileprojectNameComboBox.setSelectedIndex(-1);
    	
    	
    	fileprojectNameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileprojectNameComboBoxActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout fileTablePanelLayout = new javax.swing.GroupLayout(fileTablePanel);
        fileTablePanel.setLayout(fileTablePanelLayout);
        fileTablePanelLayout.setHorizontalGroup(
            fileTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        fileTablePanelLayout.setVerticalGroup(
            fileTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(150, 170, 153));
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
        		jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        		.addComponent(project_fileNameLabel)
                                .addComponent(fileNameLabel)
                            	.addComponent(fileFormatLabel)
                                .addComponent(fileLocationLabel))
                            .addGap(10, 10, 10)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        		.addComponent(fileprojectNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            	.addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            	.addComponent(fileFormatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fileLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addComponent(fileTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                            	.addGap(20, 20, 20)
                        		.addComponent(fileAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
    	                		.addGap(20, 20, 20)
    	                		.addComponent(fileEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
    	                	.addGroup(jPanel2Layout.createSequentialGroup()
                    			.addGap(20, 20, 20)
    	                		.addComponent(fileDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                    		.addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(project_fileNameLabel)
                            .addComponent(fileprojectNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fileFormatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileFormatLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fileLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileLocationLabel))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    		.addComponent(fileAddButton)
                            .addComponent(fileEditButton))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    		.addComponent(fileDeleteButton)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fileTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addGap(24, 24, 24)))
                .addGap(12, 12, 12))
        );

        jTabbedPane2.addTab("Files", jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        project_peopleNameLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        project_peopleNameLabel.setText("Project Name");

        peopleNameLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        peopleNameLabel.setText("People Name");

        peopleNameTextField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        peopleNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleNameTextFieldActionPerformed(evt);
            }
        });

        peopleRoleLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        peopleRoleLabel.setText("Role");

        roleTextField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        roleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleTextFieldActionPerformed(evt);
            }
        });

        
        peopleAddButton.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        peopleAddButton.setText("Add");
        peopleAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleAddButtonActionPerformed(evt);
            }
        });
        peopleProjectComboBox.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        peopleProjectComboBox.setPreferredSize(new java.awt.Dimension(56, 24));
        
        String[] people_projName_strArray = projectTableController.getProjNameComboBoxesData();

    	for(String str : people_projName_strArray) {
    		peopleProjectComboBox.addItem(str);
    	}
    	
    	peopleProjectComboBox.setSelectedIndex(-1);
        peopleProjectComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleProjectComboBoxActionPerformed(evt);
            }
        });

        peopleEditButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        peopleEditButton.setText("Update");
        peopleEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleEditButtonActionPerformed(evt);
            }
        });

        peopleDeleteButton.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        peopleDeleteButton.setText("Delete");
        peopleDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleDeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout peopleTablePanelLayout = new javax.swing.GroupLayout(peopleTablePanel);
        peopleTablePanel.setLayout(peopleTablePanelLayout);
        peopleTablePanelLayout.setHorizontalGroup(
            peopleTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        peopleTablePanelLayout.setVerticalGroup(
            peopleTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(150, 170, 153));
        
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
        		jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        		.addComponent(project_peopleNameLabel)
                                .addComponent(peopleNameLabel)
                            	.addComponent(peopleRoleLabel))
                            .addGap(10, 10, 10)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        		.addComponent(peopleProjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            	.addComponent(peopleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            	.addComponent(roleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addComponent(peopleTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                            	.addGap(20, 20, 20)
                        		.addComponent(peopleAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
    	                		.addGap(20, 20, 20)
    	                		.addComponent(peopleEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
    	                	.addGroup(jPanel5Layout.createSequentialGroup()
                    			.addGap(20, 20, 20)
    	                		.addComponent(peopleDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(project_peopleNameLabel)
                            .addComponent(peopleProjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(peopleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(peopleNameLabel))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(peopleRoleLabel)))
                    .addComponent(peopleTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
	             .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            		.addComponent(peopleAddButton)
                    .addComponent(peopleEditButton))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            		.addComponent(peopleDeleteButton))
                .addGap(68, 68, 68))
        );

        jTabbedPane2.addTab("People", jPanel5);
		
		TabPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout TabPanelLayout = new javax.swing.GroupLayout(TabPanel);
        TabPanel.setLayout(TabPanelLayout);
        TabPanelLayout.setHorizontalGroup(
            TabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        TabPanelLayout.setVerticalGroup(
            TabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        adminsearchButton.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        adminsearchButton.setText("Search");
        adminsearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminsearchButtonActionPerformed(evt);
            }
        });

        adminCancelButton.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        adminCancelButton.setText("Cancel");
        adminCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminCancelButtonActionPerformed(evt);
            }
        });

        adminLogoutButton.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        adminLogoutButton.setText("Logout");
        adminLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLogoutButtonActionPerformed(evt);
            }
        });

       jPanel7.setBackground(new java.awt.Color(150, 170, 153));
        
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(620, 620, 620)
                .addComponent(adminsearchButton)
                .addGap(38, 38, 38)
                .addComponent(adminLogoutButton)
                .addGap(30, 30, 30)
                .addComponent(adminCancelButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                //.addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminsearchButton)
                    .addComponent(adminCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminLogoutButton))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FooterPanelLayout = new javax.swing.GroupLayout(FooterPanel);
        FooterPanel.setLayout(FooterPanelLayout);
        FooterPanelLayout.setHorizontalGroup(
            FooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FooterPanelLayout.createSequentialGroup()
                .addGroup(FooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HeaderPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TabPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        FooterPanelLayout.setVerticalGroup(
            FooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FooterPanelLayout.createSequentialGroup()
                .addComponent(HeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(TabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        getContentPane().add(FooterPanel);

        pack();
    }// </editor-fold>                        

    private void projectNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void categoryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void fromDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void scopeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void fileFormatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void fileNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void peopleNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void roleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void adminsearchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    	SearchesGUI.main(null);
    }                                                 

    private void projectAddButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    	String[] array = new String[11];
    	array[0] = "0";
    	array[1] = projectNameTextField.getText();
    	array[2] = fromDateTextField.getText();
    	array[3] = toDateTextField.getText();
    	array[4] = scopeTextField.getText();
    	array[5] = statusComboBox.getSelectedItem().toString();
    	array[6] = categoryTextField.getText();
    	array[7] = outcomeTextField.getText();
    	array[8] = "2014-06-11";
    	array[9] = "Yuanfeng";
    	
    	projectTableController.addRow(array);
    }                                                

    private void projectEditButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    	String[] array = new String[11];
    	array[0] = "0";
    	array[1] = projectNameTextField.getText();
    	array[2] = fromDateTextField.getText();
    	array[3] = toDateTextField.getText();
    	array[4] = scopeTextField.getText();
    	array[5] = statusComboBox.getSelectedItem().toString();
    	array[6] = categoryTextField.getText();
    	array[7] = outcomeTextField.getText();
    	array[8] = "2014-06-11";
    	array[9] = "Yuanfeng";
    	
    	projectTableController.updateRow(array);
    }                                                 

    private void projectDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    	projectTableController.deleteRow(projectNameTextField.getText());
    }                                                   

    private void fileAddButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    	int index = fileprojectNameComboBox.getSelectedIndex();
    	String projID = projectTableController.getTableModel().getValueAt(index,0).toString();
    	String[] array = new String[6];
        array[0] = "0";
        array[1] = projID;
        array[2] = fileFormatTextField.getText();
        array[3] = fileNameTextField.getText();
        array[4] = fileLocationTextField.getText();
        
        fileTableController.addRow(array);
    }                                             

    private void fileEditButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    	int index = fileprojectNameComboBox.getSelectedIndex();
    	String projID = projectTableController.getTableModel().getValueAt(index,0).toString();
    	String[] array = new String[6];
        array[0] = "0";
        array[1] = projID;
        array[2] = fileFormatTextField.getText();
        array[3] = fileNameTextField.getText();
        array[4] = fileLocationTextField.getText();
        
        fileTableController.updateRow(array);
    }                                              

    private void fileDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	fileTableController.deleteRow(fileNameTextField.getText());
    }                                                

    private void fileLocationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    private void peopleAddButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    	int index = peopleProjectComboBox.getSelectedIndex();
    	String projID = projectTableController.getTableModel().getValueAt(index,0).toString();
    	String[] array = new String[6];
        array[0] = "0";
        array[1] = peopleNameTextField.getText();
        array[2] = projID;
        array[3] = roleTextField.getText();
    	peopleTableController.addRow(array);
    }                                               

    private void peopleEditButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    	int index = peopleProjectComboBox.getSelectedIndex();
    	String projID = projectTableController.getTableModel().getValueAt(index,0).toString();
    	String[] array = new String[6];
        array[0] = "0";
        array[1] = peopleNameTextField.getText();
        array[2] = projID;
        array[3] = roleTextField.getText();
        
        peopleTableController.updateRow(array);
    }                                                

    private void peopleDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    	peopleTableController.deleteRow(peopleNameTextField.getText());
    }                                                  

    private void adminLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    	this.setVisible(false);
    	LoginGUI.showGUI();
    }                                                 

    private void adminCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    	this.setVisible(false);
    }                                                 

    private void fileprojectNameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    	int index = fileprojectNameComboBox.getSelectedIndex();
    	if (index != -1) {
	    	String projID = projectTableController.getTableModel().getValueAt(index,0).toString();
	    	fileTableController.filterFileList(projID);
	    	updateFileTable();
	    	
    	}
    } 
    
    private void peopleProjectComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    	int index = peopleProjectComboBox.getSelectedIndex();
    	if (index != -1) {
	    	String projID = projectTableController.getTableModel().getValueAt(index,0).toString();
	    	peopleTableController.filterPeopleList(projID);
	    	//System.out.println(projID);
	    	updatePeopleTable();
    	}
    	
    } 
    
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
            java.util.logging.Logger.getLogger(NewAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewAdminGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JPanel TabPanel;
    private javax.swing.JButton adminCancelButton;
    private javax.swing.JButton adminLogoutButton;
    private javax.swing.JButton adminsearchButton;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JButton fileAddButton;
    private javax.swing.JButton fileDeleteButton;
    private javax.swing.JButton fileEditButton;
    private javax.swing.JLabel fileFormatLabel;
    private javax.swing.JTextField fileFormatTextField;
    private javax.swing.JLabel fileLocationLabel;
    private javax.swing.JTextField fileLocationTextField;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JPanel fileTablePanel;
    private javax.swing.JComboBox fileprojectNameComboBox;
    private javax.swing.JLabel fromDateLabel;
    private javax.swing.JTextField fromDateTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel outcomeLabel;
    private javax.swing.JTextField outcomeTextField;
    private javax.swing.JButton peopleAddButton;
    private javax.swing.JButton peopleDeleteButton;
    private javax.swing.JButton peopleEditButton;
    private javax.swing.JLabel peopleNameLabel;
    private javax.swing.JTextField peopleNameTextField;
    private javax.swing.JComboBox peopleProjectComboBox;
    private javax.swing.JLabel peopleRoleLabel;
    private javax.swing.JPanel peopleTablePanel;
    private javax.swing.JButton projectAddButton;
    private javax.swing.JButton projectDeleteButton;
    private javax.swing.JButton projectEditButton;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JTextField projectNameTextField;
    private javax.swing.JPanel projectTablePanel;
    private javax.swing.JLabel project_fileNameLabel;
    private javax.swing.JLabel project_peopleNameLabel;
    private javax.swing.JTextField roleTextField;
    private javax.swing.JLabel scopeLabel;
    private javax.swing.JComboBox statusComboBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel toDateLabel;
    private javax.swing.JTextField toDateTextField;
    private javax.swing.JTextField categoryTextField;
    private javax.swing.JTextField scopeTextField;
    private javax.swing.JTable projectTable;
    private javax.swing.JTable fileTable;
    private javax.swing.JTable peopleTable;
    // End of variables declaration                   
}
