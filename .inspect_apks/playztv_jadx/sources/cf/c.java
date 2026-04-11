package cf;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import df.o;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f2732e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final df.i f2734d;

    static {
        boolean z2 = false;
        if (pa.b.h() && Build.VERSION.SDK_INT < 30) {
            z2 = true;
        }
        f2732e = z2;
    }

    public c() throws NoSuchMethodException {
        o oVar;
        Method method;
        Method method2;
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketImpl"));
            Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketFactoryImpl"));
            Class.forName("com.android.org.conscrypt".concat(".SSLParametersImpl"));
            oVar = new o(cls);
        } catch (Exception e10) {
            n.f2753a.getClass();
            n.i("unable to load android socket classes", 5, e10);
            oVar = null;
        }
        ArrayList arrayListX = od.h.X(new df.n[]{oVar, new df.m(df.f.f), new df.m(df.k.f4210a), new df.m(df.h.f4206a)});
        ArrayList arrayList = new ArrayList();
        int size = arrayListX.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListX.get(i);
            i++;
            if (((df.n) obj).c()) {
                arrayList.add(obj);
            }
        }
        this.f2733c = arrayList;
        try {
            Class<?> cls2 = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls2.getMethod("get", null);
            method = cls2.getMethod("open", String.class);
            method2 = cls2.getMethod("warnIfOpen", null);
            method3 = method4;
        } catch (Exception unused) {
            method = null;
            method2 = null;
        }
        this.f2734d = new df.i(method3, method, method2);
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
    public final gf.d c(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // cf.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        Object obj;
        be.h.e(list, "protocols");
        ArrayList arrayList = this.f2733c;
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
    public final void e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        be.h.e(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e10) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e10;
            }
            throw new IOException("Exception in connect", e10);
        }
    }

    @Override // cf.n
    public final String f(SSLSocket sSLSocket) {
        Object obj;
        ArrayList arrayList = this.f2733c;
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
    public final Object g() {
        df.i iVar = this.f2734d;
        iVar.getClass();
        Method method = iVar.f4207a;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, null);
                Method method2 = iVar.f4208b;
                be.h.b(method2);
                method2.invoke(objInvoke, "response.body().close()");
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // cf.n
    public final boolean h(String str) {
        be.h.e(str, "hostname");
        return Build.VERSION.SDK_INT >= 24 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str) : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    @Override // cf.n
    public final void j(Object obj, String str) {
        be.h.e(str, "message");
        df.i iVar = this.f2734d;
        iVar.getClass();
        if (obj != null) {
            try {
                Method method = iVar.f4209c;
                be.h.b(method);
                method.invoke(obj, null);
                return;
            } catch (Exception unused) {
            }
        }
        n.i(str, 5, null);
    }
}
