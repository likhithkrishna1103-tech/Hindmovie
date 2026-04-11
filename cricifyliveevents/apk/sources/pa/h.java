package pa;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends ka.i {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final /* synthetic */ int f10066d0 = 0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public g f10067c0;

    @Override // ka.i
    public final void g(Canvas canvas) {
        if (this.f10067c0.f10065r.isEmpty()) {
            super.g(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.f10067c0.f10065r);
        } else {
            canvas.clipRect(this.f10067c0.f10065r, Region.Op.DIFFERENCE);
        }
        super.g(canvas);
        canvas.restore();
    }

    @Override // ka.i, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.f10067c0 = new g(this.f10067c0);
        return this;
    }

    public final void y(float f, float f10, float f11, float f12) {
        RectF rectF = this.f10067c0.f10065r;
        if (f == rectF.left && f10 == rectF.top && f11 == rectF.right && f12 == rectF.bottom) {
            return;
        }
        rectF.set(f, f10, f11, f12);
        invalidateSelf();
    }
}
