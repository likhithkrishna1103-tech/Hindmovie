package h4;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static final byte[] f = {0, 0, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f5678e;

    public final void a(byte[] bArr, int i, int i10) {
        if (this.f5674a) {
            int i11 = i10 - i;
            byte[] bArr2 = this.f5678e;
            int length = bArr2.length;
            int i12 = this.f5676c + i11;
            if (length < i12) {
                this.f5678e = Arrays.copyOf(bArr2, i12 * 2);
            }
            System.arraycopy(bArr, i, this.f5678e, this.f5676c, i11);
            this.f5676c += i11;
        }
    }
}
