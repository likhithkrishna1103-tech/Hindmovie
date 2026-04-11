package d2;

import android.net.Uri;
import b2.b0;
import b2.c;
import b2.l;
import b2.o;
import b2.y;
import ge.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import kf.q;
import kf.u;
import kf.x;
import kf.z;
import l4.c0;
import of.n;
import v1.h0;
import va.b;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c {
    public final c0 A;
    public final String B;
    public final c0 C;
    public o D;
    public z E;
    public InputStream F;
    public boolean G;
    public long H;
    public long I;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final u f3331z;

    static {
        h0.a("media3.datasource.okhttp");
    }

    public a(u uVar, String str, c0 c0Var) {
        super(true);
        this.f3331z = uVar;
        this.B = str;
        this.C = c0Var;
        this.A = new c0(8);
    }

    @Override // b2.h
    public final long B(o oVar) throws y {
        q qVarB;
        this.D = oVar;
        this.I = 0L;
        this.H = 0L;
        e();
        long j4 = oVar.f;
        int i = oVar.f1716c;
        long j7 = oVar.f1719g;
        String string = oVar.f1714a.toString();
        i.e(string, "<this>");
        try {
            ka.c0 c0Var = new ka.c0(1);
            c0Var.e(null, string);
            qVarB = c0Var.b();
        } catch (IllegalArgumentException unused) {
            qVarB = null;
        }
        if (qVarB == null) {
            throw new y(1004, "Malformed URL");
        }
        dd.c cVar = new dd.c();
        cVar.f3672w = qVarB;
        HashMap map = new HashMap();
        c0 c0Var2 = this.C;
        if (c0Var2 != null) {
            map.putAll(c0Var2.O());
        }
        map.putAll(this.A.O());
        map.putAll(oVar.f1718e);
        for (Map.Entry entry : map.entrySet()) {
            cVar.o((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = b0.a(j4, j7);
        if (strA != null) {
            cVar.l("Range", strA);
        }
        String str = this.B;
        if (str != null) {
            cVar.l("User-Agent", str);
        }
        if ((oVar.i & 1) != 1) {
            cVar.l("Accept-Encoding", "identity");
        }
        byte[] bArr = oVar.f1717d;
        cVar.p(o.b(i), bArr != null ? x.c(bArr) : i == 2 ? x.c(a0.f14553c) : null);
        c2.o oVar2 = new c2.o(cVar);
        u uVar = this.f3331z;
        uVar.getClass();
        n nVar = new n(uVar, oVar2);
        try {
            ya.c0 c0Var3 = new ya.c0();
            nVar.e(new pc.c(c0Var3));
            try {
                z zVar = (z) c0Var3.get();
                this.E = zVar;
                kf.b0 b0Var = zVar.B;
                b0Var.getClass();
                this.F = b0Var.q().d0();
                int i10 = zVar.f7597y;
                if (zVar.K) {
                    b0Var.g();
                    long j10 = (i10 != 200 || j4 == 0) ? 0L : j4;
                    if (j7 != -1) {
                        this.H = j7;
                    } else {
                        long jA = b0Var.a();
                        this.H = jA != -1 ? jA - j10 : -1L;
                    }
                    this.G = true;
                    f(oVar);
                    try {
                        l(j10);
                        return this.H;
                    } catch (y e9) {
                        h();
                        throw e9;
                    }
                }
                if (i10 == 416 && j4 == b0.b(zVar.A.a("Content-Range"))) {
                    this.G = true;
                    f(oVar);
                    if (j7 != -1) {
                        return j7;
                    }
                    return 0L;
                }
                try {
                    InputStream inputStream = this.F;
                    inputStream.getClass();
                    b.b(inputStream);
                } catch (IOException unused2) {
                    int i11 = a0.f14551a;
                }
                TreeMap treeMapD = zVar.A.d();
                h();
                throw new b2.a0(i10, i10 == 416 ? new l(2008) : null, treeMapD);
            } catch (InterruptedException unused3) {
                nVar.d();
                throw new InterruptedIOException();
            } catch (ExecutionException e10) {
                throw new IOException(e10);
            }
        } catch (IOException e11) {
            throw y.a(e11, 1);
        }
    }

    @Override // b2.h
    public final void close() {
        if (this.G) {
            this.G = false;
            c();
            h();
        }
        this.E = null;
        this.D = null;
    }

    public final void h() {
        z zVar = this.E;
        if (zVar != null) {
            kf.b0 b0Var = zVar.B;
            b0Var.getClass();
            b0Var.close();
        }
        this.F = null;
    }

    @Override // b2.c, b2.h
    public final Map j() {
        z zVar = this.E;
        return zVar == null ? Collections.EMPTY_MAP : zVar.A.d();
    }

    public final void l(long j4) throws y {
        if (j4 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j4 > 0) {
            try {
                int iMin = (int) Math.min(j4, 4096);
                InputStream inputStream = this.F;
                int i = a0.f14551a;
                int i10 = inputStream.read(bArr, 0, iMin);
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (i10 == -1) {
                    throw new y(2008);
                }
                j4 -= (long) i10;
                b(i10);
            } catch (IOException e9) {
                if (!(e9 instanceof y)) {
                    throw new y(2000);
                }
                throw ((y) e9);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: IOException -> 0x0032, TRY_LEAVE, TryCatch #0 {IOException -> 0x0032, blocks: (B:5:0x0004, B:7:0x000d, B:10:0x0017, B:11:0x001d, B:14:0x0028), top: B:19:0x0004 }] */
    @Override // v1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int read(byte[] r7, int r8, int r9) throws b2.y {
        /*
            r6 = this;
            if (r9 != 0) goto L4
            r7 = 0
            return r7
        L4:
            long r0 = r6.H     // Catch: java.io.IOException -> L32
            r2 = -1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r3 = -1
            if (r2 == 0) goto L1d
            long r4 = r6.I     // Catch: java.io.IOException -> L32
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
            java.io.InputStream r0 = r6.F     // Catch: java.io.IOException -> L32
            int r1 = y1.a0.f14551a     // Catch: java.io.IOException -> L32
            int r7 = r0.read(r7, r8, r9)     // Catch: java.io.IOException -> L32
            if (r7 != r3) goto L28
        L27:
            return r3
        L28:
            long r8 = r6.I     // Catch: java.io.IOException -> L32
            long r0 = (long) r7     // Catch: java.io.IOException -> L32
            long r8 = r8 + r0
            r6.I = r8     // Catch: java.io.IOException -> L32
            r6.b(r7)     // Catch: java.io.IOException -> L32
            return r7
        L32:
            r7 = move-exception
            int r8 = y1.a0.f14551a
            r8 = 2
            b2.y r7 = b2.y.a(r7, r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.a.read(byte[], int, int):int");
    }

    @Override // b2.h
    public final Uri t() {
        z zVar = this.E;
        if (zVar != null) {
            return Uri.parse(((q) zVar.f7594v.f2035b).f7521h);
        }
        o oVar = this.D;
        if (oVar != null) {
            return oVar.f1714a;
        }
        return null;
    }
}
