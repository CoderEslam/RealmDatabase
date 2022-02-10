package com.doubleclick.realmdatabase;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class NewTaskDialog extends DialogFragment {

    NewTaskInterface newTaskInterface;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            newTaskInterface = (NewTaskInterface) context;
        }catch (ClassCastException e){
            throw  new ClassCastException(getActivity().toString()+"must implement NewTaskListiner");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.new_task_dialog,null);
        EditText editText = view.findViewById(R.id.editTextTextPersonName2);
        builder.setView(view).setPositiveButton("Add Task", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String task =editText.getText().toString();
                newTaskInterface.onAddTask(task);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NewTaskDialog.this.getDialog().cancel();
                newTaskInterface.onCancel(NewTaskDialog.this);
            }
        });

        return  builder.create();
    }

    public interface NewTaskInterface{
        void onAddTask(String task);
        void onCancel(DialogFragment dialogFragment);

    }
}
