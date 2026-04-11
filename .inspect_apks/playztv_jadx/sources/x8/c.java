package x8;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.button.MaterialButton;
import java.util.WeakHashMap;
import q0.o0;
import q9.f;
import q9.g;
import q9.k;
import q9.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialButton f14307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f14308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14311e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14313h;
    public PorterDuff.Mode i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f14314j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f14315k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f14316l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g f14317m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f14321q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RippleDrawable f14323s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f14324t;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14318n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14319o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f14320p = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f14322r = true;

    public c(MaterialButton materialButton, k kVar) {
        this.f14307a = materialButton;
        this.f14308b = kVar;
    }

    public final u a() {
        RippleDrawable rippleDrawable = this.f14323s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f14323s.getNumberOfLayers() > 2 ? (u) this.f14323s.getDrawable(2) : (u) this.f14323s.getDrawable(1);
    }

    public final g b(boolean z2) {
        RippleDrawable rippleDrawable = this.f14323s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (g) ((LayerDrawable) ((InsetDrawable) this.f14323s.getDrawable(0)).getDrawable()).getDrawable(!z2 ? 1 : 0);
    }

    public final void c(k kVar) {
        this.f14308b = kVar;
        if (b(false) != null) {
            b(false).setShapeAppearanceModel(kVar);
        }
        if (b(true) != null) {
            b(true).setShapeAppearanceModel(kVar);
        }
        if (a() != null) {
            a().setShapeAppearanceModel(kVar);
        }
    }

    public final void d(int i, int i10) {
        WeakHashMap weakHashMap = o0.f10475a;
        MaterialButton materialButton = this.f14307a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i11 = this.f14311e;
        int i12 = this.f;
        this.f = i10;
        this.f14311e = i;
        if (!this.f14319o) {
            e();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i) - i11, paddingEnd, (paddingBottom + i10) - i12);
    }

    public final void e() {
        g gVar = new g(this.f14308b);
        MaterialButton materialButton = this.f14307a;
        gVar.j(materialButton.getContext());
        gVar.setTintList(this.f14314j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            gVar.setTintMode(mode);
        }
        float f = this.f14313h;
        ColorStateList colorStateList = this.f14315k;
        gVar.f11105u.f11097j = f;
        gVar.invalidateSelf();
        f fVar = gVar.f11105u;
        if (fVar.f11093d != colorStateList) {
            fVar.f11093d = colorStateList;
            gVar.onStateChange(gVar.getState());
        }
        g gVar2 = new g(this.f14308b);
        gVar2.setTint(0);
        float f4 = this.f14313h;
        int iM = this.f14318n ? z7.a.m(materialButton, p8.b.colorSurface) : 0;
        gVar2.f11105u.f11097j = f4;
        gVar2.invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iM);
        f fVar2 = gVar2.f11105u;
        if (fVar2.f11093d != colorStateListValueOf) {
            fVar2.f11093d = colorStateListValueOf;
            gVar2.onStateChange(gVar2.getState());
        }
        g gVar3 = new g(this.f14308b);
        this.f14317m = gVar3;
        gVar3.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(o9.a.c(this.f14316l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{gVar2, gVar}), this.f14309c, this.f14311e, this.f14310d, this.f), this.f14317m);
        this.f14323s = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        g gVarB = b(false);
        if (gVarB != null) {
            gVarB.k(this.f14324t);
            gVarB.setState(materialButton.getDrawableState());
        }
    }

    public final void f() {
        g gVarB = b(false);
        g gVarB2 = b(true);
        if (gVarB != null) {
            float f = this.f14313h;
            ColorStateList colorStateList = this.f14315k;
            gVarB.f11105u.f11097j = f;
            gVarB.invalidateSelf();
            f fVar = gVarB.f11105u;
            if (fVar.f11093d != colorStateList) {
                fVar.f11093d = colorStateList;
                gVarB.onStateChange(gVarB.getState());
            }
            if (gVarB2 != null) {
                float f4 = this.f14313h;
                int iM = this.f14318n ? z7.a.m(this.f14307a, p8.b.colorSurface) : 0;
                gVarB2.f11105u.f11097j = f4;
                gVarB2.invalidateSelf();
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(iM);
                f fVar2 = gVarB2.f11105u;
                if (fVar2.f11093d != colorStateListValueOf) {
                    fVar2.f11093d = colorStateListValueOf;
                    gVarB2.onStateChange(gVarB2.getState());
                }
            }
        }
    }
}
