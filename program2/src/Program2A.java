import java.util.ArrayList;
import java.util.Scanner;

public class Program2A {
    static class Staff{
        String StaffID,name;
        int Salary;
        long phone_number;
        public Staff(String name, String StaffID, int Salary, long phone_number){
            this.name = name;
            this.StaffID = StaffID;
            this.Salary = Salary;
            this.phone_number = phone_number;
        }
    }
    public static class Teaching extends Staff{
        String domain;
        int publications;
        public Teaching(String name, String StaffID, int Salary, long phone_number,String domain,int publications){
            super(name,StaffID,Salary,phone_number);
            this.domain = domain;
            this.publications = publications;
        }
    }
    public static class Technical_Skills extends Staff{
        String skills;
        public Technical_Skills(String name, String StaffID, int Salary, long phone_number,String skills){
            super(name,StaffID,Salary,phone_number);
            this.skills = skills;
        }
    }
    public static class Contract extends Staff{
        int contract_period;
        public Contract(String name, String StaffID, int Salary, long phone_number,int contract_period){
            super(name,StaffID,Salary,phone_number);
            this.contract_period = contract_period;
        }
    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int option,publications,Salary,contract_period;
        long phone_number;
        String StaffID,name,domain,skills;

        ArrayList<Teaching>TeachingStaff = new ArrayList<>(3);
        ArrayList<Technical_Skills>Technical_Staff = new ArrayList<>(3);
        ArrayList<Contract>Contract_Staff = new ArrayList<>(3);
// TODO:: IMPROVE THIS CODE BY DISPLAYING ONLY WHAT IS REQUIRED
        for(;;){
            System.out.println("Enter the type of staff:\n\t1. Teaching Staff\n\t2. Technical Staff\n\t3. Contract\n\t4. Display\n\t0. Exit");
            System.out.println("Enter your option: ");
            option = myObj.nextInt();
            if(option == 1){    // Reading details for teaching staff
                System.out.println("Enter name: ");
                name = myObj.next();
                System.out.println("Enter ID: ");
                StaffID = myObj.next();
                System.out.println("Enter salary: ");
                Salary = myObj.nextInt();
                System.out.println("Enter phone_number:" );
                phone_number = myObj.nextLong();
                System.out.println("Enter domain: ");
                domain = myObj.next();
                System.out.println("Enter publications: ");
                publications = myObj.nextInt();
                Teaching temp_teach1 = new Teaching(name,StaffID,Salary,phone_number,domain,publications);
                TeachingStaff.add(temp_teach1);
            }
            else if(option == 2){   // Reading details of technical staff
                System.out.println("Enter name: ");
                name = myObj.next();
                System.out.println("Enter ID: ");
                StaffID = myObj.next();
                System.out.println("Enter salary: ");
                Salary = myObj.nextInt();
                System.out.println("Enter phone_number:" );
                phone_number = myObj.nextLong();
                System.out.println("Enter skills:" );
                skills = myObj.next();
                Technical_Skills temp_tech = new Technical_Skills(name,StaffID,Salary,phone_number,skills);
                Technical_Staff.add(temp_tech);
            }
            else if(option == 3){   // Reading details of contract staff
                System.out.println("Enter name: ");
                name = myObj.next();
                System.out.println("Enter ID: ");
                StaffID = myObj.next();
                System.out.println("Enter salary: ");
                Salary = myObj.nextInt();
                System.out.println("Enter phone_number:" );
                phone_number = myObj.nextLong();
                System.out.println("Enter contract:" );
                contract_period = myObj.nextInt();
                Contract temp_contract = new Contract(name,StaffID,Salary,phone_number,contract_period);
                Contract_Staff.add(temp_contract);
            }
            else if(option == 4){
                for(int i=0;i<3;i++){
                    try {
                        System.out.println("Details for Teaching Staff:");
                        System.out.println("Name: " + TeachingStaff.get(i).name);
                        System.out.println("Staff ID: " + TeachingStaff.get(i).StaffID);
                        System.out.println("Salary: " + TeachingStaff.get(i).Salary);
                        System.out.println("Phone Number: "+TeachingStaff.get(i).phone_number);
                        System.out.println("Domain: " + TeachingStaff.get(i).domain);
                        System.out.println("Publications: "+TeachingStaff.get(i).publications);
                    }catch (IndexOutOfBoundsException e){System.out.println("There are missing items for this category");break;}
                }
                for(int i=0;i<3;i++){
                    try {
                        System.out.println("Details for Technical Staff:");
                        System.out.println("Name: " + Technical_Staff.get(i).name);
                        System.out.println("Staff ID: " + Technical_Staff.get(i).StaffID);
                        System.out.println("Salary: " + Technical_Staff.get(i).Salary);
                        System.out.println("Phone Number: "+Technical_Staff.get(i).phone_number);
                        System.out.println("Skills: "+Technical_Staff.get(i).skills);
                    }catch (IndexOutOfBoundsException e){System.out.println("There are missing items for this category");break;}
                }
                for(int i=0;i<3;i++){
                    try {
                        System.out.println("Details for Contract Staff:");
                        System.out.println("Name: " + Contract_Staff.get(i).name);
                        System.out.println("Staff ID: " + Contract_Staff.get(i).StaffID);
                        System.out.println("Salary: " + Contract_Staff.get(i).Salary);
                        System.out.println("Phone Number: "+Contract_Staff.get(i).phone_number);
                        System.out.println("Contract Period: "+Contract_Staff.get(i).contract_period);
                    }catch (IndexOutOfBoundsException e){System.out.println("There are missing items for this category");break;}
                }
            }
            else if(option == 0){break;}
            else{System.out.println("Wrong option");}
        }
        System.exit(0);
    }
}
