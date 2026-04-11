package ue;

import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f13015c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f13016d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f13018b;

    public q(String str, String[] strArr) {
        this.f13017a = str;
        this.f13018b = strArr;
    }

    public final Charset a(Charset charset) {
        String str;
        String[] strArr = this.f13018b;
        int i = 0;
        int iO = cf.d.o(0, strArr.length - 1, 2);
        if (iO < 0) {
            str = null;
            break;
        }
        while (!ie.n.I(strArr[i], "charset")) {
            if (i == iO) {
                str = null;
                break;
            }
            i += 2;
        }
        str = strArr[i + 1];
        if (str == null) {
            return charset;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof q) && be.h.a(((q) obj).f13017a, this.f13017a);
    }

    public final int hashCode() {
        return this.f13017a.hashCode();
    }

    public final String toString() {
        return this.f13017a;
    }
}
