package uf;

import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.os.StrictMode;
import android.security.NetworkSecurityPolicy;
import android.util.CloseGuard;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import sd.i;
import vf.h;
import vf.k;
import vf.m;
import vf.n;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends f implements e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f12498e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f12499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f12500d;

    static {
        f12498e = Build.VERSION.SDK_INT >= 29;
    }

    public b() {
        int i = 0;
        ArrayList arrayListQ = i.q(new n[]{Build.VERSION.SDK_INT >= 29 ? new vf.a() : null, new m(vf.e.f), new m(k.f13739a), new m(h.f13737a)});
        ArrayList arrayList = new ArrayList();
        int size = arrayListQ.size();
        while (i < size) {
            Object obj = arrayListQ.get(i);
            i++;
            if (((n) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.f12500d = arrayList;
    }

    @Override // uf.e
    public final void a(Context context) {
        this.f12499c = context;
    }

    @Override // uf.e
    public final Context b() {
        return this.f12499c;
    }

    @Override // uf.f
    public final w8.e c(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        vf.b bVar = x509TrustManagerExtensions != null ? new vf.b(x509TrustManager, x509TrustManagerExtensions) : null;
        return bVar != null ? bVar : new yf.a(d(x509TrustManager));
    }

    @Override // uf.f
    public final yf.d d(X509TrustManager x509TrustManager) {
        StrictMode.noteSlowCall("buildTrustRootIndex");
        return super.d(x509TrustManager);
    }

    @Override // uf.f
    public final void e(SSLSocket sSLSocket, String str, List list) {
        Object obj;
        ge.i.e(list, "protocols");
        ArrayList arrayList = this.f12500d;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            if (((n) obj).c(sSLSocket)) {
                break;
            }
        }
        n nVar = (n) obj;
        if (nVar != null) {
            nVar.d(sSLSocket, str, list);
        }
    }

    @Override // uf.f
    public final String g(SSLSocket sSLSocket) {
        Object obj;
        ArrayList arrayList = this.f12500d;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            if (((n) obj).c(sSLSocket)) {
                break;
            }
        }
        n nVar = (n) obj;
        if (nVar != null) {
            return nVar.a(sSLSocket);
        }
        return null;
    }

    @Override // uf.f
    public final Object h() {
        if (Build.VERSION.SDK_INT < 30) {
            return super.h();
        }
        CloseGuard closeGuardC = a.c();
        closeGuardC.open("response.body().close()");
        return closeGuardC;
    }

    @Override // uf.f
    public final boolean i(String str) {
        ge.i.e(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    @Override // uf.f
    public final void j(String str, int i, Throwable th) {
        ge.i.e(str, "message");
        if (i == 5) {
            boolean z10 = d.f12503e;
            Log.w("OkHttp", str, th);
        } else {
            boolean z11 = d.f12503e;
            Log.i("OkHttp", str, th);
        }
    }

    @Override // uf.f
    public final void k(Object obj, String str) {
        ge.i.e(str, "message");
        if (Build.VERSION.SDK_INT < 30) {
            super.k(obj, str);
        } else {
            ge.i.c(obj, "null cannot be cast to non-null type android.util.CloseGuard");
            a.d(obj).warnIfOpen();
        }
    }

    @Override // uf.f
    public final SSLContext l() {
        StrictMode.noteSlowCall("newSSLContext");
        return super.l();
    }
}
