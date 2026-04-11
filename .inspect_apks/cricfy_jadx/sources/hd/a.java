package hd;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.DocumentsContract;
import androidx.emoji2.text.v;
import com.google.android.gms.internal.measurement.j4;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import o.t3;
import sd.s;
import w4.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {
    public final i2.k A;
    public final cd.i B;
    public final int C;
    public final LinkedHashSet D;
    public volatile boolean E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final dd.g f5912v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final fd.a f5913w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final id.d f5914x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d5.a f5915y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final d8.j f5916z;

    public a(dd.g gVar, fd.a aVar, id.d dVar, d5.a aVar2, md.e eVar, cd.d dVar2, d8.j jVar, Handler handler, i2.k kVar, v vVar, cd.i iVar) {
        ge.i.e(aVar2, "logger");
        ge.i.e(eVar, "httpDownloader");
        ge.i.e(dVar2, "fileServerDownloader");
        ge.i.e(handler, "uiHandler");
        ge.i.e(iVar, "prioritySort");
        this.f5912v = gVar;
        this.f5913w = aVar;
        this.f5914x = dVar;
        this.f5915y = aVar2;
        this.f5916z = jVar;
        this.A = kVar;
        this.B = iVar;
        this.C = UUID.randomUUID().hashCode();
        this.D = new LinkedHashSet();
    }

    public final void A() {
        id.d dVar = this.f5914x;
        synchronized (dVar.C) {
            dVar.f6444v.d(new ff.h(2, dVar, "LibGlobalFetchLib"));
        }
        if (this.f5914x.F && !this.E) {
            this.f5914x.z();
        }
        if (!this.f5914x.E || this.E) {
            return;
        }
        this.f5914x.s();
    }

    public final void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            dd.e eVar = (dd.e) it.next();
            fd.a aVar = this.f5913w;
            int i = eVar.f3676v;
            synchronized (aVar.E) {
                aVar.s(i);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.E) {
            return;
        }
        this.E = true;
        synchronized (this.D) {
            try {
                Iterator it = this.D.iterator();
                while (it.hasNext()) {
                    this.f5916z.g(this.C, (cd.e) it.next());
                }
                this.D.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f5914x.A();
        this.f5914x.close();
        this.f5913w.close();
        g.a();
    }

    public final void g(List list) throws FileNotFoundException {
        a(list);
        dd.g gVar = this.f5912v;
        synchronized (gVar.f3687w) {
            dd.f fVar = gVar.f3686v;
            fVar.O();
            dd.c cVarQ = fVar.A.q();
            t tVar = (t) cVarQ.f3672w;
            tVar.b();
            tVar.c();
            try {
                ((dd.b) cVarQ.f3675z).f(list);
                tVar.j().Y().N();
            } finally {
                tVar.g();
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            dd.e eVar = (dd.e) it.next();
            cd.l lVar = cd.l.F;
            eVar.getClass();
            eVar.E = lVar;
            i2.k kVar = this.A;
            String str = eVar.f3679y;
            ge.i.e(str, "file");
            Context context = (Context) kVar.f6085v;
            ge.i.e(context, "context");
            if (android.support.v4.media.session.b.E(str)) {
                Uri uri = Uri.parse(str);
                String scheme = uri.getScheme();
                if (scheme != null) {
                    int iHashCode = scheme.hashCode();
                    if (iHashCode != 3143036) {
                        if (iHashCode == 951530617 && scheme.equals("content")) {
                            if (DocumentsContract.isDocumentUri(context, uri)) {
                                DocumentsContract.deleteDocument(context.getContentResolver(), uri);
                            } else {
                                context.getContentResolver().delete(uri, null, null);
                            }
                        }
                    } else if (scheme.equals("file")) {
                        File file = new File(String.valueOf(uri.getPath()));
                        if (file.canWrite() && file.exists() && file.exists() && file.canWrite()) {
                            file.delete();
                        }
                    }
                }
            } else {
                File file2 = new File(str);
                if (file2.exists() && file2.canWrite()) {
                    file2.delete();
                }
            }
            p6.d dVarQ = gVar.q();
            if (dVarQ != null) {
                i2.k kVar2 = ((cd.c) ((t3) dVarQ.f10037w).f9367v).f;
                j4.n(eVar, "GET");
                j4.d(eVar.f3676v, (String) kVar2.f6086w);
            }
        }
    }

    public final ArrayList q(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            cd.k kVar = (cd.k) it.next();
            dd.e eVar = new dd.e();
            ge.i.e(kVar, "<this>");
            eVar.f3676v = kVar.H;
            eVar.j(kVar.F);
            eVar.g(kVar.G);
            cd.h hVar = kVar.f2183y;
            ge.i.e(hVar, "<set-?>");
            eVar.A = hVar;
            eVar.B = s.C(kVar.f2182x);
            eVar.f3680z = kVar.f2181w;
            cd.g gVar = kVar.f2184z;
            ge.i.e(gVar, "<set-?>");
            eVar.G = gVar;
            cd.l lVar = ld.a.f7952e;
            ge.i.e(lVar, "<set-?>");
            eVar.E = lVar;
            eVar.e(ld.a.f7951d);
            eVar.C = 0L;
            eVar.I = kVar.A;
            cd.a aVar = kVar.B;
            ge.i.e(aVar, "<set-?>");
            eVar.J = aVar;
            eVar.K = kVar.f2180v;
            eVar.L = kVar.C;
            md.g gVar2 = kVar.E;
            ge.i.e(gVar2, "<set-?>");
            eVar.M = gVar2;
            eVar.N = kVar.D;
            eVar.O = 0;
            eVar.f3677w = "LibGlobalFetchLib";
            try {
                boolean z10 = z(eVar);
                if (eVar.E != cd.l.B) {
                    eVar.E = kVar.C ? cd.l.f2187y : cd.l.G;
                    if (z10) {
                        this.f5912v.A(eVar);
                        this.f5915y.b("Updated download " + eVar);
                        arrayList.add(new rd.f(eVar, cd.b.f2152y));
                    } else {
                        rd.f fVarZ = this.f5912v.z(eVar);
                        this.f5915y.b("Enqueued download " + fVarZ.f10993v);
                        arrayList.add(new rd.f(fVarZ.f10993v, cd.b.f2152y));
                        A();
                    }
                } else {
                    arrayList.add(new rd.f(eVar, cd.b.f2152y));
                }
                if (this.B == cd.i.f2178w && !this.f5913w.a()) {
                    id.d dVar = this.f5914x;
                    synchronized (dVar.C) {
                        dVar.C();
                        dVar.E = true;
                        dVar.F = false;
                        dVar.f6446x.g();
                        dVar.f6448z.getClass();
                    }
                }
            } catch (Exception e9) {
                arrayList.add(new rd.f(eVar, com.bumptech.glide.c.n(e9)));
            }
        }
        A();
        return arrayList;
    }

    public final boolean s(boolean z10) {
        long count;
        if (ge.i.a(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            throw new a9.l("blocking_call_on_ui_thread");
        }
        dd.g gVar = this.f5912v;
        synchronized (gVar.f3687w) {
            dd.f fVar = gVar.f3686v;
            try {
                Cursor cursorZ = fVar.B.Z(z10 ? fVar.D : fVar.C);
                count = cursorZ.getCount();
                cursorZ.close();
            } catch (Exception unused) {
                count = -1;
            }
        }
        return count > 0;
    }

    public final boolean z(dd.e eVar) throws IOException {
        cd.l lVar = cd.l.B;
        cd.a aVar = cd.a.f2144y;
        cd.l lVar2 = cd.l.f2187y;
        d5.a aVar2 = this.f5915y;
        i2.k kVar = this.A;
        a(n5.a.x(eVar));
        dd.g gVar = this.f5912v;
        dd.e eVarA = gVar.a(eVar.f3679y);
        if (eVarA != null) {
            a(n5.a.x(eVarA));
            eVarA = gVar.a(eVar.f3679y);
            if (eVarA == null || eVarA.E != cd.l.f2188z) {
                if ((eVarA != null ? eVarA.E : null) == lVar && eVar.J == cd.a.A && !kVar.i(eVarA.f3679y)) {
                    try {
                        synchronized (gVar.f3687w) {
                            gVar.f3686v.a(eVarA);
                        }
                    } catch (Exception e9) {
                        e9.getMessage();
                        aVar2.getClass();
                    }
                    if (eVar.J != aVar) {
                        kVar.d(eVar.f3679y, false);
                    }
                    eVarA = null;
                }
            } else {
                eVarA.E = lVar2;
                try {
                    gVar.A(eVarA);
                } catch (Exception e10) {
                    e10.getMessage();
                    aVar2.getClass();
                }
            }
        } else if (eVar.J != aVar) {
            kVar.d(eVar.f3679y, false);
        }
        int iOrdinal = eVar.J.ordinal();
        if (iOrdinal == 0) {
            if (eVarA != null) {
                g(n5.a.x(eVarA));
            }
            g(n5.a.x(eVar));
            return false;
        }
        if (iOrdinal == 1) {
            kVar.d(eVar.f3679y, true);
            eVar.g(eVar.f3679y);
            String str = eVar.f3678x;
            String str2 = eVar.f3679y;
            ge.i.e(str, "url");
            ge.i.e(str2, "file");
            eVar.f3676v = str2.hashCode() + (str.hashCode() * 31);
            return false;
        }
        if (iOrdinal == 2) {
            if (eVarA == null) {
                return false;
            }
            throw new a9.l("request_with_file_path_already_exist");
        }
        if (iOrdinal != 3) {
            throw new a9.l();
        }
        if (eVarA == null) {
            return false;
        }
        eVar.C = eVarA.C;
        eVar.D = eVarA.D;
        eVar.e(eVarA.F);
        cd.l lVar3 = eVarA.E;
        ge.i.e(lVar3, "<set-?>");
        eVar.E = lVar3;
        if (lVar3 != lVar) {
            eVar.E = lVar2;
            eVar.e(ld.a.f7951d);
        }
        if (eVar.E == lVar && !kVar.i(eVar.f3679y)) {
            kVar.d(eVar.f3679y, false);
            eVar.C = 0L;
            eVar.D = -1L;
            eVar.E = lVar2;
            eVar.e(ld.a.f7951d);
        }
        return true;
    }
}
