package v3;

import a3.a0;
import a3.k0;
import a3.l0;
import ff.m;
import java.util.ArrayList;
import java.util.Arrays;
import nb.w;
import ua.i0;
import v1.m0;
import v1.n0;
import v1.o;
import v1.p;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public m f13169n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13170o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f13171p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a0 f13172q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public pc.c f13173r;

    @Override // v3.i
    public final void a(long j4) {
        this.f13163g = j4;
        this.f13171p = j4 != 0;
        a0 a0Var = this.f13172q;
        this.f13170o = a0Var != null ? a0Var.f121e : 0;
    }

    @Override // v3.i
    public final long b(t tVar) {
        byte b8 = tVar.f14609a[0];
        if ((b8 & 1) == 1) {
            return -1L;
        }
        m mVar = this.f13169n;
        y1.d.h(mVar);
        int i = mVar.f4599w;
        a0 a0Var = (a0) mVar.f4600x;
        int i10 = !((l0[]) mVar.A)[(b8 >> 1) & (255 >>> (8 - i))].f218b ? a0Var.f121e : a0Var.f;
        long j4 = this.f13171p ? (this.f13170o + i10) / 4 : 0;
        byte[] bArr = tVar.f14609a;
        int length = bArr.length;
        int i11 = tVar.f14611c + 4;
        if (length < i11) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i11);
            tVar.H(bArrCopyOf.length, bArrCopyOf);
        } else {
            tVar.I(i11);
        }
        byte[] bArr2 = tVar.f14609a;
        int i12 = tVar.f14611c;
        bArr2[i12 - 4] = (byte) (j4 & 255);
        bArr2[i12 - 3] = (byte) ((j4 >>> 8) & 255);
        bArr2[i12 - 2] = (byte) ((j4 >>> 16) & 255);
        bArr2[i12 - 1] = (byte) ((j4 >>> 24) & 255);
        this.f13171p = true;
        this.f13170o = i10;
        return j4;
    }

    /* JADX WARN: Type inference failed for: r1v59, types: [byte[], java.io.Serializable] */
    @Override // v3.i
    public final boolean c(t tVar, long j4, w wVar) throws n0 {
        m mVar;
        if (this.f13169n != null) {
            ((p) wVar.f9016w).getClass();
            return false;
        }
        a0 a0Var = this.f13172q;
        int i = 4;
        if (a0Var == null) {
            a3.b.x(1, tVar, false);
            tVar.p();
            int iX = tVar.x();
            int iP = tVar.p();
            int iL = tVar.l();
            if (iL <= 0) {
                iL = -1;
            }
            int iL2 = tVar.l();
            int i10 = iL2 > 0 ? iL2 : -1;
            tVar.l();
            int iX2 = tVar.x();
            int iPow = (int) Math.pow(2.0d, iX2 & 15);
            int iPow2 = (int) Math.pow(2.0d, (iX2 & 240) >> 4);
            tVar.x();
            ?? CopyOf = Arrays.copyOf(tVar.f14609a, tVar.f14611c);
            a0 a0Var2 = new a0();
            a0Var2.f117a = iX;
            a0Var2.f118b = iP;
            a0Var2.f119c = iL;
            a0Var2.f120d = i10;
            a0Var2.f121e = iPow;
            a0Var2.f = iPow2;
            a0Var2.f122g = CopyOf;
            this.f13172q = a0Var2;
        } else {
            pc.c cVar = this.f13173r;
            if (cVar == null) {
                this.f13173r = a3.b.v(tVar, true, true);
            } else {
                int i11 = tVar.f14611c;
                byte[] bArr = new byte[i11];
                System.arraycopy(tVar.f14609a, 0, bArr, 0, i11);
                int i12 = a0Var.f117a;
                int i13 = 5;
                a3.b.x(5, tVar, false);
                int iX3 = tVar.x() + 1;
                k0 k0Var = new k0(tVar.f14609a);
                int i14 = 8;
                k0Var.t(tVar.f14610b * 8);
                int i15 = 0;
                while (true) {
                    int i16 = 16;
                    if (i15 < iX3) {
                        int i17 = i14;
                        if (k0Var.i(24) != 5653314) {
                            throw n0.a(null, "expected code book to start with [0x56, 0x43, 0x42] at " + ((k0Var.f210d * 8) + k0Var.f211e));
                        }
                        int i18 = k0Var.i(16);
                        int i19 = k0Var.i(24);
                        if (k0Var.h()) {
                            k0Var.t(i13);
                            int i20 = 0;
                            while (i20 < i19) {
                                int i21 = 0;
                                for (int i22 = i19 - i20; i22 > 0; i22 >>>= 1) {
                                    i21++;
                                }
                                i20 += k0Var.i(i21);
                            }
                        } else {
                            boolean zH = k0Var.h();
                            for (int i23 = 0; i23 < i19; i23++) {
                                if (!zH) {
                                    k0Var.t(i13);
                                } else if (k0Var.h()) {
                                    k0Var.t(i13);
                                }
                            }
                        }
                        int i24 = k0Var.i(4);
                        if (i24 > 2) {
                            throw n0.a(null, "lookup type greater than 2 not decodable: " + i24);
                        }
                        if (i24 == 1 || i24 == 2) {
                            k0Var.t(32);
                            k0Var.t(32);
                            int i25 = k0Var.i(4) + 1;
                            k0Var.t(1);
                            k0Var.t((int) ((i24 == 1 ? i18 != 0 ? (long) Math.floor(Math.pow(i19, 1.0d / ((double) i18))) : 0L : ((long) i19) * ((long) i18)) * ((long) i25)));
                        }
                        i15++;
                        i14 = i17;
                        i13 = 5;
                    } else {
                        int i26 = i14;
                        int i27 = 6;
                        int i28 = k0Var.i(6) + 1;
                        for (int i29 = 0; i29 < i28; i29++) {
                            if (k0Var.i(16) != 0) {
                                throw n0.a(null, "placeholder of time domain transforms not zeroed out");
                            }
                        }
                        int i30 = 1;
                        int i31 = k0Var.i(6) + 1;
                        int i32 = 0;
                        while (true) {
                            int i33 = 3;
                            if (i32 < i31) {
                                int i34 = k0Var.i(i16);
                                if (i34 == 0) {
                                    int i35 = i26;
                                    k0Var.t(i35);
                                    k0Var.t(16);
                                    k0Var.t(16);
                                    k0Var.t(6);
                                    k0Var.t(i35);
                                    int i36 = k0Var.i(4) + 1;
                                    int i37 = 0;
                                    while (i37 < i36) {
                                        k0Var.t(i35);
                                        i37++;
                                        i35 = 8;
                                    }
                                } else {
                                    if (i34 != i30) {
                                        throw n0.a(null, "floor type greater than 1 not decodable: " + i34);
                                    }
                                    int i38 = k0Var.i(5);
                                    int[] iArr = new int[i38];
                                    int i39 = -1;
                                    for (int i40 = 0; i40 < i38; i40++) {
                                        int i41 = k0Var.i(i);
                                        iArr[i40] = i41;
                                        if (i41 > i39) {
                                            i39 = i41;
                                        }
                                    }
                                    int i42 = i39 + 1;
                                    int[] iArr2 = new int[i42];
                                    int i43 = 0;
                                    while (i43 < i42) {
                                        iArr2[i43] = k0Var.i(i33) + 1;
                                        int i44 = k0Var.i(2);
                                        int i45 = i26;
                                        if (i44 > 0) {
                                            k0Var.t(i45);
                                        }
                                        int[] iArr3 = iArr2;
                                        int i46 = 0;
                                        for (int i47 = 1; i46 < (i47 << i44); i47 = 1) {
                                            k0Var.t(i45);
                                            i46++;
                                            i45 = 8;
                                        }
                                        i43++;
                                        iArr2 = iArr3;
                                        i26 = 8;
                                        i33 = 3;
                                    }
                                    int[] iArr4 = iArr2;
                                    k0Var.t(2);
                                    int i48 = k0Var.i(4);
                                    int i49 = 0;
                                    int i50 = 0;
                                    for (int i51 = 0; i51 < i38; i51++) {
                                        i49 += iArr4[iArr[i51]];
                                        while (i50 < i49) {
                                            k0Var.t(i48);
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
                                int i52 = k0Var.i(i27) + 1;
                                int i53 = 0;
                                while (i53 < i52) {
                                    if (k0Var.i(16) > 2) {
                                        throw n0.a(null, "residueType greater than 2 is not decodable");
                                    }
                                    k0Var.t(24);
                                    k0Var.t(24);
                                    k0Var.t(24);
                                    int i54 = k0Var.i(i27) + 1;
                                    int i55 = 8;
                                    k0Var.t(8);
                                    int[] iArr5 = new int[i54];
                                    for (int i56 = 0; i56 < i54; i56++) {
                                        iArr5[i56] = ((k0Var.h() ? k0Var.i(5) : 0) * 8) + k0Var.i(3);
                                    }
                                    int i57 = 0;
                                    while (i57 < i54) {
                                        int i58 = 0;
                                        while (i58 < i55) {
                                            if ((iArr5[i57] & (1 << i58)) != 0) {
                                                k0Var.t(i55);
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
                                int i59 = k0Var.i(i27) + 1;
                                for (int i60 = 0; i60 < i59; i60++) {
                                    int i61 = k0Var.i(16);
                                    if (i61 != 0) {
                                        y1.b.g("VorbisUtil", "mapping type other than 0 not supported: " + i61);
                                    } else {
                                        int i62 = k0Var.h() ? k0Var.i(4) + 1 : 1;
                                        if (k0Var.h()) {
                                            int i63 = k0Var.i(8) + 1;
                                            for (int i64 = 0; i64 < i63; i64++) {
                                                int i65 = i12 - 1;
                                                int i66 = 0;
                                                for (int i67 = i65; i67 > 0; i67 >>>= 1) {
                                                    i66++;
                                                }
                                                k0Var.t(i66);
                                                int i68 = 0;
                                                while (i65 > 0) {
                                                    i68++;
                                                    i65 >>>= 1;
                                                }
                                                k0Var.t(i68);
                                            }
                                        }
                                        if (k0Var.i(2) != 0) {
                                            throw n0.a(null, "to reserved bits must be zero after mapping coupling steps");
                                        }
                                        if (i62 > 1) {
                                            for (int i69 = 0; i69 < i12; i69++) {
                                                k0Var.t(4);
                                            }
                                        }
                                        for (int i70 = 0; i70 < i62; i70++) {
                                            k0Var.t(8);
                                            k0Var.t(8);
                                            k0Var.t(8);
                                        }
                                    }
                                }
                                int i71 = k0Var.i(6);
                                int i72 = i71 + 1;
                                l0[] l0VarArr = new l0[i72];
                                for (int i73 = 0; i73 < i72; i73++) {
                                    boolean zH2 = k0Var.h();
                                    k0Var.i(16);
                                    k0Var.i(16);
                                    k0Var.i(8);
                                    l0VarArr[i73] = new l0(zH2);
                                }
                                if (!k0Var.h()) {
                                    throw n0.a(null, "framing bit after modes not set as expected");
                                }
                                int i74 = 0;
                                while (i71 > 0) {
                                    i74++;
                                    i71 >>>= 1;
                                }
                                mVar = new m(a0Var, cVar, bArr, l0VarArr, i74);
                            }
                        }
                    }
                }
            }
        }
        mVar = null;
        this.f13169n = mVar;
        if (mVar == null) {
            return true;
        }
        a0 a0Var3 = (a0) mVar.f4600x;
        ArrayList arrayList = new ArrayList();
        arrayList.add((byte[]) a0Var3.f122g);
        arrayList.add((byte[]) mVar.f4602z);
        v1.l0 l0VarR = a3.b.r(i0.l((String[]) ((pc.c) mVar.f4601y).f10180v));
        o oVar = new o();
        oVar.f12892l = m0.p("audio/ogg");
        oVar.f12893m = m0.p("audio/vorbis");
        oVar.f12889h = a0Var3.f120d;
        oVar.i = a0Var3.f119c;
        oVar.E = a0Var3.f117a;
        oVar.F = a0Var3.f118b;
        oVar.f12896p = arrayList;
        oVar.f12891k = l0VarR;
        wVar.f9016w = new p(oVar);
        return true;
    }

    @Override // v3.i
    public final void d(boolean z10) {
        super.d(z10);
        if (z10) {
            this.f13169n = null;
            this.f13172q = null;
            this.f13173r = null;
        }
        this.f13170o = 0;
        this.f13171p = false;
    }
}
