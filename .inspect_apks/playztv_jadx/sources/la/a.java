package la;

import aa.c1;
import aa.g0;
import aa.j0;
import aa.o0;
import aa.q;
import android.os.Bundle;
import k8.c2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f8063a = o0.t("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c1 f8064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c1 f8065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c1 f8066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c1 f8067e;
    public static final c1 f;

    static {
        Object[] objArr = {"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd"};
        q.b(7, objArr);
        f8064b = j0.l(7, objArr);
        Object[] objArr2 = {"auto", "app", "am"};
        q.b(3, objArr2);
        f8065c = j0.l(3, objArr2);
        f8066d = j0.w("_r", "_dbg");
        g0 g0Var = new g0(4);
        g0Var.b(c2.f7114e);
        g0Var.b(c2.f);
        f8067e = g0Var.g();
        f = j0.w("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }

    public static boolean a(String str, Bundle bundle) {
        if (!f8064b.contains(str)) {
            if (bundle == null) {
                return true;
            }
            c1 c1Var = f8066d;
            int i = c1Var.f652x;
            int i10 = 0;
            while (i10 < i) {
                Object obj = c1Var.get(i10);
                i10++;
                if (bundle.containsKey((String) obj)) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean b(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            if (str.equals("fcm") || str.equals("frc")) {
                return true;
            }
        } else if ("_ln".equals(str2)) {
            if (str.equals("fcm") || str.equals("fiam")) {
                return true;
            }
        } else if (!f8067e.contains(str2)) {
            c1 c1Var = f;
            int i = c1Var.f652x;
            int i10 = 0;
            while (i10 < i) {
                Object obj = c1Var.get(i10);
                i10++;
                if (str2.matches((String) obj)) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean c(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (d(str) && bundle != null) {
            c1 c1Var = f8066d;
            int i = c1Var.f652x;
            int i10 = 0;
            while (true) {
                if (i10 >= i) {
                    str.getClass();
                    switch (str) {
                        case "fcm":
                            bundle.putString("_cis", "fcm_integration");
                            return true;
                        case "fdl":
                            bundle.putString("_cis", "fdl_integration");
                            return true;
                        case "fiam":
                            bundle.putString("_cis", "fiam_integration");
                            return true;
                    }
                }
                Object obj = c1Var.get(i10);
                i10++;
                if (bundle.containsKey((String) obj)) {
                    break;
                }
            }
        }
        return false;
    }

    public static boolean d(String str) {
        return !f8065c.contains(str);
    }
}
