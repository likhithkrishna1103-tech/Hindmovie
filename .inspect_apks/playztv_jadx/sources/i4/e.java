package i4;

import android.content.res.Resources;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements v0, q6.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Resources f6220u;

    public e(Resources resources, int i) {
        switch (i) {
            case 1:
                this.f6220u = resources;
                break;
            default:
                resources.getClass();
                this.f6220u = resources;
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(p1.q r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.f10015d
            java.lang.String r1 = r8.f10013b
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r3 = ""
            if (r2 != 0) goto L42
            java.lang.String r2 = "und"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L15
            goto L42
        L15:
            int r2 = s1.b0.f11647a
            r4 = 21
            if (r2 < r4) goto L20
            java.util.Locale r0 = java.util.Locale.forLanguageTag(r0)
            goto L26
        L20:
            java.util.Locale r2 = new java.util.Locale
            r2.<init>(r0)
            r0 = r2
        L26:
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r2 < r4) goto L34
            j2.e.l()
            java.util.Locale r2 = j2.e.m()
            goto L38
        L34:
            java.util.Locale r2 = java.util.Locale.getDefault()
        L38:
            java.lang.String r0 = r0.getDisplayName(r2)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L44
        L42:
            r0 = r3
            goto L65
        L44:
            r4 = 1
            r5 = 0
            int r4 = r0.offsetByCodePoints(r5, r4)     // Catch: java.lang.IndexOutOfBoundsException -> L65
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.IndexOutOfBoundsException -> L65
            r6.<init>()     // Catch: java.lang.IndexOutOfBoundsException -> L65
            java.lang.String r5 = r0.substring(r5, r4)     // Catch: java.lang.IndexOutOfBoundsException -> L65
            java.lang.String r2 = r5.toUpperCase(r2)     // Catch: java.lang.IndexOutOfBoundsException -> L65
            r6.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> L65
            java.lang.String r2 = r0.substring(r4)     // Catch: java.lang.IndexOutOfBoundsException -> L65
            r6.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> L65
            java.lang.String r0 = r6.toString()     // Catch: java.lang.IndexOutOfBoundsException -> L65
        L65:
            java.lang.String r8 = r7.b(r8)
            java.lang.String[] r8 = new java.lang.String[]{r0, r8}
            java.lang.String r8 = r7.d(r8)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L7f
            boolean r8 = android.text.TextUtils.isEmpty(r1)
            if (r8 == 0) goto L7e
            r1 = r3
        L7e:
            r8 = r1
        L7f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.e.a(p1.q):java.lang.String");
    }

    public String b(p1.q qVar) {
        int i = qVar.f;
        int i10 = qVar.f;
        int i11 = i & 2;
        Resources resources = this.f6220u;
        String string = i11 != 0 ? resources.getString(l0.exo_track_role_alternate) : "";
        if ((i10 & 4) != 0) {
            string = d(string, resources.getString(l0.exo_track_role_supplementary));
        }
        if ((i10 & 8) != 0) {
            string = d(string, resources.getString(l0.exo_track_role_commentary));
        }
        return (i10 & 1088) != 0 ? d(string, resources.getString(l0.exo_track_role_closed_captions)) : string;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String c(p1.q r13) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.e.c(p1.q):java.lang.String");
    }

    public String d(String... strArr) {
        String string = "";
        for (String str : strArr) {
            if (str.length() > 0) {
                string = TextUtils.isEmpty(string) ? str : this.f6220u.getString(l0.exo_item_list, string, str);
            }
        }
        return string;
    }

    @Override // q6.a
    public e6.b0 f(e6.b0 b0Var, c6.i iVar) {
        if (b0Var == null) {
            return null;
        }
        return new l6.d(this.f6220u, b0Var);
    }
}
