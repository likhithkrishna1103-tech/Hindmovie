package h2;

import a2.g0;
import aa.j0;
import aa.l0;
import android.net.Uri;
import android.os.SystemClock;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k8.a0;
import o2.u;
import p1.n0;
import s1.b0;
import v1.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements s2.h {
    public long A;
    public long B;
    public boolean C;
    public IOException D;
    public boolean E;
    public final /* synthetic */ c F;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Uri f5654u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final s2.m f5655v = new s2.m("DefaultHlsPlaylistTracker:MediaPlaylist");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final v1.h f5656w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public l f5657x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f5658y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f5659z;

    public b(c cVar, Uri uri) {
        this.F = cVar;
        this.f5654u = uri;
        this.f5656w = ((v1.g) cVar.f5660u.f14088v).g();
    }

    public static boolean a(b bVar, long j5) {
        bVar.B = SystemClock.elapsedRealtime() + j5;
        Uri uri = bVar.f5654u;
        c cVar = bVar.F;
        if (!uri.equals(cVar.E)) {
            return false;
        }
        List list = cVar.D.f5742e;
        int size = list.size();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            b bVar2 = (b) cVar.f5663x.get(((n) list.get(i)).f5735a);
            bVar2.getClass();
            if (jElapsedRealtime > bVar2.B) {
                Uri uri2 = bVar2.f5654u;
                cVar.E = uri2;
                bVar2.f(cVar.b(uri2));
                return false;
            }
        }
        return true;
    }

    public final Uri b() {
        l lVar = this.f5657x;
        Uri uri = this.f5654u;
        if (lVar != null) {
            k kVar = lVar.f5730v;
            if (kVar.f5709a != -9223372036854775807L || kVar.f5713e) {
                Uri.Builder builderBuildUpon = uri.buildUpon();
                l lVar2 = this.f5657x;
                if (lVar2.f5730v.f5713e) {
                    builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(lVar2.f5719k + ((long) lVar2.f5726r.size())));
                    l lVar3 = this.f5657x;
                    if (lVar3.f5722n != -9223372036854775807L) {
                        j0 j0Var = lVar3.f5727s;
                        int size = j0Var.size();
                        if (!j0Var.isEmpty() && ((g) aa.q.k(j0Var)).G) {
                            size--;
                        }
                        builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                    }
                }
                k kVar2 = this.f5657x.f5730v;
                if (kVar2.f5709a != -9223372036854775807L) {
                    builderBuildUpon.appendQueryParameter("_HLS_skip", kVar2.f5710b ? "v2" : "YES");
                }
                return builderBuildUpon.build();
            }
        }
        return uri;
    }

    public final void c(boolean z2) {
        f(z2 ? b() : this.f5654u);
    }

    @Override // s2.h
    public final void d(s2.j jVar, long j5, long j8) {
        s2.p pVar = (s2.p) jVar;
        p pVar2 = (p) pVar.f11775z;
        Uri uri = pVar.f11773x.f13128w;
        u uVar = new u(j8);
        if (pVar2 instanceof l) {
            g((l) pVar2, uVar);
            this.F.f5665z.n(uVar, 4);
        } else {
            n0 n0VarB = n0.b("Loaded playlist has unexpected type.", null);
            this.D = n0VarB;
            this.F.f5665z.r(uVar, 4, n0VarB, true);
        }
        this.F.f5662w.getClass();
    }

    public final void e(Uri uri) {
        c cVar = this.F;
        s2.o oVarJ = cVar.f5661v.j(cVar.D, this.f5657x);
        Map map = Collections.EMPTY_MAP;
        s1.d.i(uri, "The uri must be set.");
        s2.p pVar = new s2.p(this.f5656w, new v1.m(uri, 0L, 1, null, map, 0L, -1L, null, 1), 4, oVarJ);
        this.f5655v.f(pVar, this, cVar.f5662w.k(pVar.f11772w));
    }

    public final void f(Uri uri) {
        this.B = 0L;
        if (this.C) {
            return;
        }
        s2.m mVar = this.f5655v;
        if (mVar.d() || mVar.c()) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = this.A;
        if (jElapsedRealtime >= j5) {
            e(uri);
        } else {
            this.C = true;
            this.F.B.postDelayed(new g0(this, 23, uri), j5 - jElapsedRealtime);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0251  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(h2.l r73, o2.u r74) {
        /*
            Method dump skipped, instruction units count: 657
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.b.g(h2.l, o2.u):void");
    }

    @Override // s2.h
    public final void k(s2.j jVar, long j5, long j8, int i) {
        u uVar;
        s2.p pVar = (s2.p) jVar;
        if (i == 0) {
            long j10 = pVar.f11770u;
            uVar = new u(pVar.f11771v);
        } else {
            long j11 = pVar.f11770u;
            Uri uri = pVar.f11773x.f13128w;
            uVar = new u(j8);
        }
        this.F.f5665z.t(uVar, pVar.f11772w, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, i);
    }

    @Override // s2.h
    public final e4.f m(s2.j jVar, long j5, long j8, IOException iOException, int i) {
        s2.p pVar = (s2.p) jVar;
        long j10 = pVar.f11770u;
        int i10 = pVar.f11772w;
        Uri uri = pVar.f11773x.f13128w;
        u uVar = new u(j8);
        boolean z2 = uri.getQueryParameter("_HLS_msn") != null;
        boolean z10 = iOException instanceof q;
        e4.f fVar = s2.m.f11765y;
        c cVar = this.F;
        if (z2 || z10) {
            int i11 = iOException instanceof x ? ((x) iOException).f13177x : Integer.MAX_VALUE;
            if (z10 || i11 == 400 || i11 == 503) {
                this.A = SystemClock.elapsedRealtime();
                c(false);
                l0 l0Var = cVar.f5665z;
                int i12 = b0.f11647a;
                l0Var.r(uVar, i10, iOException, true);
                return fVar;
            }
        }
        e6.i iVar = new e6.i(i, iOException);
        Iterator it = cVar.f5664y.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            z11 |= !((t) it.next()).d(this.f5654u, iVar, false);
        }
        a0 a0Var = cVar.f5662w;
        if (z11) {
            a0Var.getClass();
            long jN = a0.n(iVar);
            fVar = jN != -9223372036854775807L ? new e4.f(0, jN, false) : s2.m.f11766z;
        }
        boolean zA = fVar.a();
        cVar.f5665z.r(uVar, i10, iOException, !zA);
        if (!zA) {
            a0Var.getClass();
        }
        return fVar;
    }

    @Override // s2.h
    public final void u(s2.j jVar, long j5, long j8, boolean z2) {
        s2.p pVar = (s2.p) jVar;
        long j10 = pVar.f11770u;
        Uri uri = pVar.f11773x.f13128w;
        u uVar = new u(j8);
        c cVar = this.F;
        cVar.f5662w.getClass();
        cVar.f5665z.m(uVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
}
