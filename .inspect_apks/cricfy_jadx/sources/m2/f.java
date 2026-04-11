package m2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends t2.e {
    public byte[] E;
    public volatile boolean F;
    public byte[] G;

    @Override // w2.k
    public final void a() {
        try {
            this.D.B(this.f11849w);
            int i = 0;
            int i10 = 0;
            while (i != -1 && !this.F) {
                byte[] bArr = this.E;
                if (bArr.length < i10 + 16384) {
                    this.E = Arrays.copyOf(bArr, bArr.length + 16384);
                }
                i = this.D.read(this.E, i10, 16384);
                if (i != -1) {
                    i10 += i;
                }
            }
            if (!this.F) {
                this.G = Arrays.copyOf(this.E, i10);
            }
            u8.a.g(this.D);
        } catch (Throwable th) {
            u8.a.g(this.D);
            throw th;
        }
    }

    @Override // w2.k
    public final void d() {
        this.F = true;
    }
}
