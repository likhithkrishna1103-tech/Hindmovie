package c6;

import a5.g;
import a5.j;
import android.support.v4.media.session.b;
import androidx.emoji2.text.h;
import app.cricfy.tv.room.db.AppDatabase_Impl;
import com.bumptech.glide.e;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppDatabase_Impl f2099d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AppDatabase_Impl appDatabase_Impl) {
        super(5, "bcbc6ffc6df09a9b7fc547d1e7f8a8d5", "d5b366757883717c8d7d8f8646bd19e2");
        this.f2099d = appDatabase_Impl;
    }

    @Override // androidx.emoji2.text.h
    public final void a(c5.a aVar) throws Exception {
        b.k(aVar, "CREATE TABLE IF NOT EXISTS `fav_channels` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `image` TEXT, `link` TEXT, `playlist` TEXT)");
        b.k(aVar, "CREATE TABLE IF NOT EXISTS `ns_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `url` TEXT, `ref` TEXT, `origin` TEXT, `ua` TEXT, `license` TEXT, `drmType` INTEGER NOT NULL, `advanceOptions` INTEGER NOT NULL)");
        b.k(aVar, "CREATE TABLE IF NOT EXISTS `notifications` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `body` TEXT, `image` TEXT, `url` TEXT, `opened` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL)");
        b.k(aVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        b.k(aVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'bcbc6ffc6df09a9b7fc547d1e7f8a8d5')");
    }

    @Override // androidx.emoji2.text.h
    public final void c(c5.a aVar) throws Exception {
        b.k(aVar, "DROP TABLE IF EXISTS `fav_channels`");
        b.k(aVar, "DROP TABLE IF EXISTS `ns_data`");
        b.k(aVar, "DROP TABLE IF EXISTS `notifications`");
    }

    @Override // androidx.emoji2.text.h
    public final void s(c5.a aVar) throws Exception {
        this.f2099d.o(aVar);
    }

    @Override // androidx.emoji2.text.h
    public final void u(c5.a aVar) throws Exception {
        ab.b.h(aVar);
    }

    @Override // androidx.emoji2.text.h
    public final i8.a v(c5.a aVar) {
        HashMap map = new HashMap(5);
        map.put("id", new g(1, 1, "id", "INTEGER", null, true));
        map.put("name", new g(0, 1, "name", "TEXT", null, false));
        map.put("image", new g(0, 1, "image", "TEXT", null, false));
        map.put("link", new g(0, 1, "link", "TEXT", null, false));
        map.put("playlist", new g(0, 1, "playlist", "TEXT", null, false));
        j jVar = new j("fav_channels", map, new HashSet(0), new HashSet(0));
        j jVarM = e.m(aVar, "fav_channels");
        if (!jVar.equals(jVarM)) {
            return new i8.a(false, "fav_channels(app.cricfy.tv.room.FavChannelEntity).\n Expected:\n" + jVar + "\n Found:\n" + jVarM, 2);
        }
        HashMap map2 = new HashMap(8);
        map2.put("id", new g(1, 1, "id", "INTEGER", null, true));
        map2.put("url", new g(0, 1, "url", "TEXT", null, false));
        map2.put("ref", new g(0, 1, "ref", "TEXT", null, false));
        map2.put("origin", new g(0, 1, "origin", "TEXT", null, false));
        map2.put("ua", new g(0, 1, "ua", "TEXT", null, false));
        map2.put("license", new g(0, 1, "license", "TEXT", null, false));
        map2.put("drmType", new g(0, 1, "drmType", "INTEGER", null, true));
        map2.put("advanceOptions", new g(0, 1, "advanceOptions", "INTEGER", null, true));
        j jVar2 = new j("ns_data", map2, new HashSet(0), new HashSet(0));
        j jVarM2 = e.m(aVar, "ns_data");
        if (!jVar2.equals(jVarM2)) {
            return new i8.a(false, "ns_data(app.cricfy.tv.room.NsEntity).\n Expected:\n" + jVar2 + "\n Found:\n" + jVarM2, 2);
        }
        HashMap map3 = new HashMap(7);
        map3.put("id", new g(1, 1, "id", "INTEGER", null, true));
        map3.put("title", new g(0, 1, "title", "TEXT", null, false));
        map3.put("body", new g(0, 1, "body", "TEXT", null, false));
        map3.put("image", new g(0, 1, "image", "TEXT", null, false));
        map3.put("url", new g(0, 1, "url", "TEXT", null, false));
        map3.put("opened", new g(0, 1, "opened", "INTEGER", null, true));
        map3.put("timestamp", new g(0, 1, "timestamp", "INTEGER", null, true));
        j jVar3 = new j("notifications", map3, new HashSet(0), new HashSet(0));
        j jVarM3 = e.m(aVar, "notifications");
        if (jVar3.equals(jVarM3)) {
            return new i8.a(true, (String) null, 2);
        }
        return new i8.a(false, "notifications(app.cricfy.tv.room.NotificationEntity).\n Expected:\n" + jVar3 + "\n Found:\n" + jVarM3, 2);
    }

    @Override // androidx.emoji2.text.h
    public final void r(c5.a aVar) {
    }

    @Override // androidx.emoji2.text.h
    public final void t(c5.a aVar) {
    }
}
