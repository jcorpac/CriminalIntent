package com.bignerdranch.android.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Jeff on 2/17/2016.
 */
public class ImagePreviewFragment extends DialogFragment {

    private static String ARG_IMAGE = "com.bignerdranch.android.criminalintent.image";

    private ImageView mImageView;
    private File mImageFile;

    public static ImagePreviewFragment newInstance(File imageFile) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_IMAGE, imageFile);
        ImagePreviewFragment fragment = new ImagePreviewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mImageFile = (File)getArguments().getSerializable(ARG_IMAGE);
        Bitmap imageBitmap = PictureUtils.getScaledBitmap(mImageFile.getPath(), getActivity());

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_image_preview, null);
        mImageView = (ImageView)v.findViewById(R.id.image_preview_imageview);;
        mImageView.setImageBitmap(imageBitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Scene of the crime!")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
    }
}
