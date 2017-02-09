package com.example.zmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class PhotoActivity extends Activity implements ViewFactory{

	private int[] images =new int[] { R.drawable.x01, R.drawable.x03, 
			R.drawable.x04, R.drawable.x06, R.drawable.x07};
	private ImageSwitcher switcher; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);

		switcher = (ImageSwitcher)this.findViewById(R.id.imageSwitcher1); 
		switcher.setFactory(this); 
		switcher.setImageResource(images[0]); 
		switcher.setInAnimation(AnimationUtils.loadAnimation(this, 
				android.R.anim.fade_in)); 
		switcher.setOutAnimation(AnimationUtils.loadAnimation(this, 
				android.R.anim.fade_out)); 

		Gallery gallery = (Gallery) this.findViewById(R.id.gallery1); 
		gallery.setSelection(images.length/2); 
		gallery.setAdapter(new ImageAdapter()); 
		gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() { 

			public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, 
					long arg3) { 
				switcher.setImageResource(images[arg2]); 
			} 
		});

		gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { 

            public void onItemSelected(AdapterView<?> arg0, View arg1, 
                    int arg2, long arg3) { 
                switcher.setImageResource(images[arg2]); 
            } 
            public void onNothingSelected(AdapterView<?> arg0) { 
            } 
        });
	}

	public class ImageAdapter extends BaseAdapter{ 

		public int getCount() { 
			return images.length; 

		} 
		public Object getItem(int position) { 
			return position; 
		} 
		public long getItemId(int position) { 
			return position; 
		} 
		public View getView(int position, View convertView, ViewGroup parent) { 
			ImageView views =new ImageView(PhotoActivity.this); 
			views.setImageResource(images[position]); 
			views.setAdjustViewBounds(true); 
			views.setMaxHeight(80); 
			views.setMaxWidth(120); 
			views.setScaleType(ImageView.ScaleType.FIT_CENTER); 
			views.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)); 
			return views; 
		} 
	} 

	@Override
	public View makeView() {
		ImageView i =new ImageView(PhotoActivity.this); 
		i.setBackgroundColor(55000000); 
		i.setScaleType(ImageView.ScaleType.CENTER_CROP); 
		return i; 
	}

}
