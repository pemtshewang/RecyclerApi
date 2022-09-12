package com.example.recyclerapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
/* Adapter class for the RecyclerView
*  */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    /*We are creating a var postList to store the JSON data received.*/
    private List<Posts> postList;
    public PostAdapter(List<Posts> postList) {
        //constructor for the PostAdapter Class
        this.postList = postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //get the view list-item and inflate them into parent view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        /*Filling the view with constructors*/
    //topic
    holder.tvTitle.setText("Name: "+postList.get(position).getName());
    //body
    holder.quoteText.setText("Says: "+"\n"+postList.get(position).getBody());
    //email
    holder.authorName.setText("Email: "+postList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle,quoteText,authorName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            quoteText = itemView.findViewById(R.id.quoteText);
            authorName = itemView.findViewById(R.id.authorName);
        }
    }
}
