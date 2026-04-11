package fd;

import android.content.ContentResolver;
import android.content.Context;
import b2.q;
import c.d0;
import com.google.android.gms.internal.measurement.j4;
import dd.e;
import ge.i;
import i2.k;
import i2.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import md.h;
import md.o;
import rd.j;
import sd.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {
    public final k A;
    public volatile boolean B;
    public volatile boolean C;
    public id.b D;
    public final j E;
    public volatile long F;
    public volatile long G;
    public volatile boolean H;
    public double I;
    public final q J;
    public long K;
    public ExecutorService L;
    public volatile int M;
    public int N;
    public final Object O;
    public volatile Exception P;
    public List Q;
    public o R;
    public int S;
    public final p6.d T;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e f4565v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final md.e f4566w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d5.a f4567x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final x f4568y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f4569z;

    public c(e eVar, md.e eVar2, d5.a aVar, x xVar, String str, k kVar) {
        i.e(eVar, "initialDownload");
        i.e(eVar2, "downloader");
        i.e(aVar, "logger");
        i.e(str, "fileTempDir");
        this.f4565v = eVar;
        this.f4566w = eVar2;
        this.f4567x = aVar;
        this.f4568y = xVar;
        this.f4569z = str;
        this.A = kVar;
        this.E = new j(new d0(2, this));
        this.G = -1L;
        this.J = new q(3);
        this.K = -1L;
        this.O = new Object();
        this.Q = p.f11669v;
        this.T = new p6.d(18, this);
    }

    @Override // fd.b
    public final e A() {
        d().C = this.F;
        d().D = this.G;
        return d();
    }

    @Override // fd.b
    public final void Q(id.b bVar) {
        this.D = bVar;
    }

    public final void a(dd.c cVar, ArrayList arrayList) throws IOException {
        int i = 0;
        this.M = 0;
        this.N = arrayList.size();
        if (!this.A.i((String) cVar.f3674y)) {
            this.A.d((String) cVar.f3674y, this.f4565v.J == cd.a.f2144y);
        }
        this.A.q((String) cVar.f3674y, d().D);
        k kVar = this.A;
        String str = (String) cVar.f3674y;
        ContentResolver contentResolver = ((Context) kVar.f6085v).getContentResolver();
        i.d(contentResolver, "getContentResolver(...)");
        o oVarQ = com.bumptech.glide.c.q(str, contentResolver);
        this.R = oVarQ;
        oVarQ.g(0L);
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            h hVar = (h) obj;
            if (this.B || this.C) {
                return;
            }
            ExecutorService executorService = this.L;
            if (executorService != null) {
                executorService.execute(new androidx.fragment.app.d(4, this, hVar));
            }
        }
    }

    public final long b() {
        double d10 = this.I;
        if (d10 < 1.0d) {
            return 0L;
        }
        return (long) Math.ceil(d10);
    }

    public final id.b c() {
        return this.D;
    }

    public final e d() {
        return (e) this.E.getValue();
    }

    public final List e(boolean z10, dd.c cVar) {
        Long lW;
        if (!this.A.i(d().f3679y)) {
            j4.d(d().f3676v, this.f4569z);
        }
        int i = d().f3676v;
        String str = this.f4569z;
        i.e(str, "fileTempDir");
        int iLongValue = -1;
        try {
            Long lW2 = android.support.v4.media.session.b.w(j4.l(i, str));
            if (lW2 != null) {
                iLongValue = (int) lW2.longValue();
            }
        } catch (Exception unused) {
        }
        long jLongValue = 0;
        if (!z10 || this.H) {
            if (iLongValue != 1) {
                j4.d(d().f3676v, this.f4569z);
            }
            j4.B(d().f3676v, 1, this.f4569z);
            int i10 = d().f3676v;
            long j4 = this.G;
            int i11 = d().f3676v;
            String str2 = this.f4569z;
            i.e(str2, "fileTempDir");
            try {
                Long lW3 = android.support.v4.media.session.b.w(j4.h(i11, 1, str2));
                if (lW3 != null) {
                    jLongValue = lW3.longValue();
                }
            } catch (Exception unused2) {
            }
            h hVar = new h(i10, 1, 0L, j4, jLongValue);
            this.F += hVar.f8438e;
            return n5.a.x(hVar);
        }
        this.f4566w.F(cVar);
        long j7 = this.G;
        float f = (j7 / 1024.0f) * 1024.0f;
        md.i iVar = 1024.0f * f >= 1.0f ? new md.i(6, (long) Math.ceil(r8 / 6)) : f >= 1.0f ? new md.i(4, (long) Math.ceil(r8 / 4)) : new md.i(2, j7);
        if (iLongValue != iVar.f8439a) {
            j4.d(d().f3676v, this.f4569z);
        }
        j4.B(d().f3676v, iVar.f8439a, this.f4569z);
        ArrayList arrayList = new ArrayList();
        int i12 = iVar.f8439a;
        if (1 > i12) {
            return arrayList;
        }
        long j10 = 0;
        int i13 = 1;
        while (!this.B && !this.C) {
            long j11 = iVar.f8439a == i13 ? this.G : iVar.f8440b + j10;
            int i14 = d().f3676v;
            int i15 = d().f3676v;
            String str3 = this.f4569z;
            i.e(str3, "fileTempDir");
            try {
                lW = android.support.v4.media.session.b.w(j4.h(i15, i13, str3));
            } catch (Exception unused3) {
            }
            long jLongValue2 = lW != null ? lW.longValue() : 0L;
            h hVar2 = new h(i14, i13, j10, j11, jLongValue2);
            this.F += hVar2.f8438e;
            arrayList.add(hVar2);
            if (i13 == i12) {
                return arrayList;
            }
            i13++;
            j10 = j11;
        }
        return arrayList;
    }

    @Override // fd.b
    public final boolean e0() {
        return this.B;
    }

    public final boolean f() {
        return this.C;
    }

    public final void g() {
        synchronized (this.O) {
            this.M++;
        }
    }

    public final boolean h() {
        return ((this.F > 0 && this.G > 0) || this.H) && this.F >= this.G;
    }

    public final void i(md.d dVar) {
        if (dVar.f8428b && dVar.f8429c == -1) {
            this.H = true;
        }
    }

    public final void j() {
        long j4 = this.F;
        long jNanoTime = System.nanoTime();
        long jNanoTime2 = System.nanoTime();
        while (this.M != this.N && !this.B && !this.C) {
            d().C = this.F;
            d().D = this.G;
            boolean zA = android.support.v4.media.session.b.A(jNanoTime2, System.nanoTime(), 1000L);
            long j7 = jNanoTime2;
            if (zA) {
                this.J.d(this.F - j4);
                this.I = q.e(this.J);
                this.K = android.support.v4.media.session.b.c(this.F, this.G, b());
                j4 = this.F;
            }
            if (android.support.v4.media.session.b.A(jNanoTime, System.nanoTime(), 2000L)) {
                synchronized (this.O) {
                    try {
                        if (!this.B && !this.C) {
                            d().C = this.F;
                            d().D = this.G;
                            id.b bVar = this.D;
                            if (bVar != null) {
                                bVar.f(d());
                            }
                            d().P = this.K;
                            d().Q = b();
                            id.b bVar2 = this.D;
                            if (bVar2 != null) {
                                bVar2.d(d(), d().P, d().Q);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                jNanoTime = System.nanoTime();
            }
            jNanoTime2 = zA ? System.nanoTime() : j7;
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException unused) {
                this.f4567x.getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:187:0x03d1 A[Catch: all -> 0x0049, TryCatch #4 {all -> 0x0049, blocks: (B:3:0x0008, B:5:0x0045, B:11:0x0053, B:14:0x005d, B:17:0x0065, B:19:0x0069, B:21:0x0073, B:24:0x007a, B:25:0x007f, B:26:0x0080, B:27:0x00a4, B:31:0x00b0, B:32:0x00bb, B:34:0x00c1, B:36:0x00ce, B:37:0x00d2, B:39:0x00d8, B:41:0x00de, B:42:0x0101, B:44:0x0107, B:45:0x0137, B:47:0x013d, B:49:0x0143, B:51:0x0157, B:52:0x0160, B:54:0x0167, B:56:0x0175, B:58:0x017b, B:169:0x037e, B:171:0x0384, B:173:0x038a, B:178:0x03b8, B:179:0x03bb, B:187:0x03d1, B:188:0x03d3, B:190:0x03f2, B:192:0x03f8, B:194:0x040c, B:182:0x03c4, B:184:0x03c8, B:63:0x0189, B:65:0x0191, B:66:0x019b, B:100:0x0210, B:102:0x0226, B:104:0x022c, B:106:0x0232, B:108:0x0238, B:110:0x023e, B:111:0x0245, B:113:0x025f, B:114:0x0274, B:116:0x027a, B:118:0x0280, B:120:0x0286, B:122:0x028a, B:123:0x0290, B:125:0x0296, B:126:0x02a0, B:128:0x02a6, B:131:0x02b4, B:133:0x02cb, B:135:0x02d1, B:137:0x02d7, B:139:0x02dd, B:140:0x02e4, B:142:0x02f5, B:144:0x02fb, B:146:0x0324, B:147:0x0337, B:149:0x034b, B:132:0x02b5, B:168:0x037d, B:30:0x00ab, B:70:0x01bb, B:72:0x01c1, B:74:0x01c7, B:77:0x01ce, B:78:0x01d3, B:80:0x01d6, B:82:0x01da, B:84:0x01e0, B:86:0x01e6, B:89:0x01ed, B:90:0x01f4, B:91:0x01f5, B:93:0x01fb, B:95:0x0201, B:98:0x0208, B:99:0x020f), top: B:239:0x0008, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x040c A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #4 {all -> 0x0049, blocks: (B:3:0x0008, B:5:0x0045, B:11:0x0053, B:14:0x005d, B:17:0x0065, B:19:0x0069, B:21:0x0073, B:24:0x007a, B:25:0x007f, B:26:0x0080, B:27:0x00a4, B:31:0x00b0, B:32:0x00bb, B:34:0x00c1, B:36:0x00ce, B:37:0x00d2, B:39:0x00d8, B:41:0x00de, B:42:0x0101, B:44:0x0107, B:45:0x0137, B:47:0x013d, B:49:0x0143, B:51:0x0157, B:52:0x0160, B:54:0x0167, B:56:0x0175, B:58:0x017b, B:169:0x037e, B:171:0x0384, B:173:0x038a, B:178:0x03b8, B:179:0x03bb, B:187:0x03d1, B:188:0x03d3, B:190:0x03f2, B:192:0x03f8, B:194:0x040c, B:182:0x03c4, B:184:0x03c8, B:63:0x0189, B:65:0x0191, B:66:0x019b, B:100:0x0210, B:102:0x0226, B:104:0x022c, B:106:0x0232, B:108:0x0238, B:110:0x023e, B:111:0x0245, B:113:0x025f, B:114:0x0274, B:116:0x027a, B:118:0x0280, B:120:0x0286, B:122:0x028a, B:123:0x0290, B:125:0x0296, B:126:0x02a0, B:128:0x02a6, B:131:0x02b4, B:133:0x02cb, B:135:0x02d1, B:137:0x02d7, B:139:0x02dd, B:140:0x02e4, B:142:0x02f5, B:144:0x02fb, B:146:0x0324, B:147:0x0337, B:149:0x034b, B:132:0x02b5, B:168:0x037d, B:30:0x00ab, B:70:0x01bb, B:72:0x01c1, B:74:0x01c7, B:77:0x01ce, B:78:0x01d3, B:80:0x01d6, B:82:0x01da, B:84:0x01e0, B:86:0x01e6, B:89:0x01ed, B:90:0x01f4, B:91:0x01f5, B:93:0x01fb, B:95:0x0201, B:98:0x0208, B:99:0x020f), top: B:239:0x0008, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0417 A[Catch: Exception -> 0x041b, TRY_LEAVE, TryCatch #10 {Exception -> 0x041b, blocks: (B:195:0x0413, B:197:0x0417), top: B:250:0x0413 }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0425 A[Catch: Exception -> 0x0429, TRY_LEAVE, TryCatch #2 {Exception -> 0x0429, blocks: (B:201:0x0421, B:203:0x0425), top: B:235:0x0421 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0431 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1130
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fd.c.run():void");
    }

    @Override // fd.b
    public final void s() {
        id.b bVar = this.D;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f6442c = true;
        }
        this.B = true;
    }

    @Override // fd.b
    public final void z() {
        id.b bVar = this.D;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f6442c = true;
        }
        this.C = true;
    }
}
