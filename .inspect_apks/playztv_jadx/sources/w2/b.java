package w2;

import android.util.Base64;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import n.a1;
import p1.l0;
import p1.n0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f13571a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f13572b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f13573c = {1, 2, 3, 6};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f13574d = {48000, 44100, 32000};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f13575e = {24000, 22050, 16000};
    public static final int[] f = {2, 1, 2, 3, 3, 4, 4, 5};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f13576g = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f13577h = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};
    public static final int[] i = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f13578j = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f13579k = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f13580l = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f13581m = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f13582n = {5, 8, 10, 12};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f13583o = {6, 9, 12, 15};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f13584p = {2, 4, 6, 8};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f13585q = {9, 11, 13, 16};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f13586r = {5, 8, 10, 12};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String[] f13587s = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int[] f13588t = {44100, 48000, 32000};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int[] f13589u = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int[] f13590v = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int[] f13591w = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f13592x = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f13593y = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static byte[] a(int i10, int i11, int i12) {
        return new byte[]{(byte) (((i10 << 3) & 248) | ((i11 >> 1) & 7)), (byte) (((i11 << 7) & 128) | ((i12 << 3) & 120))};
    }

    public static ArrayList b(byte[] bArr) {
        long j5 = (((long) (((bArr[11] & 255) << 8) | (bArr[10] & 255))) * 1000000000) / 48000;
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j5).array());
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(80000000L).array());
        return arrayList;
    }

    public static boolean c(s1.u uVar, u uVar2, int i10, s sVar) {
        long jZ = uVar.z();
        long j5 = jZ >>> 16;
        if (j5 != i10) {
            return false;
        }
        boolean z2 = (j5 & 1) == 1;
        int i11 = (int) ((jZ >> 12) & 15);
        int i12 = (int) ((jZ >> 8) & 15);
        int i13 = (int) ((jZ >> 4) & 15);
        int i14 = (int) ((jZ >> 1) & 7);
        boolean z10 = (jZ & 1) == 1;
        if (i13 <= 7) {
            if (i13 != uVar2.f13673g - 1) {
                return false;
            }
        } else if (i13 > 10 || uVar2.f13673g != 2) {
            return false;
        }
        if (!(i14 == 0 || i14 == uVar2.i) || z10) {
            return false;
        }
        try {
            long jE = uVar.E();
            if (!z2) {
                jE *= (long) uVar2.f13669b;
            }
            sVar.f13664a = jE;
            int iU = u(i11, uVar);
            if (iU == -1 || iU > uVar2.f13669b) {
                return false;
            }
            int i15 = uVar2.f13672e;
            if (i12 != 0) {
                if (i12 <= 11) {
                    if (i12 != uVar2.f) {
                        return false;
                    }
                } else if (i12 != 12) {
                    if (i12 > 14) {
                        return false;
                    }
                    int iD = uVar.D();
                    if (i12 == 14) {
                        iD *= 10;
                    }
                    if (iD != i15) {
                        return false;
                    }
                } else if (uVar.x() * 1000 != i15) {
                    return false;
                }
            }
            int iX = uVar.x();
            int i16 = uVar.f11710b;
            byte[] bArr = uVar.f11709a;
            int i17 = i16 - 1;
            int i18 = 0;
            for (int i19 = uVar.f11710b; i19 < i17; i19++) {
                i18 = s1.b0.f11658n[i18 ^ (bArr[i19] & 255)];
            }
            int i20 = s1.b0.f11647a;
            return iX == i18;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static void d(String str, boolean z2) throws n0 {
        if (!z2) {
            throw n0.a(null, str);
        }
    }

    public static void e(long j5, s1.u uVar, h0[] h0VarArr) {
        int i10;
        while (true) {
            if (uVar.a() <= 1) {
                return;
            }
            int i11 = 0;
            while (true) {
                if (uVar.a() == 0) {
                    i10 = -1;
                    break;
                }
                int iX = uVar.x();
                i11 += iX;
                if (iX != 255) {
                    i10 = i11;
                    break;
                }
            }
            int i12 = 0;
            while (true) {
                if (uVar.a() == 0) {
                    i12 = -1;
                    break;
                }
                int iX2 = uVar.x();
                i12 += iX2;
                if (iX2 != 255) {
                    break;
                }
            }
            int i13 = uVar.f11710b + i12;
            if (i12 == -1 || i12 > uVar.a()) {
                s1.b.p("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                i13 = uVar.f11711c;
            } else if (i10 == 4 && i12 >= 8) {
                int iX3 = uVar.x();
                int iD = uVar.D();
                int iJ = iD == 49 ? uVar.j() : 0;
                int iX4 = uVar.x();
                if (iD == 47) {
                    uVar.K(1);
                }
                boolean z2 = iX3 == 181 && (iD == 49 || iD == 47) && iX4 == 3;
                if (iD == 49) {
                    z2 &= iJ == 1195456820;
                }
                if (z2) {
                    f(j5, uVar, h0VarArr);
                }
            }
            uVar.J(i13);
        }
    }

    public static void f(long j5, s1.u uVar, h0[] h0VarArr) {
        int iX = uVar.x();
        if ((iX & 64) != 0) {
            uVar.K(1);
            int i10 = (iX & 31) * 3;
            int i11 = uVar.f11710b;
            for (h0 h0Var : h0VarArr) {
                uVar.J(i11);
                h0Var.f(i10, uVar);
                s1.d.g(j5 != -9223372036854775807L);
                h0Var.a(j5, 1, i10, 0, null);
            }
        }
    }

    public static int g(int i10, int i11) {
        int i12 = i11 / 2;
        if (i10 < 0 || i10 >= 3 || i11 < 0 || i12 >= 19) {
            return -1;
        }
        int i13 = f13574d[i10];
        if (i13 == 44100) {
            return ((i11 % 2) + f13577h[i12]) * 2;
        }
        int i14 = f13576g[i12];
        return i13 == 32000 ? i14 * 6 : i14 * 4;
    }

    public static void h(int i10, s1.u uVar) {
        uVar.G(7);
        byte[] bArr = uVar.f11709a;
        bArr[0] = -84;
        bArr[1] = 64;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = (byte) ((i10 >> 16) & 255);
        bArr[5] = (byte) ((i10 >> 8) & 255);
        bArr[6] = (byte) (i10 & 255);
    }

    public static int i(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if ((i10 & (-2097152)) != -2097152 || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0 || (i13 = (i10 >>> 12) & 15) == 0 || i13 == 15 || (i14 = (i10 >>> 10) & 3) == 3) {
            return -1;
        }
        int i15 = f13588t[i14];
        if (i11 == 2) {
            i15 /= 2;
        } else if (i11 == 0) {
            i15 /= 4;
        }
        int i16 = (i10 >>> 9) & 1;
        if (i12 == 3) {
            return ((((i11 == 3 ? f13589u[i13 - 1] : f13590v[i13 - 1]) * 12) / i15) + i16) * 4;
        }
        int i17 = i11 == 3 ? i12 == 2 ? f13591w[i13 - 1] : f13592x[i13 - 1] : f13593y[i13 - 1];
        if (i11 == 3) {
            return ((i17 * 144) / i15) + i16;
        }
        return (((i12 == 1 ? 72 : 144) * i17) / i15) + i16;
    }

    public static int j(int i10) {
        if (i10 == 20) {
            return 63750;
        }
        if (i10 == 30) {
            return 2250000;
        }
        switch (i10) {
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return 80000;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return 768000;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return 192000;
            case 8:
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

    public static s1.t k(byte[] bArr) {
        byte b10 = bArr[0];
        if (b10 == 127 || b10 == 100 || b10 == 64 || b10 == 113) {
            return new s1.t(bArr.length, bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        byte b11 = bArrCopyOf[0];
        if (b11 == -2 || b11 == -1 || b11 == 37 || b11 == -14 || b11 == -24) {
            for (int i10 = 0; i10 < bArrCopyOf.length - 1; i10 += 2) {
                byte b12 = bArrCopyOf[i10];
                int i11 = i10 + 1;
                bArrCopyOf[i10] = bArrCopyOf[i11];
                bArrCopyOf[i11] = b12;
            }
        }
        s1.t tVar = new s1.t(bArrCopyOf.length, bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            s1.t tVar2 = new s1.t(bArrCopyOf.length, bArrCopyOf);
            while (tVar2.b() >= 16) {
                tVar2.t(2);
                int i12 = tVar2.i(14) & 16383;
                int iMin = Math.min(8 - tVar.f11705d, 14);
                int i13 = tVar.f11705d;
                int i14 = (8 - i13) - iMin;
                byte[] bArr2 = tVar.f11703b;
                int i15 = tVar.f11704c;
                byte b13 = (byte) (((65280 >> i13) | ((1 << i14) - 1)) & bArr2[i15]);
                bArr2[i15] = b13;
                int i16 = 14 - iMin;
                bArr2[i15] = (byte) (b13 | ((i12 >>> i16) << i14));
                int i17 = i15 + 1;
                while (i16 > 8) {
                    tVar.f11703b[i17] = (byte) (i12 >>> (i16 - 8));
                    i16 -= 8;
                    i17++;
                }
                int i18 = 8 - i16;
                byte[] bArr3 = tVar.f11703b;
                byte b14 = (byte) (bArr3[i17] & ((1 << i18) - 1));
                bArr3[i17] = b14;
                bArr3[i17] = (byte) (((i12 & ((1 << i16) - 1)) << i18) | b14);
                tVar.t(14);
                tVar.a();
            }
        }
        tVar.o(bArrCopyOf.length, bArrCopyOf);
        return tVar;
    }

    public static long l(byte b10, byte b11) {
        int i10;
        int i11 = b10 & 255;
        int i12 = b10 & 3;
        if (i12 != 0) {
            i10 = 2;
            if (i12 != 1 && i12 != 2) {
                i10 = b11 & 63;
            }
        } else {
            i10 = 1;
        }
        int i13 = i11 >> 3;
        int i14 = i13 & 3;
        return ((long) i10) * ((long) (i13 >= 16 ? 2500 << i14 : i13 >= 12 ? 10000 << (i13 & 1) : i14 == 3 ? 60000 : 10000 << i14));
    }

    public static int m(s1.t tVar) throws n0 {
        int i10 = tVar.i(4);
        if (i10 == 15) {
            if (tVar.b() >= 24) {
                return tVar.i(24);
            }
            throw n0.a(null, "AAC header insufficient data");
        }
        if (i10 < 13) {
            return f13571a[i10];
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
    public static b8.d n(s1.t r9) {
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
            int[] r8 = w2.b.i
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
            b8.d r1 = new b8.d
            r1.<init>(r5, r0, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.b.n(s1.t):b8.d");
    }

    public static a o(s1.t tVar, boolean z2) throws n0 {
        int i10 = tVar.i(5);
        if (i10 == 31) {
            i10 = tVar.i(6) + 32;
        }
        int iM = m(tVar);
        int i11 = tVar.i(4);
        String strL = e6.j.l("mp4a.40.", i10);
        if (i10 == 5 || i10 == 29) {
            iM = m(tVar);
            int i12 = tVar.i(5);
            if (i12 == 31) {
                i12 = tVar.i(6) + 32;
            }
            i10 = i12;
            if (i10 == 22) {
                i11 = tVar.i(4);
            }
        }
        if (z2) {
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
            if (tVar.h()) {
                s1.b.p("AacUtil", "Unexpected frameLengthFlag = 1");
            }
            if (tVar.h()) {
                tVar.t(14);
            }
            boolean zH = tVar.h();
            if (i11 == 0) {
                throw new UnsupportedOperationException();
            }
            if (i10 == 6 || i10 == 20) {
                tVar.t(3);
            }
            if (zH) {
                if (i10 == 22) {
                    tVar.t(16);
                }
                if (i10 == 17 || i10 == 19 || i10 == 20 || i10 == 23) {
                    tVar.t(3);
                }
                tVar.t(1);
            }
            switch (i10) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int i13 = tVar.i(2);
                    if (i13 == 2 || i13 == 3) {
                        throw n0.c("Unsupported epConfig: " + i13);
                    }
                    break;
            }
        }
        int i14 = f13572b[i11];
        if (i14 != -1) {
            return new a(iM, i14, strL);
        }
        throw n0.a(null, null);
    }

    public static void p(s1.t tVar, c cVar) throws n0 {
        int i10 = tVar.i(5);
        tVar.t(2);
        if (tVar.h()) {
            tVar.t(5);
        }
        if (i10 >= 7 && i10 <= 10) {
            tVar.s();
        }
        if (tVar.h()) {
            int i11 = tVar.i(3);
            if (cVar.f13595b == -1 && i10 >= 0 && i10 <= 15 && (i11 == 0 || i11 == 1)) {
                cVar.f13595b = i10;
            }
            if (tVar.h()) {
                x(tVar);
            }
        }
    }

    public static void q(s1.t tVar, c cVar) throws n0 {
        tVar.t(2);
        boolean zH = tVar.h();
        int i10 = tVar.i(8);
        for (int i11 = 0; i11 < i10; i11++) {
            tVar.t(2);
            if (tVar.h()) {
                tVar.t(5);
            }
            if (zH) {
                tVar.t(24);
            } else {
                if (tVar.h()) {
                    if (!tVar.h()) {
                        tVar.t(4);
                    }
                    cVar.f13596c = tVar.i(6) + 1;
                }
                tVar.t(4);
            }
        }
        if (tVar.h()) {
            tVar.t(3);
            if (tVar.h()) {
                x(tVar);
            }
        }
    }

    public static int r(s1.t tVar, int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 3 && tVar.h(); i11++) {
            i10++;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            i12 += 1 << iArr[i13];
        }
        return tVar.i(iArr[i10]) + i12;
    }

    public static l0 s(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = (String) list.get(i10);
            int i11 = s1.b0.f11647a;
            String[] strArrSplit = str.split("=", 2);
            if (strArrSplit.length != 2) {
                s1.b.p("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (strArrSplit[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(i3.a.d(new s1.u(Base64.decode(strArrSplit[1], 0))));
                } catch (RuntimeException e10) {
                    s1.b.q("VorbisUtil", "Failed to parse vorbis picture", e10);
                }
            } else {
                arrayList.add(new n3.a(strArrSplit[0], strArrSplit[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new l0(arrayList);
    }

    public static l0 t(p pVar, boolean z2) throws Throwable {
        ia.b bVar = z2 ? null : k3.h.f6999e;
        s1.u uVar = new s1.u(10);
        l0 l0VarY = null;
        int i10 = 0;
        while (true) {
            try {
                pVar.w(uVar.f11709a, 0, 10);
                uVar.J(0);
                if (uVar.A() != 4801587) {
                    break;
                }
                uVar.K(3);
                int iW = uVar.w();
                int i11 = iW + 10;
                if (l0VarY == null) {
                    byte[] bArr = new byte[i11];
                    System.arraycopy(uVar.f11709a, 0, bArr, 0, 10);
                    pVar.w(bArr, 10, iW);
                    l0VarY = new k3.h(bVar).y(i11, bArr);
                } else {
                    pVar.B(iW);
                }
                i10 += i11;
            } catch (EOFException unused) {
            }
        }
        pVar.l();
        pVar.B(i10);
        if (l0VarY == null || l0VarY.f9896a.length == 0) {
            return null;
        }
        return l0VarY;
    }

    public static int u(int i10, s1.u uVar) {
        switch (i10) {
            case 1:
                return 192;
            case 2:
            case 3:
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return 576 << (i10 - 2);
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return uVar.x() + 1;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return uVar.D() + 1;
            case 8:
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

    public static p2.c v(s1.u uVar) {
        uVar.K(1);
        int iA = uVar.A();
        long j5 = ((long) uVar.f11710b) + ((long) iA);
        int i10 = iA / 18;
        long[] jArrCopyOf = new long[i10];
        long[] jArrCopyOf2 = new long[i10];
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                break;
            }
            long jR = uVar.r();
            if (jR == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
                break;
            }
            jArrCopyOf[i11] = jR;
            jArrCopyOf2[i11] = uVar.r();
            uVar.K(2);
            i11++;
        }
        uVar.K((int) (j5 - ((long) uVar.f11710b)));
        return new p2.c(jArrCopyOf, 22, jArrCopyOf2);
    }

    public static a1 w(s1.u uVar, boolean z2, boolean z10) throws n0 {
        if (z2) {
            y(3, uVar, false);
        }
        uVar.v((int) uVar.o(), StandardCharsets.UTF_8);
        long jO = uVar.o();
        String[] strArr = new String[(int) jO];
        for (int i10 = 0; i10 < jO; i10++) {
            strArr[i10] = uVar.v((int) uVar.o(), StandardCharsets.UTF_8);
        }
        if (z10 && (uVar.x() & 1) == 0) {
            throw n0.a(null, "framing bit expected to be set");
        }
        return new a1(strArr);
    }

    public static void x(s1.t tVar) throws n0 {
        int i10 = tVar.i(6);
        if (i10 < 2 || i10 > 42) {
            throw n0.c(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(i10)));
        }
        tVar.t(i10 * 8);
    }

    public static boolean y(int i10, s1.u uVar, boolean z2) throws n0 {
        if (uVar.a() < 7) {
            if (z2) {
                return false;
            }
            throw n0.a(null, "too short header: " + uVar.a());
        }
        if (uVar.x() != i10) {
            if (z2) {
                return false;
            }
            throw n0.a(null, "expected header type " + Integer.toHexString(i10));
        }
        if (uVar.x() == 118 && uVar.x() == 111 && uVar.x() == 114 && uVar.x() == 98 && uVar.x() == 105 && uVar.x() == 115) {
            return true;
        }
        if (z2) {
            return false;
        }
        throw n0.a(null, "expected characters 'vorbis'");
    }
}
