package w1;

import android.net.Uri;
import java.io.InterruptedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import s1.b0;
import v1.d0;
import v1.e0;
import v1.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements v1.h {
    public final boolean A;
    public Uri B;
    public v1.m C;
    public v1.m D;
    public v1.h E;
    public long F;
    public long G;
    public long H;
    public v I;
    public boolean J;
    public boolean K;
    public long L;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f13515u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v1.h f13516v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final d0 f13517w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final v1.h f13518x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f13519y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f13520z;

    public e(u uVar, v1.h hVar, v1.h hVar2, d dVar, int i) {
        this.f13515u = uVar;
        this.f13516v = hVar2;
        this.f13520z = (i & 2) != 0;
        this.A = false;
        if (hVar != null) {
            this.f13518x = hVar;
            this.f13517w = dVar != null ? new d0(hVar, dVar) : null;
        } else {
            this.f13518x = z.f13181u;
            this.f13517w = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        b bVar = this.f13515u;
        v1.h hVar = this.E;
        if (hVar == null) {
            return;
        }
        try {
            hVar.close();
        } finally {
            this.D = null;
            this.E = null;
            v vVar = this.I;
            if (vVar != null) {
                ((u) bVar).j(vVar);
                this.I = null;
            }
        }
    }

    public final void c(v1.m mVar, boolean z2) throws InterruptedIOException {
        v vVarM;
        v1.m mVarA;
        v1.h hVar;
        String str = mVar.f13163h;
        int i = b0.f11647a;
        if (this.K) {
            vVarM = null;
        } else if (this.f13519y) {
            try {
                b bVar = this.f13515u;
                long j5 = this.G;
                long j8 = this.H;
                u uVar = (u) bVar;
                synchronized (uVar) {
                    uVar.d();
                    while (true) {
                        vVarM = uVar.m(j5, j8, str);
                        if (vVarM != null) {
                            break;
                        } else {
                            uVar.wait();
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            vVarM = ((u) this.f13515u).m(this.G, this.H, str);
        }
        if (vVarM == null) {
            hVar = this.f13518x;
            v1.l lVarA = mVar.a();
            lVarA.f = this.G;
            lVarA.f13155g = this.H;
            mVarA = lVarA.a();
        } else if (vVarM.f13530x) {
            Uri uriFromFile = Uri.fromFile(vVarM.f13531y);
            long j10 = vVarM.f13528v;
            long j11 = this.G - j10;
            long jMin = vVarM.f13529w - j11;
            long j12 = this.H;
            if (j12 != -1) {
                jMin = Math.min(jMin, j12);
            }
            v1.l lVarA2 = mVar.a();
            lVarA2.f13150a = uriFromFile;
            lVarA2.f13151b = j10;
            lVarA2.f = j11;
            lVarA2.f13155g = jMin;
            mVarA = lVarA2.a();
            hVar = this.f13516v;
        } else {
            long jMin2 = vVarM.f13529w;
            if (jMin2 == -1) {
                jMin2 = this.H;
            } else {
                long j13 = this.H;
                if (j13 != -1) {
                    jMin2 = Math.min(jMin2, j13);
                }
            }
            v1.l lVarA3 = mVar.a();
            lVarA3.f = this.G;
            lVarA3.f13155g = jMin2;
            mVarA = lVarA3.a();
            hVar = this.f13517w;
            if (hVar == null) {
                hVar = this.f13518x;
                ((u) this.f13515u).j(vVarM);
                vVarM = null;
            }
        }
        this.L = (this.K || hVar != this.f13518x) ? Long.MAX_VALUE : this.G + 102400;
        if (z2) {
            s1.d.g(this.E == this.f13518x);
            if (hVar == this.f13518x) {
                return;
            }
            try {
                b();
            } catch (Throwable th) {
                if (!vVarM.f13530x) {
                    ((u) this.f13515u).j(vVarM);
                }
                throw th;
            }
        }
        if (vVarM != null && !vVarM.f13530x) {
            this.I = vVarM;
        }
        this.E = hVar;
        this.D = mVarA;
        this.F = 0L;
        long jH = hVar.h(mVarA);
        g gVar = new g();
        if (mVarA.f13162g == -1 && jH != -1) {
            this.H = jH;
            gVar.a(Long.valueOf(this.G + jH), "exo_len");
        }
        if (!(this.E == this.f13516v)) {
            Uri uriO = hVar.o();
            this.B = uriO;
            Uri uri = mVar.f13157a.equals(uriO) ? null : this.B;
            if (uri == null) {
                ((ArrayList) gVar.f13525b).add("exo_redir");
                ((HashMap) gVar.f13524a).remove("exo_redir");
            } else {
                gVar.a(uri.toString(), "exo_redir");
            }
        }
        if (this.E == this.f13517w) {
            ((u) this.f13515u).c(str, gVar);
        }
    }

    @Override // v1.h
    public final void close() {
        this.C = null;
        this.B = null;
        this.G = 0L;
        try {
            b();
        } catch (Throwable th) {
            if (this.E == this.f13516v || (th instanceof a)) {
                this.J = true;
            }
            throw th;
        }
    }

    @Override // v1.h
    public final void g(e0 e0Var) {
        e0Var.getClass();
        this.f13516v.g(e0Var);
        this.f13518x.g(e0Var);
    }

    @Override // v1.h
    public final long h(v1.m mVar) {
        long j5;
        b bVar = this.f13515u;
        try {
            String string = mVar.f13163h;
            long j8 = mVar.f;
            long j10 = mVar.f13162g;
            if (string == null) {
                string = mVar.f13157a.toString();
            }
            v1.l lVarA = mVar.a();
            lVarA.f13156h = string;
            v1.m mVarA = lVarA.a();
            this.C = mVarA;
            Uri uri = mVarA.f13157a;
            byte[] bArr = (byte[]) ((u) bVar).g(string).f13552b.get("exo_redir");
            Uri uri2 = null;
            String str = bArr != null ? new String(bArr, StandardCharsets.UTF_8) : null;
            if (str != null) {
                uri2 = Uri.parse(str);
            }
            if (uri2 != null) {
                uri = uri2;
            }
            this.B = uri;
            this.G = j8;
            boolean z2 = (this.f13520z && this.J) || (this.A && j10 == -1);
            this.K = z2;
            if (z2) {
                this.H = -1L;
                j5 = -1;
            } else {
                j5 = -1;
                long jD = e6.j.d(((u) bVar).g(string));
                this.H = jD;
                if (jD != -1) {
                    long j11 = jD - j8;
                    this.H = j11;
                    if (j11 < 0) {
                        throw new v1.j(2008);
                    }
                }
            }
            if (j10 != j5) {
                long j12 = this.H;
                this.H = j12 == j5 ? j10 : Math.min(j12, j10);
            }
            long j13 = this.H;
            if (j13 > 0 || j13 == j5) {
                c(mVarA, false);
            }
            return j10 != j5 ? j10 : this.H;
        } catch (Throwable th) {
            if (this.E == this.f13516v || (th instanceof a)) {
                this.J = true;
            }
            throw th;
        }
    }

    @Override // v1.h
    public final Map k() {
        return !(this.E == this.f13516v) ? this.f13518x.k() : Collections.EMPTY_MAP;
    }

    @Override // v1.h
    public final Uri o() {
        return this.B;
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) {
        int i11;
        long j5;
        v1.h hVar = this.f13516v;
        if (i10 == 0) {
            return 0;
        }
        if (this.H == 0) {
            return -1;
        }
        v1.m mVar = this.C;
        mVar.getClass();
        v1.m mVar2 = this.D;
        mVar2.getClass();
        try {
            if (this.G >= this.L) {
                c(mVar, true);
            }
            v1.h hVar2 = this.E;
            hVar2.getClass();
            int i12 = hVar2.read(bArr, i, i10);
            if (i12 != -1) {
                long j8 = i12;
                this.G += j8;
                this.F += j8;
                long j10 = this.H;
                if (j10 == -1) {
                    return i12;
                }
                this.H = j10 - j8;
                return i12;
            }
            v1.h hVar3 = this.E;
            if (!(hVar3 == hVar)) {
                j5 = -1;
                long j11 = mVar2.f13162g;
                if (j11 != -1) {
                    i11 = i12;
                    if (this.F < j11) {
                    }
                } else {
                    i11 = i12;
                }
                String str = mVar.f13163h;
                int i13 = b0.f11647a;
                this.H = 0L;
                if (!(hVar3 == this.f13517w)) {
                    return i11;
                }
                g gVar = new g();
                gVar.a(Long.valueOf(this.G), "exo_len");
                ((u) this.f13515u).c(str, gVar);
                return i11;
            }
            i11 = i12;
            j5 = -1;
            long j12 = this.H;
            if (j12 <= 0 && j12 != j5) {
                return i11;
            }
            b();
            c(mVar, false);
            return read(bArr, i, i10);
        } catch (Throwable th) {
            if (this.E == hVar || (th instanceof a)) {
                this.J = true;
            }
            throw th;
        }
    }
}
