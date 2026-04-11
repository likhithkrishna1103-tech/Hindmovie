package o3;

import aa.c1;
import aa.h0;
import aa.j0;
import android.util.SparseArray;
import e6.i;
import e6.j;
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
import p1.n0;
import s1.b0;
import s1.u;
import t1.p;
import t3.k;
import w2.i0;
import w2.l;
import w2.o;
import w2.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements o {

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final byte[] f9296f0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final byte[] f9297g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final byte[] f9298h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final byte[] f9299i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final UUID f9300j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final Map f9301k0;
    public long A;
    public boolean B;
    public long C;
    public long D;
    public long E;
    public i F;
    public i G;
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
    public final b f9302a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f9303a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f9304b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f9305b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f9306c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public byte f9307c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9308d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f9309d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9310e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public q f9311e0;
    public final k f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u f9312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u f9313h;
    public final u i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u f9314j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u f9315k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final u f9316l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final u f9317m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final u f9318n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final u f9319o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final u f9320p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ByteBuffer f9321q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f9322r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f9323s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f9324t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f9325u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f9326v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f9327w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public c f9328x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f9329y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f9330z;

    static {
        int i = b0.f11647a;
        f9297g0 = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
        f9298h0 = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        f9299i0 = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        f9300j0 = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        j.q(0, map, "htc_video_rotA-000", 90, "htc_video_rotA-090");
        j.q(180, map, "htc_video_rotA-180", 270, "htc_video_rotA-270");
        f9301k0 = Collections.unmodifiableMap(map);
    }

    public d(k kVar, int i) {
        b bVar = new b();
        this.f9323s = -1L;
        this.f9324t = -9223372036854775807L;
        this.f9325u = -9223372036854775807L;
        this.f9326v = -9223372036854775807L;
        this.C = -1L;
        this.D = -1L;
        this.E = -9223372036854775807L;
        this.f9302a = bVar;
        bVar.f9268d = new u5.d(24, this);
        this.f = kVar;
        this.f9308d = (i & 1) == 0;
        this.f9310e = (i & 2) == 0;
        this.f9304b = new e();
        this.f9306c = new SparseArray();
        this.i = new u(4);
        this.f9314j = new u(ByteBuffer.allocate(4).putInt(-1).array());
        this.f9315k = new u(4);
        this.f9312g = new u(p.f12057a);
        this.f9313h = new u(4);
        this.f9316l = new u();
        this.f9317m = new u();
        this.f9318n = new u(8);
        this.f9319o = new u();
        this.f9320p = new u();
        this.O = new int[1];
    }

    public static byte[] i(long j5, long j8, String str) {
        s1.d.b(j5 != -9223372036854775807L);
        int i = (int) (j5 / 3600000000L);
        long j10 = j5 - (((long) i) * 3600000000L);
        int i10 = (int) (j10 / 60000000);
        long j11 = j10 - (((long) i10) * 60000000);
        int i11 = (int) (j11 / 1000000);
        String str2 = String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf((int) ((j11 - (((long) i11) * 1000000)) / j8)));
        int i12 = b0.f11647a;
        return str2.getBytes(StandardCharsets.UTF_8);
    }

    public final void b(int i) {
        if (this.F == null || this.G == null) {
            throw n0.a(null, "Element " + i + " must be in a Cues");
        }
    }

    @Override // w2.o
    public final void c(q qVar) {
        if (this.f9310e) {
            qVar = new a2.c(qVar, this.f);
        }
        this.f9311e0 = qVar;
    }

    public final void d(int i) {
        if (this.f9328x != null) {
            return;
        }
        throw n0.a(null, "Element " + i + " must be in a TrackEntry");
    }

    @Override // w2.o
    public final boolean e(w2.p pVar) throws EOFException, InterruptedIOException {
        i iVar = new i(2, false);
        u uVar = (u) iVar.f4523v;
        l lVar = (l) pVar;
        long j5 = lVar.f13652w;
        long j8 = 1024;
        if (j5 != -1 && j5 <= 1024) {
            j8 = j5;
        }
        int i = (int) j8;
        lVar.r(uVar.f11709a, 0, 4, false);
        long jZ = uVar.z();
        iVar.f4522u = 4;
        while (true) {
            if (jZ != 440786851) {
                int i10 = iVar.f4522u + 1;
                iVar.f4522u = i10;
                if (i10 == i) {
                    break;
                }
                lVar.r(uVar.f11709a, 0, 1, false);
                jZ = ((jZ << 8) & (-256)) | ((long) (uVar.f11709a[0] & 255));
            } else {
                long jI = iVar.i(lVar);
                long j10 = iVar.f4522u;
                if (jI != Long.MIN_VALUE && (j5 == -1 || j10 + jI < j5)) {
                    while (true) {
                        long j11 = iVar.f4522u;
                        long j12 = j10 + jI;
                        if (j11 < j12) {
                            if (iVar.i(lVar) == Long.MIN_VALUE) {
                                break;
                            }
                            long jI2 = iVar.i(lVar);
                            if (jI2 < 0 || jI2 > 2147483647L) {
                                break;
                            }
                            if (jI2 != 0) {
                                int i11 = (int) jI2;
                                lVar.b(i11, false);
                                iVar.f4522u += i11;
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

    @Override // w2.o
    public final void f(long j5, long j8) {
        this.E = -9223372036854775807L;
        this.J = 0;
        b bVar = this.f9302a;
        bVar.f9269e = 0;
        bVar.f9266b.clear();
        e eVar = bVar.f9267c;
        eVar.f9333b = 0;
        eVar.f9334c = 0;
        e eVar2 = this.f9304b;
        eVar2.f9333b = 0;
        eVar2.f9334c = 0;
        k();
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.f9306c;
            if (i >= sparseArray.size()) {
                return;
            }
            i0 i0Var = ((c) sparseArray.valueAt(i)).V;
            if (i0Var != null) {
                i0Var.f13640b = false;
                i0Var.f13641c = 0;
            }
            i++;
        }
    }

    @Override // w2.o
    public final List g() {
        h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(o3.c r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.d.h(o3.c, long, int, int, int):void");
    }

    public final void j(w2.p pVar, int i) {
        u uVar = this.i;
        if (uVar.f11711c >= i) {
            return;
        }
        byte[] bArr = uVar.f11709a;
        if (bArr.length < i) {
            uVar.c(Math.max(bArr.length * 2, i));
        }
        byte[] bArr2 = uVar.f11709a;
        int i10 = uVar.f11711c;
        pVar.readFully(bArr2, i10, i - i10);
        uVar.I(i);
    }

    public final void k() {
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = false;
        this.Z = false;
        this.f9303a0 = false;
        this.f9305b0 = 0;
        this.f9307c0 = (byte) 0;
        this.f9309d0 = false;
        this.f9316l.G(0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:678:0x0bef, code lost:
    
        r1 = true;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:851:0x0f76, code lost:
    
        if (r1 == false) goto L862;
     */
    /* JADX WARN: Code restructure failed: missing block: B:852:0x0f78, code lost:
    
        r2 = r0.getPosition();
        r4 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:853:0x0f80, code lost:
    
        if (r4.B == false) goto L856;
     */
    /* JADX WARN: Code restructure failed: missing block: B:854:0x0f82, code lost:
    
        r4.D = r2;
        r43.f13664a = r4.C;
        r4.B = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:855:0x0f8e, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:857:0x0f95, code lost:
    
        if (r4.f9329y == false) goto L914;
     */
    /* JADX WARN: Code restructure failed: missing block: B:858:0x0f97, code lost:
    
        r5 = r4.D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:859:0x0f9d, code lost:
    
        if (r5 == (-1)) goto L915;
     */
    /* JADX WARN: Code restructure failed: missing block: B:860:0x0f9f, code lost:
    
        r43.f13664a = r5;
        r4.D = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:861:0x0fa3, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:862:0x0fa4, code lost:
    
        r4 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:865:0x0fc3, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:866:0x0fc4, code lost:
    
        if (r5 != false) goto L876;
     */
    /* JADX WARN: Code restructure failed: missing block: B:867:0x0fc6, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:868:0x0fc7, code lost:
    
        r0 = r4.f9306c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:869:0x0fcd, code lost:
    
        if (r3 >= r0.size()) goto L941;
     */
    /* JADX WARN: Code restructure failed: missing block: B:870:0x0fcf, code lost:
    
        r0 = (o3.c) r0.valueAt(r3);
        r0.Z.getClass();
        r1 = r0.V;
     */
    /* JADX WARN: Code restructure failed: missing block: B:871:0x0fdc, code lost:
    
        if (r1 == null) goto L943;
     */
    /* JADX WARN: Code restructure failed: missing block: B:872:0x0fde, code lost:
    
        r1.a(r0.Z, r0.f9280k);
     */
    /* JADX WARN: Code restructure failed: missing block: B:873:0x0fe5, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:874:0x0fe8, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:876:0x0feb, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:914:0x0faa, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01be, code lost:
    
        throw p1.n0.a(null, "Mandatory element SeekID or SeekPosition not found");
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x0913  */
    /* JADX WARN: Removed duplicated region for block: B:546:0x092a  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x092c  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x093d  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x094a  */
    /* JADX WARN: Removed duplicated region for block: B:623:0x0ac4  */
    /* JADX WARN: Removed duplicated region for block: B:643:0x0b10  */
    /* JADX WARN: Removed duplicated region for block: B:648:0x0b24  */
    /* JADX WARN: Removed duplicated region for block: B:649:0x0b27  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e3  */
    /* JADX WARN: Type inference failed for: r0v159 */
    /* JADX WARN: Type inference failed for: r0v160 */
    /* JADX WARN: Type inference failed for: r0v161 */
    /* JADX WARN: Type inference failed for: r0v162 */
    /* JADX WARN: Type inference failed for: r0v163 */
    /* JADX WARN: Type inference failed for: r0v164 */
    /* JADX WARN: Type inference failed for: r0v165 */
    /* JADX WARN: Type inference failed for: r0v168 */
    /* JADX WARN: Type inference failed for: r0v27, types: [w2.p] */
    /* JADX WARN: Type inference failed for: r0v28, types: [w2.p] */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [w2.p] */
    /* JADX WARN: Type inference failed for: r2v3, types: [u5.d] */
    /* JADX WARN: Type inference failed for: r3v49, types: [java.lang.Object, o3.c] */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r5v160 */
    /* JADX WARN: Type inference failed for: r5v42, types: [int] */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r7v1, types: [o3.b] */
    /* JADX WARN: Type inference failed for: r8v0, types: [o3.e] */
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
    @Override // w2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(w2.p r42, w2.s r43) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 4906
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.d.l(w2.p, w2.s):int");
    }

    public final long m(long j5) throws n0 {
        long j8 = this.f9324t;
        if (j8 == -9223372036854775807L) {
            throw n0.a(null, "Can't scale timecode prior to timecodeScale being set.");
        }
        int i = b0.f11647a;
        return b0.W(j5, j8, 1000L, RoundingMode.DOWN);
    }

    public final int n(w2.p pVar, c cVar, int i, boolean z2) throws n0 {
        int iC;
        int iC2;
        int i10;
        if ("S_TEXT/UTF8".equals(cVar.f9274c)) {
            o(pVar, f9296f0, i);
            int i11 = this.W;
            k();
            return i11;
        }
        if ("S_TEXT/ASS".equals(cVar.f9274c) || "S_TEXT/SSA".equals(cVar.f9274c)) {
            o(pVar, f9298h0, i);
            int i12 = this.W;
            k();
            return i12;
        }
        if ("S_TEXT/WEBVTT".equals(cVar.f9274c)) {
            o(pVar, f9299i0, i);
            int i13 = this.W;
            k();
            return i13;
        }
        w2.h0 h0Var = cVar.Z;
        boolean z10 = this.Y;
        u uVar = this.f9316l;
        if (!z10) {
            boolean z11 = cVar.i;
            u uVar2 = this.i;
            if (z11) {
                this.R &= -1073741825;
                if (!this.Z) {
                    pVar.readFully(uVar2.f11709a, 0, 1);
                    this.V++;
                    byte b10 = uVar2.f11709a[0];
                    if ((b10 & 128) == 128) {
                        throw n0.a(null, "Extension bit is set in signal byte");
                    }
                    this.f9307c0 = b10;
                    this.Z = true;
                }
                byte b11 = this.f9307c0;
                if ((b11 & 1) == 1) {
                    boolean z12 = (b11 & 2) == 2;
                    this.R |= 1073741824;
                    if (!this.f9309d0) {
                        u uVar3 = this.f9318n;
                        pVar.readFully(uVar3.f11709a, 0, 8);
                        this.V += 8;
                        this.f9309d0 = true;
                        uVar2.f11709a[0] = (byte) ((z12 ? 128 : 0) | 8);
                        uVar2.J(0);
                        h0Var.b(uVar2, 1, 1);
                        this.W++;
                        uVar3.J(0);
                        h0Var.b(uVar3, 8, 1);
                        this.W += 8;
                    }
                    if (z12) {
                        if (!this.f9303a0) {
                            pVar.readFully(uVar2.f11709a, 0, 1);
                            this.V++;
                            uVar2.J(0);
                            this.f9305b0 = uVar2.x();
                            this.f9303a0 = true;
                        }
                        int i14 = this.f9305b0 * 4;
                        uVar2.G(i14);
                        pVar.readFully(uVar2.f11709a, 0, i14);
                        this.V += i14;
                        short s3 = (short) ((this.f9305b0 / 2) + 1);
                        int i15 = (s3 * 6) + 2;
                        ByteBuffer byteBuffer = this.f9321q;
                        if (byteBuffer == null || byteBuffer.capacity() < i15) {
                            this.f9321q = ByteBuffer.allocate(i15);
                        }
                        this.f9321q.position(0);
                        this.f9321q.putShort(s3);
                        int i16 = 0;
                        int i17 = 0;
                        while (true) {
                            i10 = this.f9305b0;
                            if (i16 >= i10) {
                                break;
                            }
                            int iB = uVar2.B();
                            if (i16 % 2 == 0) {
                                this.f9321q.putShort((short) (iB - i17));
                            } else {
                                this.f9321q.putInt(iB - i17);
                            }
                            i16++;
                            i17 = iB;
                        }
                        int i18 = (i - this.V) - i17;
                        if (i10 % 2 == 1) {
                            this.f9321q.putInt(i18);
                        } else {
                            this.f9321q.putShort((short) i18);
                            this.f9321q.putInt(0);
                        }
                        byte[] bArrArray = this.f9321q.array();
                        u uVar4 = this.f9319o;
                        uVar4.H(i15, bArrArray);
                        h0Var.b(uVar4, i15, 1);
                        this.W += i15;
                    }
                }
            } else {
                byte[] bArr = cVar.f9279j;
                if (bArr != null) {
                    uVar.H(bArr.length, bArr);
                }
            }
            if ("A_OPUS".equals(cVar.f9274c) ? z2 : cVar.f9277g > 0) {
                this.R |= 268435456;
                this.f9320p.G(0);
                int i19 = (uVar.f11711c + i) - this.V;
                uVar2.G(4);
                byte[] bArr2 = uVar2.f11709a;
                bArr2[0] = (byte) ((i19 >> 24) & 255);
                bArr2[1] = (byte) ((i19 >> 16) & 255);
                bArr2[2] = (byte) ((i19 >> 8) & 255);
                bArr2[3] = (byte) (i19 & 255);
                h0Var.b(uVar2, 4, 2);
                this.W += 4;
            }
            this.Y = true;
        }
        int i20 = i + uVar.f11711c;
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f9274c) && !"V_MPEGH/ISO/HEVC".equals(cVar.f9274c)) {
            if (cVar.V != null) {
                s1.d.g(uVar.f11711c == 0);
                cVar.V.c(pVar);
            }
            while (true) {
                int i21 = this.V;
                if (i21 >= i20) {
                    break;
                }
                int i22 = i20 - i21;
                int iA = uVar.a();
                if (iA > 0) {
                    iC2 = Math.min(i22, iA);
                    h0Var.f(iC2, uVar);
                } else {
                    iC2 = h0Var.c(pVar, i22, false);
                }
                this.V += iC2;
                this.W += iC2;
            }
        } else {
            u uVar5 = this.f9313h;
            byte[] bArr3 = uVar5.f11709a;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i23 = cVar.f9272a0;
            int i24 = 4 - i23;
            while (this.V < i20) {
                int i25 = this.X;
                if (i25 == 0) {
                    int iMin = Math.min(i23, uVar.a());
                    pVar.readFully(bArr3, i24 + iMin, i23 - iMin);
                    if (iMin > 0) {
                        uVar.h(bArr3, i24, iMin);
                    }
                    this.V += i23;
                    uVar5.J(0);
                    this.X = uVar5.B();
                    u uVar6 = this.f9312g;
                    uVar6.J(0);
                    h0Var.f(4, uVar6);
                    this.W += 4;
                } else {
                    int iA2 = uVar.a();
                    if (iA2 > 0) {
                        iC = Math.min(i25, iA2);
                        h0Var.f(iC, uVar);
                    } else {
                        iC = h0Var.c(pVar, i25, false);
                    }
                    this.V += iC;
                    this.W += iC;
                    this.X -= iC;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f9274c)) {
            u uVar7 = this.f9314j;
            uVar7.J(0);
            h0Var.f(4, uVar7);
            this.W += 4;
        }
        int i26 = this.W;
        k();
        return i26;
    }

    public final void o(w2.p pVar, byte[] bArr, int i) {
        int length = bArr.length + i;
        u uVar = this.f9317m;
        byte[] bArr2 = uVar.f11709a;
        if (bArr2.length < length) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, length + i);
            uVar.getClass();
            uVar.H(bArrCopyOf.length, bArrCopyOf);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        pVar.readFully(uVar.f11709a, bArr.length, i);
        uVar.J(0);
        uVar.I(length);
    }

    @Override // w2.o
    public final o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
