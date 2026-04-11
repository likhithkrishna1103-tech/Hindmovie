package r4;

import android.content.Context;
import android.content.Intent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import n.a1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f11470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.emoji2.text.h f11471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f11472e;
    public final t4.b f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z4.a f11473g;

    public p(a aVar, androidx.emoji2.text.h hVar) {
        int i;
        t4.e eVar;
        r rVar = aVar.f11409g;
        pa.b bVar = aVar.f11406c;
        String str = aVar.f11405b;
        this.f11470c = aVar;
        this.f11471d = hVar;
        List list = aVar.f11408e;
        this.f11472e = list == null ? od.q.f9570u : list;
        y4.b bVar2 = aVar.f11421t;
        if (bVar2 != null) {
            if (str == null) {
                eVar = new t4.e(new p2.c(this, bVar2));
            } else {
                p2.c cVar = new p2.c(this, bVar2);
                int iOrdinal = rVar.ordinal();
                if (iOrdinal == 1) {
                    i = 1;
                } else {
                    if (iOrdinal != 2) {
                        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + rVar + '\'').toString());
                    }
                    i = 4;
                }
                int iOrdinal2 = rVar.ordinal();
                if (iOrdinal2 != 1 && iOrdinal2 != 2) {
                    throw new IllegalStateException(("Can't get max number of writers for journal mode '" + rVar + '\'').toString());
                }
                eVar = new t4.e(cVar, str, i);
            }
            this.f = eVar;
        } else {
            if (bVar == null) {
                throw new IllegalArgumentException("SQLiteManager was constructed with both null driver and open helper factory!");
            }
            Context context = aVar.f11404a;
            be.h.e(context, "context");
            this.f = new u4.b(new o4.c((z4.b) new a5.j(context, str, new n(this, hVar.f1174a))));
        }
        boolean z2 = rVar == r.f11490w;
        z4.b bVarC = c();
        if (bVarC != null) {
            bVarC.setWriteAheadLoggingEnabled(z2);
        }
    }

    public static final void a(p pVar, y4.a aVar) throws Exception {
        Object objH;
        androidx.emoji2.text.h hVar = pVar.f11471d;
        a aVar2 = pVar.f11470c;
        r rVar = aVar2.f11409g;
        r rVar2 = r.f11490w;
        if (rVar == rVar2) {
            android.support.v4.media.session.b.o(aVar, "PRAGMA journal_mode = WAL");
        } else {
            android.support.v4.media.session.b.o(aVar, "PRAGMA journal_mode = TRUNCATE");
        }
        if (aVar2.f11409g == rVar2) {
            android.support.v4.media.session.b.o(aVar, "PRAGMA synchronous = NORMAL");
        } else {
            android.support.v4.media.session.b.o(aVar, "PRAGMA synchronous = FULL");
        }
        b(aVar);
        y4.c cVarE0 = aVar.e0("PRAGMA user_version");
        try {
            cVarE0.W();
            int i = (int) cVarE0.getLong(0);
            cf.d.g(cVarE0, null);
            int i10 = hVar.f1174a;
            if (i != i10) {
                android.support.v4.media.session.b.o(aVar, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    if (i == 0) {
                        pVar.d(aVar);
                    } else {
                        pVar.e(aVar, i, i10);
                    }
                    android.support.v4.media.session.b.o(aVar, "PRAGMA user_version = " + i10);
                    objH = nd.k.f8990a;
                } catch (Throwable th) {
                    objH = i5.a.h(th);
                }
                if (!(objH instanceof nd.g)) {
                    android.support.v4.media.session.b.o(aVar, "END TRANSACTION");
                }
                Throwable thA = nd.h.a(objH);
                if (thA != null) {
                    android.support.v4.media.session.b.o(aVar, "ROLLBACK TRANSACTION");
                    throw thA;
                }
            }
            pVar.f(aVar);
        } finally {
        }
    }

    public static void b(y4.a aVar) throws Exception {
        y4.c cVarE0 = aVar.e0("PRAGMA busy_timeout");
        try {
            cVarE0.W();
            long j5 = cVarE0.getLong(0);
            cf.d.g(cVarE0, null);
            if (j5 < 3000) {
                android.support.v4.media.session.b.o(aVar, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                cf.d.g(cVarE0, th);
                throw th2;
            }
        }
    }

    public final z4.b c() {
        o4.c cVar;
        t4.b bVar = this.f;
        u4.b bVar2 = bVar instanceof u4.b ? (u4.b) bVar : null;
        if (bVar2 == null || (cVar = bVar2.f12763u) == null) {
            return null;
        }
        return (z4.b) cVar.f9349u;
    }

    public final void d(y4.a aVar) throws Exception {
        be.h.e(aVar, "connection");
        y4.c cVarE0 = aVar.e0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z2 = false;
            if (cVarE0.W()) {
                if (cVarE0.getLong(0) == 0) {
                    z2 = true;
                }
            }
            cf.d.g(cVarE0, null);
            androidx.emoji2.text.h hVar = this.f11471d;
            hVar.a(aVar);
            if (!z2) {
                n7.a aVarV = hVar.v(aVar);
                if (!aVarV.f8824b) {
                    throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + aVarV.f8825c).toString());
                }
            }
            android.support.v4.media.session.b.o(aVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            android.support.v4.media.session.b.o(aVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + ((String) hVar.f1175b) + "')");
            hVar.r(aVar);
            Iterator it = this.f11472e.iterator();
            while (it.hasNext()) {
                ((o) it.next()).getClass();
                if (aVar instanceof u4.a) {
                    be.h.e(((u4.a) aVar).f12762u, "db");
                }
            }
        } finally {
        }
    }

    public final void e(y4.a aVar, int i, int i10) throws Exception {
        be.h.e(aVar, "connection");
        a aVar2 = this.f11470c;
        List<ad.a> listH = a.a.h(aVar2.f11407d, i, i10);
        androidx.emoji2.text.h hVar = this.f11471d;
        if (listH != null) {
            hVar.u(aVar);
            for (ad.a aVar3 : listH) {
                aVar3.getClass();
                if (!(aVar instanceof u4.a)) {
                    throw new nd.e("Migration functionality with a provided SQLiteDriver requires overriding the migrate(SQLiteConnection) function.");
                }
                aVar3.a(((u4.a) aVar).f12762u);
            }
            n7.a aVarV = hVar.v(aVar);
            if (!aVarV.f8824b) {
                throw new IllegalStateException(("Migration didn't properly handle: " + aVarV.f8825c).toString());
            }
            hVar.t(aVar);
            android.support.v4.media.session.b.o(aVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            android.support.v4.media.session.b.o(aVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + ((String) hVar.f1175b) + "')");
            return;
        }
        if (a.a.z(aVar2, i, i10)) {
            throw new IllegalStateException(("A migration from " + i + " to " + i10 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
        }
        if (aVar2.f11420s) {
            y4.c cVarE0 = aVar.e0("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                pd.c cVarN = android.support.v4.media.session.b.n();
                while (cVarE0.W()) {
                    String strJ = cVarE0.j(0);
                    if (!ie.n.M(strJ, "sqlite_", false) && !strJ.equals("android_metadata")) {
                        cVarN.add(new nd.f(strJ, Boolean.valueOf(be.h.a(cVarE0.j(1), "view"))));
                    }
                }
                pd.c cVarC = android.support.v4.media.session.b.c(cVarN);
                cf.d.g(cVarE0, null);
                ListIterator listIterator = cVarC.listIterator(0);
                while (true) {
                    pd.a aVar4 = (pd.a) listIterator;
                    if (!aVar4.hasNext()) {
                        break;
                    }
                    nd.f fVar = (nd.f) aVar4.next();
                    String str = (String) fVar.f8983u;
                    if (((Boolean) fVar.f8984v).booleanValue()) {
                        android.support.v4.media.session.b.o(aVar, "DROP VIEW IF EXISTS " + str);
                    } else {
                        android.support.v4.media.session.b.o(aVar, "DROP TABLE IF EXISTS " + str);
                    }
                }
            } finally {
            }
        } else {
            hVar.c(aVar);
        }
        Iterator it = this.f11472e.iterator();
        while (it.hasNext()) {
            ((o) it.next()).getClass();
            if (aVar instanceof u4.a) {
                be.h.e(((u4.a) aVar).f12762u, "db");
            }
        }
        hVar.a(aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(y4.a r10) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.p.f(y4.a):void");
    }

    public p(a aVar, he.i iVar) {
        r rVar = aVar.f11409g;
        this.f11470c = aVar;
        this.f11471d = new m(-1, "", "");
        List list = aVar.f11408e;
        od.q qVar = od.q.f9570u;
        this.f11472e = list == null ? qVar : list;
        ArrayList arrayListD0 = od.i.d0(list == null ? qVar : list, new o(new he.i(2, this)));
        Context context = aVar.f11404a;
        String str = aVar.f11405b;
        pa.b bVar = aVar.f11406c;
        a1 a1Var = aVar.f11407d;
        boolean z2 = aVar.f;
        Executor executor = aVar.f11410h;
        Executor executor2 = aVar.i;
        Intent intent = aVar.f11411j;
        boolean z10 = aVar.f11412k;
        boolean z11 = aVar.f11413l;
        Set set = aVar.f11414m;
        String str2 = aVar.f11415n;
        File file = aVar.f11416o;
        Callable callable = aVar.f11417p;
        List list2 = aVar.f11418q;
        List list3 = aVar.f11419r;
        boolean z12 = aVar.f11420s;
        y4.b bVar2 = aVar.f11421t;
        rd.h hVar = aVar.f11422u;
        be.h.e(context, "context");
        be.h.e(a1Var, "migrationContainer");
        be.h.e(executor, "queryExecutor");
        be.h.e(executor2, "transactionExecutor");
        be.h.e(list2, "typeConverters");
        be.h.e(list3, "autoMigrationSpecs");
        this.f = new u4.b(new o4.c((z4.b) iVar.a(new a(context, str, bVar, a1Var, arrayListD0, z2, rVar, executor, executor2, intent, z10, z11, set, str2, file, callable, list2, list3, z12, bVar2, hVar))));
        boolean z13 = rVar == r.f11490w;
        z4.b bVarC = c();
        if (bVarC != null) {
            bVarC.setWriteAheadLoggingEnabled(z13);
        }
    }
}
