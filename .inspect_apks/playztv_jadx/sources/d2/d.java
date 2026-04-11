package d2;

import aa.l0;
import android.net.Uri;
import java.io.IOException;
import o2.u;
import s2.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements s2.h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ g f3708u;

    public void a() {
        long j5;
        g gVar = this.f3708u;
        synchronized (t2.b.f12068b) {
            try {
                j5 = t2.b.f12069c ? t2.b.f12070d : -9223372036854775807L;
            } catch (Throwable th) {
                throw th;
            }
        }
        gVar.f3723f0 = j5;
        gVar.C(true);
    }

    @Override // s2.h
    public void d(s2.j jVar, long j5, long j8) {
        p pVar = (p) jVar;
        g gVar = this.f3708u;
        long j10 = pVar.f11770u;
        Uri uri = pVar.f11773x.f13128w;
        u uVar = new u(j8);
        gVar.G.getClass();
        gVar.K.n(uVar, pVar.f11772w);
        gVar.f3723f0 = ((Long) pVar.f11775z).longValue() - j5;
        gVar.C(true);
    }

    @Override // s2.h
    public e4.f m(s2.j jVar, long j5, long j8, IOException iOException, int i) {
        p pVar = (p) jVar;
        g gVar = this.f3708u;
        l0 l0Var = gVar.K;
        long j10 = pVar.f11770u;
        Uri uri = pVar.f11773x.f13128w;
        l0Var.r(new u(j8), pVar.f11772w, iOException, true);
        gVar.G.getClass();
        gVar.B(iOException);
        return s2.m.f11765y;
    }

    @Override // s2.h
    public void u(s2.j jVar, long j5, long j8, boolean z2) {
        this.f3708u.A((p) jVar, j8);
    }

    @Override // s2.h
    public /* synthetic */ void k(s2.j jVar, long j5, long j8, int i) {
    }
}
