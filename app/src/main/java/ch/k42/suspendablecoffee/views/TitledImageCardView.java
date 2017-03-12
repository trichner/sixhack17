package ch.k42.suspendablecoffee.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ch.k42.suspendablecoffee.R;

public class TitledImageCardView extends LinearLayout {

    private TextView titleView;
    private ImageView imageView;

    public TitledImageCardView(Context context) {
        super(context);
        initializeViews(context);
    }

    public TitledImageCardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public TitledImageCardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }

    public TitledImageCardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.titled_image_card, this);
    }

    public void setTitle(CharSequence title){
        this.titleView.setText(title);
    }

    public CharSequence getTitle(){
        return this.titleView.getText();
    }

    public void setImageResource(int resId){
        this.imageView.setImageResource(resId);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        titleView = (TextView) findViewById(R.id.titledimagecard_title);
        imageView = (ImageView) findViewById(R.id.titledimagecard_image);
    }
}
