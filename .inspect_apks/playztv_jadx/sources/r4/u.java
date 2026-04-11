package r4;

import android.database.Cursor;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import n.a1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u extends t1.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f11500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f11501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a1 f11502e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(a aVar, a1 a1Var) {
        super(7, 1);
        be.h.e(aVar, "configuration");
        this.f11501d = aVar.f11408e;
        this.f11500c = aVar;
        this.f11502e = a1Var;
    }

    @Override // t1.e
    public final void i(a5.d dVar) throws Exception {
        Cursor cursorA0 = dVar.a0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z2 = false;
            if (cursorA0.moveToFirst()) {
                if (cursorA0.getInt(0) == 0) {
                    z2 = true;
                }
            }
            cursorA0.close();
            dVar.n("CREATE TABLE IF NOT EXISTS `requests` (`_id` INTEGER NOT NULL, `_namespace` TEXT NOT NULL, `_url` TEXT NOT NULL, `_file` TEXT NOT NULL, `_group` INTEGER NOT NULL, `_priority` INTEGER NOT NULL, `_headers` TEXT NOT NULL, `_written_bytes` INTEGER NOT NULL, `_total_bytes` INTEGER NOT NULL, `_status` INTEGER NOT NULL, `_error` INTEGER NOT NULL, `_network_type` INTEGER NOT NULL, `_created` INTEGER NOT NULL, `_tag` TEXT, `_enqueue_action` INTEGER NOT NULL, `_identifier` INTEGER NOT NULL, `_download_on_enqueue` INTEGER NOT NULL, `_extras` TEXT NOT NULL, `_auto_retry_max_attempts` INTEGER NOT NULL, `_auto_retry_attempts` INTEGER NOT NULL, PRIMARY KEY(`_id`))");
            dVar.n("CREATE UNIQUE INDEX IF NOT EXISTS `index_requests__file` ON `requests` (`_file`)");
            dVar.n("CREATE INDEX IF NOT EXISTS `index_requests__group__status` ON `requests` (`_group`, `_status`)");
            dVar.n("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            dVar.n("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '460643a974555d792b8f5a6e1a5d323c')");
            if (!z2) {
                n7.a aVarA = a1.A(dVar);
                if (!aVarA.f8824b) {
                    throw new IllegalStateException("Pre-packaged database has an invalid schema: " + aVarA.f8825c);
                }
            }
            dVar.n("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            dVar.n("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '460643a974555d792b8f5a6e1a5d323c')");
            List list = this.f11501d;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((o) it.next()).getClass();
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                i5.a.e(cursorA0, th);
                throw th2;
            }
        }
    }

    @Override // t1.e
    public final void j(a5.d dVar, int i, int i10) throws Exception {
        l(dVar, i, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    @Override // t1.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(a5.d r5) throws java.lang.Exception {
        /*
            r4 = this;
            java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
            android.database.Cursor r0 = r5.a0(r0)
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L15
            r2 = 0
            if (r1 == 0) goto L18
            int r1 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L18
            r1 = 1
            goto L19
        L15:
            r5 = move-exception
            goto Lb6
        L18:
            r1 = r2
        L19:
            r0.close()
            r0 = 0
            if (r1 == 0) goto L5e
            androidx.emoji2.text.r r1 = new androidx.emoji2.text.r
            java.lang.String r3 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r1.<init>(r3)
            android.database.Cursor r1 = r5.p(r1)
            boolean r3 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L37
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L35
            goto L38
        L35:
            r5 = move-exception
            goto L58
        L37:
            r2 = r0
        L38:
            r1.close()
            java.lang.String r1 = "460643a974555d792b8f5a6e1a5d323c"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L70
            java.lang.String r1 = "946eca6b182e63ebe50cf82e483715bf"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L4c
            goto L70
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: 460643a974555d792b8f5a6e1a5d323c, found: "
            java.lang.String r0 = l4.a.m(r0, r2)
            r5.<init>(r0)
            throw r5
        L58:
            throw r5     // Catch: java.lang.Throwable -> L59
        L59:
            r0 = move-exception
            i5.a.e(r1, r5)
            throw r0
        L5e:
            n7.a r1 = n.a1.A(r5)
            boolean r2 = r1.f8824b
            if (r2 == 0) goto La0
            java.lang.String r1 = "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)"
            r5.n(r1)
            java.lang.String r1 = "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '460643a974555d792b8f5a6e1a5d323c')"
            r5.n(r1)
        L70:
            n.a1 r1 = r4.f11502e
            java.lang.Object r1 = r1.f8343u
            com.tonyodev.fetch2.database.DownloadDatabase_Impl r1 = (com.tonyodev.fetch2.database.DownloadDatabase_Impl) r1
            u4.a r2 = new u4.a
            r2.<init>(r5)
            r1.n(r2)
            java.util.List r1 = r4.f11501d
            if (r1 == 0) goto L9d
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L88:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L9d
            java.lang.Object r2 = r1.next()
            r4.o r2 = (r4.o) r2
            r2.getClass()
            he.i r2 = r2.f11467a
            r2.a(r5)
            goto L88
        L9d:
            r4.f11500c = r0
            return
        La0:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Pre-packaged database has an invalid schema: "
            r0.<init>(r2)
            java.lang.String r1 = r1.f8825c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        Lb6:
            throw r5     // Catch: java.lang.Throwable -> Lb7
        Lb7:
            r1 = move-exception
            i5.a.e(r0, r5)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.u.k(a5.d):void");
    }

    @Override // t1.e
    public final void l(a5.d dVar, int i, int i10) throws Exception {
        a aVar = this.f11500c;
        if (aVar != null) {
            a1 a1Var = aVar.f11407d;
            a1Var.getClass();
            List<ad.a> listH = a.a.h(a1Var, i, i10);
            if (listH != null) {
                z7.a.j(new u4.a(dVar));
                for (ad.a aVar2 : listH) {
                    aVar2.getClass();
                    aVar2.a(dVar);
                }
                n7.a aVarA = a1.A(dVar);
                if (!aVarA.f8824b) {
                    throw new IllegalStateException("Migration didn't properly handle: " + aVarA.f8825c);
                }
                dVar.n("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                dVar.n("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '460643a974555d792b8f5a6e1a5d323c')");
                return;
            }
        }
        a aVar3 = this.f11500c;
        if (aVar3 == null || a.a.z(aVar3, i, i10)) {
            throw new IllegalStateException("A migration from " + i + " to " + i10 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        if (aVar3.f11420s) {
            Cursor cursorA0 = dVar.a0("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                pd.c cVarN = android.support.v4.media.session.b.n();
                while (cursorA0.moveToNext()) {
                    String string = cursorA0.getString(0);
                    be.h.b(string);
                    if (!ie.n.M(string, "sqlite_", false) && !string.equals("android_metadata")) {
                        cVarN.add(new nd.f(string, Boolean.valueOf(be.h.a(cursorA0.getString(1), "view"))));
                    }
                }
                pd.c cVarC = android.support.v4.media.session.b.c(cVarN);
                cursorA0.close();
                ListIterator listIterator = cVarC.listIterator(0);
                while (true) {
                    pd.a aVar4 = (pd.a) listIterator;
                    if (!aVar4.hasNext()) {
                        break;
                    }
                    nd.f fVar = (nd.f) aVar4.next();
                    String str = (String) fVar.f8983u;
                    if (((Boolean) fVar.f8984v).booleanValue()) {
                        dVar.n("DROP VIEW IF EXISTS " + str);
                    } else {
                        dVar.n("DROP TABLE IF EXISTS " + str);
                    }
                }
            } finally {
            }
        } else {
            dVar.n("DROP TABLE IF EXISTS `requests`");
        }
        List list = this.f11501d;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((o) it.next()).getClass();
            }
        }
        dVar.n("CREATE TABLE IF NOT EXISTS `requests` (`_id` INTEGER NOT NULL, `_namespace` TEXT NOT NULL, `_url` TEXT NOT NULL, `_file` TEXT NOT NULL, `_group` INTEGER NOT NULL, `_priority` INTEGER NOT NULL, `_headers` TEXT NOT NULL, `_written_bytes` INTEGER NOT NULL, `_total_bytes` INTEGER NOT NULL, `_status` INTEGER NOT NULL, `_error` INTEGER NOT NULL, `_network_type` INTEGER NOT NULL, `_created` INTEGER NOT NULL, `_tag` TEXT, `_enqueue_action` INTEGER NOT NULL, `_identifier` INTEGER NOT NULL, `_download_on_enqueue` INTEGER NOT NULL, `_extras` TEXT NOT NULL, `_auto_retry_max_attempts` INTEGER NOT NULL, `_auto_retry_attempts` INTEGER NOT NULL, PRIMARY KEY(`_id`))");
        dVar.n("CREATE UNIQUE INDEX IF NOT EXISTS `index_requests__file` ON `requests` (`_file`)");
        dVar.n("CREATE INDEX IF NOT EXISTS `index_requests__group__status` ON `requests` (`_group`, `_status`)");
        dVar.n("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        dVar.n("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '460643a974555d792b8f5a6e1a5d323c')");
    }

    @Override // t1.e
    public final void h(a5.d dVar) {
    }
}
