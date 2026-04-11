package q6;

import android.graphics.Color;
import android.graphics.PointF;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nb.w f10424a = nb.w.I("x", "y");

    public static int a(r6.a aVar) {
        aVar.a();
        int iJ = (int) (aVar.J() * 255.0d);
        int iJ2 = (int) (aVar.J() * 255.0d);
        int iJ3 = (int) (aVar.J() * 255.0d);
        while (aVar.A()) {
            aVar.i0();
        }
        aVar.q();
        return Color.argb(255, iJ, iJ2, iJ3);
    }

    public static PointF b(r6.a aVar, float f) {
        int iC = y.e.c(aVar.R());
        if (iC == 0) {
            aVar.a();
            float fJ = (float) aVar.J();
            float fJ2 = (float) aVar.J();
            while (aVar.R() != 2) {
                aVar.i0();
            }
            aVar.q();
            return new PointF(fJ * f, fJ2 * f);
        }
        if (iC != 2) {
            if (iC != 6) {
                throw new IllegalArgumentException("Unknown point starts with ".concat(l0.e.u(aVar.R())));
            }
            float fJ3 = (float) aVar.J();
            float fJ4 = (float) aVar.J();
            while (aVar.A()) {
                aVar.i0();
            }
            return new PointF(fJ3 * f, fJ4 * f);
        }
        aVar.g();
        float fD = 0.0f;
        float fD2 = 0.0f;
        while (aVar.A()) {
            int iG0 = aVar.g0(f10424a);
            if (iG0 == 0) {
                fD = d(aVar);
            } else if (iG0 != 1) {
                aVar.h0();
                aVar.i0();
            } else {
                fD2 = d(aVar);
            }
        }
        aVar.s();
        return new PointF(fD * f, fD2 * f);
    }

    public static ArrayList c(r6.a aVar, float f) {
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.R() == 1) {
            aVar.a();
            arrayList.add(b(aVar, f));
            aVar.q();
        }
        aVar.q();
        return arrayList;
    }

    public static float d(r6.a aVar) {
        int iR = aVar.R();
        int iC = y.e.c(iR);
        if (iC != 0) {
            if (iC == 6) {
                return (float) aVar.J();
            }
            throw new IllegalArgumentException("Unknown value for token of type ".concat(l0.e.u(iR)));
        }
        aVar.a();
        float fJ = (float) aVar.J();
        while (aVar.A()) {
            aVar.i0();
        }
        aVar.q();
        return fJ;
    }
}
