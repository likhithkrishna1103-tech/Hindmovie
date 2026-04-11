package y8;

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
import b8.h;
import com.google.android.material.card.MaterialCardView;
import java.util.WeakHashMap;
import p8.f;
import p8.l;
import q0.o0;
import q9.d;
import q9.g;
import q9.i;
import q9.j;
import q9.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final double f14541y = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ColorDrawable f14542z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialCardView f14543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f14544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f14545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f14546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14547e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14549h;
    public Drawable i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f14550j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f14551k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f14552l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k f14553m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f14554n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RippleDrawable f14555o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LayerDrawable f14556p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public g f14557q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f14558r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f14559s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ValueAnimator f14560t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TimeInterpolator f14561u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f14562v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f14563w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f14564x;

    static {
        f14542z = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public c(MaterialCardView materialCardView, AttributeSet attributeSet, int i) {
        int i10 = MaterialCardView.I;
        this.f14544b = new Rect();
        this.f14558r = false;
        this.f14564x = 0.0f;
        this.f14543a = materialCardView;
        g gVar = new g(materialCardView.getContext(), attributeSet, i, i10);
        this.f14545c = gVar;
        gVar.j(materialCardView.getContext());
        gVar.n();
        j jVarF = gVar.f11105u.f11090a.f();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, l.CardView, i, p8.k.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(l.CardView_cardCornerRadius)) {
            jVarF.b(typedArrayObtainStyledAttributes.getDimension(l.CardView_cardCornerRadius, 0.0f));
        }
        this.f14546d = new g();
        h(jVarF.a());
        this.f14561u = h.y(materialCardView.getContext(), p8.b.motionEasingLinearInterpolator, q8.a.f11072a);
        this.f14562v = h.x(materialCardView.getContext(), p8.b.motionDurationShort2, 300);
        this.f14563w = h.x(materialCardView.getContext(), p8.b.motionDurationShort1, 300);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float b(ga.b bVar, float f) {
        if (bVar instanceof i) {
            return (float) ((1.0d - f14541y) * ((double) f));
        }
        if (bVar instanceof d) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    public final float a() {
        ga.b bVar = this.f14553m.f11123a;
        g gVar = this.f14545c;
        return Math.max(Math.max(b(bVar, gVar.h()), b(this.f14553m.f11124b, gVar.f11105u.f11090a.f.a(gVar.g()))), Math.max(b(this.f14553m.f11125c, gVar.f11105u.f11090a.f11128g.a(gVar.g())), b(this.f14553m.f11126d, gVar.f11105u.f11090a.f11129h.a(gVar.g()))));
    }

    public final LayerDrawable c() {
        if (this.f14555o == null) {
            int[] iArr = o9.a.f9444a;
            this.f14557q = new g(this.f14553m);
            this.f14555o = new RippleDrawable(this.f14551k, null, this.f14557q);
        }
        if (this.f14556p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f14555o, this.f14546d, this.f14550j});
            this.f14556p = layerDrawable;
            layerDrawable.setId(2, f.mtrl_card_checked_layer_id);
        }
        return this.f14556p;
    }

    public final b d(Drawable drawable) {
        int iCeil;
        int i;
        if (this.f14543a.getUseCompatPadding()) {
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
        if (this.f14556p != null) {
            MaterialCardView materialCardView = this.f14543a;
            if (materialCardView.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(((materialCardView.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f)) * 2.0f);
                iCeil2 = (int) Math.ceil((materialCardView.getMaxCardElevation() + (i() ? a() : 0.0f)) * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i13 = this.f14548g;
            int i14 = (i13 & 8388613) == 8388613 ? ((i - this.f14547e) - this.f) - iCeil2 : this.f14547e;
            int i15 = (i13 & 80) == 80 ? this.f14547e : ((i10 - this.f14547e) - this.f) - iCeil;
            int i16 = (i13 & 8388613) == 8388613 ? this.f14547e : ((i - this.f14547e) - this.f) - iCeil2;
            int i17 = (i13 & 80) == 80 ? ((i10 - this.f14547e) - this.f) - iCeil : this.f14547e;
            WeakHashMap weakHashMap = o0.f10475a;
            if (materialCardView.getLayoutDirection() == 1) {
                i12 = i16;
                i11 = i14;
            } else {
                i11 = i16;
                i12 = i14;
            }
            this.f14556p.setLayerInset(2, i12, i17, i11, i15);
        }
    }

    public final void f(boolean z2, boolean z10) {
        Drawable drawable = this.f14550j;
        if (drawable != null) {
            if (!z10) {
                drawable.setAlpha(z2 ? 255 : 0);
                this.f14564x = z2 ? 1.0f : 0.0f;
                return;
            }
            float f = z2 ? 1.0f : 0.0f;
            float f4 = z2 ? 1.0f - this.f14564x : this.f14564x;
            ValueAnimator valueAnimator = this.f14560t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f14560t = null;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f14564x, f);
            this.f14560t = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new i4.d(4, this));
            this.f14560t.setInterpolator(this.f14561u);
            this.f14560t.setDuration((long) ((z2 ? this.f14562v : this.f14563w) * f4));
            this.f14560t.start();
        }
    }

    public final void g(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.f14550j = drawableMutate;
            drawableMutate.setTintList(this.f14552l);
            f(this.f14543a.D, false);
        } else {
            this.f14550j = f14542z;
        }
        LayerDrawable layerDrawable = this.f14556p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(f.mtrl_card_checked_layer_id, this.f14550j);
        }
    }

    public final void h(k kVar) {
        this.f14553m = kVar;
        g gVar = this.f14545c;
        gVar.setShapeAppearanceModel(kVar);
        gVar.Q = !gVar.f11105u.f11090a.e(gVar.g());
        g gVar2 = this.f14546d;
        if (gVar2 != null) {
            gVar2.setShapeAppearanceModel(kVar);
        }
        g gVar3 = this.f14557q;
        if (gVar3 != null) {
            gVar3.setShapeAppearanceModel(kVar);
        }
    }

    public final boolean i() {
        MaterialCardView materialCardView = this.f14543a;
        if (!materialCardView.getPreventCornerOverlap()) {
            return false;
        }
        g gVar = this.f14545c;
        return gVar.f11105u.f11090a.e(gVar.g()) && materialCardView.getUseCompatPadding();
    }

    public final boolean j() {
        View view = this.f14543a;
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
        Drawable drawableC = j() ? c() : this.f14546d;
        this.i = drawableC;
        if (drawable != drawableC) {
            MaterialCardView materialCardView = this.f14543a;
            if (materialCardView.getForeground() instanceof InsetDrawable) {
                ((InsetDrawable) materialCardView.getForeground()).setDrawable(drawableC);
            } else {
                materialCardView.setForeground(d(drawableC));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            r6 = this;
            com.google.android.material.card.MaterialCardView r0 = r6.f14543a
            boolean r1 = r0.getPreventCornerOverlap()
            r2 = 0
            if (r1 == 0) goto L1a
            q9.g r1 = r6.f14545c
            q9.f r3 = r1.f11105u
            q9.k r3 = r3.f11090a
            android.graphics.RectF r1 = r1.g()
            boolean r1 = r3.e(r1)
            if (r1 != 0) goto L1a
            goto L20
        L1a:
            boolean r1 = r6.i()
            if (r1 == 0) goto L25
        L20:
            float r1 = r6.a()
            goto L26
        L25:
            r1 = r2
        L26:
            boolean r3 = r0.getPreventCornerOverlap()
            if (r3 == 0) goto L3e
            boolean r3 = r0.getUseCompatPadding()
            if (r3 == 0) goto L3e
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = y8.c.f14541y
            double r2 = r2 - r4
            float r4 = r0.getCardViewRadius()
            double r4 = (double) r4
            double r2 = r2 * r4
            float r2 = (float) r2
        L3e:
            float r1 = r1 - r2
            int r1 = (int) r1
            android.graphics.Rect r2 = r6.f14544b
            int r3 = r2.left
            int r3 = r3 + r1
            int r4 = r2.top
            int r4 = r4 + r1
            int r5 = r2.right
            int r5 = r5 + r1
            int r2 = r2.bottom
            int r2 = r2 + r1
            android.graphics.Rect r1 = r0.f958w
            r1.set(r3, r4, r5, r2)
            p2.c r0 = r0.f960y
            java.lang.Object r1 = r0.f10131w
            androidx.cardview.widget.CardView r1 = (androidx.cardview.widget.CardView) r1
            boolean r2 = r1.getUseCompatPadding()
            if (r2 != 0) goto L64
            r1 = 0
            r0.v(r1, r1, r1, r1)
            return
        L64:
            java.lang.Object r2 = r0.f10130v
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2
            r.a r2 = (r.a) r2
            float r3 = r2.f11201e
            float r2 = r2.f11197a
            boolean r4 = r1.getPreventCornerOverlap()
            float r4 = r.b.a(r3, r2, r4)
            double r4 = (double) r4
            double r4 = java.lang.Math.ceil(r4)
            int r4 = (int) r4
            boolean r1 = r1.getPreventCornerOverlap()
            float r1 = r.b.b(r3, r2, r1)
            double r1 = (double) r1
            double r1 = java.lang.Math.ceil(r1)
            int r1 = (int) r1
            r0.v(r4, r1, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.c.l():void");
    }

    public final void m() {
        boolean z2 = this.f14558r;
        MaterialCardView materialCardView = this.f14543a;
        if (!z2) {
            materialCardView.setBackgroundInternal(d(this.f14545c));
        }
        materialCardView.setForeground(d(this.i));
    }
}
