package w4;

import android.database.Cursor;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends d5.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f14007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f14008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final pc.c f14009e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(a aVar, pc.c cVar) {
        super(7, 0);
        ge.i.e(aVar, "configuration");
        this.f14008d = aVar.f13906e;
        this.f14007c = aVar;
        this.f14009e = cVar;
    }

    @Override // d5.c
    public final void i(e5.c cVar) throws IOException {
        Cursor cursorZ = cVar.Z("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (cursorZ.moveToFirst()) {
                if (cursorZ.getInt(0) == 0) {
                    z10 = true;
                }
            }
            cursorZ.close();
            cVar.m("CREATE TABLE IF NOT EXISTS `requests` (`_id` INTEGER NOT NULL, `_namespace` TEXT NOT NULL, `_url` TEXT NOT NULL, `_file` TEXT NOT NULL, `_group` INTEGER NOT NULL, `_priority` INTEGER NOT NULL, `_headers` TEXT NOT NULL, `_written_bytes` INTEGER NOT NULL, `_total_bytes` INTEGER NOT NULL, `_status` INTEGER NOT NULL, `_error` INTEGER NOT NULL, `_network_type` INTEGER NOT NULL, `_created` INTEGER NOT NULL, `_tag` TEXT, `_enqueue_action` INTEGER NOT NULL, `_identifier` INTEGER NOT NULL, `_download_on_enqueue` INTEGER NOT NULL, `_extras` TEXT NOT NULL, `_auto_retry_max_attempts` INTEGER NOT NULL, `_auto_retry_attempts` INTEGER NOT NULL, PRIMARY KEY(`_id`))");
            cVar.m("CREATE UNIQUE INDEX IF NOT EXISTS `index_requests__file` ON `requests` (`_file`)");
            cVar.m("CREATE INDEX IF NOT EXISTS `index_requests__group__status` ON `requests` (`_group`, `_status`)");
            cVar.m("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            cVar.m("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '460643a974555d792b8f5a6e1a5d323c')");
            if (!z10) {
                i8.a aVarJ = pc.c.J(cVar);
                if (!aVarJ.f6352c) {
                    throw new IllegalStateException("Pre-packaged database has an invalid schema: " + aVarJ.f6351b);
                }
            }
            cVar.m("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            cVar.m("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '460643a974555d792b8f5a6e1a5d323c')");
            List list = this.f14008d;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((p) it.next()).getClass();
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                com.bumptech.glide.e.b(cursorZ, th);
                throw th2;
            }
        }
    }

    @Override // d5.c
    public final void j(e5.c cVar, int i, int i10) throws Exception {
        l(cVar, i, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    @Override // d5.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(e5.c r6) throws java.lang.Exception {
        /*
            r5 = this;
            java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
            android.database.Cursor r0 = r6.Z(r0)
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L15
            r2 = 0
            if (r1 == 0) goto L18
            int r1 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L18
            r1 = 1
            goto L19
        L15:
            r6 = move-exception
            goto Lb5
        L18:
            r1 = r2
        L19:
            r0.close()
            r0 = 0
            if (r1 == 0) goto L5f
            d5.a r1 = new d5.a
            java.lang.String r3 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r4 = 0
            r1.<init>(r4, r3)
            android.database.Cursor r1 = r6.f0(r1)
            boolean r3 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L36
            if (r3 == 0) goto L38
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L36
            goto L39
        L36:
            r6 = move-exception
            goto L59
        L38:
            r2 = r0
        L39:
            r1.close()
            java.lang.String r1 = "460643a974555d792b8f5a6e1a5d323c"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L71
            java.lang.String r1 = "946eca6b182e63ebe50cf82e483715bf"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L4d
            goto L71
        L4d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: 460643a974555d792b8f5a6e1a5d323c, found: "
            java.lang.String r0 = q4.a.n(r0, r2)
            r6.<init>(r0)
            throw r6
        L59:
            throw r6     // Catch: java.lang.Throwable -> L5a
        L5a:
            r0 = move-exception
            com.bumptech.glide.e.b(r1, r6)
            throw r0
        L5f:
            i8.a r1 = pc.c.J(r6)
            boolean r2 = r1.f6352c
            if (r2 == 0) goto L9f
            java.lang.String r1 = "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)"
            r6.m(r1)
            java.lang.String r1 = "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '460643a974555d792b8f5a6e1a5d323c')"
            r6.m(r1)
        L71:
            pc.c r1 = r5.f14009e
            java.lang.Object r1 = r1.f10180v
            com.tonyodev.fetch2.database.DownloadDatabase_Impl r1 = (com.tonyodev.fetch2.database.DownloadDatabase_Impl) r1
            f5.a r2 = new f5.a
            r2.<init>(r6)
            r1.o(r2)
            java.util.List r1 = r5.f14008d
            if (r1 == 0) goto L9c
            java.util.Iterator r1 = r1.iterator()
        L87:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L9c
            java.lang.Object r2 = r1.next()
            w4.p r2 = (w4.p) r2
            r2.getClass()
            df.l r2 = r2.f13971a
            r2.a(r6)
            goto L87
        L9c:
            r5.f14007c = r0
            return
        L9f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Pre-packaged database has an invalid schema: "
            r0.<init>(r2)
            java.lang.String r1 = r1.f6351b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        Lb5:
            throw r6     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            r1 = move-exception
            com.bumptech.glide.e.b(r0, r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.x.k(e5.c):void");
    }

    @Override // d5.c
    public final void l(e5.c cVar, int i, int i10) throws Exception {
        a aVar = this.f14007c;
        if (aVar != null) {
            w.b bVar = aVar.f13905d;
            bVar.getClass();
            List<ed.a> listM = android.support.v4.media.session.b.m(bVar, i, i10);
            if (listM != null) {
                ab.b.h(new f5.a(cVar));
                for (ed.a aVar2 : listM) {
                    aVar2.getClass();
                    aVar2.a(cVar);
                }
                i8.a aVarJ = pc.c.J(cVar);
                if (!aVarJ.f6352c) {
                    throw new IllegalStateException("Migration didn't properly handle: " + aVarJ.f6351b);
                }
                cVar.m("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                cVar.m("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '460643a974555d792b8f5a6e1a5d323c')");
                return;
            }
        }
        a aVar3 = this.f14007c;
        if (aVar3 == null || android.support.v4.media.session.b.D(aVar3, i, i10)) {
            throw new IllegalStateException("A migration from " + i + " to " + i10 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        if (aVar3.f13918s) {
            Cursor cursorZ = cVar.Z("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                td.c cVarH = n5.a.h();
                while (cursorZ.moveToNext()) {
                    String string = cursorZ.getString(0);
                    ge.i.b(string);
                    if (!ne.o.Z(string, "sqlite_", false) && !string.equals("android_metadata")) {
                        cVarH.add(new rd.f(string, Boolean.valueOf(ge.i.a(cursorZ.getString(1), "view"))));
                    }
                }
                td.c cVarA = n5.a.a(cVarH);
                cursorZ.close();
                ListIterator listIterator = cVarA.listIterator(0);
                while (true) {
                    td.a aVar4 = (td.a) listIterator;
                    if (!aVar4.hasNext()) {
                        break;
                    }
                    rd.f fVar = (rd.f) aVar4.next();
                    String str = (String) fVar.f10993v;
                    if (((Boolean) fVar.f10994w).booleanValue()) {
                        cVar.m("DROP VIEW IF EXISTS " + str);
                    } else {
                        cVar.m("DROP TABLE IF EXISTS " + str);
                    }
                }
            } finally {
            }
        } else {
            cVar.m("DROP TABLE IF EXISTS `requests`");
        }
        List list = this.f14008d;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((p) it.next()).getClass();
            }
        }
        cVar.m("CREATE TABLE IF NOT EXISTS `requests` (`_id` INTEGER NOT NULL, `_namespace` TEXT NOT NULL, `_url` TEXT NOT NULL, `_file` TEXT NOT NULL, `_group` INTEGER NOT NULL, `_priority` INTEGER NOT NULL, `_headers` TEXT NOT NULL, `_written_bytes` INTEGER NOT NULL, `_total_bytes` INTEGER NOT NULL, `_status` INTEGER NOT NULL, `_error` INTEGER NOT NULL, `_network_type` INTEGER NOT NULL, `_created` INTEGER NOT NULL, `_tag` TEXT, `_enqueue_action` INTEGER NOT NULL, `_identifier` INTEGER NOT NULL, `_download_on_enqueue` INTEGER NOT NULL, `_extras` TEXT NOT NULL, `_auto_retry_max_attempts` INTEGER NOT NULL, `_auto_retry_attempts` INTEGER NOT NULL, PRIMARY KEY(`_id`))");
        cVar.m("CREATE UNIQUE INDEX IF NOT EXISTS `index_requests__file` ON `requests` (`_file`)");
        cVar.m("CREATE INDEX IF NOT EXISTS `index_requests__group__status` ON `requests` (`_group`, `_status`)");
        cVar.m("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        cVar.m("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '460643a974555d792b8f5a6e1a5d323c')");
    }

    @Override // d5.c
    public final void h(e5.c cVar) {
    }
}
