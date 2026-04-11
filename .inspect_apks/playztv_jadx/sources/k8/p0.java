package k8;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.b8;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p0 extends x1 {
    public final r0 A;
    public final r0 B;
    public final r0 C;
    public final r0 D;
    public final r0 E;
    public final r0 F;
    public final r0 G;
    public final r0 H;
    public final r0 I;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public char f7362x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f7363y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f7364z;

    public p0(k1 k1Var) {
        super(k1Var);
        this.f7362x = (char) 0;
        this.f7363y = -1L;
        this.A = new r0(this, 6, false, false);
        this.B = new r0(this, 6, true, false);
        this.C = new r0(this, 6, false, true);
        this.D = new r0(this, 5, false, false);
        this.E = new r0(this, 5, true, false);
        this.F = new r0(this, 5, false, true);
        this.G = new r0(this, 4, false, false);
        this.H = new r0(this, 3, false, false);
        this.I = new r0(this, 2, false, false);
    }

    public static String t1(Object obj, boolean z2) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z2) {
                return String.valueOf(obj);
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String strValueOf = String.valueOf(Math.abs(l10.longValue()));
            return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof q0 ? ((q0) obj).f7379a : z2 ? "-" : String.valueOf(obj);
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z2 ? th.getClass().getName() : th.toString());
        String strY1 = y1(k1.class.getCanonicalName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && y1(className).equals(strY1)) {
                sb2.append(": ");
                sb2.append(stackTraceElement);
                break;
            }
            i++;
        }
        return sb2.toString();
    }

    public static String u1(boolean z2, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strT1 = t1(obj, z2);
        String strT12 = t1(obj2, z2);
        String strT13 = t1(obj3, z2);
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strT1)) {
            sb2.append(str2);
            sb2.append(strT1);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strT12)) {
            str3 = str2;
        } else {
            sb2.append(str2);
            sb2.append(strT12);
        }
        if (!TextUtils.isEmpty(strT13)) {
            sb2.append(str3);
            sb2.append(strT13);
        }
        return sb2.toString();
    }

    public static q0 v1(String str) {
        if (str == null) {
            return null;
        }
        return new q0(str);
    }

    public static String y1(String str) {
        if (!TextUtils.isEmpty(str)) {
            int iLastIndexOf = str.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                return str.substring(0, iLastIndexOf);
            }
            b8.f2904v.get();
            if (!((Boolean) w.G0.a(null)).booleanValue()) {
                return str;
            }
        }
        return "";
    }

    public final r0 A1() {
        return this.A;
    }

    public final r0 B1() {
        return this.I;
    }

    public final r0 C1() {
        return this.D;
    }

    public final String D1() {
        String str;
        synchronized (this) {
            try {
                if (this.f7364z == null) {
                    String str2 = ((k1) this.f2454v).f7285x;
                    if (str2 == null) {
                        str2 = "FA";
                    }
                    this.f7364z = str2;
                }
                t7.v.h(this.f7364z);
                str = this.f7364z;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    @Override // k8.x1
    public final boolean s1() {
        return false;
    }

    public final void w1(int i, boolean z2, boolean z10, String str, Object obj, Object obj2, Object obj3) {
        if (!z2 && x1(i)) {
            Log.println(i, D1(), u1(false, str, obj, obj2, obj3));
        }
        if (z10 || i < 5) {
            return;
        }
        t7.v.h(str);
        h1 h1Var = ((k1) this.f2454v).D;
        if (h1Var == null) {
            Log.println(6, D1(), "Scheduler not set. Not logging error/warn");
            return;
        }
        if (!h1Var.f7539w) {
            Log.println(6, D1(), "Scheduler not initialized. Not logging error/warn");
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i >= 9) {
            i = 8;
        }
        h1Var.y1(new o0(this, i, str, obj, obj2, obj3));
    }

    public final boolean x1(int i) {
        return Log.isLoggable(D1(), i);
    }

    public final r0 z1() {
        return this.H;
    }
}
