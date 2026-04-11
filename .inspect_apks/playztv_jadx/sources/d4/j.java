package d4;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f3890e = {0, 0, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f3894d;

    public final void a(byte[] bArr, int i, int i10) {
        if (this.f3891a) {
            int i11 = i10 - i;
            byte[] bArr2 = this.f3894d;
            int length = bArr2.length;
            int i12 = this.f3892b + i11;
            if (length < i12) {
                this.f3894d = Arrays.copyOf(bArr2, i12 * 2);
            }
            System.arraycopy(bArr, i, this.f3894d, this.f3892b, i11);
            this.f3892b += i11;
        }
    }
}
