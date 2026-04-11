package k8;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.l9;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v3 extends u3 {
    public static String t1(g0 g0Var) {
        Uri.Builder builder = new Uri.Builder();
        String strJ = g0Var.j();
        if (TextUtils.isEmpty(strJ)) {
            strJ = g0Var.d();
        }
        builder.scheme((String) w.f.a(null)).encodedAuthority((String) w.f7479g.a(null)).path("config/app/" + strJ).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "106000").appendQueryParameter("runtime_version", "0");
        return builder.build().toString();
    }

    public final y3 u1(String str) {
        g0 g0VarN2;
        l9.a();
        k1 k1Var = (k1) this.f2454v;
        y3 y3Var = null;
        if (k1Var.A.A1(null, w.f7518x0)) {
            o1();
            if (h4.s2(str)) {
                g().I.d("sgtm feature flag enabled.");
                g0 g0VarN22 = r1().n2(str);
                if (g0VarN22 == null) {
                    return new y3(v1(str), 1);
                }
                String strG = g0VarN22.g();
                com.google.android.gms.internal.measurement.n2 n2VarG1 = s1().G1(str);
                if (n2VarG1 == null || (g0VarN2 = r1().n2(str)) == null || ((!n2VarG1.F() || n2VarG1.w().n() != 100) && !o1().q2(str, g0VarN2.l()) && (!k1Var.A.A1(null, w.f7522z0) ? !(TextUtils.isEmpty(strG) || strG.hashCode() % 100 >= n2VarG1.w().n()) : !(TextUtils.isEmpty(strG) || Math.abs(strG.hashCode() % 100) >= n2VarG1.w().n())))) {
                    return new y3(v1(str), 1);
                }
                if (g0VarN22.o()) {
                    g().I.d("sgtm upload enabled in manifest.");
                    com.google.android.gms.internal.measurement.n2 n2VarG12 = s1().G1(g0VarN22.f());
                    if (n2VarG12 != null && n2VarG12.F()) {
                        String strQ = n2VarG12.w().q();
                        if (!TextUtils.isEmpty(strQ)) {
                            String strP = n2VarG12.w().p();
                            g().I.b(strQ, TextUtils.isEmpty(strP) ? "Y" : "N", "sgtm configured with upload_url, server_info");
                            if (TextUtils.isEmpty(strP)) {
                                y3Var = new y3(strQ, 3);
                            } else {
                                HashMap map = new HashMap();
                                map.put("x-sgtm-server-info", strP);
                                if (!TextUtils.isEmpty(g0VarN22.l())) {
                                    map.put("x-gtm-server-preview", g0VarN22.l());
                                }
                                y3Var = new y3(strQ, map, 3);
                            }
                        }
                    }
                }
                if (y3Var != null) {
                    return y3Var;
                }
            }
        }
        return new y3(v1(str), 1);
    }

    public final String v1(String str) {
        String strK1 = s1().K1(str);
        if (TextUtils.isEmpty(strK1)) {
            return (String) w.f7505r.a(null);
        }
        Uri uri = Uri.parse((String) w.f7505r.a(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.authority(strK1 + "." + uri.getAuthority());
        return builderBuildUpon.build().toString();
    }
}
