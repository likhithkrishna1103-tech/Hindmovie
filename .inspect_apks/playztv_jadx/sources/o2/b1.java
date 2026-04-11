package o2;

import android.util.SparseArray;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.EOFException;
import java.util.Objects;
import k8.o3;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class b1 implements w2.h0 {
    public p1.q A;
    public p1.q B;
    public long C;
    public boolean E;
    public long F;
    public boolean G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y0 f9057a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f2.n f9060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f2.k f9061e;
    public Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p1.q f9062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f2.h f9063h;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9070p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f9071q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f9072r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f9073s;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f9077w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f9080z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.c f9058b = new a7.c();
    public int i = 1000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long[] f9064j = new long[1000];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long[] f9065k = new long[1000];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long[] f9068n = new long[1000];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f9067m = new int[1000];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int[] f9066l = new int[1000];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public w2.g0[] f9069o = new w2.g0[1000];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final aa.l0 f9059c = new aa.l0(new ia.b(7));

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f9074t = Long.MIN_VALUE;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f9075u = Long.MIN_VALUE;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f9076v = Long.MIN_VALUE;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f9079y = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f9078x = true;
    public boolean D = true;

    public b1(s2.e eVar, f2.n nVar, f2.k kVar) {
        this.f9060d = nVar;
        this.f9061e = kVar;
        this.f9057a = new y0(eVar);
    }

    public final void A(p1.q qVar, h4.z zVar) {
        p1.q qVar2;
        p1.q qVar3 = this.f9062g;
        boolean z2 = qVar3 == null;
        p1.m mVar = qVar3 == null ? null : qVar3.f10027r;
        this.f9062g = qVar;
        p1.m mVar2 = qVar.f10027r;
        f2.n nVar = this.f9060d;
        if (nVar != null) {
            int iF = nVar.f(qVar);
            p1.p pVarA = qVar.a();
            pVarA.N = iF;
            qVar2 = new p1.q(pVarA);
        } else {
            qVar2 = qVar;
        }
        zVar.f5868w = qVar2;
        zVar.f5867v = this.f9063h;
        if (nVar == null) {
            return;
        }
        if (z2 || !Objects.equals(mVar, mVar2)) {
            f2.h hVar = this.f9063h;
            f2.k kVar = this.f9061e;
            f2.h hVarH = nVar.h(kVar, qVar);
            this.f9063h = hVarH;
            zVar.f5867v = hVarH;
            if (hVar != null) {
                hVar.c(kVar);
            }
        }
    }

    public final synchronized long B() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return this.f9073s != this.f9070p ? this.f9064j[u(this.f9073s)] : this.C;
    }

    public final int C(h4.z zVar, DecoderInputBuffer decoderInputBuffer, int i, boolean z2) {
        int i10;
        boolean z10 = (i & 2) != 0;
        a7.c cVar = this.f9058b;
        synchronized (this) {
            try {
                decoderInputBuffer.waitingForKeys = false;
                i10 = -3;
                if (this.f9073s != this.f9070p) {
                    p1.q qVar = ((z0) this.f9059c.j(t())).f9261a;
                    if (!z10 && qVar == this.f9062g) {
                        int iU = u(this.f9073s);
                        if (y(iU)) {
                            decoderInputBuffer.setFlags(this.f9067m[iU]);
                            if (this.f9073s == this.f9070p - 1 && (z2 || this.f9077w)) {
                                decoderInputBuffer.addFlag(536870912);
                            }
                            decoderInputBuffer.timeUs = this.f9068n[iU];
                            cVar.f621a = this.f9066l[iU];
                            cVar.f622b = this.f9065k[iU];
                            cVar.f623c = this.f9069o[iU];
                            i10 = -4;
                        } else {
                            decoderInputBuffer.waitingForKeys = true;
                        }
                    }
                    A(qVar, zVar);
                    i10 = -5;
                } else {
                    if (!z2 && !this.f9077w) {
                        p1.q qVar2 = this.B;
                        if (qVar2 == null || (!z10 && qVar2 == this.f9062g)) {
                        }
                        A(qVar2, zVar);
                        i10 = -5;
                    }
                    decoderInputBuffer.setFlags(4);
                    decoderInputBuffer.timeUs = Long.MIN_VALUE;
                    i10 = -4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i10 == -4 && !decoderInputBuffer.isEndOfStream()) {
            boolean z11 = (i & 1) != 0;
            if ((i & 4) == 0) {
                if (z11) {
                    y0 y0Var = this.f9057a;
                    y0.f(y0Var.f9253e, decoderInputBuffer, this.f9058b, y0Var.f9251c);
                } else {
                    y0 y0Var2 = this.f9057a;
                    y0Var2.f9253e = y0.f(y0Var2.f9253e, decoderInputBuffer, this.f9058b, y0Var2.f9251c);
                }
            }
            if (!z11) {
                this.f9073s++;
            }
        }
        return i10;
    }

    public final void D(boolean z2) {
        y0 y0Var = this.f9057a;
        y0Var.a(y0Var.f9252d);
        o3 o3Var = y0Var.f9252d;
        int i = y0Var.f9250b;
        s1.d.g(((s2.a) o3Var.f7358w) == null);
        o3Var.f7356u = 0L;
        o3Var.f7357v = i;
        o3 o3Var2 = y0Var.f9252d;
        y0Var.f9253e = o3Var2;
        y0Var.f = o3Var2;
        y0Var.f9254g = 0L;
        y0Var.f9249a.c();
        this.f9070p = 0;
        this.f9071q = 0;
        this.f9072r = 0;
        this.f9073s = 0;
        this.f9078x = true;
        this.f9074t = Long.MIN_VALUE;
        this.f9075u = Long.MIN_VALUE;
        this.f9076v = Long.MIN_VALUE;
        this.f9077w = false;
        aa.l0 l0Var = this.f9059c;
        SparseArray sparseArray = (SparseArray) l0Var.f706w;
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            ((ia.b) l0Var.f707x).accept(sparseArray.valueAt(i10));
        }
        l0Var.f705v = -1;
        sparseArray.clear();
        if (z2) {
            this.A = null;
            this.B = null;
            this.f9079y = true;
            this.D = true;
        }
    }

    public final synchronized void E() {
        this.f9073s = 0;
        y0 y0Var = this.f9057a;
        y0Var.f9253e = y0Var.f9252d;
    }

    public final synchronized boolean F(int i) {
        E();
        int i10 = this.f9071q;
        if (i >= i10 && i <= this.f9070p + i10) {
            this.f9074t = Long.MIN_VALUE;
            this.f9073s = i - i10;
            return true;
        }
        return false;
    }

    public final synchronized boolean G(boolean z2, long j5) {
        Throwable th;
        b1 b1Var;
        long j8;
        int iO;
        try {
            try {
                E();
                int iU = u(this.f9073s);
                int i = this.f9073s;
                int i10 = this.f9070p;
                if (!(i != i10) || j5 < this.f9068n[iU] || (j5 > this.f9076v && !z2)) {
                    return false;
                }
                if (this.D) {
                    int i11 = i10 - i;
                    int i12 = 0;
                    while (true) {
                        if (i12 < i11) {
                            try {
                                if (this.f9068n[iU] >= j5) {
                                    i11 = i12;
                                    break;
                                }
                                iU++;
                                if (iU == this.i) {
                                    iU = 0;
                                }
                                i12++;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } else if (!z2) {
                            i11 = -1;
                        }
                    }
                    j8 = j5;
                    iO = i11;
                    b1Var = this;
                } else {
                    int i13 = i10 - i;
                    b1Var = this;
                    j8 = j5;
                    iO = b1Var.o(iU, i13, j8, true);
                }
                if (iO == -1) {
                    return false;
                }
                b1Var.f9074t = j8;
                b1Var.f9073s += iO;
                return true;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void H(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 < 0) goto Le
            int r0 = r2.f9073s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            int r1 = r2.f9070p     // Catch: java.lang.Throwable -> Lc
            if (r0 > r1) goto Le
            r0 = 1
            goto Lf
        Lc:
            r3 = move-exception
            goto L19
        Le:
            r0 = 0
        Lf:
            s1.d.b(r0)     // Catch: java.lang.Throwable -> Lc
            int r0 = r2.f9073s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            r2.f9073s = r0     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r2)
            return
        L19:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.b1.H(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    @Override // w2.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(long r13, int r15, int r16, int r17, w2.g0 r18) {
        /*
            r12 = this;
            boolean r0 = r12.f9080z
            if (r0 == 0) goto Lc
            p1.q r0 = r12.A
            s1.d.h(r0)
            r12.d(r0)
        Lc:
            r0 = r15 & 1
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L14
            r4 = r3
            goto L15
        L14:
            r4 = r2
        L15:
            boolean r5 = r12.f9078x
            if (r5 == 0) goto L1f
            if (r4 != 0) goto L1d
            goto L83
        L1d:
            r12.f9078x = r2
        L1f:
            long r5 = r12.F
            long r5 = r5 + r13
            boolean r7 = r12.D
            if (r7 == 0) goto L4d
            long r7 = r12.f9074t
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 >= 0) goto L2d
            goto L83
        L2d:
            if (r0 != 0) goto L4d
            boolean r0 = r12.E
            if (r0 != 0) goto L4a
            java.lang.String r0 = "SampleQueue"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Overriding unexpected non-sync sample for format: "
            r7.<init>(r8)
            p1.q r8 = r12.B
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            s1.b.p(r0, r7)
            r12.E = r3
        L4a:
            r0 = r15 | 1
            goto L4e
        L4d:
            r0 = r15
        L4e:
            boolean r7 = r12.G
            if (r7 == 0) goto L84
            if (r4 == 0) goto L83
            monitor-enter(r12)
            int r4 = r12.f9070p     // Catch: java.lang.Throwable -> L63
            if (r4 != 0) goto L65
            long r7 = r12.f9075u     // Catch: java.lang.Throwable -> L63
            int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r4 <= 0) goto L60
            goto L61
        L60:
            r3 = r2
        L61:
            monitor-exit(r12)
            goto L7b
        L63:
            r0 = move-exception
            goto L81
        L65:
            long r7 = r12.r()     // Catch: java.lang.Throwable -> L63
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 < 0) goto L70
            monitor-exit(r12)
            r3 = r2
            goto L7b
        L70:
            int r4 = r12.h(r5)     // Catch: java.lang.Throwable -> L63
            int r7 = r12.f9071q     // Catch: java.lang.Throwable -> L63
            int r7 = r7 + r4
            r12.m(r7)     // Catch: java.lang.Throwable -> L63
            monitor-exit(r12)
        L7b:
            if (r3 != 0) goto L7e
            goto L83
        L7e:
            r12.G = r2
            goto L84
        L81:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L63
            throw r0
        L83:
            return
        L84:
            o2.y0 r2 = r12.f9057a
            long r2 = r2.f9254g
            r7 = r16
            long r8 = (long) r7
            long r2 = r2 - r8
            r4 = r17
            long r8 = (long) r4
            long r2 = r2 - r8
            r10 = r5
            r5 = r2
            r2 = r10
            r1 = r12
            r8 = r18
            r4 = r0
            r1.g(r2, r4, r5, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.b1.a(long, int, int, int, w2.g0):void");
    }

    @Override // w2.h0
    public final void b(s1.u uVar, int i, int i10) {
        while (true) {
            y0 y0Var = this.f9057a;
            if (i <= 0) {
                y0Var.getClass();
                return;
            }
            int iC = y0Var.c(i);
            o3 o3Var = y0Var.f;
            s2.a aVar = (s2.a) o3Var.f7358w;
            uVar.h(aVar.f11723a, ((int) (y0Var.f9254g - o3Var.f7356u)) + aVar.f11724b, iC);
            i -= iC;
            long j5 = y0Var.f9254g + ((long) iC);
            y0Var.f9254g = j5;
            o3 o3Var2 = y0Var.f;
            if (j5 == o3Var2.f7357v) {
                y0Var.f = (o3) o3Var2.f7359x;
            }
        }
    }

    @Override // w2.h0
    public final int c(p1.i iVar, int i, boolean z2) {
        return e(iVar, i, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059 A[Catch: all -> 0x0057, TryCatch #0 {all -> 0x0057, blocks: (B:4:0x000a, B:8:0x0016, B:13:0x0028, B:15:0x0041, B:19:0x005b, B:18:0x0059), top: B:29:0x000a }] */
    /* JADX WARN: Type inference failed for: r5v26, types: [java.lang.Object, o2.a1] */
    @Override // w2.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(p1.q r5) {
        /*
            r4 = this;
            p1.q r0 = r4.p(r5)
            r1 = 0
            r4.f9080z = r1
            r4.A = r5
            monitor-enter(r4)
            r4.f9079y = r1     // Catch: java.lang.Throwable -> L57
            p1.q r5 = r4.B     // Catch: java.lang.Throwable -> L57
            boolean r5 = java.util.Objects.equals(r0, r5)     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L16
            monitor-exit(r4)
            goto L6e
        L16:
            aa.l0 r5 = r4.f9059c     // Catch: java.lang.Throwable -> L57
            java.lang.Object r5 = r5.f706w     // Catch: java.lang.Throwable -> L57
            android.util.SparseArray r5 = (android.util.SparseArray) r5     // Catch: java.lang.Throwable -> L57
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L57
            r2 = 1
            if (r5 != 0) goto L25
            r5 = r2
            goto L26
        L25:
            r5 = r1
        L26:
            if (r5 != 0) goto L59
            aa.l0 r5 = r4.f9059c     // Catch: java.lang.Throwable -> L57
            java.lang.Object r5 = r5.f706w     // Catch: java.lang.Throwable -> L57
            android.util.SparseArray r5 = (android.util.SparseArray) r5     // Catch: java.lang.Throwable -> L57
            int r3 = r5.size()     // Catch: java.lang.Throwable -> L57
            int r3 = r3 - r2
            java.lang.Object r5 = r5.valueAt(r3)     // Catch: java.lang.Throwable -> L57
            o2.z0 r5 = (o2.z0) r5     // Catch: java.lang.Throwable -> L57
            p1.q r5 = r5.f9261a     // Catch: java.lang.Throwable -> L57
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L59
            aa.l0 r5 = r4.f9059c     // Catch: java.lang.Throwable -> L57
            java.lang.Object r5 = r5.f706w     // Catch: java.lang.Throwable -> L57
            android.util.SparseArray r5 = (android.util.SparseArray) r5     // Catch: java.lang.Throwable -> L57
            int r0 = r5.size()     // Catch: java.lang.Throwable -> L57
            int r0 = r0 - r2
            java.lang.Object r5 = r5.valueAt(r0)     // Catch: java.lang.Throwable -> L57
            o2.z0 r5 = (o2.z0) r5     // Catch: java.lang.Throwable -> L57
            p1.q r5 = r5.f9261a     // Catch: java.lang.Throwable -> L57
            r4.B = r5     // Catch: java.lang.Throwable -> L57
            goto L5b
        L57:
            r5 = move-exception
            goto L78
        L59:
            r4.B = r0     // Catch: java.lang.Throwable -> L57
        L5b:
            boolean r5 = r4.D     // Catch: java.lang.Throwable -> L57
            p1.q r0 = r4.B     // Catch: java.lang.Throwable -> L57
            java.lang.String r3 = r0.f10023n     // Catch: java.lang.Throwable -> L57
            java.lang.String r0 = r0.f10020k     // Catch: java.lang.Throwable -> L57
            boolean r0 = p1.m0.a(r3, r0)     // Catch: java.lang.Throwable -> L57
            r5 = r5 & r0
            r4.D = r5     // Catch: java.lang.Throwable -> L57
            r4.E = r1     // Catch: java.lang.Throwable -> L57
            monitor-exit(r4)
            r1 = r2
        L6e:
            java.lang.Object r5 = r4.f
            if (r5 == 0) goto L77
            if (r1 == 0) goto L77
            r5.b()
        L77:
            return
        L78:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L57
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.b1.d(p1.q):void");
    }

    @Override // w2.h0
    public final int e(p1.i iVar, int i, boolean z2) throws EOFException {
        y0 y0Var = this.f9057a;
        int iC = y0Var.c(i);
        o3 o3Var = y0Var.f;
        s2.a aVar = (s2.a) o3Var.f7358w;
        int i10 = iVar.read(aVar.f11723a, ((int) (y0Var.f9254g - o3Var.f7356u)) + aVar.f11724b, iC);
        if (i10 == -1) {
            if (z2) {
                return -1;
            }
            throw new EOFException();
        }
        long j5 = y0Var.f9254g + ((long) i10);
        y0Var.f9254g = j5;
        o3 o3Var2 = y0Var.f;
        if (j5 == o3Var2.f7357v) {
            y0Var.f = (o3) o3Var2.f7359x;
        }
        return i10;
    }

    @Override // w2.h0
    public final /* synthetic */ void f(int i, s1.u uVar) {
        e6.j.b(this, uVar, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0082 A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:3:0x0001, B:5:0x0007, B:9:0x001d, B:12:0x0024, B:16:0x002c, B:21:0x0067, B:44:0x00e3, B:46:0x00ec, B:23:0x0082, B:25:0x008b, B:27:0x0094, B:29:0x00a9, B:33:0x00b2, B:34:0x00b7, B:36:0x00bd, B:40:0x00cb, B:42:0x00d0, B:43:0x00e0, B:26:0x0092), top: B:51:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void g(long r9, int r11, long r12, int r14, w2.g0 r15) {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.b1.g(long, int, long, int, w2.g0):void");
    }

    public final int h(long j5) {
        int i = this.f9070p;
        int iU = u(i - 1);
        while (i > this.f9073s && this.f9068n[iU] >= j5) {
            i--;
            iU--;
            if (iU == -1) {
                iU = this.i - 1;
            }
        }
        return i;
    }

    public final long i(int i) {
        this.f9075u = Math.max(this.f9075u, s(i));
        this.f9070p -= i;
        int i10 = this.f9071q + i;
        this.f9071q = i10;
        int i11 = this.f9072r + i;
        this.f9072r = i11;
        int i12 = this.i;
        if (i11 >= i12) {
            this.f9072r = i11 - i12;
        }
        int i13 = this.f9073s - i;
        this.f9073s = i13;
        int i14 = 0;
        if (i13 < 0) {
            this.f9073s = 0;
        }
        aa.l0 l0Var = this.f9059c;
        SparseArray sparseArray = (SparseArray) l0Var.f706w;
        while (i14 < sparseArray.size() - 1) {
            int i15 = i14 + 1;
            if (i10 < sparseArray.keyAt(i15)) {
                break;
            }
            ((ia.b) l0Var.f707x).accept(sparseArray.valueAt(i14));
            sparseArray.removeAt(i14);
            int i16 = l0Var.f705v;
            if (i16 > 0) {
                l0Var.f705v = i16 - 1;
            }
            i14 = i15;
        }
        if (this.f9070p != 0) {
            return this.f9065k[this.f9072r];
        }
        int i17 = this.f9072r;
        if (i17 == 0) {
            i17 = this.i;
        }
        int i18 = i17 - 1;
        return this.f9065k[i18] + ((long) this.f9066l[i18]);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(long r12, boolean r14, boolean r15) {
        /*
            r11 = this;
            o2.y0 r0 = r11.f9057a
            monitor-enter(r11)
            int r1 = r11.f9070p     // Catch: java.lang.Throwable -> L38
            r2 = -1
            if (r1 == 0) goto L13
            long[] r4 = r11.f9068n     // Catch: java.lang.Throwable -> L38
            int r6 = r11.f9072r     // Catch: java.lang.Throwable -> L38
            r7 = r4[r6]     // Catch: java.lang.Throwable -> L38
            int r4 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r4 >= 0) goto L15
        L13:
            r5 = r11
            goto L3b
        L15:
            if (r15 == 0) goto L1d
            int r15 = r11.f9073s     // Catch: java.lang.Throwable -> L22
            if (r15 == r1) goto L1d
            int r1 = r15 + 1
        L1d:
            r5 = r11
            r8 = r12
            r10 = r14
            r7 = r1
            goto L26
        L22:
            r0 = move-exception
            r12 = r0
            r5 = r11
            goto L40
        L26:
            int r12 = r5.o(r6, r7, r8, r10)     // Catch: java.lang.Throwable -> L35
            r13 = -1
            if (r12 != r13) goto L2f
            monitor-exit(r11)
            goto L3c
        L2f:
            long r2 = r11.i(r12)     // Catch: java.lang.Throwable -> L35
            monitor-exit(r11)
            goto L3c
        L35:
            r0 = move-exception
        L36:
            r12 = r0
            goto L40
        L38:
            r0 = move-exception
            r5 = r11
            goto L36
        L3b:
            monitor-exit(r11)
        L3c:
            r0.b(r2)
            return
        L40:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L35
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.b1.j(long, boolean, boolean):void");
    }

    public final void k() {
        long jI;
        y0 y0Var = this.f9057a;
        synchronized (this) {
            int i = this.f9070p;
            jI = i == 0 ? -1L : i(i);
        }
        y0Var.b(jI);
    }

    public final void l(long j5) {
        if (this.f9070p == 0) {
            return;
        }
        s1.d.b(j5 > r());
        n(this.f9071q + h(j5));
    }

    public final long m(int i) {
        int i10 = this.f9071q;
        int i11 = this.f9070p;
        int i12 = (i10 + i11) - i;
        boolean z2 = false;
        s1.d.b(i12 >= 0 && i12 <= i11 - this.f9073s);
        int i13 = this.f9070p - i12;
        this.f9070p = i13;
        this.f9076v = Math.max(this.f9075u, s(i13));
        if (i12 == 0 && this.f9077w) {
            z2 = true;
        }
        this.f9077w = z2;
        aa.l0 l0Var = this.f9059c;
        SparseArray sparseArray = (SparseArray) l0Var.f706w;
        for (int size = sparseArray.size() - 1; size >= 0 && i < sparseArray.keyAt(size); size--) {
            ((ia.b) l0Var.f707x).accept(sparseArray.valueAt(size));
            sparseArray.removeAt(size);
        }
        l0Var.f705v = sparseArray.size() > 0 ? Math.min(l0Var.f705v, sparseArray.size() - 1) : -1;
        int i14 = this.f9070p;
        if (i14 == 0) {
            return 0L;
        }
        int iU = u(i14 - 1);
        return this.f9065k[iU] + ((long) this.f9066l[iU]);
    }

    public final void n(int i) {
        long jM = m(i);
        y0 y0Var = this.f9057a;
        int i10 = y0Var.f9250b;
        s1.d.b(jM <= y0Var.f9254g);
        y0Var.f9254g = jM;
        if (jM != 0) {
            o3 o3Var = y0Var.f9252d;
            if (jM != o3Var.f7356u) {
                while (y0Var.f9254g > o3Var.f7357v) {
                    o3Var = (o3) o3Var.f7359x;
                }
                o3 o3Var2 = (o3) o3Var.f7359x;
                o3Var2.getClass();
                y0Var.a(o3Var2);
                o3 o3Var3 = new o3(i10, o3Var.f7357v);
                o3Var.f7359x = o3Var3;
                if (y0Var.f9254g == o3Var.f7357v) {
                    o3Var = o3Var3;
                }
                y0Var.f = o3Var;
                if (y0Var.f9253e == o3Var2) {
                    y0Var.f9253e = o3Var3;
                    return;
                }
                return;
            }
        }
        y0Var.a(y0Var.f9252d);
        o3 o3Var4 = new o3(i10, y0Var.f9254g);
        y0Var.f9252d = o3Var4;
        y0Var.f9253e = o3Var4;
        y0Var.f = o3Var4;
    }

    public final int o(int i, int i10, long j5, boolean z2) {
        int i11 = -1;
        for (int i12 = 0; i12 < i10; i12++) {
            long j8 = this.f9068n[i];
            if (j8 > j5) {
                break;
            }
            if (!z2 || (this.f9067m[i] & 1) != 0) {
                if (j8 == j5) {
                    return i12;
                }
                i11 = i12;
            }
            i++;
            if (i == this.i) {
                i = 0;
            }
        }
        return i11;
    }

    public p1.q p(p1.q qVar) {
        if (this.F == 0 || qVar.f10028s == Long.MAX_VALUE) {
            return qVar;
        }
        p1.p pVarA = qVar.a();
        pVarA.f9972r = qVar.f10028s + this.F;
        return new p1.q(pVarA);
    }

    public final synchronized long q() {
        return this.f9076v;
    }

    public final synchronized long r() {
        return Math.max(this.f9075u, s(this.f9073s));
    }

    public final long s(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iU = u(i - 1);
        for (int i10 = 0; i10 < i; i10++) {
            jMax = Math.max(jMax, this.f9068n[iU]);
            if ((this.f9067m[iU] & 1) != 0) {
                return jMax;
            }
            iU--;
            if (iU == -1) {
                iU = this.i - 1;
            }
        }
        return jMax;
    }

    public final int t() {
        return this.f9071q + this.f9073s;
    }

    public final int u(int i) {
        int i10 = this.f9072r + i;
        int i11 = this.i;
        return i10 < i11 ? i10 : i10 - i11;
    }

    public final synchronized int v(boolean z2, long j5) {
        try {
            try {
                int iU = u(this.f9073s);
                int i = this.f9073s;
                int i10 = this.f9070p;
                if (!(i != i10) || j5 < this.f9068n[iU]) {
                    return 0;
                }
                if (j5 > this.f9076v && z2) {
                    return i10 - i;
                }
                int iO = o(iU, i10 - i, j5, true);
                if (iO == -1) {
                    return 0;
                }
                return iO;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    public final synchronized p1.q w() {
        return this.f9079y ? null : this.B;
    }

    public final synchronized boolean x(boolean z2) {
        p1.q qVar;
        boolean z10 = false;
        if (this.f9073s != this.f9070p) {
            if (((z0) this.f9059c.j(t())).f9261a != this.f9062g) {
                return true;
            }
            return y(u(this.f9073s));
        }
        if (z2 || this.f9077w || ((qVar = this.B) != null && qVar != this.f9062g)) {
            z10 = true;
        }
        return z10;
    }

    public final boolean y(int i) {
        f2.h hVar = this.f9063h;
        if (hVar == null || hVar.getState() == 4) {
            return true;
        }
        return (this.f9067m[i] & 1073741824) == 0 && this.f9063h.a();
    }

    public final void z() {
        f2.h hVar = this.f9063h;
        if (hVar == null || hVar.getState() != 1) {
            return;
        }
        f2.g gVarF = this.f9063h.f();
        gVarF.getClass();
        throw gVarF;
    }
}
