package h4;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f5653e = {0, 0, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f5657d;

    public final void a(byte[] bArr, int i, int i10) {
        if (this.f5654a) {
            int i11 = i10 - i;
            byte[] bArr2 = this.f5657d;
            int length = bArr2.length;
            int i12 = this.f5655b + i11;
            if (length < i12) {
                this.f5657d = Arrays.copyOf(bArr2, i12 * 2);
            }
            System.arraycopy(bArr, i, this.f5657d, this.f5655b, i11);
            this.f5655b += i11;
        }
    }
}
