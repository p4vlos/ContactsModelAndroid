package info.efstratiou.contacts;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ContactDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        Intent intent = getIntent();
        int itemId = intent.getIntExtra("ITEM_ID", 0);

        // Get fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        ContactDetailsFragment fragment = (ContactDetailsFragment) fragmentManager
                .findFragmentById(R.id.details_fragment);
        fragment.updateDetails(itemId);
    }
}
