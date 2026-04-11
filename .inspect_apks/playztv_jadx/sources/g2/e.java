package g2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends p2.f {
    public byte[] D;
    public volatile boolean E;
    public byte[] F;

    @Override // s2.j
    public final void b() {
        try {
            this.C.h(this.f10144v);
            int i = 0;
            int i10 = 0;
            while (i != -1 && !this.E) {
                byte[] bArr = this.D;
                if (bArr.length < i10 + 16384) {
                    this.D = Arrays.copyOf(bArr, bArr.length + 16384);
                }
                i = this.C.read(this.D, i10, 16384);
                if (i != -1) {
                    i10 += i;
                }
            }
            if (!this.E) {
                this.F = Arrays.copyOf(this.D, i10);
            }
            com.bumptech.glide.c.f(this.C);
        } catch (Throwable th) {
            com.bumptech.glide.c.f(this.C);
            throw th;
        }
    }

    @Override // s2.j
    public final void c() {
        this.E = true;
    }
}
