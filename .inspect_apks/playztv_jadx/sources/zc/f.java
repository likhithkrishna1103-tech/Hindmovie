package zc;

import a2.y0;
import a5.l;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import cc.w;
import com.tonyodev.fetch2.database.DownloadDatabase;
import h4.z;
import id.h;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import n.a1;
import r4.q;
import r4.s;
import r4.t;
import r4.v;
import wa.t1;
import yc.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Closeable {
    public final z4.a A;
    public final String B;
    public final String C;
    public final ArrayList D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f14956u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bumptech.glide.manager.e f14957v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final z f14958w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f14959x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public rc.b f14960y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final DownloadDatabase f14961z;

    public f(Context context, h hVar, ad.a[] aVarArr, com.bumptech.glide.manager.e eVar, z zVar) {
        be.h.e(context, "context");
        be.h.e(hVar, "logger");
        this.f14956u = hVar;
        this.f14957v = eVar;
        this.f14958w = zVar;
        q qVarL = cf.d.l(context, DownloadDatabase.class, "LibGlobalFetchLib.db");
        ad.a[] aVarArr2 = (ad.a[]) Arrays.copyOf(aVarArr, aVarArr.length);
        LinkedHashSet linkedHashSet = qVarL.f11483l;
        be.h.e(aVarArr2, "migrations");
        for (ad.a aVar : aVarArr2) {
            linkedHashSet.add(Integer.valueOf(aVar.f792a));
            linkedHashSet.add(Integer.valueOf(aVar.f793b));
        }
        a1 a1Var = qVarL.f11481j;
        ad.a[] aVarArr3 = (ad.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length);
        a1Var.getClass();
        be.h.e(aVarArr3, "migrations");
        for (ad.a aVar2 : aVarArr3) {
            a1Var.q(aVar2);
        }
        DownloadDatabase downloadDatabase = (DownloadDatabase) qVarL.a();
        this.f14961z = downloadDatabase;
        this.A = downloadDatabase.h().Z();
        this.B = "SELECT _id FROM requests WHERE _status = '1' OR _status = '2'";
        this.C = "SELECT _id FROM requests WHERE _status = '1' OR _status = '2' OR _status = '9'";
        this.D = new ArrayList();
    }

    public final List F(int i) throws Throwable {
        v vVar;
        S();
        c cVarP = this.f14961z.p();
        Object obj = cVarP.f14947w;
        v vVarA = v.a("SELECT * FROM requests WHERE _group = ?", 1);
        vVarA.N(1, i);
        t tVar = (t) cVarP.f14945u;
        tVar.b();
        Cursor cursorW = z7.a.w(tVar, vVarA);
        try {
            int iM = t1.m(cursorW, "_id");
            int iM2 = t1.m(cursorW, "_namespace");
            int iM3 = t1.m(cursorW, "_url");
            int iM4 = t1.m(cursorW, "_file");
            int iM5 = t1.m(cursorW, "_group");
            int iM6 = t1.m(cursorW, "_priority");
            int iM7 = t1.m(cursorW, "_headers");
            int iM8 = t1.m(cursorW, "_written_bytes");
            int iM9 = t1.m(cursorW, "_total_bytes");
            int iM10 = t1.m(cursorW, "_status");
            int iM11 = t1.m(cursorW, "_error");
            int iM12 = t1.m(cursorW, "_network_type");
            int iM13 = t1.m(cursorW, "_created");
            vVar = vVarA;
            try {
                int iM14 = t1.m(cursorW, "_tag");
                try {
                    int iM15 = t1.m(cursorW, "_enqueue_action");
                    int iM16 = t1.m(cursorW, "_identifier");
                    int iM17 = t1.m(cursorW, "_download_on_enqueue");
                    int iM18 = t1.m(cursorW, "_extras");
                    int iM19 = t1.m(cursorW, "_auto_retry_max_attempts");
                    int iM20 = t1.m(cursorW, "_auto_retry_attempts");
                    int i10 = iM14;
                    ArrayList arrayList = new ArrayList(cursorW.getCount());
                    while (cursorW.moveToNext()) {
                        e eVar = new e();
                        ArrayList arrayList2 = arrayList;
                        eVar.f14950u = cursorW.getInt(iM);
                        eVar.h(cursorW.getString(iM2));
                        eVar.j(cursorW.getString(iM3));
                        eVar.g(cursorW.getString(iM4));
                        eVar.f14954y = cursorW.getInt(iM5);
                        int i11 = cursorW.getInt(iM6);
                        yc.g.f14672v.getClass();
                        eVar.f14955z = va.e.f(i11);
                        eVar.A = ua.c.d(cursorW.getString(iM7));
                        int i12 = iM;
                        eVar.B = cursorW.getLong(iM8);
                        eVar.C = cursorW.getLong(iM9);
                        int i13 = cursorW.getInt(iM10);
                        k.f14687v.getClass();
                        eVar.D = w2.f.b(i13);
                        int i14 = cursorW.getInt(iM11);
                        yc.b.f14648v.getClass();
                        eVar.E = w2.f.a(i14);
                        int i15 = cursorW.getInt(iM12);
                        yc.f.f14666v.getClass();
                        eVar.F = v8.c.a(i15);
                        eVar.G = cursorW.getLong(iM13);
                        int i16 = i10;
                        eVar.H = cursorW.isNull(i16) ? null : cursorW.getString(i16);
                        int i17 = iM15;
                        int i18 = cursorW.getInt(i17);
                        yc.a.f14640v.getClass();
                        eVar.I = va.e.e(i18);
                        int i19 = iM2;
                        int i20 = iM16;
                        int i21 = iM3;
                        eVar.J = cursorW.getLong(i20);
                        int i22 = iM17;
                        eVar.K = cursorW.getInt(i22) != 0;
                        int i23 = iM18;
                        eVar.L = ua.c.a(cursorW.getString(i23));
                        int i24 = iM19;
                        eVar.M = cursorW.getInt(i24);
                        iM19 = i24;
                        int i25 = iM20;
                        eVar.N = cursorW.getInt(i25);
                        arrayList2.add(eVar);
                        iM2 = i19;
                        iM15 = i17;
                        iM17 = i22;
                        iM18 = i23;
                        iM3 = i21;
                        iM16 = i20;
                        iM20 = i25;
                        i10 = i16;
                        arrayList = arrayList2;
                        iM = i12;
                    }
                    List list = arrayList;
                    cursorW.close();
                    vVar.x();
                    J(list, false);
                    return list;
                } catch (Throwable th) {
                    th = th;
                    cursorW.close();
                    vVar.x();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            vVar = vVarA;
        }
    }

    public final List G(yc.h hVar) throws Throwable {
        v vVar;
        int iM;
        int iM2;
        int iM3;
        int iM4;
        int iM5;
        int iM6;
        int iM7;
        int iM8;
        int iM9;
        int iM10;
        int iM11;
        int iM12;
        int iM13;
        int iM14;
        f fVar;
        ArrayList arrayList;
        v vVar2;
        int iM15;
        int iM16;
        int iM17;
        int iM18;
        int iM19;
        int iM20;
        int iM21;
        int iM22;
        int iM23;
        int iM24;
        int iM25;
        int iM26;
        int iM27;
        be.h.e(hVar, "prioritySort");
        S();
        yc.h hVar2 = yc.h.f14678u;
        va.e eVar = yc.a.f14640v;
        v8.c cVar = yc.f.f14666v;
        w2.f fVar2 = yc.b.f14648v;
        w2.f fVar3 = k.f14687v;
        va.e eVar2 = yc.g.f14672v;
        DownloadDatabase downloadDatabase = this.f14961z;
        if (hVar == hVar2) {
            c cVarP = downloadDatabase.p();
            cVarP.getClass();
            v vVarA = v.a("SELECT * FROM requests WHERE _status = ? ORDER BY _priority DESC, _created ASC", 1);
            vVarA.N(1, 1);
            t tVar = (t) cVarP.f14945u;
            tVar.b();
            Cursor cursorW = z7.a.w(tVar, vVarA);
            try {
                iM15 = t1.m(cursorW, "_id");
                iM16 = t1.m(cursorW, "_namespace");
                iM17 = t1.m(cursorW, "_url");
                iM18 = t1.m(cursorW, "_file");
                iM19 = t1.m(cursorW, "_group");
                iM20 = t1.m(cursorW, "_priority");
                iM21 = t1.m(cursorW, "_headers");
                iM22 = t1.m(cursorW, "_written_bytes");
                iM23 = t1.m(cursorW, "_total_bytes");
                iM24 = t1.m(cursorW, "_status");
                iM25 = t1.m(cursorW, "_error");
                iM26 = t1.m(cursorW, "_network_type");
                iM27 = t1.m(cursorW, "_created");
                vVar2 = vVarA;
            } catch (Throwable th) {
                th = th;
                vVar2 = vVarA;
            }
            try {
                int iM28 = t1.m(cursorW, "_tag");
                int iM29 = t1.m(cursorW, "_enqueue_action");
                int iM30 = t1.m(cursorW, "_identifier");
                int iM31 = t1.m(cursorW, "_download_on_enqueue");
                int iM32 = t1.m(cursorW, "_extras");
                int iM33 = t1.m(cursorW, "_auto_retry_max_attempts");
                int iM34 = t1.m(cursorW, "_auto_retry_attempts");
                int i = iM28;
                arrayList = new ArrayList(cursorW.getCount());
                while (cursorW.moveToNext()) {
                    e eVar3 = new e();
                    ArrayList arrayList2 = arrayList;
                    eVar3.f14950u = cursorW.getInt(iM15);
                    eVar3.h(cursorW.getString(iM16));
                    eVar3.j(cursorW.getString(iM17));
                    eVar3.g(cursorW.getString(iM18));
                    eVar3.f14954y = cursorW.getInt(iM19);
                    int i10 = cursorW.getInt(iM20);
                    eVar2.getClass();
                    eVar3.f14955z = va.e.f(i10);
                    eVar3.A = ua.c.d(cursorW.getString(iM21));
                    int i11 = iM15;
                    eVar3.B = cursorW.getLong(iM22);
                    eVar3.C = cursorW.getLong(iM23);
                    int i12 = cursorW.getInt(iM24);
                    fVar3.getClass();
                    eVar3.D = w2.f.b(i12);
                    int i13 = cursorW.getInt(iM25);
                    fVar2.getClass();
                    eVar3.E = w2.f.a(i13);
                    int i14 = cursorW.getInt(iM26);
                    cVar.getClass();
                    eVar3.F = v8.c.a(i14);
                    eVar3.G = cursorW.getLong(iM27);
                    int i15 = i;
                    eVar3.H = cursorW.isNull(i15) ? null : cursorW.getString(i15);
                    int i16 = iM29;
                    int i17 = cursorW.getInt(i16);
                    eVar.getClass();
                    i = i15;
                    eVar3.I = va.e.e(i17);
                    int i18 = iM24;
                    int i19 = iM30;
                    int i20 = iM16;
                    eVar3.J = cursorW.getLong(i19);
                    int i21 = iM31;
                    eVar3.K = cursorW.getInt(i21) != 0;
                    int i22 = iM32;
                    eVar3.L = ua.c.a(cursorW.getString(i22));
                    int i23 = iM33;
                    eVar3.M = cursorW.getInt(i23);
                    int i24 = iM34;
                    eVar3.N = cursorW.getInt(i24);
                    arrayList2.add(eVar3);
                    iM31 = i21;
                    iM16 = i20;
                    iM30 = i19;
                    iM32 = i22;
                    iM24 = i18;
                    iM29 = i16;
                    iM33 = i23;
                    iM34 = i24;
                    arrayList = arrayList2;
                    iM15 = i11;
                }
                cursorW.close();
                vVar2.x();
                fVar = this;
            } catch (Throwable th2) {
                th = th2;
                cursorW.close();
                vVar2.x();
                throw th;
            }
        } else {
            c cVarP2 = downloadDatabase.p();
            cVarP2.getClass();
            v vVarA2 = v.a("SELECT * FROM requests WHERE _status = ? ORDER BY _priority DESC, _created DESC", 1);
            vVarA2.N(1, 1);
            t tVar2 = (t) cVarP2.f14945u;
            tVar2.b();
            Cursor cursorW2 = z7.a.w(tVar2, vVarA2);
            try {
                iM = t1.m(cursorW2, "_id");
                iM2 = t1.m(cursorW2, "_namespace");
                iM3 = t1.m(cursorW2, "_url");
                iM4 = t1.m(cursorW2, "_file");
                iM5 = t1.m(cursorW2, "_group");
                iM6 = t1.m(cursorW2, "_priority");
                iM7 = t1.m(cursorW2, "_headers");
                iM8 = t1.m(cursorW2, "_written_bytes");
                iM9 = t1.m(cursorW2, "_total_bytes");
                iM10 = t1.m(cursorW2, "_status");
                iM11 = t1.m(cursorW2, "_error");
                iM12 = t1.m(cursorW2, "_network_type");
                iM13 = t1.m(cursorW2, "_created");
                iM14 = t1.m(cursorW2, "_tag");
                vVar = vVarA2;
            } catch (Throwable th3) {
                th = th3;
                vVar = vVarA2;
            }
            try {
                int iM35 = t1.m(cursorW2, "_enqueue_action");
                int iM36 = t1.m(cursorW2, "_identifier");
                int iM37 = t1.m(cursorW2, "_download_on_enqueue");
                int iM38 = t1.m(cursorW2, "_extras");
                int iM39 = t1.m(cursorW2, "_auto_retry_max_attempts");
                int iM40 = t1.m(cursorW2, "_auto_retry_attempts");
                int i25 = iM14;
                ArrayList arrayList3 = new ArrayList(cursorW2.getCount());
                while (cursorW2.moveToNext()) {
                    e eVar4 = new e();
                    ArrayList arrayList4 = arrayList3;
                    eVar4.f14950u = cursorW2.getInt(iM);
                    eVar4.h(cursorW2.getString(iM2));
                    eVar4.j(cursorW2.getString(iM3));
                    eVar4.g(cursorW2.getString(iM4));
                    eVar4.f14954y = cursorW2.getInt(iM5);
                    int i26 = cursorW2.getInt(iM6);
                    eVar2.getClass();
                    eVar4.f14955z = va.e.f(i26);
                    eVar4.A = ua.c.d(cursorW2.getString(iM7));
                    int i27 = iM;
                    eVar4.B = cursorW2.getLong(iM8);
                    eVar4.C = cursorW2.getLong(iM9);
                    int i28 = cursorW2.getInt(iM10);
                    fVar3.getClass();
                    eVar4.D = w2.f.b(i28);
                    int i29 = cursorW2.getInt(iM11);
                    fVar2.getClass();
                    eVar4.E = w2.f.a(i29);
                    int i30 = cursorW2.getInt(iM12);
                    cVar.getClass();
                    eVar4.F = v8.c.a(i30);
                    eVar4.G = cursorW2.getLong(iM13);
                    int i31 = i25;
                    eVar4.H = cursorW2.isNull(i31) ? null : cursorW2.getString(i31);
                    int i32 = iM35;
                    int i33 = cursorW2.getInt(i32);
                    eVar.getClass();
                    int i34 = iM10;
                    eVar4.I = va.e.e(i33);
                    iM35 = i32;
                    int i35 = iM36;
                    eVar4.J = cursorW2.getLong(i35);
                    int i36 = iM37;
                    eVar4.K = cursorW2.getInt(i36) != 0;
                    int i37 = iM38;
                    eVar4.L = ua.c.a(cursorW2.getString(i37));
                    int i38 = iM39;
                    eVar4.M = cursorW2.getInt(i38);
                    int i39 = iM40;
                    eVar4.N = cursorW2.getInt(i39);
                    arrayList4.add(eVar4);
                    arrayList3 = arrayList4;
                    iM10 = i34;
                    i25 = i31;
                    iM36 = i35;
                    iM37 = i36;
                    iM39 = i38;
                    iM40 = i39;
                    iM38 = i37;
                    iM = i27;
                }
                cursorW2.close();
                vVar.x();
                fVar = this;
                arrayList = arrayList3;
            } catch (Throwable th4) {
                th = th4;
                cursorW2.close();
                vVar.x();
                throw th;
            }
        }
        if (!fVar.J(arrayList, false)) {
            return arrayList;
        }
        ArrayList arrayList5 = new ArrayList();
        int size = arrayList.size();
        int i40 = 0;
        while (i40 < size) {
            Object obj = arrayList.get(i40);
            i40++;
            if (((e) obj).D == k.f14689x) {
                arrayList5.add(obj);
            }
        }
        return arrayList5;
    }

    public final nd.f H(e eVar) {
        S();
        c cVarP = this.f14961z.p();
        t tVar = (t) cVarP.f14945u;
        tVar.b();
        tVar.a();
        tVar.a();
        z4.a aVarZ = tVar.h().Z();
        if (!aVarZ.D()) {
            b8.h.z(new w(tVar.g(), null, 3));
        }
        if (aVarZ.L()) {
            aVarZ.R();
        } else {
            aVarZ.f();
        }
        try {
            a aVar = (a) cVarP.f14946v;
            l lVarA = aVar.a();
            try {
                aVar.e(lVarA, eVar);
                long jExecuteInsert = lVarA.f570v.executeInsert();
                aVar.d(lVarA);
                tVar.h().Z().Q();
                tVar.m();
                return new nd.f(eVar, Boolean.valueOf(jExecuteInsert != -1));
            } catch (Throwable th) {
                aVar.d(lVarA);
                throw th;
            }
        } catch (Throwable th2) {
            tVar.m();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean J(java.util.List r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: zc.f.J(java.util.List, boolean):boolean");
    }

    public final void K() {
        S();
        com.bumptech.glide.manager.e eVar = this.f14957v;
        synchronized (eVar.f2837v) {
            if (!eVar.f2836u) {
                J(v(), true);
                eVar.f2836u = true;
            }
        }
    }

    public final void S() {
        if (this.f14959x) {
            throw new y0("LibGlobalFetchLib database is closed");
        }
    }

    public final void a(List list) {
        S();
        c cVarP = this.f14961z.p();
        t tVar = (t) cVarP.f14945u;
        tVar.b();
        tVar.a();
        tVar.a();
        z4.a aVarZ = tVar.h().Z();
        if (!aVarZ.D()) {
            b8.h.z(new w(tVar.g(), null, 3));
        }
        if (aVarZ.L()) {
            aVarZ.R();
        } else {
            aVarZ.f();
        }
        try {
            ((b) cVarP.f14948x).f(list);
            tVar.h().Z().Q();
        } finally {
            tVar.m();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f14959x) {
            return;
        }
        this.f14959x = true;
        try {
            this.A.close();
        } catch (Exception unused) {
        }
        try {
            kc.b bVar = this.f14961z.f;
            synchronized (bVar) {
                if (((AtomicBoolean) bVar.f7622x).compareAndSet(false, true)) {
                    while (((AtomicInteger) bVar.f7621w).get() != 0) {
                    }
                    ((s) bVar.f7620v).b();
                }
            }
        } catch (Exception unused2) {
        }
        this.f14956u.getClass();
    }

    public final void d(e eVar) {
        S();
        c cVarP = this.f14961z.p();
        t tVar = (t) cVarP.f14945u;
        tVar.b();
        tVar.a();
        tVar.a();
        z4.a aVarZ = tVar.h().Z();
        if (!aVarZ.D()) {
            b8.h.z(new w(tVar.g(), null, 3));
        }
        if (aVarZ.L()) {
            aVarZ.R();
        } else {
            aVarZ.f();
        }
        try {
            b bVar = (b) cVarP.f14948x;
            l lVarA = bVar.a();
            try {
                bVar.e(lVarA, eVar);
                lVarA.a();
                bVar.d(lVarA);
                tVar.h().Z().Q();
            } catch (Throwable th) {
                bVar.d(lVarA);
                throw th;
            }
        } finally {
            tVar.m();
        }
    }

    public final void g0(e eVar) {
        be.h.e(eVar, "downloadInfo");
        S();
        c cVarP = this.f14961z.p();
        t tVar = (t) cVarP.f14945u;
        tVar.b();
        tVar.a();
        tVar.a();
        z4.a aVarZ = tVar.h().Z();
        if (!aVarZ.D()) {
            b8.h.z(new w(tVar.g(), null, 3));
        }
        if (aVarZ.L()) {
            aVarZ.R();
        } else {
            aVarZ.f();
        }
        try {
            b bVar = (b) cVarP.f14949y;
            l lVarA = bVar.a();
            try {
                bVar.e(lVarA, eVar);
                lVarA.a();
                bVar.d(lVarA);
                tVar.h().Z().Q();
            } catch (Throwable th) {
                bVar.d(lVarA);
                throw th;
            }
        } finally {
            tVar.m();
        }
    }

    public final void h0(e eVar) {
        h hVar = this.f14956u;
        z4.a aVar = this.A;
        be.h.e(eVar, "downloadInfo");
        S();
        try {
            aVar.f();
            aVar.P(new Object[]{Long.valueOf(eVar.B), Long.valueOf(eVar.C), Integer.valueOf(eVar.D.f14692u), Integer.valueOf(eVar.f14950u)});
            aVar.Q();
        } catch (SQLiteException unused) {
            hVar.getClass();
        }
        try {
            aVar.e();
        } catch (SQLiteException unused2) {
            hVar.getClass();
        }
    }

    public final List v() throws Throwable {
        v vVar;
        S();
        c cVarP = this.f14961z.p();
        Object obj = cVarP.f14947w;
        v vVarA = v.a("SELECT * FROM requests", 0);
        t tVar = (t) cVarP.f14945u;
        tVar.b();
        Cursor cursorW = z7.a.w(tVar, vVarA);
        try {
            int iM = t1.m(cursorW, "_id");
            int iM2 = t1.m(cursorW, "_namespace");
            int iM3 = t1.m(cursorW, "_url");
            int iM4 = t1.m(cursorW, "_file");
            int iM5 = t1.m(cursorW, "_group");
            int iM6 = t1.m(cursorW, "_priority");
            int iM7 = t1.m(cursorW, "_headers");
            int iM8 = t1.m(cursorW, "_written_bytes");
            int iM9 = t1.m(cursorW, "_total_bytes");
            int iM10 = t1.m(cursorW, "_status");
            int iM11 = t1.m(cursorW, "_error");
            int iM12 = t1.m(cursorW, "_network_type");
            int iM13 = t1.m(cursorW, "_created");
            vVar = vVarA;
            try {
                int iM14 = t1.m(cursorW, "_tag");
                try {
                    int iM15 = t1.m(cursorW, "_enqueue_action");
                    int iM16 = t1.m(cursorW, "_identifier");
                    int iM17 = t1.m(cursorW, "_download_on_enqueue");
                    int iM18 = t1.m(cursorW, "_extras");
                    int iM19 = t1.m(cursorW, "_auto_retry_max_attempts");
                    int iM20 = t1.m(cursorW, "_auto_retry_attempts");
                    int i = iM14;
                    ArrayList arrayList = new ArrayList(cursorW.getCount());
                    while (cursorW.moveToNext()) {
                        e eVar = new e();
                        ArrayList arrayList2 = arrayList;
                        eVar.f14950u = cursorW.getInt(iM);
                        eVar.h(cursorW.getString(iM2));
                        eVar.j(cursorW.getString(iM3));
                        eVar.g(cursorW.getString(iM4));
                        eVar.f14954y = cursorW.getInt(iM5);
                        int i10 = cursorW.getInt(iM6);
                        yc.g.f14672v.getClass();
                        eVar.f14955z = va.e.f(i10);
                        eVar.A = ua.c.d(cursorW.getString(iM7));
                        int i11 = iM;
                        eVar.B = cursorW.getLong(iM8);
                        eVar.C = cursorW.getLong(iM9);
                        int i12 = cursorW.getInt(iM10);
                        k.f14687v.getClass();
                        eVar.D = w2.f.b(i12);
                        int i13 = cursorW.getInt(iM11);
                        yc.b.f14648v.getClass();
                        eVar.E = w2.f.a(i13);
                        int i14 = cursorW.getInt(iM12);
                        yc.f.f14666v.getClass();
                        eVar.F = v8.c.a(i14);
                        eVar.G = cursorW.getLong(iM13);
                        int i15 = i;
                        eVar.H = cursorW.isNull(i15) ? null : cursorW.getString(i15);
                        int i16 = iM15;
                        int i17 = cursorW.getInt(i16);
                        yc.a.f14640v.getClass();
                        i = i15;
                        eVar.I = va.e.e(i17);
                        int i18 = iM2;
                        int i19 = iM16;
                        int i20 = iM3;
                        eVar.J = cursorW.getLong(i19);
                        int i21 = iM17;
                        eVar.K = cursorW.getInt(i21) != 0;
                        int i22 = iM18;
                        eVar.L = ua.c.a(cursorW.getString(i22));
                        int i23 = iM19;
                        eVar.M = cursorW.getInt(i23);
                        iM19 = i23;
                        int i24 = iM20;
                        eVar.N = cursorW.getInt(i24);
                        arrayList2.add(eVar);
                        iM17 = i21;
                        iM2 = i18;
                        iM15 = i16;
                        iM18 = i22;
                        iM3 = i20;
                        iM16 = i19;
                        iM20 = i24;
                        arrayList = arrayList2;
                        iM = i11;
                    }
                    List list = arrayList;
                    cursorW.close();
                    vVar.x();
                    J(list, false);
                    return list;
                } catch (Throwable th) {
                    th = th;
                    cursorW.close();
                    vVar.x();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            vVar = vVarA;
        }
    }

    public final e x(String str) throws Throwable {
        v vVar;
        int iM;
        int iM2;
        int iM3;
        int iM4;
        int iM5;
        int iM6;
        int iM7;
        int iM8;
        int iM9;
        int iM10;
        int iM11;
        int iM12;
        int iM13;
        int iM14;
        be.h.e(str, "file");
        S();
        c cVarP = this.f14961z.p();
        Object obj = cVarP.f14947w;
        v vVarA = v.a("SELECT * FROM requests WHERE _file = ?", 1);
        vVarA.V(str, 1);
        t tVar = (t) cVarP.f14945u;
        tVar.b();
        Cursor cursorW = z7.a.w(tVar, vVarA);
        try {
            iM = t1.m(cursorW, "_id");
            iM2 = t1.m(cursorW, "_namespace");
            iM3 = t1.m(cursorW, "_url");
            iM4 = t1.m(cursorW, "_file");
            iM5 = t1.m(cursorW, "_group");
            iM6 = t1.m(cursorW, "_priority");
            iM7 = t1.m(cursorW, "_headers");
            iM8 = t1.m(cursorW, "_written_bytes");
            iM9 = t1.m(cursorW, "_total_bytes");
            iM10 = t1.m(cursorW, "_status");
            iM11 = t1.m(cursorW, "_error");
            iM12 = t1.m(cursorW, "_network_type");
            iM13 = t1.m(cursorW, "_created");
            vVar = vVarA;
            try {
                iM14 = t1.m(cursorW, "_tag");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            vVar = vVarA;
        }
        try {
            int iM15 = t1.m(cursorW, "_enqueue_action");
            int iM16 = t1.m(cursorW, "_identifier");
            int iM17 = t1.m(cursorW, "_download_on_enqueue");
            int iM18 = t1.m(cursorW, "_extras");
            int iM19 = t1.m(cursorW, "_auto_retry_max_attempts");
            int iM20 = t1.m(cursorW, "_auto_retry_attempts");
            e eVar = null;
            if (cursorW.moveToFirst()) {
                e eVar2 = new e();
                eVar2.f14950u = cursorW.getInt(iM);
                eVar2.h(cursorW.getString(iM2));
                eVar2.j(cursorW.getString(iM3));
                eVar2.g(cursorW.getString(iM4));
                eVar2.f14954y = cursorW.getInt(iM5);
                int i = cursorW.getInt(iM6);
                yc.g.f14672v.getClass();
                eVar2.f14955z = va.e.f(i);
                eVar2.A = ua.c.d(cursorW.getString(iM7));
                eVar2.B = cursorW.getLong(iM8);
                eVar2.C = cursorW.getLong(iM9);
                int i10 = cursorW.getInt(iM10);
                k.f14687v.getClass();
                eVar2.D = w2.f.b(i10);
                int i11 = cursorW.getInt(iM11);
                yc.b.f14648v.getClass();
                eVar2.E = w2.f.a(i11);
                int i12 = cursorW.getInt(iM12);
                yc.f.f14666v.getClass();
                eVar2.F = v8.c.a(i12);
                eVar2.G = cursorW.getLong(iM13);
                eVar2.H = cursorW.isNull(iM14) ? null : cursorW.getString(iM14);
                int i13 = cursorW.getInt(iM15);
                yc.a.f14640v.getClass();
                eVar2.I = va.e.e(i13);
                eVar2.J = cursorW.getLong(iM16);
                eVar2.K = cursorW.getInt(iM17) != 0;
                eVar2.L = ua.c.a(cursorW.getString(iM18));
                eVar2.M = cursorW.getInt(iM19);
                eVar2.N = cursorW.getInt(iM20);
                eVar = eVar2;
            }
            cursorW.close();
            vVar.x();
            if (eVar == null) {
                return eVar;
            }
            J(android.support.v4.media.session.b.G(eVar), false);
            return eVar;
        } catch (Throwable th3) {
            th = th3;
            cursorW.close();
            vVar.x();
            throw th;
        }
    }
}
