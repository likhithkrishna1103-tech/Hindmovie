package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends q4.t {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f3444q = 0;

    public /* synthetic */ w(Context context) {
        super(context);
    }

    @Override // q4.t
    public int b(View view, int i) {
        switch (this.f3444q) {
            case 1:
                return 0;
            default:
                return super.b(view, i);
        }
    }

    @Override // q4.t
    public int c(View view, int i) {
        switch (this.f3444q) {
            case 1:
                return 0;
            default:
                return super.c(view, i);
        }
    }

    @Override // q4.t
    public float d(DisplayMetrics displayMetrics) {
        switch (this.f3444q) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return 100.0f / displayMetrics.densityDpi;
            default:
                return super.d(displayMetrics);
        }
    }

    @Override // q4.t
    public PointF f(int i) {
        switch (this.f3444q) {
            case 1:
                return null;
            default:
                return super.f(i);
        }
    }

    public w(CarouselLayoutManager carouselLayoutManager, Context context) {
        super(context);
    }
}
