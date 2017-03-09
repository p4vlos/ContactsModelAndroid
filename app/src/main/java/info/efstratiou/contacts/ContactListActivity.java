package info.efstratiou.contacts;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.LayoutInflater;

public class ContactListActivity extends AppCompatActivity
    implements ContactListFragment.OnContactItemClickedListener,
        ContactListAdapter.onContactListListener {

    private boolean hasTwoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        if (findViewById(R.id.details_fragment) != null) {
            hasTwoPanes = true;
        } else {
            hasTwoPanes = false;
        }
    }

    // Method for the onContactListListener interface
    @Override
    public void onContactListItemClicked(int position) {
        final Contact contact = ContactsModel.getInstance().getContactList().get(position);

        // Show a custom dialog box and ask to dial that number
        AlertDialog.Builder dlgBuilder = new AlertDialog.Builder(this);
        final View dlgView = getLayoutInflater().inflate(R.layout.adapter_contact_item, null);
        // Add values to the dialog
        TextView fullName = (TextView) dlgView.findViewById(R.id.full_name);
        TextView phoneNumber = (TextView) dlgView.findViewById(R.id.phone_number);
        ImageView photo = (ImageView) dlgView.findViewById(R.id.photo);

        fullName.setText(contact.getFirstName() + " " + contact.getLastName());
        phoneNumber.setText(contact.getPhoneNumber());
        photo.setImageResource(contact.getImageResource());

        dlgBuilder.setView(dlgView);
        dlgBuilder.setPositiveButton("Dial", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Start the dialing app to make the call
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + contact.getPhoneNumber()));
                startActivity(intent);
            }
        });
        dlgBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Nothing to do here
            }
        });
        dlgBuilder.create().show();

    }

    @Override
    public void onContactItemClicked(int position) {

        if (hasTwoPanes) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            ContactDetailsFragment fragment = (ContactDetailsFragment) fragmentManager
                    .findFragmentById(R.id.details_fragment);
            fragment.updateDetails(position);

        } else {
           Intent intent = new Intent(this, ContactDetailsActivity.class);
            intent.putExtra("ITEM_ID", position);
            startActivity(intent);
        }
    }


}
