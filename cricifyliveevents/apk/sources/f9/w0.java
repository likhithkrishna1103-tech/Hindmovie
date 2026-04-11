package f9;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 extends b2 {
    public String A;
    public final u0 B;
    public final u0 C;
    public final u0 D;
    public final u0 E;
    public final u0 F;
    public final u0 G;
    public final u0 H;
    public final u0 I;
    public final u0 J;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public char f4454y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f4455z;

    public w0(r1 r1Var) {
        super(r1Var);
        this.f4454y = (char) 0;
        this.f4455z = -1L;
        this.B = new u0(this, 6, false, false);
        this.C = new u0(this, 6, true, false);
        this.D = new u0(this, 6, false, true);
        this.E = new u0(this, 5, false, false);
        this.F = new u0(this, 5, true, false);
        this.G = new u0(this, 5, false, true);
        this.H = new u0(this, 4, false, false);
        this.I = new u0(this, 3, false, false);
        this.J = new u0(this, 2, false, false);
    }

    public static v0 u1(String str) {
        if (str == null) {
            return null;
        }
        return new v0(str);
    }

    public static String x1(boolean z10, String str, Object obj, Object obj2, Object obj3) {
        String strY1 = y1(obj, z10);
        String strY12 = y1(obj2, z10);
        String strY13 = y1(obj3, z10);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strY1)) {
            sb.append(str2);
            sb.append(strY1);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strY12)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strY12);
        }
        if (!TextUtils.isEmpty(strY13)) {
            sb.append(str3);
            sb.append(strY13);
        }
        return sb.toString();
    }

    public static String y1(Object obj, boolean z10) {
        int iLastIndexOf;
        String className;
        int iLastIndexOf2;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z10) {
                return obj.toString();
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return obj.toString();
            }
            char cCharAt = obj.toString().charAt(0);
            String strValueOf = String.valueOf(Math.abs(l10.longValue()));
            long jRound = Math.round(Math.pow(10.0d, strValueOf.length() - 1));
            long jRound2 = Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
            int length = String.valueOf(jRound).length();
            String str = cCharAt == '-' ? "-" : "";
            StringBuilder sb = new StringBuilder(str.length() + str.length() + length + 3 + String.valueOf(jRound2).length());
            sb.append(str);
            sb.append(jRound);
            sb.append("...");
            sb.append(str);
            sb.append(jRound2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof v0 ? ((v0) obj).f4445a : z10 ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z10 ? th.getClass().getName() : th.toString());
        String canonicalName = r1.class.getCanonicalName();
        String strSubstring = (TextUtils.isEmpty(canonicalName) || (iLastIndexOf = canonicalName.lastIndexOf(46)) == -1) ? "" : canonicalName.substring(0, iLastIndexOf);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length2 = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length2) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                if (((TextUtils.isEmpty(className) || (iLastIndexOf2 = className.lastIndexOf(46)) == -1) ? "" : className.substring(0, iLastIndexOf2)).equals(strSubstring)) {
                    sb2.append(": ");
                    sb2.append(stackTraceElement);
                    break;
                }
            }
            i++;
        }
        return sb2.toString();
    }

    @Override // f9.b2
    public final boolean n1() {
        return false;
    }

    public final u0 q1() {
        return this.B;
    }

    public final u0 r1() {
        return this.E;
    }

    public final u0 s1() {
        return this.I;
    }

    public final u0 t1() {
        return this.J;
    }

    public final void v1(int i, boolean z10, boolean z11, String str, Object obj, Object obj2, Object obj3) {
        if (!z10 && Log.isLoggable(w1(), i)) {
            Log.println(i, w1(), x1(false, str, obj, obj2, obj3));
        }
        if (z11 || i < 5) {
            return;
        }
        o8.u.g(str);
        p1 p1Var = ((r1) this.f307w).B;
        if (p1Var == null) {
            Log.println(6, w1(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!p1Var.f4048x) {
                Log.println(6, w1(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i >= 9) {
                i = 8;
            }
            p1Var.v1(new t0(this, i, str, obj, obj2, obj3));
        }
    }

    public final String w1() {
        String str;
        synchronized (this) {
            try {
                if (this.A == null) {
                    ((r1) ((r1) this.f307w).f4366y.f307w).getClass();
                    this.A = "FA";
                }
                o8.u.g(this.A);
                str = this.A;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
