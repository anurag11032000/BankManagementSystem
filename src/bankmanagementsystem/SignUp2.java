
package bankmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class SignUp2 extends JFrame implements ActionListener {
    
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,Catagory,Income,education,occupation;
    String formno;
    
    SignUp2(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails=new JLabel( "Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name=new JLabel( "Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel fname=new JLabel( "Catagory:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCatagory[]={"General","OBC","SC","ST","Other"};
        Catagory=new JComboBox(valCatagory);
        Catagory.setBounds(300,190,400,30);
        Catagory.setBackground(Color.WHITE);
        add(Catagory);
        
        
        JLabel dob=new JLabel( "Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String IncomeCatagory[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        Income=new JComboBox(IncomeCatagory);
        Income.setBounds(300,240,400,30);
        Income.setBackground(Color.WHITE);
        add(Income);
        
        JLabel gender=new JLabel( "Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,310,200,30);
        add(gender);
        
        JLabel email=new JLabel( "Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        String EducationValues[]={"Non Graduate","Graduate","Post Graduation","Doctrate","Others"};
        education=new JComboBox(EducationValues);
        education.setBounds(300,325,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel MaritalStatus=new JLabel( "Occupation:");
        MaritalStatus.setFont(new Font("Raleway",Font.BOLD,20));
        MaritalStatus.setBounds(100,390,200,30);
        add(MaritalStatus);
        
        String OccupationValues[]={"Salaried","Self Employed","Bussiness","Student","Retired","Others"};
        occupation=new JComboBox(OccupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        JLabel Address=new JLabel( "PAN Number:");
        Address.setFont(new Font("Raleway",Font.BOLD,20));
        Address.setBounds(100,440,200,30);
        add(Address);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel City=new JLabel( "Aadhar No:");
        City.setFont(new Font("Raleway",Font.BOLD,20));
        City.setBounds(100,490,200,30);
        add(City);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel State=new JLabel( "Senior Citizen:");
        State.setFont(new Font("Raleway",Font.BOLD,20));
        State.setBounds(100,540,200,30);
        add(State);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        JLabel pinCode=new JLabel( "Existing Account:");
        pinCode.setFont(new Font("Raleway",Font.BOLD,20));
        pinCode.setBounds(100,590,200,30);
        add(pinCode);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalgroup=new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)Catagory.getSelectedItem();
        String sincome=(String)Income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }
        String existionAccount =null;
        if(eyes.isSelected()){
            existionAccount="Yes";
        }else if(eno.isSelected()){
            existionAccount="No";
        }
        String span=pan.getText();
        String saadhar=aadhar.getText();
         
        try{
            
                Conn c=new Conn();
                String query="insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existionAccount+"')"; 
                c.s.executeUpdate(query);
                //signup3 object
                setVisible(false);
                new SignUp3(formno).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String[] args) {
        new SignUp2("");
    }
}
