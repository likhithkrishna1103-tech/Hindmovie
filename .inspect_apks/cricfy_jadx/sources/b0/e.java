package b0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import w4.p;
import w4.r;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f1598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f1599e;
    public Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f1600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f1601h;

    public static final void a(e eVar, c5.a aVar) throws Exception {
        Object objE;
        androidx.emoji2.text.h hVar = (androidx.emoji2.text.h) eVar.f1598d;
        f(aVar);
        w4.a aVar2 = (w4.a) eVar.f1597c;
        r rVar = aVar2.f13907g;
        r rVar2 = r.f13988x;
        if (rVar == rVar2) {
            android.support.v4.media.session.b.k(aVar, "PRAGMA journal_mode = WAL");
        } else {
            android.support.v4.media.session.b.k(aVar, "PRAGMA journal_mode = TRUNCATE");
        }
        if (aVar2.f13907g == rVar2) {
            android.support.v4.media.session.b.k(aVar, "PRAGMA synchronous = NORMAL");
        } else {
            android.support.v4.media.session.b.k(aVar, "PRAGMA synchronous = FULL");
        }
        c5.c cVarC0 = aVar.c0("PRAGMA user_version");
        try {
            cVarC0.V();
            int i = (int) cVarC0.getLong(0);
            android.support.v4.media.session.b.d(cVarC0, null);
            int i10 = hVar.f856a;
            if (i != i10) {
                android.support.v4.media.session.b.k(aVar, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    if (i == 0) {
                        eVar.j(aVar);
                    } else {
                        eVar.k(aVar, i, i10);
                    }
                    android.support.v4.media.session.b.k(aVar, "PRAGMA user_version = " + i10);
                    objE = rd.l.f11003a;
                } catch (Throwable th) {
                    objE = com.bumptech.glide.c.e(th);
                }
                if (!(objE instanceof rd.g)) {
                    android.support.v4.media.session.b.k(aVar, "END TRANSACTION");
                }
                Throwable thA = rd.h.a(objE);
                if (thA != null) {
                    android.support.v4.media.session.b.k(aVar, "ROLLBACK TRANSACTION");
                    throw thA;
                }
            }
            eVar.l(aVar);
        } finally {
        }
    }

    public static void f(c5.a aVar) throws Exception {
        c5.c cVarC0 = aVar.c0("PRAGMA busy_timeout");
        try {
            cVarC0.V();
            long j4 = cVarC0.getLong(0);
            android.support.v4.media.session.b.d(cVarC0, null);
            if (j4 < 3000) {
                android.support.v4.media.session.b.k(aVar, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                android.support.v4.media.session.b.d(cVarC0, th);
                throw th2;
            }
        }
    }

    public void b(f fVar, int i, ArrayList arrayList, l lVar) {
        o oVar = fVar.f1605d;
        l lVar2 = oVar.f1626c;
        f fVar2 = oVar.i;
        f fVar3 = oVar.f1630h;
        if (lVar2 == null) {
            a0.e eVar = (a0.e) this.f1597c;
            if (oVar == eVar.f32d || oVar == eVar.f34e) {
                return;
            }
            if (lVar == null) {
                lVar = new l();
                lVar.f1615a = null;
                lVar.f1616b = new ArrayList();
                lVar.f1615a = oVar;
                arrayList.add(lVar);
            }
            oVar.f1626c = lVar;
            lVar.f1616b.add(oVar);
            ArrayList arrayList2 = fVar3.f1610k;
            int size = arrayList2.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                d dVar = (d) obj;
                if (dVar instanceof f) {
                    b((f) dVar, i, arrayList, lVar);
                }
            }
            ArrayList arrayList3 = fVar2.f1610k;
            int size2 = arrayList3.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj2 = arrayList3.get(i12);
                i12++;
                d dVar2 = (d) obj2;
                if (dVar2 instanceof f) {
                    b((f) dVar2, i, arrayList, lVar);
                }
            }
            if (i == 1 && (oVar instanceof m)) {
                ArrayList arrayList4 = ((m) oVar).f1617k.f1610k;
                int size3 = arrayList4.size();
                int i13 = 0;
                while (i13 < size3) {
                    Object obj3 = arrayList4.get(i13);
                    i13++;
                    d dVar3 = (d) obj3;
                    if (dVar3 instanceof f) {
                        b((f) dVar3, i, arrayList, lVar);
                    }
                }
            }
            ArrayList arrayList5 = fVar3.f1611l;
            int size4 = arrayList5.size();
            int i14 = 0;
            while (i14 < size4) {
                Object obj4 = arrayList5.get(i14);
                i14++;
                b((f) obj4, i, arrayList, lVar);
            }
            ArrayList arrayList6 = fVar2.f1611l;
            int size5 = arrayList6.size();
            int i15 = 0;
            while (i15 < size5) {
                Object obj5 = arrayList6.get(i15);
                i15++;
                b((f) obj5, i, arrayList, lVar);
            }
            if (i == 1 && (oVar instanceof m)) {
                ArrayList arrayList7 = ((m) oVar).f1617k.f1611l;
                int size6 = arrayList7.size();
                while (i10 < size6) {
                    Object obj6 = arrayList7.get(i10);
                    i10++;
                    b((f) obj6, i, arrayList, lVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c9, code lost:
    
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(a0.e r25) {
        /*
            Method dump skipped, instruction units count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.e.c(a0.e):void");
    }

    public void d() {
        a0.e eVar = (a0.e) this.f1597c;
        ArrayList arrayList = (ArrayList) this.f;
        ArrayList arrayList2 = (ArrayList) this.f1599e;
        arrayList2.clear();
        a0.e eVar2 = (a0.e) this.f1598d;
        eVar2.f32d.f();
        eVar2.f34e.f();
        arrayList2.add(eVar2.f32d);
        arrayList2.add(eVar2.f34e);
        ArrayList arrayList3 = eVar2.f65q0;
        int size = arrayList3.size();
        HashSet hashSet = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            a0.d dVar = (a0.d) obj;
            if (dVar instanceof a0.h) {
                i iVar = new i(dVar);
                dVar.f32d.f();
                dVar.f34e.f();
                iVar.f = ((a0.h) dVar).f105u0;
                arrayList2.add(iVar);
            } else {
                if (dVar.x()) {
                    if (dVar.f28b == null) {
                        dVar.f28b = new c(dVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f28b);
                } else {
                    arrayList2.add(dVar.f32d);
                }
                if (dVar.y()) {
                    if (dVar.f30c == null) {
                        dVar.f30c = new c(dVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f30c);
                } else {
                    arrayList2.add(dVar.f34e);
                }
                if (dVar instanceof a0.i) {
                    arrayList2.add(new j(dVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList2.addAll(hashSet);
        }
        int size2 = arrayList2.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList2.get(i10);
            i10++;
            ((o) obj2).f();
        }
        int size3 = arrayList2.size();
        int i11 = 0;
        while (i11 < size3) {
            Object obj3 = arrayList2.get(i11);
            i11++;
            o oVar = (o) obj3;
            if (oVar.f1625b != eVar2) {
                oVar.d();
            }
        }
        arrayList.clear();
        g(eVar.f32d, 0, arrayList);
        g(eVar.f34e, 1, arrayList);
        this.f1595a = false;
    }

    public int e(a0.e eVar, int i) {
        ArrayList arrayList;
        int i10;
        long jMax;
        float f;
        a0.e eVar2 = eVar;
        ArrayList arrayList2 = (ArrayList) this.f;
        int size = arrayList2.size();
        long j4 = 0;
        int i11 = 0;
        long jMax2 = 0;
        while (i11 < size) {
            o oVar = ((l) arrayList2.get(i11)).f1615a;
            if (!(oVar instanceof c) ? !(i != 0 ? (oVar instanceof m) : (oVar instanceof k)) : ((c) oVar).f != i) {
                f fVar = (i == 0 ? eVar2.f32d : eVar2.f34e).f1630h;
                f fVar2 = (i == 0 ? eVar2.f32d : eVar2.f34e).i;
                f fVar3 = oVar.f1630h;
                f fVar4 = oVar.i;
                boolean zContains = fVar3.f1611l.contains(fVar);
                boolean zContains2 = fVar4.f1611l.contains(fVar2);
                long j7 = oVar.j();
                if (zContains && zContains2) {
                    long jB = l.b(fVar3, j4);
                    long jA = l.a(fVar4, j4);
                    long j10 = jB - j7;
                    int i12 = fVar4.f;
                    arrayList = arrayList2;
                    i10 = size;
                    if (j10 >= (-i12)) {
                        j10 += (long) i12;
                    }
                    long j11 = fVar3.f;
                    long j12 = ((-jA) - j7) - j11;
                    if (j12 >= j11) {
                        j12 -= j11;
                    }
                    a0.d dVar = oVar.f1625b;
                    if (i == 0) {
                        f = dVar.f33d0;
                    } else if (i == 1) {
                        f = dVar.f35e0;
                    } else {
                        dVar.getClass();
                        f = -1.0f;
                    }
                    float f10 = f > 0.0f ? (long) ((j10 / (1.0f - f)) + (j12 / f)) : 0L;
                    jMax = (((long) fVar3.f) + ((((long) ((f10 * f) + 0.5f)) + j7) + ((long) q4.a.h(1.0f, f, f10, 0.5f)))) - ((long) fVar4.f);
                } else {
                    arrayList = arrayList2;
                    i10 = size;
                    jMax = zContains ? Math.max(l.b(fVar3, fVar3.f), ((long) fVar3.f) + j7) : zContains2 ? Math.max(-l.a(fVar4, fVar4.f), ((long) (-fVar4.f)) + j7) : (oVar.j() + ((long) fVar3.f)) - ((long) fVar4.f);
                }
            } else {
                arrayList = arrayList2;
                i10 = size;
                jMax = j4;
            }
            jMax2 = Math.max(jMax2, jMax);
            i11++;
            eVar2 = eVar;
            arrayList2 = arrayList;
            size = i10;
            j4 = 0;
        }
        return (int) jMax2;
    }

    public void g(o oVar, int i, ArrayList arrayList) {
        f fVar = oVar.f1630h;
        f fVar2 = oVar.i;
        ArrayList arrayList2 = fVar.f1610k;
        int size = arrayList2.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList2.get(i11);
            i11++;
            d dVar = (d) obj;
            if (dVar instanceof f) {
                b((f) dVar, i, arrayList, null);
            } else if (dVar instanceof o) {
                b(((o) dVar).f1630h, i, arrayList, null);
            }
        }
        ArrayList arrayList3 = fVar2.f1610k;
        int size2 = arrayList3.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList3.get(i12);
            i12++;
            d dVar2 = (d) obj2;
            if (dVar2 instanceof f) {
                b((f) dVar2, i, arrayList, null);
            } else if (dVar2 instanceof o) {
                b(((o) dVar2).i, i, arrayList, null);
            }
        }
        if (i == 1) {
            ArrayList arrayList4 = ((m) oVar).f1617k.f1610k;
            int size3 = arrayList4.size();
            while (i10 < size3) {
                Object obj3 = arrayList4.get(i10);
                i10++;
                d dVar3 = (d) obj3;
                if (dVar3 instanceof f) {
                    b((f) dVar3, i, arrayList, null);
                }
            }
        }
    }

    public void h(int i, int i10, int i11, int i12, a0.d dVar) {
        b bVar = (b) this.f1601h;
        bVar.f1585a = i;
        bVar.f1586b = i11;
        bVar.f1587c = i10;
        bVar.f1588d = i12;
        ((d0.f) this.f1600g).b(dVar, bVar);
        dVar.O(bVar.f1589e);
        dVar.L(bVar.f);
        dVar.E = bVar.f1591h;
        dVar.I(bVar.f1590g);
    }

    public void i() {
        a aVar;
        e eVar = this;
        ArrayList arrayList = ((a0.e) eVar.f1597c).f65q0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            int i10 = i + 1;
            a0.d dVar = (a0.d) arrayList.get(i);
            if (!dVar.f26a) {
                int[] iArr = dVar.f54p0;
                int i11 = iArr[0];
                int i12 = iArr[1];
                int i13 = dVar.f56r;
                int i14 = dVar.f57s;
                boolean z10 = i11 == 2 || (i11 == 3 && i13 == 1);
                boolean z11 = i12 == 2 || (i12 == 3 && i14 == 1);
                g gVar = dVar.f32d.f1628e;
                boolean z12 = gVar.f1609j;
                g gVar2 = dVar.f34e.f1628e;
                boolean z13 = gVar2.f1609j;
                boolean z14 = z10;
                if (z12 && z13) {
                    eVar.h(1, gVar.f1607g, 1, gVar2.f1607g, dVar);
                    dVar.f26a = true;
                } else if (z12 && z11) {
                    h(1, gVar.f1607g, 2, gVar2.f1607g, dVar);
                    if (i12 == 3) {
                        dVar.f34e.f1628e.f1612m = dVar.k();
                    } else {
                        dVar.f34e.f1628e.d(dVar.k());
                        dVar.f26a = true;
                    }
                } else if (z13 && z14) {
                    h(2, gVar.f1607g, 1, gVar2.f1607g, dVar);
                    if (i11 == 3) {
                        dVar.f32d.f1628e.f1612m = dVar.q();
                    } else {
                        dVar.f32d.f1628e.d(dVar.q());
                        dVar.f26a = true;
                    }
                }
                if (dVar.f26a && (aVar = dVar.f34e.f1618l) != null) {
                    aVar.d(dVar.f27a0);
                }
                eVar = this;
            }
            i = i10;
        }
    }

    public void j(c5.a aVar) throws Exception {
        androidx.emoji2.text.h hVar = (androidx.emoji2.text.h) this.f1598d;
        ge.i.e(aVar, "connection");
        c5.c cVarC0 = aVar.c0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (cVarC0.V()) {
                if (cVarC0.getLong(0) == 0) {
                    z10 = true;
                }
            }
            android.support.v4.media.session.b.d(cVarC0, null);
            hVar.a(aVar);
            if (!z10) {
                i8.a aVarV = hVar.v(aVar);
                if (!aVarV.f6352c) {
                    throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + aVarV.f6351b).toString());
                }
            }
            android.support.v4.media.session.b.k(aVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            android.support.v4.media.session.b.k(aVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + ((String) hVar.f857b) + "')");
            hVar.r(aVar);
            Iterator it = this.f1599e.iterator();
            while (it.hasNext()) {
                ((p) it.next()).getClass();
                if (aVar instanceof f5.a) {
                    ge.i.e(((f5.a) aVar).f3961v, "db");
                }
            }
        } finally {
        }
    }

    public void k(c5.a aVar, int i, int i10) throws Exception {
        androidx.emoji2.text.h hVar = (androidx.emoji2.text.h) this.f1598d;
        ge.i.e(aVar, "connection");
        w4.a aVar2 = (w4.a) this.f1597c;
        List<ed.a> listM = android.support.v4.media.session.b.m(aVar2.f13905d, i, i10);
        if (listM != null) {
            hVar.u(aVar);
            for (ed.a aVar3 : listM) {
                aVar3.getClass();
                if (!(aVar instanceof f5.a)) {
                    throw new rd.e("Migration functionality with a provided SQLiteDriver requires overriding the migrate(SQLiteConnection) function.");
                }
                aVar3.a(((f5.a) aVar).f3961v);
            }
            i8.a aVarV = hVar.v(aVar);
            if (!aVarV.f6352c) {
                throw new IllegalStateException(("Migration didn't properly handle: " + aVarV.f6351b).toString());
            }
            hVar.t(aVar);
            android.support.v4.media.session.b.k(aVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            android.support.v4.media.session.b.k(aVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + ((String) hVar.f857b) + "')");
            return;
        }
        if (android.support.v4.media.session.b.D(aVar2, i, i10)) {
            throw new IllegalStateException(("A migration from " + i + " to " + i10 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
        }
        if (aVar2.f13918s) {
            c5.c cVarC0 = aVar.c0("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                td.c cVarH = n5.a.h();
                while (cVarC0.V()) {
                    String strJ = cVarC0.j(0);
                    if (!ne.o.Z(strJ, "sqlite_", false) && !strJ.equals("android_metadata")) {
                        cVarH.add(new rd.f(strJ, Boolean.valueOf(ge.i.a(cVarC0.j(1), "view"))));
                    }
                }
                td.c cVarA = n5.a.a(cVarH);
                android.support.v4.media.session.b.d(cVarC0, null);
                ListIterator listIterator = cVarA.listIterator(0);
                while (true) {
                    td.a aVar4 = (td.a) listIterator;
                    if (!aVar4.hasNext()) {
                        break;
                    }
                    rd.f fVar = (rd.f) aVar4.next();
                    String str = (String) fVar.f10993v;
                    if (((Boolean) fVar.f10994w).booleanValue()) {
                        android.support.v4.media.session.b.k(aVar, "DROP VIEW IF EXISTS `" + str + '`');
                    } else {
                        android.support.v4.media.session.b.k(aVar, "DROP TABLE IF EXISTS `" + str + '`');
                    }
                }
            } finally {
            }
        } else {
            hVar.c(aVar);
        }
        Iterator it = this.f1599e.iterator();
        while (it.hasNext()) {
            ((p) it.next()).getClass();
            if (aVar instanceof f5.a) {
                ge.i.e(((f5.a) aVar).f3961v, "db");
            }
        }
        hVar.a(aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(c5.a r11) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.e.l(c5.a):void");
    }
}
