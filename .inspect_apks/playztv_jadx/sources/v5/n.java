package v5;

import android.graphics.Color;
import android.graphics.PointF;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pb.c f13300a = pb.c.k("x", "y");

    public static int a(w5.a aVar) {
        aVar.a();
        int iJ = (int) (aVar.J() * 255.0d);
        int iJ2 = (int) (aVar.J() * 255.0d);
        int iJ3 = (int) (aVar.J() * 255.0d);
        while (aVar.G()) {
            aVar.k0();
        }
        aVar.v();
        return Color.argb(255, iJ, iJ2, iJ3);
    }

    public static PointF b(w5.a aVar, float f) {
        int iC = v.e.c(aVar.g0());
        if (iC == 0) {
            aVar.a();
            float fJ = (float) aVar.J();
            float fJ2 = (float) aVar.J();
            while (aVar.g0() != 2) {
                aVar.k0();
            }
            aVar.v();
            return new PointF(fJ * f, fJ2 * f);
        }
        if (iC != 2) {
            if (iC != 6) {
                throw new IllegalArgumentException("Unknown point starts with ".concat(e6.j.v(aVar.g0())));
            }
            float fJ3 = (float) aVar.J();
            float fJ4 = (float) aVar.J();
            while (aVar.G()) {
                aVar.k0();
            }
            return new PointF(fJ3 * f, fJ4 * f);
        }
        aVar.d();
        float fD = 0.0f;
        float fD2 = 0.0f;
        while (aVar.G()) {
            int iI0 = aVar.i0(f13300a);
            if (iI0 == 0) {
                fD = d(aVar);
            } else if (iI0 != 1) {
                aVar.j0();
                aVar.k0();
            } else {
                fD2 = d(aVar);
            }
        }
        aVar.x();
        return new PointF(fD * f, fD2 * f);
    }

    public static ArrayList c(w5.a aVar, float f) {
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.g0() == 1) {
            aVar.a();
            arrayList.add(b(aVar, f));
            aVar.v();
        }
        aVar.v();
        return arrayList;
    }

    public static float d(w5.a aVar) {
        int iG0 = aVar.g0();
        int iC = v.e.c(iG0);
        if (iC != 0) {
            if (iC == 6) {
                return (float) aVar.J();
            }
            throw new IllegalArgumentException("Unknown value for token of type ".concat(e6.j.v(iG0)));
        }
        aVar.a();
        float fJ = (float) aVar.J();
        while (aVar.G()) {
            aVar.k0();
        }
        aVar.v();
        return fJ;
    }
}
