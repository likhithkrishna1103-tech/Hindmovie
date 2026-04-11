package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z4 extends a5 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3257y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f3258z;

    public z4(byte[] bArr, int i, int i10) {
        super(bArr);
        a5.d(i, i + i10, bArr.length);
        this.f3257y = i;
        this.f3258z = i10;
    }

    @Override // com.google.android.gms.internal.measurement.a5
    public final byte b(int i) {
        int i10 = this.f3258z;
        if (((i10 - (i + 1)) | i) >= 0) {
            return this.f2887v[this.f3257y + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(e6.j.l("Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(l4.a.l(i, i10, "Index > length: ", ", "));
    }

    @Override // com.google.android.gms.internal.measurement.a5
    public final byte f(int i) {
        return this.f2887v[this.f3257y + i];
    }

    @Override // com.google.android.gms.internal.measurement.a5
    public final int h() {
        return this.f3258z;
    }

    @Override // com.google.android.gms.internal.measurement.a5
    public final int i() {
        return this.f3257y;
    }
}
