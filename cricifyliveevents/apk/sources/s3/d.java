package s3;

import a3.j0;
import a3.p;
import a3.q;
import a3.r;
import ag.o;
import android.util.SparseArray;
import com.bumptech.glide.l;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kf.i;
import ua.g0;
import ua.i0;
import ua.z0;
import v1.n0;
import x3.n;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements p {

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final byte[] f11430f0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final byte[] f11431g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final byte[] f11432h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final byte[] f11433i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final UUID f11434j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final Map f11435k0;
    public long A;
    public boolean B;
    public long C;
    public long D;
    public long E;
    public o F;
    public o G;
    public boolean H;
    public boolean I;
    public int J;
    public long K;
    public long L;
    public int M;
    public int N;
    public int[] O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public boolean T;
    public long U;
    public int V;
    public int W;
    public int X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f11436a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f11437a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f11438b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f11439b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f11440c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public byte f11441c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11442d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f11443d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f11444e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public r f11445e0;
    public final n f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t f11446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t f11447h;
    public final t i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t f11448j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final t f11449k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final t f11450l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final t f11451m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final t f11452n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final t f11453o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final t f11454p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ByteBuffer f11455q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f11456r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f11457s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f11458t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f11459u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f11460v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f11461w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public c f11462x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f11463y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11464z;

    static {
        int i = a0.f14551a;
        f11431g0 = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
        f11432h0 = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        f11433i0 = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        f11434j0 = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        l0.e.q(0, map, "htc_video_rotA-000", 90, "htc_video_rotA-090");
        l0.e.q(180, map, "htc_video_rotA-180", 270, "htc_video_rotA-270");
        f11435k0 = Collections.unmodifiableMap(map);
    }

    public d(n nVar, int i) {
        b bVar = new b();
        this.f11457s = -1L;
        this.f11458t = -9223372036854775807L;
        this.f11459u = -9223372036854775807L;
        this.f11460v = -9223372036854775807L;
        this.C = -1L;
        this.D = -1L;
        this.E = -9223372036854775807L;
        this.f11436a = bVar;
        bVar.f11402d = new i(15, this);
        this.f = nVar;
        this.f11442d = (i & 1) == 0;
        this.f11444e = (i & 2) == 0;
        this.f11438b = new e();
        this.f11440c = new SparseArray();
        this.i = new t(4);
        this.f11448j = new t(ByteBuffer.allocate(4).putInt(-1).array());
        this.f11449k = new t(4);
        this.f11446g = new t(z1.o.f15122a);
        this.f11447h = new t(4);
        this.f11450l = new t();
        this.f11451m = new t();
        this.f11452n = new t(8);
        this.f11453o = new t();
        this.f11454p = new t();
        this.O = new int[1];
    }

    public static byte[] j(long j4, long j7, String str) {
        y1.d.b(j4 != -9223372036854775807L);
        int i = (int) (j4 / 3600000000L);
        long j10 = j4 - (((long) i) * 3600000000L);
        int i10 = (int) (j10 / 60000000);
        long j11 = j10 - (((long) i10) * 60000000);
        int i11 = (int) (j11 / 1000000);
        String str2 = String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf((int) ((j11 - (((long) i11) * 1000000)) / j7)));
        int i12 = a0.f14551a;
        return str2.getBytes(StandardCharsets.UTF_8);
    }

    public final void b(int i) {
        if (this.F == null || this.G == null) {
            throw n0.a(null, "Element " + i + " must be in a Cues");
        }
    }

    @Override // a3.p
    public final void c(r rVar) {
        if (this.f11444e) {
            rVar = new l(rVar, this.f);
        }
        this.f11445e0 = rVar;
    }

    public final void d(int i) {
        if (this.f11462x != null) {
            return;
        }
        throw n0.a(null, "Element " + i + " must be in a TrackEntry");
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        this.E = -9223372036854775807L;
        this.J = 0;
        b bVar = this.f11436a;
        bVar.f11403e = 0;
        bVar.f11400b.clear();
        e eVar = bVar.f11401c;
        eVar.f11467b = 0;
        eVar.f11468c = 0;
        e eVar2 = this.f11438b;
        eVar2.f11467b = 0;
        eVar2.f11468c = 0;
        l();
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.f11440c;
            if (i >= sparseArray.size()) {
                return;
            }
            j0 j0Var = ((c) sparseArray.valueAt(i)).V;
            if (j0Var != null) {
                j0Var.f197b = false;
                j0Var.f198c = 0;
            }
            i++;
        }
    }

    @Override // a3.p
    public final List f() {
        g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(s3.c r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.d.g(s3.c, long, int, int, int):void");
    }

    @Override // a3.p
    public final boolean h(q qVar) throws EOFException, InterruptedIOException {
        o oVar = new o(7, (byte) 0);
        t tVar = (t) oVar.f455x;
        a3.l lVar = (a3.l) qVar;
        long j4 = lVar.f214x;
        long j7 = 1024;
        if (j4 != -1 && j4 <= 1024) {
            j7 = j4;
        }
        int i = (int) j7;
        lVar.v(tVar.f14609a, 0, 4, false);
        long jZ = tVar.z();
        oVar.f454w = 4;
        while (true) {
            if (jZ != 440786851) {
                int i10 = oVar.f454w + 1;
                oVar.f454w = i10;
                if (i10 == i) {
                    break;
                }
                lVar.v(tVar.f14609a, 0, 1, false);
                jZ = ((jZ << 8) & (-256)) | ((long) (tVar.f14609a[0] & 255));
            } else {
                long jL = oVar.l(lVar);
                long j10 = oVar.f454w;
                if (jL != Long.MIN_VALUE && (j4 == -1 || j10 + jL < j4)) {
                    while (true) {
                        long j11 = oVar.f454w;
                        long j12 = j10 + jL;
                        if (j11 < j12) {
                            if (oVar.l(lVar) == Long.MIN_VALUE) {
                                break;
                            }
                            long jL2 = oVar.l(lVar);
                            if (jL2 < 0 || jL2 > 2147483647L) {
                                break;
                            }
                            if (jL2 != 0) {
                                int i11 = (int) jL2;
                                lVar.b(i11, false);
                                oVar.f454w += i11;
                            }
                        } else if (j11 == j12) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:673:0x0bc5, code lost:
    
        r5 = true;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:848:0x0f55, code lost:
    
        if (r5 == false) goto L859;
     */
    /* JADX WARN: Code restructure failed: missing block: B:849:0x0f57, code lost:
    
        r2 = r1.getPosition();
        r0 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:850:0x0f5f, code lost:
    
        if (r0.B == false) goto L853;
     */
    /* JADX WARN: Code restructure failed: missing block: B:851:0x0f61, code lost:
    
        r0.D = r2;
        r44.f227a = r0.C;
        r0.B = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:852:0x0f6d, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:854:0x0f74, code lost:
    
        if (r0.f11463y == false) goto L909;
     */
    /* JADX WARN: Code restructure failed: missing block: B:855:0x0f76, code lost:
    
        r6 = r0.D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:856:0x0f7c, code lost:
    
        if (r6 == (-1)) goto L910;
     */
    /* JADX WARN: Code restructure failed: missing block: B:857:0x0f7e, code lost:
    
        r44.f227a = r6;
        r0.D = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:858:0x0f82, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:859:0x0f83, code lost:
    
        r0 = r42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:862:0x0f9f, code lost:
    
        if (r5 != false) goto L872;
     */
    /* JADX WARN: Code restructure failed: missing block: B:863:0x0fa1, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:864:0x0fa2, code lost:
    
        r1 = r0.f11440c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:865:0x0fa8, code lost:
    
        if (r3 >= r1.size()) goto L936;
     */
    /* JADX WARN: Code restructure failed: missing block: B:866:0x0faa, code lost:
    
        r1 = (s3.c) r1.valueAt(r3);
        r1.Z.getClass();
        r2 = r1.V;
     */
    /* JADX WARN: Code restructure failed: missing block: B:867:0x0fb7, code lost:
    
        if (r2 == null) goto L938;
     */
    /* JADX WARN: Code restructure failed: missing block: B:868:0x0fb9, code lost:
    
        r2.a(r1.Z, r1.f11414k);
     */
    /* JADX WARN: Code restructure failed: missing block: B:869:0x0fc0, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:870:0x0fc3, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:872:0x0fc6, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:909:0x0f89, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01ac, code lost:
    
        throw v1.n0.a(null, "Mandatory element SeekID or SeekPosition not found");
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x08ef  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0906  */
    /* JADX WARN: Removed duplicated region for block: B:543:0x0908  */
    /* JADX WARN: Removed duplicated region for block: B:546:0x0919  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x0926  */
    /* JADX WARN: Removed duplicated region for block: B:638:0x0ae6  */
    /* JADX WARN: Removed duplicated region for block: B:643:0x0afa  */
    /* JADX WARN: Removed duplicated region for block: B:644:0x0afd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01cb  */
    /* JADX WARN: Type inference failed for: r0v122 */
    /* JADX WARN: Type inference failed for: r0v5, types: [kf.i] */
    /* JADX WARN: Type inference failed for: r0v53, types: [int] */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r1v155 */
    /* JADX WARN: Type inference failed for: r1v156 */
    /* JADX WARN: Type inference failed for: r1v157 */
    /* JADX WARN: Type inference failed for: r1v158 */
    /* JADX WARN: Type inference failed for: r1v159 */
    /* JADX WARN: Type inference failed for: r1v16, types: [a3.q] */
    /* JADX WARN: Type inference failed for: r1v160 */
    /* JADX WARN: Type inference failed for: r1v161 */
    /* JADX WARN: Type inference failed for: r1v17, types: [a3.q] */
    /* JADX WARN: Type inference failed for: r1v175 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [a3.q] */
    /* JADX WARN: Type inference failed for: r7v1, types: [s3.b] */
    /* JADX WARN: Type inference failed for: r8v0, types: [s3.e] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // a3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(a3.q r43, a3.t r44) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 4870
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.d.i(a3.q, a3.t):int");
    }

    public final void k(q qVar, int i) {
        t tVar = this.i;
        if (tVar.f14611c >= i) {
            return;
        }
        byte[] bArr = tVar.f14609a;
        if (bArr.length < i) {
            tVar.c(Math.max(bArr.length * 2, i));
        }
        byte[] bArr2 = tVar.f14609a;
        int i10 = tVar.f14611c;
        qVar.readFully(bArr2, i10, i - i10);
        tVar.I(i);
    }

    public final void l() {
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = false;
        this.Z = false;
        this.f11437a0 = false;
        this.f11439b0 = 0;
        this.f11441c0 = (byte) 0;
        this.f11443d0 = false;
        this.f11450l.G(0);
    }

    public final long m(long j4) throws n0 {
        long j7 = this.f11458t;
        if (j7 == -9223372036854775807L) {
            throw n0.a(null, "Can't scale timecode prior to timecodeScale being set.");
        }
        int i = a0.f14551a;
        return a0.W(j4, j7, 1000L, RoundingMode.DOWN);
    }

    public final int n(q qVar, c cVar, int i, boolean z10) throws n0 {
        int iB;
        int iB2;
        int i10;
        if ("S_TEXT/UTF8".equals(cVar.f11408c)) {
            o(qVar, f11430f0, i);
            int i11 = this.W;
            l();
            return i11;
        }
        if ("S_TEXT/ASS".equals(cVar.f11408c) || "S_TEXT/SSA".equals(cVar.f11408c)) {
            o(qVar, f11432h0, i);
            int i12 = this.W;
            l();
            return i12;
        }
        if ("S_TEXT/WEBVTT".equals(cVar.f11408c)) {
            o(qVar, f11433i0, i);
            int i13 = this.W;
            l();
            return i13;
        }
        a3.i0 i0Var = cVar.Z;
        boolean z11 = this.Y;
        t tVar = this.f11450l;
        if (!z11) {
            boolean z12 = cVar.i;
            t tVar2 = this.i;
            if (z12) {
                this.R &= -1073741825;
                if (!this.Z) {
                    qVar.readFully(tVar2.f14609a, 0, 1);
                    this.V++;
                    byte b8 = tVar2.f14609a[0];
                    if ((b8 & 128) == 128) {
                        throw n0.a(null, "Extension bit is set in signal byte");
                    }
                    this.f11441c0 = b8;
                    this.Z = true;
                }
                byte b10 = this.f11441c0;
                if ((b10 & 1) == 1) {
                    boolean z13 = (b10 & 2) == 2;
                    this.R |= 1073741824;
                    if (!this.f11443d0) {
                        t tVar3 = this.f11452n;
                        qVar.readFully(tVar3.f14609a, 0, 8);
                        this.V += 8;
                        this.f11443d0 = true;
                        tVar2.f14609a[0] = (byte) ((z13 ? 128 : 0) | 8);
                        tVar2.J(0);
                        i0Var.c(tVar2, 1, 1);
                        this.W++;
                        tVar3.J(0);
                        i0Var.c(tVar3, 8, 1);
                        this.W += 8;
                    }
                    if (z13) {
                        if (!this.f11437a0) {
                            qVar.readFully(tVar2.f14609a, 0, 1);
                            this.V++;
                            tVar2.J(0);
                            this.f11439b0 = tVar2.x();
                            this.f11437a0 = true;
                        }
                        int i14 = this.f11439b0 * 4;
                        tVar2.G(i14);
                        qVar.readFully(tVar2.f14609a, 0, i14);
                        this.V += i14;
                        short s10 = (short) ((this.f11439b0 / 2) + 1);
                        int i15 = (s10 * 6) + 2;
                        ByteBuffer byteBuffer = this.f11455q;
                        if (byteBuffer == null || byteBuffer.capacity() < i15) {
                            this.f11455q = ByteBuffer.allocate(i15);
                        }
                        this.f11455q.position(0);
                        this.f11455q.putShort(s10);
                        int i16 = 0;
                        int i17 = 0;
                        while (true) {
                            i10 = this.f11439b0;
                            if (i16 >= i10) {
                                break;
                            }
                            int iB3 = tVar2.B();
                            if (i16 % 2 == 0) {
                                this.f11455q.putShort((short) (iB3 - i17));
                            } else {
                                this.f11455q.putInt(iB3 - i17);
                            }
                            i16++;
                            i17 = iB3;
                        }
                        int i18 = (i - this.V) - i17;
                        if (i10 % 2 == 1) {
                            this.f11455q.putInt(i18);
                        } else {
                            this.f11455q.putShort((short) i18);
                            this.f11455q.putInt(0);
                        }
                        byte[] bArrArray = this.f11455q.array();
                        t tVar4 = this.f11453o;
                        tVar4.H(i15, bArrArray);
                        i0Var.c(tVar4, i15, 1);
                        this.W += i15;
                    }
                }
            } else {
                byte[] bArr = cVar.f11413j;
                if (bArr != null) {
                    tVar.H(bArr.length, bArr);
                }
            }
            if ("A_OPUS".equals(cVar.f11408c) ? z10 : cVar.f11411g > 0) {
                this.R |= 268435456;
                this.f11454p.G(0);
                int i19 = (tVar.f14611c + i) - this.V;
                tVar2.G(4);
                byte[] bArr2 = tVar2.f14609a;
                bArr2[0] = (byte) ((i19 >> 24) & 255);
                bArr2[1] = (byte) ((i19 >> 16) & 255);
                bArr2[2] = (byte) ((i19 >> 8) & 255);
                bArr2[3] = (byte) (i19 & 255);
                i0Var.c(tVar2, 4, 2);
                this.W += 4;
            }
            this.Y = true;
        }
        int i20 = i + tVar.f14611c;
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f11408c) && !"V_MPEGH/ISO/HEVC".equals(cVar.f11408c)) {
            if (cVar.V != null) {
                y1.d.g(tVar.f14611c == 0);
                cVar.V.c(qVar);
            }
            while (true) {
                int i21 = this.V;
                if (i21 >= i20) {
                    break;
                }
                int i22 = i20 - i21;
                int iA = tVar.a();
                if (iA > 0) {
                    iB2 = Math.min(i22, iA);
                    i0Var.a(iB2, tVar);
                } else {
                    iB2 = i0Var.b(qVar, i22, false);
                }
                this.V += iB2;
                this.W += iB2;
            }
        } else {
            t tVar5 = this.f11447h;
            byte[] bArr3 = tVar5.f14609a;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i23 = cVar.f11406a0;
            int i24 = 4 - i23;
            while (this.V < i20) {
                int i25 = this.X;
                if (i25 == 0) {
                    int iMin = Math.min(i23, tVar.a());
                    qVar.readFully(bArr3, i24 + iMin, i23 - iMin);
                    if (iMin > 0) {
                        tVar.h(bArr3, i24, iMin);
                    }
                    this.V += i23;
                    tVar5.J(0);
                    this.X = tVar5.B();
                    t tVar6 = this.f11446g;
                    tVar6.J(0);
                    i0Var.a(4, tVar6);
                    this.W += 4;
                } else {
                    int iA2 = tVar.a();
                    if (iA2 > 0) {
                        iB = Math.min(i25, iA2);
                        i0Var.a(iB, tVar);
                    } else {
                        iB = i0Var.b(qVar, i25, false);
                    }
                    this.V += iB;
                    this.W += iB;
                    this.X -= iB;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f11408c)) {
            t tVar7 = this.f11448j;
            tVar7.J(0);
            i0Var.a(4, tVar7);
            this.W += 4;
        }
        int i26 = this.W;
        l();
        return i26;
    }

    public final void o(q qVar, byte[] bArr, int i) {
        int length = bArr.length + i;
        t tVar = this.f11451m;
        byte[] bArr2 = tVar.f14609a;
        if (bArr2.length < length) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, length + i);
            tVar.getClass();
            tVar.H(bArrCopyOf.length, bArrCopyOf);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        qVar.readFully(tVar.f14609a, bArr.length, i);
        tVar.J(0);
        tVar.I(length);
    }

    @Override // a3.p
    public final p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
