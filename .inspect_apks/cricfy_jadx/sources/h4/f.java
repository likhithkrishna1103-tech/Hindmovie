package h4;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f5624b;

    public f(int i, List list) {
        this.f5623a = i;
        this.f5624b = list;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h4.h0 a(int r6, k8.m r7) {
        /*
            Method dump skipped, instruction units count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.f.a(int, k8.m):h4.h0");
    }

    public List b(k8.m mVar) {
        String str;
        int i;
        List listSingletonList;
        boolean zC = c(32);
        List list = this.f5624b;
        if (zC) {
            return list;
        }
        y1.t tVar = new y1.t((byte[]) mVar.f7282y);
        while (tVar.a() > 0) {
            int iX = tVar.x();
            int iX2 = tVar.f14610b + tVar.x();
            if (iX == 134) {
                ArrayList arrayList = new ArrayList();
                int iX3 = tVar.x() & 31;
                for (int i10 = 0; i10 < iX3; i10++) {
                    String strV = tVar.v(3, StandardCharsets.UTF_8);
                    int iX4 = tVar.x();
                    boolean z10 = (iX4 & 128) != 0;
                    if (z10) {
                        i = iX4 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bX = (byte) tVar.x();
                    tVar.K(1);
                    if (z10) {
                        boolean z11 = (bX & 64) != 0;
                        byte[] bArr = y1.e.f14568a;
                        listSingletonList = Collections.singletonList(z11 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    v1.o oVar = new v1.o();
                    oVar.f12893m = m0.p(str);
                    oVar.f12886d = strV;
                    oVar.J = i;
                    oVar.f12896p = listSingletonList;
                    arrayList.add(new v1.p(oVar));
                }
                list = arrayList;
            }
            tVar.J(iX2);
        }
        return list;
    }

    public boolean c(int i) {
        return (i & this.f5623a) != 0;
    }

    public f() {
        this.f5623a = 1;
        this.f5624b = Collections.singletonList(null);
    }

    public f(ArrayList arrayList) {
        this.f5623a = 0;
        this.f5624b = arrayList;
    }
}
