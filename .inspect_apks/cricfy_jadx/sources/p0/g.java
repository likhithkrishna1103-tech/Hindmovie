package p0;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f9873b = a(new Locale[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f9874a;

    public g(i iVar) {
        this.f9874a = iVar;
    }

    public static g a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? new g(new j(d.a(localeArr))) : new g(new h(localeArr));
    }

    public static g b(String str) {
        if (str == null || str.isEmpty()) {
            return f9873b;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            String str2 = strArrSplit[i];
            int i10 = f.f9872a;
            localeArr[i] = Locale.forLanguageTag(str2);
        }
        return a(localeArr);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f9874a.equals(((g) obj).f9874a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9874a.hashCode();
    }

    public final String toString() {
        return this.f9874a.toString();
    }
}
