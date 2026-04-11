package j2;

import android.net.Uri;
import java.io.IOException;
import s2.t;
import w2.r;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements w2.i {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ h f6537v;

    @Override // w2.i
    public i4.e g(w2.k kVar, long j4, long j7, IOException iOException, int i) {
        r rVar = (r) kVar;
        h hVar = this.f6537v;
        f3.a aVar = hVar.f6547q;
        long j10 = rVar.f13887v;
        Uri uri = rVar.f13890y.f1686x;
        aVar.q(new t(j7), rVar.f13889x, iOException, true);
        hVar.f6543m.getClass();
        hVar.x(iOException);
        return w2.o.f13883e;
    }

    @Override // w2.i
    public void k(w2.k kVar, long j4, long j7) {
        r rVar = (r) kVar;
        h hVar = this.f6537v;
        long j10 = rVar.f13887v;
        Uri uri = rVar.f13890y.f1686x;
        t tVar = new t(j7);
        hVar.f6543m.getClass();
        hVar.f6547q.o(tVar, rVar.f13889x, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        hVar.L = ((Long) rVar.A).longValue() - j4;
        hVar.y(true);
    }

    @Override // w2.i
    public void n(w2.k kVar, long j4, long j7, boolean z10) {
        this.f6537v.w((r) kVar, j7);
    }

    @Override // w2.i
    public /* synthetic */ void B(w2.k kVar, long j4, long j7, int i) {
    }
}
