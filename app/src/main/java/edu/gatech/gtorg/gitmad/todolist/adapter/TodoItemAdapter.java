package edu.gatech.gtorg.gitmad.todolist.adapter;

import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import edu.gatech.gtorg.gitmad.todolist.R;
import edu.gatech.gtorg.gitmad.todolist.model.TodoItem;
import edu.gatech.gtorg.gitmad.todolist.service.TodoItemsProvider;


public class TodoItemAdapter extends RecyclerView.Adapter<TodoItemAdapter.TodoItemAdapterViewHolder> {

    private List<TodoItem> items;

    public TodoItemAdapter(List<TodoItem> items) {
        this.items = items;
    }

    @Override
    public TodoItemAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_item, parent, false);

        return new TodoItemAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TodoItemAdapter.TodoItemAdapterViewHolder holder, final int position) {
        final TodoItem todoItem = items.get(position);
        holder.textView.setText(todoItem.getText());
        holder.checkBox.setChecked(todoItem.isCompleted());

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.remove(position);

                TodoItemsProvider.setItemCompleted(!todoItem.isCompleted(), todoItem.getId());

                notifyDataSetChanged();

                // TODO: 12. Fill in the Snackbar code
                Snackbar snackbar = Snackbar.make((View) v.getParent().getParent(), /*...*/);
                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        items.add(position, todoItem);

                        TodoItemsProvider.setItemCompleted(!todoItem.isCompleted(), todoItem.getId());

                        notifyDataSetChanged();
                    }
                });
                /* ... */
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<TodoItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    static class TodoItemAdapterViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public CheckBox checkBox;

        public TodoItemAdapterViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.todo_text);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }
}
