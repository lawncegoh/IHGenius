package orbital.milestone2;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;


import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context mContext;
    private List<Upload> mUploads;
    private StorageReference ref = FirebaseStorage.getInstance().getReference("Image Uploads");

    public ImageAdapter(Context context, List<Upload> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, int position) {
        Upload uploadCur = mUploads.get(position);
//        holder.textViewName.setText(uploadCurrent.getName());
//        System.out.println(uploadCurrent.getImageUrl());
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/ihgenius-5e66d.appspot.com/o/Image%20Uploads%2F2019-07-25%2012.09.53.jpg?alt=media&token=83c75a36-9f4c-4cfa-aa92-ddbb00f224ed")
                .fit().centerCrop().into(holder.imageView);

//        Picasso.get().load(ref.child("test.jpg").getDownloadUrl().getResult())
//                .into(holder.imageView);
//        System.out.println(uploadCurrent.getImageUrl());
    }

    @Override
    public int getItemCount() {
        int a;
        if (mUploads != null && !mUploads.isEmpty()) {
            a = mUploads.size();
        } else {
            a = 0;
        }
        return a;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
        }
    }

}
