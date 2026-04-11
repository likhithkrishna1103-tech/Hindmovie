package vf;

import android.os.Build;
import f9.b0;
import f9.c0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class e implements n {
    public static final c0 f = new c0(27);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f13728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f13729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f13730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f13731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f13732e;

    public e(Class cls) throws NoSuchMethodException {
        this.f13728a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        ge.i.d(declaredMethod, "getDeclaredMethod(...)");
        this.f13729b = declaredMethod;
        this.f13730c = cls.getMethod("setHostname", String.class);
        this.f13731d = cls.getMethod("getAlpnSelectedProtocol", null);
        this.f13732e = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // vf.n
    public final String a(SSLSocket sSLSocket) {
        if (this.f13728a.isInstance(sSLSocket)) {
            try {
                byte[] bArr = (byte[]) this.f13731d.invoke(sSLSocket, null);
                if (bArr != null) {
                    return new String(bArr, ne.a.f9126a);
                }
            } catch (IllegalAccessException e9) {
                throw new AssertionError(e9);
            } catch (InvocationTargetException e10) {
                Throwable cause = e10.getCause();
                if (!(cause instanceof NullPointerException) || !ge.i.a(((NullPointerException) cause).getMessage(), "ssl == null")) {
                    throw new AssertionError(e10);
                }
            }
        }
        return null;
    }

    @Override // vf.n
    public final boolean b() {
        boolean z10 = uf.d.f12503e;
        return uf.d.f12503e;
    }

    @Override // vf.n
    public final boolean c(SSLSocket sSLSocket) {
        return this.f13728a.isInstance(sSLSocket);
    }

    @Override // vf.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        ge.i.e(list, "protocols");
        if (this.f13728a.isInstance(sSLSocket)) {
            try {
                this.f13729b.invoke(sSLSocket, Boolean.TRUE);
                if (str != null && Build.VERSION.SDK_INT <= 23) {
                    this.f13730c.invoke(sSLSocket, str);
                }
                Method method = this.f13732e;
                uf.f fVar = uf.f.f12506a;
                method.invoke(sSLSocket, b0.x(list));
            } catch (IllegalAccessException e9) {
                throw new AssertionError(e9);
            } catch (InvocationTargetException e10) {
                throw new AssertionError(e10);
            }
        }
    }
}
