package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int InboxSize = 0;
    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)

    ArrayList<mails> Inbox = new ArrayList<>();
    ArrayList<mails> Trash = new ArrayList<>();

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;

    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
          if(InboxSize >= inboxCapacity){
              Trash.add(Inbox.remove(0));
              InboxSize--;
          }
              Inbox.add(new mails(date, sender, message));
              InboxSize++;
              //System.out.println(InboxSize);

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
         for(mails temp : Inbox){
             if(temp.message == message){
                 Trash.add(temp);
                 break;
             }

         }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(Inbox.size() == 0) return null;
        mails temp = Inbox.get(Inbox.size()-1);
        return temp.message;

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(Inbox.size() == 0) return null;
        mails temp = Inbox.get(0);
        return temp.message;

    }

    public int findMailsBetweenDates(Date start, Date end) {
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int mailcount = 0;
        for (mails temp : Inbox) {
            if (temp.date.compareTo(start) >= 0 && temp.date.compareTo(end) <= 0) {
                mailcount++;
            }
        }
            return mailcount;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return Inbox.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return Trash.size();

    }

    public void emptyTrash(){
        // clear all mails in the trash
        Trash.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
class mails{
    Date date;
    String sender;
    String message;

    public mails(Date date, String sender, String message){
        this.date = date;
        this.sender = sender;
        this.message = message;
    }

        }
