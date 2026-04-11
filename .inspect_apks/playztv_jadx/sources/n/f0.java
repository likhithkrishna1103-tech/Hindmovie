package n;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends SeekBar {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final g0 f8380u;

    /* JADX WARN: Illegal instructions before constructor call */
    public f0(Context context, AttributeSet attributeSet) {
        int i = g.a.seekBarStyle;
        super(context, attributeSet, i);
        b3.a(getContext(), this);
        g0 g0Var = new g0(this);
        this.f8380u = g0Var;
        g0Var.b(attributeSet, i);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        g0 g0Var = this.f8380u;
        f0 f0Var = g0Var.f8390e;
        Drawable drawable = g0Var.f;
        if (drawable != null && drawable.isStateful() && drawable.setState(f0Var.getDrawableState())) {
            f0Var.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f8380u.f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8380u.g(canvas);
    }
}
