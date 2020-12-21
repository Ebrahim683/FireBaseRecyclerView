package com.example.firebaserecyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class RecyclerAdapter extends FirebaseRecyclerAdapter<DataModel,RecyclerAdapter.RecyclerViewHolder> {


    public RecyclerAdapter(@NonNull FirebaseRecyclerOptions<DataModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position, @NonNull DataModel model) {
        holder.sampleTitle.setText(model.getTitle());
        holder.sampleDes.setText(model.getDescription());
        Glide.with(holder.sampleImg.getContext()).load(model.getPic()).into(holder.sampleImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MainActivity2.class);
                intent.putExtra("phoneKey",getRef(position).getKey());
                v.getContext().startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new RecyclerViewHolder(view);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        ImageView sampleImg;
        TextView sampleTitle,sampleDes;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            sampleImg = itemView.findViewById(R.id.sampleImg);
            sampleTitle = itemView.findViewById(R.id.sampleTitle);
            sampleDes = itemView.findViewById(R.id.sampleDes);
        }
    }

}
