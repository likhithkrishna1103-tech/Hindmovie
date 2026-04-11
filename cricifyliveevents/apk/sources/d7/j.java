package d7;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements x6.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f3488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final URL f3489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3491e;
    public URL f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile byte[] f3492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3493h;

    public j(URL url) {
        n nVar = k.f3494a;
        s7.f.c(url, "Argument must not be null");
        this.f3489c = url;
        this.f3490d = null;
        s7.f.c(nVar, "Argument must not be null");
        this.f3488b = nVar;
    }

    @Override // x6.e
    public final void a(MessageDigest messageDigest) {
        if (this.f3492g == null) {
            this.f3492g = c().getBytes(x6.e.f14397a);
        }
        messageDigest.update(this.f3492g);
    }

    public final String c() {
        String str = this.f3490d;
        if (str != null) {
            return str;
        }
        URL url = this.f3489c;
        s7.f.c(url, "Argument must not be null");
        return url.toString();
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f3491e)) {
            String string = this.f3490d;
            if (TextUtils.isEmpty(string)) {
                URL url = this.f3489c;
                s7.f.c(url, "Argument must not be null");
                string = url.toString();
            }
            this.f3491e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$[]");
        }
        return this.f3491e;
    }

    @Override // x6.e
    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (c().equals(jVar.c()) && this.f3488b.equals(jVar.f3488b)) {
                return true;
            }
        }
        return false;
    }

    @Override // x6.e
    public final int hashCode() {
        if (this.f3493h == 0) {
            int iHashCode = c().hashCode();
            this.f3493h = iHashCode;
            this.f3493h = this.f3488b.hashCode() + (iHashCode * 31);
        }
        return this.f3493h;
    }

    public final String toString() {
        return c();
    }

    public j(String str) {
        n nVar = k.f3494a;
        this.f3489c = null;
        if (!TextUtils.isEmpty(str)) {
            this.f3490d = str;
            s7.f.c(nVar, "Argument must not be null");
            this.f3488b = nVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
