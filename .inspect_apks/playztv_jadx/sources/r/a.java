package r;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f11197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f11198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f11199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f11200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f11201e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f11203h;
    public PorterDuffColorFilter i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f11204j;
    public boolean f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11202g = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f11205k = PorterDuff.Mode.SRC_IN;

    public a(ColorStateList colorStateList, float f) {
        this.f11197a = f;
        Paint paint = new Paint(5);
        this.f11198b = paint;
        colorStateList = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.f11203h = colorStateList;
        paint.setColor(colorStateList.getColorForState(getState(), this.f11203h.getDefaultColor()));
        this.f11199c = new RectF();
        this.f11200d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void b(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        float f = rect.left;
        float f4 = rect.top;
        float f10 = rect.right;
        float f11 = rect.bottom;
        RectF rectF = this.f11199c;
        rectF.set(f, f4, f10, f11);
        Rect rect2 = this.f11200d;
        rect2.set(rect);
        if (this.f) {
            rect2.inset((int) Math.ceil(b.a(this.f11201e, this.f11197a, this.f11202g)), (int) Math.ceil(b.b(this.f11201e, this.f11197a, this.f11202g)));
            rectF.set(rect2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z2;
        PorterDuffColorFilter porterDuffColorFilter = this.i;
        Paint paint = this.f11198b;
        if (porterDuffColorFilter == null || paint.getColorFilter() != null) {
            z2 = false;
        } else {
            paint.setColorFilter(this.i);
            z2 = true;
        }
        RectF rectF = this.f11199c;
        float f = this.f11197a;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z2) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f11200d, this.f11197a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.f11204j;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f11203h;
        return (colorStateList2 != null && colorStateList2.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        b(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f11203h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.f11198b;
        boolean z2 = colorForState != paint.getColor();
        if (z2) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f11204j;
        if (colorStateList2 == null || (mode = this.f11205k) == null) {
            return z2;
        }
        this.i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f11198b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f11198b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f11204j = colorStateList;
        this.i = a(colorStateList, this.f11205k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f11205k = mode;
        this.i = a(this.f11204j, mode);
        invalidateSelf();
    }
}
