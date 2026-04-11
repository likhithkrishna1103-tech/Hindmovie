package n2;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import b2.x;
import f9.a0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import k4.r0;
import v1.m0;
import v1.n0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements w2.i {
    public static final r0 J = new r0(26);
    public f3.a A;
    public w2.o B;
    public Handler C;
    public m2.m D;
    public o E;
    public Uri F;
    public l G;
    public boolean H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l4.a f8637v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final s f8638w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a0 f8639x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CopyOnWriteArrayList f8641z = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final HashMap f8640y = new HashMap();
    public long I = -9223372036854775807L;

    public c(l4.a aVar, a0 a0Var, s sVar) {
        this.f8637v = aVar;
        this.f8638w = sVar;
        this.f8639x = a0Var;
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
        this.A.s(tVar, rVar.f13889x, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, i);
    }

    public final l a(Uri uri, boolean z10) {
        HashMap map = this.f8640y;
        l lVar = ((b) map.get(uri)).f8635y;
        if (lVar != null && z10) {
            if (!uri.equals(this.F)) {
                List list = this.E.f8717e;
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        break;
                    }
                    if (uri.equals(((n) list.get(i)).f8710a)) {
                        l lVar2 = this.G;
                        if (lVar2 == null || !lVar2.f8698o) {
                            this.F = uri;
                            b bVar = (b) map.get(uri);
                            l lVar3 = bVar.f8635y;
                            if (lVar3 == null || !lVar3.f8698o) {
                                bVar.e(b(uri));
                            } else {
                                this.G = lVar3;
                                this.D.v(lVar3);
                            }
                        }
                    } else {
                        i++;
                    }
                }
            }
            b bVar2 = (b) map.get(uri);
            l lVar4 = bVar2.f8635y;
            if (!bVar2.F) {
                bVar2.F = true;
                if (lVar4 != null && !lVar4.f8698o) {
                    bVar2.c(true);
                }
            }
        }
        return lVar;
    }

    public final Uri b(Uri uri) {
        h hVar;
        l lVar = this.G;
        if (lVar == null || !lVar.f8705v.f8688e || (hVar = (h) lVar.f8703t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(hVar.f8677b));
        int i = hVar.f8678c;
        if (i != -1) {
            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(i));
        }
        return builderBuildUpon.build();
    }

    public final boolean c(Uri uri) {
        int i;
        b bVar = (b) this.f8640y.get(uri);
        if (bVar.f8635y == null) {
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jMax = Math.max(30000L, y1.a0.b0(bVar.f8635y.f8704u));
        l lVar = bVar.f8635y;
        return lVar.f8698o || (i = lVar.f8689d) == 2 || i == 1 || bVar.f8636z + jMax > jElapsedRealtime;
    }

    @Override // w2.i
    public final i4.e g(w2.k kVar, long j4, long j7, IOException iOException, int i) {
        long jMin;
        w2.r rVar = (w2.r) kVar;
        long j10 = rVar.f13887v;
        Uri uri = rVar.f13890y.f1686x;
        s2.t tVar = new s2.t(j7);
        int i10 = rVar.f13889x;
        this.f8639x.getClass();
        if ((iOException instanceof n0) || (iOException instanceof FileNotFoundException) || (iOException instanceof x) || (iOException instanceof w2.n)) {
            jMin = -9223372036854775807L;
            break;
        }
        int i11 = b2.l.f1700w;
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof b2.l) && ((b2.l) cause).f1701v == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min((i - 1) * 1000, 5000);
        boolean z10 = jMin == -9223372036854775807L;
        this.A.q(tVar, i10, iOException, z10);
        return z10 ? w2.o.f : new i4.e(0, jMin, false);
    }

    @Override // w2.i
    public final void k(w2.k kVar, long j4, long j7) {
        o oVar;
        w2.r rVar = (w2.r) kVar;
        p pVar = (p) rVar.A;
        boolean z10 = pVar instanceof l;
        if (z10) {
            String str = pVar.f8722a;
            o oVar2 = o.f8715l;
            Uri uri = Uri.parse(str);
            v1.o oVar3 = new v1.o();
            oVar3.f12883a = "0";
            oVar3.f12892l = m0.p("application/x-mpegURL");
            List listSingletonList = Collections.singletonList(new n(uri, new v1.p(oVar3), null, null, null, null));
            List list = Collections.EMPTY_LIST;
            oVar = new o("", list, listSingletonList, list, list, list, list, null, null, false, Collections.EMPTY_MAP, list);
        } else {
            oVar = (o) pVar;
        }
        this.E = oVar;
        this.F = ((n) oVar.f8717e.get(0)).f8710a;
        this.f8641z.add(new a(this));
        List list2 = oVar.f8716d;
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            Uri uri2 = (Uri) list2.get(i);
            this.f8640y.put(uri2, new b(this, uri2));
        }
        Uri uri3 = rVar.f13890y.f1686x;
        s2.t tVar = new s2.t(j7);
        b bVar = (b) this.f8640y.get(this.F);
        if (z10) {
            bVar.f((l) pVar, tVar);
        } else {
            bVar.c(false);
        }
        this.f8639x.getClass();
        this.A.o(tVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    @Override // w2.i
    public final void n(w2.k kVar, long j4, long j7, boolean z10) {
        w2.r rVar = (w2.r) kVar;
        long j10 = rVar.f13887v;
        Uri uri = rVar.f13890y.f1686x;
        s2.t tVar = new s2.t(j7);
        this.f8639x.getClass();
        this.A.n(tVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
}
