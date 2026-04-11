package r9;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.bumptech.glide.f;
import com.google.android.material.button.MaterialButton;
import k1.g;
import ka.d0;
import ka.i;
import ka.m;
import ka.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialButton f10897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f10898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0 f10899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f10900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public kb.d f10901e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10903h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f10906l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ColorStateList f10907m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f10908n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorStateList f10909o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public i f10910p;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10914t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public RippleDrawable f10916v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10917w;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10911q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10912r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10913s = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10915u = true;

    public d(MaterialButton materialButton, m mVar) {
        this.f10897a = materialButton;
        this.f10898b = mVar;
    }

    public final i a(boolean z10) {
        RippleDrawable rippleDrawable = this.f10916v;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (i) ((LayerDrawable) ((InsetDrawable) this.f10916v.getDrawable(0)).getDrawable()).getDrawable(!z10 ? 1 : 0);
    }

    public final void b(int i, int i10) {
        MaterialButton materialButton = this.f10897a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i11 = this.f10903h;
        int i12 = this.i;
        this.i = i10;
        this.f10903h = i;
        if (!this.f10912r) {
            c();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i) - i11, paddingEnd, (paddingBottom + i10) - i12);
    }

    public final void c() {
        i iVar = new i(this.f10898b);
        d0 d0Var = this.f10899c;
        if (d0Var != null) {
            iVar.t(d0Var);
        }
        g gVar = this.f10900d;
        if (gVar != null) {
            iVar.o(gVar);
        }
        kb.d dVar = this.f10901e;
        if (dVar != null) {
            iVar.Z = dVar;
        }
        MaterialButton materialButton = this.f10897a;
        iVar.m(materialButton.getContext());
        iVar.setTintList(this.f10907m);
        PorterDuff.Mode mode = this.f10906l;
        if (mode != null) {
            iVar.setTintMode(mode);
        }
        float f = this.f10905k;
        ColorStateList colorStateList = this.f10908n;
        iVar.f7334w.f7324k = f;
        iVar.invalidateSelf();
        ka.g gVar2 = iVar.f7334w;
        if (gVar2.f7320e != colorStateList) {
            gVar2.f7320e = colorStateList;
            iVar.onStateChange(iVar.getState());
        }
        i iVar2 = new i(this.f10898b);
        d0 d0Var2 = this.f10899c;
        if (d0Var2 != null) {
            iVar2.t(d0Var2);
        }
        g gVar3 = this.f10900d;
        if (gVar3 != null) {
            iVar2.o(gVar3);
        }
        iVar2.setTint(0);
        float f10 = this.f10905k;
        int iN = this.f10911q ? f.n(materialButton, k9.b.colorSurface) : 0;
        iVar2.f7334w.f7324k = f10;
        iVar2.invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iN);
        ka.g gVar4 = iVar2.f7334w;
        if (gVar4.f7320e != colorStateListValueOf) {
            gVar4.f7320e = colorStateListValueOf;
            iVar2.onStateChange(iVar2.getState());
        }
        i iVar3 = new i(this.f10898b);
        this.f10910p = iVar3;
        d0 d0Var3 = this.f10899c;
        if (d0Var3 != null) {
            iVar3.t(d0Var3);
        }
        g gVar5 = this.f10900d;
        if (gVar5 != null) {
            this.f10910p.o(gVar5);
        }
        this.f10910p.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(ia.a.b(this.f10909o), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{iVar2, iVar}), this.f, this.f10903h, this.f10902g, this.i), this.f10910p);
        this.f10916v = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        i iVarA = a(false);
        if (iVarA != null) {
            iVarA.p(this.f10917w);
            iVarA.setState(materialButton.getDrawableState());
        }
    }

    public final void d() {
        i iVarA = a(false);
        if (iVarA != null) {
            d0 d0Var = this.f10899c;
            if (d0Var != null) {
                iVarA.t(d0Var);
            } else {
                iVarA.setShapeAppearanceModel(this.f10898b);
            }
            g gVar = this.f10900d;
            if (gVar != null) {
                iVarA.o(gVar);
            }
        }
        i iVarA2 = a(true);
        if (iVarA2 != null) {
            d0 d0Var2 = this.f10899c;
            if (d0Var2 != null) {
                iVarA2.t(d0Var2);
            } else {
                iVarA2.setShapeAppearanceModel(this.f10898b);
            }
            g gVar2 = this.f10900d;
            if (gVar2 != null) {
                iVarA2.o(gVar2);
            }
        }
        RippleDrawable rippleDrawable = this.f10916v;
        w wVar = (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) ? null : this.f10916v.getNumberOfLayers() > 2 ? (w) this.f10916v.getDrawable(2) : (w) this.f10916v.getDrawable(1);
        if (wVar != null) {
            wVar.setShapeAppearanceModel(this.f10898b);
            if (wVar instanceof i) {
                i iVar = (i) wVar;
                d0 d0Var3 = this.f10899c;
                if (d0Var3 != null) {
                    iVar.t(d0Var3);
                }
                g gVar3 = this.f10900d;
                if (gVar3 != null) {
                    iVar.o(gVar3);
                }
            }
        }
    }

    public final void e() {
        i iVarA = a(false);
        i iVarA2 = a(true);
        if (iVarA != null) {
            float f = this.f10905k;
            ColorStateList colorStateList = this.f10908n;
            iVarA.f7334w.f7324k = f;
            iVarA.invalidateSelf();
            ka.g gVar = iVarA.f7334w;
            if (gVar.f7320e != colorStateList) {
                gVar.f7320e = colorStateList;
                iVarA.onStateChange(iVarA.getState());
            }
            if (iVarA2 != null) {
                float f10 = this.f10905k;
                int iN = this.f10911q ? f.n(this.f10897a, k9.b.colorSurface) : 0;
                iVarA2.f7334w.f7324k = f10;
                iVarA2.invalidateSelf();
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(iN);
                ka.g gVar2 = iVarA2.f7334w;
                if (gVar2.f7320e != colorStateListValueOf) {
                    gVar2.f7320e = colorStateListValueOf;
                    iVarA2.onStateChange(iVarA2.getState());
                }
            }
        }
    }
}
