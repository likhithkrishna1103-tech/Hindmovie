package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends v4.s {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f2904q = 0;

    public /* synthetic */ x(Context context) {
        super(context);
    }

    @Override // v4.s
    public int b(View view, int i) {
        switch (this.f2904q) {
            case 1:
                return 0;
            default:
                return super.b(view, i);
        }
    }

    @Override // v4.s
    public int c(View view, int i) {
        switch (this.f2904q) {
            case 1:
                return 0;
            default:
                return super.c(view, i);
        }
    }

    @Override // v4.s
    public float d(DisplayMetrics displayMetrics) {
        switch (this.f2904q) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return 100.0f / displayMetrics.densityDpi;
            default:
                return super.d(displayMetrics);
        }
    }

    @Override // v4.s
    public PointF f(int i) {
        switch (this.f2904q) {
            case 1:
                return null;
            default:
                return super.f(i);
        }
    }

    public x(CarouselLayoutManager carouselLayoutManager, Context context) {
        super(context);
    }
}
