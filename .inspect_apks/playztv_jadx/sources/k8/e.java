package k8;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends c3.e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Boolean f7144w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f7145x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f f7146y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Boolean f7147z;

    public final boolean A1(String str, f0 f0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) f0Var.a(null)).booleanValue();
        }
        String strB = this.f7146y.B(str, f0Var.f7169a);
        return TextUtils.isEmpty(strB) ? ((Boolean) f0Var.a(null)).booleanValue() : ((Boolean) f0Var.a(Boolean.valueOf("1".equals(strB)))).booleanValue();
    }

    public final boolean B1(String str) {
        return "1".equals(this.f7146y.B(str, "measurement.event_sampling_enabled"));
    }

    public final boolean C1() {
        Boolean boolY1 = y1("google_analytics_automatic_screen_reporting_enabled");
        return boolY1 == null || boolY1.booleanValue();
    }

    public final boolean D1() {
        if (this.f7144w == null) {
            Boolean boolY1 = y1("app_measurement_lite");
            this.f7144w = boolY1;
            if (boolY1 == null) {
                this.f7144w = Boolean.FALSE;
            }
        }
        return this.f7144w.booleanValue() || !((k1) this.f2454v).f7286y;
    }

    public final double q1(String str, f0 f0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) f0Var.a(null)).doubleValue();
        }
        String strB = this.f7146y.B(str, f0Var.f7169a);
        if (TextUtils.isEmpty(strB)) {
            return ((Double) f0Var.a(null)).doubleValue();
        }
        try {
            return ((Double) f0Var.a(Double.valueOf(Double.parseDouble(strB)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) f0Var.a(null)).doubleValue();
        }
    }

    public final String r1(String str) {
        try {
            String str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            t7.v.h(str2);
            return str2;
        } catch (ClassNotFoundException e10) {
            g().A.c(e10, "Could not find SystemProperties class");
            return "";
        } catch (IllegalAccessException e11) {
            g().A.c(e11, "Could not access SystemProperties.get()");
            return "";
        } catch (NoSuchMethodException e12) {
            g().A.c(e12, "Could not find SystemProperties.get() method");
            return "";
        } catch (InvocationTargetException e13) {
            g().A.c(e13, "SystemProperties.get() threw an exception");
            return "";
        }
    }

    public final boolean s1(f0 f0Var) {
        return A1(null, f0Var);
    }

    public final Bundle t1() {
        k1 k1Var = (k1) this.f2454v;
        try {
            if (k1Var.f7282u.getPackageManager() == null) {
                g().A.d("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoB = z7.b.a(k1Var.f7282u).b(k1Var.f7282u.getPackageName(), 128);
            if (applicationInfoB != null) {
                return applicationInfoB.metaData;
            }
            g().A.d("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            g().A.c(e10, "Failed to load metadata: Package name not found");
            return null;
        }
    }

    public final int u1(String str, f0 f0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) f0Var.a(null)).intValue();
        }
        String strB = this.f7146y.B(str, f0Var.f7169a);
        if (TextUtils.isEmpty(strB)) {
            return ((Integer) f0Var.a(null)).intValue();
        }
        try {
            return ((Integer) f0Var.a(Integer.valueOf(Integer.parseInt(strB)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) f0Var.a(null)).intValue();
        }
    }

    public final long v1(String str, f0 f0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) f0Var.a(null)).longValue();
        }
        String strB = this.f7146y.B(str, f0Var.f7169a);
        if (TextUtils.isEmpty(strB)) {
            return ((Long) f0Var.a(null)).longValue();
        }
        try {
            return ((Long) f0Var.a(Long.valueOf(Long.parseLong(strB)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) f0Var.a(null)).longValue();
        }
    }

    public final b2 w1(String str, boolean z2) {
        Object obj;
        t7.v.d(str);
        Bundle bundleT1 = t1();
        if (bundleT1 == null) {
            g().A.d("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleT1.get(str);
        }
        b2 b2Var = b2.f7089v;
        if (obj == null) {
            return b2Var;
        }
        if (Boolean.TRUE.equals(obj)) {
            return b2.f7092y;
        }
        if (Boolean.FALSE.equals(obj)) {
            return b2.f7091x;
        }
        if (z2 && "eu_consent_policy".equals(obj)) {
            return b2.f7090w;
        }
        g().D.c(str, "Invalid manifest metadata for");
        return b2Var;
    }

    public final String x1(String str, f0 f0Var) {
        return TextUtils.isEmpty(str) ? (String) f0Var.a(null) : (String) f0Var.a(this.f7146y.B(str, f0Var.f7169a));
    }

    public final Boolean y1(String str) {
        t7.v.d(str);
        Bundle bundleT1 = t1();
        if (bundleT1 == null) {
            g().A.d("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleT1.containsKey(str)) {
            return Boolean.valueOf(bundleT1.getBoolean(str));
        }
        return null;
    }

    public final boolean z1(String str, f0 f0Var) {
        return A1(str, f0Var);
    }
}
