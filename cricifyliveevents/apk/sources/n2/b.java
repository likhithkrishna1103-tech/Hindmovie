package n2;

import android.net.Uri;
import android.os.SystemClock;
import b2.a0;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ua.i0;
import v1.n0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements w2.i {
    public long A;
    public long B;
    public long C;
    public boolean D;
    public IOException E;
    public boolean F;
    public final /* synthetic */ c G;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Uri f8632v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final w2.o f8633w = new w2.o("DefaultHlsPlaylistTracker:MediaPlaylist");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b2.h f8634x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public l f8635y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f8636z;

    public b(c cVar, Uri uri) {
        this.G = cVar;
        this.f8632v = uri;
        this.f8634x = ((b2.g) cVar.f8637v.f7697v).h();
    }

    public static boolean a(b bVar, long j4) {
        bVar.C = SystemClock.elapsedRealtime() + j4;
        Uri uri = bVar.f8632v;
        c cVar = bVar.G;
        if (!uri.equals(cVar.F)) {
            return false;
        }
        List list = cVar.E.f8717e;
        int size = list.size();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            b bVar2 = (b) cVar.f8640y.get(((n) list.get(i)).f8710a);
            bVar2.getClass();
            if (jElapsedRealtime > bVar2.C) {
                Uri uri2 = bVar2.f8632v;
                cVar.F = uri2;
                bVar2.e(cVar.b(uri2));
                return false;
            }
        }
        return true;
    }

    @Override // w2.i
    public final void B(w2.k kVar, long j4, long j7, int i) {
        s2.t tVar;
        w2.r rVar = (w2.r) kVar;
        if (i == 0) {
            long j10 = rVar.f13887v;
            tVar = new s2.t(rVar.f13888w);
        } else {
            long j11 = rVar.f13887v;
            Uri uri = rVar.f13890y.f1686x;
            tVar = new s2.t(j7);
        }
        this.G.A.s(tVar, rVar.f13889x, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, i);
    }

    public final Uri b() {
        l lVar = this.f8635y;
        Uri uri = this.f8632v;
        if (lVar != null) {
            k kVar = lVar.f8705v;
            if (kVar.f8684a != -9223372036854775807L || kVar.f8688e) {
                Uri.Builder builderBuildUpon = uri.buildUpon();
                l lVar2 = this.f8635y;
                if (lVar2.f8705v.f8688e) {
                    builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(lVar2.f8694k + ((long) lVar2.f8701r.size())));
                    l lVar3 = this.f8635y;
                    if (lVar3.f8697n != -9223372036854775807L) {
                        i0 i0Var = lVar3.f8702s;
                        int size = i0Var.size();
                        if (!i0Var.isEmpty() && ((g) ua.q.l(i0Var)).H) {
                            size--;
                        }
                        builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                    }
                }
                k kVar2 = this.f8635y.f8705v;
                if (kVar2.f8684a != -9223372036854775807L) {
                    builderBuildUpon.appendQueryParameter("_HLS_skip", kVar2.f8685b ? "v2" : "YES");
                }
                return builderBuildUpon.build();
            }
        }
        return uri;
    }

    public final void c(boolean z10) {
        e(z10 ? b() : this.f8632v);
    }

    public final void d(Uri uri) {
        c cVar = this.G;
        w2.q qVarT = cVar.f8638w.t(cVar.E, this.f8635y);
        Map map = Collections.EMPTY_MAP;
        y1.d.i(uri, "The uri must be set.");
        w2.r rVar = new w2.r(this.f8634x, new b2.o(uri, 0L, 1, null, map, 0L, -1L, null, 1), 4, qVarT);
        this.f8633w.f(rVar, this, cVar.f8639x.m(rVar.f13889x));
    }

    public final void e(Uri uri) {
        this.C = 0L;
        if (this.D) {
            return;
        }
        w2.o oVar = this.f8633w;
        if (oVar.d() || oVar.b()) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j4 = this.B;
        if (jElapsedRealtime >= j4) {
            d(uri);
        } else {
            this.D = true;
            this.G.C.postDelayed(new androidx.fragment.app.d(28, this, uri), j4 - jElapsedRealtime);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0253  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(n2.l r73, s2.t r74) {
        /*
            Method dump skipped, instruction units count: 659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.b.f(n2.l, s2.t):void");
    }

    @Override // w2.i
    public final i4.e g(w2.k kVar, long j4, long j7, IOException iOException, int i) {
        w2.r rVar = (w2.r) kVar;
        long j10 = rVar.f13887v;
        int i10 = rVar.f13889x;
        Uri uri = rVar.f13890y.f1686x;
        s2.t tVar = new s2.t(j7);
        boolean z10 = uri.getQueryParameter("_HLS_msn") != null;
        boolean z11 = iOException instanceof q;
        i4.e eVar = w2.o.f13883e;
        c cVar = this.G;
        if (z10 || z11) {
            int i11 = iOException instanceof a0 ? ((a0) iOException).f1671y : Integer.MAX_VALUE;
            if (z11 || i11 == 400 || i11 == 503) {
                this.B = SystemClock.elapsedRealtime();
                c(false);
                f3.a aVar = cVar.A;
                int i12 = y1.a0.f14551a;
                aVar.q(tVar, i10, iOException, true);
                return eVar;
            }
        }
        ag.o oVar = new ag.o(i, 10, iOException);
        Iterator it = cVar.f8641z.iterator();
        boolean z12 = false;
        while (it.hasNext()) {
            z12 |= !((t) it.next()).c(this.f8632v, oVar, false);
        }
        f9.a0 a0Var = cVar.f8639x;
        if (z12) {
            a0Var.getClass();
            long jQ = f9.a0.q(oVar);
            eVar = jQ != -9223372036854775807L ? new i4.e(0, jQ, false) : w2.o.f;
        }
        boolean zA = eVar.a();
        cVar.A.q(tVar, i10, iOException, !zA);
        if (!zA) {
            a0Var.getClass();
        }
        return eVar;
    }

    @Override // w2.i
    public final void k(w2.k kVar, long j4, long j7) {
        w2.r rVar = (w2.r) kVar;
        p pVar = (p) rVar.A;
        Uri uri = rVar.f13890y.f1686x;
        s2.t tVar = new s2.t(j7);
        if (pVar instanceof l) {
            f((l) pVar, tVar);
            this.G.A.o(tVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        } else {
            n0 n0VarB = n0.b("Loaded playlist has unexpected type.", null);
            this.E = n0VarB;
            this.G.A.q(tVar, 4, n0VarB, true);
        }
        this.G.f8639x.getClass();
    }

    @Override // w2.i
    public final void n(w2.k kVar, long j4, long j7, boolean z10) {
        w2.r rVar = (w2.r) kVar;
        long j10 = rVar.f13887v;
        Uri uri = rVar.f13890y.f1686x;
        s2.t tVar = new s2.t(j7);
        c cVar = this.G;
        cVar.f8639x.getClass();
        cVar.A.n(tVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
}
