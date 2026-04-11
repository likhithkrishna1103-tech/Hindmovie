package w2;

import android.net.Uri;
import b2.f0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements k {
    public volatile Object A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f13887v = s2.t.f11325b.getAndIncrement();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b2.o f13888w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f13889x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f0 f13890y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final q f13891z;

    public r(b2.h hVar, b2.o oVar, int i, q qVar) {
        this.f13890y = new f0(hVar);
        this.f13888w = oVar;
        this.f13889x = i;
        this.f13891z = qVar;
    }

    @Override // w2.k
    public final void a() {
        this.f13890y.f1685w = 0L;
        b2.m mVar = new b2.m(this.f13890y, this.f13888w);
        try {
            mVar.a();
            Uri uriT = this.f13890y.f1684v.t();
            uriT.getClass();
            this.A = this.f13891z.g(uriT, mVar);
        } finally {
            a0.g(mVar);
        }
    }

    @Override // w2.k
    public final void d() {
    }
}
