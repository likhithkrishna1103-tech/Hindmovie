package t0;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.PathInterpolator;
import e6.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i0.d f11965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i0.d f11966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f11967e;
    public final ColorDrawable f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f11968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11969h;

    static {
        new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f);
        new PathInterpolator(0.6f, 0.0f, 1.0f, 1.0f);
        new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);
        new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);
    }

    public a(int i, int i10) {
        b bVar = new b();
        bVar.f11970a = -1;
        bVar.f11971b = -1;
        i0.d dVar = i0.d.f6160e;
        bVar.f11972c = dVar;
        bVar.f11973d = false;
        bVar.f11974e = null;
        bVar.f = 0.0f;
        bVar.f11975g = 0.0f;
        bVar.f11976h = 1.0f;
        this.f11964b = bVar;
        this.f11965c = dVar;
        this.f11966d = dVar;
        this.f11967e = null;
        if (i != 1 && i != 2 && i != 4 && i != 8) {
            throw new IllegalArgumentException(j.l("Unexpected side: ", i));
        }
        this.f11963a = i;
        ColorDrawable colorDrawable = new ColorDrawable();
        this.f = colorDrawable;
        this.f11969h = 0;
        this.f11968g = true;
        if (i10 != 0) {
            this.f11969h = i10;
            colorDrawable.setColor(i10);
            bVar.f11974e = colorDrawable;
            p2.c cVar = bVar.i;
            if (cVar != null) {
                ((View) cVar.f10131w).setBackground(colorDrawable);
            }
        }
    }

    public final void a(float f) {
        float f4 = f * 1.0f;
        b bVar = this.f11964b;
        if (bVar.f11976h != f4) {
            bVar.f11976h = f4;
            p2.c cVar = bVar.i;
            if (cVar != null) {
                ((View) cVar.f10131w).setAlpha(f4);
            }
        }
    }

    public final void b(float f) {
        float f4 = f * 1.0f;
        b bVar = this.f11964b;
        int i = this.f11963a;
        if (i == 1) {
            float f10 = (-(1.0f - f4)) * bVar.f11970a;
            if (bVar.f != f10) {
                bVar.f = f10;
                p2.c cVar = bVar.i;
                if (cVar != null) {
                    ((View) cVar.f10131w).setTranslationX(f10);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 2) {
            float f11 = (-(1.0f - f4)) * bVar.f11971b;
            if (bVar.f11975g != f11) {
                bVar.f11975g = f11;
                p2.c cVar2 = bVar.i;
                if (cVar2 != null) {
                    ((View) cVar2.f10131w).setTranslationY(f11);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 4) {
            float f12 = (1.0f - f4) * bVar.f11970a;
            if (bVar.f != f12) {
                bVar.f = f12;
                p2.c cVar3 = bVar.i;
                if (cVar3 != null) {
                    ((View) cVar3.f10131w).setTranslationX(f12);
                    return;
                }
                return;
            }
            return;
        }
        if (i != 8) {
            return;
        }
        float f13 = (1.0f - f4) * bVar.f11971b;
        if (bVar.f11975g != f13) {
            bVar.f11975g = f13;
            p2.c cVar4 = bVar.i;
            if (cVar4 != null) {
                ((View) cVar4.f10131w).setTranslationY(f13);
            }
        }
    }
}
