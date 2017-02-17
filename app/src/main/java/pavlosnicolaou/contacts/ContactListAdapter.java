package pavlosnicolaou.contacts;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by vl1s on 17/02/2017.
 */

public class ContactListAdapter {
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
        }

        public void SetData(Contact contact) {
            //Set values
            fullName.setText(contact.getFirstName() + " " + contact.getLastName());
            phoneNumber.setText(contact.getPhoneNumber());
            photo.setImageResource(contact.getImageResource());
        }
    }
}
