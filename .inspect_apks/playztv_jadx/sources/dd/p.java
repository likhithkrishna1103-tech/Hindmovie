package dd;

import android.content.Context;
import android.os.Handler;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.media3.decoder.DecoderInputBuffer;
import b7.s;
import c2.w;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import n.a1;
import nc.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4186a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4187b;

    public p(s sVar) {
        this.f4187b = sVar;
    }

    public final void a(zc.e eVar) {
        switch (this.f4186a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(eVar, "download");
                s sVar = (s) this.f4187b;
                synchronized (sVar.f1900c) {
                    try {
                        Iterator it = ((LinkedHashMap) sVar.f1901d).values().iterator();
                        while (it.hasNext()) {
                            Iterator it2 = ((Set) it.next()).iterator();
                            while (it2.hasNext()) {
                                p pVar = (p) ((WeakReference) it2.next()).get();
                                if (pVar == null) {
                                    it2.remove();
                                } else {
                                    ((Handler) sVar.f1899b).post(new k(pVar, eVar, 2));
                                }
                            }
                        }
                        if (((LinkedHashMap) sVar.f1902e).isEmpty()) {
                            ((a7.b) sVar.f1898a).z(eVar.f14954y, eVar, id.o.f6591u);
                        } else {
                            ((a7.b) sVar.f1898a).v(eVar.f14954y, eVar, id.o.f6591u);
                            Iterator it3 = ((LinkedHashMap) sVar.f1902e).values().iterator();
                            while (it3.hasNext()) {
                                Iterator it4 = ((Set) it3.next()).iterator();
                                while (it4.hasNext()) {
                                    if (((WeakReference) it4.next()).get() != null) {
                                        throw new ClassCastException();
                                    }
                                    it4.remove();
                                }
                            }
                        }
                        List list = (List) ((LinkedHashMap) sVar.f1904h).get(Integer.valueOf(eVar.f14950u));
                        if (list != null) {
                            Iterator it5 = list.iterator();
                            while (it5.hasNext()) {
                                if (((WeakReference) it5.next()).get() != null) {
                                    throw new ClassCastException();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final void c(zc.e eVar) {
        switch (this.f4186a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(eVar, "download");
                s sVar = (s) this.f4187b;
                synchronized (sVar.f1900c) {
                    try {
                        ((Handler) sVar.f1903g).post(new m(sVar, eVar, 1));
                        Iterator it = ((LinkedHashMap) sVar.f1901d).values().iterator();
                        while (it.hasNext()) {
                            Iterator it2 = ((Set) it.next()).iterator();
                            while (it2.hasNext()) {
                                p pVar = (p) ((WeakReference) it2.next()).get();
                                if (pVar == null) {
                                    it2.remove();
                                } else {
                                    ((Handler) sVar.f1899b).post(new k(pVar, eVar, 1));
                                }
                            }
                        }
                        if (((LinkedHashMap) sVar.f1902e).isEmpty()) {
                            ((a7.b) sVar.f1898a).z(eVar.f14954y, eVar, id.o.f6596z);
                        } else {
                            ((a7.b) sVar.f1898a).v(eVar.f14954y, eVar, id.o.f6596z);
                            Iterator it3 = ((LinkedHashMap) sVar.f1902e).values().iterator();
                            while (it3.hasNext()) {
                                Iterator it4 = ((Set) it3.next()).iterator();
                                while (it4.hasNext()) {
                                    if (((WeakReference) it4.next()).get() != null) {
                                        throw new ClassCastException();
                                    }
                                    it4.remove();
                                }
                            }
                        }
                        List list = (List) ((LinkedHashMap) sVar.f1904h).get(Integer.valueOf(eVar.f14950u));
                        if (list != null) {
                            Iterator it5 = list.iterator();
                            while (it5.hasNext()) {
                                if (((WeakReference) it5.next()).get() != null) {
                                    throw new ClassCastException();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            default:
                x xVar = (x) ((wb.c) this.f4187b).f14088v;
                if (xVar.j() != null) {
                    Toast.makeText(xVar.j(), "Install", 0).show();
                    a1 a1Var = xVar.L0;
                    Context contextJ = xVar.j();
                    a1 a1Var2 = xVar.L0;
                    Context contextJ2 = xVar.j();
                    String str = xVar.J0;
                    a1Var2.getClass();
                    File fileT = a1.t(contextJ2, str);
                    a1Var.getClass();
                    a1.v(contextJ, fileT);
                }
                xVar.N0 = true;
                ((Button) xVar.H0.f2546c).setText("Install");
                ((Button) xVar.H0.f2546c).setVisibility(0);
                ((LinearLayout) xVar.H0.f2550h).setVisibility(8);
                return;
        }
    }

    public final void d(zc.e eVar, id.b bVar, int i) {
        switch (this.f4186a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(eVar, "download");
                be.h.e(bVar, "downloadBlock");
                s sVar = (s) this.f4187b;
                synchronized (sVar.f1900c) {
                    try {
                        Iterator it = ((LinkedHashMap) sVar.f1901d).values().iterator();
                        while (it.hasNext()) {
                            Iterator it2 = ((Set) it.next()).iterator();
                            while (it2.hasNext()) {
                                p pVar = (p) ((WeakReference) it2.next()).get();
                                if (pVar == null) {
                                    it2.remove();
                                } else {
                                    pVar.d(eVar, bVar, i);
                                }
                            }
                        }
                        if (!((LinkedHashMap) sVar.f1902e).isEmpty()) {
                            ((a7.b) sVar.f1898a).v(eVar.f14954y, eVar, id.o.B);
                            Iterator it3 = ((LinkedHashMap) sVar.f1902e).values().iterator();
                            while (it3.hasNext()) {
                                Iterator it4 = ((Set) it3.next()).iterator();
                                while (it4.hasNext()) {
                                    if (((WeakReference) it4.next()).get() != null) {
                                        throw new ClassCastException();
                                    }
                                    it4.remove();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final void f(zc.e eVar, yc.b bVar, Throwable th) {
        switch (this.f4186a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(eVar, "download");
                be.h.e(bVar, "error");
                s sVar = (s) this.f4187b;
                synchronized (sVar.f1900c) {
                    try {
                        ((Handler) sVar.f1903g).post(new m(sVar, eVar, 0));
                        Iterator it = ((LinkedHashMap) sVar.f1901d).values().iterator();
                        while (it.hasNext()) {
                            Iterator it2 = ((Set) it.next()).iterator();
                            while (it2.hasNext()) {
                                p pVar = (p) ((WeakReference) it2.next()).get();
                                if (pVar == null) {
                                    it2.remove();
                                } else {
                                    zc.e eVar2 = eVar;
                                    yc.b bVar2 = bVar;
                                    Throwable th2 = th;
                                    ((Handler) sVar.f1899b).post(new w(pVar, eVar2, bVar2, th2, 1));
                                    eVar = eVar2;
                                    bVar = bVar2;
                                    th = th2;
                                }
                            }
                        }
                        zc.e eVar3 = eVar;
                        if (((LinkedHashMap) sVar.f1902e).isEmpty()) {
                            ((a7.b) sVar.f1898a).z(eVar3.f14954y, eVar3, id.o.A);
                        } else {
                            ((a7.b) sVar.f1898a).v(eVar3.f14954y, eVar3, id.o.A);
                            Iterator it3 = ((LinkedHashMap) sVar.f1902e).values().iterator();
                            while (it3.hasNext()) {
                                Iterator it4 = ((Set) it3.next()).iterator();
                                while (it4.hasNext()) {
                                    if (((WeakReference) it4.next()).get() != null) {
                                        throw new ClassCastException();
                                    }
                                    it4.remove();
                                }
                            }
                        }
                        List list = (List) ((LinkedHashMap) sVar.f1904h).get(Integer.valueOf(eVar3.f14950u));
                        if (list != null) {
                            Iterator it5 = list.iterator();
                            while (it5.hasNext()) {
                                if (((WeakReference) it5.next()).get() != null) {
                                    throw new ClassCastException();
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                return;
            default:
                wb.c cVar = (wb.c) this.f4187b;
                String message = th.getMessage();
                Toast.makeText(((x) cVar.f14088v).j(), "Error: " + message, 0).show();
                return;
        }
    }

    public final void g(final zc.e eVar, final long j5, final long j8) {
        switch (this.f4186a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(eVar, "download");
                s sVar = (s) this.f4187b;
                synchronized (sVar.f1900c) {
                    try {
                        ((Handler) sVar.f1903g).post(new m(sVar, eVar, 2));
                        Iterator it = ((LinkedHashMap) sVar.f1901d).values().iterator();
                        while (it.hasNext()) {
                            Iterator it2 = ((Set) it.next()).iterator();
                            while (it2.hasNext()) {
                                final p pVar = (p) ((WeakReference) it2.next()).get();
                                if (pVar == null) {
                                    it2.remove();
                                } else {
                                    ((Handler) sVar.f1899b).post(new Runnable() { // from class: dd.o
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f4182u.g(eVar, j5, j8);
                                        }
                                    });
                                }
                            }
                        }
                        if (((LinkedHashMap) sVar.f1902e).isEmpty()) {
                            ((a7.b) sVar.f1898a).z(eVar.f14954y, eVar, id.o.f6595y);
                        } else {
                            ((a7.b) sVar.f1898a).v(eVar.f14954y, eVar, id.o.f6595y);
                            Iterator it3 = ((LinkedHashMap) sVar.f1902e).values().iterator();
                            while (it3.hasNext()) {
                                Iterator it4 = ((Set) it3.next()).iterator();
                                while (it4.hasNext()) {
                                    if (((WeakReference) it4.next()).get() != null) {
                                        throw new ClassCastException();
                                    }
                                    it4.remove();
                                }
                            }
                        }
                        List list = (List) ((LinkedHashMap) sVar.f1904h).get(Integer.valueOf(eVar.f14950u));
                        if (list != null) {
                            Iterator it5 = list.iterator();
                            while (it5.hasNext()) {
                                if (((WeakReference) it5.next()).get() != null) {
                                    throw new ClassCastException();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            default:
                wb.c cVar = (wb.c) this.f4187b;
                long j10 = eVar.B;
                long j11 = eVar.C;
                int i = j11 < 1 ? -1 : j10 < 1 ? 0 : j10 >= j11 ? 100 : (int) ((j10 / j11) * ((double) 100));
                x xVar = (x) cVar.f14088v;
                ((TextView) xVar.H0.f2547d).setText(i + "%");
                ((ProgressBar) xVar.H0.f2545b).setProgress(i);
                return;
        }
    }

    public final void h(zc.e eVar, boolean z2) {
        switch (this.f4186a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(eVar, "download");
                s sVar = (s) this.f4187b;
                synchronized (sVar.f1900c) {
                    try {
                        Iterator it = ((LinkedHashMap) sVar.f1901d).values().iterator();
                        while (it.hasNext()) {
                            Iterator it2 = ((Set) it.next()).iterator();
                            while (it2.hasNext()) {
                                p pVar = (p) ((WeakReference) it2.next()).get();
                                if (pVar == null) {
                                    it2.remove();
                                } else {
                                    ((Handler) sVar.f1899b).post(new n(pVar, eVar, z2));
                                }
                            }
                        }
                        if (((LinkedHashMap) sVar.f1902e).isEmpty()) {
                            ((a7.b) sVar.f1898a).z(eVar.f14954y, eVar, id.o.f6592v);
                        } else {
                            ((a7.b) sVar.f1898a).v(eVar.f14954y, eVar, id.o.f6592v);
                            Iterator it3 = ((LinkedHashMap) sVar.f1902e).values().iterator();
                            while (it3.hasNext()) {
                                Iterator it4 = ((Set) it3.next()).iterator();
                                while (it4.hasNext()) {
                                    if (((WeakReference) it4.next()).get() != null) {
                                        throw new ClassCastException();
                                    }
                                    it4.remove();
                                }
                            }
                        }
                        List list = (List) ((LinkedHashMap) sVar.f1904h).get(Integer.valueOf(eVar.f14950u));
                        if (list != null) {
                            Iterator it5 = list.iterator();
                            while (it5.hasNext()) {
                                if (((WeakReference) it5.next()).get() != null) {
                                    throw new ClassCastException();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final void j(zc.e eVar, List list, int i) {
        String str;
        switch (this.f4186a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(eVar, "download");
                s sVar = (s) this.f4187b;
                synchronized (sVar.f1900c) {
                    try {
                        ((Handler) sVar.f1903g).post(new m(sVar, eVar, 3));
                        Iterator it = ((LinkedHashMap) sVar.f1901d).values().iterator();
                        while (it.hasNext()) {
                            Iterator it2 = ((Set) it.next()).iterator();
                            while (it2.hasNext()) {
                                p pVar = (p) ((WeakReference) it2.next()).get();
                                if (pVar == null) {
                                    it2.remove();
                                } else {
                                    ((Handler) sVar.f1899b).post(new l(pVar, eVar, list, i));
                                }
                            }
                        }
                        if (((LinkedHashMap) sVar.f1902e).isEmpty()) {
                            ((a7.b) sVar.f1898a).z(eVar.f14954y, eVar, id.o.f6593w);
                        } else {
                            ((a7.b) sVar.f1898a).v(eVar.f14954y, eVar, id.o.f6593w);
                            Iterator it3 = ((LinkedHashMap) sVar.f1902e).values().iterator();
                            while (it3.hasNext()) {
                                Iterator it4 = ((Set) it3.next()).iterator();
                                while (it4.hasNext()) {
                                    if (((WeakReference) it4.next()).get() != null) {
                                        throw new ClassCastException();
                                    }
                                    it4.remove();
                                }
                            }
                        }
                        List list2 = (List) ((LinkedHashMap) sVar.f1904h).get(Integer.valueOf(eVar.f14950u));
                        if (list2 != null) {
                            Iterator it5 = list2.iterator();
                            while (it5.hasNext()) {
                                if (((WeakReference) it5.next()).get() != null) {
                                    throw new ClassCastException();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            default:
                wb.c cVar = (wb.c) this.f4187b;
                long j5 = eVar.C;
                double d10 = j5 / 1024.0d;
                double d11 = d10 / 1024.0d;
                double d12 = d11 / 1024.0d;
                double d13 = d12 / 1024.0d;
                if (j5 < 1024) {
                    str = j5 + " B";
                } else {
                    str = j5 < 1048576 ? String.format("%.2f KB", Double.valueOf(d10)) : j5 < 1073741824 ? String.format("%.2f MB", Double.valueOf(d11)) : j5 < 1099511627776L ? String.format("%.2f GB", Double.valueOf(d12)) : String.format("%.2f TB", Double.valueOf(d13));
                }
                ((TextView) ((x) cVar.f14088v).H0.f).setText(str);
                return;
        }
    }

    public final void k(zc.e eVar) {
        switch (this.f4186a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(eVar, "download");
                s sVar = (s) this.f4187b;
                synchronized (sVar.f1900c) {
                    try {
                        Iterator it = ((LinkedHashMap) sVar.f1901d).values().iterator();
                        while (it.hasNext()) {
                            Iterator it2 = ((Set) it.next()).iterator();
                            while (it2.hasNext()) {
                                p pVar = (p) ((WeakReference) it2.next()).get();
                                if (pVar == null) {
                                    it2.remove();
                                } else {
                                    ((Handler) sVar.f1899b).post(new k(pVar, eVar, 0));
                                }
                            }
                        }
                        if (((LinkedHashMap) sVar.f1902e).isEmpty()) {
                            ((a7.b) sVar.f1898a).z(eVar.f14954y, eVar, id.o.f6594x);
                        } else {
                            ((a7.b) sVar.f1898a).v(eVar.f14954y, eVar, id.o.f6594x);
                            Iterator it3 = ((LinkedHashMap) sVar.f1902e).values().iterator();
                            while (it3.hasNext()) {
                                Iterator it4 = ((Set) it3.next()).iterator();
                                while (it4.hasNext()) {
                                    if (((WeakReference) it4.next()).get() != null) {
                                        throw new ClassCastException();
                                    }
                                    it4.remove();
                                }
                            }
                        }
                        List list = (List) ((LinkedHashMap) sVar.f1904h).get(Integer.valueOf(eVar.f14950u));
                        if (list != null) {
                            Iterator it5 = list.iterator();
                            while (it5.hasNext()) {
                                if (((WeakReference) it5.next()).get() != null) {
                                    throw new ClassCastException();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            default:
                return;
        }
    }

    public p(a1 a1Var, wb.c cVar) {
        this.f4187b = cVar;
    }

    private final void b(zc.e eVar) {
    }

    private final void l(zc.e eVar) {
    }

    private final void i(zc.e eVar, boolean z2) {
    }

    private final void e(zc.e eVar, id.b bVar, int i) {
    }
}
