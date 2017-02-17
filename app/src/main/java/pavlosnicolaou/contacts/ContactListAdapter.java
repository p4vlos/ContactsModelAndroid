package pavlosnicolaou.contacts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vl1s on 17/02/2017.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {

    //variable for the constructor
    private ContactsModel model = ContactsModel.getInstance();

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView fullName;
        private TextView phoneNumber;
        private ImageView photo;

        public ViewHolder(View itemView) {
            super(itemView);

            //Bind elements to the layout
            fullName = (TextView) itemView.findViewById(R.id.full_name);
            phoneNumber = (TextView) itemView.findViewById(R.id.phone_number);
            photo = (ImageView) itemView.findViewById(R.id.photo);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    
                }
            });
        }

        public void setData(Contact contact) {
            //Set values
            fullName.setText(contact.getFirstName() + " " + contact.getLastName());
            phoneNumber.setText(contact.getPhoneNumber());
            photo.setImageResource(contact.getImageResource());
        }
    }

    //here is the constructor
    public ContactListAdapter() {
        super();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Create the new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_contact_item, parent, false);

        //Save view in view holder
        ViewHolder vh = new ViewHolder(v);

        //Return view holder
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //Get the relevant object
        Contact contact = model.getContactList().get(position);

        holder.setData(contact);

    }

    @Override
    public int getItemCount() {
        return model.getContactList().size();
    }
}
