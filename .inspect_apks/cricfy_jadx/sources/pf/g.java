package pf;

import kf.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    static {
        ag.h hVar = ag.h.f430y;
        ka.f.d("\"\\");
        ka.f.d("\t ,=");
    }

    public static final boolean a(z zVar) {
        if (ge.i.a((String) zVar.f7594v.f2036c, "HEAD")) {
            return false;
        }
        int i = zVar.f7597y;
        if (((i < 100 || i >= 200) && i != 204 && i != 304) || lf.f.d(zVar) != -1) {
            return true;
        }
        String strA = zVar.A.a("Transfer-Encoding");
        if (strA == null) {
            strA = null;
        }
        return "chunked".equalsIgnoreCase(strA);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(kf.b r37, kf.q r38, kf.p r39) {
        /*
            Method dump skipped, instruction units count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pf.g.b(kf.b, kf.q, kf.p):void");
    }
}
