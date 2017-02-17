package pavlosnicolaou.contacts;

import java.util.ArrayList;

/**
 * Created by vl1s on 17/02/2017.
 */
public class ContactsModel {
    private static ContactsModel ourInstance = new ContactsModel();

    public static ContactsModel getInstance() {
        return ourInstance;
    }

    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    private ContactsModel() {

        contactList.add(new Contact("John", "Snow", "0784738291", R.drawable.jonsnow));
        contactList.add(new Contact("Daenerys", "Targaryen", "07848434934", R.drawable.daenerys));
        contactList.add(new Contact("Tyrion", "Lannister", "07841342394", R.drawable.tyrion));

    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }
}
