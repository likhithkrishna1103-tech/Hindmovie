package uf;

import android.os.Build;
import ge.i;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kf.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f12506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f12507b;

    static {
        try {
            for (Map.Entry entry : vf.c.f13726b.entrySet()) {
                vf.c.b((String) entry.getKey(), (String) entry.getValue());
            }
        } catch (RuntimeException e9) {
            System.err.println("Possibly running android unit test without robolectric");
            e9.printStackTrace();
        } catch (UnsatisfiedLinkError e10) {
            System.err.println("Possibly running android unit test without robolectric");
            e10.printStackTrace();
        }
        f bVar = b.f12498e ? new b() : null;
        if (bVar == null) {
            bVar = d.f12503e ? new d() : null;
        }
        if (bVar == null) {
            throw new IllegalStateException(l0.e.g(Build.VERSION.SDK_INT, "Expected Android API level 21+ but was "));
        }
        f12506a = bVar;
        f12507b = Logger.getLogger(u.class.getName());
    }

    public abstract w8.e c(X509TrustManager x509TrustManager);

    public yf.d d(X509TrustManager x509TrustManager) {
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        return new yf.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public abstract void e(SSLSocket sSLSocket, String str, List list);

    public void f(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        i.e(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    public abstract String g(SSLSocket sSLSocket);

    public Object h() {
        if (f12507b.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public abstract boolean i(String str);

    public abstract void j(String str, int i, Throwable th);

    public void k(Object obj, String str) {
        i.e(str, "message");
        if (obj == null) {
            str = str.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        j(str, 5, (Throwable) obj);
    }

    public SSLContext l() {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        i.d(sSLContext, "getInstance(...)");
        return sSLContext;
    }

    public final String toString() {
        return getClass().getSimpleName();
    }
}
