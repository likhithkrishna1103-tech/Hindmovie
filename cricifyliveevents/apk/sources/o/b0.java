package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends RatingBar {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final z f9183v;

    /* JADX WARN: Illegal instructions before constructor call */
    public b0(Context context, AttributeSet attributeSet) {
        int i = g.a.ratingBarStyle;
        super(context, attributeSet, i);
        f3.a(getContext(), this);
        z zVar = new z(this);
        this.f9183v = zVar;
        zVar.b(attributeSet, i);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        Bitmap bitmap = (Bitmap) this.f9183v.f9419c;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
