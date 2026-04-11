package q3;

import aa.c1;
import aa.j0;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.internal.measurement.k4;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.UUID;
import p1.m0;
import p1.n0;
import s1.b0;
import s1.z;
import w2.f0;
import w2.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements w2.o {
    public static final byte[] P = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final p1.q Q;
    public long A;
    public long B;
    public long C;
    public j D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public boolean I;
    public w2.q J;
    public h0[] K;
    public h0[] L;
    public boolean M;
    public boolean N;
    public long O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t3.k f10636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f10638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f10639d;
    public final byte[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s1.u f10643j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final z f10644k;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final n.p f10649p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final h0 f10650q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final t.b f10651r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public c1 f10652s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10653t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10654u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f10655v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10656w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public s1.u f10657x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f10658y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f10659z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k4 f10645l = new k4(16);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final s1.u f10646m = new s1.u(16);
    public final s1.u f = new s1.u(t1.p.f12057a);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s1.u f10641g = new s1.u(6);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s1.u f10642h = new s1.u();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayDeque f10647n = new ArrayDeque();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayDeque f10648o = new ArrayDeque();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray f10640e = new SparseArray();

    static {
        p1.p pVar = new p1.p();
        pVar.f9967m = m0.p("application/x-emsg");
        Q = new p1.q(pVar);
    }

    public k(t3.k kVar, int i, z zVar, r rVar, List list, d2.n nVar) {
        this.f10636a = kVar;
        this.f10637b = i;
        this.f10644k = zVar;
        this.f10638c = rVar;
        this.f10639d = Collections.unmodifiableList(list);
        this.f10650q = nVar;
        byte[] bArr = new byte[16];
        this.i = bArr;
        this.f10643j = new s1.u(bArr);
        aa.h0 h0Var = j0.f690v;
        this.f10652s = c1.f650y;
        this.B = -9223372036854775807L;
        this.A = -9223372036854775807L;
        this.C = -9223372036854775807L;
        this.J = w2.q.f13663t;
        this.K = new h0[0];
        this.L = new h0[0];
        this.f10649p = new n.p(new h(this));
        this.f10651r = new t.b(1);
        this.O = -1L;
    }

    public static p1.m d(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            t1.d dVar = (t1.d) list.get(i);
            if (dVar.f12004b == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = dVar.f12002c.f11709a;
                p7.m mVarJ = q.j(bArr);
                UUID uuid = mVarJ == null ? null : (UUID) mVarJ.f10284v;
                if (uuid == null) {
                    s1.b.p("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new p1.l(uuid, null, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new p1.m(null, false, (p1.l[]) arrayList.toArray(new p1.l[0]));
    }

    public static void h(s1.u uVar, int i, t tVar) throws n0 {
        uVar.J(i + 8);
        int iJ = uVar.j();
        byte[] bArr = f.f10616a;
        if ((iJ & 1) != 0) {
            throw n0.c("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z2 = (iJ & 2) != 0;
        int iB = uVar.B();
        if (iB == 0) {
            Arrays.fill(tVar.f10724l, 0, tVar.f10719e, false);
            return;
        }
        int i10 = tVar.f10719e;
        s1.u uVar2 = tVar.f10726n;
        if (iB != i10) {
            throw n0.a(null, "Senc sample count " + iB + " is different from fragment sample count" + tVar.f10719e);
        }
        Arrays.fill(tVar.f10724l, 0, iB, z2);
        uVar2.G(uVar.a());
        tVar.f10723k = true;
        tVar.f10727o = true;
        uVar.h(uVar2.f11709a, 0, uVar2.f11711c);
        uVar2.J(0);
        tVar.f10727o = false;
    }

    public static Pair i(long j5, s1.u uVar) throws n0 {
        long jC;
        long jC2;
        s1.u uVar2 = uVar;
        uVar2.J(8);
        int iE = f.e(uVar2.j());
        uVar2.K(4);
        long jZ = uVar2.z();
        if (iE == 0) {
            jC = uVar2.z();
            jC2 = uVar2.z();
        } else {
            jC = uVar2.C();
            jC2 = uVar2.C();
        }
        long j8 = jC2 + j5;
        int i = b0.f11647a;
        long jW = b0.W(jC, 1000000L, jZ, RoundingMode.DOWN);
        uVar2.K(2);
        int iD = uVar2.D();
        int[] iArr = new int[iD];
        long[] jArr = new long[iD];
        long[] jArr2 = new long[iD];
        long[] jArr3 = new long[iD];
        long j10 = j8;
        long j11 = jW;
        int i10 = 0;
        while (i10 < iD) {
            int iJ = uVar2.j();
            if ((Integer.MIN_VALUE & iJ) != 0) {
                throw n0.a(null, "Unhandled indirect reference");
            }
            long jZ2 = uVar2.z();
            iArr[i10] = iJ & Integer.MAX_VALUE;
            jArr[i10] = j10;
            jArr3[i10] = j11;
            jC += jZ2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            long jW2 = b0.W(jC, 1000000L, jZ, RoundingMode.DOWN);
            jArr4[i10] = jW2 - jArr5[i10];
            uVar2.K(4);
            j10 += (long) iArr[i10];
            i10++;
            iD = iD;
            uVar2 = uVar;
            j11 = jW2;
            jArr2 = jArr4;
            jArr3 = jArr5;
        }
        return Pair.create(Long.valueOf(jW), new w2.k(iArr, jArr, jArr2, jArr3));
    }

    public final void b() {
        this.f10653t = 0;
        this.f10656w = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1  */
    @Override // w2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(w2.q r13) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.k.c(w2.q):void");
    }

    @Override // w2.o
    public final boolean e(w2.p pVar) {
        c1 c1VarV;
        f0 f0VarN = q.n(pVar, true, false);
        if (f0VarN != null) {
            c1VarV = j0.v(f0VarN);
        } else {
            aa.h0 h0Var = j0.f690v;
            c1VarV = c1.f650y;
        }
        this.f10652s = c1VarV;
        return f0VarN == null;
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        SparseArray sparseArray = this.f10640e;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            ((j) sparseArray.valueAt(i)).e();
        }
        this.f10648o.clear();
        this.f10659z = 0;
        ((PriorityQueue) this.f10649p.f8479e).clear();
        this.A = j8;
        this.f10647n.clear();
        b();
    }

    @Override // w2.o
    public final List g() {
        return this.f10652s;
    }

    /* JADX WARN: Code restructure failed: missing block: B:361:0x0813, code lost:
    
        b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0816, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0730  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(long r55) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 2071
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.k.j(long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e7, code lost:
    
        if (r32.F >= r32.E) goto L517;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01e9, code lost:
    
        r2 = r32.G;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01eb, code lost:
    
        if (r2 != 0) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01f0, code lost:
    
        if (r32.L.length > 0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f4, code lost:
    
        if (r32.H != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01f6, code lost:
    
        r2 = t1.p.d(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0206, code lost:
    
        if ((r22 + r2) > (r32.E - r32.F)) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0208, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x020b, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x020c, code lost:
    
        r33.readFully(r9, r12, r22 + r2);
        r15.J(0);
        r19 = r15.j();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0219, code lost:
    
        if (r19 < 0) goto L518;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x021b, code lost:
    
        r32.G = r19 - r2;
        r13 = r32.f;
        r25 = r12;
        r13.J(0);
        r8.f(4, r13);
        r32.F += 4;
        r32.E += r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0239, code lost:
    
        if (r32.L.length <= 0) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x023b, code lost:
    
        if (r2 <= 0) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x023d, code lost:
    
        r13 = r9[4];
        r12 = r6.f10023n;
        r13 = r6.f10020k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0249, code lost:
    
        if (java.util.Objects.equals(r12, r11) != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x024f, code lost:
    
        if (p1.m0.c(r13, r11) == null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0252, code lost:
    
        r26 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0256, code lost:
    
        r26 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x025b, code lost:
    
        if ((r13 & 31) == 6) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0263, code lost:
    
        if (java.util.Objects.equals(r6.f10023n, "video/hevc") != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0269, code lost:
    
        if (p1.m0.c(r13, "video/hevc") == null) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0273, code lost:
    
        if (((r13 & 126) >> 1) != 39) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0275, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0277, code lost:
    
        r26 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x027a, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x027b, code lost:
    
        r32.I = r12;
        r8.f(r2, r15);
        r32.F += r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0285, code lost:
    
        if (r2 <= 0) goto L520;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0289, code lost:
    
        if (r32.H != false) goto L521;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x028f, code lost:
    
        if (t1.p.c(r9, r2, r6) == false) goto L522;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0291, code lost:
    
        r32.H = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0294, code lost:
    
        r13 = r22;
        r12 = r25;
        r11 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02a3, code lost:
    
        throw p1.n0.a(null, "Invalid NAL length");
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02a4, code lost:
    
        r26 = r11;
        r25 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02ab, code lost:
    
        if (r32.I == false) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02ad, code lost:
    
        r12 = r32.f10642h;
        r12.G(r2);
        r33.readFully(r12.f11709a, 0, r32.G);
        r8.f(r32.G, r12);
        r2 = r32.G;
        r2 = t1.p.m(r12.f11711c, r12.f11709a);
        r12.J(0);
        r12.I(r2);
        r2 = r6.f10025p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02d4, code lost:
    
        if (r2 != (-1)) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02d8, code lost:
    
        if (r7.f8475a == 0) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02da, code lost:
    
        r7.x(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02e0, code lost:
    
        if (r7.f8475a == r2) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02e2, code lost:
    
        r7.x(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02e5, code lost:
    
        r7.a(r4, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02f1, code lost:
    
        if ((r17.a() & 4) == 0) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02f3, code lost:
    
        r7.i(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02f6, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02f9, code lost:
    
        r2 = r8.c(r33, r2, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0300, code lost:
    
        r32.F += r2;
        r32.G -= r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x030b, code lost:
    
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x030d, code lost:
    
        r2 = r32.F;
        r6 = r32.E;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0311, code lost:
    
        if (r2 >= r6) goto L528;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0313, code lost:
    
        r32.F += r8.c(r33, r6 - r2, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x031f, code lost:
    
        r1 = r17.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0325, code lost:
    
        if (r32.H != false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0327, code lost:
    
        r1 = r1 | 67108864;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x032a, code lost:
    
        r28 = r1;
        r1 = r17.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0330, code lost:
    
        if (r1 == null) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0332, code lost:
    
        r31 = r1.f10712c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0337, code lost:
    
        r31 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0339, code lost:
    
        r26 = r4;
        r8.a(r26, r28, r32.E, 0, r31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x034a, code lost:
    
        if (r3.isEmpty() != false) goto L524;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x034c, code lost:
    
        r1 = (q3.i) r3.removeFirst();
        r32.f10659z -= r1.f10624c;
        r4 = r1.f10622a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x035d, code lost:
    
        if (r1.f10623b == false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x035f, code lost:
    
        r4 = r4 + r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0361, code lost:
    
        if (r14 == null) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0363, code lost:
    
        r4 = r14.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0367, code lost:
    
        r7 = r4;
        r2 = r32.K;
        r4 = r2.length;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x036c, code lost:
    
        if (r5 >= r4) goto L527;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x036e, code lost:
    
        r2[r5].a(r7, 1, r1.f10624c, r32.f10659z, null);
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0380, code lost:
    
        if (r17.c() != false) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0382, code lost:
    
        r32.D = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0385, code lost:
    
        r32.f10653t = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x038a, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ce, code lost:
    
        r5 = r2.f10626b;
        r11 = "video/avc";
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d9, code lost:
    
        if (r32.f10653t != 3) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dd, code lost:
    
        if (r2.f10635m != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00df, code lost:
    
        r6 = r2.f10628d.f10733d[r2.f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e8, code lost:
    
        r6 = r5.f10721h[r2.f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ee, code lost:
    
        r32.E = r6;
        r6 = r2.f10628d.f10730a.f10705g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fc, code lost:
    
        if (java.util.Objects.equals(r6.f10023n, "video/avc") == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0100, code lost:
    
        if ((r4 & 64) == 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0102, code lost:
    
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0105, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010e, code lost:
    
        if (java.util.Objects.equals(r6.f10023n, "video/hevc") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0112, code lost:
    
        if ((r4 & 128) == 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0115, code lost:
    
        r32.H = !r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x011d, code lost:
    
        if (r2.f >= r2.i) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x011f, code lost:
    
        r33.m(r32.E);
        r1 = r2.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0128, code lost:
    
        if (r1 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x012b, code lost:
    
        r3 = r5.f10726n;
        r1 = r1.f10713d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x012f, code lost:
    
        if (r1 == 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0131, code lost:
    
        r3.K(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0134, code lost:
    
        r1 = r2.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0138, code lost:
    
        if (r5.f10723k == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x013e, code lost:
    
        if (r5.f10724l[r1] == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0140, code lost:
    
        r3.K(r3.D() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x014c, code lost:
    
        if (r2.c() != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x014e, code lost:
    
        r32.D = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0151, code lost:
    
        r32.f10653t = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0154, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x015d, code lost:
    
        if (r2.f10628d.f10730a.f10706h != r21) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x015f, code lost:
    
        r32.E -= 8;
        r33.m(r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0178, code lost:
    
        if ("audio/ac4".equals(r2.f10628d.f10730a.f10705g.f10023n) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x017a, code lost:
    
        r32.F = r2.d(r32.E, 7);
        w2.b.h(r32.E, r8);
        r2.f10625a.f(7, r8);
        r32.F += 7;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0195, code lost:
    
        r6 = 0;
        r32.F = r2.d(r32.E, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x019f, code lost:
    
        r32.E += r32.F;
        r32.f10653t = 4;
        r32.G = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01aa, code lost:
    
        r4 = r2.f10628d;
        r6 = r4.f10730a;
        r8 = r2.f10625a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01b2, code lost:
    
        if (r2.f10635m != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01b4, code lost:
    
        r15 = r4.f[r2.f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01ba, code lost:
    
        r4 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01bc, code lost:
    
        r15 = r5.i[r2.f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01c3, code lost:
    
        if (r14 == null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01c5, code lost:
    
        r4 = r14.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c9, code lost:
    
        r13 = r6.f10708k;
        r6 = r6.f10705g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01cd, code lost:
    
        if (r13 == 0) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01cf, code lost:
    
        r15 = r32.f10641g;
        r9 = r15.f11709a;
        r9[0] = 0;
        r9[1] = 0;
        r9[r20] = 0;
        r12 = 4 - r13;
        r17 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e1, code lost:
    
        r22 = r13;
     */
    @Override // w2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(w2.p r33, w2.s r34) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 2276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.k.l(w2.p, w2.s):int");
    }

    @Override // w2.o
    public final w2.o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
