package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z4 extends a5 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f2742y;

    public z4(int i, byte[] bArr) {
        super(bArr);
        a5.f(0, i, bArr.length);
        this.f2742y = i;
    }

    @Override // com.google.android.gms.internal.measurement.a5
    public final byte a(int i) {
        int i10 = this.f2742y;
        if (((i10 - (i + 1)) | i) >= 0) {
            return this.f2318w[i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 11);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 18 + String.valueOf(i10).length());
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i10);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.a5
    public final byte b(int i) {
        return this.f2318w[i];
    }

    @Override // com.google.android.gms.internal.measurement.a5
    public final int c() {
        return this.f2742y;
    }
}
