package r3;

import a2.f2;
import aa.j0;
import d4.e0;
import java.util.ArrayList;
import java.util.Arrays;
import n.a1;
import p1.l0;
import p1.m0;
import p1.n0;
import p1.p;
import p1.q;
import s1.t;
import s1.u;
import w2.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e0 f11399n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f11400o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f11401p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public z f11402q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a1 f11403r;

    @Override // r3.i
    public final void a(long j5) {
        this.f11393g = j5;
        this.f11401p = j5 != 0;
        z zVar = this.f11402q;
        this.f11400o = zVar != null ? zVar.f13702e : 0;
    }

    @Override // r3.i
    public final long b(u uVar) {
        byte b10 = uVar.f11709a[0];
        if ((b10 & 1) == 1) {
            return -1L;
        }
        e0 e0Var = this.f11399n;
        s1.d.h(e0Var);
        int i = e0Var.f3837v;
        z zVar = (z) e0Var.f3838w;
        int i10 = !((f2[]) e0Var.f3841z)[(b10 >> 1) & (255 >>> (8 - i))].f230b ? zVar.f13702e : zVar.f;
        long j5 = this.f11401p ? (this.f11400o + i10) / 4 : 0;
        byte[] bArr = uVar.f11709a;
        int length = bArr.length;
        int i11 = uVar.f11711c + 4;
        if (length < i11) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i11);
            uVar.H(bArrCopyOf.length, bArrCopyOf);
        } else {
            uVar.I(i11);
        }
        byte[] bArr2 = uVar.f11709a;
        int i12 = uVar.f11711c;
        bArr2[i12 - 4] = (byte) (j5 & 255);
        bArr2[i12 - 3] = (byte) ((j5 >>> 8) & 255);
        bArr2[i12 - 2] = (byte) ((j5 >>> 16) & 255);
        bArr2[i12 - 1] = (byte) ((j5 >>> 24) & 255);
        this.f11401p = true;
        this.f11400o = i10;
        return j5;
    }

    /* JADX WARN: Type inference failed for: r1v59, types: [byte[], java.io.Serializable] */
    @Override // r3.i
    public final boolean c(u uVar, long j5, pb.c cVar) throws n0 {
        e0 e0Var;
        if (this.f11399n != null) {
            ((q) cVar.f10310v).getClass();
            return false;
        }
        z zVar = this.f11402q;
        int i = 4;
        if (zVar == null) {
            w2.b.y(1, uVar, false);
            uVar.p();
            int iX = uVar.x();
            int iP = uVar.p();
            int iL = uVar.l();
            if (iL <= 0) {
                iL = -1;
            }
            int iL2 = uVar.l();
            int i10 = iL2 > 0 ? iL2 : -1;
            uVar.l();
            int iX2 = uVar.x();
            int iPow = (int) Math.pow(2.0d, iX2 & 15);
            int iPow2 = (int) Math.pow(2.0d, (iX2 & 240) >> 4);
            uVar.x();
            ?? CopyOf = Arrays.copyOf(uVar.f11709a, uVar.f11711c);
            z zVar2 = new z();
            zVar2.f13698a = iX;
            zVar2.f13699b = iP;
            zVar2.f13700c = iL;
            zVar2.f13701d = i10;
            zVar2.f13702e = iPow;
            zVar2.f = iPow2;
            zVar2.f13703g = CopyOf;
            this.f11402q = zVar2;
        } else {
            a1 a1Var = this.f11403r;
            if (a1Var == null) {
                this.f11403r = w2.b.w(uVar, true, true);
            } else {
                int i11 = uVar.f11711c;
                byte[] bArr = new byte[i11];
                System.arraycopy(uVar.f11709a, 0, bArr, 0, i11);
                int i12 = zVar.f13698a;
                int i13 = 5;
                w2.b.y(5, uVar, false);
                int iX3 = uVar.x() + 1;
                t tVar = new t(uVar.f11709a);
                int i14 = 8;
                tVar.t(uVar.f11710b * 8);
                int i15 = 0;
                while (true) {
                    int i16 = 16;
                    if (i15 < iX3) {
                        int i17 = i14;
                        if (tVar.i(24) != 5653314) {
                            throw n0.a(null, "expected code book to start with [0x56, 0x43, 0x42] at " + ((tVar.f11705d * 8) + tVar.f11706e));
                        }
                        int i18 = tVar.i(16);
                        int i19 = tVar.i(24);
                        if (tVar.h()) {
                            tVar.t(i13);
                            int i20 = 0;
                            while (i20 < i19) {
                                int i21 = 0;
                                for (int i22 = i19 - i20; i22 > 0; i22 >>>= 1) {
                                    i21++;
                                }
                                i20 += tVar.i(i21);
                            }
                        } else {
                            boolean zH = tVar.h();
                            for (int i23 = 0; i23 < i19; i23++) {
                                if (!zH) {
                                    tVar.t(i13);
                                } else if (tVar.h()) {
                                    tVar.t(i13);
                                }
                            }
                        }
                        int i24 = tVar.i(4);
                        if (i24 > 2) {
                            throw n0.a(null, "lookup type greater than 2 not decodable: " + i24);
                        }
                        if (i24 == 1 || i24 == 2) {
                            tVar.t(32);
                            tVar.t(32);
                            int i25 = tVar.i(4) + 1;
                            tVar.t(1);
                            tVar.t((int) ((i24 == 1 ? i18 != 0 ? (long) Math.floor(Math.pow(i19, 1.0d / ((double) i18))) : 0L : ((long) i19) * ((long) i18)) * ((long) i25)));
                        }
                        i15++;
                        i14 = i17;
                        i13 = 5;
                    } else {
                        int i26 = i14;
                        int i27 = 6;
                        int i28 = tVar.i(6) + 1;
                        for (int i29 = 0; i29 < i28; i29++) {
                            if (tVar.i(16) != 0) {
                                throw n0.a(null, "placeholder of time domain transforms not zeroed out");
                            }
                        }
                        int i30 = 1;
                        int i31 = tVar.i(6) + 1;
                        int i32 = 0;
                        while (true) {
                            int i33 = 3;
                            if (i32 < i31) {
                                int i34 = tVar.i(i16);
                                if (i34 == 0) {
                                    int i35 = i26;
                                    tVar.t(i35);
                                    tVar.t(16);
                                    tVar.t(16);
                                    tVar.t(6);
                                    tVar.t(i35);
                                    int i36 = tVar.i(4) + 1;
                                    int i37 = 0;
                                    while (i37 < i36) {
                                        tVar.t(i35);
                                        i37++;
                                        i35 = 8;
                                    }
                                } else {
                                    if (i34 != i30) {
                                        throw n0.a(null, "floor type greater than 1 not decodable: " + i34);
                                    }
                                    int i38 = tVar.i(5);
                                    int[] iArr = new int[i38];
                                    int i39 = -1;
                                    for (int i40 = 0; i40 < i38; i40++) {
                                        int i41 = tVar.i(i);
                                        iArr[i40] = i41;
                                        if (i41 > i39) {
                                            i39 = i41;
                                        }
                                    }
                                    int i42 = i39 + 1;
                                    int[] iArr2 = new int[i42];
                                    int i43 = 0;
                                    while (i43 < i42) {
                                        iArr2[i43] = tVar.i(i33) + 1;
                                        int i44 = tVar.i(2);
                                        int i45 = i26;
                                        if (i44 > 0) {
                                            tVar.t(i45);
                                        }
                                        int[] iArr3 = iArr2;
                                        int i46 = 0;
                                        for (int i47 = 1; i46 < (i47 << i44); i47 = 1) {
                                            tVar.t(i45);
                                            i46++;
                                            i45 = 8;
                                        }
                                        i43++;
                                        iArr2 = iArr3;
                                        i26 = 8;
                                        i33 = 3;
                                    }
                                    int[] iArr4 = iArr2;
                                    tVar.t(2);
                                    int i48 = tVar.i(4);
                                    int i49 = 0;
                                    int i50 = 0;
                                    for (int i51 = 0; i51 < i38; i51++) {
                                        i49 += iArr4[iArr[i51]];
                                        while (i50 < i49) {
                                            tVar.t(i48);
                                            i50++;
                                        }
                                    }
                                }
                                i32++;
                                i26 = 8;
                                i27 = 6;
                                i = 4;
                                i16 = 16;
                                i30 = 1;
                            } else {
                                int i52 = tVar.i(i27) + 1;
                                int i53 = 0;
                                while (i53 < i52) {
                                    if (tVar.i(16) > 2) {
                                        throw n0.a(null, "residueType greater than 2 is not decodable");
                                    }
                                    tVar.t(24);
                                    tVar.t(24);
                                    tVar.t(24);
                                    int i54 = tVar.i(i27) + 1;
                                    int i55 = 8;
                                    tVar.t(8);
                                    int[] iArr5 = new int[i54];
                                    for (int i56 = 0; i56 < i54; i56++) {
                                        iArr5[i56] = ((tVar.h() ? tVar.i(5) : 0) * 8) + tVar.i(3);
                                    }
                                    int i57 = 0;
                                    while (i57 < i54) {
                                        int i58 = 0;
                                        while (i58 < i55) {
                                            if ((iArr5[i57] & (1 << i58)) != 0) {
                                                tVar.t(i55);
                                            }
                                            i58++;
                                            i55 = 8;
                                        }
                                        i57++;
                                        i55 = 8;
                                    }
                                    i53++;
                                    i27 = 6;
                                }
                                int i59 = tVar.i(i27) + 1;
                                for (int i60 = 0; i60 < i59; i60++) {
                                    int i61 = tVar.i(16);
                                    if (i61 != 0) {
                                        s1.b.g("VorbisUtil", "mapping type other than 0 not supported: " + i61);
                                    } else {
                                        int i62 = tVar.h() ? tVar.i(4) + 1 : 1;
                                        if (tVar.h()) {
                                            int i63 = tVar.i(8) + 1;
                                            for (int i64 = 0; i64 < i63; i64++) {
                                                int i65 = i12 - 1;
                                                int i66 = 0;
                                                for (int i67 = i65; i67 > 0; i67 >>>= 1) {
                                                    i66++;
                                                }
                                                tVar.t(i66);
                                                int i68 = 0;
                                                while (i65 > 0) {
                                                    i68++;
                                                    i65 >>>= 1;
                                                }
                                                tVar.t(i68);
                                            }
                                        }
                                        if (tVar.i(2) != 0) {
                                            throw n0.a(null, "to reserved bits must be zero after mapping coupling steps");
                                        }
                                        if (i62 > 1) {
                                            for (int i69 = 0; i69 < i12; i69++) {
                                                tVar.t(4);
                                            }
                                        }
                                        for (int i70 = 0; i70 < i62; i70++) {
                                            tVar.t(8);
                                            tVar.t(8);
                                            tVar.t(8);
                                        }
                                    }
                                }
                                int i71 = tVar.i(6);
                                int i72 = i71 + 1;
                                f2[] f2VarArr = new f2[i72];
                                for (int i73 = 0; i73 < i72; i73++) {
                                    boolean zH2 = tVar.h();
                                    tVar.i(16);
                                    tVar.i(16);
                                    tVar.i(8);
                                    f2VarArr[i73] = new f2(zH2);
                                }
                                if (!tVar.h()) {
                                    throw n0.a(null, "framing bit after modes not set as expected");
                                }
                                int i74 = 0;
                                while (i71 > 0) {
                                    i74++;
                                    i71 >>>= 1;
                                }
                                e0Var = new e0(zVar, a1Var, bArr, f2VarArr, i74);
                            }
                        }
                    }
                }
            }
        }
        e0Var = null;
        this.f11399n = e0Var;
        if (e0Var == null) {
            return true;
        }
        z zVar3 = (z) e0Var.f3838w;
        ArrayList arrayList = new ArrayList();
        arrayList.add((byte[]) zVar3.f13703g);
        arrayList.add((byte[]) e0Var.f3840y);
        l0 l0VarS = w2.b.s(j0.s((String[]) ((a1) e0Var.f3839x).f8343u));
        p pVar = new p();
        pVar.f9966l = m0.p("audio/ogg");
        pVar.f9967m = m0.p("audio/vorbis");
        pVar.f9963h = zVar3.f13701d;
        pVar.i = zVar3.f13700c;
        pVar.E = zVar3.f13698a;
        pVar.F = zVar3.f13699b;
        pVar.f9970p = arrayList;
        pVar.f9965k = l0VarS;
        cVar.f10310v = new q(pVar);
        return true;
    }

    @Override // r3.i
    public final void d(boolean z2) {
        super.d(z2);
        if (z2) {
            this.f11399n = null;
            this.f11402q = null;
            this.f11403r = null;
        }
        this.f11400o = 0;
        this.f11401p = false;
    }
}
