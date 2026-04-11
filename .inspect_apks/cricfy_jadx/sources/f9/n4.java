package f9;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n4 extends h4 {
    public static final boolean p1(String str) {
        String str2 = (String) f0.f4154t.a(null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split(",")) {
            if (str.equalsIgnoreCase(str3.trim())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008e, code lost:
    
        if (java.lang.Math.abs(r7.hashCode() % 100) < r9.E().p()) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.m4 n1(java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n4.n1(java.lang.String):f9.m4");
    }

    public final String o1(String str) {
        l1 l1Var = this.f4215x.f4353v;
        q4.P(l1Var);
        String strZ1 = l1Var.z1(str);
        if (TextUtils.isEmpty(strZ1)) {
            return (String) f0.f4150r.a(null);
        }
        Uri uri = Uri.parse((String) f0.f4150r.a(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        String authority = uri.getAuthority();
        StringBuilder sb = new StringBuilder(String.valueOf(strZ1).length() + 1 + String.valueOf(authority).length());
        sb.append(strZ1);
        sb.append(".");
        sb.append(authority);
        builderBuildUpon.authority(sb.toString());
        return builderBuildUpon.build().toString();
    }
}
