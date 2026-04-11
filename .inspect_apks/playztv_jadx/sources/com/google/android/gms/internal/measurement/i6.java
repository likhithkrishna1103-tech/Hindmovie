package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4 f3053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f3055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3056d;

    public i6(u4 u4Var, String str, Object[] objArr) {
        this.f3053a = u4Var;
        this.f3054b = str;
        this.f3055c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f3056d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i10 = 13;
        int i11 = 1;
        while (true) {
            int i12 = i11 + 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 < 55296) {
                this.f3056d = i | (cCharAt2 << i10);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i10;
                i10 += 13;
                i11 = i12;
            }
        }
    }

    public final int a() {
        int i = this.f3056d;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }
}
