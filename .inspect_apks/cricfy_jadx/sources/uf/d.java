package uf;

import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.os.StrictMode;
import android.security.NetworkSecurityPolicy;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kf.u;
import sd.i;
import vf.h;
import vf.k;
import vf.m;
import vf.n;
import vf.o;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends f implements e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f12503e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f12504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f12505d;

    static {
        f12503e = Build.VERSION.SDK_INT < 29;
    }

    public d() {
        o oVar;
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketImpl"));
            Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketFactoryImpl"));
            Class.forName("com.android.org.conscrypt".concat(".SSLParametersImpl"));
            oVar = new o(cls);
        } catch (Exception e9) {
            CopyOnWriteArraySet copyOnWriteArraySet = vf.c.f13725a;
            vf.c.a(u.class.getName(), 5, "unable to load android socket classes", e9);
            oVar = null;
        }
        int i = 0;
        ArrayList arrayListQ = i.q(new n[]{oVar, new m(vf.e.f), new m(k.f13739a), new m(h.f13737a)});
        ArrayList arrayList = new ArrayList();
        int size = arrayListQ.size();
        while (i < size) {
            Object obj = arrayListQ.get(i);
            i++;
            if (((n) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.f12505d = arrayList;
    }

    @Override // uf.e
    public final void a(Context context) {
        this.f12504c = context;
    }

    @Override // uf.e
    public final Context b() {
        return this.f12504c;
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
        try {
            StrictMode.noteSlowCall("buildTrustRootIndex");
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new c(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
    }

    @Override // uf.f
    public final void e(SSLSocket sSLSocket, String str, List list) {
        Object obj;
        ge.i.e(list, "protocols");
        ArrayList arrayList = this.f12505d;
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
    public final void f(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        ge.i.e(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e9) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e9;
            }
            throw new IOException("Exception in connect", e9);
        }
    }

    @Override // uf.f
    public final String g(SSLSocket sSLSocket) {
        Object obj;
        ArrayList arrayList = this.f12505d;
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
    public final boolean i(String str) {
        ge.i.e(str, "hostname");
        return Build.VERSION.SDK_INT >= 24 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str) : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    @Override // uf.f
    public final void j(String str, int i, Throwable th) {
        ge.i.e(str, "message");
        if (i == 5) {
            Log.w("OkHttp", str, th);
        } else {
            Log.i("OkHttp", str, th);
        }
    }

    @Override // uf.f
    public final SSLContext l() {
        StrictMode.noteSlowCall("newSSLContext");
        return super.l();
    }
}
