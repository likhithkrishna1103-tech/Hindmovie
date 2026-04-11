package u3;

import a3.i0;
import android.util.Pair;
import android.util.SparseArray;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.UUID;
import ua.g0;
import ua.z0;
import v1.m0;
import v1.n0;
import y1.a0;
import y1.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements a3.p {
    public static final byte[] O = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final v1.p P;
    public long A;
    public long B;
    public i C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public boolean H;
    public a3.r I;
    public i0[] J;
    public i0[] K;
    public boolean L;
    public boolean M;
    public long N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x3.n f12111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f12113c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f12117h;
    public final y1.t i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final y f12118j;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ff.k f12123o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final i0 f12124p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final p6.c f12125q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public z0 f12126r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f12127s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12128t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f12129u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12130v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public y1.t f12131w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f12132x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12133y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f12134z;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i2.k f12119k = new i2.k(15);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final y1.t f12120l = new y1.t(16);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y1.t f12115e = new y1.t(z1.o.f15122a);
    public final y1.t f = new y1.t(6);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y1.t f12116g = new y1.t();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayDeque f12121m = new ArrayDeque();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayDeque f12122n = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray f12114d = new SparseArray();

    static {
        v1.o oVar = new v1.o();
        oVar.f12893m = m0.p("application/x-emsg");
        P = new v1.p(oVar);
    }

    public j(x3.n nVar, int i, y yVar, List list, j2.n nVar2) {
        this.f12111a = nVar;
        this.f12112b = i;
        this.f12118j = yVar;
        this.f12113c = Collections.unmodifiableList(list);
        this.f12124p = nVar2;
        byte[] bArr = new byte[16];
        this.f12117h = bArr;
        this.i = new y1.t(bArr);
        g0 g0Var = ua.i0.f12341w;
        this.f12126r = z0.f12413z;
        this.A = -9223372036854775807L;
        this.f12134z = -9223372036854775807L;
        this.B = -9223372036854775807L;
        this.I = a3.r.f226a;
        this.J = new i0[0];
        this.K = new i0[0];
        this.f12123o = new ff.k(new g(this));
        this.f12125q = new p6.c(1);
        this.N = -1L;
    }

    public static v1.l d(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            z1.d dVar = (z1.d) list.get(i);
            if (dVar.f3393b == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = dVar.f15069c.f14609a;
                k8.m mVarJ = p.j(bArr);
                UUID uuid = mVarJ == null ? null : (UUID) mVarJ.f7280w;
                if (uuid == null) {
                    y1.b.p("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new v1.k(uuid, null, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new v1.l(null, false, (v1.k[]) arrayList.toArray(new v1.k[0]));
    }

    public static void g(y1.t tVar, int i, s sVar) throws n0 {
        tVar.J(i + 8);
        int iJ = tVar.j();
        byte[] bArr = e.f12091a;
        if ((iJ & 1) != 0) {
            throw n0.c("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z10 = (iJ & 2) != 0;
        int iB = tVar.B();
        if (iB == 0) {
            Arrays.fill(sVar.f12199l, 0, sVar.f12194e, false);
            return;
        }
        int i10 = sVar.f12194e;
        y1.t tVar2 = sVar.f12201n;
        if (iB != i10) {
            StringBuilder sbM = l0.e.m(iB, "Senc sample count ", " is different from fragment sample count");
            sbM.append(sVar.f12194e);
            throw n0.a(null, sbM.toString());
        }
        Arrays.fill(sVar.f12199l, 0, iB, z10);
        tVar2.G(tVar.a());
        sVar.f12198k = true;
        sVar.f12202o = true;
        tVar.h(tVar2.f14609a, 0, tVar2.f14611c);
        tVar2.J(0);
        sVar.f12202o = false;
    }

    public static Pair j(long j4, y1.t tVar) throws n0 {
        long jC;
        long jC2;
        y1.t tVar2 = tVar;
        tVar2.J(8);
        int iE = e.e(tVar2.j());
        tVar2.K(4);
        long jZ = tVar2.z();
        if (iE == 0) {
            jC = tVar2.z();
            jC2 = tVar2.z();
        } else {
            jC = tVar2.C();
            jC2 = tVar2.C();
        }
        long j7 = jC2 + j4;
        int i = a0.f14551a;
        long jW = a0.W(jC, 1000000L, jZ, RoundingMode.DOWN);
        tVar2.K(2);
        int iD = tVar2.D();
        int[] iArr = new int[iD];
        long[] jArr = new long[iD];
        long[] jArr2 = new long[iD];
        long[] jArr3 = new long[iD];
        long j10 = j7;
        long j11 = jW;
        int i10 = 0;
        while (i10 < iD) {
            int iJ = tVar2.j();
            if ((Integer.MIN_VALUE & iJ) != 0) {
                throw n0.a(null, "Unhandled indirect reference");
            }
            long jZ2 = tVar2.z();
            iArr[i10] = iJ & Integer.MAX_VALUE;
            jArr[i10] = j10;
            jArr3[i10] = j11;
            jC += jZ2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            long jW2 = a0.W(jC, 1000000L, jZ, RoundingMode.DOWN);
            jArr4[i10] = jW2 - jArr5[i10];
            tVar2.K(4);
            j10 += (long) iArr[i10];
            i10++;
            iD = iD;
            tVar2 = tVar;
            j11 = jW2;
            jArr2 = jArr4;
            jArr3 = jArr5;
        }
        return Pair.create(Long.valueOf(jW), new a3.k(iArr, jArr, jArr2, jArr3));
    }

    public final void b() {
        this.f12127s = 0;
        this.f12130v = 0;
    }

    @Override // a3.p
    public final void c(a3.r rVar) {
        int i;
        int i10 = this.f12112b;
        if ((i10 & 32) == 0) {
            rVar = new com.bumptech.glide.l(rVar, this.f12111a);
        }
        this.I = rVar;
        b();
        i0[] i0VarArr = new i0[2];
        this.J = i0VarArr;
        int i11 = 0;
        i0 i0Var = this.f12124p;
        if (i0Var != null) {
            i0VarArr[0] = i0Var;
            i = 1;
        } else {
            i = 0;
        }
        int i12 = 100;
        if ((i10 & 4) != 0) {
            i0VarArr[i] = this.I.p(100, 5);
            i12 = 101;
            i++;
        }
        i0[] i0VarArr2 = (i0[]) a0.Q(i, this.J);
        this.J = i0VarArr2;
        for (i0 i0Var2 : i0VarArr2) {
            i0Var2.f(P);
        }
        List list = this.f12113c;
        this.K = new i0[list.size()];
        while (i11 < this.K.length) {
            i0 i0VarP = this.I.p(i12, 3);
            i0VarP.f((v1.p) list.get(i11));
            this.K[i11] = i0VarP;
            i11++;
            i12++;
        }
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        SparseArray sparseArray = this.f12114d;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            ((i) sparseArray.valueAt(i)).e();
        }
        this.f12122n.clear();
        this.f12133y = 0;
        ((PriorityQueue) this.f12123o.f4590e).clear();
        this.f12134z = j7;
        this.f12121m.clear();
        b();
    }

    @Override // a3.p
    public final List f() {
        return this.f12126r;
    }

    @Override // a3.p
    public final boolean h(a3.q qVar) {
        z0 z0VarO;
        a3.g0 g0VarN = p.n(qVar, true, false);
        if (g0VarN != null) {
            z0VarO = ua.i0.o(g0VarN);
        } else {
            g0 g0Var = ua.i0.f12341w;
            z0VarO = z0.f12413z;
        }
        this.f12126r = z0VarO;
        return g0VarN == null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e5, code lost:
    
        if (r32.E >= r32.D) goto L519;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01e7, code lost:
    
        r2 = r32.F;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01e9, code lost:
    
        if (r2 != 0) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01ee, code lost:
    
        if (r32.K.length > 0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f2, code lost:
    
        if (r32.G != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01f4, code lost:
    
        r2 = z1.o.d(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0204, code lost:
    
        if ((r4 + r2) > (r32.D - r32.E)) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0206, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0209, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x020a, code lost:
    
        r33.readFully(r15, r6, r4 + r2);
        r9.J(0);
        r19 = r9.j();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0217, code lost:
    
        if (r19 < 0) goto L520;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0219, code lost:
    
        r32.F = r19 - r2;
        r13 = r32.f12115e;
        r25 = r4;
        r13.J(0);
        r5.a(4, r13);
        r32.E += 4;
        r32.D += r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0236, code lost:
    
        if (r32.K.length <= 0) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0238, code lost:
    
        if (r2 <= 0) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x023a, code lost:
    
        r13 = r15[4];
        r4 = r8.f12946n;
        r20 = r6;
        r6 = r8.f12943k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0246, code lost:
    
        if (java.util.Objects.equals(r4, r12) != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x024c, code lost:
    
        if (v1.m0.c(r6, r12) == null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x024f, code lost:
    
        r26 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0253, code lost:
    
        r26 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0258, code lost:
    
        if ((r13 & 31) == 6) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x025a, code lost:
    
        r12 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0262, code lost:
    
        if (java.util.Objects.equals(r8.f12946n, r12) != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0268, code lost:
    
        if (v1.m0.c(r6, r12) == null) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0272, code lost:
    
        if (((r13 & 126) >> 1) != 39) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0275, code lost:
    
        r12 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0277, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0279, code lost:
    
        r20 = r6;
        r26 = r12;
        r12 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x027f, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0280, code lost:
    
        r32.H = r4;
        r5.a(r2, r9);
        r32.E += r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x028a, code lost:
    
        if (r2 <= 0) goto L522;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x028e, code lost:
    
        if (r32.G != false) goto L523;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0294, code lost:
    
        if (z1.o.c(r15, r2, r8) == false) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0296, code lost:
    
        r32.G = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0299, code lost:
    
        r34 = r12;
        r6 = r20;
        r2 = r22;
        r4 = r25;
        r12 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02ac, code lost:
    
        throw v1.n0.a(null, "Invalid NAL length");
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02ad, code lost:
    
        r25 = r4;
        r20 = r6;
        r26 = r12;
        r12 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02b7, code lost:
    
        if (r32.H == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02b9, code lost:
    
        r4 = r32.f12116g;
        r4.G(r2);
        r33.readFully(r4.f14609a, 0, r32.F);
        r5.a(r32.F, r4);
        r2 = r32.F;
        r2 = z1.o.m(r4.f14611c, r4.f14609a);
        r4.J(0);
        r4.I(r2);
        r2 = r8.f12948p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02e0, code lost:
    
        if (r2 != (-1)) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02e4, code lost:
    
        if (r7.f4586a == 0) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02e6, code lost:
    
        r7.I(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02ec, code lost:
    
        if (r7.f4586a == r2) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02ee, code lost:
    
        r7.I(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02f1, code lost:
    
        r7.a(r10, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02fd, code lost:
    
        if ((r22.a() & 4) == 0) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02ff, code lost:
    
        r7.v(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0302, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0305, code lost:
    
        r2 = r5.b(r33, r2, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x030c, code lost:
    
        r32.E += r2;
        r32.F -= r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0317, code lost:
    
        r22 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0319, code lost:
    
        r2 = r32.E;
        r4 = r32.D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x031d, code lost:
    
        if (r2 >= r4) goto L530;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x031f, code lost:
    
        r32.E += r5.b(r33, r4 - r2, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x032b, code lost:
    
        r1 = r22.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0331, code lost:
    
        if (r32.G != false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0333, code lost:
    
        r1 = r1 | 67108864;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0336, code lost:
    
        r28 = r1;
        r1 = r22.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x033c, code lost:
    
        if (r1 == null) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x033e, code lost:
    
        r31 = r1.f12187c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0343, code lost:
    
        r31 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0345, code lost:
    
        r26 = r10;
        r5.e(r26, r28, r32.D, 0, r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0356, code lost:
    
        if (r3.isEmpty() != false) goto L526;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0358, code lost:
    
        r1 = (u3.h) r3.removeFirst();
        r32.f12133y -= r1.f12099c;
        r4 = r1.f12097a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0369, code lost:
    
        if (r1.f12098b == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x036b, code lost:
    
        r4 = r4 + r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x036d, code lost:
    
        if (r14 == null) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x036f, code lost:
    
        r4 = r14.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0373, code lost:
    
        r7 = r4;
        r2 = r32.J;
        r4 = r2.length;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0378, code lost:
    
        if (r5 >= r4) goto L529;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x037a, code lost:
    
        r2[r5].e(r7, 1, r1.f12099c, r32.f12133y, null);
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x038c, code lost:
    
        if (r22.c() != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x038e, code lost:
    
        r32.C = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0391, code lost:
    
        r32.f12127s = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0396, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ce, code lost:
    
        r5 = r2.f12100a;
        r6 = r2.f12101b;
        r12 = "video/avc";
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00db, code lost:
    
        if (r32.f12127s != 3) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00df, code lost:
    
        if (r2.f12110m != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e1, code lost:
    
        r9 = r2.f12103d.f12208d[r2.f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ea, code lost:
    
        r9 = r6.f12196h[r2.f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f0, code lost:
    
        r32.D = r9;
        r9 = r2.f12103d.f12205a.f12180g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fe, code lost:
    
        if (java.util.Objects.equals(r9.f12946n, "video/avc") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0102, code lost:
    
        if ((r4 & 64) == 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0104, code lost:
    
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0107, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0110, code lost:
    
        if (java.util.Objects.equals(r9.f12946n, "video/hevc") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0114, code lost:
    
        if ((r4 & 128) == 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0117, code lost:
    
        r32.G = !r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x011f, code lost:
    
        if (r2.f >= r2.i) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0121, code lost:
    
        r33.n(r32.D);
        r1 = r2.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x012a, code lost:
    
        if (r1 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x012d, code lost:
    
        r3 = r6.f12201n;
        r1 = r1.f12188d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0131, code lost:
    
        if (r1 == 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0133, code lost:
    
        r3.K(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0136, code lost:
    
        r1 = r2.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x013a, code lost:
    
        if (r6.f12198k == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0140, code lost:
    
        if (r6.f12199l[r1] == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0142, code lost:
    
        r3.K(r3.D() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x014e, code lost:
    
        if (r2.c() != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0150, code lost:
    
        r32.C = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0153, code lost:
    
        r32.f12127s = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0156, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x015f, code lost:
    
        if (r2.f12103d.f12205a.f12181h != r21) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0161, code lost:
    
        r32.D -= 8;
        r33.n(r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x017a, code lost:
    
        if ("audio/ac4".equals(r2.f12103d.f12205a.f12180g.f12946n) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x017c, code lost:
    
        r32.E = r2.d(r32.D, 7);
        a3.b.g(r32.D, r8);
        r5.a(7, r8);
        r32.E += 7;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0195, code lost:
    
        r8 = 0;
        r32.E = r2.d(r32.D, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x019f, code lost:
    
        r32.D += r32.E;
        r32.f12127s = 4;
        r32.F = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01aa, code lost:
    
        r4 = r2.f12103d;
        r8 = r4.f12205a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01b0, code lost:
    
        if (r2.f12110m != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01b2, code lost:
    
        r15 = r4.f[r2.f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01b8, code lost:
    
        r34 = "video/hevc";
        r10 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01bc, code lost:
    
        r15 = r6.i[r2.f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01c3, code lost:
    
        if (r14 == null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01c5, code lost:
    
        r10 = r14.a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c9, code lost:
    
        r4 = r8.f12183k;
        r8 = r8.f12180g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01cd, code lost:
    
        if (r4 == 0) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01cf, code lost:
    
        r9 = r32.f;
        r15 = r9.f14609a;
        r15[0] = 0;
        r15[1] = 0;
        r15[r20] = 0;
        r6 = 4 - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01df, code lost:
    
        r22 = r2;
     */
    @Override // a3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(a3.q r33, a3.t r34) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 2292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.j.i(a3.q, a3.t):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:344:0x07df, code lost:
    
        b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x07e2, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:307:0x06fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(long r54) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 2019
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.j.k(long):void");
    }

    @Override // a3.p
    public final a3.p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
