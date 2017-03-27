package edu.gatech.gtorg.gitmad.todolist.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.gatech.gtorg.gitmad.todolist.R;
import edu.gatech.gtorg.gitmad.todolist.adapter.TodoItemAdapter;
import edu.gatech.gtorg.gitmad.todolist.service.TodoItemsProvider;

public class CompletedFragment extends Fragment {
    public CompletedFragment() {
        // Required empty public constructor
    }

    public static CompletedFragment newInstance() {

        return new CompletedFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_completed, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        final TodoItemAdapter adapter = new TodoItemAdapter(TodoItemsProvider.getCompletedItems());
        recyclerView.setAdapter(adapter);

        // TODO: 11. Setup the SwipeRefreshLayout
        // The following should be performed when refreshing:
        // adapter.setItems(TodoItemsProvider.getCompletedItems());

        return view;
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
