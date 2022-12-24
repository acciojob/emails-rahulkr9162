package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
         if(oldPassword.equals(password)){
             if(ValidatePassword(newPassword) == true)
                   this.password = newPassword;
         }

    }
    public boolean ValidatePassword(String newPassword){
        int CountCapsLetter = 0;
        int CountSmallLetter = 0;
        int CountDigit = 0;
        int CountSpeChar = 0;
        for(int i=0; i<newPassword.length(); i++){
            char ch = newPassword.charAt(i);
            if(ch >='A' && ch <= 'Z') CountCapsLetter++;
            if(ch >='a' && ch <= 'z') CountSmallLetter++;
            if(ch >='0' && ch <= '9') CountDigit++;
            if((ch>=(char)32 && ch<=(char)47) || (ch>=(char)58 && ch<=(char)64) || (ch>=(char)91 && ch<=(char)96) || (ch>=(char)123 &&ch<=(char)126)) CountSpeChar++;
        }
        return newPassword.length()>=8 && CountCapsLetter>=1 && CountSmallLetter>=1 && CountDigit>=1 && CountSpeChar>=1;
    }

}
