package com.example.images;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Image> images;

    public Adapter(Context ctx,List<Image> images){
        this.inflater=LayoutInflater.from(ctx);
        this.images=images;
    }




    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=inflater.inflate(R.layout.custom_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        //binding the data
        holder.imageId.setText(images.get(position).getId());
        holder.imageAuthor.setText(images.get(position).getAuthor());
        Picasso.get().load(images.get(position).getCoverImage()).into(holder.imageCoverImage);


    }

    @Override
    public int getItemCount() {
        return images.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView imageId,imageAuthor;
        ImageView imageCoverImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageId=itemView.findViewById(R.id.imageId);
            imageAuthor=itemView.findViewById(R.id.imageAuthor);
            imageCoverImage=itemView.findViewById(R.id.coverImage);
        }
    }
}
