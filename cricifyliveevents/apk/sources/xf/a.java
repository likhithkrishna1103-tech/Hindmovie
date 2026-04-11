package xf;

import ag.h;
import c2.o;
import ge.i;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import ka.f;
import l0.e;
import me.g;
import sd.j;
import sd.p;
import x2.b;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f14503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List f14504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f14505d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f14506a;

    static {
        byte[] bArrCopyOf = Arrays.copyOf(new byte[]{42}, 1);
        i.d(bArrCopyOf, "copyOf(...)");
        f14503b = new h(bArrCopyOf);
        f14504c = n5.a.x("*");
        f14505d = new a(new o(11));
    }

    public a(o oVar) {
        this.f14506a = oVar;
    }

    public static List b(String str) {
        List listP0 = ne.h.p0(str, new char[]{'.'});
        if (!i.a(j.m0(listP0), "")) {
            return listP0;
        }
        int size = listP0.size() - 1;
        if (size < 0) {
            size = 0;
        }
        if (size < 0) {
            throw new IllegalArgumentException(e.h(size, "Requested element count ", " is less than zero.").toString());
        }
        p pVar = p.f11669v;
        if (size == 0) {
            return pVar;
        }
        if (size >= listP0.size()) {
            return j.r0(listP0);
        }
        if (size == 1) {
            return n5.a.x(j.h0(listP0));
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator it = listP0.iterator();
        int i = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i++;
            if (i == size) {
                break;
            }
        }
        int size2 = arrayList.size();
        return size2 != 0 ? size2 != 1 ? arrayList : n5.a.x(arrayList.get(0)) : pVar;
    }

    public final String a(String str) {
        String strF;
        String strF2;
        String strF3;
        List listP0;
        int size;
        int size2;
        String unicode = IDN.toUnicode(str);
        i.b(unicode);
        List listB = b(unicode);
        o oVar = this.f14506a;
        AtomicBoolean atomicBoolean = (AtomicBoolean) oVar.f2035b;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            try {
                ((CountDownLatch) oVar.f2036c).await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z10 = false;
            while (true) {
                try {
                    try {
                        oVar.v();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z10 = true;
                    } catch (IOException e9) {
                        oVar.f = e9;
                        if (z10) {
                        }
                    }
                } finally {
                    if (z10) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        if (((h) oVar.f2037d) == null) {
            StringBuilder sb = new StringBuilder("Unable to load ");
            sb.append(oVar.f2039g);
            sb.append(" resource.");
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            illegalStateException.initCause((IOException) oVar.f);
            throw illegalStateException;
        }
        int size3 = listB.size();
        h[] hVarArr = new h[size3];
        for (int i = 0; i < size3; i++) {
            h hVar = h.f430y;
            hVarArr[i] = f.d((String) listB.get(i));
        }
        int i10 = 0;
        while (true) {
            if (i10 >= size3) {
                strF = null;
                break;
            }
            h hVar2 = (h) oVar.f2037d;
            if (hVar2 == null) {
                i.i("bytes");
                throw null;
            }
            strF = b.f(hVar2, hVarArr, i10);
            if (strF != null) {
                break;
            }
            i10++;
        }
        if (size3 > 1) {
            h[] hVarArr2 = (h[]) hVarArr.clone();
            int length = hVarArr2.length - 1;
            for (int i11 = 0; i11 < length; i11++) {
                hVarArr2[i11] = f14503b;
                h hVar3 = (h) oVar.f2037d;
                if (hVar3 == null) {
                    i.i("bytes");
                    throw null;
                }
                strF2 = b.f(hVar3, hVarArr2, i11);
                if (strF2 != null) {
                    break;
                }
            }
            strF2 = null;
        } else {
            strF2 = null;
        }
        if (strF2 != null) {
            int i12 = size3 - 1;
            for (int i13 = 0; i13 < i12; i13++) {
                h hVar4 = (h) oVar.f2038e;
                if (hVar4 == null) {
                    i.i("exceptionBytes");
                    throw null;
                }
                strF3 = b.f(hVar4, hVarArr, i13);
                if (strF3 != null) {
                    break;
                }
            }
            strF3 = null;
        } else {
            strF3 = null;
        }
        if (strF3 != null) {
            listP0 = ne.h.p0("!".concat(strF3), new char[]{'.'});
        } else if (strF == null && strF2 == null) {
            listP0 = f14504c;
        } else {
            List listP02 = p.f11669v;
            List listP03 = strF != null ? ne.h.p0(strF, new char[]{'.'}) : listP02;
            if (strF2 != null) {
                listP02 = ne.h.p0(strF2, new char[]{'.'});
            }
            listP0 = listP03.size() > listP02.size() ? listP03 : listP02;
        }
        if (listB.size() == listP0.size() && ((String) listP0.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listP0.get(0)).charAt(0) == '!') {
            size = listB.size();
            size2 = listP0.size();
        } else {
            size = listB.size();
            size2 = listP0.size() + 1;
        }
        int i14 = size - size2;
        me.e hVar5 = new me.h(2, b(str));
        if (i14 < 0) {
            throw new IllegalArgumentException(e.h(i14, "Requested element count ", " is less than zero.").toString());
        }
        if (i14 != 0) {
            hVar5 = new me.b(hVar5, i14);
        }
        return g.H(hVar5, ".");
    }
}
