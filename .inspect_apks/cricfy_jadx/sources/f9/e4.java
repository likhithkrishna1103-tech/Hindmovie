package f9;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ua.z0 f4107a = ua.i0.q("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");

    public static String a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    public static final boolean b(com.google.android.gms.internal.measurement.s4 s4Var, ua.e1 e1Var, ua.k0 k0Var, ua.l1 l1Var, char[] cArr, int i, int i10, int i11, String str, String str2, String str3, boolean z10, boolean z11) {
        d4 d4Var;
        char c9;
        int iC = c(s4Var);
        if (iC > 0 && (i10 != 1 || i != 1)) {
            cArr[iC] = '2';
        }
        if (g(s4Var, k0Var) == com.google.android.gms.internal.measurement.t4.f2636w) {
            c9 = '3';
        } else {
            if (s4Var == com.google.android.gms.internal.measurement.s4.f2604w && i11 == 1 && l1Var.f12357y.equals(str)) {
                if (iC > 0 && cArr[iC] != '2') {
                    cArr[iC] = '1';
                }
                return true;
            }
            if (e1Var.containsKey(s4Var) && (d4Var = (d4) e1Var.get(s4Var)) != null) {
                int iOrdinal = d4Var.ordinal();
                com.google.android.gms.internal.measurement.t4 t4Var = com.google.android.gms.internal.measurement.t4.f2638y;
                if (iOrdinal != 0) {
                    com.google.android.gms.internal.measurement.t4 t4Var2 = com.google.android.gms.internal.measurement.t4.f2637x;
                    if (iOrdinal != 1) {
                        if (iOrdinal == 2) {
                            return g(s4Var, k0Var) == t4Var ? f(s4Var, cArr, str3, z11) : e(s4Var, cArr, str2, z10);
                        }
                        if (iOrdinal == 3) {
                            return g(s4Var, k0Var) == t4Var2 ? e(s4Var, cArr, str2, z10) : f(s4Var, cArr, str3, z11);
                        }
                        c9 = '0';
                    } else if (g(s4Var, k0Var) != t4Var2) {
                        return f(s4Var, cArr, str3, z11);
                    }
                } else if (g(s4Var, k0Var) != t4Var) {
                    return e(s4Var, cArr, str2, z10);
                }
                c9 = '8';
            } else {
                c9 = '0';
            }
        }
        if (iC <= 0 || cArr[iC] == '2') {
            return false;
        }
        cArr[iC] = c9;
        return false;
    }

    public static final int c(com.google.android.gms.internal.measurement.s4 s4Var) {
        if (s4Var == com.google.android.gms.internal.measurement.s4.f2604w) {
            return 1;
        }
        if (s4Var == com.google.android.gms.internal.measurement.s4.f2606y) {
            return 2;
        }
        if (s4Var == com.google.android.gms.internal.measurement.s4.f2607z) {
            return 3;
        }
        return s4Var == com.google.android.gms.internal.measurement.s4.A ? 4 : -1;
    }

    public static final String d(com.google.android.gms.internal.measurement.s4 s4Var, String str, String str2) {
        String strValueOf = "0";
        String strValueOf2 = (TextUtils.isEmpty(str) || str.length() < s4Var.a()) ? "0" : String.valueOf(str.charAt(s4Var.a() - 1));
        if (!TextUtils.isEmpty(str2) && str2.length() >= s4Var.a()) {
            strValueOf = String.valueOf(str2.charAt(s4Var.a() - 1));
        }
        return String.valueOf(strValueOf2).concat(String.valueOf(strValueOf));
    }

    public static final boolean e(com.google.android.gms.internal.measurement.s4 s4Var, char[] cArr, String str, boolean z10) {
        char c9;
        int iC = c(s4Var);
        if (!z10) {
            c9 = '4';
        } else {
            if (str.length() >= s4Var.a()) {
                char cCharAt = str.charAt(s4Var.a() - 1);
                boolean z11 = cCharAt == '1';
                if (iC > 0 && cArr[iC] != '2') {
                    cArr[iC] = cCharAt != '1' ? '6' : '1';
                }
                return z11;
            }
            c9 = '0';
        }
        if (iC > 0 && cArr[iC] != '2') {
            cArr[iC] = c9;
        }
        return false;
    }

    public static final boolean f(com.google.android.gms.internal.measurement.s4 s4Var, char[] cArr, String str, boolean z10) {
        char c9;
        int iC = c(s4Var);
        if (!z10) {
            c9 = '5';
        } else {
            if (str.length() >= s4Var.a()) {
                char cCharAt = str.charAt(s4Var.a() - 1);
                boolean z11 = cCharAt == '1';
                if (iC > 0 && cArr[iC] != '2') {
                    cArr[iC] = cCharAt != '1' ? '7' : '1';
                }
                return z11;
            }
            c9 = '0';
        }
        if (iC > 0 && cArr[iC] != '2') {
            cArr[iC] = c9;
        }
        return false;
    }

    public static final com.google.android.gms.internal.measurement.t4 g(com.google.android.gms.internal.measurement.s4 s4Var, ua.k0 k0Var) {
        Object obj = k0Var.get(s4Var);
        if (obj == null) {
            obj = com.google.android.gms.internal.measurement.t4.f2639z;
        }
        return (com.google.android.gms.internal.measurement.t4) obj;
    }
}
