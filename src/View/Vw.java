package View;

import Controller.Ctr;
import java.util.LinkedList;
import javax.swing.*;

public class Vw extends javax.swing.JFrame {
    
    private Ctr control;
    private final LinkedList<String> StoredData;
    private boolean CheckNewPolitical = true;
    
    public Vw() {
        initComponents();
        this.StoredData = new LinkedList<>();
        Combobox.setEditable(true);
    }
   
    public void SetControllerObject(Ctr Recieve){
        control = Recieve;
    }
    
    public String[] getData(){
        String[] StoreData = {Name.getText(), SurName.getText(), Education.getText(), getSelectedCombobox()};
        return StoreData;
    }
    
    public void CheckConnecting(int chk){
        if(chk == 1){
            UpdateCombobox();
            ShowCorrectMessage();
        } else {
            CannotConnectDBWarning();
        }
    }
    
    private void StartCalculating(){
        if(StoredData.size() < 11 || CheckNewPolitical){
            control.InputToDataBase();
        } else {
            PolicicalFullWarning();
        }
    }
    
    private void ClearTextField(){
        Name.setText("");
        SurName.setText("");
        Education.setText("");
        Combobox.setSelectedIndex(-1);
    }
    
    private void ShowCorrectMessage(){
        JFrame frame = new JFrame("Show Message Dialog");
        JOptionPane.showMessageDialog(frame, "You is one of political party now!");
    }
    
    private void CannotConnectDBWarning(){
        JOptionPane.showMessageDialog(null, "Name, Surname or Education Uncorrect. Please try again", "Ploblem", JOptionPane.INFORMATION_MESSAGE);
        ClearTextField();
    }
    
    private void PolicicalFullWarning(){
        JOptionPane.showMessageDialog(null, "Political Full. Please try again", "Ploblem", JOptionPane.INFORMATION_MESSAGE);
        ClearTextField();
    }
    
    private String getSelectedCombobox(){
        return Combobox.getSelectedItem().toString();
    }
    
    private void UpdateCombobox(){
        String TextAdd = getSelectedCombobox();
        
        if(StoredData.isEmpty()){
            StoredData.add(TextAdd);
            Combobox.addItem(TextAdd);
        } else {
            boolean check = true;
            
            for(int i = 0; i < StoredData.size(); i++){
                if(StoredData.get(i).equals(TextAdd)){
                    check = false;
                    break;
                } else {                  
                    check = true;
                }
            }
            
            if(check){
                StoredData.add(TextAdd);
                Combobox.addItem(TextAdd);
            } 
                CheckNewPolitical = check;
        }
    ClearTextField();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Political_Party_Text = new javax.swing.JLabel();
        Name_Text = new javax.swing.JLabel();
        SurName_Text = new javax.swing.JLabel();
        Education_Text = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        SurName = new javax.swing.JTextField();
        Education = new javax.swing.JTextField();
        Combobox = new javax.swing.JComboBox<>();
        Insert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Political_Party_Text.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Political_Party_Text.setText("political party");

        Name_Text.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Name_Text.setText("Name");

        SurName_Text.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SurName_Text.setText("SurName");

        Education_Text.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Education_Text.setText("Education");

        Combobox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Insert.setText("INSERT");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Political_Party_Text, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Name_Text, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SurName_Text, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Education_Text))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SurName)
                    .addComponent(Name)
                    .addComponent(Combobox, 0, 227, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Insert)
                        .addComponent(Education, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Political_Party_Text)
                    .addComponent(Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name_Text)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SurName_Text)
                    .addComponent(SurName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Education_Text)
                    .addComponent(Education, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Insert)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        StartCalculating();
    }//GEN-LAST:event_InsertActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combobox;
    private javax.swing.JTextField Education;
    private javax.swing.JLabel Education_Text;
    private javax.swing.JButton Insert;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel Name_Text;
    private javax.swing.JLabel Political_Party_Text;
    private javax.swing.JTextField SurName;
    private javax.swing.JLabel SurName_Text;
    // End of variables declaration//GEN-END:variables
}
