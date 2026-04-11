package androidx.datastore.preferences.protobuf;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements b1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f1111o = new int[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Unsafe f1112p = s1.i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f1113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f1114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f1117e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f1119h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u0 f1121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h0 f1122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k1 f1123m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final o0 f1124n;

    public s0(int[] iArr, Object[] objArr, int i, int i10, a aVar, boolean z2, int[] iArr2, int i11, int i12, u0 u0Var, h0 h0Var, k1 k1Var, o oVar, o0 o0Var) {
        this.f1113a = iArr;
        this.f1114b = objArr;
        this.f1115c = i;
        this.f1116d = i10;
        this.f = aVar instanceof w;
        this.f1118g = z2;
        this.f1119h = iArr2;
        this.i = i11;
        this.f1120j = i12;
        this.f1121k = u0Var;
        this.f1122l = h0Var;
        this.f1123m = k1Var;
        this.f1117e = aVar;
        this.f1124n = o0Var;
    }

    public static long A(long j5, Object obj) {
        return ((Long) s1.f1128d.i(j5, obj)).longValue();
    }

    public static Field D(Class cls, String str) {
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

    public static int G(int i) {
        return (i & 267386880) >>> 20;
    }

    public static void K(int i, Object obj, k0 k0Var) throws IOException {
        if (!(obj instanceof String)) {
            k0Var.a(i, (g) obj);
        } else {
            ((k) k0Var.f1082a).P((String) obj, i);
        }
    }

    public static List s(long j5, Object obj) {
        return (List) s1.f1128d.i(j5, obj);
    }

    public static s0 w(a1 a1Var, u0 u0Var, h0 h0Var, k1 k1Var, o oVar, o0 o0Var) {
        if (a1Var instanceof a1) {
            return x(a1Var, u0Var, h0Var, k1Var, oVar, o0Var);
        }
        a1Var.getClass();
        throw new ClassCastException();
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.datastore.preferences.protobuf.s0 x(androidx.datastore.preferences.protobuf.a1 r35, androidx.datastore.preferences.protobuf.u0 r36, androidx.datastore.preferences.protobuf.h0 r37, androidx.datastore.preferences.protobuf.k1 r38, androidx.datastore.preferences.protobuf.o r39, androidx.datastore.preferences.protobuf.o0 r40) {
        /*
            Method dump skipped, instruction units count: 1041
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.s0.x(androidx.datastore.preferences.protobuf.a1, androidx.datastore.preferences.protobuf.u0, androidx.datastore.preferences.protobuf.h0, androidx.datastore.preferences.protobuf.k1, androidx.datastore.preferences.protobuf.o, androidx.datastore.preferences.protobuf.o0):androidx.datastore.preferences.protobuf.s0");
    }

    public static long y(int i) {
        return i & 1048575;
    }

    public static int z(long j5, Object obj) {
        return ((Integer) s1.f1128d.i(j5, obj)).intValue();
    }

    public final void B(Object obj, int i, i iVar, b1 b1Var, n nVar) throws a0 {
        int iZ;
        List listC = this.f1122l.c(i & 1048575, obj);
        h hVar = (h) iVar.f1067d;
        int i10 = iVar.f1064a;
        if ((i10 & 7) != 2) {
            throw b0.b();
        }
        do {
            listC.add(iVar.A(b1Var, nVar));
            if (hVar.c() || iVar.f1066c != 0) {
                return;
            } else {
                iZ = hVar.z();
            }
        } while (iZ == i10);
        iVar.f1066c = iZ;
    }

    public final void C(Object obj, int i, i iVar) {
        if ((536870912 & i) != 0) {
            s1.o(obj, i & 1048575, iVar.M());
        } else if (this.f) {
            s1.o(obj, i & 1048575, iVar.K());
        } else {
            s1.o(obj, i & 1048575, iVar.g());
        }
    }

    public final void E(int i, Object obj) {
        if (this.f1118g) {
            return;
        }
        int i10 = this.f1113a[i + 2];
        long j5 = i10 & 1048575;
        s1.m(s1.f1128d.g(j5, obj) | (1 << (i10 >>> 20)), j5, obj);
    }

    public final void F(int i, int i10, Object obj) {
        s1.m(i, this.f1113a[i10 + 2] & 1048575, obj);
    }

    public final int H(int i) {
        return this.f1113a[i + 1];
    }

    public final void I(Object obj, k0 k0Var) throws IOException {
        int i;
        int i10;
        int i11;
        int i12;
        boolean z2;
        int[] iArr = this.f1113a;
        int length = iArr.length;
        Unsafe unsafe = f1112p;
        int i13 = -1;
        int i14 = 0;
        for (int i15 = 0; i15 < length; i15 = i12 + 3) {
            int iH = H(i15);
            int i16 = iArr[i15];
            int iG = G(iH);
            if (this.f1118g || iG > 17) {
                i = i15;
                i10 = 1048575;
                i11 = 0;
            } else {
                int i17 = iArr[i15 + 2];
                i10 = 1048575;
                int i18 = i17 & 1048575;
                i = i15;
                if (i18 != i13) {
                    i14 = unsafe.getInt(obj, i18);
                    i13 = i18;
                }
                i11 = 1 << (i17 >>> 20);
            }
            long j5 = iH & i10;
            switch (iG) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        double dE = s1.f1128d.e(j5, obj);
                        k kVar = (k) k0Var.f1082a;
                        kVar.getClass();
                        kVar.K(i16, Double.doubleToRawLongBits(dE));
                    }
                    break;
                case 1:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        float f = s1.f1128d.f(j5, obj);
                        k kVar2 = (k) k0Var.f1082a;
                        kVar2.getClass();
                        kVar2.I(i16, Float.floatToRawIntBits(f));
                    }
                    break;
                case 2:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        ((k) k0Var.f1082a).U(i16, unsafe.getLong(obj, j5));
                    }
                    break;
                case 3:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        ((k) k0Var.f1082a).U(i16, unsafe.getLong(obj, j5));
                    }
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        ((k) k0Var.f1082a).M(i16, unsafe.getInt(obj, j5));
                    }
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        ((k) k0Var.f1082a).K(i16, unsafe.getLong(obj, j5));
                    }
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        ((k) k0Var.f1082a).I(i16, unsafe.getInt(obj, j5));
                    }
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        ((k) k0Var.f1082a).F(i16, s1.f1128d.c(j5, obj));
                    }
                    break;
                case 8:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        K(i16, unsafe.getObject(obj, j5), k0Var);
                    }
                    break;
                case 9:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        ((k) k0Var.f1082a).O(i16, (a) unsafe.getObject(obj, j5), n(i12));
                    }
                    break;
                case 10:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        k0Var.a(i16, (g) unsafe.getObject(obj, j5));
                    }
                    break;
                case 11:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        ((k) k0Var.f1082a).S(i16, unsafe.getInt(obj, j5));
                    }
                    break;
                case 12:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        ((k) k0Var.f1082a).M(i16, unsafe.getInt(obj, j5));
                    }
                    break;
                case 13:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        ((k) k0Var.f1082a).I(i16, unsafe.getInt(obj, j5));
                    }
                    break;
                case 14:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        ((k) k0Var.f1082a).K(i16, unsafe.getLong(obj, j5));
                    }
                    break;
                case 15:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        int i19 = unsafe.getInt(obj, j5);
                        ((k) k0Var.f1082a).S(i16, (i19 >> 31) ^ (i19 << 1));
                    }
                    break;
                case 16:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        long j8 = unsafe.getLong(obj, j5);
                        ((k) k0Var.f1082a).U(i16, (j8 >> 63) ^ (j8 << 1));
                    }
                    break;
                case 17:
                    i12 = i;
                    if ((i11 & i14) != 0) {
                        k0Var.b(i16, unsafe.getObject(obj, j5), n(i12));
                    }
                    break;
                case 18:
                    i12 = i;
                    c1.A(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 19:
                    i12 = i;
                    c1.E(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 20:
                    i12 = i;
                    c1.H(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 21:
                    i12 = i;
                    c1.P(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 22:
                    i12 = i;
                    c1.G(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 23:
                    i12 = i;
                    c1.D(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 24:
                    i12 = i;
                    c1.C(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 25:
                    i12 = i;
                    c1.y(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 26:
                    i12 = i;
                    c1.N(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var);
                    break;
                case 27:
                    i12 = i;
                    c1.I(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, n(i12));
                    break;
                case 28:
                    i12 = i;
                    c1.z(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var);
                    break;
                case 29:
                    i12 = i;
                    z2 = false;
                    c1.O(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 30:
                    i12 = i;
                    z2 = false;
                    c1.B(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 31:
                    i12 = i;
                    z2 = false;
                    c1.J(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 32:
                    i12 = i;
                    z2 = false;
                    c1.K(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 33:
                    i12 = i;
                    z2 = false;
                    c1.L(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 34:
                    i12 = i;
                    z2 = false;
                    c1.M(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, false);
                    break;
                case 35:
                    i12 = i;
                    c1.A(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 36:
                    i12 = i;
                    c1.E(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 37:
                    i12 = i;
                    c1.H(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 38:
                    i12 = i;
                    c1.P(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 39:
                    i12 = i;
                    c1.G(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 40:
                    i12 = i;
                    c1.D(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 41:
                    i12 = i;
                    c1.C(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 42:
                    i12 = i;
                    c1.y(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 43:
                    i12 = i;
                    c1.O(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 44:
                    i12 = i;
                    c1.B(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 45:
                    i12 = i;
                    c1.J(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 46:
                    i12 = i;
                    c1.K(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 47:
                    i12 = i;
                    c1.L(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 48:
                    i12 = i;
                    c1.M(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, true);
                    break;
                case 49:
                    i12 = i;
                    c1.F(iArr[i12], (List) unsafe.getObject(obj, j5), k0Var, n(i12));
                    break;
                case 50:
                    i12 = i;
                    J(k0Var, i16, unsafe.getObject(obj, j5), i12);
                    break;
                case 51:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        double dDoubleValue = ((Double) s1.f1128d.i(j5, obj)).doubleValue();
                        k kVar3 = (k) k0Var.f1082a;
                        kVar3.getClass();
                        kVar3.K(i16, Double.doubleToRawLongBits(dDoubleValue));
                    }
                    break;
                case 52:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        float fFloatValue = ((Float) s1.f1128d.i(j5, obj)).floatValue();
                        k kVar4 = (k) k0Var.f1082a;
                        kVar4.getClass();
                        kVar4.I(i16, Float.floatToRawIntBits(fFloatValue));
                    }
                    break;
                case 53:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        ((k) k0Var.f1082a).U(i16, A(j5, obj));
                    }
                    break;
                case 54:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        ((k) k0Var.f1082a).U(i16, A(j5, obj));
                    }
                    break;
                case 55:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        ((k) k0Var.f1082a).M(i16, z(j5, obj));
                    }
                    break;
                case 56:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        ((k) k0Var.f1082a).K(i16, A(j5, obj));
                    }
                    break;
                case 57:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        ((k) k0Var.f1082a).I(i16, z(j5, obj));
                    }
                    break;
                case 58:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        ((k) k0Var.f1082a).F(i16, ((Boolean) s1.f1128d.i(j5, obj)).booleanValue());
                    }
                    break;
                case 59:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        K(i16, unsafe.getObject(obj, j5), k0Var);
                    }
                    break;
                case 60:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        ((k) k0Var.f1082a).O(i16, (a) unsafe.getObject(obj, j5), n(i12));
                    }
                    break;
                case 61:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        k0Var.a(i16, (g) unsafe.getObject(obj, j5));
                    }
                    break;
                case 62:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        ((k) k0Var.f1082a).S(i16, z(j5, obj));
                    }
                    break;
                case 63:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        ((k) k0Var.f1082a).M(i16, z(j5, obj));
                    }
                    break;
                case 64:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        ((k) k0Var.f1082a).I(i16, z(j5, obj));
                    }
                    break;
                case 65:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        ((k) k0Var.f1082a).K(i16, A(j5, obj));
                    }
                    break;
                case 66:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        int iZ = z(j5, obj);
                        ((k) k0Var.f1082a).S(i16, (iZ >> 31) ^ (iZ << 1));
                    }
                    break;
                case 67:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        long jA = A(j5, obj);
                        ((k) k0Var.f1082a).U(i16, (jA >> 63) ^ (jA << 1));
                    }
                    break;
                case 68:
                    i12 = i;
                    if (r(i16, i12, obj)) {
                        k0Var.b(i16, unsafe.getObject(obj, j5), n(i12));
                    }
                    break;
                default:
                    i12 = i;
                    break;
            }
        }
        this.f1123m.getClass();
        ((w) obj).unknownFields.d(k0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0148 A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(androidx.datastore.preferences.protobuf.k0 r23, int r24, java.lang.Object r25, int r26) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.s0.J(androidx.datastore.preferences.protobuf.k0, int, java.lang.Object, int):void");
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final void a(Object obj, k0 k0Var) throws IOException {
        k0Var.getClass();
        k kVar = (k) k0Var.f1082a;
        if (!this.f1118g) {
            I(obj, k0Var);
            return;
        }
        int[] iArr = this.f1113a;
        int length = iArr.length;
        for (int i = 0; i < length; i += 3) {
            int iH = H(i);
            int i10 = iArr[i];
            switch (G(iH)) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    if (q(i, obj)) {
                        double dE = s1.f1128d.e(iH & 1048575, obj);
                        kVar.getClass();
                        kVar.K(i10, Double.doubleToRawLongBits(dE));
                    }
                    break;
                case 1:
                    if (q(i, obj)) {
                        float f = s1.f1128d.f(iH & 1048575, obj);
                        kVar.getClass();
                        kVar.I(i10, Float.floatToRawIntBits(f));
                    }
                    break;
                case 2:
                    if (q(i, obj)) {
                        kVar.U(i10, s1.f1128d.h(iH & 1048575, obj));
                    }
                    break;
                case 3:
                    if (q(i, obj)) {
                        kVar.U(i10, s1.f1128d.h(iH & 1048575, obj));
                    }
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    if (q(i, obj)) {
                        kVar.M(i10, s1.f1128d.g(iH & 1048575, obj));
                    }
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    if (q(i, obj)) {
                        kVar.K(i10, s1.f1128d.h(iH & 1048575, obj));
                    }
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    if (q(i, obj)) {
                        kVar.I(i10, s1.f1128d.g(iH & 1048575, obj));
                    }
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    if (q(i, obj)) {
                        kVar.F(i10, s1.f1128d.c(iH & 1048575, obj));
                    }
                    break;
                case 8:
                    if (q(i, obj)) {
                        K(i10, s1.f1128d.i(iH & 1048575, obj), k0Var);
                    }
                    break;
                case 9:
                    if (q(i, obj)) {
                        kVar.O(i10, (a) s1.f1128d.i(iH & 1048575, obj), n(i));
                    }
                    break;
                case 10:
                    if (q(i, obj)) {
                        k0Var.a(i10, (g) s1.f1128d.i(iH & 1048575, obj));
                    }
                    break;
                case 11:
                    if (q(i, obj)) {
                        kVar.S(i10, s1.f1128d.g(iH & 1048575, obj));
                    }
                    break;
                case 12:
                    if (q(i, obj)) {
                        kVar.M(i10, s1.f1128d.g(iH & 1048575, obj));
                    }
                    break;
                case 13:
                    if (q(i, obj)) {
                        kVar.I(i10, s1.f1128d.g(iH & 1048575, obj));
                    }
                    break;
                case 14:
                    if (q(i, obj)) {
                        kVar.K(i10, s1.f1128d.h(iH & 1048575, obj));
                    }
                    break;
                case 15:
                    if (q(i, obj)) {
                        int iG = s1.f1128d.g(iH & 1048575, obj);
                        kVar.S(i10, (iG >> 31) ^ (iG << 1));
                    }
                    break;
                case 16:
                    if (q(i, obj)) {
                        long jH = s1.f1128d.h(iH & 1048575, obj);
                        kVar.U(i10, (jH >> 63) ^ (jH << 1));
                    }
                    break;
                case 17:
                    if (q(i, obj)) {
                        k0Var.b(i10, s1.f1128d.i(iH & 1048575, obj), n(i));
                    }
                    break;
                case 18:
                    c1.A(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 19:
                    c1.E(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 20:
                    c1.H(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 21:
                    c1.P(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 22:
                    c1.G(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 23:
                    c1.D(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 24:
                    c1.C(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 25:
                    c1.y(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 26:
                    c1.N(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var);
                    break;
                case 27:
                    c1.I(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, n(i));
                    break;
                case 28:
                    c1.z(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var);
                    break;
                case 29:
                    c1.O(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 30:
                    c1.B(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 31:
                    c1.J(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 32:
                    c1.K(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 33:
                    c1.L(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 34:
                    c1.M(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, false);
                    break;
                case 35:
                    c1.A(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 36:
                    c1.E(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 37:
                    c1.H(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 38:
                    c1.P(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 39:
                    c1.G(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 40:
                    c1.D(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 41:
                    c1.C(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 42:
                    c1.y(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 43:
                    c1.O(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 44:
                    c1.B(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 45:
                    c1.J(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 46:
                    c1.K(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 47:
                    c1.L(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 48:
                    c1.M(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, true);
                    break;
                case 49:
                    c1.F(iArr[i], (List) s1.f1128d.i(iH & 1048575, obj), k0Var, n(i));
                    break;
                case 50:
                    J(k0Var, i10, s1.f1128d.i(iH & 1048575, obj), i);
                    break;
                case 51:
                    if (r(i10, i, obj)) {
                        double dDoubleValue = ((Double) s1.f1128d.i(iH & 1048575, obj)).doubleValue();
                        kVar.getClass();
                        kVar.K(i10, Double.doubleToRawLongBits(dDoubleValue));
                    }
                    break;
                case 52:
                    if (r(i10, i, obj)) {
                        float fFloatValue = ((Float) s1.f1128d.i(iH & 1048575, obj)).floatValue();
                        kVar.getClass();
                        kVar.I(i10, Float.floatToRawIntBits(fFloatValue));
                    }
                    break;
                case 53:
                    if (r(i10, i, obj)) {
                        kVar.U(i10, A(iH & 1048575, obj));
                    }
                    break;
                case 54:
                    if (r(i10, i, obj)) {
                        kVar.U(i10, A(iH & 1048575, obj));
                    }
                    break;
                case 55:
                    if (r(i10, i, obj)) {
                        kVar.M(i10, z(iH & 1048575, obj));
                    }
                    break;
                case 56:
                    if (r(i10, i, obj)) {
                        kVar.K(i10, A(iH & 1048575, obj));
                    }
                    break;
                case 57:
                    if (r(i10, i, obj)) {
                        kVar.I(i10, z(iH & 1048575, obj));
                    }
                    break;
                case 58:
                    if (r(i10, i, obj)) {
                        kVar.F(i10, ((Boolean) s1.f1128d.i(iH & 1048575, obj)).booleanValue());
                    }
                    break;
                case 59:
                    if (r(i10, i, obj)) {
                        K(i10, s1.f1128d.i(iH & 1048575, obj), k0Var);
                    }
                    break;
                case 60:
                    if (r(i10, i, obj)) {
                        kVar.O(i10, (a) s1.f1128d.i(iH & 1048575, obj), n(i));
                    }
                    break;
                case 61:
                    if (r(i10, i, obj)) {
                        k0Var.a(i10, (g) s1.f1128d.i(iH & 1048575, obj));
                    }
                    break;
                case 62:
                    if (r(i10, i, obj)) {
                        kVar.S(i10, z(iH & 1048575, obj));
                    }
                    break;
                case 63:
                    if (r(i10, i, obj)) {
                        kVar.M(i10, z(iH & 1048575, obj));
                    }
                    break;
                case 64:
                    if (r(i10, i, obj)) {
                        kVar.I(i10, z(iH & 1048575, obj));
                    }
                    break;
                case 65:
                    if (r(i10, i, obj)) {
                        kVar.K(i10, A(iH & 1048575, obj));
                    }
                    break;
                case 66:
                    if (r(i10, i, obj)) {
                        int iZ = z(iH & 1048575, obj);
                        kVar.S(i10, (iZ >> 31) ^ (iZ << 1));
                    }
                    break;
                case 67:
                    if (r(i10, i, obj)) {
                        long jA = A(iH & 1048575, obj);
                        kVar.U(i10, (jA >> 63) ^ (jA << 1));
                    }
                    break;
                case 68:
                    if (r(i10, i, obj)) {
                        k0Var.b(i10, s1.f1128d.i(iH & 1048575, obj), n(i));
                    }
                    break;
            }
        }
        this.f1123m.getClass();
        ((w) obj).unknownFields.d(k0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x0216, B:41:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.datastore.preferences.protobuf.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(androidx.datastore.preferences.protobuf.w r12) {
        /*
            Method dump skipped, instruction units count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.s0.b(androidx.datastore.preferences.protobuf.w):int");
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final void c(Object obj) {
        int[] iArr;
        int i;
        int i10 = this.i;
        while (true) {
            iArr = this.f1119h;
            i = this.f1120j;
            if (i10 >= i) {
                break;
            }
            long jH = H(iArr[i10]) & 1048575;
            Object objI = s1.f1128d.i(jH, obj);
            if (objI != null) {
                this.f1124n.getClass();
                ((n0) objI).f1093u = false;
                s1.o(obj, jH, objI);
            }
            i10++;
        }
        int length = iArr.length;
        while (i < length) {
            this.f1122l.a(iArr[i], obj);
            i++;
        }
        this.f1123m.getClass();
        ((w) obj).unknownFields.f1075e = false;
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final int d(a aVar) {
        return this.f1118g ? p(aVar) : o(aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    @Override // androidx.datastore.preferences.protobuf.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.s0.e(java.lang.Object):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    @Override // androidx.datastore.preferences.protobuf.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(androidx.datastore.preferences.protobuf.w r12, androidx.datastore.preferences.protobuf.w r13) {
        /*
            Method dump skipped, instruction units count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.s0.f(androidx.datastore.preferences.protobuf.w, androidx.datastore.preferences.protobuf.w):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:230:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b8, code lost:
    
        ((androidx.datastore.preferences.protobuf.w) r2).unknownFields = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0608 A[Catch: all -> 0x039e, TryCatch #11 {all -> 0x039e, blocks: (B:165:0x0603, B:167:0x0608, B:169:0x060f, B:171:0x0616, B:116:0x0388, B:117:0x0391, B:120:0x03a1, B:121:0x03b2, B:122:0x03c3, B:123:0x03d4, B:124:0x03e5, B:125:0x03f6, B:126:0x0407, B:127:0x0418, B:128:0x0429, B:130:0x0434, B:131:0x0453, B:132:0x0467, B:133:0x047c, B:134:0x0491, B:135:0x04a6, B:136:0x04bb, B:137:0x04d3, B:138:0x04e8, B:139:0x04fd, B:141:0x0508, B:142:0x0527, B:143:0x053b, B:144:0x0548, B:145:0x055f, B:146:0x0574, B:147:0x0589, B:148:0x059e, B:149:0x05b3, B:150:0x05c8, B:151:0x05de, B:157:0x05f4), top: B:202:0x0603 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x004b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x061c A[SYNTHETIC] */
    @Override // androidx.datastore.preferences.protobuf.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(java.lang.Object r19, androidx.datastore.preferences.protobuf.i r20, androidx.datastore.preferences.protobuf.n r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1754
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.s0.g(java.lang.Object, androidx.datastore.preferences.protobuf.i, androidx.datastore.preferences.protobuf.n):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    @Override // androidx.datastore.preferences.protobuf.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(androidx.datastore.preferences.protobuf.w r11, androidx.datastore.preferences.protobuf.w r12) {
        /*
            Method dump skipped, instruction units count: 592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.s0.h(androidx.datastore.preferences.protobuf.w, androidx.datastore.preferences.protobuf.w):void");
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final Object i() {
        this.f1121k.getClass();
        return ((w) this.f1117e).d(4);
    }

    public final boolean j(w wVar, Object obj, int i) {
        return q(i, wVar) == q(i, obj);
    }

    public final void k(Object obj, int i, Object obj2) {
        int i10 = this.f1113a[i];
        if (s1.f1128d.i(H(i) & 1048575, obj) == null) {
            return;
        }
        l(i);
    }

    public final void l(int i) {
        if (this.f1114b[((i / 3) * 2) + 1] != null) {
            throw new ClassCastException();
        }
    }

    public final Object m(int i) {
        return this.f1114b[(i / 3) * 2];
    }

    public final b1 n(int i) {
        int i10 = (i / 3) * 2;
        Object[] objArr = this.f1114b;
        b1 b1Var = (b1) objArr[i10];
        if (b1Var != null) {
            return b1Var;
        }
        b1 b1VarA = y0.f1144c.a((Class) objArr[i10 + 1]);
        objArr[i10] = b1VarA;
        return b1VarA;
    }

    public final int o(Object obj) {
        int i;
        int iY;
        int iA;
        int iY2;
        int iW;
        int iU;
        int iY3;
        int iX;
        int iJ;
        int iY4;
        int iV;
        Unsafe unsafe = f1112p;
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int[] iArr = this.f1113a;
            if (i11 >= iArr.length) {
                this.f1123m.getClass();
                return ((w) obj).unknownFields.a() + i12;
            }
            int iH = H(i11);
            int i14 = iArr[i11];
            int iG = G(iH);
            if (iG <= 17) {
                int i15 = iArr[i11 + 2];
                int i16 = i15 & 1048575;
                i = 1 << (i15 >>> 20);
                if (i16 != i10) {
                    i13 = unsafe.getInt(obj, i16);
                    i10 = i16;
                }
            } else {
                i = 0;
            }
            long j5 = iH & 1048575;
            switch (iG) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    if ((i & i13) != 0) {
                        i12 = l4.a.i(i14, 8, i12);
                    }
                    break;
                case 1:
                    if ((i13 & i) != 0) {
                        i12 = l4.a.i(i14, 4, i12);
                    }
                    break;
                case 2:
                    if ((i13 & i) != 0) {
                        long j8 = unsafe.getLong(obj, j5);
                        iY = k.y(i14);
                        iA = k.A(j8);
                        iY4 = iA + iY;
                        i12 += iY4;
                    }
                    break;
                case 3:
                    if ((i13 & i) != 0) {
                        long j10 = unsafe.getLong(obj, j5);
                        iY = k.y(i14);
                        iA = k.A(j10);
                        iY4 = iA + iY;
                        i12 += iY4;
                    }
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    if ((i13 & i) != 0) {
                        int i17 = unsafe.getInt(obj, j5);
                        iY2 = k.y(i14);
                        iW = k.w(i17);
                        iU = iW + iY2;
                        i12 += iU;
                    }
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    if ((i13 & i) != 0) {
                        iU = k.u(i14);
                        i12 += iU;
                    }
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    if ((i13 & i) != 0) {
                        iU = k.t(i14);
                        i12 += iU;
                    }
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    if ((i13 & i) != 0) {
                        i12 = l4.a.i(i14, 1, i12);
                    }
                    break;
                case 8:
                    if ((i13 & i) != 0) {
                        Object object = unsafe.getObject(obj, j5);
                        if (object instanceof g) {
                            int iY5 = k.y(i14);
                            int size = ((g) object).size();
                            iJ = l4.a.j(size, size, iY5, i12);
                            i12 = iJ;
                        } else {
                            iY3 = k.y(i14);
                            iX = k.x((String) object);
                            iJ = iX + iY3 + i12;
                            i12 = iJ;
                        }
                    }
                    break;
                case 9:
                    if ((i13 & i) != 0) {
                        Object object2 = unsafe.getObject(obj, j5);
                        b1 b1VarN = n(i11);
                        Class cls = c1.f1026a;
                        int iY6 = k.y(i14);
                        int iB = ((a) object2).b(b1VarN);
                        i12 = l4.a.j(iB, iB, iY6, i12);
                    }
                    break;
                case 10:
                    if ((i13 & i) != 0) {
                        iU = k.r(i14, (g) unsafe.getObject(obj, j5));
                        i12 += iU;
                    }
                    break;
                case 11:
                    if ((i13 & i) != 0) {
                        int i18 = unsafe.getInt(obj, j5);
                        iY2 = k.y(i14);
                        iW = k.z(i18);
                        iU = iW + iY2;
                        i12 += iU;
                    }
                    break;
                case 12:
                    if ((i13 & i) != 0) {
                        int i19 = unsafe.getInt(obj, j5);
                        iY2 = k.y(i14);
                        iW = k.w(i19);
                        iU = iW + iY2;
                        i12 += iU;
                    }
                    break;
                case 13:
                    if ((i13 & i) != 0) {
                        i12 = l4.a.i(i14, 4, i12);
                    }
                    break;
                case 14:
                    if ((i & i13) != 0) {
                        i12 = l4.a.i(i14, 8, i12);
                    }
                    break;
                case 15:
                    if ((i13 & i) != 0) {
                        int i20 = unsafe.getInt(obj, j5);
                        iY2 = k.y(i14);
                        iW = k.z((i20 >> 31) ^ (i20 << 1));
                        iU = iW + iY2;
                        i12 += iU;
                    }
                    break;
                case 16:
                    if ((i13 & i) != 0) {
                        long j11 = unsafe.getLong(obj, j5);
                        iY = k.y(i14);
                        iA = k.A((j11 >> 63) ^ (j11 << 1));
                        iY4 = iA + iY;
                        i12 += iY4;
                    }
                    break;
                case 17:
                    if ((i13 & i) != 0) {
                        iU = k.v(i14, (a) unsafe.getObject(obj, j5), n(i11));
                        i12 += iU;
                    }
                    break;
                case 18:
                    iU = c1.f(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 19:
                    iU = c1.d(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 20:
                    iU = c1.j(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 21:
                    iU = c1.t(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 22:
                    iU = c1.h(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 23:
                    iU = c1.f(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 24:
                    iU = c1.d(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 25:
                    List list = (List) unsafe.getObject(obj, j5);
                    Class cls2 = c1.f1026a;
                    int size2 = list.size();
                    iY4 = size2 == 0 ? 0 : (k.y(i14) + 1) * size2;
                    i12 += iY4;
                    break;
                case 26:
                    iU = c1.q(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 27:
                    iU = c1.l(i14, (List) unsafe.getObject(obj, j5), n(i11));
                    i12 += iU;
                    break;
                case 28:
                    iU = c1.a(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 29:
                    iU = c1.r(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 30:
                    iU = c1.b(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 31:
                    iU = c1.d(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 32:
                    iU = c1.f(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 33:
                    iU = c1.m(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 34:
                    iU = c1.o(i14, (List) unsafe.getObject(obj, j5));
                    i12 += iU;
                    break;
                case 35:
                    int iG2 = c1.g((List) unsafe.getObject(obj, j5));
                    if (iG2 > 0) {
                        i12 = l4.a.j(iG2, k.y(i14), iG2, i12);
                    }
                    break;
                case 36:
                    int iE = c1.e((List) unsafe.getObject(obj, j5));
                    if (iE > 0) {
                        i12 = l4.a.j(iE, k.y(i14), iE, i12);
                    }
                    break;
                case 37:
                    int iK = c1.k((List) unsafe.getObject(obj, j5));
                    if (iK > 0) {
                        i12 = l4.a.j(iK, k.y(i14), iK, i12);
                    }
                    break;
                case 38:
                    int iU2 = c1.u((List) unsafe.getObject(obj, j5));
                    if (iU2 > 0) {
                        i12 = l4.a.j(iU2, k.y(i14), iU2, i12);
                    }
                    break;
                case 39:
                    int i21 = c1.i((List) unsafe.getObject(obj, j5));
                    if (i21 > 0) {
                        i12 = l4.a.j(i21, k.y(i14), i21, i12);
                    }
                    break;
                case 40:
                    int iG3 = c1.g((List) unsafe.getObject(obj, j5));
                    if (iG3 > 0) {
                        i12 = l4.a.j(iG3, k.y(i14), iG3, i12);
                    }
                    break;
                case 41:
                    int iE2 = c1.e((List) unsafe.getObject(obj, j5));
                    if (iE2 > 0) {
                        i12 = l4.a.j(iE2, k.y(i14), iE2, i12);
                    }
                    break;
                case 42:
                    List list2 = (List) unsafe.getObject(obj, j5);
                    Class cls3 = c1.f1026a;
                    int size3 = list2.size();
                    if (size3 > 0) {
                        i12 = l4.a.j(size3, k.y(i14), size3, i12);
                    }
                    break;
                case 43:
                    int iS = c1.s((List) unsafe.getObject(obj, j5));
                    if (iS > 0) {
                        i12 = l4.a.j(iS, k.y(i14), iS, i12);
                    }
                    break;
                case 44:
                    int iC = c1.c((List) unsafe.getObject(obj, j5));
                    if (iC > 0) {
                        i12 = l4.a.j(iC, k.y(i14), iC, i12);
                    }
                    break;
                case 45:
                    int iE3 = c1.e((List) unsafe.getObject(obj, j5));
                    if (iE3 > 0) {
                        i12 = l4.a.j(iE3, k.y(i14), iE3, i12);
                    }
                    break;
                case 46:
                    int iG4 = c1.g((List) unsafe.getObject(obj, j5));
                    if (iG4 > 0) {
                        i12 = l4.a.j(iG4, k.y(i14), iG4, i12);
                    }
                    break;
                case 47:
                    int iN = c1.n((List) unsafe.getObject(obj, j5));
                    if (iN > 0) {
                        i12 = l4.a.j(iN, k.y(i14), iN, i12);
                    }
                    break;
                case 48:
                    int iP = c1.p((List) unsafe.getObject(obj, j5));
                    if (iP > 0) {
                        i12 = l4.a.j(iP, k.y(i14), iP, i12);
                    }
                    break;
                case 49:
                    List list3 = (List) unsafe.getObject(obj, j5);
                    b1 b1VarN2 = n(i11);
                    Class cls4 = c1.f1026a;
                    int size4 = list3.size();
                    if (size4 == 0) {
                        iV = 0;
                    } else {
                        iV = 0;
                        for (int i22 = 0; i22 < size4; i22++) {
                            iV += k.v(i14, (a) list3.get(i22), b1VarN2);
                        }
                    }
                    i12 += iV;
                    break;
                case 50:
                    Object object3 = unsafe.getObject(obj, j5);
                    Object objM = m(i11);
                    this.f1124n.getClass();
                    iU = o0.a(object3, i14, objM);
                    i12 += iU;
                    break;
                case 51:
                    if (r(i14, i11, obj)) {
                        i12 = l4.a.i(i14, 8, i12);
                    }
                    break;
                case 52:
                    if (r(i14, i11, obj)) {
                        i12 = l4.a.i(i14, 4, i12);
                    }
                    break;
                case 53:
                    if (r(i14, i11, obj)) {
                        long jA = A(j5, obj);
                        iY = k.y(i14);
                        iA = k.A(jA);
                        iY4 = iA + iY;
                        i12 += iY4;
                    }
                    break;
                case 54:
                    if (r(i14, i11, obj)) {
                        long jA2 = A(j5, obj);
                        iY = k.y(i14);
                        iA = k.A(jA2);
                        iY4 = iA + iY;
                        i12 += iY4;
                    }
                    break;
                case 55:
                    if (r(i14, i11, obj)) {
                        int iZ = z(j5, obj);
                        iY2 = k.y(i14);
                        iW = k.w(iZ);
                        iU = iW + iY2;
                        i12 += iU;
                    }
                    break;
                case 56:
                    if (r(i14, i11, obj)) {
                        iU = k.u(i14);
                        i12 += iU;
                    }
                    break;
                case 57:
                    if (r(i14, i11, obj)) {
                        iU = k.t(i14);
                        i12 += iU;
                    }
                    break;
                case 58:
                    if (r(i14, i11, obj)) {
                        i12 = l4.a.i(i14, 1, i12);
                    }
                    break;
                case 59:
                    if (r(i14, i11, obj)) {
                        Object object4 = unsafe.getObject(obj, j5);
                        if (object4 instanceof g) {
                            int iY7 = k.y(i14);
                            int size5 = ((g) object4).size();
                            iJ = l4.a.j(size5, size5, iY7, i12);
                            i12 = iJ;
                        } else {
                            iY3 = k.y(i14);
                            iX = k.x((String) object4);
                            iJ = iX + iY3 + i12;
                            i12 = iJ;
                        }
                    }
                    break;
                case 60:
                    if (r(i14, i11, obj)) {
                        Object object5 = unsafe.getObject(obj, j5);
                        b1 b1VarN3 = n(i11);
                        Class cls5 = c1.f1026a;
                        int iY8 = k.y(i14);
                        int iB2 = ((a) object5).b(b1VarN3);
                        i12 = l4.a.j(iB2, iB2, iY8, i12);
                    }
                    break;
                case 61:
                    if (r(i14, i11, obj)) {
                        iU = k.r(i14, (g) unsafe.getObject(obj, j5));
                        i12 += iU;
                    }
                    break;
                case 62:
                    if (r(i14, i11, obj)) {
                        int iZ2 = z(j5, obj);
                        iY2 = k.y(i14);
                        iW = k.z(iZ2);
                        iU = iW + iY2;
                        i12 += iU;
                    }
                    break;
                case 63:
                    if (r(i14, i11, obj)) {
                        int iZ3 = z(j5, obj);
                        iY2 = k.y(i14);
                        iW = k.w(iZ3);
                        iU = iW + iY2;
                        i12 += iU;
                    }
                    break;
                case 64:
                    if (r(i14, i11, obj)) {
                        i12 = l4.a.i(i14, 4, i12);
                    }
                    break;
                case 65:
                    if (r(i14, i11, obj)) {
                        i12 = l4.a.i(i14, 8, i12);
                    }
                    break;
                case 66:
                    if (r(i14, i11, obj)) {
                        int iZ4 = z(j5, obj);
                        iY2 = k.y(i14);
                        iW = k.z((iZ4 >> 31) ^ (iZ4 << 1));
                        iU = iW + iY2;
                        i12 += iU;
                    }
                    break;
                case 67:
                    if (r(i14, i11, obj)) {
                        long jA3 = A(j5, obj);
                        iY = k.y(i14);
                        iA = k.A((jA3 >> 63) ^ (jA3 << 1));
                        iY4 = iA + iY;
                        i12 += iY4;
                    }
                    break;
                case 68:
                    if (r(i14, i11, obj)) {
                        iU = k.v(i14, (a) unsafe.getObject(obj, j5), n(i11));
                        i12 += iU;
                    }
                    break;
            }
            i11 += 3;
        }
    }

    public final int p(Object obj) {
        int iY;
        int iA;
        int iY2;
        int iW;
        int iU;
        int iY3;
        int iX;
        int iY4;
        int iA2;
        int iV;
        Unsafe unsafe = f1112p;
        int i = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f1113a;
            if (i >= iArr.length) {
                this.f1123m.getClass();
                return ((w) obj).unknownFields.a() + i10;
            }
            int iH = H(i);
            int iG = G(iH);
            int i11 = iArr[i];
            long j5 = iH & 1048575;
            if (iG >= r.f1103v.f1107u && iG <= r.f1104w.f1107u) {
                int i12 = iArr[i + 2];
            }
            switch (iG) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    if (q(i, obj)) {
                        i10 = l4.a.i(i11, 8, i10);
                    }
                    break;
                case 1:
                    if (q(i, obj)) {
                        i10 = l4.a.i(i11, 4, i10);
                    }
                    break;
                case 2:
                    if (q(i, obj)) {
                        long jH = s1.f1128d.h(j5, obj);
                        iY = k.y(i11);
                        iA = k.A(jH);
                        iU = iA + iY;
                        i10 += iU;
                    }
                    break;
                case 3:
                    if (q(i, obj)) {
                        long jH2 = s1.f1128d.h(j5, obj);
                        iY = k.y(i11);
                        iA = k.A(jH2);
                        iU = iA + iY;
                        i10 += iU;
                    }
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    if (q(i, obj)) {
                        int iG2 = s1.f1128d.g(j5, obj);
                        iY2 = k.y(i11);
                        iW = k.w(iG2);
                        iU = iW + iY2;
                        i10 += iU;
                    }
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    if (q(i, obj)) {
                        iU = k.u(i11);
                        i10 += iU;
                    }
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    if (q(i, obj)) {
                        iU = k.t(i11);
                        i10 += iU;
                    }
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    if (q(i, obj)) {
                        i10 = l4.a.i(i11, 1, i10);
                    }
                    break;
                case 8:
                    if (q(i, obj)) {
                        Object objI = s1.f1128d.i(j5, obj);
                        if (objI instanceof g) {
                            int iY5 = k.y(i11);
                            int size = ((g) objI).size();
                            i10 = l4.a.j(size, size, iY5, i10);
                        } else {
                            iY3 = k.y(i11);
                            iX = k.x((String) objI);
                            i10 = iX + iY3 + i10;
                        }
                    }
                    break;
                case 9:
                    if (q(i, obj)) {
                        Object objI2 = s1.f1128d.i(j5, obj);
                        b1 b1VarN = n(i);
                        Class cls = c1.f1026a;
                        int iY6 = k.y(i11);
                        int iB = ((a) objI2).b(b1VarN);
                        i10 = l4.a.j(iB, iB, iY6, i10);
                    }
                    break;
                case 10:
                    if (q(i, obj)) {
                        iU = k.r(i11, (g) s1.f1128d.i(j5, obj));
                        i10 += iU;
                    }
                    break;
                case 11:
                    if (q(i, obj)) {
                        int iG3 = s1.f1128d.g(j5, obj);
                        iY2 = k.y(i11);
                        iW = k.z(iG3);
                        iU = iW + iY2;
                        i10 += iU;
                    }
                    break;
                case 12:
                    if (q(i, obj)) {
                        int iG4 = s1.f1128d.g(j5, obj);
                        iY2 = k.y(i11);
                        iW = k.w(iG4);
                        iU = iW + iY2;
                        i10 += iU;
                    }
                    break;
                case 13:
                    if (q(i, obj)) {
                        i10 = l4.a.i(i11, 4, i10);
                    }
                    break;
                case 14:
                    if (q(i, obj)) {
                        i10 = l4.a.i(i11, 8, i10);
                    }
                    break;
                case 15:
                    if (q(i, obj)) {
                        int iG5 = s1.f1128d.g(j5, obj);
                        iY2 = k.y(i11);
                        iW = k.z((iG5 >> 31) ^ (iG5 << 1));
                        iU = iW + iY2;
                        i10 += iU;
                    }
                    break;
                case 16:
                    if (q(i, obj)) {
                        long jH3 = s1.f1128d.h(j5, obj);
                        iY4 = k.y(i11);
                        iA2 = k.A((jH3 >> 63) ^ (jH3 << 1));
                        iU = iA2 + iY4;
                        i10 += iU;
                    }
                    break;
                case 17:
                    if (q(i, obj)) {
                        iU = k.v(i11, (a) s1.f1128d.i(j5, obj), n(i));
                        i10 += iU;
                    }
                    break;
                case 18:
                    iU = c1.f(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 19:
                    iU = c1.d(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 20:
                    iU = c1.j(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 21:
                    iU = c1.t(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 22:
                    iU = c1.h(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 23:
                    iU = c1.f(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 24:
                    iU = c1.d(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 25:
                    List listS = s(j5, obj);
                    Class cls2 = c1.f1026a;
                    int size2 = listS.size();
                    i10 += size2 == 0 ? 0 : (k.y(i11) + 1) * size2;
                    break;
                case 26:
                    iU = c1.q(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 27:
                    iU = c1.l(i11, s(j5, obj), n(i));
                    i10 += iU;
                    break;
                case 28:
                    iU = c1.a(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 29:
                    iU = c1.r(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 30:
                    iU = c1.b(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 31:
                    iU = c1.d(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 32:
                    iU = c1.f(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 33:
                    iU = c1.m(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 34:
                    iU = c1.o(i11, s(j5, obj));
                    i10 += iU;
                    break;
                case 35:
                    int iG6 = c1.g((List) unsafe.getObject(obj, j5));
                    if (iG6 > 0) {
                        i10 = l4.a.j(iG6, k.y(i11), iG6, i10);
                    }
                    break;
                case 36:
                    int iE = c1.e((List) unsafe.getObject(obj, j5));
                    if (iE > 0) {
                        i10 = l4.a.j(iE, k.y(i11), iE, i10);
                    }
                    break;
                case 37:
                    int iK = c1.k((List) unsafe.getObject(obj, j5));
                    if (iK > 0) {
                        i10 = l4.a.j(iK, k.y(i11), iK, i10);
                    }
                    break;
                case 38:
                    int iU2 = c1.u((List) unsafe.getObject(obj, j5));
                    if (iU2 > 0) {
                        i10 = l4.a.j(iU2, k.y(i11), iU2, i10);
                    }
                    break;
                case 39:
                    int i13 = c1.i((List) unsafe.getObject(obj, j5));
                    if (i13 > 0) {
                        i10 = l4.a.j(i13, k.y(i11), i13, i10);
                    }
                    break;
                case 40:
                    int iG7 = c1.g((List) unsafe.getObject(obj, j5));
                    if (iG7 > 0) {
                        i10 = l4.a.j(iG7, k.y(i11), iG7, i10);
                    }
                    break;
                case 41:
                    int iE2 = c1.e((List) unsafe.getObject(obj, j5));
                    if (iE2 > 0) {
                        i10 = l4.a.j(iE2, k.y(i11), iE2, i10);
                    }
                    break;
                case 42:
                    List list = (List) unsafe.getObject(obj, j5);
                    Class cls3 = c1.f1026a;
                    int size3 = list.size();
                    if (size3 > 0) {
                        i10 = l4.a.j(size3, k.y(i11), size3, i10);
                    }
                    break;
                case 43:
                    int iS = c1.s((List) unsafe.getObject(obj, j5));
                    if (iS > 0) {
                        i10 = l4.a.j(iS, k.y(i11), iS, i10);
                    }
                    break;
                case 44:
                    int iC = c1.c((List) unsafe.getObject(obj, j5));
                    if (iC > 0) {
                        i10 = l4.a.j(iC, k.y(i11), iC, i10);
                    }
                    break;
                case 45:
                    int iE3 = c1.e((List) unsafe.getObject(obj, j5));
                    if (iE3 > 0) {
                        i10 = l4.a.j(iE3, k.y(i11), iE3, i10);
                    }
                    break;
                case 46:
                    int iG8 = c1.g((List) unsafe.getObject(obj, j5));
                    if (iG8 > 0) {
                        i10 = l4.a.j(iG8, k.y(i11), iG8, i10);
                    }
                    break;
                case 47:
                    int iN = c1.n((List) unsafe.getObject(obj, j5));
                    if (iN > 0) {
                        i10 = l4.a.j(iN, k.y(i11), iN, i10);
                    }
                    break;
                case 48:
                    int iP = c1.p((List) unsafe.getObject(obj, j5));
                    if (iP > 0) {
                        i10 = l4.a.j(iP, k.y(i11), iP, i10);
                    }
                    break;
                case 49:
                    List listS2 = s(j5, obj);
                    b1 b1VarN2 = n(i);
                    Class cls4 = c1.f1026a;
                    int size4 = listS2.size();
                    if (size4 == 0) {
                        iV = 0;
                    } else {
                        iV = 0;
                        for (int i14 = 0; i14 < size4; i14++) {
                            iV += k.v(i11, (a) listS2.get(i14), b1VarN2);
                        }
                    }
                    i10 += iV;
                    break;
                case 50:
                    Object objI3 = s1.f1128d.i(j5, obj);
                    Object objM = m(i);
                    this.f1124n.getClass();
                    iU = o0.a(objI3, i11, objM);
                    i10 += iU;
                    break;
                case 51:
                    if (r(i11, i, obj)) {
                        i10 = l4.a.i(i11, 8, i10);
                    }
                    break;
                case 52:
                    if (r(i11, i, obj)) {
                        i10 = l4.a.i(i11, 4, i10);
                    }
                    break;
                case 53:
                    if (r(i11, i, obj)) {
                        long jA = A(j5, obj);
                        iY = k.y(i11);
                        iA = k.A(jA);
                        iU = iA + iY;
                        i10 += iU;
                    }
                    break;
                case 54:
                    if (r(i11, i, obj)) {
                        long jA2 = A(j5, obj);
                        iY = k.y(i11);
                        iA = k.A(jA2);
                        iU = iA + iY;
                        i10 += iU;
                    }
                    break;
                case 55:
                    if (r(i11, i, obj)) {
                        int iZ = z(j5, obj);
                        iY2 = k.y(i11);
                        iW = k.w(iZ);
                        iU = iW + iY2;
                        i10 += iU;
                    }
                    break;
                case 56:
                    if (r(i11, i, obj)) {
                        iU = k.u(i11);
                        i10 += iU;
                    }
                    break;
                case 57:
                    if (r(i11, i, obj)) {
                        iU = k.t(i11);
                        i10 += iU;
                    }
                    break;
                case 58:
                    if (r(i11, i, obj)) {
                        i10 = l4.a.i(i11, 1, i10);
                    }
                    break;
                case 59:
                    if (r(i11, i, obj)) {
                        Object objI4 = s1.f1128d.i(j5, obj);
                        if (objI4 instanceof g) {
                            int iY7 = k.y(i11);
                            int size5 = ((g) objI4).size();
                            i10 = l4.a.j(size5, size5, iY7, i10);
                        } else {
                            iY3 = k.y(i11);
                            iX = k.x((String) objI4);
                            i10 = iX + iY3 + i10;
                        }
                    }
                    break;
                case 60:
                    if (r(i11, i, obj)) {
                        Object objI5 = s1.f1128d.i(j5, obj);
                        b1 b1VarN3 = n(i);
                        Class cls5 = c1.f1026a;
                        int iY8 = k.y(i11);
                        int iB2 = ((a) objI5).b(b1VarN3);
                        i10 = l4.a.j(iB2, iB2, iY8, i10);
                    }
                    break;
                case 61:
                    if (r(i11, i, obj)) {
                        iU = k.r(i11, (g) s1.f1128d.i(j5, obj));
                        i10 += iU;
                    }
                    break;
                case 62:
                    if (r(i11, i, obj)) {
                        int iZ2 = z(j5, obj);
                        iY2 = k.y(i11);
                        iW = k.z(iZ2);
                        iU = iW + iY2;
                        i10 += iU;
                    }
                    break;
                case 63:
                    if (r(i11, i, obj)) {
                        int iZ3 = z(j5, obj);
                        iY2 = k.y(i11);
                        iW = k.w(iZ3);
                        iU = iW + iY2;
                        i10 += iU;
                    }
                    break;
                case 64:
                    if (r(i11, i, obj)) {
                        i10 = l4.a.i(i11, 4, i10);
                    }
                    break;
                case 65:
                    if (r(i11, i, obj)) {
                        i10 = l4.a.i(i11, 8, i10);
                    }
                    break;
                case 66:
                    if (r(i11, i, obj)) {
                        int iZ4 = z(j5, obj);
                        iY2 = k.y(i11);
                        iW = k.z((iZ4 >> 31) ^ (iZ4 << 1));
                        iU = iW + iY2;
                        i10 += iU;
                    }
                    break;
                case 67:
                    if (r(i11, i, obj)) {
                        long jA3 = A(j5, obj);
                        iY4 = k.y(i11);
                        iA2 = k.A((jA3 >> 63) ^ (jA3 << 1));
                        iU = iA2 + iY4;
                        i10 += iU;
                    }
                    break;
                case 68:
                    if (r(i11, i, obj)) {
                        iU = k.v(i11, (a) s1.f1128d.i(j5, obj), n(i));
                        i10 += iU;
                    }
                    break;
            }
            i += 3;
        }
    }

    public final boolean q(int i, Object obj) {
        if (this.f1118g) {
            int iH = H(i);
            long j5 = iH & 1048575;
            switch (G(iH)) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    if (s1.f1128d.e(j5, obj) == 0.0d) {
                        return false;
                    }
                    break;
                case 1:
                    if (s1.f1128d.f(j5, obj) == 0.0f) {
                        return false;
                    }
                    break;
                case 2:
                    if (s1.f1128d.h(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (s1.f1128d.h(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    if (s1.f1128d.g(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    if (s1.f1128d.h(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    if (s1.f1128d.g(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    return s1.f1128d.c(j5, obj);
                case 8:
                    Object objI = s1.f1128d.i(j5, obj);
                    if (objI instanceof String) {
                        return !((String) objI).isEmpty();
                    }
                    if (objI instanceof g) {
                        return !g.f1043w.equals(objI);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (s1.f1128d.i(j5, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !g.f1043w.equals(s1.f1128d.i(j5, obj));
                case 11:
                    if (s1.f1128d.g(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (s1.f1128d.g(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (s1.f1128d.g(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (s1.f1128d.h(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (s1.f1128d.g(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (s1.f1128d.h(j5, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (s1.f1128d.i(j5, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((s1.f1128d.g(r6 & 1048575, obj) & (1 << (this.f1113a[i + 2] >>> 20))) == 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean r(int i, int i10, Object obj) {
        return s1.f1128d.g((long) (this.f1113a[i10 + 2] & 1048575), obj) == i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009b, code lost:
    
        r10.put(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009e, code lost:
    
        r0.d(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a1, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(java.lang.Object r9, int r10, java.lang.Object r11, androidx.datastore.preferences.protobuf.n r12, androidx.datastore.preferences.protobuf.i r13) throws androidx.datastore.preferences.protobuf.a0 {
        /*
            r8 = this;
            int r10 = r8.H(r10)
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r0
            long r0 = (long) r10
            androidx.datastore.preferences.protobuf.r1 r10 = androidx.datastore.preferences.protobuf.s1.f1128d
            java.lang.Object r10 = r10.i(r0, r9)
            androidx.datastore.preferences.protobuf.o0 r2 = r8.f1124n
            if (r10 != 0) goto L20
            r2.getClass()
            androidx.datastore.preferences.protobuf.n0 r10 = androidx.datastore.preferences.protobuf.n0.f1092v
            androidx.datastore.preferences.protobuf.n0 r10 = r10.b()
            androidx.datastore.preferences.protobuf.s1.o(r9, r0, r10)
            goto L37
        L20:
            r2.getClass()
            r3 = r10
            androidx.datastore.preferences.protobuf.n0 r3 = (androidx.datastore.preferences.protobuf.n0) r3
            boolean r3 = r3.f1093u
            if (r3 != 0) goto L37
            androidx.datastore.preferences.protobuf.n0 r3 = androidx.datastore.preferences.protobuf.n0.f1092v
            androidx.datastore.preferences.protobuf.n0 r3 = r3.b()
            androidx.datastore.preferences.protobuf.o0.b(r3, r10)
            androidx.datastore.preferences.protobuf.s1.o(r9, r0, r3)
            r10 = r3
        L37:
            r2.getClass()
            androidx.datastore.preferences.protobuf.n0 r10 = (androidx.datastore.preferences.protobuf.n0) r10
            androidx.datastore.preferences.protobuf.m0 r11 = (androidx.datastore.preferences.protobuf.m0) r11
            androidx.datastore.preferences.protobuf.l0 r9 = r11.f1088a
            r11 = 2
            r13.S(r11)
            java.lang.Object r0 = r13.f1067d
            androidx.datastore.preferences.protobuf.h r0 = (androidx.datastore.preferences.protobuf.h) r0
            int r1 = r0.A()
            int r1 = r0.e(r1)
            java.lang.Object r2 = r9.f1085c
            java.lang.String r3 = ""
            r4 = r2
        L55:
            int r5 = r13.c()     // Catch: java.lang.Throwable -> L79
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r5 == r6) goto L9b
            boolean r6 = r0.c()     // Catch: java.lang.Throwable -> L79
            if (r6 == 0) goto L65
            goto L9b
        L65:
            r6 = 1
            java.lang.String r7 = "Unable to parse map entry."
            if (r5 == r6) goto L86
            if (r5 == r11) goto L7b
            boolean r5 = r13.T()     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.a0 -> L8e
            if (r5 == 0) goto L73
            goto L55
        L73:
            androidx.datastore.preferences.protobuf.b0 r5 = new androidx.datastore.preferences.protobuf.b0     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.a0 -> L8e
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.a0 -> L8e
            throw r5     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.a0 -> L8e
        L79:
            r9 = move-exception
            goto La2
        L7b:
            androidx.datastore.preferences.protobuf.a2 r5 = r9.f1084b     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.a0 -> L8e
            java.lang.Class r6 = r2.getClass()     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.a0 -> L8e
            java.lang.Object r4 = r13.m(r5, r6, r12)     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.a0 -> L8e
            goto L55
        L86:
            androidx.datastore.preferences.protobuf.a2 r5 = r9.f1083a     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.a0 -> L8e
            r6 = 0
            java.lang.Object r3 = r13.m(r5, r6, r6)     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.a0 -> L8e
            goto L55
        L8e:
            boolean r5 = r13.T()     // Catch: java.lang.Throwable -> L79
            if (r5 == 0) goto L95
            goto L55
        L95:
            androidx.datastore.preferences.protobuf.b0 r9 = new androidx.datastore.preferences.protobuf.b0     // Catch: java.lang.Throwable -> L79
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L79
            throw r9     // Catch: java.lang.Throwable -> L79
        L9b:
            r10.put(r3, r4)     // Catch: java.lang.Throwable -> L79
            r0.d(r1)
            return
        La2:
            r0.d(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.s0.t(java.lang.Object, int, java.lang.Object, androidx.datastore.preferences.protobuf.n, androidx.datastore.preferences.protobuf.i):void");
    }

    public final void u(Object obj, int i, Object obj2) {
        long jH = H(i) & 1048575;
        if (q(i, obj2)) {
            r1 r1Var = s1.f1128d;
            Object objI = r1Var.i(jH, obj);
            Object objI2 = r1Var.i(jH, obj2);
            if (objI != null && objI2 != null) {
                s1.o(obj, jH, z.c(objI, objI2));
                E(i, obj);
            } else if (objI2 != null) {
                s1.o(obj, jH, objI2);
                E(i, obj);
            }
        }
    }

    public final void v(Object obj, int i, Object obj2) {
        int iH = H(i);
        int i10 = this.f1113a[i];
        long j5 = iH & 1048575;
        if (r(i10, i, obj2)) {
            r1 r1Var = s1.f1128d;
            Object objI = r1Var.i(j5, obj);
            Object objI2 = r1Var.i(j5, obj2);
            if (objI != null && objI2 != null) {
                s1.o(obj, j5, z.c(objI, objI2));
                F(i10, i, obj);
            } else if (objI2 != null) {
                s1.o(obj, j5, objI2);
                F(i10, i, obj);
            }
        }
    }
}
