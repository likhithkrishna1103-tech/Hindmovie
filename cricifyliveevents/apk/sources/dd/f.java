package dd;

import a9.l;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import cd.h;
import com.tonyodev.fetch2.database.DownloadDatabase;
import e5.j;
import ge.i;
import i2.k;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import w4.q;
import w4.s;
import w4.t;
import w4.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Closeable {
    public final DownloadDatabase A;
    public final d5.b B;
    public final String C;
    public final String D;
    public final ArrayList E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d5.a f3681v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.bumptech.glide.manager.e f3682w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k f3683x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f3684y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public p6.d f3685z;

    public f(Context context, d5.a aVar, ed.a[] aVarArr, com.bumptech.glide.manager.e eVar, k kVar) {
        i.e(context, "context");
        i.e(aVar, "logger");
        this.f3681v = aVar;
        this.f3682w = eVar;
        this.f3683x = kVar;
        q qVarG = com.bumptech.glide.c.g(context, DownloadDatabase.class, "LibGlobalFetchLib.db");
        ed.a[] aVarArr2 = (ed.a[]) Arrays.copyOf(aVarArr, aVarArr.length);
        LinkedHashSet linkedHashSet = qVarG.f13981l;
        i.e(aVarArr2, "migrations");
        for (ed.a aVar2 : aVarArr2) {
            linkedHashSet.add(Integer.valueOf(aVar2.f3887a));
            linkedHashSet.add(Integer.valueOf(aVar2.f3888b));
        }
        w.b bVar = qVarG.f13979j;
        ed.a[] aVarArr3 = (ed.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length);
        bVar.getClass();
        i.e(aVarArr3, "migrations");
        for (ed.a aVar3 : aVarArr3) {
            bVar.a(aVar3);
        }
        DownloadDatabase downloadDatabase = (DownloadDatabase) qVarG.a();
        this.A = downloadDatabase;
        this.B = downloadDatabase.j().Y();
        this.C = "SELECT _id FROM requests WHERE _status = '1' OR _status = '2'";
        this.D = "SELECT _id FROM requests WHERE _status = '1' OR _status = '2' OR _status = '9'";
        this.E = new ArrayList();
    }

    public final rd.f A(e eVar) {
        O();
        c cVarQ = this.A.q();
        t tVar = (t) cVarQ.f3672w;
        tVar.b();
        tVar.c();
        try {
            a aVar = (a) cVarQ.f3673x;
            j jVarA = aVar.a();
            try {
                aVar.e(jVarA, eVar);
                long jExecuteInsert = jVarA.f3807w.executeInsert();
                aVar.d(jVarA);
                tVar.j().Y().N();
                tVar.g();
                return new rd.f(eVar, Boolean.valueOf(jExecuteInsert != -1));
            } catch (Throwable th) {
                aVar.d(jVarA);
                throw th;
            }
        } catch (Throwable th2) {
            tVar.g();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean C(java.util.List r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: dd.f.C(java.util.List, boolean):boolean");
    }

    public final void J() {
        O();
        com.bumptech.glide.manager.e eVar = this.f3682w;
        synchronized (eVar.f2265w) {
            if (!eVar.f2264v) {
                C(g(), true);
                eVar.f2264v = true;
            }
        }
    }

    public final void O() {
        if (this.f3684y) {
            throw new l("LibGlobalFetchLib database is closed");
        }
    }

    public final void Q(e eVar) {
        i.e(eVar, "downloadInfo");
        O();
        c cVarQ = this.A.q();
        t tVar = (t) cVarQ.f3672w;
        tVar.b();
        tVar.c();
        try {
            b bVar = (b) cVarQ.A;
            j jVarA = bVar.a();
            try {
                bVar.e(jVarA, eVar);
                jVarA.a();
                bVar.d(jVarA);
                tVar.j().Y().N();
            } catch (Throwable th) {
                bVar.d(jVarA);
                throw th;
            }
        } finally {
            tVar.g();
        }
    }

    public final void R(e eVar) {
        d5.a aVar = this.f3681v;
        d5.b bVar = this.B;
        i.e(eVar, "downloadInfo");
        O();
        try {
            bVar.i();
            bVar.M(new Object[]{Long.valueOf(eVar.C), Long.valueOf(eVar.D), Integer.valueOf(eVar.E.f2189v), Integer.valueOf(eVar.f3676v)});
            bVar.N();
        } catch (SQLiteException unused) {
            aVar.getClass();
        }
        try {
            bVar.h();
        } catch (SQLiteException unused2) {
            aVar.getClass();
        }
    }

    public final void a(e eVar) {
        O();
        c cVarQ = this.A.q();
        t tVar = (t) cVarQ.f3672w;
        tVar.b();
        tVar.c();
        try {
            b bVar = (b) cVarQ.f3675z;
            j jVarA = bVar.a();
            try {
                bVar.e(jVarA, eVar);
                jVarA.a();
                bVar.d(jVarA);
                tVar.j().Y().N();
            } catch (Throwable th) {
                bVar.d(jVarA);
                throw th;
            }
        } finally {
            tVar.g();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f3684y) {
            return;
        }
        this.f3684y = true;
        try {
            this.B.close();
        } catch (Exception unused) {
        }
        try {
            l7.a aVar = this.A.f;
            synchronized (aVar) {
                if (((AtomicBoolean) aVar.f7868y).compareAndSet(false, true)) {
                    while (((AtomicInteger) aVar.f7867x).get() != 0) {
                    }
                    ((s) aVar.f7866w).b();
                }
            }
        } catch (Exception unused2) {
        }
        this.f3681v.getClass();
    }

    public final List g() throws Throwable {
        y yVar;
        O();
        c cVarQ = this.A.q();
        Object obj = cVarQ.f3674y;
        y yVarG = y.g(0, "SELECT * FROM requests");
        t tVar = (t) cVarQ.f3672w;
        tVar.b();
        Cursor cursorT = ab.b.t(tVar, yVarG);
        try {
            int iD = a.a.d(cursorT, "_id");
            int iD2 = a.a.d(cursorT, "_namespace");
            int iD3 = a.a.d(cursorT, "_url");
            int iD4 = a.a.d(cursorT, "_file");
            int iD5 = a.a.d(cursorT, "_group");
            int iD6 = a.a.d(cursorT, "_priority");
            int iD7 = a.a.d(cursorT, "_headers");
            int iD8 = a.a.d(cursorT, "_written_bytes");
            int iD9 = a.a.d(cursorT, "_total_bytes");
            int iD10 = a.a.d(cursorT, "_status");
            int iD11 = a.a.d(cursorT, "_error");
            int iD12 = a.a.d(cursorT, "_network_type");
            int iD13 = a.a.d(cursorT, "_created");
            yVar = yVarG;
            try {
                int iD14 = a.a.d(cursorT, "_tag");
                try {
                    int iD15 = a.a.d(cursorT, "_enqueue_action");
                    int iD16 = a.a.d(cursorT, "_identifier");
                    int iD17 = a.a.d(cursorT, "_download_on_enqueue");
                    int iD18 = a.a.d(cursorT, "_extras");
                    int iD19 = a.a.d(cursorT, "_auto_retry_max_attempts");
                    int iD20 = a.a.d(cursorT, "_auto_retry_attempts");
                    int i = iD14;
                    ArrayList arrayList = new ArrayList(cursorT.getCount());
                    while (cursorT.moveToNext()) {
                        e eVar = new e();
                        ArrayList arrayList2 = arrayList;
                        eVar.f3676v = cursorT.getInt(iD);
                        eVar.h(cursorT.getString(iD2));
                        eVar.j(cursorT.getString(iD3));
                        eVar.g(cursorT.getString(iD4));
                        eVar.f3680z = cursorT.getInt(iD5);
                        int i10 = cursorT.getInt(iD6);
                        h.f2172w.getClass();
                        eVar.A = fc.e.j(i10);
                        eVar.B = fc.e.e(cursorT.getString(iD7));
                        int i11 = iD;
                        eVar.C = cursorT.getLong(iD8);
                        eVar.D = cursorT.getLong(iD9);
                        int i12 = cursorT.getInt(iD10);
                        cd.l.f2185w.getClass();
                        eVar.E = jb.b.h(i12);
                        int i13 = cursorT.getInt(iD11);
                        cd.b.f2150w.getClass();
                        eVar.F = jb.b.g(i13);
                        int i14 = cursorT.getInt(iD12);
                        cd.g.f2167w.getClass();
                        eVar.G = o8.j.j(i14);
                        eVar.H = cursorT.getLong(iD13);
                        int i15 = i;
                        eVar.I = cursorT.isNull(i15) ? null : cursorT.getString(i15);
                        int i16 = iD15;
                        int i17 = cursorT.getInt(i16);
                        cd.a.f2142w.getClass();
                        i = i15;
                        eVar.J = fc.e.i(i17);
                        int i18 = iD13;
                        int i19 = iD16;
                        eVar.K = cursorT.getLong(i19);
                        int i20 = iD17;
                        eVar.L = cursorT.getInt(i20) != 0;
                        int i21 = iD18;
                        eVar.M = fc.e.b(cursorT.getString(i21));
                        iD17 = i20;
                        int i22 = iD19;
                        eVar.N = cursorT.getInt(i22);
                        iD19 = i22;
                        int i23 = iD20;
                        eVar.O = cursorT.getInt(i23);
                        arrayList2.add(eVar);
                        iD18 = i21;
                        iD13 = i18;
                        iD15 = i16;
                        iD16 = i19;
                        iD20 = i23;
                        arrayList = arrayList2;
                        iD = i11;
                    }
                    List list = arrayList;
                    cursorT.close();
                    yVar.q();
                    C(list, false);
                    return list;
                } catch (Throwable th) {
                    th = th;
                    cursorT.close();
                    yVar.q();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            yVar = yVarG;
        }
    }

    public final e q(String str) throws Throwable {
        y yVar;
        int iD;
        int iD2;
        int iD3;
        int iD4;
        int iD5;
        int iD6;
        int iD7;
        int iD8;
        int iD9;
        int iD10;
        int iD11;
        int iD12;
        int iD13;
        int iD14;
        i.e(str, "file");
        O();
        c cVarQ = this.A.q();
        Object obj = cVarQ.f3674y;
        y yVarG = y.g(1, "SELECT * FROM requests WHERE _file = ?");
        yVarG.n(1, str);
        t tVar = (t) cVarQ.f3672w;
        tVar.b();
        Cursor cursorT = ab.b.t(tVar, yVarG);
        try {
            iD = a.a.d(cursorT, "_id");
            iD2 = a.a.d(cursorT, "_namespace");
            iD3 = a.a.d(cursorT, "_url");
            iD4 = a.a.d(cursorT, "_file");
            iD5 = a.a.d(cursorT, "_group");
            iD6 = a.a.d(cursorT, "_priority");
            iD7 = a.a.d(cursorT, "_headers");
            iD8 = a.a.d(cursorT, "_written_bytes");
            iD9 = a.a.d(cursorT, "_total_bytes");
            iD10 = a.a.d(cursorT, "_status");
            iD11 = a.a.d(cursorT, "_error");
            iD12 = a.a.d(cursorT, "_network_type");
            iD13 = a.a.d(cursorT, "_created");
            yVar = yVarG;
            try {
                iD14 = a.a.d(cursorT, "_tag");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            yVar = yVarG;
        }
        try {
            int iD15 = a.a.d(cursorT, "_enqueue_action");
            int iD16 = a.a.d(cursorT, "_identifier");
            int iD17 = a.a.d(cursorT, "_download_on_enqueue");
            int iD18 = a.a.d(cursorT, "_extras");
            int iD19 = a.a.d(cursorT, "_auto_retry_max_attempts");
            int iD20 = a.a.d(cursorT, "_auto_retry_attempts");
            e eVar = null;
            if (cursorT.moveToFirst()) {
                e eVar2 = new e();
                eVar2.f3676v = cursorT.getInt(iD);
                eVar2.h(cursorT.getString(iD2));
                eVar2.j(cursorT.getString(iD3));
                eVar2.g(cursorT.getString(iD4));
                eVar2.f3680z = cursorT.getInt(iD5);
                int i = cursorT.getInt(iD6);
                h.f2172w.getClass();
                eVar2.A = fc.e.j(i);
                eVar2.B = fc.e.e(cursorT.getString(iD7));
                eVar2.C = cursorT.getLong(iD8);
                eVar2.D = cursorT.getLong(iD9);
                int i10 = cursorT.getInt(iD10);
                cd.l.f2185w.getClass();
                eVar2.E = jb.b.h(i10);
                int i11 = cursorT.getInt(iD11);
                cd.b.f2150w.getClass();
                eVar2.F = jb.b.g(i11);
                int i12 = cursorT.getInt(iD12);
                cd.g.f2167w.getClass();
                eVar2.G = o8.j.j(i12);
                eVar2.H = cursorT.getLong(iD13);
                eVar2.I = cursorT.isNull(iD14) ? null : cursorT.getString(iD14);
                int i13 = cursorT.getInt(iD15);
                cd.a.f2142w.getClass();
                eVar2.J = fc.e.i(i13);
                eVar2.K = cursorT.getLong(iD16);
                eVar2.L = cursorT.getInt(iD17) != 0;
                eVar2.M = fc.e.b(cursorT.getString(iD18));
                eVar2.N = cursorT.getInt(iD19);
                eVar2.O = cursorT.getInt(iD20);
                eVar = eVar2;
            }
            cursorT.close();
            yVar.q();
            if (eVar == null) {
                return eVar;
            }
            C(n5.a.x(eVar), false);
            return eVar;
        } catch (Throwable th3) {
            th = th3;
            cursorT.close();
            yVar.q();
            throw th;
        }
    }

    public final List s(int i) throws Throwable {
        y yVar;
        O();
        c cVarQ = this.A.q();
        Object obj = cVarQ.f3674y;
        y yVarG = y.g(1, "SELECT * FROM requests WHERE _group = ?");
        yVarG.e(1, i);
        t tVar = (t) cVarQ.f3672w;
        tVar.b();
        Cursor cursorT = ab.b.t(tVar, yVarG);
        try {
            int iD = a.a.d(cursorT, "_id");
            int iD2 = a.a.d(cursorT, "_namespace");
            int iD3 = a.a.d(cursorT, "_url");
            int iD4 = a.a.d(cursorT, "_file");
            int iD5 = a.a.d(cursorT, "_group");
            int iD6 = a.a.d(cursorT, "_priority");
            int iD7 = a.a.d(cursorT, "_headers");
            int iD8 = a.a.d(cursorT, "_written_bytes");
            int iD9 = a.a.d(cursorT, "_total_bytes");
            int iD10 = a.a.d(cursorT, "_status");
            int iD11 = a.a.d(cursorT, "_error");
            int iD12 = a.a.d(cursorT, "_network_type");
            int iD13 = a.a.d(cursorT, "_created");
            yVar = yVarG;
            try {
                int iD14 = a.a.d(cursorT, "_tag");
                try {
                    int iD15 = a.a.d(cursorT, "_enqueue_action");
                    int iD16 = a.a.d(cursorT, "_identifier");
                    int iD17 = a.a.d(cursorT, "_download_on_enqueue");
                    int iD18 = a.a.d(cursorT, "_extras");
                    int iD19 = a.a.d(cursorT, "_auto_retry_max_attempts");
                    int iD20 = a.a.d(cursorT, "_auto_retry_attempts");
                    int i10 = iD14;
                    ArrayList arrayList = new ArrayList(cursorT.getCount());
                    while (cursorT.moveToNext()) {
                        e eVar = new e();
                        ArrayList arrayList2 = arrayList;
                        eVar.f3676v = cursorT.getInt(iD);
                        eVar.h(cursorT.getString(iD2));
                        eVar.j(cursorT.getString(iD3));
                        eVar.g(cursorT.getString(iD4));
                        eVar.f3680z = cursorT.getInt(iD5);
                        int i11 = cursorT.getInt(iD6);
                        h.f2172w.getClass();
                        eVar.A = fc.e.j(i11);
                        eVar.B = fc.e.e(cursorT.getString(iD7));
                        int i12 = iD;
                        eVar.C = cursorT.getLong(iD8);
                        eVar.D = cursorT.getLong(iD9);
                        int i13 = cursorT.getInt(iD10);
                        cd.l.f2185w.getClass();
                        eVar.E = jb.b.h(i13);
                        int i14 = cursorT.getInt(iD11);
                        cd.b.f2150w.getClass();
                        eVar.F = jb.b.g(i14);
                        int i15 = cursorT.getInt(iD12);
                        cd.g.f2167w.getClass();
                        eVar.G = o8.j.j(i15);
                        eVar.H = cursorT.getLong(iD13);
                        int i16 = i10;
                        eVar.I = cursorT.isNull(i16) ? null : cursorT.getString(i16);
                        int i17 = iD15;
                        int i18 = cursorT.getInt(i17);
                        cd.a.f2142w.getClass();
                        eVar.J = fc.e.i(i18);
                        int i19 = iD13;
                        int i20 = iD16;
                        eVar.K = cursorT.getLong(i20);
                        int i21 = iD17;
                        eVar.L = cursorT.getInt(i21) != 0;
                        int i22 = iD18;
                        eVar.M = fc.e.b(cursorT.getString(i22));
                        iD17 = i21;
                        int i23 = iD19;
                        eVar.N = cursorT.getInt(i23);
                        iD19 = i23;
                        int i24 = iD20;
                        eVar.O = cursorT.getInt(i24);
                        arrayList2.add(eVar);
                        iD13 = i19;
                        iD15 = i17;
                        iD16 = i20;
                        iD18 = i22;
                        iD20 = i24;
                        i10 = i16;
                        arrayList = arrayList2;
                        iD = i12;
                    }
                    List list = arrayList;
                    cursorT.close();
                    yVar.q();
                    C(list, false);
                    return list;
                } catch (Throwable th) {
                    th = th;
                    cursorT.close();
                    yVar.q();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            yVar = yVarG;
        }
    }

    public final List z(cd.i iVar) throws Throwable {
        y yVar;
        int iD;
        int iD2;
        int iD3;
        int iD4;
        int iD5;
        int iD6;
        int iD7;
        int iD8;
        int iD9;
        int iD10;
        int iD11;
        int iD12;
        int iD13;
        int iD14;
        f fVar;
        ArrayList arrayList;
        y yVar2;
        int iD15;
        int iD16;
        int iD17;
        int iD18;
        int iD19;
        int iD20;
        int iD21;
        int iD22;
        int iD23;
        int iD24;
        int iD25;
        int iD26;
        int iD27;
        i.e(iVar, "prioritySort");
        O();
        cd.i iVar2 = cd.i.f2177v;
        fc.e eVar = cd.a.f2142w;
        o8.j jVar = cd.g.f2167w;
        jb.b bVar = cd.b.f2150w;
        jb.b bVar2 = cd.l.f2185w;
        fc.e eVar2 = h.f2172w;
        DownloadDatabase downloadDatabase = this.A;
        if (iVar == iVar2) {
            c cVarQ = downloadDatabase.q();
            cVarQ.getClass();
            y yVarG = y.g(1, "SELECT * FROM requests WHERE _status = ? ORDER BY _priority DESC, _created ASC");
            yVarG.e(1, 1);
            t tVar = (t) cVarQ.f3672w;
            tVar.b();
            Cursor cursorT = ab.b.t(tVar, yVarG);
            try {
                iD15 = a.a.d(cursorT, "_id");
                iD16 = a.a.d(cursorT, "_namespace");
                iD17 = a.a.d(cursorT, "_url");
                iD18 = a.a.d(cursorT, "_file");
                iD19 = a.a.d(cursorT, "_group");
                iD20 = a.a.d(cursorT, "_priority");
                iD21 = a.a.d(cursorT, "_headers");
                iD22 = a.a.d(cursorT, "_written_bytes");
                iD23 = a.a.d(cursorT, "_total_bytes");
                iD24 = a.a.d(cursorT, "_status");
                iD25 = a.a.d(cursorT, "_error");
                iD26 = a.a.d(cursorT, "_network_type");
                iD27 = a.a.d(cursorT, "_created");
                yVar2 = yVarG;
            } catch (Throwable th) {
                th = th;
                yVar2 = yVarG;
            }
            try {
                int iD28 = a.a.d(cursorT, "_tag");
                int iD29 = a.a.d(cursorT, "_enqueue_action");
                int iD30 = a.a.d(cursorT, "_identifier");
                int iD31 = a.a.d(cursorT, "_download_on_enqueue");
                int iD32 = a.a.d(cursorT, "_extras");
                int iD33 = a.a.d(cursorT, "_auto_retry_max_attempts");
                int iD34 = a.a.d(cursorT, "_auto_retry_attempts");
                int i = iD28;
                arrayList = new ArrayList(cursorT.getCount());
                while (cursorT.moveToNext()) {
                    e eVar3 = new e();
                    ArrayList arrayList2 = arrayList;
                    eVar3.f3676v = cursorT.getInt(iD15);
                    eVar3.h(cursorT.getString(iD16));
                    eVar3.j(cursorT.getString(iD17));
                    eVar3.g(cursorT.getString(iD18));
                    eVar3.f3680z = cursorT.getInt(iD19);
                    int i10 = cursorT.getInt(iD20);
                    eVar2.getClass();
                    eVar3.A = fc.e.j(i10);
                    eVar3.B = fc.e.e(cursorT.getString(iD21));
                    int i11 = iD15;
                    eVar3.C = cursorT.getLong(iD22);
                    eVar3.D = cursorT.getLong(iD23);
                    int i12 = cursorT.getInt(iD24);
                    bVar2.getClass();
                    eVar3.E = jb.b.h(i12);
                    int i13 = cursorT.getInt(iD25);
                    bVar.getClass();
                    eVar3.F = jb.b.g(i13);
                    int i14 = cursorT.getInt(iD26);
                    jVar.getClass();
                    eVar3.G = o8.j.j(i14);
                    eVar3.H = cursorT.getLong(iD27);
                    int i15 = i;
                    eVar3.I = cursorT.isNull(i15) ? null : cursorT.getString(i15);
                    int i16 = iD29;
                    int i17 = cursorT.getInt(i16);
                    eVar.getClass();
                    i = i15;
                    eVar3.J = fc.e.i(i17);
                    int i18 = iD24;
                    int i19 = iD30;
                    int i20 = iD16;
                    eVar3.K = cursorT.getLong(i19);
                    int i21 = iD31;
                    eVar3.L = cursorT.getInt(i21) != 0;
                    int i22 = iD32;
                    eVar3.M = fc.e.b(cursorT.getString(i22));
                    int i23 = iD33;
                    eVar3.N = cursorT.getInt(i23);
                    int i24 = iD34;
                    eVar3.O = cursorT.getInt(i24);
                    arrayList2.add(eVar3);
                    iD31 = i21;
                    iD16 = i20;
                    iD30 = i19;
                    iD32 = i22;
                    iD24 = i18;
                    iD29 = i16;
                    iD33 = i23;
                    iD34 = i24;
                    arrayList = arrayList2;
                    iD15 = i11;
                }
                cursorT.close();
                yVar2.q();
                fVar = this;
            } catch (Throwable th2) {
                th = th2;
                cursorT.close();
                yVar2.q();
                throw th;
            }
        } else {
            c cVarQ2 = downloadDatabase.q();
            cVarQ2.getClass();
            y yVarG2 = y.g(1, "SELECT * FROM requests WHERE _status = ? ORDER BY _priority DESC, _created DESC");
            yVarG2.e(1, 1);
            t tVar2 = (t) cVarQ2.f3672w;
            tVar2.b();
            Cursor cursorT2 = ab.b.t(tVar2, yVarG2);
            try {
                iD = a.a.d(cursorT2, "_id");
                iD2 = a.a.d(cursorT2, "_namespace");
                iD3 = a.a.d(cursorT2, "_url");
                iD4 = a.a.d(cursorT2, "_file");
                iD5 = a.a.d(cursorT2, "_group");
                iD6 = a.a.d(cursorT2, "_priority");
                iD7 = a.a.d(cursorT2, "_headers");
                iD8 = a.a.d(cursorT2, "_written_bytes");
                iD9 = a.a.d(cursorT2, "_total_bytes");
                iD10 = a.a.d(cursorT2, "_status");
                iD11 = a.a.d(cursorT2, "_error");
                iD12 = a.a.d(cursorT2, "_network_type");
                iD13 = a.a.d(cursorT2, "_created");
                iD14 = a.a.d(cursorT2, "_tag");
                yVar = yVarG2;
            } catch (Throwable th3) {
                th = th3;
                yVar = yVarG2;
            }
            try {
                int iD35 = a.a.d(cursorT2, "_enqueue_action");
                int iD36 = a.a.d(cursorT2, "_identifier");
                int iD37 = a.a.d(cursorT2, "_download_on_enqueue");
                int iD38 = a.a.d(cursorT2, "_extras");
                int iD39 = a.a.d(cursorT2, "_auto_retry_max_attempts");
                int iD40 = a.a.d(cursorT2, "_auto_retry_attempts");
                int i25 = iD14;
                ArrayList arrayList3 = new ArrayList(cursorT2.getCount());
                while (cursorT2.moveToNext()) {
                    e eVar4 = new e();
                    ArrayList arrayList4 = arrayList3;
                    eVar4.f3676v = cursorT2.getInt(iD);
                    eVar4.h(cursorT2.getString(iD2));
                    eVar4.j(cursorT2.getString(iD3));
                    eVar4.g(cursorT2.getString(iD4));
                    eVar4.f3680z = cursorT2.getInt(iD5);
                    int i26 = cursorT2.getInt(iD6);
                    eVar2.getClass();
                    eVar4.A = fc.e.j(i26);
                    eVar4.B = fc.e.e(cursorT2.getString(iD7));
                    int i27 = iD;
                    eVar4.C = cursorT2.getLong(iD8);
                    eVar4.D = cursorT2.getLong(iD9);
                    int i28 = cursorT2.getInt(iD10);
                    bVar2.getClass();
                    eVar4.E = jb.b.h(i28);
                    int i29 = cursorT2.getInt(iD11);
                    bVar.getClass();
                    eVar4.F = jb.b.g(i29);
                    int i30 = cursorT2.getInt(iD12);
                    jVar.getClass();
                    eVar4.G = o8.j.j(i30);
                    eVar4.H = cursorT2.getLong(iD13);
                    int i31 = i25;
                    eVar4.I = cursorT2.isNull(i31) ? null : cursorT2.getString(i31);
                    int i32 = iD35;
                    int i33 = cursorT2.getInt(i32);
                    eVar.getClass();
                    int i34 = iD10;
                    eVar4.J = fc.e.i(i33);
                    iD35 = i32;
                    int i35 = iD36;
                    eVar4.K = cursorT2.getLong(i35);
                    int i36 = iD37;
                    eVar4.L = cursorT2.getInt(i36) != 0;
                    int i37 = iD38;
                    eVar4.M = fc.e.b(cursorT2.getString(i37));
                    int i38 = iD39;
                    eVar4.N = cursorT2.getInt(i38);
                    int i39 = iD40;
                    eVar4.O = cursorT2.getInt(i39);
                    arrayList4.add(eVar4);
                    arrayList3 = arrayList4;
                    iD10 = i34;
                    i25 = i31;
                    iD36 = i35;
                    iD37 = i36;
                    iD39 = i38;
                    iD40 = i39;
                    iD38 = i37;
                    iD = i27;
                }
                cursorT2.close();
                yVar.q();
                fVar = this;
                arrayList = arrayList3;
            } catch (Throwable th4) {
                th = th4;
                cursorT2.close();
                yVar.q();
                throw th;
            }
        }
        if (!fVar.C(arrayList, false)) {
            return arrayList;
        }
        ArrayList arrayList5 = new ArrayList();
        int size = arrayList.size();
        int i40 = 0;
        while (i40 < size) {
            Object obj = arrayList.get(i40);
            i40++;
            if (((e) obj).E == cd.l.f2187y) {
                arrayList5.add(obj);
            }
        }
        return arrayList5;
    }
}
