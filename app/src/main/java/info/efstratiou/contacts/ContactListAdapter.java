package info.efstratiou.contacts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ce208 on 16/02/2017.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fullName;
        private TextView phoneNumber;
        private ImageView photo;
        public ViewHolder(View itemView) {
            super(itemView);

            fullName = (TextView) itemView.findViewById(R.id.full_name);
            phoneNumber = (TextView) itemView.findViewById(R.id.phone_number);
            photo = (ImageView) itemView.findViewById(R.id.photo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();
                    //Toast.makeText(v.getContext(), "Clicked item "+position, Toast.LENGTH_SHORT).show();

                    // Using the listener we can notify the activity
                    if (listener != null) {
                        listener.onContactItemClicked(position);
                    }
                }
            });
        }

        public void setData(Contact contact) {
            fullName.setText(contact.getFirstName() + " " + contact.getLastName());
            phoneNumber.setText(contact.getPhoneNumber());
            photo.setImageResource(contact.getImageResource());
        }
    }

    private final static String _TAG = "ContactListAdapter";

    private ContactsModel model = ContactsModel.getInstance();
    // The listener pointer
    private onContactListListener activitylistener;
    private Context context;
    private ContactListFragment.OnContactItemClickedListener listener;

    // We expect the context object to also support the onContactListListener interface
    public ContactListAdapter(Context ctx) {
        super();
        context = ctx;
        if (context instanceof ContactListFragment.OnContactItemClickedListener) {
            listener = (ContactListFragment.OnContactItemClickedListener) context;
        } else {
            Log.e(_TAG, "Activity does not support OnContactListListener interface");
        }
    }

    @Override
    public int getItemCount() {
        return model.getContactList().size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_contact_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = model.getContactList().get(position);
        holder.setData(contact);
    }

    /**
     * Communication with Activity
     * We define a listener interface for contacting the activity
     * The activity needs to implement that interface
     *
     * We also hold a private variable with a pointer to the listener (see above)
     */

    public interface onContactListListener {
        public void onContactListItemClicked(int position);
    }
}
