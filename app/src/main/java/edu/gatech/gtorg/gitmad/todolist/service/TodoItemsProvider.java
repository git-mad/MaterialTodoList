package edu.gatech.gtorg.gitmad.todolist.service;


import java.util.ArrayList;
import java.util.List;

import edu.gatech.gtorg.gitmad.todolist.model.TodoItem;

public class TodoItemsProvider {

    private static List<TodoItem> items = new ArrayList<TodoItem>() {
        {
            add(new TodoItem("Hit the Gym", false));
            add(new TodoItem("Lawyer Up", false));
            add(new TodoItem("Delete Facebook", false));

            add(new TodoItem("Learn Material Design", true));
            add(new TodoItem("Go to GITMAD Meeting", true));
        }
    };

    public static List<TodoItem> getPendingItems() {
        List<TodoItem> pendingItems = new ArrayList<>();

        for (TodoItem item : items) {
            if (!item.isCompleted()) {
                pendingItems.add(item);
            }
        }


        return pendingItems;
    }

    public static List<TodoItem> getCompletedItems() {
        List<TodoItem> completedItems = new ArrayList<>();

        for (TodoItem item : items) {
            if (item.isCompleted()) {
                completedItems.add(item);
            }
        }


        return completedItems;
    }

    public static void setItemCompleted(boolean completed, int id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                item.setCompleted(completed);
                break;
            }
        }
    }

    public static void setPending(int id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                item.setCompleted(false);
                break;
            }
        }
    }

    public static void addItem(TodoItem newItem) {
        items.add(newItem);
    }
}
