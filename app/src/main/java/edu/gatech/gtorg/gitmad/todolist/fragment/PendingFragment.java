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

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.setItems(TodoItemsProvider.getPendingItems());
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        final FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = createDialog(adapter);
                dialog.show();
            }
        });

        return view;
    }

    public AlertDialog createDialog(final TodoItemAdapter adapter) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_item_dialog, null);
        builder.setMessage("Add a New Todo");
        builder.setView(view);
        final EditText editText = (EditText) view.findViewById(R.id.edit_text);
        builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TodoItemsProvider.addItem(new TodoItem(editText.getText().toString(), false));
                adapter.setItems(TodoItemsProvider.getPendingItems());
            }
        })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return builder.create();
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
