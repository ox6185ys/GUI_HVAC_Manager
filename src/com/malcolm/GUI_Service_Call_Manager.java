package com.malcolm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

/**
 * Created by Malcolm on 11/15/2015.
 */
public class GUI_Service_Call_Manager extends JFrame{
    private JScrollPane openCallsScrollPane;
    private JList<ServiceCall> openServiceCallsDisplayJList;
    private JComboBox selectTaskComboBox;
    private JComboBox callTypeComboBox;

    private JTextField callAddressTextField;
    private JTextField callDescriptionTextField;
    private JComboBox ifFurnaceSelectedComboBox;
    private JTextField modelTypeORAgeOfHeaterTextField;
    private JLabel furnaceTypeDropDownLabel;
    private JLabel serviceCallTypeLabel;
    private JLabel callAddressLabel;
    private JLabel callProblemDescriptionLabel;
    private JPanel rootPanel;
    private JLabel taskSelectionLabel;
    private JLabel modelOrAgeOfHeaterLabel;
    private JButton addingServiceCallButton;
    private JButton resolveTicketButton;
    private JTextField resolutionDescriptionTextField;
    private JTextField feeChargedTextField;
    private JLabel feeChargedJLabel;
    private JLabel resolutionDescriptionLabel;
    private JScrollPane resolvedServiceCallsScrollPane;
    private JList<ServiceCall> resolvedServiceCallsDisplayJList;

    DefaultListModel<Furnace> furnaceListModel;
    DefaultListModel<CentralAC> centralACListModel;
    DefaultListModel<WaterHeater>waterHeaterListModel;
    DefaultListModel<ServiceCall>serviceCallListModel;
    DefaultListModel<ServiceCall>resolvedServiceCallListModel;

    public GUI_Service_Call_Manager(){

    super ("HVAC Service Call Manager");
    setContentPane(rootPanel);
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
        //TicketDisplayJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        furnaceListModel=new DefaultListModel<Furnace>();
        centralACListModel=new DefaultListModel<CentralAC>();
        waterHeaterListModel=new DefaultListModel<WaterHeater>();
        serviceCallListModel=new DefaultListModel<ServiceCall>();
        resolvedServiceCallListModel=new DefaultListModel<ServiceCall>();
        openServiceCallsDisplayJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resolvedServiceCallsDisplayJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //TODO here should be where the list shows its data ina  meaninful way.  Might have to make 3 seperate lists.
        openServiceCallsDisplayJList.setModel(serviceCallListModel);
        resolvedServiceCallsDisplayJList.setModel(resolvedServiceCallListModel);
//Here I set various elements to non-visible until selections are made.
        feeChargedJLabel.setVisible(false);
        feeChargedTextField.setVisible(false);
        resolutionDescriptionLabel.setVisible(false);
        resolutionDescriptionTextField.setVisible(false);
        resolveTicketButton.setVisible(false);
        callTypeComboBox.setVisible(false);
        callAddressLabel.setVisible(false);
        callAddressLabel.setVisible(false);
        callAddressTextField.setVisible(false);
        callDescriptionTextField.setVisible(false);
        ifFurnaceSelectedComboBox.setVisible(false);
        modelTypeORAgeOfHeaterTextField.setVisible(false);
        furnaceTypeDropDownLabel.setVisible(false);
        serviceCallTypeLabel.setVisible(false);
        callProblemDescriptionLabel.setVisible(false);
        modelOrAgeOfHeaterLabel.setVisible(false);
        addingServiceCallButton.setVisible(false);
        /**Here are variables for the Furnace Types**/
        final String EMPTY_FURNACE_TYPE="";
        final String FORCED_AIR="Forced Air";
        final String BOILER_AND_RADIATOR="Boiler & Radiators";
        final String OLD_OCTOPUS="Ancient 'Octopus' Style";
        //Now we add them to the combo box
        ifFurnaceSelectedComboBox.addItem(EMPTY_FURNACE_TYPE);
        ifFurnaceSelectedComboBox.addItem(FORCED_AIR);
        ifFurnaceSelectedComboBox.addItem(BOILER_AND_RADIATOR);
        ifFurnaceSelectedComboBox.addItem(OLD_OCTOPUS);

        /** Here are the variables for the selectTaskComboBox **/
        final String EMPTY_SELECTION="";
        final String NEW_SERVICE_CALL="Add Service Call to Call Queue";
        final String RESOLVE_SERVICE_CALL="resolve a Call from the Call Queue";
        final String DELETE_A_CALL="Delete a call from the Call Queue";
        //Here are them added to the combo boxes
        selectTaskComboBox.addItem(EMPTY_SELECTION);
        selectTaskComboBox.addItem(NEW_SERVICE_CALL);
        selectTaskComboBox.addItem(RESOLVE_SERVICE_CALL);
        selectTaskComboBox.addItem(DELETE_A_CALL);
        /**Here are the variables for the callTypeCombobox**/
        final String EMPTY_SELECTION_FOR_CALL_TYPE="";
        final String FURNACE="Furnace Repair Call";
        final String CENTRAL_AC="Central A/C Repair Call";
        final String WATER_HEATER="Water Heater Repair Call";
        //Here we add the options to the type of service Call
        callTypeComboBox.addItem(EMPTY_SELECTION_FOR_CALL_TYPE);
        callTypeComboBox.addItem(FURNACE);
        callTypeComboBox.addItem(CENTRAL_AC);
        callTypeComboBox.addItem(WATER_HEATER);


        selectTaskComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if the item selected is "New Service Call" then we will make new call, and make bits visible
                if(selectTaskComboBox.getSelectedItem().equals(NEW_SERVICE_CALL)){
                    callTypeComboBox.setVisible(true);
                    serviceCallTypeLabel.setVisible(true);
                    feeChargedTextField.setVisible(false);
                    feeChargedJLabel.setVisible(false);
                    resolutionDescriptionTextField.setVisible(false);
                    resolveTicketButton.setVisible(false);
                    resolutionDescriptionLabel.setVisible(false);
                }else if(selectTaskComboBox.getSelectedItem().equals(EMPTY_SELECTION)){
                    callTypeComboBox.setVisible(false);
                    serviceCallTypeLabel.setVisible(false);
                    feeChargedTextField.setVisible(false);
                    feeChargedJLabel.setVisible(false);
                    resolutionDescriptionTextField.setVisible(false);
                    resolveTicketButton.setVisible(false);
                    resolutionDescriptionLabel.setVisible(false);
                }else if(selectTaskComboBox.getSelectedItem().equals(RESOLVE_SERVICE_CALL)){
                    System.out.println("Resolve Selected");
                    feeChargedTextField.setVisible(true);
                    feeChargedJLabel.setVisible(true);
                    resolutionDescriptionTextField.setVisible(true);
                    resolveTicketButton.setVisible(true);
                    resolutionDescriptionLabel.setVisible(true);
                }else if(selectTaskComboBox.getSelectedItem().equals(DELETE_A_CALL)){
                    System.out.println("Delete A Call Selected");
                }
            }
        });
        callTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(callTypeComboBox.getSelectedItem().equals(EMPTY_SELECTION_FOR_CALL_TYPE)){
                    furnaceTypeDropDownLabel.setVisible(false);
                    ifFurnaceSelectedComboBox.setVisible(false);
                    //reset to invisible when select the blank option
                    modelTypeORAgeOfHeaterTextField.setVisible(false);
                    modelOrAgeOfHeaterLabel.setVisible(false);
                    //reset to invisible when select the blank option
                    callAddressLabel.setVisible(false);
                    callAddressTextField.setVisible(false);
                    //reset to invisible when select the blank option
                    callDescriptionTextField.setVisible(false);
                    callProblemDescriptionLabel.setVisible(false);

                    addingServiceCallButton.setVisible(false);

                }else if(callTypeComboBox.getSelectedItem().equals(FURNACE)){

                    furnaceTypeDropDownLabel.setVisible(true);
                    ifFurnaceSelectedComboBox.setVisible(true);
                    //Show Address label and text box when this one is selected
                    callAddressLabel.setVisible(true);
                    callAddressTextField.setVisible(true);
                    //make model stuff invisible
                    modelTypeORAgeOfHeaterTextField.setVisible(false);
                    modelOrAgeOfHeaterLabel.setVisible(false);
                    //make the description boxes visible
                    callDescriptionTextField.setVisible(true);
                    callProblemDescriptionLabel.setVisible(true);

                    addingServiceCallButton.setVisible(true);

                }else if(callTypeComboBox.getSelectedItem().equals(CENTRAL_AC)){

                    modelTypeORAgeOfHeaterTextField.setVisible(true);
                    modelOrAgeOfHeaterLabel.setVisible(true);
                    modelOrAgeOfHeaterLabel.setText(" Model Number of Unit : ");

                    ifFurnaceSelectedComboBox.setVisible(false);
                    furnaceTypeDropDownLabel.setVisible(false);

                    callAddressLabel.setVisible(true);
                    callAddressTextField.setVisible(true);
                    //make the description boxes visible
                    callDescriptionTextField.setVisible(true);
                    callProblemDescriptionLabel.setVisible(true);

                    addingServiceCallButton.setVisible(true);

                }else if (callTypeComboBox.getSelectedItem().equals(WATER_HEATER)){

                    modelTypeORAgeOfHeaterTextField.setVisible(true);
                    modelOrAgeOfHeaterLabel.setVisible(true);
                    modelOrAgeOfHeaterLabel.setText(" Age of Water Heater : ");

                    ifFurnaceSelectedComboBox.setVisible(false);
                    furnaceTypeDropDownLabel.setVisible(false);

                    callAddressLabel.setVisible(true);
                    callAddressTextField.setVisible(true);
                    //make the description boxes visible
                    callDescriptionTextField.setVisible(true);
                    callProblemDescriptionLabel.setVisible(true);

                    addingServiceCallButton.setVisible(true);

                }
            }
        });
        addingServiceCallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //if one of the fields is empty, display the error.
                if (callDescriptionTextField.getText().equals("")||callAddressTextField.getText().equals("")){
                    JOptionPane.showMessageDialog(GUI_Service_Call_Manager.this,"Please fill in all fields before\n adding the service call to the queue.");
                }else{
                    //Otherwise continue on as normal
                    String serviceAddress=callAddressTextField.getText();
                    String callDescription=callDescriptionTextField.getText();
                    Date date = new Date();
                    String modelNumber="";
                    String ageOfHeater="";
                    int furnaceType=0;


                    /** If furnace is selected then we make a Furnace Service Call Object **/
                    if (callTypeComboBox.getSelectedItem().equals(FURNACE)) {
                        if(ifFurnaceSelectedComboBox.isVisible()&&ifFurnaceSelectedComboBox.getSelectedItem().equals(FORCED_AIR)){
                            furnaceType=1;
                        }
                        else if(ifFurnaceSelectedComboBox.isVisible()&&ifFurnaceSelectedComboBox.getSelectedItem().equals(BOILER_AND_RADIATOR)){
                            furnaceType=2;
                        }else if(ifFurnaceSelectedComboBox.isVisible()&&ifFurnaceSelectedComboBox.getSelectedItem().equals(OLD_OCTOPUS)) {
                            furnaceType = 3;
                        }
                        Furnace furnaceCall = new Furnace(serviceAddress, callDescription, date, furnaceType);
                        GUI_Service_Call_Manager.this.serviceCallListModel.addElement(furnaceCall);
                        System.out.println("I made a furnace call!");
                    }
                    /** If Central AC is selected then we gather the data from the same places, with the addition of the model number **/
                    else if (callTypeComboBox.getSelectedItem().equals(CENTRAL_AC)){
                        modelNumber=modelTypeORAgeOfHeaterTextField.getText();
                        CentralAC centralACCall=new CentralAC(serviceAddress,callDescription,date,modelNumber);
                        GUI_Service_Call_Manager.this.serviceCallListModel.addElement(centralACCall);
                        System.out.println("I made a Central AC call.");
                    }
                    else if(callTypeComboBox.getSelectedItem().equals(WATER_HEATER)){
                        ageOfHeater=modelTypeORAgeOfHeaterTextField.getText();
                        WaterHeater waterHeaterCall=new WaterHeater(serviceAddress,callDescription,date,ageOfHeater);
                        GUI_Service_Call_Manager.this.serviceCallListModel.addElement(waterHeaterCall);
                        System.out.println("I made a Water heater Call");

                    }
                    selectTaskComboBox.setSelectedItem(EMPTY_SELECTION);
                    callTypeComboBox.setSelectedItem(EMPTY_SELECTION_FOR_CALL_TYPE);
                    callAddressTextField.setText("");
                    callDescriptionTextField.setText("");
                    ifFurnaceSelectedComboBox.setSelectedItem(EMPTY_FURNACE_TYPE);
                    modelTypeORAgeOfHeaterTextField.setText("");
                }
            }
        });
        resolveTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(feeChargedTextField.getText().equals("")||resolutionDescriptionTextField.getText().equals("")){
                    JOptionPane.showMessageDialog(GUI_Service_Call_Manager.this,"Please fill in all fields before\n resolving a ticket from the queue.");
                }else {
                    Date date= new Date();
                    ServiceCall toResolve = GUI_Service_Call_Manager.this.openServiceCallsDisplayJList.getSelectedValue();
                    toResolve.setFee(Double.parseDouble(feeChargedTextField.getText()));
                    toResolve.setProblemDescription(resolutionDescriptionTextField.getText());
                    toResolve.setResolvedDate(date);
                    GUI_Service_Call_Manager.this.resolvedServiceCallListModel.addElement(toResolve);
                    GUI_Service_Call_Manager.this.serviceCallListModel.removeElement(toResolve);
                    //TODO set up so this adds the sleted one to the new JLIST resolved stuff. You have to set that all up too
                }
                }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
