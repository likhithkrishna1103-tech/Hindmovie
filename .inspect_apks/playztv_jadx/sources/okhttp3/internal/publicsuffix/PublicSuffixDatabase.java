package okhttp3.internal.publicsuffix;

import android.support.v4.media.session.b;
import be.h;
import cf.l;
import cf.n;
import e6.j;
import he.g;
import hf.k;
import ie.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import od.i;
import od.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f9586e = {42};
    public static final List f = b.G("*");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PublicSuffixDatabase f9587g = new PublicSuffixDatabase();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f9588a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CountDownLatch f9589b = new CountDownLatch(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f9590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f9591d;

    public static List c(String str) {
        Object next;
        int i = 0;
        List listY = e.Y(str, new char[]{'.'});
        if (!h.a(i.c0(listY), "")) {
            return listY;
        }
        List list = listY;
        int size = listY.size() - 1;
        if (size < 0) {
            size = 0;
        }
        if (size < 0) {
            throw new IllegalArgumentException(j.j(size, "Requested element count ", " is less than zero.").toString());
        }
        if (size == 0) {
            return q.f9570u;
        }
        if (list instanceof Collection) {
            if (size >= list.size()) {
                return i.h0(list);
            }
            if (size == 1) {
                if (list instanceof List) {
                    next = i.X(list);
                } else {
                    Iterator it = list.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException("Collection is empty.");
                    }
                    next = it.next();
                }
                return b.G(next);
            }
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
            i++;
            if (i == size) {
                break;
            }
        }
        return od.j.T(arrayList);
    }

    public final String a(String str) {
        String strC;
        String strC2;
        String strC3;
        int size;
        int size2;
        String unicode = IDN.toUnicode(str);
        h.d(unicode, "unicodeDomain");
        List listC = c(unicode);
        List listY = q.f9570u;
        if (this.f9588a.get() || !this.f9588a.compareAndSet(false, true)) {
            try {
                this.f9589b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z2 = false;
            while (true) {
                try {
                    try {
                        b();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z2 = true;
                    } catch (IOException e10) {
                        n nVar = n.f2753a;
                        n.f2753a.getClass();
                        n.i("Failed to read public suffix list", 5, e10);
                        if (z2) {
                        }
                    }
                } finally {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        if (this.f9590c == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size3 = listC.size();
        byte[][] bArr = new byte[size3][];
        for (int i = 0; i < size3; i++) {
            String str2 = (String) listC.get(i);
            Charset charset = StandardCharsets.UTF_8;
            h.d(charset, "UTF_8");
            byte[] bytes = str2.getBytes(charset);
            h.d(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i] = bytes;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= size3) {
                strC = null;
                break;
            }
            byte[] bArr2 = this.f9590c;
            if (bArr2 == null) {
                h.i("publicSuffixListBytes");
                throw null;
            }
            strC = q9.e.c(bArr2, bArr, i10);
            if (strC != null) {
                break;
            }
            i10++;
        }
        if (size3 > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            for (int i11 = 0; i11 < length; i11++) {
                bArr3[i11] = f9586e;
                byte[] bArr4 = this.f9590c;
                if (bArr4 == null) {
                    h.i("publicSuffixListBytes");
                    throw null;
                }
                strC2 = q9.e.c(bArr4, bArr3, i11);
                if (strC2 != null) {
                    break;
                }
            }
            strC2 = null;
        } else {
            strC2 = null;
        }
        if (strC2 != null) {
            int i12 = size3 - 1;
            for (int i13 = 0; i13 < i12; i13++) {
                byte[] bArr5 = this.f9591d;
                if (bArr5 == null) {
                    h.i("publicSuffixExceptionListBytes");
                    throw null;
                }
                strC3 = q9.e.c(bArr5, bArr, i13);
                if (strC3 != null) {
                    break;
                }
            }
            strC3 = null;
        } else {
            strC3 = null;
        }
        if (strC3 != null) {
            listY = e.Y("!".concat(strC3), new char[]{'.'});
        } else if (strC == null && strC2 == null) {
            listY = f;
        } else {
            List listY2 = strC != null ? e.Y(strC, new char[]{'.'}) : listY;
            if (strC2 != null) {
                listY = e.Y(strC2, new char[]{'.'});
            }
            if (listY2.size() > listY.size()) {
                listY = listY2;
            }
        }
        if (listC.size() == listY.size() && ((String) listY.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listY.get(0)).charAt(0) == '!') {
            size = listC.size();
            size2 = listY.size();
        } else {
            size = listC.size();
            size2 = listY.size() + 1;
        }
        int i14 = size - size2;
        he.e jVar = new he.j(2, c(str));
        if (i14 < 0) {
            throw new IllegalArgumentException(j.j(i14, "Requested element count ", " is less than zero.").toString());
        }
        if (i14 != 0) {
            jVar = new he.b(jVar, i14);
        }
        return g.R(jVar, ".");
    }

    public final void b() {
        try {
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
            if (resourceAsStream != null) {
                hf.q qVar = new hf.q(new k(l.A(resourceAsStream)));
                try {
                    long j5 = qVar.readInt();
                    qVar.X(j5);
                    byte[] bArrG = qVar.f6141v.G(j5);
                    long j8 = qVar.readInt();
                    qVar.X(j8);
                    byte[] bArrG2 = qVar.f6141v.G(j8);
                    qVar.close();
                    synchronized (this) {
                        this.f9590c = bArrG;
                        this.f9591d = bArrG2;
                    }
                } finally {
                }
            }
        } finally {
            this.f9589b.countDown();
        }
    }
}
