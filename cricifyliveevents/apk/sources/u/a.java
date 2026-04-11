package u;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f12033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f12034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f12035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f12036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f12037e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f12039h;
    public PorterDuffColorFilter i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f12040j;
    public boolean f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f12038g = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f12041k = PorterDuff.Mode.SRC_IN;

    public a(ColorStateList colorStateList, float f) {
        this.f12033a = f;
        Paint paint = new Paint(5);
        this.f12034b = paint;
        colorStateList = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.f12039h = colorStateList;
        paint.setColor(colorStateList.getColorForState(getState(), this.f12039h.getDefaultColor()));
        this.f12035c = new RectF();
        this.f12036d = new Rect();
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
        float f10 = rect.top;
        float f11 = rect.right;
        float f12 = rect.bottom;
        RectF rectF = this.f12035c;
        rectF.set(f, f10, f11, f12);
        Rect rect2 = this.f12036d;
        rect2.set(rect);
        if (this.f) {
            rect2.inset((int) Math.ceil(b.a(this.f12037e, this.f12033a, this.f12038g)), (int) Math.ceil(b.b(this.f12037e, this.f12033a, this.f12038g)));
            rectF.set(rect2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z10;
        PorterDuffColorFilter porterDuffColorFilter = this.i;
        Paint paint = this.f12034b;
        if (porterDuffColorFilter == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.i);
            z10 = true;
        }
        RectF rectF = this.f12035c;
        float f = this.f12033a;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f12036d, this.f12033a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.f12040j;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f12039h;
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
        ColorStateList colorStateList = this.f12039h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.f12034b;
        boolean z10 = colorForState != paint.getColor();
        if (z10) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f12040j;
        if (colorStateList2 == null || (mode = this.f12041k) == null) {
            return z10;
        }
        this.i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f12034b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f12034b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f12040j = colorStateList;
        this.i = a(colorStateList, this.f12041k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f12041k = mode;
        this.i = a(this.f12040j, mode);
        invalidateSelf();
    }
}
