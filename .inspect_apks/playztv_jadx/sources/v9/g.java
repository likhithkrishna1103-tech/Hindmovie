package v9;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends q9.g {
    public static final /* synthetic */ int T = 0;
    public f S;

    @Override // q9.g
    public final void f(Canvas canvas) {
        if (this.S.f13353r.isEmpty()) {
            super.f(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.S.f13353r);
        } else {
            canvas.clipRect(this.S.f13353r, Region.Op.DIFFERENCE);
        }
        super.f(canvas);
        canvas.restore();
    }

    @Override // q9.g, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.S = new f(this.S);
        return this;
    }

    public final void r(float f, float f4, float f10, float f11) {
        RectF rectF = this.S.f13353r;
        if (f == rectF.left && f4 == rectF.top && f10 == rectF.right && f11 == rectF.bottom) {
            return;
        }
        rectF.set(f, f4, f10, f11);
        invalidateSelf();
    }
}
