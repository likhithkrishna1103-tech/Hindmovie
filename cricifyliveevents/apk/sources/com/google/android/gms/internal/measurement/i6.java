package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4 f2485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f2487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2488d;

    public i6(u4 u4Var, String str, Object[] objArr) {
        this.f2485a = u4Var;
        this.f2486b = str;
        this.f2487c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f2488d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i10 = 1;
        int i11 = 13;
        while (true) {
            int i12 = i10 + 1;
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 < 55296) {
                this.f2488d = i | (cCharAt2 << i11);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i11;
                i11 += 13;
                i10 = i12;
            }
        }
    }

    public final int a() {
        int i = this.f2488d;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }
}
