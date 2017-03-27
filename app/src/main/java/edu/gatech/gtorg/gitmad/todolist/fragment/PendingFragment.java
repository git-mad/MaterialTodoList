package edu.gatech.gtorg.gitmad.todolist.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import edu.gatech.gtorg.gitmad.todolist.R;
import edu.gatech.gtorg.gitmad.todolist.adapter.TodoItemAdapter;
import edu.gatech.gtorg.gitmad.todolist.model.TodoItem;
import edu.gatech.gtorg.gitmad.todolist.service.TodoItemsProvider;


public class PendingFragment extends Fragment {
    public PendingFragment() {
        // Required empty public constructor
    }

    public static PendingFragment newInstance() {
        return new PendingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pending, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        final TodoItemAdapter adapter = new TodoItemAdapter(TodoItemsProvider.getPendingItems());
        recyclerView.setAdapter(adapter);

        // TODO: 5. Setup the SwipeRefreshLayout
        // The following should be performed when refreshing:
        // adapter.setItems(TodoItemsProvider.getPendingItems());

        // TODO: 7. Setup the FloatingActionButton and show the dialog when clicked

        return view;
    }

    public AlertDialog createDialog(final TodoItemAdapter adapter) {
        // TODO: 9. Create the dialog
        // The following should be performed when the user clicks to confirm:
        // TodoItemsProvider.addItem(new TodoItem(editText.getText().toString(), false));
        // adapter.setItems(TodoItemsProvider.getPendingItems());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
