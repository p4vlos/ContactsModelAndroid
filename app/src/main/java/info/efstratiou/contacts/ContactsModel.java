package info.efstratiou.contacts;

import java.util.ArrayList;

/**
 * Created by ce208 on 16/02/2017.
 */
public class ContactsModel {
    private static ContactsModel ourInstance = new ContactsModel();

    public static ContactsModel getInstance() {
        return ourInstance;
    }

    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    private ContactsModel() {
        contactList.add(new Contact("Jon", "Snow", "+44 1234 567890", R.drawable.jonsnow));
        contactList.add(new Contact("Daenerys", "Targaryen", "+44 1234 567890", R.drawable.daenerys));
        contactList.add(new Contact("Tyrion", "Lannister", "+44 1234 567890", R.drawable.tyrion));
        contactList.add(new Contact("Arya", "Stark", "+44 1234 567890", R.drawable.arya));
        contactList.add(new Contact("Cersei", "Lannister", "+44 1234 567890", R.drawable.cersei));
        contactList.add(new Contact("Sansa", "Stark", "+44 1234 567890", R.drawable.sansa));
        contactList.add(new Contact("Jon", "Snow", "+44 1234 567890", R.drawable.jonsnow));
        contactList.add(new Contact("Daenerys", "Targaryen", "+44 1234 567890", R.drawable.daenerys));
        contactList.add(new Contact("Tyrion", "Lannister", "+44 1234 567890", R.drawable.tyrion));
        contactList.add(new Contact("Arya", "Stark", "+44 1234 567890", R.drawable.arya));
        contactList.add(new Contact("Cersei", "Lannister", "+44 1234 567890", R.drawable.cersei));
        contactList.add(new Contact("Sansa", "Stark", "+44 1234 567890", R.drawable.sansa));
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }
}
