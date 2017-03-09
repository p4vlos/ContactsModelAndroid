package info.efstratiou.contacts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactDetailsFragment extends Fragment {
    private ImageView photo;
    private TextView fullName;
    private TextView phoneNumber;

    public ContactDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_details, container, false);

        photo = (ImageView) view.findViewById(R.id.imageView);
        fullName = (TextView) view.findViewById(R.id.fullName);
        phoneNumber = (TextView) view.findViewById(R.id.phoneNumber);
        return view;
    }

    public void updateDetails(int id) {
        Contact contact = ContactsModel.getInstance().getContactList().get(id);

        Log.d("ContactDetailsFragment", "Got " + contact.getFirstName() + " " + contact.getLastName());
        photo.setImageResource(contact.getImageResource());
        fullName.setText(contact.getFirstName() + " " + contact.getLastName());
        phoneNumber.setText(contact.getPhoneNumber());
    }

}
