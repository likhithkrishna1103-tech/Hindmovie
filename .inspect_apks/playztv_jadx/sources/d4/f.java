package d4;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p1.m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f3843b;

    public f(int i, List list) {
        this.f3842a = i;
        this.f3843b = list;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d4.i0 a(int r6, p7.m r7) {
        /*
            Method dump skipped, instruction units count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.f.a(int, p7.m):d4.i0");
    }

    public List b(p7.m mVar) {
        String str;
        int i;
        List listSingletonList;
        boolean zC = c(32);
        List list = this.f3843b;
        if (zC) {
            return list;
        }
        s1.u uVar = new s1.u((byte[]) mVar.f10286x);
        while (uVar.a() > 0) {
            int iX = uVar.x();
            int iX2 = uVar.f11710b + uVar.x();
            if (iX == 134) {
                ArrayList arrayList = new ArrayList();
                int iX3 = uVar.x() & 31;
                for (int i10 = 0; i10 < iX3; i10++) {
                    String strV = uVar.v(3, StandardCharsets.UTF_8);
                    int iX4 = uVar.x();
                    boolean z2 = (iX4 & 128) != 0;
                    if (z2) {
                        i = iX4 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bX = (byte) uVar.x();
                    uVar.K(1);
                    if (z2) {
                        boolean z10 = (bX & 64) != 0;
                        byte[] bArr = s1.e.f11662a;
                        listSingletonList = Collections.singletonList(z10 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    p1.p pVar = new p1.p();
                    pVar.f9967m = m0.p(str);
                    pVar.f9960d = strV;
                    pVar.J = i;
                    pVar.f9970p = listSingletonList;
                    arrayList.add(new p1.q(pVar));
                }
                list = arrayList;
            }
            uVar.J(iX2);
        }
        return list;
    }

    public boolean c(int i) {
        return (i & this.f3842a) != 0;
    }

    public f() {
        this.f3842a = 1;
        this.f3843b = Collections.singletonList(null);
    }

    public f(ArrayList arrayList) {
        this.f3842a = 0;
        this.f3843b = arrayList;
    }
}
