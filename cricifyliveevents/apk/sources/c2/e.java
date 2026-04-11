package c2;

import android.net.Uri;
import b2.c0;
import b2.g0;
import b2.h0;
import java.io.InterruptedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements b2.h {
    public final boolean A;
    public final boolean B;
    public Uri C;
    public b2.o D;
    public b2.o E;
    public b2.h F;
    public long G;
    public long H;
    public long I;
    public w J;
    public boolean K;
    public boolean L;
    public long M;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f2001v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b2.h f2002w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g0 f2003x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b2.h f2004y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f2005z = false;

    public e(v vVar, b2.h hVar, b2.h hVar2, d dVar, int i) {
        this.f2001v = vVar;
        this.f2002w = hVar2;
        this.A = (i & 2) != 0;
        this.B = false;
        if (hVar != null) {
            this.f2004y = hVar;
            this.f2003x = dVar != null ? new g0(hVar, dVar) : null;
        } else {
            this.f2004y = c0.f1680v;
            this.f2003x = null;
        }
    }

    @Override // b2.h
    public final long B(b2.o oVar) {
        long j4;
        b bVar = this.f2001v;
        try {
            String string = oVar.f1720h;
            long j7 = oVar.f;
            long j10 = oVar.f1719g;
            if (string == null) {
                string = oVar.f1714a.toString();
            }
            b2.n nVarA = oVar.a();
            nVarA.f1713h = string;
            b2.o oVarA = nVarA.a();
            this.D = oVarA;
            Uri uri = oVarA.f1714a;
            byte[] bArr = (byte[]) ((v) bVar).g(string).f2042b.get("exo_redir");
            Uri uri2 = null;
            String str = bArr != null ? new String(bArr, StandardCharsets.UTF_8) : null;
            if (str != null) {
                uri2 = Uri.parse(str);
            }
            if (uri2 != null) {
                uri = uri2;
            }
            this.C = uri;
            this.H = j7;
            boolean z10 = (this.A && this.K) || (this.B && j10 == -1);
            this.L = z10;
            if (z10) {
                this.I = -1L;
                j4 = -1;
            } else {
                j4 = -1;
                long jE = q4.a.e(((v) bVar).g(string));
                this.I = jE;
                if (jE != -1) {
                    long j11 = jE - j7;
                    this.I = j11;
                    if (j11 < 0) {
                        throw new b2.l(2008);
                    }
                }
            }
            if (j10 != j4) {
                long j12 = this.I;
                this.I = j12 == j4 ? j10 : Math.min(j12, j10);
            }
            long j13 = this.I;
            if (j13 > 0 || j13 == j4) {
                c(oVarA, false);
            }
            return j10 != j4 ? j10 : this.I;
        } catch (Throwable th) {
            if (this.F == this.f2002w || (th instanceof a)) {
                this.K = true;
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        b bVar = this.f2001v;
        b2.h hVar = this.F;
        if (hVar == null) {
            return;
        }
        try {
            hVar.close();
        } finally {
            this.E = null;
            this.F = null;
            w wVar = this.J;
            if (wVar != null) {
                ((v) bVar).j(wVar);
                this.J = null;
            }
        }
    }

    public final void c(b2.o oVar, boolean z10) throws InterruptedIOException {
        w wVarM;
        b2.o oVarA;
        b2.h hVar;
        String str = oVar.f1720h;
        int i = a0.f14551a;
        if (this.L) {
            wVarM = null;
        } else if (this.f2005z) {
            try {
                b bVar = this.f2001v;
                long j4 = this.H;
                long j7 = this.I;
                v vVar = (v) bVar;
                synchronized (vVar) {
                    vVar.d();
                    while (true) {
                        wVarM = vVar.m(j4, j7, str);
                        if (wVarM != null) {
                            break;
                        } else {
                            vVar.wait();
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            wVarM = ((v) this.f2001v).m(this.H, this.I, str);
        }
        if (wVarM == null) {
            hVar = this.f2004y;
            b2.n nVarA = oVar.a();
            nVarA.f = this.H;
            nVarA.f1712g = this.I;
            oVarA = nVarA.a();
        } else if (wVarM.f2015y) {
            Uri uriFromFile = Uri.fromFile(wVarM.f2016z);
            long j10 = wVarM.f2013w;
            long j11 = this.H - j10;
            long jMin = wVarM.f2014x - j11;
            long j12 = this.I;
            if (j12 != -1) {
                jMin = Math.min(jMin, j12);
            }
            b2.n nVarA2 = oVar.a();
            nVarA2.f1707a = uriFromFile;
            nVarA2.f1708b = j10;
            nVarA2.f = j11;
            nVarA2.f1712g = jMin;
            oVarA = nVarA2.a();
            hVar = this.f2002w;
        } else {
            long jMin2 = wVarM.f2014x;
            if (jMin2 == -1) {
                jMin2 = this.I;
            } else {
                long j13 = this.I;
                if (j13 != -1) {
                    jMin2 = Math.min(jMin2, j13);
                }
            }
            b2.n nVarA3 = oVar.a();
            nVarA3.f = this.H;
            nVarA3.f1712g = jMin2;
            oVarA = nVarA3.a();
            hVar = this.f2003x;
            if (hVar == null) {
                hVar = this.f2004y;
                ((v) this.f2001v).j(wVarM);
                wVarM = null;
            }
        }
        this.M = (this.L || hVar != this.f2004y) ? Long.MAX_VALUE : this.H + 102400;
        if (z10) {
            y1.d.g(this.F == this.f2004y);
            if (hVar == this.f2004y) {
                return;
            }
            try {
                b();
            } catch (Throwable th) {
                if (!wVarM.f2015y) {
                    ((v) this.f2001v).j(wVarM);
                }
                throw th;
            }
        }
        if (wVarM != null && !wVarM.f2015y) {
            this.J = wVarM;
        }
        this.F = hVar;
        this.E = oVarA;
        this.G = 0L;
        long jB = hVar.B(oVarA);
        g gVar = new g();
        if (oVarA.f1719g == -1 && jB != -1) {
            this.I = jB;
            gVar.a(Long.valueOf(this.H + jB), "exo_len");
        }
        if (!(this.F == this.f2002w)) {
            Uri uriT = hVar.t();
            this.C = uriT;
            Uri uri = oVar.f1714a.equals(uriT) ? null : this.C;
            if (uri == null) {
                ((ArrayList) gVar.f2010b).add("exo_redir");
                ((HashMap) gVar.f2009a).remove("exo_redir");
            } else {
                gVar.a(uri.toString(), "exo_redir");
            }
        }
        if (this.F == this.f2003x) {
            ((v) this.f2001v).c(str, gVar);
        }
    }

    @Override // b2.h
    public final void close() {
        this.D = null;
        this.C = null;
        this.H = 0L;
        try {
            b();
        } catch (Throwable th) {
            if (this.F == this.f2002w || (th instanceof a)) {
                this.K = true;
            }
            throw th;
        }
    }

    @Override // b2.h
    public final void d(h0 h0Var) {
        h0Var.getClass();
        this.f2002w.d(h0Var);
        this.f2004y.d(h0Var);
    }

    @Override // b2.h
    public final Map j() {
        return !(this.F == this.f2002w) ? this.f2004y.j() : Collections.EMPTY_MAP;
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) {
        int i11;
        long j4;
        b2.h hVar = this.f2002w;
        if (i10 == 0) {
            return 0;
        }
        if (this.I == 0) {
            return -1;
        }
        b2.o oVar = this.D;
        oVar.getClass();
        b2.o oVar2 = this.E;
        oVar2.getClass();
        try {
            if (this.H >= this.M) {
                c(oVar, true);
            }
            b2.h hVar2 = this.F;
            hVar2.getClass();
            int i12 = hVar2.read(bArr, i, i10);
            if (i12 != -1) {
                long j7 = i12;
                this.H += j7;
                this.G += j7;
                long j10 = this.I;
                if (j10 == -1) {
                    return i12;
                }
                this.I = j10 - j7;
                return i12;
            }
            b2.h hVar3 = this.F;
            if (!(hVar3 == hVar)) {
                j4 = -1;
                long j11 = oVar2.f1719g;
                if (j11 != -1) {
                    i11 = i12;
                    if (this.G < j11) {
                    }
                } else {
                    i11 = i12;
                }
                String str = oVar.f1720h;
                int i13 = a0.f14551a;
                this.I = 0L;
                if (!(hVar3 == this.f2003x)) {
                    return i11;
                }
                g gVar = new g();
                gVar.a(Long.valueOf(this.H), "exo_len");
                ((v) this.f2001v).c(str, gVar);
                return i11;
            }
            i11 = i12;
            j4 = -1;
            long j12 = this.I;
            if (j12 <= 0 && j12 != j4) {
                return i11;
            }
            b();
            c(oVar, false);
            return read(bArr, i, i10);
        } catch (Throwable th) {
            if (this.F == hVar || (th instanceof a)) {
                this.K = true;
            }
            throw th;
        }
    }

    @Override // b2.h
    public final Uri t() {
        return this.C;
    }
}
