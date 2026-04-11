package y1;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import v1.m0;
import v1.n0;
import v1.w0;
import ya.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f14551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f14552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f14553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long[] f14554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f14555e;
    public static final Pattern f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f14556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f14557h;
    public static HashMap i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f14558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f14559k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f14560l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f14561m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f14562n;

    static {
        int i10 = Build.VERSION.SDK_INT;
        f14551a = i10;
        String str = Build.DEVICE;
        String str2 = Build.MANUFACTURER;
        f14552b = str + ", " + Build.MODEL + ", " + str2 + ", " + i10;
        f14553c = new byte[0];
        f14554d = new long[0];
        f14555e = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f14556g = Pattern.compile("%([A-Fa-f0-9]{2})");
        f14557h = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        f14558j = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f14559k = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f14560l = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f14561m = new int[]{0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935};
        f14562n = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, 128, 149, 146, ModuleDescriptor.MODULE_VERSION, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    public static v1.p A(int i10, int i11, int i12) {
        v1.o oVar = new v1.o();
        oVar.f12893m = m0.p("audio/raw");
        oVar.E = i11;
        oVar.F = i12;
        oVar.G = i10;
        return new v1.p(oVar);
    }

    public static long B(long j4, float f10) {
        return f10 == 1.0f ? j4 : Math.round(j4 / ((double) f10));
    }

    public static String C(StringBuilder sb, Formatter formatter, long j4) {
        if (j4 == -9223372036854775807L) {
            j4 = 0;
        }
        String str = j4 < 0 ? "-" : "";
        long jAbs = (Math.abs(j4) + 500) / 1000;
        long j7 = jAbs % 60;
        long j10 = (jAbs / 60) % 60;
        long j11 = jAbs / 3600;
        sb.setLength(0);
        return j11 > 0 ? formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j11), Long.valueOf(j10), Long.valueOf(j7)).toString() : formatter.format("%s%02d:%02d", str, Long.valueOf(j10), Long.valueOf(j7)).toString();
    }

    public static String D(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e9) {
            b.h("Util", "Failed to read system property ".concat(str), e9);
            return null;
        }
    }

    public static String E(int i10) {
        switch (i10) {
            case -2:
                return "none";
            case -1:
                return "unknown";
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "default";
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return "image";
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return "metadata";
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return "camera motion";
            default:
                return i10 >= 10000 ? l0.e.h(i10, "custom (", ")") : "?";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean F(v1.w0 r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            int r1 = r4.E()
            r2 = 1
            if (r1 != r2) goto L17
            r3 = 2
            boolean r3 = r4.Z(r3)
            if (r3 == 0) goto L17
            r4.b()
        L15:
            r0 = r2
            goto L24
        L17:
            r3 = 4
            if (r1 != r3) goto L24
            boolean r1 = r4.Z(r3)
            if (r1 == 0) goto L24
            r4.V()
            goto L15
        L24:
            boolean r1 = r4.Z(r2)
            if (r1 == 0) goto L2e
            r4.T()
            return r2
        L2e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.a0.F(v1.w0):boolean");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int G(android.net.Uri r7, java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.a0.G(android.net.Uri, java.lang.String):int");
    }

    public static boolean H(t tVar, t tVar2, Inflater inflater) {
        if (tVar.a() == 0) {
            return false;
        }
        if (tVar2.f14609a.length < tVar.a()) {
            tVar2.c(tVar.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(tVar.f14609a, tVar.f14610b, tVar.a());
        int iInflate = 0;
        while (true) {
            try {
                byte[] bArr = tVar2.f14609a;
                iInflate += inflater.inflate(bArr, iInflate, bArr.length - iInflate);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                    }
                    byte[] bArr2 = tVar2.f14609a;
                    if (iInflate == bArr2.length) {
                        tVar2.c(bArr2.length * 2);
                    }
                } else {
                    tVar2.I(iInflate);
                    inflater.reset();
                    return true;
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static void I(int i10) {
        Integer.toString(i10, 36);
    }

    public static boolean J(int i10) {
        return i10 == 3 || i10 == 2 || i10 == 268435456 || i10 == 21 || i10 == 1342177280 || i10 == 22 || i10 == 1610612736 || i10 == 4;
    }

    public static boolean K(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
            return true;
        }
        if (i10 == 30) {
            String str = Build.MODEL;
            if (android.support.v4.media.session.b.j(str, "moto g(20)") || android.support.v4.media.session.b.j(str, "rmx3231")) {
                return true;
            }
        }
        return i10 == 34 && android.support.v4.media.session.b.j(Build.MODEL, "sm-x200");
    }

    public static boolean L(int i10) {
        return i10 == 10 || i10 == 13;
    }

    public static boolean M(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static void N(ArrayList arrayList, int i10, int i11, int i12) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i13 = (i11 - i10) - 1; i13 >= 0; i13--) {
            arrayDeque.addFirst(arrayList.remove(i10 + i13));
        }
        arrayList.addAll(Math.min(i12, arrayList.size()), arrayDeque);
    }

    public static long O(long j4) {
        return (j4 == -9223372036854775807L || j4 == Long.MIN_VALUE) ? j4 : j4 * 1000;
    }

    public static String P(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !strReplace.equals("und")) {
            str = strReplace;
        }
        String strO = android.support.v4.media.session.b.O(str);
        int i10 = 0;
        String str2 = strO.split("-", 2)[0];
        if (i == null) {
            String[] iSOLanguages = Locale.getISOLanguages();
            int length = iSOLanguages.length;
            String[] strArr = f14558j;
            HashMap map = new HashMap(length + strArr.length);
            for (String str3 : iSOLanguages) {
                try {
                    String iSO3Language = new Locale(str3).getISO3Language();
                    if (!TextUtils.isEmpty(iSO3Language)) {
                        map.put(iSO3Language, str3);
                    }
                } catch (MissingResourceException unused) {
                }
            }
            for (int i11 = 0; i11 < strArr.length; i11 += 2) {
                map.put(strArr[i11], strArr[i11 + 1]);
            }
            i = map;
        }
        String str4 = (String) i.get(str2);
        if (str4 != null) {
            StringBuilder sbB = y.e.b(str4);
            sbB.append(strO.substring(str2.length()));
            strO = sbB.toString();
            str2 = str4;
        }
        if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
            return strO;
        }
        while (true) {
            String[] strArr2 = f14559k;
            if (i10 >= strArr2.length) {
                return strO;
            }
            if (strO.startsWith(strArr2[i10])) {
                return strArr2[i10 + 1] + strO.substring(strArr2[i10].length());
            }
            i10 += 2;
        }
    }

    public static Object[] Q(int i10, Object[] objArr) {
        d.b(i10 <= objArr.length);
        return Arrays.copyOf(objArr, i10);
    }

    public static long R(String str) throws n0 {
        Matcher matcher = f14555e.matcher(str);
        if (!matcher.matches()) {
            throw n0.a(null, "Invalid date/time format: " + str);
        }
        int i10 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i10 = Integer.parseInt(matcher.group(13)) + (Integer.parseInt(matcher.group(12)) * 60);
            if ("-".equals(matcher.group(11))) {
                i10 *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i10 != 0 ? timeInMillis - (((long) i10) * 60000) : timeInMillis;
    }

    public static void S(Handler handler, Runnable runnable) {
        Looper looper = handler.getLooper();
        if (looper.getThread().isAlive()) {
            if (looper == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    public static void T(ArrayList arrayList, int i10, int i11) {
        if (i10 < 0 || i11 > arrayList.size() || i10 > i11) {
            throw new IllegalArgumentException();
        }
        if (i10 != i11) {
            arrayList.subList(i10, i11).clear();
        }
    }

    public static long U(int i10, long j4) {
        return W(j4, 1000000L, i10, RoundingMode.DOWN);
    }

    public static void V(long[] jArr, long j4) {
        long j7;
        RoundingMode roundingMode = RoundingMode.DOWN;
        int i10 = 0;
        if (j4 >= 1000000 && j4 % 1000000 == 0) {
            long jN = sd.i.n(j4, 1000000L, RoundingMode.UNNECESSARY);
            while (i10 < jArr.length) {
                jArr[i10] = sd.i.n(jArr[i10], jN, roundingMode);
                i10++;
            }
            return;
        }
        if (j4 < 1000000 && 1000000 % j4 == 0) {
            long jN2 = sd.i.n(1000000L, j4, RoundingMode.UNNECESSARY);
            while (i10 < jArr.length) {
                jArr[i10] = sd.i.E(jArr[i10], jN2);
                i10++;
            }
            return;
        }
        int i11 = 0;
        while (i11 < jArr.length) {
            long j10 = jArr[i11];
            if (j10 != 0) {
                if (j4 >= j10 && j4 % j10 == 0) {
                    jArr[i11] = sd.i.n(1000000L, sd.i.n(j4, j10, RoundingMode.UNNECESSARY), roundingMode);
                } else if (j4 >= j10 || j10 % j4 != 0) {
                    j7 = j4;
                    jArr[i11] = X(j10, 1000000L, j7, roundingMode);
                } else {
                    jArr[i11] = sd.i.E(1000000L, sd.i.n(j10, j4, RoundingMode.UNNECESSARY));
                }
                j7 = j4;
            } else {
                j7 = j4;
            }
            i11++;
            j4 = j7;
        }
    }

    public static long W(long j4, long j7, long j10, RoundingMode roundingMode) {
        if (j4 == 0 || j7 == 0) {
            return 0L;
        }
        return (j10 < j7 || j10 % j7 != 0) ? (j10 >= j7 || j7 % j10 != 0) ? (j10 < j4 || j10 % j4 != 0) ? (j10 >= j4 || j4 % j10 != 0) ? X(j4, j7, j10, roundingMode) : sd.i.E(j7, sd.i.n(j4, j10, RoundingMode.UNNECESSARY)) : sd.i.n(j7, sd.i.n(j10, j4, RoundingMode.UNNECESSARY), roundingMode) : sd.i.E(j4, sd.i.n(j7, j10, RoundingMode.UNNECESSARY)) : sd.i.n(j4, sd.i.n(j10, j7, RoundingMode.UNNECESSARY), roundingMode);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long X(long r9, long r11, long r13, java.math.RoundingMode r15) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.a0.X(long, long, long, java.math.RoundingMode):long");
    }

    public static boolean Y(w0 w0Var, boolean z10) {
        return w0Var == null || !w0Var.w() || w0Var.E() == 1 || w0Var.E() == 4 || !(!z10 || w0Var.r0() == 0 || w0Var.r0() == 4);
    }

    public static String[] Z(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : str.trim().split("(\\s*,\\s*)", -1);
    }

    public static int a(long[] jArr, long j4, boolean z10) {
        int i10;
        int iBinarySearch = Arrays.binarySearch(jArr, j4);
        if (iBinarySearch < 0) {
            return ~iBinarySearch;
        }
        while (true) {
            i10 = iBinarySearch + 1;
            if (i10 >= jArr.length || jArr[i10] != j4) {
                break;
            }
            iBinarySearch = i10;
        }
        return z10 ? iBinarySearch : i10;
    }

    public static c0 a0(ya.w wVar, ya.p pVar) {
        c0 c0Var = new c0();
        nc.i iVar = new nc.i(17, c0Var, wVar);
        ya.q qVar = ya.q.f15009v;
        c0Var.h(iVar, qVar);
        wVar.h(new androidx.emoji2.text.n(wVar, c0Var, pVar, 8), qVar);
        return c0Var;
    }

    public static int b(ag.o oVar, long j4) {
        int i10 = oVar.f454w - 1;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            if (oVar.g(i12) < j4) {
                i11 = i12 + 1;
            } else {
                i10 = i12 - 1;
            }
        }
        int i13 = i10 + 1;
        if (i13 < oVar.f454w && oVar.g(i13) == j4) {
            return i13;
        }
        if (i10 == -1) {
            return 0;
        }
        return i10;
    }

    public static long b0(long j4) {
        return (j4 == -9223372036854775807L || j4 == Long.MIN_VALUE) ? j4 : j4 / 1000;
    }

    public static int c(List list, Long l10, boolean z10) {
        int i10;
        int iBinarySearch = Collections.binarySearch(list, l10);
        if (iBinarySearch < 0) {
            i10 = -(iBinarySearch + 2);
        } else {
            while (true) {
                int i11 = iBinarySearch - 1;
                if (i11 < 0 || ((Comparable) list.get(i11)).compareTo(l10) != 0) {
                    break;
                }
                iBinarySearch = i11;
            }
            i10 = iBinarySearch;
        }
        return z10 ? Math.max(0, i10) : i10;
    }

    public static int d(int[] iArr, int i10, boolean z10, boolean z11) {
        int i11;
        int i12;
        int iBinarySearch = Arrays.binarySearch(iArr, i10);
        if (iBinarySearch < 0) {
            i12 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i11 = iBinarySearch - 1;
                if (i11 < 0 || iArr[i11] != i10) {
                    break;
                }
                iBinarySearch = i11;
            }
            i12 = z10 ? iBinarySearch : i11;
        }
        return z11 ? Math.max(0, i12) : i12;
    }

    public static int e(long[] jArr, long j4, boolean z10) {
        int i10;
        int iBinarySearch = Arrays.binarySearch(jArr, j4);
        if (iBinarySearch < 0) {
            i10 = -(iBinarySearch + 2);
        } else {
            while (true) {
                int i11 = iBinarySearch - 1;
                if (i11 < 0 || jArr[i11] != j4) {
                    break;
                }
                iBinarySearch = i11;
            }
            i10 = iBinarySearch;
        }
        return z10 ? Math.max(0, i10) : i10;
    }

    public static int f(int i10, int i11) {
        return ((i10 + i11) - 1) / i11;
    }

    public static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static float h(float f10, float f11, float f12) {
        return Math.max(f11, Math.min(f10, f12));
    }

    public static int i(int i10, int i11, int i12) {
        return Math.max(i11, Math.min(i10, i12));
    }

    public static long j(long j4, long j7, long j10) {
        return Math.max(j7, Math.min(j4, j10));
    }

    public static boolean k(SparseArray sparseArray, int i10) {
        return sparseArray.indexOfKey(i10) >= 0;
    }

    public static boolean l(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (Objects.equals(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static int m(int i10, int i11, int i12, byte[] bArr) {
        while (i10 < i11) {
            i12 = f14560l[((i12 >>> 24) ^ (bArr[i10] & 255)) & 255] ^ (i12 << 8);
            i10++;
        }
        return i12;
    }

    public static Handler n(Handler.Callback callback) {
        Looper looperMyLooper = Looper.myLooper();
        d.h(looperMyLooper);
        return new Handler(looperMyLooper, callback);
    }

    public static String o(byte[] bArr) {
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static int p(int i10) {
        if (i10 == 30) {
            return 34;
        }
        switch (i10) {
            case 2:
            case 3:
                return 3;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return 21;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return 23;
            case 9:
            case 10:
            case 11:
            case 12:
                return 28;
            default:
                switch (i10) {
                    case 14:
                        return 25;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        return 28;
                    default:
                        switch (i10) {
                            case 20:
                                return 30;
                            case 21:
                            case 22:
                                return 31;
                            default:
                                return Integer.MAX_VALUE;
                        }
                }
        }
    }

    public static int q(int i10) {
        if (i10 == 10) {
            return Build.VERSION.SDK_INT >= 32 ? 737532 : 6396;
        }
        if (i10 == 12) {
            return 743676;
        }
        if (i10 == 24) {
            return Build.VERSION.SDK_INT >= 32 ? 67108860 : 0;
        }
        switch (i10) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return 204;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return 220;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return 252;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return 1276;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return 6396;
            default:
                return 0;
        }
    }

    public static int r(int i10) {
        if (i10 != 2) {
            if (i10 == 3) {
                return 1;
            }
            if (i10 != 4) {
                if (i10 != 21) {
                    if (i10 != 22) {
                        if (i10 != 268435456) {
                            if (i10 != 1342177280) {
                                if (i10 != 1610612736) {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    }
                }
                return 3;
            }
            return 4;
        }
        return 2;
    }

    public static int s(int i10, String str) {
        int i11 = 0;
        for (String str2 : Z(str)) {
            if (i10 == m0.i(m0.e(str2))) {
                i11++;
            }
        }
        return i11;
    }

    public static String t(int i10, String str) {
        String[] strArrZ = Z(str);
        if (strArrZ.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrZ) {
            if (i10 == m0.i(m0.e(str2))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static Point u(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getClass();
            display = windowManager.getDefaultDisplay();
        }
        if (display.getDisplayId() == 0 && M(context)) {
            String strD = Build.VERSION.SDK_INT < 28 ? D("sys.display-size") : D("vendor.display-size");
            if (!TextUtils.isEmpty(strD)) {
                try {
                    String[] strArrSplit = strD.trim().split("x", -1);
                    if (strArrSplit.length == 2) {
                        int i10 = Integer.parseInt(strArrSplit[0]);
                        int i11 = Integer.parseInt(strArrSplit[1]);
                        if (i10 > 0 && i11 > 0) {
                            return new Point(i10, i11);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                b.g("Util", "Invalid display size: " + strD);
            }
            if ("Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
        return point;
    }

    public static int v(int i10) {
        if (i10 == 2 || i10 == 4) {
            return 6005;
        }
        if (i10 == 10) {
            return 6004;
        }
        if (i10 == 7) {
            return 6005;
        }
        if (i10 == 8) {
            return 6003;
        }
        switch (i10) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i10) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static int w(String str) {
        String[] strArrSplit;
        int length;
        int i10 = 0;
        if (str == null || (length = (strArrSplit = str.split("_", -1)).length) < 2) {
            return 0;
        }
        String str2 = strArrSplit[length - 1];
        boolean z10 = length >= 3 && "neg".equals(strArrSplit[length - 2]);
        try {
            str2.getClass();
            i10 = Integer.parseInt(str2);
            if (z10) {
                return -i10;
            }
        } catch (NumberFormatException unused) {
        }
        return i10;
    }

    public static long x(long j4, float f10) {
        return f10 == 1.0f ? j4 : Math.round(j4 * ((double) f10));
    }

    public static long y(long j4) {
        return j4 == -9223372036854775807L ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + j4;
    }

    public static int z(int i10, ByteOrder byteOrder) {
        if (i10 == 8) {
            return 3;
        }
        if (i10 == 16) {
            return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 2 : 268435456;
        }
        if (i10 == 24) {
            return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 21 : 1342177280;
        }
        if (i10 != 32) {
            return 0;
        }
        return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 22 : 1610612736;
    }
}
