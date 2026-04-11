package ve;

import be.h;
import com.bumptech.glide.c;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import hf.f;
import hf.i;
import hf.n;
import hf.w;
import ie.d;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import lb.e;
import od.j;
import ue.m;
import ue.o;
import ue.s;
import ue.v;
import ue.x;
import ue.y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f13497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f13498b = v.k(new String[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f13499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f13500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeZone f13501e;
    public static final d f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13502g;

    static {
        byte[] bArr = new byte[0];
        f13497a = bArr;
        f fVar = new f();
        fVar.g0(0, bArr);
        long j5 = 0;
        f13499c = new y(j5, fVar);
        b(j5, j5, j5);
        i iVar = i.f6114x;
        f13500d = c.p(e.g("efbbbf"), e.g("feff"), e.g("fffe"), e.g("0000ffff"), e.g("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        h.b(timeZone);
        f13501e = timeZone;
        f = new d();
        String strX = ie.e.X(s.class.getName(), "okhttp3.");
        if (ie.n.H(strX, "Client")) {
            strX = strX.substring(0, strX.length() - 6);
            h.d(strX, "substring(...)");
        }
        f13502g = strX;
    }

    public static final boolean a(o oVar, o oVar2) {
        h.e(oVar, "<this>");
        h.e(oVar2, "other");
        return h.a(oVar.f13011d, oVar2.f13011d) && oVar.f13012e == oVar2.f13012e && h.a(oVar.f13008a, oVar2.f13008a);
    }

    public static final void b(long j5, long j8, long j10) {
        if ((j8 | j10) < 0 || j8 > j5 || j5 - j8 < j10) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void c(Closeable closeable) {
        h.e(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final void d(Socket socket) {
        h.e(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (!h.a(e11.getMessage(), "bio == null")) {
                throw e11;
            }
        } catch (Exception unused) {
        }
    }

    public static final int e(int i, int i10, String str, String str2) {
        while (i < i10) {
            if (ie.e.O(str2, str.charAt(i))) {
                return i;
            }
            i++;
        }
        return i10;
    }

    public static final int f(String str, char c9, int i, int i10) {
        while (i < i10) {
            if (str.charAt(i) == c9) {
                return i;
            }
            i++;
        }
        return i10;
    }

    public static final String g(String str, Object... objArr) {
        h.e(str, "format");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0038, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean h(java.lang.String[] r7, java.lang.String[] r8, java.util.Comparator r9) {
        /*
            java.lang.String r0 = "<this>"
            be.h.e(r7, r0)
            int r0 = r7.length
            r1 = 0
            if (r0 != 0) goto La
            goto L3b
        La:
            if (r8 == 0) goto L3b
            int r0 = r8.length
            if (r0 != 0) goto L10
            goto L3b
        L10:
            int r0 = r7.length
            r2 = r1
        L12:
            if (r2 >= r0) goto L3b
            r3 = r7[r2]
            r4 = r1
        L17:
            int r5 = r8.length
            r6 = 1
            if (r4 >= r5) goto L1d
            r5 = r6
            goto L1e
        L1d:
            r5 = r1
        L1e:
            if (r5 == 0) goto L38
            int r5 = r4 + 1
            r4 = r8[r4]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L2d
            int r4 = r9.compare(r3, r4)
            if (r4 != 0) goto L2b
            return r6
        L2b:
            r4 = r5
            goto L17
        L2d:
            r7 = move-exception
            java.util.NoSuchElementException r8 = new java.util.NoSuchElementException
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r7)
            throw r8
        L38:
            int r2 = r2 + 1
            goto L12
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ve.b.h(java.lang.String[], java.lang.String[], java.util.Comparator):boolean");
    }

    public static final long i(x xVar) {
        String strB = xVar.f13071z.b("Content-Length");
        if (strB == null) {
            return -1L;
        }
        try {
            return Long.parseLong(strB);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final List j(Object... objArr) {
        h.e(objArr, "elements");
        Object[] objArr2 = (Object[]) objArr.clone();
        List listUnmodifiableList = Collections.unmodifiableList(j.S(Arrays.copyOf(objArr2, objArr2.length)));
        h.d(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int k(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (h.f(cCharAt, 31) <= 0 || h.f(cCharAt, ModuleDescriptor.MODULE_VERSION) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int l(int i, int i10, String str) {
        while (i < i10) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i10;
    }

    public static final int m(int i, int i10, String str) {
        int i11 = i10 - 1;
        if (i <= i11) {
            while (true) {
                char cCharAt = str.charAt(i11);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i11 + 1;
                }
                if (i11 == i) {
                    break;
                }
                i11--;
            }
        }
        return i;
    }

    public static final String[] n(String[] strArr, String[] strArr2, Comparator comparator) {
        h.e(strArr2, "other");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean o(String str) {
        h.e(str, "name");
        return str.equalsIgnoreCase("Authorization") || str.equalsIgnoreCase("Cookie") || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase("Set-Cookie");
    }

    public static final int p(char c9) {
        if ('0' <= c9 && c9 < ':') {
            return c9 - '0';
        }
        if ('a' <= c9 && c9 < 'g') {
            return c9 - 'W';
        }
        if ('A' > c9 || c9 >= 'G') {
            return -1;
        }
        return c9 - '7';
    }

    public static final Charset q(hf.h hVar, Charset charset) {
        h.e(hVar, "<this>");
        h.e(charset, "default");
        int iO = hVar.o(f13500d);
        if (iO == -1) {
            return charset;
        }
        if (iO == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            h.d(charset2, "UTF_8");
            return charset2;
        }
        if (iO == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            h.d(charset3, "UTF_16BE");
            return charset3;
        }
        if (iO == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            h.d(charset4, "UTF_16LE");
            return charset4;
        }
        if (iO == 3) {
            Charset charset5 = ie.a.f6599a;
            Charset charset6 = ie.a.f6601c;
            if (charset6 != null) {
                return charset6;
            }
            Charset charsetForName = Charset.forName("UTF-32BE");
            h.d(charsetForName, "forName(...)");
            ie.a.f6601c = charsetForName;
            return charsetForName;
        }
        if (iO != 4) {
            throw new AssertionError();
        }
        Charset charset7 = ie.a.f6599a;
        Charset charset8 = ie.a.f6600b;
        if (charset8 != null) {
            return charset8;
        }
        Charset charsetForName2 = Charset.forName("UTF-32LE");
        h.d(charsetForName2, "forName(...)");
        ie.a.f6600b = charsetForName2;
        return charsetForName2;
    }

    public static final int r(hf.h hVar) {
        h.e(hVar, "<this>");
        return (hVar.readByte() & 255) | ((hVar.readByte() & 255) << 16) | ((hVar.readByte() & 255) << 8);
    }

    public static final boolean s(w wVar, int i) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        h.e(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = wVar.c().e() ? wVar.c().c() - jNanoTime : Long.MAX_VALUE;
        wVar.c().d(Math.min(jC, timeUnit.toNanos(i)) + jNanoTime);
        try {
            f fVar = new f();
            while (wVar.l(8192L, fVar) != -1) {
                fVar.a();
            }
            if (jC == Long.MAX_VALUE) {
                wVar.c().a();
                return true;
            }
            wVar.c().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                wVar.c().a();
                return false;
            }
            wVar.c().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                wVar.c().a();
            } else {
                wVar.c().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final m t(List list) {
        ArrayList arrayList = new ArrayList(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bf.b bVar = (bf.b) it.next();
            i iVar = bVar.f2052a;
            i iVar2 = bVar.f2053b;
            String strH = iVar.h();
            String strH2 = iVar2.h();
            arrayList.add(strH);
            arrayList.add(ie.e.b0(strH2).toString());
        }
        return new m((String[]) arrayList.toArray(new String[0]));
    }

    public static final String u(o oVar, boolean z2) {
        h.e(oVar, "<this>");
        int i = oVar.f13012e;
        String str = oVar.f13011d;
        if (ie.e.N(str, ":", false)) {
            str = "[" + str + ']';
        }
        if (!z2) {
            String str2 = oVar.f13008a;
            h.e(str2, "scheme");
            if (i == (str2.equals("http") ? 80 : str2.equals("https") ? 443 : -1)) {
                return str;
            }
        }
        return str + ':' + i;
    }

    public static final List v(List list) {
        h.e(list, "<this>");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        h.d(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final int w(String str, int i) {
        if (str != null) {
            try {
                long j5 = Long.parseLong(str);
                if (j5 > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (j5 < 0) {
                    return 0;
                }
                return (int) j5;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public static final String x(int i, int i10, String str) {
        int iL = l(i, i10, str);
        String strSubstring = str.substring(iL, m(iL, i10, str));
        h.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
