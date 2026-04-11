package o;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends SeekBar {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e0 f9192v;

    /* JADX WARN: Illegal instructions before constructor call */
    public d0(Context context, AttributeSet attributeSet) {
        int i = g.a.seekBarStyle;
        super(context, attributeSet, i);
        f3.a(getContext(), this);
        e0 e0Var = new e0(this);
        this.f9192v = e0Var;
        e0Var.b(attributeSet, i);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        e0 e0Var = this.f9192v;
        d0 d0Var = e0Var.f9200e;
        Drawable drawable = e0Var.f;
        if (drawable != null && drawable.isStateful() && drawable.setState(d0Var.getDrawableState())) {
            d0Var.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f9192v.f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f9192v.g(canvas);
    }
}
