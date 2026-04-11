package fb;

import android.os.Bundle;
import f9.h2;
import ua.f0;
import ua.i0;
import ua.m0;
import ua.q;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f4528a = m0.m("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z0 f4529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z0 f4530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final z0 f4531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final z0 f4532e;
    public static final z0 f;

    static {
        Object[] objArr = {"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd"};
        q.b(7, objArr);
        f4529b = i0.i(7, objArr);
        Object[] objArr2 = {"auto", "app", "am"};
        q.b(3, objArr2);
        f4530c = i0.i(3, objArr2);
        f4531d = i0.p("_r", "_dbg");
        f0 f0Var = new f0(4);
        f0Var.b(h2.i);
        f0Var.b(h2.f4211j);
        f4532e = f0Var.g();
        f = i0.p("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }

    public static boolean a(String str) {
        return !f4530c.contains(str);
    }

    public static boolean b(String str, Bundle bundle) {
        if (!f4529b.contains(str)) {
            if (bundle == null) {
                return true;
            }
            z0 z0Var = f4531d;
            int i = z0Var.f12415y;
            int i10 = 0;
            while (i10 < i) {
                boolean zContainsKey = bundle.containsKey((String) z0Var.get(i10));
                i10++;
                if (zContainsKey) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean c(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            if (str.equals("fcm") || str.equals("frc")) {
                return true;
            }
        } else if ("_ln".equals(str2)) {
            if (str.equals("fcm") || str.equals("fiam")) {
                return true;
            }
        } else if (!f4532e.contains(str2)) {
            z0 z0Var = f;
            int i = z0Var.f12415y;
            int i10 = 0;
            while (i10 < i) {
                boolean zMatches = str2.matches((String) z0Var.get(i10));
                i10++;
                if (zMatches) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean d(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (a(str) && bundle != null) {
            z0 z0Var = f4531d;
            int i = z0Var.f12415y;
            int i10 = 0;
            while (true) {
                if (i10 >= i) {
                    int iHashCode = str.hashCode();
                    if (iHashCode != 101200) {
                        if (iHashCode != 101230) {
                            if (iHashCode == 3142703 && str.equals("fiam")) {
                                bundle.putString("_cis", "fiam_integration");
                                return true;
                            }
                        } else if (str.equals("fdl")) {
                            bundle.putString("_cis", "fdl_integration");
                            return true;
                        }
                    } else if (str.equals("fcm")) {
                        bundle.putString("_cis", "fcm_integration");
                        return true;
                    }
                } else {
                    boolean zContainsKey = bundle.containsKey((String) z0Var.get(i10));
                    i10++;
                    if (zContainsKey) {
                        break;
                    }
                }
            }
        }
        return false;
    }
}
