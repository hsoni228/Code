package questions;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Contacts {

    private static class Contact {
        String fName, mName, lName;
        List<String> phoneList;

        public String getfName() {
            return fName;
        }

        public void setfName(String fName) {
            this.fName = fName;
        }

        public String getmName() {
            return mName;
        }

        public void setmName(String mName) {
            this.mName = mName;
        }

        public String getlName() {
            return lName;
        }

        public void setlName(String lName) {
            this.lName = lName;
        }

        public List<String> getPhoneList() {
            return phoneList;
        }

        public void setPhoneList(List<String> phoneList) {
            this.phoneList = phoneList;
        }
    }

    private static List<Contact> contactList = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        List<String> fileList = new ArrayList<>();
        fileList.add("/home/himanshu.soni/Desktop/Contacts_Himani/File1.txt");
        fileList.add("/home/himanshu.soni/Desktop/Contacts_Himani/File2.txt");
        fileList.add("/home/himanshu.soni/Desktop/Contacts_Himani/File3.txt");

        for(String fileName : fileList) {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            JSONObject contacts = JSONObject.fromObject(content);
            JSONArray contactsArray = contacts.getJSONArray("ct");

            for (int i = 0; i < contactsArray.size(); i++) {
                JSONObject contact = contactsArray.getJSONObject(i);
                JSONArray fsArray = contact.getJSONArray("fs");

                JSONObject nameObj = new JSONObject();
                List<JSONObject> phoneList = new ArrayList<>();
                if(fsArray.size() == 1)
                    continue;
                for (int j = 0; j < fsArray.size(); j++) {
                    JSONObject fsObj = fsArray.getJSONObject(j);

                    if (fsObj.getString("t").equalsIgnoreCase("NAME")) {
                        nameObj = fsObj;
                    } else if (fsObj.getString("t").equalsIgnoreCase("PHONE")) {
                        phoneList.add(fsObj);
                    }
                }

                try {

                    String fName = JsonUtil.getSafeString(nameObj.getJSONObject("v"), "givenName");
                    String mName = JsonUtil.getSafeString(nameObj.getJSONObject("v"), "middleName");
                    String lName = JsonUtil.getSafeString(nameObj.getJSONObject("v"), "familyName");

                    List<String> phoneNo = new ArrayList<>();
                    for (JSONObject phone : phoneList) {
                        phoneNo.add(JsonUtil.getSafeString(phone, "v"));
                    }

                    Contact contactInfo = new Contact();
                    contactInfo.setfName(fName);
                    contactInfo.setmName(mName);
                    contactInfo.setlName(lName);
                    contactInfo.setPhoneList(phoneNo);

                    contactList.add(contactInfo);
                } catch (Exception e) {
                    System.out.println("Error - " + i);
                    e.printStackTrace();
                }


            }

        }

        for (Contact contact : contactList){
            String name = contact.mName.equals("") ? contact.fName : contact.fName + " " + contact.mName;
            String fullName = contact.lName.equals("") ? name : name + " " + contact.lName;

            System.out.println("BEGIN:VCARD");
            System.out.println("VERSION:2.1");
            System.out.println("N:"+contact.lName+";"+name+";;;");
            System.out.println("FN:"+fullName+"");
            for(String phone : contact.phoneList) {
                phone = phone.replaceAll(" ", "");
                System.out.println("TEL;CELL:"+phone+"");
            }
            System.out.println("END:VCARD");
        }
    }
}
