package com.hervinda.training.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hervinda.training.R;
import com.hervinda.training.model.TrainingModel;

import java.util.List;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>  {
    private Context context;
    private List<TrainingModel> trainingModels;
    public TrainingAdapter(Context context,
                           List<TrainingModel> trainingModels) {
        this.context = context;
        this.trainingModels = trainingModels;     }
    @NonNull     @Override
    public TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_training, parent, false);
        return new TrainingViewHolder(view);     }
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull TrainingViewHolder holder, int position) {
        if (trainingModels.get(position).getStatusTraining().contains("pending")){
            holder.tvNamaTrainingItem.setBackgroundColor(R.color.colorAccent);
            holder.containerAkftifkan.setVisibility(View.VISIBLE);         }
        holder.tvNamaTrainingItem.setText(trainingModels.get(position).getNamaTraining());
        holder.tvTipeTrainingItem.setText(trainingModels.get(position).getTypeTraining());
        holder.tvKuotaTrainingItem.setText(trainingModels.get(position).getJumlahTraining());
        holder.tvHargaTrainingItem.setText(trainingModels.get(position).getHargaTraining());
        holder.tvTanggalTrainingItem.setText(trainingModels.get(position).getTanggalTraining());
        holder.tvStatusTrainingItem.setText(trainingModels.get(position).getStatusTraining());
        Glide.with(context).load(trainingModels.get(position).getGambarTraining()).error(R.drawable.ic_menu_gallery).into(holder.ivImageTrainingItem);
    }
    @Override     public int getItemCount() {         return trainingModels.size();     }
    public class TrainingViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNamaTrainingItem;
        private TextView tvTipeTrainingItem;
        private TextView tvKuotaTrainingItem;
        private TextView tvHargaTrainingItem;
        private TextView tvTanggalTrainingItem;
        private TextView tvStatusTrainingItem;
        private ImageView ivImageTrainingItem;
        private LinearLayout containerAkftifkan;
        private Button btnAktifkan;
        private CardView cvItemTraining;
        public TrainingViewHolder(@NonNull View itemView) {             super(itemView);
        tvNamaTrainingItem = itemView.findViewById(R.id.tv_nama_training_item);
        tvTipeTrainingItem = itemView.findViewById(R.id.tv_tipe_training_item);
        tvKuotaTrainingItem = itemView.findViewById(R.id.tv_kuota_training_item);
        tvHargaTrainingItem = itemView.findViewById(R.id.tv_harga_training_item);
        tvTanggalTrainingItem = itemView.findViewById(R.id.tv_tanggal_training_item);
        tvStatusTrainingItem = itemView.findViewById(R.id.tv_status_training_item);
        ivImageTrainingItem = itemView.findViewById(R.id.iv_image_training_item);
            containerAkftifkan = itemView.findViewById(R.id.container_aktifkan);
            btnAktifkan = itemView.findViewById(R.id.btn_aktifkan_training_item);
            cvItemTraining = itemView.findViewById(R.id.cv_training_item);         }     }
}
