package o2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i1 implements s2.j {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final v1.m f9139u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v1.c0 f9140v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public byte[] f9141w;

    public i1(v1.h hVar, v1.m mVar) {
        u.f9216b.getAndIncrement();
        this.f9139u = mVar;
        this.f9140v = new v1.c0(hVar);
    }

    @Override // s2.j
    public final void b() {
        v1.c0 c0Var = this.f9140v;
        c0Var.f13127v = 0L;
        try {
            c0Var.h(this.f9139u);
            int i = 0;
            while (i != -1) {
                int i10 = (int) c0Var.f13127v;
                byte[] bArr = this.f9141w;
                if (bArr == null) {
                    this.f9141w = new byte[1024];
                } else if (i10 == bArr.length) {
                    this.f9141w = Arrays.copyOf(bArr, bArr.length * 2);
                }
                byte[] bArr2 = this.f9141w;
                i = c0Var.read(bArr2, i10, bArr2.length - i10);
            }
            com.bumptech.glide.c.f(c0Var);
        } catch (Throwable th) {
            com.bumptech.glide.c.f(c0Var);
            throw th;
        }
    }

    @Override // s2.j
    public final void c() {
    }
}
