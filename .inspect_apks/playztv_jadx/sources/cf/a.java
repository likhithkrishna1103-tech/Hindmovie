package cf;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f2728d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2729c;

    static {
        f2728d = pa.b.h() && Build.VERSION.SDK_INT >= 29;
    }

    public a() {
        int i = 0;
        ArrayList arrayListX = od.h.X(new df.n[]{(!pa.b.h() || Build.VERSION.SDK_INT < 29) ? null : new df.a(), new df.m(df.f.f), new df.m(df.k.f4210a), new df.m(df.h.f4206a)});
        ArrayList arrayList = new ArrayList();
        int size = arrayListX.size();
        while (i < size) {
            Object obj = arrayListX.get(i);
            i++;
            if (((df.n) obj).c()) {
                arrayList.add(obj);
            }
        }
        this.f2729c = arrayList;
    }

    @Override // cf.n
    public final com.bumptech.glide.c b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        df.b bVar = x509TrustManagerExtensions != null ? new df.b(x509TrustManager, x509TrustManagerExtensions) : null;
        return bVar != null ? bVar : new gf.a(c(x509TrustManager));
    }

    @Override // cf.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        Object obj;
        be.h.e(list, "protocols");
        ArrayList arrayList = this.f2729c;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            if (((df.n) obj).a(sSLSocket)) {
                break;
            }
        }
        df.n nVar = (df.n) obj;
        if (nVar != null) {
            nVar.d(sSLSocket, str, list);
        }
    }

    @Override // cf.n
    public final String f(SSLSocket sSLSocket) {
        Object obj;
        ArrayList arrayList = this.f2729c;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            if (((df.n) obj).a(sSLSocket)) {
                break;
            }
        }
        df.n nVar = (df.n) obj;
        if (nVar != null) {
            return nVar.b(sSLSocket);
        }
        return null;
    }

    @Override // cf.n
    public final boolean h(String str) {
        be.h.e(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
