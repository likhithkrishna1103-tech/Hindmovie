package ze;

import be.h;
import hf.i;
import ue.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    static {
        i iVar = i.f6114x;
        lb.e.h("\"\\");
        lb.e.h("\t ,=");
    }

    public static final boolean a(x xVar) {
        if (h.a((String) xVar.f13066u.f1738c, "HEAD")) {
            return false;
        }
        int i = xVar.f13069x;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && ve.b.i(xVar) == -1 && !"chunked".equalsIgnoreCase(x.a("Transfer-Encoding", xVar))) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(ue.b r35, ue.o r36, ue.m r37) {
        /*
            Method dump skipped, instruction units count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ze.e.b(ue.b, ue.o, ue.m):void");
    }
}
