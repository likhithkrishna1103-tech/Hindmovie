package i6;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements c6.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f6401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final URL f6402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6404e;
    public URL f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile byte[] f6405g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6406h;

    public h(URL url) {
        l lVar = i.f6407a;
        x6.f.c(url, "Argument must not be null");
        this.f6402c = url;
        this.f6403d = null;
        x6.f.c(lVar, "Argument must not be null");
        this.f6401b = lVar;
    }

    @Override // c6.f
    public final void b(MessageDigest messageDigest) {
        if (this.f6405g == null) {
            this.f6405g = c().getBytes(c6.f.f2515a);
        }
        messageDigest.update(this.f6405g);
    }

    public final String c() {
        String str = this.f6403d;
        if (str != null) {
            return str;
        }
        URL url = this.f6402c;
        x6.f.c(url, "Argument must not be null");
        return url.toString();
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f6404e)) {
            String string = this.f6403d;
            if (TextUtils.isEmpty(string)) {
                URL url = this.f6402c;
                x6.f.c(url, "Argument must not be null");
                string = url.toString();
            }
            this.f6404e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f6404e;
    }

    @Override // c6.f
    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (c().equals(hVar.c()) && this.f6401b.equals(hVar.f6401b)) {
                return true;
            }
        }
        return false;
    }

    @Override // c6.f
    public final int hashCode() {
        if (this.f6406h == 0) {
            int iHashCode = c().hashCode();
            this.f6406h = iHashCode;
            this.f6406h = this.f6401b.hashCode() + (iHashCode * 31);
        }
        return this.f6406h;
    }

    public final String toString() {
        return c();
    }

    public h(String str) {
        l lVar = i.f6407a;
        this.f6402c = null;
        if (!TextUtils.isEmpty(str)) {
            this.f6403d = str;
            x6.f.c(lVar, "Argument must not be null");
            this.f6401b = lVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
