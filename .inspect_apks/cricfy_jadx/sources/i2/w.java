package i2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends w1.i {
    public int[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f6142j;

    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fb  */
    @Override // w1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.nio.ByteBuffer r18) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.w.f(java.nio.ByteBuffer):void");
    }

    @Override // w1.i
    public final w1.f g(w1.f fVar) throws w1.g {
        int i = fVar.f13793c;
        int[] iArr = this.i;
        if (iArr == null) {
            return w1.f.f13790e;
        }
        int i10 = fVar.f13792b;
        if (!y1.a0.J(i)) {
            throw new w1.g(fVar);
        }
        boolean z10 = i10 != iArr.length;
        int i11 = 0;
        while (i11 < iArr.length) {
            int i12 = iArr[i11];
            if (i12 >= i10) {
                throw new w1.g("Channel map (" + Arrays.toString(iArr) + ") trying to access non-existent input channel.", fVar);
            }
            z10 |= i12 != i11;
            i11++;
        }
        return z10 ? new w1.f(fVar.f13791a, iArr.length, i) : w1.f.f13790e;
    }

    @Override // w1.i
    public final void h() {
        this.f6142j = this.i;
    }

    @Override // w1.i
    public final void j() {
        this.f6142j = null;
        this.i = null;
    }
}
