package com.doubleclick.realmdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.security.SecureRandom;
import java.security.Security;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements NewTaskDialog.NewTaskInterface {

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        recyclerView = findViewById(R.id.recycler);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        DialogFragment addTask = new NewTaskDialog();

        ReecyelerAdapter reecyelerAdapter= new ReecyelerAdapter(realm.where(TaskDB.class).findAll());
        recyclerView.setAdapter(reecyelerAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        TouchCallBack touchCallBack = new TouchCallBack();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchCallBack);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask.show(getSupportFragmentManager(),"New Task");
            }
        });

    }

    @Override
    public void onAddTask(String task) {
        SecureRandom secureRandom = new SecureRandom();
        int taskD = secureRandom.nextInt(100000);
        DataHelper.newTask(realm,taskD,task);
    }

    @Override
    public void onCancel(DialogFragment dialogFragment) {
        Toast.makeText(MainActivity.this, "Canceld", Toast.LENGTH_SHORT).show();
    }



    private class TouchCallBack extends ItemTouchHelper.SimpleCallback{

        public TouchCallBack() {
            super(ItemTouchHelper.UP|ItemTouchHelper.DOWN,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            DataHelper.deleteTask(realm,viewHolder.getItemId());
        }
    }
}