package cf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import ue.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f2746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f2747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f2748e;
    public final Class f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class f2749g;

    public j(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f2746c = method;
        this.f2747d = method2;
        this.f2748e = method3;
        this.f = cls;
        this.f2749g = cls2;
    }

    @Override // cf.n
    public final void a(SSLSocket sSLSocket) {
        try {
            this.f2748e.invoke(null, sSLSocket);
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to remove ALPN", e11);
        }
    }

    @Override // cf.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        be.h.e(list, "protocols");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((t) obj) != t.f13046v) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(od.k.U(arrayList));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(((t) obj2).f13051u);
        }
        try {
            this.f2746c.invoke(null, sSLSocket, Proxy.newProxyInstance(n.class.getClassLoader(), new Class[]{this.f, this.f2749g}, new i(arrayList2)));
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to set ALPN", e11);
        }
    }

    @Override // cf.n
    public final String f(SSLSocket sSLSocket) {
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f2747d.invoke(null, sSLSocket));
            be.h.c(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            i iVar = (i) invocationHandler;
            boolean z2 = iVar.f2744b;
            if (!z2 && iVar.f2745c == null) {
                n.i("ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 4, null);
                return null;
            }
            if (z2) {
                return null;
            }
            return iVar.f2745c;
        } catch (IllegalAccessException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        } catch (InvocationTargetException e11) {
            throw new AssertionError("failed to get ALPN selected protocol", e11);
        }
    }
}
