package com.example.uasmcsv3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> posts = new ArrayList<>();

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView bodyTextView;
        private TextView userIdTextView;
        private TextView idTextView;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.itemHomeTittle);
            bodyTextView = itemView.findViewById(R.id.itemHomeBody);
            userIdTextView = itemView.findViewById(R.id.itemHomeUserId);
            idTextView = itemView.findViewById(R.id.itemHomeId);
        }

        public void bind(Post post) {
            titleTextView.setText(post.getTitle());
            bodyTextView.setText(post.getBody());
            userIdTextView.setText(String.valueOf(post.getUserId()));
            idTextView.setText(String.valueOf(post.getId()));
        }
    }
}
