package j9;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class w extends FrameLayout {
    public boolean A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Drawable f6907u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Rect f6908v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Rect f6909w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f6910x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6911y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f6912z;

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Rect rect = this.f6909w;
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f6908v == null || this.f6907u == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f6910x) {
            rect.set(0, 0, width, this.f6908v.top);
            this.f6907u.setBounds(rect);
            this.f6907u.draw(canvas);
        }
        if (this.f6911y) {
            rect.set(0, height - this.f6908v.bottom, width, height);
            this.f6907u.setBounds(rect);
            this.f6907u.draw(canvas);
        }
        if (this.f6912z) {
            Rect rect2 = this.f6908v;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f6907u.setBounds(rect);
            this.f6907u.draw(canvas);
        }
        if (this.A) {
            Rect rect3 = this.f6908v;
            rect.set(width - rect3.right, rect3.top, width, height - rect3.bottom);
            this.f6907u.setBounds(rect);
            this.f6907u.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f6907u;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f6907u;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z2) {
        this.f6911y = z2;
    }

    public void setDrawLeftInsetForeground(boolean z2) {
        this.f6912z = z2;
    }

    public void setDrawRightInsetForeground(boolean z2) {
        this.A = z2;
    }

    public void setDrawTopInsetForeground(boolean z2) {
        this.f6910x = z2;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f6907u = drawable;
    }
}
