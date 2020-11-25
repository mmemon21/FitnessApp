package com.example.fitnessproject3fall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessproject3fall.model.GroupChat;
import com.example.fitnessproject3fall.model.Videos;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoViewHolder> {

    List<Videos> videosList;

    public VideosAdapter(){

    }
    public VideosAdapter(List<Videos> videos){
        this.videosList=videos;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_video,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position){
        holder.videoWeb.loadData(videosList.get(position).getVideo_url(),"text/html","utf-8");
    }

    @Override
    public int getItemCount(){return videosList.size();}

    public class VideoViewHolder extends RecyclerView.ViewHolder{
        WebView videoWeb;

        public VideoViewHolder(View itemView){
            super(itemView);

            videoWeb = (WebView) itemView.findViewById(R.id.videoView);
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient(){});

        }
    }

}

