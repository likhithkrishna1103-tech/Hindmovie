package s8;

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
import android.widget.FrameLayout;
import j9.a0;
import j9.e0;
import j9.z;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import n9.d;
import p8.j;
import p8.k;
import q9.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Drawable implements z {
    public static final int H = k.Widget_MaterialComponents_Badge;
    public static final int I = p8.b.badgeStyle;
    public float A;
    public final int B;
    public float C;
    public float D;
    public float E;
    public WeakReference F;
    public WeakReference G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final WeakReference f11912u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g f11913v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a0 f11914w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Rect f11915x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c f11916y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f11917z;

    public a(Context context, b bVar) {
        d dVar;
        WeakReference weakReference = new WeakReference(context);
        this.f11912u = weakReference;
        e0.c(context, e0.f6882b, "Theme.MaterialComponents");
        this.f11915x = new Rect();
        a0 a0Var = new a0(this);
        this.f11914w = a0Var;
        Paint.Align align = Paint.Align.CENTER;
        TextPaint textPaint = a0Var.f6836a;
        textPaint.setTextAlign(align);
        c cVar = new c(context, bVar);
        this.f11916y = cVar;
        boolean zF = f();
        b bVar2 = cVar.f11925b;
        g gVar = new g(q9.k.a(context, zF ? bVar2.A.intValue() : bVar2.f11922y.intValue(), f() ? bVar2.B.intValue() : bVar2.f11923z.intValue()).a());
        this.f11913v = gVar;
        h();
        Context context2 = (Context) weakReference.get();
        if (context2 != null && a0Var.f6841g != (dVar = new d(context2, bVar2.f11921x.intValue()))) {
            a0Var.b(dVar, context2);
            textPaint.setColor(bVar2.f11920w.intValue());
            invalidateSelf();
            j();
            invalidateSelf();
        }
        int i = bVar2.F;
        if (i != -2) {
            this.B = ((int) Math.pow(10.0d, ((double) i) - 1.0d)) - 1;
        } else {
            this.B = bVar2.G;
        }
        a0Var.f6840e = true;
        j();
        invalidateSelf();
        a0Var.f6840e = true;
        h();
        j();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(bVar2.f11919v.intValue());
        if (gVar.f11105u.f11092c != colorStateListValueOf) {
            gVar.l(colorStateListValueOf);
            invalidateSelf();
        }
        textPaint.setColor(bVar2.f11920w.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.F;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = (View) this.F.get();
            WeakReference weakReference3 = this.G;
            i(view, weakReference3 != null ? (FrameLayout) weakReference3.get() : null);
        }
        j();
        setVisible(bVar2.N.booleanValue(), false);
    }

    @Override // j9.z
    public final void a() {
        invalidateSelf();
    }

    public final String b() {
        c cVar = this.f11916y;
        b bVar = cVar.f11925b;
        b bVar2 = cVar.f11925b;
        String str = bVar.D;
        WeakReference weakReference = this.f11912u;
        if (str == null) {
            if (!g()) {
                return null;
            }
            int i = this.B;
            if (i == -2 || e() <= i) {
                return NumberFormat.getInstance(bVar2.H).format(e());
            }
            Context context = (Context) weakReference.get();
            return context == null ? "" : String.format(bVar2.H, context.getString(j.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(i), "+");
        }
        int i10 = bVar.F;
        if (i10 == -2 || str == null || str.length() <= i10) {
            return str;
        }
        Context context2 = (Context) weakReference.get();
        if (context2 == null) {
            return "";
        }
        return String.format(context2.getString(j.m3_exceed_max_badge_text_suffix), str.substring(0, i10 - 1), "…");
    }

    public final CharSequence c() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        c cVar = this.f11916y;
        b bVar = cVar.f11925b;
        b bVar2 = cVar.f11925b;
        if (bVar.D != null) {
            CharSequence charSequence = bVar.I;
            return charSequence != null ? charSequence : cVar.f11925b.D;
        }
        if (!g()) {
            return bVar2.J;
        }
        if (bVar2.K == 0 || (context = (Context) this.f11912u.get()) == null) {
            return null;
        }
        int i = this.B;
        return (i == -2 || e() <= i) ? context.getResources().getQuantityString(bVar2.K, e(), Integer.valueOf(e())) : context.getString(bVar2.L, Integer.valueOf(i));
    }

    public final FrameLayout d() {
        WeakReference weakReference = this.G;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        String strB;
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f11913v.draw(canvas);
        if (!f() || (strB = b()) == null) {
            return;
        }
        Rect rect = new Rect();
        a0 a0Var = this.f11914w;
        a0Var.f6836a.getTextBounds(strB, 0, strB.length(), rect);
        float fExactCenterY = this.A - rect.exactCenterY();
        canvas.drawText(strB, this.f11917z, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), a0Var.f6836a);
    }

    public final int e() {
        int i = this.f11916y.f11925b.E;
        if (i != -1) {
            return i;
        }
        return 0;
    }

    public final boolean f() {
        return this.f11916y.f11925b.D != null || g();
    }

    public final boolean g() {
        b bVar = this.f11916y.f11925b;
        return bVar.D == null && bVar.E != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f11916y.f11925b.C;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f11915x.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f11915x.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void h() {
        Context context = (Context) this.f11912u.get();
        if (context == null) {
            return;
        }
        boolean zF = f();
        c cVar = this.f11916y;
        this.f11913v.setShapeAppearanceModel(q9.k.a(context, zF ? cVar.f11925b.A.intValue() : cVar.f11925b.f11922y.intValue(), f() ? cVar.f11925b.B.intValue() : cVar.f11925b.f11923z.intValue()).a());
        invalidateSelf();
    }

    public final void i(View view, FrameLayout frameLayout) {
        this.F = new WeakReference(view);
        this.G = new WeakReference(frameLayout);
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0284  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instruction units count: 710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.a.j():void");
    }

    @Override // android.graphics.drawable.Drawable, j9.z
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        c cVar = this.f11916y;
        cVar.f11924a.C = i;
        cVar.f11925b.C = i;
        this.f11914w.f6836a.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
