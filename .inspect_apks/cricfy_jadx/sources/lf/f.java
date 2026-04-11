package lf;

import ag.g;
import ag.w;
import ge.i;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kf.p;
import kf.q;
import kf.u;
import kf.z;
import ne.h;
import ne.o;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f7964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7965b;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        i.b(timeZone);
        f7964a = timeZone;
        String strO0 = h.o0(u.class.getName(), "okhttp3.");
        if (o.V(strO0, "Client")) {
            strO0 = strO0.substring(0, strO0.length() - 6);
            i.d(strO0, "substring(...)");
        }
        f7965b = strO0;
    }

    public static final boolean a(q qVar, q qVar2) {
        i.e(qVar, "<this>");
        i.e(qVar2, "other");
        return i.a(qVar.f7518d, qVar2.f7518d) && qVar.f7519e == qVar2.f7519e && i.a(qVar.f7515a, qVar2.f7515a);
    }

    public static final void b(Socket socket) {
        i.e(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e9) {
            throw e9;
        } catch (RuntimeException e10) {
            if (!i.a(e10.getMessage(), "bio == null")) {
                throw e10;
            }
        } catch (Exception unused) {
        }
    }

    public static final String c(String str, Object... objArr) {
        i.e(str, "format");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final long d(z zVar) {
        String strA = zVar.A.a("Content-Length");
        if (strA == null) {
            return -1L;
        }
        byte[] bArr = d.f7960a;
        try {
            return Long.parseLong(strA);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final Charset e(g gVar, Charset charset) {
        i.e(gVar, "<this>");
        i.e(charset, "default");
        int iR = gVar.r(d.f7961b);
        if (iR == -1) {
            return charset;
        }
        if (iR == 0) {
            return ne.a.f9126a;
        }
        if (iR == 1) {
            return ne.a.f9127b;
        }
        if (iR == 2) {
            Charset charset2 = ne.a.f9126a;
            Charset charset3 = ne.a.f9129d;
            if (charset3 != null) {
                return charset3;
            }
            Charset charsetForName = Charset.forName("UTF-32LE");
            i.d(charsetForName, "forName(...)");
            ne.a.f9129d = charsetForName;
            return charsetForName;
        }
        if (iR == 3) {
            return ne.a.f9128c;
        }
        if (iR != 4) {
            throw new AssertionError();
        }
        Charset charset4 = ne.a.f9126a;
        Charset charset5 = ne.a.f9130e;
        if (charset5 != null) {
            return charset5;
        }
        Charset charsetForName2 = Charset.forName("UTF-32BE");
        i.d(charsetForName2, "forName(...)");
        ne.a.f9130e = charsetForName2;
        return charsetForName2;
    }

    public static final boolean f(w wVar, int i) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        i.e(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = wVar.d().e() ? wVar.d().c() - jNanoTime : Long.MAX_VALUE;
        wVar.d().d(Math.min(jC, timeUnit.toNanos(i)) + jNanoTime);
        try {
            ag.e eVar = new ag.e();
            while (wVar.U(8192L, eVar) != -1) {
                eVar.a();
            }
            if (jC == Long.MAX_VALUE) {
                wVar.d().a();
                return true;
            }
            wVar.d().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                wVar.d().a();
                return false;
            }
            wVar.d().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                wVar.d().a();
            } else {
                wVar.d().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final p g(List list) {
        ArrayList arrayList = new ArrayList(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            rf.d dVar = (rf.d) it.next();
            ag.h hVar = dVar.f11061a;
            ag.h hVar2 = dVar.f11062b;
            String strJ = hVar.j();
            String strJ2 = hVar2.j();
            arrayList.add(strJ);
            arrayList.add(h.t0(strJ2).toString());
        }
        return new p((String[]) arrayList.toArray(new String[0]));
    }

    public static final String h(q qVar, boolean z10) {
        i.e(qVar, "<this>");
        int i = qVar.f7519e;
        String str = qVar.f7518d;
        if (h.c0(str, ":", false)) {
            str = "[" + str + ']';
        }
        if (!z10) {
            String str2 = qVar.f7515a;
            i.e(str2, "scheme");
            if (i == (str2.equals("http") ? 80 : str2.equals("https") ? 443 : -1)) {
                return str;
            }
        }
        return str + ':' + i;
    }

    public static final List i(List list) {
        i.e(list, "<this>");
        if (list.isEmpty()) {
            return sd.p.f11669v;
        }
        if (list.size() == 1) {
            List listSingletonList = Collections.singletonList(list.get(0));
            i.d(listSingletonList, "singletonList(...)");
            return listSingletonList;
        }
        Object[] array = list.toArray();
        i.d(array, "toArray(...)");
        List listUnmodifiableList = Collections.unmodifiableList(sd.i.a(array));
        i.d(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public static final List j(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return sd.p.f11669v;
        }
        if (objArr.length == 1) {
            List listSingletonList = Collections.singletonList(objArr[0]);
            i.d(listSingletonList, "singletonList(...)");
            return listSingletonList;
        }
        List listUnmodifiableList = Collections.unmodifiableList(sd.i.a((Object[]) objArr.clone()));
        i.d(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }
}
