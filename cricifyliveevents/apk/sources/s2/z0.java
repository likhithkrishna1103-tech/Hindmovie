package s2;

import android.util.SparseArray;
import androidx.media3.decoder.DecoderInputBuffer;
import f9.a4;
import java.io.EOFException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class z0 implements a3.i0 {
    public v1.p A;
    public v1.p B;
    public long C;
    public boolean E;
    public long F;
    public boolean G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w0 f11373a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l2.n f11376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l2.k f11377e;
    public Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v1.p f11378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l2.h f11379h;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f11386p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f11387q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f11388r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f11389s;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f11393w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f11396z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o2.f f11374b = new o2.f();
    public int i = 1000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long[] f11380j = new long[1000];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long[] f11381k = new long[1000];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long[] f11384n = new long[1000];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f11383m = new int[1000];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int[] f11382l = new int[1000];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a3.h0[] f11385o = new a3.h0[1000];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f3.a f11375c = new f3.a(new nc.l(20));

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f11390t = Long.MIN_VALUE;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f11391u = Long.MIN_VALUE;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f11392v = Long.MIN_VALUE;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f11395y = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f11394x = true;
    public boolean D = true;

    public z0(w2.e eVar, l2.n nVar, l2.k kVar) {
        this.f11376d = nVar;
        this.f11377e = kVar;
        this.f11373a = new w0(eVar);
    }

    public final void A(v1.p pVar, l4.c0 c0Var) {
        v1.p pVar2;
        v1.p pVar3 = this.f11378g;
        boolean z10 = pVar3 == null;
        v1.l lVar = pVar3 == null ? null : pVar3.f12950r;
        this.f11378g = pVar;
        v1.l lVar2 = pVar.f12950r;
        l2.n nVar = this.f11376d;
        if (nVar != null) {
            int iH = nVar.h(pVar);
            v1.o oVarA = pVar.a();
            oVarA.N = iH;
            pVar2 = new v1.p(oVarA);
        } else {
            pVar2 = pVar;
        }
        c0Var.f7706x = pVar2;
        c0Var.f7705w = this.f11379h;
        if (nVar == null) {
            return;
        }
        if (z10 || !Objects.equals(lVar, lVar2)) {
            l2.h hVar = this.f11379h;
            l2.k kVar = this.f11377e;
            l2.h hVarI = nVar.i(kVar, pVar);
            this.f11379h = hVarI;
            c0Var.f7705w = hVarI;
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
        return this.f11389s != this.f11386p ? this.f11380j[u(this.f11389s)] : this.C;
    }

    public final int C(l4.c0 c0Var, DecoderInputBuffer decoderInputBuffer, int i, boolean z10) {
        int i10;
        boolean z11 = (i & 2) != 0;
        o2.f fVar = this.f11374b;
        synchronized (this) {
            try {
                decoderInputBuffer.waitingForKeys = false;
                i10 = -3;
                if (this.f11389s != this.f11386p) {
                    v1.p pVar = ((x0) this.f11375c.k(t())).f11365a;
                    if (!z11 && pVar == this.f11378g) {
                        int iU = u(this.f11389s);
                        if (y(iU)) {
                            decoderInputBuffer.setFlags(this.f11383m[iU]);
                            if (this.f11389s == this.f11386p - 1 && (z10 || this.f11393w)) {
                                decoderInputBuffer.addFlag(536870912);
                            }
                            decoderInputBuffer.timeUs = this.f11384n[iU];
                            fVar.f9431a = this.f11382l[iU];
                            fVar.f9432b = this.f11381k[iU];
                            fVar.f9433c = this.f11385o[iU];
                            i10 = -4;
                        } else {
                            decoderInputBuffer.waitingForKeys = true;
                        }
                    }
                    A(pVar, c0Var);
                    i10 = -5;
                } else {
                    if (!z10 && !this.f11393w) {
                        v1.p pVar2 = this.B;
                        if (pVar2 == null || (!z11 && pVar2 == this.f11378g)) {
                        }
                        A(pVar2, c0Var);
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
            boolean z12 = (i & 1) != 0;
            if ((i & 4) == 0) {
                if (z12) {
                    w0 w0Var = this.f11373a;
                    w0.f(w0Var.f11355e, decoderInputBuffer, this.f11374b, w0Var.f11353c);
                } else {
                    w0 w0Var2 = this.f11373a;
                    w0Var2.f11355e = w0.f(w0Var2.f11355e, decoderInputBuffer, this.f11374b, w0Var2.f11353c);
                }
            }
            if (!z12) {
                this.f11389s++;
            }
        }
        return i10;
    }

    public final void D(boolean z10) {
        w0 w0Var = this.f11373a;
        w0Var.a(w0Var.f11354d);
        a4 a4Var = w0Var.f11354d;
        int i = w0Var.f11352b;
        y1.d.g(((w2.a) a4Var.f4010x) == null);
        a4Var.f4008v = 0L;
        a4Var.f4009w = i;
        a4 a4Var2 = w0Var.f11354d;
        w0Var.f11355e = a4Var2;
        w0Var.f = a4Var2;
        w0Var.f11356g = 0L;
        w0Var.f11351a.c();
        this.f11386p = 0;
        this.f11387q = 0;
        this.f11388r = 0;
        this.f11389s = 0;
        this.f11394x = true;
        this.f11390t = Long.MIN_VALUE;
        this.f11391u = Long.MIN_VALUE;
        this.f11392v = Long.MIN_VALUE;
        this.f11393w = false;
        f3.a aVar = this.f11375c;
        SparseArray sparseArray = (SparseArray) aVar.f3936x;
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            ((nc.l) aVar.f3937y).accept(sparseArray.valueAt(i10));
        }
        aVar.f3935w = -1;
        sparseArray.clear();
        if (z10) {
            this.A = null;
            this.B = null;
            this.f11395y = true;
            this.D = true;
        }
    }

    public final synchronized void E() {
        this.f11389s = 0;
        w0 w0Var = this.f11373a;
        w0Var.f11355e = w0Var.f11354d;
    }

    public final synchronized boolean F(int i) {
        E();
        int i10 = this.f11387q;
        if (i >= i10 && i <= this.f11386p + i10) {
            this.f11390t = Long.MIN_VALUE;
            this.f11389s = i - i10;
            return true;
        }
        return false;
    }

    public final synchronized boolean G(boolean z10, long j4) {
        Throwable th;
        z0 z0Var;
        long j7;
        int iO;
        try {
            try {
                E();
                int iU = u(this.f11389s);
                int i = this.f11389s;
                int i10 = this.f11386p;
                if (!(i != i10) || j4 < this.f11384n[iU] || (j4 > this.f11392v && !z10)) {
                    return false;
                }
                if (this.D) {
                    int i11 = i10 - i;
                    int i12 = 0;
                    while (true) {
                        if (i12 < i11) {
                            try {
                                if (this.f11384n[iU] >= j4) {
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
                        } else if (!z10) {
                            i11 = -1;
                        }
                    }
                    j7 = j4;
                    iO = i11;
                    z0Var = this;
                } else {
                    int i13 = i10 - i;
                    z0Var = this;
                    j7 = j4;
                    iO = z0Var.o(iU, i13, j7, true);
                }
                if (iO == -1) {
                    return false;
                }
                z0Var.f11390t = j7;
                z0Var.f11389s += iO;
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
            int r0 = r2.f11389s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            int r1 = r2.f11386p     // Catch: java.lang.Throwable -> Lc
            if (r0 > r1) goto Le
            r0 = 1
            goto Lf
        Lc:
            r3 = move-exception
            goto L19
        Le:
            r0 = 0
        Lf:
            y1.d.b(r0)     // Catch: java.lang.Throwable -> Lc
            int r0 = r2.f11389s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            r2.f11389s = r0     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r2)
            return
        L19:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.z0.H(int):void");
    }

    @Override // a3.i0
    public final /* synthetic */ void a(int i, y1.t tVar) {
        q4.a.a(this, tVar, i);
    }

    @Override // a3.i0
    public final int b(v1.h hVar, int i, boolean z10) {
        return d(hVar, i, z10);
    }

    @Override // a3.i0
    public final void c(y1.t tVar, int i, int i10) {
        while (true) {
            w0 w0Var = this.f11373a;
            if (i <= 0) {
                w0Var.getClass();
                return;
            }
            int iC = w0Var.c(i);
            a4 a4Var = w0Var.f;
            w2.a aVar = (w2.a) a4Var.f4010x;
            tVar.h(aVar.f13836a, ((int) (w0Var.f11356g - a4Var.f4008v)) + aVar.f13837b, iC);
            i -= iC;
            long j4 = w0Var.f11356g + ((long) iC);
            w0Var.f11356g = j4;
            a4 a4Var2 = w0Var.f;
            if (j4 == a4Var2.f4009w) {
                w0Var.f = (a4) a4Var2.f4011y;
            }
        }
    }

    @Override // a3.i0
    public final int d(v1.h hVar, int i, boolean z10) throws EOFException {
        w0 w0Var = this.f11373a;
        int iC = w0Var.c(i);
        a4 a4Var = w0Var.f;
        w2.a aVar = (w2.a) a4Var.f4010x;
        int i10 = hVar.read(aVar.f13836a, ((int) (w0Var.f11356g - a4Var.f4008v)) + aVar.f13837b, iC);
        if (i10 == -1) {
            if (z10) {
                return -1;
            }
            throw new EOFException();
        }
        long j4 = w0Var.f11356g + ((long) i10);
        w0Var.f11356g = j4;
        a4 a4Var2 = w0Var.f;
        if (j4 == a4Var2.f4009w) {
            w0Var.f = (a4) a4Var2.f4011y;
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    @Override // a3.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(long r13, int r15, int r16, int r17, a3.h0 r18) {
        /*
            r12 = this;
            boolean r0 = r12.f11396z
            if (r0 == 0) goto Lc
            v1.p r0 = r12.A
            y1.d.h(r0)
            r12.f(r0)
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
            boolean r5 = r12.f11394x
            if (r5 == 0) goto L1f
            if (r4 != 0) goto L1d
            goto L83
        L1d:
            r12.f11394x = r2
        L1f:
            long r5 = r12.F
            long r5 = r5 + r13
            boolean r7 = r12.D
            if (r7 == 0) goto L4d
            long r7 = r12.f11390t
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
            v1.p r8 = r12.B
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            y1.b.p(r0, r7)
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
            int r4 = r12.f11386p     // Catch: java.lang.Throwable -> L63
            if (r4 != 0) goto L65
            long r7 = r12.f11391u     // Catch: java.lang.Throwable -> L63
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
            int r7 = r12.f11387q     // Catch: java.lang.Throwable -> L63
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
            s2.w0 r2 = r12.f11373a
            long r2 = r2.f11356g
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
        throw new UnsupportedOperationException("Method not decompiled: s2.z0.e(long, int, int, int, a3.h0):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059 A[Catch: all -> 0x0057, TryCatch #0 {all -> 0x0057, blocks: (B:4:0x000a, B:8:0x0016, B:13:0x0028, B:15:0x0041, B:19:0x005b, B:18:0x0059), top: B:29:0x000a }] */
    /* JADX WARN: Type inference failed for: r5v26, types: [java.lang.Object, s2.y0] */
    @Override // a3.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(v1.p r5) {
        /*
            r4 = this;
            v1.p r0 = r4.p(r5)
            r1 = 0
            r4.f11396z = r1
            r4.A = r5
            monitor-enter(r4)
            r4.f11395y = r1     // Catch: java.lang.Throwable -> L57
            v1.p r5 = r4.B     // Catch: java.lang.Throwable -> L57
            boolean r5 = java.util.Objects.equals(r0, r5)     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L16
            monitor-exit(r4)
            goto L6e
        L16:
            f3.a r5 = r4.f11375c     // Catch: java.lang.Throwable -> L57
            java.lang.Object r5 = r5.f3936x     // Catch: java.lang.Throwable -> L57
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
            f3.a r5 = r4.f11375c     // Catch: java.lang.Throwable -> L57
            java.lang.Object r5 = r5.f3936x     // Catch: java.lang.Throwable -> L57
            android.util.SparseArray r5 = (android.util.SparseArray) r5     // Catch: java.lang.Throwable -> L57
            int r3 = r5.size()     // Catch: java.lang.Throwable -> L57
            int r3 = r3 - r2
            java.lang.Object r5 = r5.valueAt(r3)     // Catch: java.lang.Throwable -> L57
            s2.x0 r5 = (s2.x0) r5     // Catch: java.lang.Throwable -> L57
            v1.p r5 = r5.f11365a     // Catch: java.lang.Throwable -> L57
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L59
            f3.a r5 = r4.f11375c     // Catch: java.lang.Throwable -> L57
            java.lang.Object r5 = r5.f3936x     // Catch: java.lang.Throwable -> L57
            android.util.SparseArray r5 = (android.util.SparseArray) r5     // Catch: java.lang.Throwable -> L57
            int r0 = r5.size()     // Catch: java.lang.Throwable -> L57
            int r0 = r0 - r2
            java.lang.Object r5 = r5.valueAt(r0)     // Catch: java.lang.Throwable -> L57
            s2.x0 r5 = (s2.x0) r5     // Catch: java.lang.Throwable -> L57
            v1.p r5 = r5.f11365a     // Catch: java.lang.Throwable -> L57
            r4.B = r5     // Catch: java.lang.Throwable -> L57
            goto L5b
        L57:
            r5 = move-exception
            goto L78
        L59:
            r4.B = r0     // Catch: java.lang.Throwable -> L57
        L5b:
            boolean r5 = r4.D     // Catch: java.lang.Throwable -> L57
            v1.p r0 = r4.B     // Catch: java.lang.Throwable -> L57
            java.lang.String r3 = r0.f12946n     // Catch: java.lang.Throwable -> L57
            java.lang.String r0 = r0.f12943k     // Catch: java.lang.Throwable -> L57
            boolean r0 = v1.m0.a(r3, r0)     // Catch: java.lang.Throwable -> L57
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
        throw new UnsupportedOperationException("Method not decompiled: s2.z0.f(v1.p):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0082 A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:3:0x0001, B:5:0x0007, B:9:0x001d, B:12:0x0024, B:16:0x002c, B:21:0x0067, B:44:0x00e3, B:46:0x00ec, B:23:0x0082, B:25:0x008b, B:27:0x0094, B:29:0x00a9, B:33:0x00b2, B:34:0x00b7, B:36:0x00bd, B:40:0x00cb, B:42:0x00d0, B:43:0x00e0, B:26:0x0092), top: B:51:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void g(long r9, int r11, long r12, int r14, a3.h0 r15) {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.z0.g(long, int, long, int, a3.h0):void");
    }

    public final int h(long j4) {
        int i = this.f11386p;
        int iU = u(i - 1);
        while (i > this.f11389s && this.f11384n[iU] >= j4) {
            i--;
            iU--;
            if (iU == -1) {
                iU = this.i - 1;
            }
        }
        return i;
    }

    public final long i(int i) {
        this.f11391u = Math.max(this.f11391u, s(i));
        this.f11386p -= i;
        int i10 = this.f11387q + i;
        this.f11387q = i10;
        int i11 = this.f11388r + i;
        this.f11388r = i11;
        int i12 = this.i;
        if (i11 >= i12) {
            this.f11388r = i11 - i12;
        }
        int i13 = this.f11389s - i;
        this.f11389s = i13;
        int i14 = 0;
        if (i13 < 0) {
            this.f11389s = 0;
        }
        f3.a aVar = this.f11375c;
        SparseArray sparseArray = (SparseArray) aVar.f3936x;
        while (i14 < sparseArray.size() - 1) {
            int i15 = i14 + 1;
            if (i10 < sparseArray.keyAt(i15)) {
                break;
            }
            ((nc.l) aVar.f3937y).accept(sparseArray.valueAt(i14));
            sparseArray.removeAt(i14);
            int i16 = aVar.f3935w;
            if (i16 > 0) {
                aVar.f3935w = i16 - 1;
            }
            i14 = i15;
        }
        if (this.f11386p != 0) {
            return this.f11381k[this.f11388r];
        }
        int i17 = this.f11388r;
        if (i17 == 0) {
            i17 = this.i;
        }
        int i18 = i17 - 1;
        return this.f11381k[i18] + ((long) this.f11382l[i18]);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(long r12, boolean r14, boolean r15) throws java.lang.Throwable {
        /*
            r11 = this;
            s2.w0 r0 = r11.f11373a
            monitor-enter(r11)
            int r1 = r11.f11386p     // Catch: java.lang.Throwable -> L38
            r2 = -1
            if (r1 == 0) goto L13
            long[] r4 = r11.f11384n     // Catch: java.lang.Throwable -> L38
            int r6 = r11.f11388r     // Catch: java.lang.Throwable -> L38
            r7 = r4[r6]     // Catch: java.lang.Throwable -> L38
            int r4 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r4 >= 0) goto L15
        L13:
            r5 = r11
            goto L3b
        L15:
            if (r15 == 0) goto L1d
            int r15 = r11.f11389s     // Catch: java.lang.Throwable -> L22
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
        throw new UnsupportedOperationException("Method not decompiled: s2.z0.j(long, boolean, boolean):void");
    }

    public final void k() {
        long jI;
        w0 w0Var = this.f11373a;
        synchronized (this) {
            int i = this.f11386p;
            jI = i == 0 ? -1L : i(i);
        }
        w0Var.b(jI);
    }

    public final void l(long j4) {
        if (this.f11386p == 0) {
            return;
        }
        y1.d.b(j4 > r());
        n(this.f11387q + h(j4));
    }

    public final long m(int i) {
        int i10 = this.f11387q;
        int i11 = this.f11386p;
        int i12 = (i10 + i11) - i;
        boolean z10 = false;
        y1.d.b(i12 >= 0 && i12 <= i11 - this.f11389s);
        int i13 = this.f11386p - i12;
        this.f11386p = i13;
        this.f11392v = Math.max(this.f11391u, s(i13));
        if (i12 == 0 && this.f11393w) {
            z10 = true;
        }
        this.f11393w = z10;
        f3.a aVar = this.f11375c;
        SparseArray sparseArray = (SparseArray) aVar.f3936x;
        for (int size = sparseArray.size() - 1; size >= 0 && i < sparseArray.keyAt(size); size--) {
            ((nc.l) aVar.f3937y).accept(sparseArray.valueAt(size));
            sparseArray.removeAt(size);
        }
        aVar.f3935w = sparseArray.size() > 0 ? Math.min(aVar.f3935w, sparseArray.size() - 1) : -1;
        int i14 = this.f11386p;
        if (i14 == 0) {
            return 0L;
        }
        int iU = u(i14 - 1);
        return this.f11381k[iU] + ((long) this.f11382l[iU]);
    }

    public final void n(int i) {
        long jM = m(i);
        w0 w0Var = this.f11373a;
        int i10 = w0Var.f11352b;
        y1.d.b(jM <= w0Var.f11356g);
        w0Var.f11356g = jM;
        if (jM != 0) {
            a4 a4Var = w0Var.f11354d;
            if (jM != a4Var.f4008v) {
                while (w0Var.f11356g > a4Var.f4009w) {
                    a4Var = (a4) a4Var.f4011y;
                }
                a4 a4Var2 = (a4) a4Var.f4011y;
                a4Var2.getClass();
                w0Var.a(a4Var2);
                a4 a4Var3 = new a4(i10, a4Var.f4009w);
                a4Var.f4011y = a4Var3;
                if (w0Var.f11356g == a4Var.f4009w) {
                    a4Var = a4Var3;
                }
                w0Var.f = a4Var;
                if (w0Var.f11355e == a4Var2) {
                    w0Var.f11355e = a4Var3;
                    return;
                }
                return;
            }
        }
        w0Var.a(w0Var.f11354d);
        a4 a4Var4 = new a4(i10, w0Var.f11356g);
        w0Var.f11354d = a4Var4;
        w0Var.f11355e = a4Var4;
        w0Var.f = a4Var4;
    }

    public final int o(int i, int i10, long j4, boolean z10) {
        int i11 = -1;
        for (int i12 = 0; i12 < i10; i12++) {
            long j7 = this.f11384n[i];
            if (j7 > j4) {
                break;
            }
            if (!z10 || (this.f11383m[i] & 1) != 0) {
                if (j7 == j4) {
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

    public v1.p p(v1.p pVar) {
        if (this.F == 0 || pVar.f12951s == Long.MAX_VALUE) {
            return pVar;
        }
        v1.o oVarA = pVar.a();
        oVarA.f12898r = pVar.f12951s + this.F;
        return new v1.p(oVarA);
    }

    public final synchronized long q() {
        return this.f11392v;
    }

    public final synchronized long r() {
        return Math.max(this.f11391u, s(this.f11389s));
    }

    public final long s(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iU = u(i - 1);
        for (int i10 = 0; i10 < i; i10++) {
            jMax = Math.max(jMax, this.f11384n[iU]);
            if ((this.f11383m[iU] & 1) != 0) {
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
        return this.f11387q + this.f11389s;
    }

    public final int u(int i) {
        int i10 = this.f11388r + i;
        int i11 = this.i;
        return i10 < i11 ? i10 : i10 - i11;
    }

    public final synchronized int v(boolean z10, long j4) {
        try {
            try {
                int iU = u(this.f11389s);
                int i = this.f11389s;
                int i10 = this.f11386p;
                if (!(i != i10) || j4 < this.f11384n[iU]) {
                    return 0;
                }
                if (j4 > this.f11392v && z10) {
                    return i10 - i;
                }
                int iO = o(iU, i10 - i, j4, true);
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

    public final synchronized v1.p w() {
        return this.f11395y ? null : this.B;
    }

    public final synchronized boolean x(boolean z10) {
        v1.p pVar;
        boolean z11 = false;
        if (this.f11389s != this.f11386p) {
            if (((x0) this.f11375c.k(t())).f11365a != this.f11378g) {
                return true;
            }
            return y(u(this.f11389s));
        }
        if (z10 || this.f11393w || ((pVar = this.B) != null && pVar != this.f11378g)) {
            z11 = true;
        }
        return z11;
    }

    public final boolean y(int i) {
        l2.h hVar = this.f11379h;
        if (hVar == null || hVar.getState() == 4) {
            return true;
        }
        return (this.f11383m[i] & 1073741824) == 0 && this.f11379h.a();
    }

    public final void z() {
        l2.h hVar = this.f11379h;
        if (hVar == null || hVar.getState() != 1) {
            return;
        }
        l2.g gVarF = this.f11379h.f();
        gVarF.getClass();
        throw gVarF;
    }
}
