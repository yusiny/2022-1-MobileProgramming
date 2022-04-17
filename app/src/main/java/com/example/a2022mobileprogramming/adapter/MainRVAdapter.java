package com.example.a2022mobileprogramming.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2022mobileprogramming.R;
import com.example.a2022mobileprogramming.model.WeekInfoModel;

import java.util.ArrayList;
import java.util.List;

public class MainRVAdapter extends RecyclerView.Adapter<MainRVAdapter.ViewHolder> {
    private List<WeekInfoModel> datas = new ArrayList<>();

    public interface OnItemClickListener{
        void onItemclick(View v,int position);
    }

    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

   @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater= LayoutInflater.from(parent.getContext());
       View view=inflater.inflate(R.layout.item_button,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeekInfoModel info = datas.get(position);
        holder.bind(info);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button btn;
        private TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.main_btn);
            tv = itemView.findViewById(R.id.main_tv);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemclick(view, getAdapterPosition());
                    Log.d("Click", "클릭됨");
                }
            });
        }

        //규칙3
        public void bind(WeekInfoModel info){
            btn.setText("Week " + info.getWeek());
            tv.setText(info.getSubject());
        }
    }

    public void addItem(WeekInfoModel info){
        datas.add(info);
    }
}
