package n9;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import da.a0;
import da.b0;
import da.d0;
import ha.d;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import k9.j;
import k9.k;
import ka.i;
import ka.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Drawable implements a0 {
    public static final int I = k.Widget_MaterialComponents_Badge;
    public static final int J = k9.b.badgeStyle;
    public float A;
    public float B;
    public final int C;
    public float D;
    public float E;
    public float F;
    public WeakReference G;
    public WeakReference H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final WeakReference f8901v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f8902w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b0 f8903x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Rect f8904y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f8905z;

    public a(Context context) {
        d dVar;
        WeakReference weakReference = new WeakReference(context);
        this.f8901v = weakReference;
        d0.c(context, d0.f3611b, "Theme.MaterialComponents");
        this.f8904y = new Rect();
        b0 b0Var = new b0(this);
        this.f8903x = b0Var;
        Paint.Align align = Paint.Align.CENTER;
        TextPaint textPaint = b0Var.f3567a;
        textPaint.setTextAlign(align);
        c cVar = new c(context);
        this.f8905z = cVar;
        boolean zF = f();
        b bVar = cVar.f8912b;
        i iVar = new i(m.a(context, zF ? bVar.B.intValue() : bVar.f8910z.intValue(), f() ? bVar.C.intValue() : bVar.A.intValue()).a());
        this.f8902w = iVar;
        h();
        Context context2 = (Context) weakReference.get();
        if (context2 != null && b0Var.f3572g != (dVar = new d(context2, bVar.f8909y.intValue()))) {
            b0Var.b(dVar, context2);
            textPaint.setColor(bVar.f8908x.intValue());
            invalidateSelf();
            j();
            invalidateSelf();
        }
        int i = bVar.G;
        if (i != -2) {
            this.C = ((int) Math.pow(10.0d, ((double) i) - 1.0d)) - 1;
        } else {
            this.C = bVar.H;
        }
        b0Var.f3571e = true;
        j();
        invalidateSelf();
        b0Var.f3571e = true;
        h();
        j();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(bVar.f8907w.intValue());
        if (iVar.f7334w.f7319d != colorStateListValueOf) {
            iVar.q(colorStateListValueOf);
            invalidateSelf();
        }
        textPaint.setColor(bVar.f8908x.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.G;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = (View) this.G.get();
            WeakReference weakReference3 = this.H;
            i(view, weakReference3 != null ? (FrameLayout) weakReference3.get() : null);
        }
        j();
        setVisible(bVar.O.booleanValue(), false);
    }

    @Override // da.a0
    public final void a() {
        invalidateSelf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(View view, View view2) {
        float y10;
        float x10;
        ViewParent parent;
        boolean z10;
        FrameLayout frameLayoutD = d();
        if (frameLayoutD == null) {
            float y11 = view.getY();
            x10 = view.getX();
            parent = view.getParent();
            y10 = y11;
        } else {
            y10 = 0.0f;
            x10 = 0.0f;
            parent = frameLayoutD;
        }
        while (true) {
            z10 = parent instanceof View;
            if (!z10 || parent == view2) {
                break;
            }
            ViewParent parent2 = parent.getParent();
            if (!(parent2 instanceof ViewGroup) || ((ViewGroup) parent2).getClipChildren()) {
                break;
            }
            View view3 = (View) parent;
            y10 += view3.getY();
            x10 += view3.getX();
            parent = parent.getParent();
        }
        if (z10) {
            float f = (this.B - this.F) + y10;
            float f10 = (this.A - this.E) + x10;
            View view4 = (View) parent;
            float height = ((this.B + this.F) - view4.getHeight()) + y10;
            float width = ((this.A + this.E) - view4.getWidth()) + x10;
            if (f < 0.0f) {
                this.B = Math.abs(f) + this.B;
            }
            if (f10 < 0.0f) {
                this.A = Math.abs(f10) + this.A;
            }
            if (height > 0.0f) {
                this.B -= Math.abs(height);
            }
            if (width > 0.0f) {
                this.A -= Math.abs(width);
            }
        }
    }

    public final String c() {
        c cVar = this.f8905z;
        b bVar = cVar.f8912b;
        b bVar2 = cVar.f8912b;
        String str = bVar.E;
        WeakReference weakReference = this.f8901v;
        if (str == null) {
            if (!g()) {
                return null;
            }
            int i = this.C;
            if (i == -2 || e() <= i) {
                return NumberFormat.getInstance(bVar2.I).format(e());
            }
            Context context = (Context) weakReference.get();
            return context == null ? "" : String.format(bVar2.I, context.getString(j.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(i), "+");
        }
        int i10 = bVar.G;
        if (i10 == -2 || str == null || str.length() <= i10) {
            return str;
        }
        Context context2 = (Context) weakReference.get();
        if (context2 == null) {
            return "";
        }
        return String.format(context2.getString(j.m3_exceed_max_badge_text_suffix), str.substring(0, i10 - 1), "…");
    }

    public final FrameLayout d() {
        WeakReference weakReference = this.H;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        String strC;
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f8902w.draw(canvas);
        if (!f() || (strC = c()) == null) {
            return;
        }
        Rect rect = new Rect();
        b0 b0Var = this.f8903x;
        b0Var.f3567a.getTextBounds(strC, 0, strC.length(), rect);
        float fExactCenterY = this.B - rect.exactCenterY();
        canvas.drawText(strC, this.A, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), b0Var.f3567a);
    }

    public final int e() {
        int i = this.f8905z.f8912b.F;
        if (i != -1) {
            return i;
        }
        return 0;
    }

    public final boolean f() {
        return this.f8905z.f8912b.E != null || g();
    }

    public final boolean g() {
        b bVar = this.f8905z.f8912b;
        return bVar.E == null && bVar.F != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f8905z.f8912b.D;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f8904y.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f8904y.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void h() {
        Context context = (Context) this.f8901v.get();
        if (context == null) {
            return;
        }
        boolean zF = f();
        c cVar = this.f8905z;
        this.f8902w.setShapeAppearanceModel(m.a(context, zF ? cVar.f8912b.B.intValue() : cVar.f8912b.f8910z.intValue(), f() ? cVar.f8912b.C.intValue() : cVar.f8912b.A.intValue()).a());
        invalidateSelf();
    }

    public final void i(View view, FrameLayout frameLayout) {
        this.G = new WeakReference(view);
        this.H = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        j();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x011e A[PHI: r14
      0x011e: PHI (r14v2 int) = (r14v1 int), (r14v8 int) binds: [B:45:0x00e8, B:47:0x00f6] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instruction units count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n9.a.j():void");
    }

    @Override // android.graphics.drawable.Drawable, da.a0
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        c cVar = this.f8905z;
        cVar.f8911a.D = i;
        cVar.f8912b.D = i;
        this.f8903x.f3567a.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
