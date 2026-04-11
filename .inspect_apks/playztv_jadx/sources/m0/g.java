package m0;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f8281b = a(new Locale[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f8282a;

    public g(i iVar) {
        this.f8282a = iVar;
    }

    public static g a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? new g(new j(d.a(localeArr))) : new g(new h(localeArr));
    }

    public static g b(String str) {
        if (str == null || str.isEmpty()) {
            return f8281b;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            String str2 = strArrSplit[i];
            int i10 = f.f8280a;
            localeArr[i] = Locale.forLanguageTag(str2);
        }
        return a(localeArr);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f8282a.equals(((g) obj).f8282a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8282a.hashCode();
    }

    public final String toString() {
        return this.f8282a.toString();
    }
}
