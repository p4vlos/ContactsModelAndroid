package pavlosnicolaou.contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactListView;
    private LinearLayoutManager layoutManager;

    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Wire recycler view
        contactListView = (RecyclerView) findViewById(R.id.contact_list_view);

        //Setup layout manager
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        //Attach to recycler view
        contactListView.setLayoutManager(layoutManager);

        //Setup adapter
        adapter = new ContactListAdapter();

        //Attach to recycler view
        contactListView.setAdapter(adapter);

        //Divider between list cells
        DividerItemDecoration divider = new DividerItemDecoration(this, layoutManager.getOrientation());
        contactListView.addItemDecoration(divider);

    }
}
