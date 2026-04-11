package w0;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.PathInterpolator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f13748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0.c f13749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0.c f13750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f13751e;
    public final ColorDrawable f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f13752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13753h;

    static {
        new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f);
        new PathInterpolator(0.6f, 0.0f, 1.0f, 1.0f);
        new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);
        new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);
    }

    public a(int i, int i10) {
        b bVar = new b();
        bVar.f13754a = -1;
        bVar.f13755b = -1;
        l0.c cVar = l0.c.f7601e;
        bVar.f13756c = cVar;
        bVar.f13757d = false;
        bVar.f13758e = null;
        bVar.f = 0.0f;
        bVar.f13759g = 0.0f;
        bVar.f13760h = 1.0f;
        this.f13748b = bVar;
        this.f13749c = cVar;
        this.f13750d = cVar;
        this.f13751e = null;
        if (i != 1 && i != 2 && i != 4 && i != 8) {
            throw new IllegalArgumentException(l0.e.g(i, "Unexpected side: "));
        }
        this.f13747a = i;
        ColorDrawable colorDrawable = new ColorDrawable();
        this.f = colorDrawable;
        this.f13753h = 0;
        this.f13752g = true;
        if (i10 != 0) {
            this.f13753h = i10;
            colorDrawable.setColor(i10);
            bVar.f13758e = colorDrawable;
            vb.b bVar2 = bVar.i;
            if (bVar2 != null) {
                ((View) bVar2.f13552x).setBackground(colorDrawable);
            }
        }
    }

    public final void a(float f) {
        float f10 = f * 1.0f;
        b bVar = this.f13748b;
        if (bVar.f13760h != f10) {
            bVar.f13760h = f10;
            vb.b bVar2 = bVar.i;
            if (bVar2 != null) {
                ((View) bVar2.f13552x).setAlpha(f10);
            }
        }
    }

    public final void b(float f) {
        float f10 = f * 1.0f;
        b bVar = this.f13748b;
        int i = this.f13747a;
        if (i == 1) {
            float f11 = (-(1.0f - f10)) * bVar.f13754a;
            if (bVar.f != f11) {
                bVar.f = f11;
                vb.b bVar2 = bVar.i;
                if (bVar2 != null) {
                    ((View) bVar2.f13552x).setTranslationX(f11);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 2) {
            float f12 = (-(1.0f - f10)) * bVar.f13755b;
            if (bVar.f13759g != f12) {
                bVar.f13759g = f12;
                vb.b bVar3 = bVar.i;
                if (bVar3 != null) {
                    ((View) bVar3.f13552x).setTranslationY(f12);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 4) {
            float f13 = (1.0f - f10) * bVar.f13754a;
            if (bVar.f != f13) {
                bVar.f = f13;
                vb.b bVar4 = bVar.i;
                if (bVar4 != null) {
                    ((View) bVar4.f13552x).setTranslationX(f13);
                    return;
                }
                return;
            }
            return;
        }
        if (i != 8) {
            return;
        }
        float f14 = (1.0f - f10) * bVar.f13755b;
        if (bVar.f13759g != f14) {
            bVar.f13759g = f14;
            vb.b bVar5 = bVar.i;
            if (bVar5 != null) {
                ((View) bVar5.f13552x).setTranslationY(f14);
            }
        }
    }
}
