package da;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w extends FrameLayout {
    public boolean A;
    public boolean B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Drawable f3634v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Rect f3635w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Rect f3636x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f3637y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f3638z;

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Rect rect = this.f3636x;
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f3635w == null || this.f3634v == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f3637y) {
            rect.set(0, 0, width, this.f3635w.top);
            this.f3634v.setBounds(rect);
            this.f3634v.draw(canvas);
        }
        if (this.f3638z) {
            rect.set(0, height - this.f3635w.bottom, width, height);
            this.f3634v.setBounds(rect);
            this.f3634v.draw(canvas);
        }
        if (this.A) {
            Rect rect2 = this.f3635w;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f3634v.setBounds(rect);
            this.f3634v.draw(canvas);
        }
        if (this.B) {
            Rect rect3 = this.f3635w;
            rect.set(width - rect3.right, rect3.top, width, height - rect3.bottom);
            this.f3634v.setBounds(rect);
            this.f3634v.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f3634v;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f3634v;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z10) {
        this.f3638z = z10;
    }

    public void setDrawLeftInsetForeground(boolean z10) {
        this.A = z10;
    }

    public void setDrawRightInsetForeground(boolean z10) {
        this.B = z10;
    }

    public void setDrawTopInsetForeground(boolean z10) {
        this.f3637y = z10;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f3634v = drawable;
    }
}
