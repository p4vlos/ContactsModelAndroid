package info.efstratiou.contacts;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnContactItemClickedListener} interface
 * to handle interaction events.
 */
public class ContactListFragment extends Fragment {

    private OnContactItemClickedListener mListener;
    private RecyclerView contactListView;
    private LinearLayoutManager layoutManager;
    private ContactListAdapter adapter;

    public ContactListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_contact_list, container, false);


        contactListView = (RecyclerView) view.findViewById(R.id.contact_list_view);

        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        // Passing the activity as attribute. This will be assigned to the listener in the adapter.
        adapter = new ContactListAdapter(getActivity());
        contactListView.setAdapter(adapter);

        contactListView.setLayoutManager(layoutManager);

        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), layoutManager.getOrientation());
        contactListView.addItemDecoration(divider);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnContactItemClickedListener) {
            mListener = (OnContactItemClickedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnContactItemClickedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnContactItemClickedListener {
        // Called when a contact is clicked
        void onContactItemClicked(int position);
    }
}
