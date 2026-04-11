package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c6 implements j6 {
    public static final int[] i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Unsafe f2913j = n6.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f2914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f2915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u4 f2918e;
    public final int[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2920h;

    public c6(int[] iArr, Object[] objArr, int i10, int i11, u4 u4Var, int[] iArr2, int i12, int i13, k5 k5Var) {
        this.f2914a = iArr;
        this.f2915b = objArr;
        this.f2916c = i10;
        this.f2917d = i11;
        this.f = iArr2;
        this.f2919g = i12;
        this.f2920h = i13;
        this.f2918e = u4Var;
    }

    public static long A(long j5, Object obj) {
        return ((Long) n6.j(j5, obj)).longValue();
    }

    public static boolean E(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof j5) {
            return ((j5) obj).m();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.measurement.c6 l(com.google.android.gms.internal.measurement.i6 r34, com.google.android.gms.internal.measurement.k5 r35) {
        /*
            Method dump skipped, instruction units count: 1037
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.c6.l(com.google.android.gms.internal.measurement.i6, com.google.android.gms.internal.measurement.k5):com.google.android.gms.internal.measurement.c6");
    }

    public static Field o(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static int w(long j5, Object obj) {
        return ((Integer) n6.j(j5, obj)).intValue();
    }

    public final n5 B(int i10) {
        return (n5) this.f2915b[((i10 / 3) << 1) + 1];
    }

    public final j6 C(int i10) {
        int i11 = (i10 / 3) << 1;
        Object[] objArr = this.f2915b;
        j6 j6Var = (j6) objArr[i11];
        if (j6Var != null) {
            return j6Var;
        }
        j6 j6VarA = h6.f3037c.a((Class) objArr[i11 + 1]);
        objArr[i11] = j6VarA;
        return j6VarA;
    }

    public final Object D(int i10) {
        return this.f2915b[(i10 / 3) << 1];
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final j5 a() {
        return (j5) ((j5) this.f2918e).e(4);
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final boolean b(Object obj) {
        int i10;
        int i11;
        int i12;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i15 < this.f2919g) {
            int i16 = this.f[i15];
            int[] iArr = this.f2914a;
            int i17 = iArr[i16];
            int iV = v(i16);
            int i18 = iArr[i16 + 2];
            int i19 = i18 & 1048575;
            int i20 = 1 << (i18 >>> 20);
            if (i19 != i13) {
                if (i19 != 1048575) {
                    i14 = f2913j.getInt(obj, i19);
                }
                i11 = i16;
                i12 = i14;
                i10 = i19;
            } else {
                int i21 = i14;
                i10 = i13;
                i11 = i16;
                i12 = i21;
            }
            if ((268435456 & iV) == 0 || s(obj, i11, i10, i12, i20)) {
                int i22 = (267386880 & iV) >>> 20;
                if (i22 != 9 && i22 != 17) {
                    if (i22 != 27) {
                        if (i22 == 60 || i22 == 68) {
                            if (!x(i17, i11, obj) || C(i11).b(n6.j(iV & 1048575, obj))) {
                            }
                        } else if (i22 != 49) {
                            if (i22 == 50 && !((z5) n6.j(iV & 1048575, obj)).isEmpty()) {
                                if (D(i11) == null) {
                                    throw new NoSuchMethodError();
                                }
                                throw new ClassCastException();
                            }
                        }
                        i15++;
                        i13 = i10;
                        i14 = i12;
                    }
                    List list = (List) n6.j(iV & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        j6 j6VarC = C(i11);
                        for (int i23 = 0; i23 < list.size(); i23++) {
                            if (j6VarC.b(list.get(i23))) {
                            }
                        }
                    }
                    i15++;
                    i13 = i10;
                    i14 = i12;
                } else if (!s(obj, i11, i10, i12, i20) || C(i11).b(n6.j(iV & 1048575, obj))) {
                    i15++;
                    i13 = i10;
                    i14 = i12;
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8 A[PHI: r3
      0x00d8: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x01fd, B:41:0x00d6] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.measurement.j6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(com.google.android.gms.internal.measurement.j5 r12) {
        /*
            Method dump skipped, instruction units count: 764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.c6.c(com.google.android.gms.internal.measurement.j5):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    @Override // com.google.android.gms.internal.measurement.j6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.c6.d(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x0375  */
    @Override // com.google.android.gms.internal.measurement.j6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e(com.google.android.gms.internal.measurement.j5 r17) {
        /*
            Method dump skipped, instruction units count: 1916
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.c6.e(com.google.android.gms.internal.measurement.j5):int");
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final void f(Object obj, Object obj2) {
        Object obj3;
        if (!E(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
        obj2.getClass();
        int i10 = 0;
        while (true) {
            int[] iArr = this.f2914a;
            if (i10 >= iArr.length) {
                m4.f(obj, obj2);
                return;
            }
            int iV = v(i10);
            long j5 = iV & 1048575;
            int i11 = iArr[i10];
            switch ((iV & 267386880) >>> 20) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        m6 m6Var = n6.f3121c;
                        m6Var.d(obj3, j5, m6Var.a(j5, obj2));
                        t(i10, obj3);
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case 1:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        m6 m6Var2 = n6.f3121c;
                        m6Var2.e(obj3, j5, m6Var2.h(j5, obj2));
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case 2:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        m6 m6Var3 = n6.f3121c;
                        m6Var3.f(obj3, j5, m6Var3.k(j5, obj2));
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case 3:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        m6 m6Var4 = n6.f3121c;
                        m6Var4.f(obj3, j5, m6Var4.k(j5, obj2));
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        n6.b(n6.f3121c.j(j5, obj2), j5, obj3);
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        m6 m6Var5 = n6.f3121c;
                        m6Var5.f(obj3, j5, m6Var5.k(j5, obj2));
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        n6.b(n6.f3121c.j(j5, obj2), j5, obj3);
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        m6 m6Var6 = n6.f3121c;
                        m6Var6.g(obj3, j5, m6Var6.i(j5, obj2));
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case 8:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        n6.c(obj3, j5, n6.j(j5, obj2));
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case 9:
                    obj3 = obj;
                    r(obj3, obj2, i10);
                    continue;
                    i10 += 3;
                    obj = obj3;
                    break;
                case 10:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        n6.c(obj3, j5, n6.j(j5, obj2));
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case 11:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        n6.b(n6.f3121c.j(j5, obj2), j5, obj3);
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case 12:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        n6.b(n6.f3121c.j(j5, obj2), j5, obj3);
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case 13:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        n6.b(n6.f3121c.j(j5, obj2), j5, obj3);
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case 14:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        m6 m6Var7 = n6.f3121c;
                        m6Var7.f(obj3, j5, m6Var7.k(j5, obj2));
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case 15:
                    obj3 = obj;
                    if (y(i10, obj2)) {
                        n6.b(n6.f3121c.j(j5, obj2), j5, obj3);
                        t(i10, obj3);
                    } else {
                        continue;
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case 16:
                    if (y(i10, obj2)) {
                        m6 m6Var8 = n6.f3121c;
                        obj3 = obj;
                        m6Var8.f(obj3, j5, m6Var8.k(j5, obj2));
                        t(i10, obj3);
                    }
                    i10 += 3;
                    obj = obj3;
                    break;
                case 17:
                    r(obj, obj2, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    s5 s5VarC = (s5) n6.j(j5, obj);
                    s5 s5Var = (s5) n6.j(j5, obj2);
                    int size = s5VarC.size();
                    int size2 = s5Var.size();
                    if (size > 0 && size2 > 0) {
                        if (!((v4) s5VarC).f3217u) {
                            s5VarC = s5VarC.c(size2 + size);
                        }
                        s5VarC.addAll(s5Var);
                    }
                    if (size > 0) {
                        s5Var = s5VarC;
                    }
                    n6.c(obj, j5, s5Var);
                    break;
                case 50:
                    n6.c(obj, j5, g5.i(n6.j(j5, obj), n6.j(j5, obj2)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (x(i11, i10, obj2)) {
                        n6.c(obj, j5, n6.j(j5, obj2));
                        n6.b(i11, iArr[i10 + 2] & 1048575, obj);
                    }
                    break;
                case 60:
                    u(obj, i10, obj2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (x(i11, i10, obj2)) {
                        n6.c(obj, j5, n6.j(j5, obj2));
                        n6.b(i11, iArr[i10 + 2] & 1048575, obj);
                    }
                    break;
                case 68:
                    u(obj, i10, obj2);
                    break;
            }
            obj3 = obj;
            i10 += 3;
            obj = obj3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    @Override // com.google.android.gms.internal.measurement.j6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(com.google.android.gms.internal.measurement.j5 r12, com.google.android.gms.internal.measurement.j5 r13) {
        /*
            Method dump skipped, instruction units count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.c6.g(com.google.android.gms.internal.measurement.j5, com.google.android.gms.internal.measurement.j5):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final void h(Object obj, byte[] bArr, int i10, int i11, y4 y4Var) {
        k(obj, bArr, i10, i11, 0, y4Var);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063 A[PHI: r3 r4
      0x0063: PHI (r3v20 int) = 
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v3 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
      (r3v1 int)
     binds: [B:16:0x0060, B:267:0x0775, B:244:0x06cc, B:265:0x0755, B:260:0x0743, B:255:0x0713, B:250:0x06f5, B:241:0x06b9, B:242:0x06bb, B:238:0x0693, B:239:0x0695, B:235:0x0684, B:236:0x0686, B:232:0x0675, B:233:0x0677, B:229:0x0666, B:230:0x0668, B:226:0x0657, B:227:0x0659, B:223:0x0643, B:224:0x0645, B:220:0x062d, B:221:0x062f, B:217:0x061a, B:218:0x061c, B:207:0x0580, B:139:0x03f8, B:141:0x03fe, B:334:0x0063, B:131:0x03bc, B:133:0x03c2, B:333:0x0063, B:122:0x0355, B:121:0x0346, B:120:0x0337, B:119:0x0328, B:118:0x0319, B:117:0x030a, B:116:0x02fb, B:115:0x02ec, B:114:0x02dd, B:113:0x02ce, B:112:0x02bf, B:111:0x02b0, B:110:0x02a1, B:109:0x0292, B:102:0x0279, B:104:0x027f, B:332:0x0063, B:93:0x0257, B:90:0x023b, B:91:0x023d, B:87:0x021f, B:88:0x0221, B:84:0x0210, B:85:0x0212, B:81:0x0201, B:82:0x0203, B:78:0x01f2, B:79:0x01f4, B:75:0x01e3, B:76:0x01e5, B:72:0x01d4, B:73:0x01d6, B:69:0x01ba, B:70:0x01bc, B:46:0x0113, B:67:0x019b, B:62:0x0189, B:57:0x0159, B:52:0x013b, B:43:0x0100, B:44:0x0102, B:40:0x00db, B:41:0x00dd, B:37:0x00cd, B:38:0x00cf, B:34:0x00bf, B:35:0x00c1, B:31:0x00b1, B:32:0x00b3, B:28:0x00a3, B:29:0x00a5, B:25:0x0090, B:26:0x0092, B:22:0x007c, B:23:0x007e, B:19:0x006a, B:20:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x0063: PHI (r4v15 int) = 
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v5 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
      (r4v3 int)
     binds: [B:16:0x0060, B:267:0x0775, B:244:0x06cc, B:265:0x0755, B:260:0x0743, B:255:0x0713, B:250:0x06f5, B:241:0x06b9, B:242:0x06bb, B:238:0x0693, B:239:0x0695, B:235:0x0684, B:236:0x0686, B:232:0x0675, B:233:0x0677, B:229:0x0666, B:230:0x0668, B:226:0x0657, B:227:0x0659, B:223:0x0643, B:224:0x0645, B:220:0x062d, B:221:0x062f, B:217:0x061a, B:218:0x061c, B:207:0x0580, B:139:0x03f8, B:141:0x03fe, B:334:0x0063, B:131:0x03bc, B:133:0x03c2, B:333:0x0063, B:122:0x0355, B:121:0x0346, B:120:0x0337, B:119:0x0328, B:118:0x0319, B:117:0x030a, B:116:0x02fb, B:115:0x02ec, B:114:0x02dd, B:113:0x02ce, B:112:0x02bf, B:111:0x02b0, B:110:0x02a1, B:109:0x0292, B:102:0x0279, B:104:0x027f, B:332:0x0063, B:93:0x0257, B:90:0x023b, B:91:0x023d, B:87:0x021f, B:88:0x0221, B:84:0x0210, B:85:0x0212, B:81:0x0201, B:82:0x0203, B:78:0x01f2, B:79:0x01f4, B:75:0x01e3, B:76:0x01e5, B:72:0x01d4, B:73:0x01d6, B:69:0x01ba, B:70:0x01bc, B:46:0x0113, B:67:0x019b, B:62:0x0189, B:57:0x0159, B:52:0x013b, B:43:0x0100, B:44:0x0102, B:40:0x00db, B:41:0x00dd, B:37:0x00cd, B:38:0x00cf, B:34:0x00bf, B:35:0x00c1, B:31:0x00b1, B:32:0x00b3, B:28:0x00a3, B:29:0x00a5, B:25:0x0090, B:26:0x0092, B:22:0x007c, B:23:0x007e, B:19:0x006a, B:20:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.measurement.j6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.lang.Object r28, com.google.android.gms.internal.measurement.x5 r29) throws c6.c {
        /*
            Method dump skipped, instruction units count: 2212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.c6.i(java.lang.Object, com.google.android.gms.internal.measurement.x5):void");
    }

    public final int j(int i10, int i11) {
        int[] iArr = this.f2914a;
        int length = (iArr.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = iArr[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x02b8, code lost:
    
        throw com.google.android.gms.internal.measurement.r5.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0309, code lost:
    
        throw com.google.android.gms.internal.measurement.r5.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x036b, code lost:
    
        throw com.google.android.gms.internal.measurement.r5.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03c5, code lost:
    
        r14 = r20 | r27;
        r5 = r3;
        r3 = r1;
        r1 = r4;
        r4 = r5;
        r15 = r36;
        r5 = r37;
        r6 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f7, code lost:
    
        r5 = r37;
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fa, code lost:
    
        r3 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fb, code lost:
    
        r9 = r12;
        r8 = r13;
        r7 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01b0, code lost:
    
        r5 = r37;
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x020b, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:639:0x0ed8  */
    /* JADX WARN: Removed duplicated region for block: B:729:0x0f19 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:749:0x0bf4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:775:0x0be3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x026b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int k(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.measurement.y4 r39) {
        /*
            Method dump skipped, instruction units count: 4152
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.c6.k(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.y4):int");
    }

    public final Object m(int i10, int i11, Object obj) {
        j6 j6VarC = C(i11);
        if (!x(i10, i11, obj)) {
            return j6VarC.a();
        }
        Object object = f2913j.getObject(obj, v(i11) & 1048575);
        if (E(object)) {
            return object;
        }
        j5 j5VarA = j6VarC.a();
        if (object != null) {
            j6VarC.f(j5VarA, object);
        }
        return j5VarA;
    }

    public final Object n(int i10, Object obj) {
        j6 j6VarC = C(i10);
        long jV = v(i10) & 1048575;
        if (!y(i10, obj)) {
            return j6VarC.a();
        }
        Object object = f2913j.getObject(obj, jV);
        if (E(object)) {
            return object;
        }
        j5 j5VarA = j6VarC.a();
        if (object != null) {
            j6VarC.f(j5VarA, object);
        }
        return j5VarA;
    }

    public final void p(Object obj, int i10, Object obj2) {
        f2913j.putObject(obj, v(i10) & 1048575, obj2);
        t(i10, obj);
    }

    public final void q(Object obj, int i10, Object obj2, int i11) {
        f2913j.putObject(obj, v(i11) & 1048575, obj2);
        n6.b(i10, this.f2914a[i11 + 2] & 1048575, obj);
    }

    public final void r(Object obj, Object obj2, int i10) {
        if (y(i10, obj2)) {
            long jV = v(i10) & 1048575;
            Unsafe unsafe = f2913j;
            Object object = unsafe.getObject(obj2, jV);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f2914a[i10] + " is present but null: " + String.valueOf(obj2));
            }
            j6 j6VarC = C(i10);
            if (!y(i10, obj)) {
                if (E(object)) {
                    j5 j5VarA = j6VarC.a();
                    j6VarC.f(j5VarA, object);
                    unsafe.putObject(obj, jV, j5VarA);
                } else {
                    unsafe.putObject(obj, jV, object);
                }
                t(i10, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jV);
            if (!E(object2)) {
                j5 j5VarA2 = j6VarC.a();
                j6VarC.f(j5VarA2, object2);
                unsafe.putObject(obj, jV, j5VarA2);
                object2 = j5VarA2;
            }
            j6VarC.f(object2, object);
        }
    }

    public final boolean s(Object obj, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? y(i10, obj) : (i12 & i13) != 0;
    }

    public final void t(int i10, Object obj) {
        int i11 = this.f2914a[i10 + 2];
        long j5 = 1048575 & i11;
        if (j5 == 1048575) {
            return;
        }
        n6.b((1 << (i11 >>> 20)) | n6.f3121c.j(j5, obj), j5, obj);
    }

    public final void u(Object obj, int i10, Object obj2) {
        int[] iArr = this.f2914a;
        int i11 = iArr[i10];
        if (x(i11, i10, obj2)) {
            long jV = v(i10) & 1048575;
            Unsafe unsafe = f2913j;
            Object object = unsafe.getObject(obj2, jV);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i10] + " is present but null: " + String.valueOf(obj2));
            }
            j6 j6VarC = C(i10);
            if (!x(i11, i10, obj)) {
                if (E(object)) {
                    j5 j5VarA = j6VarC.a();
                    j6VarC.f(j5VarA, object);
                    unsafe.putObject(obj, jV, j5VarA);
                } else {
                    unsafe.putObject(obj, jV, object);
                }
                n6.b(i11, iArr[i10 + 2] & 1048575, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jV);
            if (!E(object2)) {
                j5 j5VarA2 = j6VarC.a();
                j6VarC.f(j5VarA2, object2);
                unsafe.putObject(obj, jV, j5VarA2);
                object2 = j5VarA2;
            }
            j6VarC.f(object2, object);
        }
    }

    public final int v(int i10) {
        return this.f2914a[i10 + 1];
    }

    public final boolean x(int i10, int i11, Object obj) {
        return n6.f3121c.j((long) (this.f2914a[i11 + 2] & 1048575), obj) == i10;
    }

    public final boolean y(int i10, Object obj) {
        int i11 = this.f2914a[i10 + 2];
        long j5 = i11 & 1048575;
        if (j5 == 1048575) {
            int iV = v(i10);
            long j8 = iV & 1048575;
            switch ((iV & 267386880) >>> 20) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    if (Double.doubleToRawLongBits(n6.f3121c.a(j8, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(n6.f3121c.h(j8, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (n6.f3121c.k(j8, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (n6.f3121c.k(j8, obj) == 0) {
                        return false;
                    }
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    if (n6.f3121c.j(j8, obj) == 0) {
                        return false;
                    }
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    if (n6.f3121c.k(j8, obj) == 0) {
                        return false;
                    }
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    if (n6.f3121c.j(j8, obj) == 0) {
                        return false;
                    }
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    return n6.f3121c.i(j8, obj);
                case 8:
                    Object objJ = n6.j(j8, obj);
                    if (objJ instanceof String) {
                        if (((String) objJ).isEmpty()) {
                            return false;
                        }
                    } else {
                        if (!(objJ instanceof a5)) {
                            throw new IllegalArgumentException();
                        }
                        if (a5.f2884w.equals(objJ)) {
                            return false;
                        }
                    }
                case 9:
                    if (n6.j(j8, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    if (a5.f2884w.equals(n6.j(j8, obj))) {
                        return false;
                    }
                    break;
                case 11:
                    if (n6.f3121c.j(j8, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (n6.f3121c.j(j8, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (n6.f3121c.j(j8, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (n6.f3121c.k(j8, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (n6.f3121c.j(j8, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (n6.f3121c.k(j8, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (n6.j(j8, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i11 >>> 20)) & n6.f3121c.j(j5, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean z(j5 j5Var, j5 j5Var2, int i10) {
        return y(i10, j5Var) == y(i10, j5Var2);
    }
}
