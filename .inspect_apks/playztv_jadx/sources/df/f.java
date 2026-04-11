package df;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class f implements n {
    public static final e f = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f4201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f4202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f4203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f4204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f4205e;

    public f(Class cls) throws NoSuchMethodException {
        this.f4201a = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        be.h.d(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f4202b = declaredMethod;
        this.f4203c = cls.getMethod("setHostname", String.class);
        this.f4204d = cls.getMethod("getAlpnSelectedProtocol", null);
        this.f4205e = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // df.n
    public final boolean a(SSLSocket sSLSocket) {
        return this.f4201a.isInstance(sSLSocket);
    }

    @Override // df.n
    public final String b(SSLSocket sSLSocket) {
        if (this.f4201a.isInstance(sSLSocket)) {
            try {
                byte[] bArr = (byte[]) this.f4204d.invoke(sSLSocket, null);
                if (bArr != null) {
                    return new String(bArr, ie.a.f6599a);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                Throwable cause = e11.getCause();
                if (!(cause instanceof NullPointerException) || !be.h.a(((NullPointerException) cause).getMessage(), "ssl == null")) {
                    throw new AssertionError(e11);
                }
            }
        }
        return null;
    }

    @Override // df.n
    public final boolean c() {
        boolean z2 = cf.c.f2732e;
        return cf.c.f2732e;
    }

    @Override // df.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        be.h.e(list, "protocols");
        if (this.f4201a.isInstance(sSLSocket)) {
            try {
                this.f4202b.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.f4203c.invoke(sSLSocket, str);
                }
                Method method = this.f4205e;
                cf.n nVar = cf.n.f2753a;
                method.invoke(sSLSocket, pa.b.g(list));
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }
    }
}
