package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

/**g
 * Created by Vamsi Rao on 5/11/2017.
 */

public class BodyPartFragment extends Fragment {

    private List<Integer> mImageIds;
    private int mListIndex;

    public static final String IMAGE_ID_LIST="image_ids";
    public static final String LIST_INDEX="list_index";
    public BodyPartFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState!=null){
            mImageIds=savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex=savedInstanceState.getInt(LIST_INDEX);
        }



        View rootView= inflater.inflate(R.layout.fragment_body_part,container,false);
       //Because we're trying to find image view inside the rootview.
        final ImageView imageView= (ImageView)rootView.findViewById(R.id.body_part_image_view);

        if(mImageIds != null){
            // Set the image resource to the list item at the stored index
            imageView.setImageResource(mImageIds.get(mListIndex));}
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(mListIndex<mImageIds.size()-1){
                  mListIndex++;
              } else{
                  mListIndex=0;
              }

                    imageView.setImageResource(mImageIds.get(mListIndex));

            }
        });


        return rootView;
    }

    public void setImageIds(List<Integer> imageIds){
        mImageIds=imageIds;
    }
    public void setListIndex(int index){
        mListIndex=index;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST,(ArrayList<Integer>)mImageIds);
        currentState.putInt(LIST_INDEX,mListIndex);
    }
}
