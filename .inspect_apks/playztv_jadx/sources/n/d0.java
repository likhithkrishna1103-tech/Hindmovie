package n;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends RatingBar {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b0 f8365u;

    /* JADX WARN: Illegal instructions before constructor call */
    public d0(Context context, AttributeSet attributeSet) {
        int i = g.a.ratingBarStyle;
        super(context, attributeSet, i);
        b3.a(getContext(), this);
        b0 b0Var = new b0(this);
        this.f8365u = b0Var;
        b0Var.b(attributeSet, i);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        Bitmap bitmap = (Bitmap) this.f8365u.f8349c;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
