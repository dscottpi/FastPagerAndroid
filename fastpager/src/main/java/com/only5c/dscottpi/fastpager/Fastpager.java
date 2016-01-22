package com.only5c.dscottpi.fastpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by dan on 18/01/2016.
 */
public class Fastpager extends RelativeLayout implements SeekBar.OnSeekBarChangeListener {

    private SeekBar seekBar;
    private TextView tvCurPos;
    private ViewPager viewPager;
    private Context context;
    private boolean smoothScroll = false;
    private View mainLayout;
    private CardView cardView;

    private final static String FADE_KEY = "FADE";


    public Fastpager(Context context) {
        super(context);
        initView();
    }

    public Fastpager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public Fastpager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(context).inflate(R.layout.fast_pager, this, true);
        mainLayout = findViewById(R.id.framelayout);
        seekBar = (SeekBar) mainLayout.findViewById(R.id.seekbar);
        tvCurPos = (TextView) mainLayout.findViewById(R.id.tv_cur_pos);
        cardView = (CardView) findViewById(R.id.cardView);
    }

    private void initViewPager() {
        seekBar.setMax(viewPager.getAdapter().getCount() - 1);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar.setProgress(viewPager.getCurrentItem());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                seekBar.setProgress(position);
                updateCurPos(position, seekBar.getMax());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        updateCurPos(seekBar.getProgress(), seekBar.getMax());
    }

    @Override
    public void onProgressChanged(final SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            viewPager.setCurrentItem(progress, smoothScroll);
            updateCurPos(progress, seekBar.getMax());
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void updateCurPos(int pos, int max) {
        tvCurPos.setText(pos + "/" + max);
    }

    /**
     * Use Smooth Scroll in viewpager. Defaults to false.
     * @param smoothScroll boolean for smooth scroll.
     */
    public void setSmoothScroll(boolean smoothScroll) {
        this.smoothScroll = smoothScroll;
    }

    /**
     * Set the ViewPager for FastPager to use
     * @param viewPager the viewPager to use.
     */
    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        initViewPager();
    }

    /**
     * Fade in/out the view.
     */
    public void toggleFade() {
        if (context.getSharedPreferences(FADE_KEY, 0).getBoolean(FADE_KEY, false)) {

            context.getSharedPreferences(FADE_KEY, 0).edit()
                    .putBoolean(FADE_KEY, false).apply();

            cardView.animate().alpha(1).setDuration(300).start();
            cardView.setVisibility(View.VISIBLE);

        } else {

            context.getSharedPreferences(FADE_KEY, 0).edit()
                    .putBoolean(FADE_KEY, true).apply();

            cardView.animate().alpha(0).setDuration(300).start();
            cardView.setVisibility(View.GONE);
        }
    }
}
