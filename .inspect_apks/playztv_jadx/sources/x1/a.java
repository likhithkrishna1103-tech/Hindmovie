package x1;

import android.net.Uri;
import b2.g;
import ba.b;
import be.h;
import ea.e0;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import p1.h0;
import s1.b0;
import ue.n;
import ue.o;
import ue.s;
import ue.x;
import ue.z;
import v1.c;
import v1.j;
import v1.m;
import v1.v;
import v1.y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c {
    public final String A;
    public final p2.c B;
    public m C;
    public x D;
    public InputStream E;
    public boolean F;
    public long G;
    public long H;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final s f14206y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final p2.c f14207z;

    static {
        h0.a("media3.datasource.okhttp");
    }

    public a(s sVar, String str, p2.c cVar) {
        super(true);
        this.f14206y = sVar;
        this.A = str;
        this.B = cVar;
        this.f14207z = new p2.c(21);
    }

    @Override // v1.h
    public final void close() {
        if (this.F) {
            this.F = false;
            c();
            j();
        }
        this.D = null;
        this.C = null;
    }

    @Override // v1.h
    public final long h(m mVar) throws v {
        o oVarA;
        this.C = mVar;
        this.H = 0L;
        this.G = 0L;
        d();
        long j5 = mVar.f;
        int i = mVar.f13159c;
        long j8 = mVar.f13162g;
        String string = mVar.f13157a.toString();
        h.e(string, "<this>");
        try {
            n nVar = new n();
            nVar.c(null, string);
            oVarA = nVar.a();
        } catch (IllegalArgumentException unused) {
            oVarA = null;
        }
        if (oVarA == null) {
            throw new v("Malformed URL", 1004);
        }
        zc.c cVar = new zc.c();
        cVar.f14945u = oVarA;
        HashMap map = new HashMap();
        p2.c cVar2 = this.B;
        if (cVar2 != null) {
            map.putAll(cVar2.l());
        }
        map.putAll(this.f14207z.l());
        map.putAll(mVar.f13161e);
        for (Map.Entry entry : map.entrySet()) {
            cVar.p((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = y.a(j5, j8);
        if (strA != null) {
            cVar.l("Range", strA);
        }
        String str = this.A;
        if (str != null) {
            cVar.l("User-Agent", str);
        }
        if ((mVar.i & 1) != 1) {
            cVar.l("Accept-Encoding", "identity");
        }
        byte[] bArr = mVar.f13160d;
        cVar.q(m.b(i), bArr != null ? ue.v.e(bArr) : i == 2 ? ue.v.e(b0.f11649c) : null);
        g gVarM = cVar.m();
        s sVar = this.f14206y;
        sVar.getClass();
        ye.h hVar = new ye.h(sVar, gVarM);
        try {
            e0 e0Var = new e0();
            hVar.e(new o4.c(e0Var));
            try {
                x xVar = (x) e0Var.get();
                this.D = xVar;
                z zVar = xVar.A;
                zVar.getClass();
                this.E = zVar.v().f0();
                int i10 = xVar.f13069x;
                if (200 <= i10 && i10 < 300) {
                    zVar.d();
                    long j10 = (i10 != 200 || j5 == 0) ? 0L : j5;
                    if (j8 != -1) {
                        this.G = j8;
                    } else {
                        long jA = zVar.a();
                        this.G = jA != -1 ? jA - j10 : -1L;
                    }
                    this.F = true;
                    e(mVar);
                    try {
                        p(j10);
                        return this.G;
                    } catch (v e10) {
                        j();
                        throw e10;
                    }
                }
                if (i10 == 416 && j5 == y.b(xVar.f13071z.b("Content-Range"))) {
                    this.F = true;
                    e(mVar);
                    if (j8 != -1) {
                        return j8;
                    }
                    return 0L;
                }
                try {
                    InputStream inputStream = this.E;
                    inputStream.getClass();
                    b.b(inputStream);
                } catch (IOException unused2) {
                    int i11 = b0.f11647a;
                }
                TreeMap treeMapF = xVar.f13071z.f();
                j();
                throw new v1.x(i10, i10 == 416 ? new j(2008) : null, treeMapF);
            } catch (InterruptedException unused3) {
                hVar.d();
                throw new InterruptedIOException();
            } catch (ExecutionException e11) {
                throw new IOException(e11);
            }
        } catch (IOException e12) {
            throw v.a(1, e12);
        }
    }

    public final void j() {
        x xVar = this.D;
        if (xVar != null) {
            z zVar = xVar.A;
            zVar.getClass();
            zVar.close();
        }
        this.E = null;
    }

    @Override // v1.c, v1.h
    public final Map k() {
        x xVar = this.D;
        return xVar == null ? Collections.EMPTY_MAP : xVar.f13071z.f();
    }

    @Override // v1.h
    public final Uri o() {
        x xVar = this.D;
        if (xVar != null) {
            return Uri.parse(((o) xVar.f13066u.f1737b).f13014h);
        }
        m mVar = this.C;
        if (mVar != null) {
            return mVar.f13157a;
        }
        return null;
    }

    public final void p(long j5) throws v {
        if (j5 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j5 > 0) {
            try {
                int iMin = (int) Math.min(j5, 4096);
                InputStream inputStream = this.E;
                int i = b0.f11647a;
                int i10 = inputStream.read(bArr, 0, iMin);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (i10 == -1) {
                    throw new v(2008);
                }
                j5 -= (long) i10;
                b(i10);
            } catch (IOException e10) {
                if (!(e10 instanceof v)) {
                    throw new v(2000);
                }
                throw ((v) e10);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: IOException -> 0x0032, TRY_LEAVE, TryCatch #0 {IOException -> 0x0032, blocks: (B:5:0x0004, B:7:0x000d, B:10:0x0017, B:11:0x001d, B:14:0x0028), top: B:19:0x0004 }] */
    @Override // p1.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int read(byte[] r7, int r8, int r9) throws v1.v {
        /*
            r6 = this;
            if (r9 != 0) goto L4
            r7 = 0
            return r7
        L4:
            long r0 = r6.G     // Catch: java.io.IOException -> L32
            r2 = -1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r3 = -1
            if (r2 == 0) goto L1d
            long r4 = r6.H     // Catch: java.io.IOException -> L32
            long r0 = r0 - r4
            r4 = 0
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 != 0) goto L17
            goto L27
        L17:
            long r4 = (long) r9     // Catch: java.io.IOException -> L32
            long r0 = java.lang.Math.min(r4, r0)     // Catch: java.io.IOException -> L32
            int r9 = (int) r0     // Catch: java.io.IOException -> L32
        L1d:
            java.io.InputStream r0 = r6.E     // Catch: java.io.IOException -> L32
            int r1 = s1.b0.f11647a     // Catch: java.io.IOException -> L32
            int r7 = r0.read(r7, r8, r9)     // Catch: java.io.IOException -> L32
            if (r7 != r3) goto L28
        L27:
            return r3
        L28:
            long r8 = r6.H     // Catch: java.io.IOException -> L32
            long r0 = (long) r7     // Catch: java.io.IOException -> L32
            long r8 = r8 + r0
            r6.H = r8     // Catch: java.io.IOException -> L32
            r6.b(r7)     // Catch: java.io.IOException -> L32
            return r7
        L32:
            r7 = move-exception
            int r8 = s1.b0.f11647a
            r8 = 2
            v1.v r7 = v1.v.a(r8, r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.a.read(byte[], int, int):int");
    }
}
