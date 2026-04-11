package s2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g1 implements w2.k {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b2.o f11205v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b2.f0 f11206w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public byte[] f11207x;

    public g1(b2.h hVar, b2.o oVar) {
        t.f11325b.getAndIncrement();
        this.f11205v = oVar;
        this.f11206w = new b2.f0(hVar);
    }

    @Override // w2.k
    public final void a() {
        b2.f0 f0Var = this.f11206w;
        f0Var.f1685w = 0L;
        try {
            f0Var.B(this.f11205v);
            int i = 0;
            while (i != -1) {
                int i10 = (int) f0Var.f1685w;
                byte[] bArr = this.f11207x;
                if (bArr == null) {
                    this.f11207x = new byte[1024];
                } else if (i10 == bArr.length) {
                    this.f11207x = Arrays.copyOf(bArr, bArr.length * 2);
                }
                byte[] bArr2 = this.f11207x;
                i = f0Var.read(bArr2, i10, bArr2.length - i10);
            }
            u8.a.g(f0Var);
        } catch (Throwable th) {
            u8.a.g(f0Var);
            throw th;
        }
    }

    @Override // w2.k
    public final void d() {
    }
}
