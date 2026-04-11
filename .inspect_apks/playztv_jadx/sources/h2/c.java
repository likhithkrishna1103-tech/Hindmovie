package h2;

import aa.l0;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import g4.s0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import k8.a0;
import o2.u;
import p1.m0;
import p1.n0;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements s2.h {
    public static final s0 I = new s0(27);
    public s2.m A;
    public Handler B;
    public g2.l C;
    public o D;
    public Uri E;
    public l F;
    public boolean G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final wb.c f5660u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final s f5661v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a0 f5662w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public l0 f5665z;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CopyOnWriteArrayList f5664y = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HashMap f5663x = new HashMap();
    public long H = -9223372036854775807L;

    public c(wb.c cVar, a0 a0Var, s sVar) {
        this.f5660u = cVar;
        this.f5661v = sVar;
        this.f5662w = a0Var;
    }

    public final l a(Uri uri, boolean z2) {
        HashMap map = this.f5663x;
        l lVar = ((b) map.get(uri)).f5657x;
        if (lVar != null && z2) {
            if (!uri.equals(this.E)) {
                List list = this.D.f5742e;
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        break;
                    }
                    if (uri.equals(((n) list.get(i)).f5735a)) {
                        l lVar2 = this.F;
                        if (lVar2 == null || !lVar2.f5723o) {
                            this.E = uri;
                            b bVar = (b) map.get(uri);
                            l lVar3 = bVar.f5657x;
                            if (lVar3 == null || !lVar3.f5723o) {
                                bVar.f(b(uri));
                            } else {
                                this.F = lVar3;
                                this.C.z(lVar3);
                            }
                        }
                    } else {
                        i++;
                    }
                }
            }
            b bVar2 = (b) map.get(uri);
            l lVar4 = bVar2.f5657x;
            if (!bVar2.E) {
                bVar2.E = true;
                if (lVar4 != null && !lVar4.f5723o) {
                    bVar2.c(true);
                }
            }
        }
        return lVar;
    }

    public final Uri b(Uri uri) {
        h hVar;
        l lVar = this.F;
        if (lVar == null || !lVar.f5730v.f5713e || (hVar = (h) lVar.f5728t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(hVar.f5701b));
        int i = hVar.f5702c;
        if (i != -1) {
            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(i));
        }
        return builderBuildUpon.build();
    }

    public final boolean c(Uri uri) {
        int i;
        b bVar = (b) this.f5663x.get(uri);
        if (bVar.f5657x == null) {
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jMax = Math.max(30000L, b0.b0(bVar.f5657x.f5729u));
        l lVar = bVar.f5657x;
        return lVar.f5723o || (i = lVar.f5714d) == 2 || i == 1 || bVar.f5658y + jMax > jElapsedRealtime;
    }

    @Override // s2.h
    public final void d(s2.j jVar, long j5, long j8) {
        o oVar;
        s2.p pVar = (s2.p) jVar;
        p pVar2 = (p) pVar.f11775z;
        boolean z2 = pVar2 instanceof l;
        if (z2) {
            String str = pVar2.f5747a;
            o oVar2 = o.f5740l;
            Uri uri = Uri.parse(str);
            p1.p pVar3 = new p1.p();
            pVar3.f9957a = "0";
            pVar3.f9966l = m0.p("application/x-mpegURL");
            List listSingletonList = Collections.singletonList(new n(uri, new p1.q(pVar3), null, null, null, null));
            List list = Collections.EMPTY_LIST;
            oVar = new o("", list, listSingletonList, list, list, list, list, null, null, false, Collections.EMPTY_MAP, list);
        } else {
            oVar = (o) pVar2;
        }
        this.D = oVar;
        this.E = ((n) oVar.f5742e.get(0)).f5735a;
        this.f5664y.add(new a(this));
        List list2 = oVar.f5741d;
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            Uri uri2 = (Uri) list2.get(i);
            this.f5663x.put(uri2, new b(this, uri2));
        }
        Uri uri3 = pVar.f11773x.f13128w;
        u uVar = new u(j8);
        b bVar = (b) this.f5663x.get(this.E);
        if (z2) {
            bVar.g((l) pVar2, uVar);
        } else {
            bVar.c(false);
        }
        this.f5662w.getClass();
        this.f5665z.n(uVar, 4);
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
        this.f5665z.t(uVar, pVar.f11772w, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, i);
    }

    @Override // s2.h
    public final e4.f m(s2.j jVar, long j5, long j8, IOException iOException, int i) {
        long jMin;
        s2.p pVar = (s2.p) jVar;
        long j10 = pVar.f11770u;
        Uri uri = pVar.f11773x.f13128w;
        u uVar = new u(j8);
        int i10 = pVar.f11772w;
        this.f5662w.getClass();
        if ((iOException instanceof n0) || (iOException instanceof FileNotFoundException) || (iOException instanceof v1.u) || (iOException instanceof s2.l)) {
            jMin = -9223372036854775807L;
            break;
        }
        int i11 = v1.j.f13143v;
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof v1.j) && ((v1.j) cause).f13144u == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min((i - 1) * 1000, 5000);
        boolean z2 = jMin == -9223372036854775807L;
        this.f5665z.r(uVar, i10, iOException, z2);
        return z2 ? s2.m.f11766z : new e4.f(0, jMin, false);
    }

    @Override // s2.h
    public final void u(s2.j jVar, long j5, long j8, boolean z2) {
        s2.p pVar = (s2.p) jVar;
        long j10 = pVar.f11770u;
        Uri uri = pVar.f11773x.f13128w;
        u uVar = new u(j8);
        this.f5662w.getClass();
        this.f5665z.m(uVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
}
