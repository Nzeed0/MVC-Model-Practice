package Model;

public class Md {
    
    public String CheckName(String Name, String Surname){
        for(int i = 0; i < Name.length(); i++){
            char NameCheck = Name.charAt(i);
            if(!Character.isLetter(NameCheck)){
                return "0";
            }
        }
        
        for(int j = 0; j < Surname.length(); j++){
            char SurnameCheck = Surname.charAt(j);
            if(!Character.isLetter(SurnameCheck)){
                return "0";
            }
        }
        return "1";
    }
    
    public String CheckEducation(String Edu){
        String EducationSet[] = {"KMITL","KMIT","CU","TU","KU","KKU"};
        
        for(int i = 0; i < EducationSet.length; i++){
            if(Edu.equals(EducationSet[i]))
                return "1";
        }
        return "0";
    }    
}
