package q6;

import java.io.EOFException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nb.w f10387a = nb.w.I("k", "x", "y");

    public static m6.c a(r6.b bVar, g6.i iVar) throws a2.a, EOFException {
        ArrayList arrayList = new ArrayList();
        if (bVar.R() == 1) {
            bVar.a();
            while (bVar.A()) {
                r6.b bVar2 = bVar;
                g6.i iVar2 = iVar;
                arrayList.add(new j6.l(iVar2, p.b(bVar2, iVar2, s6.i.c(), f.f10404z, bVar.R() == 3, false)));
                bVar = bVar2;
                iVar = iVar2;
            }
            bVar.q();
            q.b(arrayList);
        } else {
            arrayList.add(new t6.a(o.b(bVar, s6.i.c())));
        }
        return new m6.c(arrayList);
    }

    public static m6.f b(r6.b bVar, g6.i iVar) throws a2.a, EOFException {
        bVar.g();
        m6.c cVarA = null;
        m6.b bVarI = null;
        boolean z10 = false;
        m6.b bVarI2 = null;
        while (bVar.R() != 4) {
            int iG0 = bVar.g0(f10387a);
            if (iG0 == 0) {
                cVarA = a(bVar, iVar);
            } else if (iG0 != 1) {
                if (iG0 != 2) {
                    bVar.h0();
                    bVar.i0();
                } else if (bVar.R() == 6) {
                    bVar.i0();
                    z10 = true;
                } else {
                    bVarI = a.a.i(bVar, iVar, true);
                }
            } else if (bVar.R() == 6) {
                bVar.i0();
                z10 = true;
            } else {
                bVarI2 = a.a.i(bVar, iVar, true);
            }
        }
        bVar.s();
        if (z10) {
            iVar.a("Lottie doesn't support expressions.");
        }
        return cVarA != null ? cVarA : new m6.d(bVarI2, bVarI);
    }
}
