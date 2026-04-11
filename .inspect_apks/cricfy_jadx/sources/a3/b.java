package a3;

import android.util.Base64;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import v1.n0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f123a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f124b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f125c = {1, 2, 3, 6};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f126d = {48000, 44100, 32000};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f127e = {24000, 22050, 16000};
    public static final int[] f = {2, 1, 2, 3, 3, 4, 4, 5};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f128g = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f129h = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};
    public static final int[] i = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f130j = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f131k = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f132l = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f133m = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f134n = {5, 8, 10, 12};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f135o = {6, 9, 12, 15};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f136p = {2, 4, 6, 8};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f137q = {9, 11, 13, 16};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f138r = {5, 8, 10, 12};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String[] f139s = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int[] f140t = {44100, 48000, 32000};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int[] f141u = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int[] f142v = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int[] f143w = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f144x = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f145y = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static ArrayList a(byte[] bArr) {
        long j4 = (((long) (((bArr[11] & 255) << 8) | (bArr[10] & 255))) * 1000000000) / 48000;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j4).array());
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(80000000L).array());
        return arrayList;
    }

    public static boolean b(y1.t tVar, v vVar, int i10, t tVar2) {
        long jZ = tVar.z();
        long j4 = jZ >>> 16;
        if (j4 != i10) {
            return false;
        }
        boolean z10 = (j4 & 1) == 1;
        int i11 = (int) ((jZ >> 12) & 15);
        int i12 = (int) ((jZ >> 8) & 15);
        int i13 = (int) ((jZ >> 4) & 15);
        int i14 = (int) ((jZ >> 1) & 7);
        boolean z11 = (jZ & 1) == 1;
        if (i13 <= 7) {
            if (i13 != vVar.f236g - 1) {
                return false;
            }
        } else if (i13 > 10 || vVar.f236g != 2) {
            return false;
        }
        if (!(i14 == 0 || i14 == vVar.i) || z11) {
            return false;
        }
        try {
            long jE = tVar.E();
            if (!z10) {
                jE *= (long) vVar.f232b;
            }
            tVar2.f227a = jE;
            int iT = t(i11, tVar);
            if (iT == -1 || iT > vVar.f232b) {
                return false;
            }
            int i15 = vVar.f235e;
            if (i12 != 0) {
                if (i12 <= 11) {
                    if (i12 != vVar.f) {
                        return false;
                    }
                } else if (i12 != 12) {
                    if (i12 > 14) {
                        return false;
                    }
                    int iD = tVar.D();
                    if (i12 == 14) {
                        iD *= 10;
                    }
                    if (iD != i15) {
                        return false;
                    }
                } else if (tVar.x() * 1000 != i15) {
                    return false;
                }
            }
            int iX = tVar.x();
            int i16 = tVar.f14610b;
            byte[] bArr = tVar.f14609a;
            int i17 = i16 - 1;
            int i18 = 0;
            for (int i19 = tVar.f14610b; i19 < i17; i19++) {
                i18 = y1.a0.f14562n[i18 ^ (bArr[i19] & 255)];
            }
            int i20 = y1.a0.f14551a;
            return iX == i18;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static void c(String str, boolean z10) throws n0 {
        if (!z10) {
            throw n0.a(null, str);
        }
    }

    public static void d(long j4, y1.t tVar, i0[] i0VarArr) {
        int i10;
        while (true) {
            if (tVar.a() <= 1) {
                return;
            }
            int i11 = 0;
            while (true) {
                if (tVar.a() == 0) {
                    i10 = -1;
                    break;
                }
                int iX = tVar.x();
                i11 += iX;
                if (iX != 255) {
                    i10 = i11;
                    break;
                }
            }
            int i12 = 0;
            while (true) {
                if (tVar.a() == 0) {
                    i12 = -1;
                    break;
                }
                int iX2 = tVar.x();
                i12 += iX2;
                if (iX2 != 255) {
                    break;
                }
            }
            int i13 = tVar.f14610b + i12;
            if (i12 == -1 || i12 > tVar.a()) {
                y1.b.p("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                i13 = tVar.f14611c;
            } else if (i10 == 4 && i12 >= 8) {
                int iX3 = tVar.x();
                int iD = tVar.D();
                int iJ = iD == 49 ? tVar.j() : 0;
                int iX4 = tVar.x();
                if (iD == 47) {
                    tVar.K(1);
                }
                boolean z10 = iX3 == 181 && (iD == 49 || iD == 47) && iX4 == 3;
                if (iD == 49) {
                    z10 &= iJ == 1195456820;
                }
                if (z10) {
                    e(j4, tVar, i0VarArr);
                }
            }
            tVar.J(i13);
        }
    }

    public static void e(long j4, y1.t tVar, i0[] i0VarArr) {
        int iX = tVar.x();
        if ((iX & 64) != 0) {
            tVar.K(1);
            int i10 = (iX & 31) * 3;
            int i11 = tVar.f14610b;
            for (i0 i0Var : i0VarArr) {
                tVar.J(i11);
                i0Var.a(i10, tVar);
                y1.d.g(j4 != -9223372036854775807L);
                i0Var.e(j4, 1, i10, 0, null);
            }
        }
    }

    public static int f(int i10, int i11) {
        int i12 = i11 / 2;
        if (i10 < 0 || i10 >= 3 || i11 < 0 || i12 >= 19) {
            return -1;
        }
        int i13 = f126d[i10];
        if (i13 == 44100) {
            return ((i11 % 2) + f129h[i12]) * 2;
        }
        int i14 = f128g[i12];
        return i13 == 32000 ? i14 * 6 : i14 * 4;
    }

    public static void g(int i10, y1.t tVar) {
        tVar.G(7);
        byte[] bArr = tVar.f14609a;
        bArr[0] = -84;
        bArr[1] = 64;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = (byte) ((i10 >> 16) & 255);
        bArr[5] = (byte) ((i10 >> 8) & 255);
        bArr[6] = (byte) (i10 & 255);
    }

    public static int h(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if ((i10 & (-2097152)) != -2097152 || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0 || (i13 = (i10 >>> 12) & 15) == 0 || i13 == 15 || (i14 = (i10 >>> 10) & 3) == 3) {
            return -1;
        }
        int i15 = f140t[i14];
        if (i11 == 2) {
            i15 /= 2;
        } else if (i11 == 0) {
            i15 /= 4;
        }
        int i16 = (i10 >>> 9) & 1;
        if (i12 == 3) {
            return ((((i11 == 3 ? f141u[i13 - 1] : f142v[i13 - 1]) * 12) / i15) + i16) * 4;
        }
        int i17 = i11 == 3 ? i12 == 2 ? f143w[i13 - 1] : f144x[i13 - 1] : f145y[i13 - 1];
        if (i11 == 3) {
            return ((i17 * 144) / i15) + i16;
        }
        return (((i12 == 1 ? 72 : 144) * i17) / i15) + i16;
    }

    public static int i(int i10) {
        if (i10 == 20) {
            return 63750;
        }
        if (i10 == 30) {
            return 2250000;
        }
        switch (i10) {
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return 80000;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return 768000;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return 192000;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            default:
                switch (i10) {
                    case 14:
                        return 3062500;
                    case 15:
                        return 8000;
                    case 16:
                        return 256000;
                    case 17:
                        return 336000;
                    case 18:
                        return 768000;
                    default:
                        return -2147483647;
                }
        }
    }

    public static k0 j(byte[] bArr) {
        byte b8 = bArr[0];
        if (b8 == 127 || b8 == 100 || b8 == 64 || b8 == 113) {
            return new k0(bArr.length, bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        byte b10 = bArrCopyOf[0];
        if (b10 == -2 || b10 == -1 || b10 == 37 || b10 == -14 || b10 == -24) {
            for (int i10 = 0; i10 < bArrCopyOf.length - 1; i10 += 2) {
                byte b11 = bArrCopyOf[i10];
                int i11 = i10 + 1;
                bArrCopyOf[i10] = bArrCopyOf[i11];
                bArrCopyOf[i11] = b11;
            }
        }
        k0 k0Var = new k0(bArrCopyOf.length, bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            k0 k0Var2 = new k0(bArrCopyOf.length, bArrCopyOf);
            while (k0Var2.b() >= 16) {
                k0Var2.t(2);
                int i12 = k0Var2.i(14) & 16383;
                int iMin = Math.min(8 - k0Var.f210d, 14);
                int i13 = k0Var.f210d;
                int i14 = (8 - i13) - iMin;
                byte[] bArr2 = k0Var.f208b;
                int i15 = k0Var.f209c;
                byte b12 = (byte) (((65280 >> i13) | ((1 << i14) - 1)) & bArr2[i15]);
                bArr2[i15] = b12;
                int i16 = 14 - iMin;
                bArr2[i15] = (byte) (b12 | ((i12 >>> i16) << i14));
                int i17 = i15 + 1;
                while (i16 > 8) {
                    k0Var.f208b[i17] = (byte) (i12 >>> (i16 - 8));
                    i16 -= 8;
                    i17++;
                }
                int i18 = 8 - i16;
                byte[] bArr3 = k0Var.f208b;
                byte b13 = (byte) (bArr3[i17] & ((1 << i18) - 1));
                bArr3[i17] = b13;
                bArr3[i17] = (byte) (((i12 & ((1 << i16) - 1)) << i18) | b13);
                k0Var.t(14);
                k0Var.a();
            }
        }
        k0Var.o(bArrCopyOf.length, bArrCopyOf);
        return k0Var;
    }

    public static long k(byte b8, byte b10) {
        int i10;
        int i11 = b8 & 255;
        int i12 = b8 & 3;
        if (i12 != 0) {
            i10 = 2;
            if (i12 != 1 && i12 != 2) {
                i10 = b10 & 63;
            }
        } else {
            i10 = 1;
        }
        int i13 = i11 >> 3;
        int i14 = i13 & 3;
        return ((long) i10) * ((long) (i13 >= 16 ? 2500 << i14 : i13 >= 12 ? 10000 << (i13 & 1) : i14 == 3 ? 60000 : 10000 << i14));
    }

    public static int l(k0 k0Var) throws n0 {
        int i10 = k0Var.i(4);
        if (i10 == 15) {
            if (k0Var.b() >= 24) {
                return k0Var.i(24);
            }
            throw n0.a(null, "AAC header insufficient data");
        }
        if (i10 < 13) {
            return f123a[i10];
        }
        throw n0.a(null, "AAC header wrong Sampling Frequency Index");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static a3.d m(a3.k0 r9) {
        /*
            r0 = 16
            int r1 = r9.i(r0)
            int r0 = r9.i(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r9.i(r0)
            r2 = 7
            goto L19
        L18:
            r2 = r3
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r1 = 2
            int r2 = r9.i(r1)
            r4 = 3
            if (r2 != r4) goto L32
        L29:
            r9.i(r1)
            boolean r2 = r9.h()
            if (r2 != 0) goto L29
        L32:
            r2 = 10
            int r2 = r9.i(r2)
            boolean r5 = r9.h()
            if (r5 == 0) goto L47
            int r5 = r9.i(r4)
            if (r5 <= 0) goto L47
            r9.t(r1)
        L47:
            boolean r5 = r9.h()
            r6 = 44100(0xac44, float:6.1797E-41)
            r7 = 48000(0xbb80, float:6.7262E-41)
            if (r5 == 0) goto L55
            r5 = r7
            goto L56
        L55:
            r5 = r6
        L56:
            int r9 = r9.i(r3)
            int[] r8 = a3.b.i
            if (r5 != r6) goto L65
            r6 = 13
            if (r9 != r6) goto L65
            r9 = r8[r9]
            goto L93
        L65:
            if (r5 != r7) goto L92
            r6 = 14
            if (r9 >= r6) goto L92
            r6 = r8[r9]
            int r2 = r2 % 5
            r7 = 8
            r8 = 1
            if (r2 == r8) goto L8b
            r8 = 11
            if (r2 == r1) goto L86
            if (r2 == r4) goto L8b
            if (r2 == r3) goto L7d
            goto L90
        L7d:
            if (r9 == r4) goto L83
            if (r9 == r7) goto L83
            if (r9 != r8) goto L90
        L83:
            int r9 = r6 + 1
            goto L93
        L86:
            if (r9 == r7) goto L83
            if (r9 != r8) goto L90
            goto L83
        L8b:
            if (r9 == r4) goto L83
            if (r9 != r7) goto L90
            goto L83
        L90:
            r9 = r6
            goto L93
        L92:
            r9 = 0
        L93:
            a3.d r1 = new a3.d
            r1.<init>(r5, r0, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.b.m(a3.k0):a3.d");
    }

    public static a n(k0 k0Var, boolean z10) throws n0 {
        int i10 = k0Var.i(5);
        if (i10 == 31) {
            i10 = k0Var.i(6) + 32;
        }
        int iL = l(k0Var);
        int i11 = k0Var.i(4);
        String strG = l0.e.g(i10, "mp4a.40.");
        if (i10 == 5 || i10 == 29) {
            iL = l(k0Var);
            int i12 = k0Var.i(5);
            if (i12 == 31) {
                i12 = k0Var.i(6) + 32;
            }
            i10 = i12;
            if (i10 == 22) {
                i11 = k0Var.i(4);
            }
        }
        if (z10) {
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4 && i10 != 6 && i10 != 7 && i10 != 17) {
                switch (i10) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw n0.c("Unsupported audio object type: " + i10);
                }
            }
            if (k0Var.h()) {
                y1.b.p("AacUtil", "Unexpected frameLengthFlag = 1");
            }
            if (k0Var.h()) {
                k0Var.t(14);
            }
            boolean zH = k0Var.h();
            if (i11 == 0) {
                throw new UnsupportedOperationException();
            }
            if (i10 == 6 || i10 == 20) {
                k0Var.t(3);
            }
            if (zH) {
                if (i10 == 22) {
                    k0Var.t(16);
                }
                if (i10 == 17 || i10 == 19 || i10 == 20 || i10 == 23) {
                    k0Var.t(3);
                }
                k0Var.t(1);
            }
            switch (i10) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int i13 = k0Var.i(2);
                    if (i13 == 2 || i13 == 3) {
                        throw n0.c("Unsupported epConfig: " + i13);
                    }
                    break;
            }
        }
        int i14 = f124b[i11];
        if (i14 != -1) {
            return new a(iL, i14, strG);
        }
        throw n0.a(null, null);
    }

    public static void o(k0 k0Var, c cVar) throws n0 {
        int i10 = k0Var.i(5);
        k0Var.t(2);
        if (k0Var.h()) {
            k0Var.t(5);
        }
        if (i10 >= 7 && i10 <= 10) {
            k0Var.s();
        }
        if (k0Var.h()) {
            int i11 = k0Var.i(3);
            if (cVar.f149b == -1 && i10 >= 0 && i10 <= 15 && (i11 == 0 || i11 == 1)) {
                cVar.f149b = i10;
            }
            if (k0Var.h()) {
                w(k0Var);
            }
        }
    }

    public static void p(k0 k0Var, c cVar) throws n0 {
        k0Var.t(2);
        boolean zH = k0Var.h();
        int i10 = k0Var.i(8);
        for (int i11 = 0; i11 < i10; i11++) {
            k0Var.t(2);
            if (k0Var.h()) {
                k0Var.t(5);
            }
            if (zH) {
                k0Var.t(24);
            } else {
                if (k0Var.h()) {
                    if (!k0Var.h()) {
                        k0Var.t(4);
                    }
                    cVar.f150c = k0Var.i(6) + 1;
                }
                k0Var.t(4);
            }
        }
        if (k0Var.h()) {
            k0Var.t(3);
            if (k0Var.h()) {
                w(k0Var);
            }
        }
    }

    public static int q(k0 k0Var, int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 3 && k0Var.h(); i11++) {
            i10++;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            i12 += 1 << iArr[i13];
        }
        return k0Var.i(iArr[i10]) + i12;
    }

    public static v1.l0 r(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = (String) list.get(i10);
            int i11 = y1.a0.f14551a;
            String[] strArrSplit = str.split("=", 2);
            if (strArrSplit.length != 2) {
                y1.b.p("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (strArrSplit[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(m3.a.d(new y1.t(Base64.decode(strArrSplit[1], 0))));
                } catch (RuntimeException e9) {
                    y1.b.q("VorbisUtil", "Failed to parse vorbis picture", e9);
                }
            } else {
                arrayList.add(new r3.a(strArrSplit[0], strArrSplit[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new v1.l0(arrayList);
    }

    public static v1.l0 s(q qVar, boolean z10) throws Throwable {
        nc.l lVar = z10 ? null : o3.h.f;
        y1.t tVar = new y1.t(10);
        v1.l0 l0VarT = null;
        int i10 = 0;
        while (true) {
            try {
                qVar.z(tVar.f14609a, 0, 10);
                tVar.J(0);
                if (tVar.A() != 4801587) {
                    break;
                }
                tVar.K(3);
                int iW = tVar.w();
                int i11 = iW + 10;
                if (l0VarT == null) {
                    byte[] bArr = new byte[i11];
                    System.arraycopy(tVar.f14609a, 0, bArr, 0, 10);
                    qVar.z(bArr, 10, iW);
                    l0VarT = new o3.h(lVar).T(i11, bArr);
                } else {
                    qVar.A(iW);
                }
                i10 += i11;
            } catch (EOFException unused) {
            }
        }
        qVar.k();
        qVar.A(i10);
        if (l0VarT == null || l0VarT.f12828a.length == 0) {
            return null;
        }
        return l0VarT;
    }

    public static int t(int i10, y1.t tVar) {
        switch (i10) {
            case 1:
                return 192;
            case 2:
            case 3:
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return 576 << (i10 - 2);
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return tVar.x() + 1;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return tVar.D() + 1;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i10 - 8);
            default:
                return -1;
        }
    }

    public static l4.c0 u(y1.t tVar) {
        tVar.K(1);
        int iA = tVar.A();
        long j4 = ((long) tVar.f14610b) + ((long) iA);
        int i10 = iA / 18;
        long[] jArrCopyOf = new long[i10];
        long[] jArrCopyOf2 = new long[i10];
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                break;
            }
            long jR = tVar.r();
            if (jR == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
                break;
            }
            jArrCopyOf[i11] = jR;
            jArrCopyOf2[i11] = tVar.r();
            tVar.K(2);
            i11++;
        }
        tVar.K((int) (j4 - ((long) tVar.f14610b)));
        return new l4.c0(2, jArrCopyOf, jArrCopyOf2);
    }

    public static pc.c v(y1.t tVar, boolean z10, boolean z11) throws n0 {
        if (z10) {
            x(3, tVar, false);
        }
        tVar.v((int) tVar.o(), StandardCharsets.UTF_8);
        long jO = tVar.o();
        String[] strArr = new String[(int) jO];
        for (int i10 = 0; i10 < jO; i10++) {
            strArr[i10] = tVar.v((int) tVar.o(), StandardCharsets.UTF_8);
        }
        if (z11 && (tVar.x() & 1) == 0) {
            throw n0.a(null, "framing bit expected to be set");
        }
        return new pc.c(strArr);
    }

    public static void w(k0 k0Var) throws n0 {
        int i10 = k0Var.i(6);
        if (i10 < 2 || i10 > 42) {
            throw n0.c(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(i10)));
        }
        k0Var.t(i10 * 8);
    }

    public static boolean x(int i10, y1.t tVar, boolean z10) throws n0 {
        if (tVar.a() < 7) {
            if (z10) {
                return false;
            }
            throw n0.a(null, "too short header: " + tVar.a());
        }
        if (tVar.x() != i10) {
            if (z10) {
                return false;
            }
            throw n0.a(null, "expected header type " + Integer.toHexString(i10));
        }
        if (tVar.x() == 118 && tVar.x() == 111 && tVar.x() == 114 && tVar.x() == 98 && tVar.x() == 105 && tVar.x() == 115) {
            return true;
        }
        if (z10) {
            return false;
        }
        throw n0.a(null, "expected characters 'vorbis'");
    }
}
