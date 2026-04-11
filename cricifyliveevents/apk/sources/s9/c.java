package s9;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.cardview.widget.CardView;
import com.google.android.material.card.MaterialCardView;
import k9.f;
import ka.e;
import ka.i;
import ka.k;
import ka.l;
import ka.m;
import nb.w;
import t.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final double f11622y = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ColorDrawable f11623z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialCardView f11624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f11625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f11626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f11627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11628e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11630h;
    public Drawable i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f11631j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f11632k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f11633l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public m f11634m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f11635n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RippleDrawable f11636o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LayerDrawable f11637p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i f11638q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11639r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f11640s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ValueAnimator f11641t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TimeInterpolator f11642u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f11643v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f11644w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f11645x;

    static {
        f11623z = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public c(MaterialCardView materialCardView, AttributeSet attributeSet, int i) {
        int i10 = MaterialCardView.J;
        this.f11625b = new Rect();
        this.f11639r = false;
        this.f11645x = 0.0f;
        this.f11624a = materialCardView;
        i iVar = new i(materialCardView.getContext(), attributeSet, i, i10);
        this.f11626c = iVar;
        iVar.m(materialCardView.getContext());
        iVar.s();
        l lVarG = iVar.f7334w.f7316a.g();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, d.CardView, i, t.c.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(d.CardView_cardCornerRadius)) {
            lVarG.b(typedArrayObtainStyledAttributes.getDimension(d.CardView_cardCornerRadius, 0.0f));
        }
        this.f11627d = new i();
        h(lVarG.a());
        this.f11642u = sd.i.D(materialCardView.getContext(), k9.b.motionEasingLinearInterpolator, l9.a.f7925a);
        this.f11643v = sd.i.C(materialCardView.getContext(), k9.b.motionDurationShort2, 300);
        this.f11644w = sd.i.C(materialCardView.getContext(), k9.b.motionDurationShort1, 300);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float b(com.bumptech.glide.d dVar, float f) {
        if (dVar instanceof k) {
            return (float) ((1.0d - f11622y) * ((double) f));
        }
        if (dVar instanceof e) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    public final float a() {
        com.bumptech.glide.d dVar = this.f11634m.f7350a;
        i iVar = this.f11626c;
        float fB = b(dVar, iVar.k());
        com.bumptech.glide.d dVar2 = this.f11634m.f7351b;
        float[] fArr = iVar.X;
        float fMax = Math.max(fB, b(dVar2, fArr != null ? fArr[0] : iVar.f7334w.f7316a.f.a(iVar.h())));
        com.bumptech.glide.d dVar3 = this.f11634m.f7352c;
        float[] fArr2 = iVar.X;
        float fB2 = b(dVar3, fArr2 != null ? fArr2[1] : iVar.f7334w.f7316a.f7355g.a(iVar.h()));
        com.bumptech.glide.d dVar4 = this.f11634m.f7353d;
        float[] fArr3 = iVar.X;
        return Math.max(fMax, Math.max(fB2, b(dVar4, fArr3 != null ? fArr3[2] : iVar.f7334w.f7316a.f7356h.a(iVar.h()))));
    }

    public final LayerDrawable c() {
        if (this.f11636o == null) {
            this.f11638q = new i(this.f11634m);
            this.f11636o = new RippleDrawable(this.f11632k, null, this.f11638q);
        }
        if (this.f11637p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f11636o, this.f11627d, this.f11631j});
            this.f11637p = layerDrawable;
            layerDrawable.setId(2, f.mtrl_card_checked_layer_id);
        }
        return this.f11637p;
    }

    public final b d(Drawable drawable) {
        int iCeil;
        int i;
        if (this.f11624a.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil((r0.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f));
            iCeil = (int) Math.ceil(r0.getMaxCardElevation() + (i() ? a() : 0.0f));
            i = iCeil2;
        } else {
            iCeil = 0;
            i = 0;
        }
        return new b(drawable, iCeil, i, iCeil, i);
    }

    public final void e(int i, int i10) {
        int iCeil;
        int iCeil2;
        int i11;
        int i12;
        if (this.f11637p != null) {
            MaterialCardView materialCardView = this.f11624a;
            if (materialCardView.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(((materialCardView.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f)) * 2.0f);
                iCeil2 = (int) Math.ceil((materialCardView.getMaxCardElevation() + (i() ? a() : 0.0f)) * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i13 = this.f11629g;
            int i14 = (i13 & 8388613) == 8388613 ? ((i - this.f11628e) - this.f) - iCeil2 : this.f11628e;
            int i15 = (i13 & 80) == 80 ? this.f11628e : ((i10 - this.f11628e) - this.f) - iCeil;
            int i16 = (i13 & 8388613) == 8388613 ? this.f11628e : ((i - this.f11628e) - this.f) - iCeil2;
            int i17 = (i13 & 80) == 80 ? ((i10 - this.f11628e) - this.f) - iCeil : this.f11628e;
            if (materialCardView.getLayoutDirection() == 1) {
                i12 = i16;
                i11 = i14;
            } else {
                i11 = i16;
                i12 = i14;
            }
            this.f11637p.setLayerInset(2, i12, i17, i11, i15);
        }
    }

    public final void f(boolean z10, boolean z11) {
        Drawable drawable = this.f11631j;
        if (drawable != null) {
            if (!z11) {
                drawable.setAlpha(z10 ? 255 : 0);
                this.f11645x = z10 ? 1.0f : 0.0f;
                return;
            }
            float f = z10 ? 1.0f : 0.0f;
            float f10 = z10 ? 1.0f - this.f11645x : this.f11645x;
            ValueAnimator valueAnimator = this.f11641t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f11641t = null;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f11645x, f);
            this.f11641t = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new fa.a(4, this));
            this.f11641t.setInterpolator(this.f11642u);
            this.f11641t.setDuration((long) ((z10 ? this.f11643v : this.f11644w) * f10));
            this.f11641t.start();
        }
    }

    public final void g(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.f11631j = drawableMutate;
            drawableMutate.setTintList(this.f11633l);
            f(this.f11624a.E, false);
        } else {
            this.f11631j = f11623z;
        }
        LayerDrawable layerDrawable = this.f11637p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(f.mtrl_card_checked_layer_id, this.f11631j);
        }
    }

    public final void h(m mVar) {
        this.f11634m = mVar;
        i iVar = this.f11626c;
        iVar.setShapeAppearanceModel(mVar);
        iVar.S = !iVar.n();
        i iVar2 = this.f11627d;
        if (iVar2 != null) {
            iVar2.setShapeAppearanceModel(mVar);
        }
        i iVar3 = this.f11638q;
        if (iVar3 != null) {
            iVar3.setShapeAppearanceModel(mVar);
        }
    }

    public final boolean i() {
        MaterialCardView materialCardView = this.f11624a;
        return materialCardView.getPreventCornerOverlap() && this.f11626c.n() && materialCardView.getUseCompatPadding();
    }

    public final boolean j() {
        View view = this.f11624a;
        if (view.isClickable()) {
            return true;
        }
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    public final void k() {
        Drawable drawable = this.i;
        Drawable drawableC = j() ? c() : this.f11627d;
        this.i = drawableC;
        if (drawable != drawableC) {
            MaterialCardView materialCardView = this.f11624a;
            if (materialCardView.getForeground() instanceof InsetDrawable) {
                ((InsetDrawable) materialCardView.getForeground()).setDrawable(drawableC);
            } else {
                materialCardView.setForeground(d(drawableC));
            }
        }
    }

    public final void l() {
        MaterialCardView materialCardView = this.f11624a;
        float cardViewRadius = 0.0f;
        float fA = ((!materialCardView.getPreventCornerOverlap() || this.f11626c.n()) && !i()) ? 0.0f : a();
        if (materialCardView.getPreventCornerOverlap() && materialCardView.getUseCompatPadding()) {
            cardViewRadius = (float) ((1.0d - f11622y) * ((double) materialCardView.getCardViewRadius()));
        }
        int i = (int) (fA - cardViewRadius);
        Rect rect = this.f11625b;
        materialCardView.f635x.set(rect.left + i, rect.top + i, rect.right + i, rect.bottom + i);
        w wVar = materialCardView.f637z;
        if (!((CardView) wVar.f9017x).getUseCompatPadding()) {
            wVar.P(0, 0, 0, 0);
            return;
        }
        u.a aVar = (u.a) ((Drawable) wVar.f9016w);
        float f = aVar.f12037e;
        float f10 = aVar.f12033a;
        int iCeil = (int) Math.ceil(u.b.a(f, f10, r1.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(u.b.b(f, f10, r1.getPreventCornerOverlap()));
        wVar.P(iCeil, iCeil2, iCeil, iCeil2);
    }

    public final void m() {
        boolean z10 = this.f11639r;
        MaterialCardView materialCardView = this.f11624a;
        if (!z10) {
            materialCardView.setBackgroundInternal(d(this.f11626c));
        }
        materialCardView.setForeground(d(this.i));
    }
}
