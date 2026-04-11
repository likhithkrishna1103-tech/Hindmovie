package f9;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends a7.a {
    public Boolean A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Boolean f4183x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f4184y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public f f4185z;

    public final boolean A1() {
        Boolean boolY1 = y1("google_analytics_automatic_screen_reporting_enabled");
        return boolY1 == null || boolY1.booleanValue();
    }

    public final d2 B1(String str, boolean z10) {
        Object obj;
        o8.u.d(str);
        r1 r1Var = (r1) this.f307w;
        Bundle bundleX1 = x1();
        if (bundleX1 == null) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.a("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleX1.get(str);
        }
        d2 d2Var = d2.f4070w;
        if (obj == null) {
            return d2Var;
        }
        if (Boolean.TRUE.equals(obj)) {
            return d2.f4073z;
        }
        if (Boolean.FALSE.equals(obj)) {
            return d2.f4072y;
        }
        if (z10 && "eu_consent_policy".equals(obj)) {
            return d2.f4071x;
        }
        w0 w0Var2 = r1Var.A;
        r1.g(w0Var2);
        w0Var2.E.b(str, "Invalid manifest metadata for");
        return d2Var;
    }

    public final boolean n1(String str) {
        return "1".equals(this.f4185z.B(str, "gaia_collection_enabled"));
    }

    public final boolean o1(String str) {
        return "1".equals(this.f4185z.B(str, "measurement.event_sampling_enabled"));
    }

    public final boolean p1() {
        if (this.f4183x == null) {
            Boolean boolY1 = y1("app_measurement_lite");
            this.f4183x = boolY1;
            if (boolY1 == null) {
                this.f4183x = Boolean.FALSE;
            }
        }
        return this.f4183x.booleanValue() || !((r1) this.f307w).f4364w;
    }

    public final String q1(String str) {
        r1 r1Var = (r1) this.f307w;
        try {
            String str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            o8.u.g(str2);
            return str2;
        } catch (ClassNotFoundException e9) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.b(e9, "Could not find SystemProperties class");
            return "";
        } catch (IllegalAccessException e10) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.B.b(e10, "Could not access SystemProperties.get()");
            return "";
        } catch (NoSuchMethodException e11) {
            w0 w0Var3 = r1Var.A;
            r1.g(w0Var3);
            w0Var3.B.b(e11, "Could not find SystemProperties.get() method");
            return "";
        } catch (InvocationTargetException e12) {
            w0 w0Var4 = r1Var.A;
            r1.g(w0Var4);
            w0Var4.B.b(e12, "SystemProperties.get() threw an exception");
            return "";
        }
    }

    public final void r1() {
        ((r1) this.f307w).getClass();
    }

    public final String s1(String str, e0 e0Var) {
        return TextUtils.isEmpty(str) ? (String) e0Var.a(null) : (String) e0Var.a(this.f4185z.B(str, e0Var.f4088a));
    }

    public final long t1(String str, e0 e0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) e0Var.a(null)).longValue();
        }
        String strB = this.f4185z.B(str, e0Var.f4088a);
        if (TextUtils.isEmpty(strB)) {
            return ((Long) e0Var.a(null)).longValue();
        }
        try {
            return ((Long) e0Var.a(Long.valueOf(Long.parseLong(strB)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) e0Var.a(null)).longValue();
        }
    }

    public final int u1(String str, e0 e0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) e0Var.a(null)).intValue();
        }
        String strB = this.f4185z.B(str, e0Var.f4088a);
        if (TextUtils.isEmpty(strB)) {
            return ((Integer) e0Var.a(null)).intValue();
        }
        try {
            return ((Integer) e0Var.a(Integer.valueOf(Integer.parseInt(strB)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) e0Var.a(null)).intValue();
        }
    }

    public final double v1(String str, e0 e0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) e0Var.a(null)).doubleValue();
        }
        String strB = this.f4185z.B(str, e0Var.f4088a);
        if (TextUtils.isEmpty(strB)) {
            return ((Double) e0Var.a(null)).doubleValue();
        }
        try {
            return ((Double) e0Var.a(Double.valueOf(Double.parseDouble(strB)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) e0Var.a(null)).doubleValue();
        }
    }

    public final boolean w1(String str, e0 e0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) e0Var.a(null)).booleanValue();
        }
        String strB = this.f4185z.B(str, e0Var.f4088a);
        return TextUtils.isEmpty(strB) ? ((Boolean) e0Var.a(null)).booleanValue() : ((Boolean) e0Var.a(Boolean.valueOf("1".equals(strB)))).booleanValue();
    }

    public final Bundle x1() {
        r1 r1Var = (r1) this.f307w;
        try {
            Context context = r1Var.f4363v;
            Context context2 = r1Var.f4363v;
            w0 w0Var = r1Var.A;
            if (context.getPackageManager() == null) {
                r1.g(w0Var);
                w0Var.B.a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoA = u8.b.a(context2).a(128, context2.getPackageName());
            if (applicationInfoA != null) {
                return applicationInfoA.metaData;
            }
            r1.g(w0Var);
            w0Var.B.a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e9) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.B.b(e9, "Failed to load metadata: Package name not found");
            return null;
        }
    }

    public final Boolean y1(String str) {
        o8.u.d(str);
        Bundle bundleX1 = x1();
        if (bundleX1 != null) {
            if (bundleX1.containsKey(str)) {
                return Boolean.valueOf(bundleX1.getBoolean(str));
            }
            return null;
        }
        w0 w0Var = ((r1) this.f307w).A;
        r1.g(w0Var);
        w0Var.B.a("Failed to load metadata: Metadata bundle is null");
        return null;
    }

    public final boolean z1() {
        ((r1) this.f307w).getClass();
        Boolean boolY1 = y1("firebase_analytics_collection_deactivated");
        return boolY1 != null && boolY1.booleanValue();
    }
}
