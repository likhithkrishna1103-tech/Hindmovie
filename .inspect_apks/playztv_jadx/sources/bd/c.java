package bd;

import a0.g;
import a2.g0;
import android.content.ContentResolver;
import android.content.Context;
import c2.x;
import h4.z;
import id.h;
import id.j;
import id.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import nd.i;
import od.q;
import zc.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {
    public volatile boolean A;
    public volatile boolean B;
    public ed.b C;
    public final i D;
    public volatile long E;
    public volatile long F;
    public volatile boolean G;
    public double H;
    public final g I;
    public long J;
    public ExecutorService K;
    public volatile int L;
    public int M;
    public final Object N;
    public volatile Exception O;
    public List P;
    public p Q;
    public int R;
    public final wb.c S;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final e f2016u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final id.e f2017v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h f2018w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final x f2019x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f2020y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final z f2021z;

    public c(e eVar, id.e eVar2, h hVar, x xVar, String str, z zVar) {
        be.h.e(eVar, "initialDownload");
        be.h.e(eVar2, "downloader");
        be.h.e(hVar, "logger");
        be.h.e(str, "fileTempDir");
        this.f2016u = eVar;
        this.f2017v = eVar2;
        this.f2018w = hVar;
        this.f2019x = xVar;
        this.f2020y = str;
        this.f2021z = zVar;
        this.D = new i(new a5.e(1, this));
        this.F = -1L;
        this.I = new g(3);
        this.J = -1L;
        this.N = new Object();
        this.P = q.f9570u;
        this.S = new wb.c(5, this);
    }

    @Override // bd.b
    public final void F() {
        ed.b bVar = this.C;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f4679c = true;
        }
        this.B = true;
    }

    @Override // bd.b
    public final e H() {
        d().B = this.E;
        d().C = this.F;
        return d();
    }

    @Override // bd.b
    public final void J(ed.b bVar) {
        this.C = bVar;
    }

    public final void a(zc.c cVar, ArrayList arrayList) throws IOException {
        int i = 0;
        this.L = 0;
        this.M = arrayList.size();
        if (!this.f2021z.a0((String) cVar.f14947w)) {
            this.f2021z.I((String) cVar.f14947w, this.f2016u.I == yc.a.f14642x);
        }
        this.f2021z.f0((String) cVar.f14947w, d().C);
        z zVar = this.f2021z;
        String str = (String) cVar.f14947w;
        ContentResolver contentResolver = ((Context) zVar.f5867v).getContentResolver();
        be.h.d(contentResolver, "getContentResolver(...)");
        p pVarN = b8.h.n(contentResolver, str);
        this.Q = pVarN;
        pVarN.d(0L);
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            id.i iVar = (id.i) obj;
            if (this.A || this.B) {
                return;
            }
            ExecutorService executorService = this.K;
            if (executorService != null) {
                executorService.execute(new g0(this, 8, iVar));
            }
        }
    }

    public final long b() {
        double d10 = this.H;
        if (d10 < 1.0d) {
            return 0L;
        }
        return (long) Math.ceil(d10);
    }

    public final ed.b c() {
        return this.C;
    }

    public final e d() {
        return (e) this.D.getValue();
    }

    public final List e(boolean z2, zc.c cVar) {
        Long lY;
        if (!this.f2021z.a0(d().f14953x)) {
            a.a.d(this.f2020y, d().f14950u);
        }
        int i = d().f14950u;
        String str = this.f2020y;
        be.h.e(str, "fileTempDir");
        int iLongValue = -1;
        try {
            Long lY2 = android.support.v4.media.session.b.y(a.a.o(str, i));
            if (lY2 != null) {
                iLongValue = (int) lY2.longValue();
            }
        } catch (Exception unused) {
        }
        long jLongValue = 0;
        if (!z2 || this.G) {
            if (iLongValue != 1) {
                a.a.d(this.f2020y, d().f14950u);
            }
            a.a.J(d().f14950u, 1, this.f2020y);
            int i10 = d().f14950u;
            long j5 = this.F;
            int i11 = d().f14950u;
            String str2 = this.f2020y;
            be.h.e(str2, "fileTempDir");
            try {
                Long lY3 = android.support.v4.media.session.b.y(a.a.l(i11, 1, str2));
                if (lY3 != null) {
                    jLongValue = lY3.longValue();
                }
            } catch (Exception unused2) {
            }
            id.i iVar = new id.i(i10, 1, 0L, j5, jLongValue);
            this.E += iVar.f6583e;
            return android.support.v4.media.session.b.G(iVar);
        }
        this.f2017v.u(cVar);
        long j8 = this.F;
        float f = (j8 / 1024.0f) * 1024.0f;
        j jVar = 1024.0f * f >= 1.0f ? new j(6, (long) Math.ceil(r8 / 6)) : f >= 1.0f ? new j(4, (long) Math.ceil(r8 / 4)) : new j(2, j8);
        if (iLongValue != jVar.f6584a) {
            a.a.d(this.f2020y, d().f14950u);
        }
        a.a.J(d().f14950u, jVar.f6584a, this.f2020y);
        ArrayList arrayList = new ArrayList();
        int i12 = jVar.f6584a;
        if (1 > i12) {
            return arrayList;
        }
        long j10 = 0;
        int i13 = 1;
        while (!this.A && !this.B) {
            long j11 = jVar.f6584a == i13 ? this.F : jVar.f6585b + j10;
            int i14 = d().f14950u;
            int i15 = d().f14950u;
            String str3 = this.f2020y;
            be.h.e(str3, "fileTempDir");
            try {
                lY = android.support.v4.media.session.b.y(a.a.l(i15, i13, str3));
            } catch (Exception unused3) {
            }
            long jLongValue2 = lY != null ? lY.longValue() : 0L;
            id.i iVar2 = new id.i(i14, i13, j10, j11, jLongValue2);
            this.E += iVar2.f6583e;
            arrayList.add(iVar2);
            if (i13 == i12) {
                return arrayList;
            }
            i13++;
            j10 = j11;
        }
        return arrayList;
    }

    public final boolean f() {
        return this.B;
    }

    public final void g() {
        synchronized (this.N) {
            this.L++;
        }
    }

    @Override // bd.b
    public final boolean g0() {
        return this.A;
    }

    public final boolean h() {
        return ((this.E > 0 && this.F > 0) || this.G) && this.E >= this.F;
    }

    public final void i(id.d dVar) {
        if (dVar.f6572b && dVar.f6573c == -1) {
            this.G = true;
        }
    }

    public final void j() {
        long j5 = this.E;
        long jNanoTime = System.nanoTime();
        long jNanoTime2 = System.nanoTime();
        while (this.L != this.M && !this.A && !this.B) {
            d().B = this.E;
            d().C = this.F;
            boolean zB = android.support.v4.media.session.b.B(jNanoTime2, System.nanoTime(), 1000L);
            long j8 = jNanoTime2;
            if (zB) {
                this.I.d(this.E - j5);
                this.H = g.e(this.I);
                this.J = android.support.v4.media.session.b.d(this.E, this.F, b());
                j5 = this.E;
            }
            if (android.support.v4.media.session.b.B(jNanoTime, System.nanoTime(), 2000L)) {
                synchronized (this.N) {
                    try {
                        if (!this.A && !this.B) {
                            d().B = this.E;
                            d().C = this.F;
                            ed.b bVar = this.C;
                            if (bVar != null) {
                                bVar.f(d());
                            }
                            d().O = this.J;
                            d().P = b();
                            ed.b bVar2 = this.C;
                            if (bVar2 != null) {
                                bVar2.d(d(), d().O, d().P);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                jNanoTime = System.nanoTime();
            }
            jNanoTime2 = zB ? System.nanoTime() : j8;
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException unused) {
                this.f2018w.getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:187:0x03d5 A[Catch: all -> 0x0049, TryCatch #3 {all -> 0x0049, blocks: (B:3:0x0008, B:5:0x0045, B:11:0x0053, B:14:0x005d, B:17:0x0065, B:19:0x0069, B:21:0x0073, B:24:0x007a, B:25:0x007f, B:26:0x0080, B:27:0x00a4, B:31:0x00b0, B:32:0x00bd, B:34:0x00c3, B:36:0x00d0, B:37:0x00d4, B:39:0x00da, B:41:0x00e0, B:42:0x0103, B:44:0x0109, B:45:0x0139, B:47:0x013f, B:49:0x0145, B:51:0x0159, B:52:0x0162, B:54:0x0169, B:56:0x0177, B:58:0x017d, B:169:0x0382, B:171:0x0388, B:173:0x038e, B:178:0x03bc, B:179:0x03bf, B:187:0x03d5, B:188:0x03d7, B:190:0x03f6, B:192:0x03fc, B:194:0x0410, B:182:0x03c8, B:184:0x03cc, B:63:0x018b, B:65:0x0193, B:66:0x019d, B:100:0x0212, B:102:0x0228, B:104:0x022e, B:106:0x0234, B:108:0x023a, B:110:0x0240, B:111:0x0247, B:113:0x0261, B:114:0x0276, B:116:0x027c, B:118:0x0282, B:120:0x0288, B:122:0x028c, B:123:0x0294, B:125:0x029a, B:126:0x02a4, B:128:0x02aa, B:131:0x02b8, B:133:0x02cf, B:135:0x02d5, B:137:0x02db, B:139:0x02e1, B:140:0x02e8, B:142:0x02f9, B:144:0x02ff, B:146:0x0328, B:147:0x033b, B:149:0x034f, B:132:0x02b9, B:168:0x0381, B:30:0x00ab, B:70:0x01bd, B:72:0x01c3, B:74:0x01c9, B:77:0x01d0, B:78:0x01d5, B:80:0x01d8, B:82:0x01dc, B:84:0x01e2, B:86:0x01e8, B:89:0x01ef, B:90:0x01f6, B:91:0x01f7, B:93:0x01fd, B:95:0x0203, B:98:0x020a, B:99:0x0211), top: B:237:0x0008, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0410 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #3 {all -> 0x0049, blocks: (B:3:0x0008, B:5:0x0045, B:11:0x0053, B:14:0x005d, B:17:0x0065, B:19:0x0069, B:21:0x0073, B:24:0x007a, B:25:0x007f, B:26:0x0080, B:27:0x00a4, B:31:0x00b0, B:32:0x00bd, B:34:0x00c3, B:36:0x00d0, B:37:0x00d4, B:39:0x00da, B:41:0x00e0, B:42:0x0103, B:44:0x0109, B:45:0x0139, B:47:0x013f, B:49:0x0145, B:51:0x0159, B:52:0x0162, B:54:0x0169, B:56:0x0177, B:58:0x017d, B:169:0x0382, B:171:0x0388, B:173:0x038e, B:178:0x03bc, B:179:0x03bf, B:187:0x03d5, B:188:0x03d7, B:190:0x03f6, B:192:0x03fc, B:194:0x0410, B:182:0x03c8, B:184:0x03cc, B:63:0x018b, B:65:0x0193, B:66:0x019d, B:100:0x0212, B:102:0x0228, B:104:0x022e, B:106:0x0234, B:108:0x023a, B:110:0x0240, B:111:0x0247, B:113:0x0261, B:114:0x0276, B:116:0x027c, B:118:0x0282, B:120:0x0288, B:122:0x028c, B:123:0x0294, B:125:0x029a, B:126:0x02a4, B:128:0x02aa, B:131:0x02b8, B:133:0x02cf, B:135:0x02d5, B:137:0x02db, B:139:0x02e1, B:140:0x02e8, B:142:0x02f9, B:144:0x02ff, B:146:0x0328, B:147:0x033b, B:149:0x034f, B:132:0x02b9, B:168:0x0381, B:30:0x00ab, B:70:0x01bd, B:72:0x01c3, B:74:0x01c9, B:77:0x01d0, B:78:0x01d5, B:80:0x01d8, B:82:0x01dc, B:84:0x01e2, B:86:0x01e8, B:89:0x01ef, B:90:0x01f6, B:91:0x01f7, B:93:0x01fd, B:95:0x0203, B:98:0x020a, B:99:0x0211), top: B:237:0x0008, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x041b A[Catch: Exception -> 0x041f, TRY_LEAVE, TryCatch #7 {Exception -> 0x041f, blocks: (B:195:0x0417, B:197:0x041b), top: B:244:0x0417 }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0429 A[Catch: Exception -> 0x042d, TRY_LEAVE, TryCatch #0 {Exception -> 0x042d, blocks: (B:201:0x0425, B:203:0x0429), top: B:232:0x0425 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0435 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1134
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bd.c.run():void");
    }

    @Override // bd.b
    public final void x() {
        ed.b bVar = this.C;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f4679c = true;
        }
        this.A = true;
    }
}
