package d4;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static final byte[] f = {0, 0, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f3915e;

    public final void a(byte[] bArr, int i, int i10) {
        if (this.f3911a) {
            int i11 = i10 - i;
            byte[] bArr2 = this.f3915e;
            int length = bArr2.length;
            int i12 = this.f3913c + i11;
            if (length < i12) {
                this.f3915e = Arrays.copyOf(bArr2, i12 * 2);
            }
            System.arraycopy(bArr, i, this.f3915e, this.f3913c, i11);
            this.f3913c += i11;
        }
    }
}
