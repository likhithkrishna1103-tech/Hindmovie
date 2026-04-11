package c2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u extends q1.h {
    public int[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f2406j;

    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fb  */
    @Override // q1.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.nio.ByteBuffer r18) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.u.e(java.nio.ByteBuffer):void");
    }

    @Override // q1.h
    public final q1.e g(q1.e eVar) throws q1.f {
        int i = eVar.f10545c;
        int[] iArr = this.i;
        if (iArr == null) {
            return q1.e.f10542e;
        }
        int i10 = eVar.f10544b;
        if (!s1.b0.J(i)) {
            throw new q1.f(eVar);
        }
        boolean z2 = i10 != iArr.length;
        int i11 = 0;
        while (i11 < iArr.length) {
            int i12 = iArr[i11];
            if (i12 >= i10) {
                throw new q1.f("Channel map (" + Arrays.toString(iArr) + ") trying to access non-existent input channel.", eVar);
            }
            z2 |= i12 != i11;
            i11++;
        }
        return z2 ? new q1.e(eVar.f10543a, iArr.length, i) : q1.e.f10542e;
    }

    @Override // q1.h
    public final void h() {
        this.f2406j = this.i;
    }

    @Override // q1.h
    public final void j() {
        this.f2406j = null;
        this.i = null;
    }
}
