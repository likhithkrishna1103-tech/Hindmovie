package sc;

import android.support.v4.media.session.b;
import androidx.emoji2.text.h;
import com.playz.tv.room.db.AppDatabase_Impl;
import java.util.HashMap;
import java.util.HashSet;
import w4.d;
import w4.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppDatabase_Impl f11941d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AppDatabase_Impl appDatabase_Impl) {
        super(3, "b3b442c11717bf826cd0c4e308ddef11", "84e040a70dc7040f198cae6f408b690c");
        this.f11941d = appDatabase_Impl;
    }

    @Override // androidx.emoji2.text.h
    public final void a(y4.a aVar) throws Exception {
        b.o(aVar, "CREATE TABLE IF NOT EXISTS `fav_channels` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `image` TEXT, `link` TEXT, `playlist` TEXT)");
        b.o(aVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        b.o(aVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b3b442c11717bf826cd0c4e308ddef11')");
    }

    @Override // androidx.emoji2.text.h
    public final void c(y4.a aVar) throws Exception {
        b.o(aVar, "DROP TABLE IF EXISTS `fav_channels`");
    }

    @Override // androidx.emoji2.text.h
    public final void s(y4.a aVar) throws Exception {
        this.f11941d.n(aVar);
    }

    @Override // androidx.emoji2.text.h
    public final void u(y4.a aVar) throws Exception {
        z7.a.j(aVar);
    }

    @Override // androidx.emoji2.text.h
    public final n7.a v(y4.a aVar) throws Exception {
        HashMap map = new HashMap(5);
        map.put("id", new d(1, 1, "id", "INTEGER", null, true));
        map.put("name", new d(0, 1, "name", "TEXT", null, false));
        map.put("image", new d(0, 1, "image", "TEXT", null, false));
        map.put("link", new d(0, 1, "link", "TEXT", null, false));
        map.put("playlist", new d(0, 1, "playlist", "TEXT", null, false));
        g gVar = new g("fav_channels", map, new HashSet(0), new HashSet(0));
        g gVarW = cf.d.w(aVar, "fav_channels");
        if (gVar.equals(gVarW)) {
            return new n7.a(true, (String) null, 1);
        }
        return new n7.a(false, "fav_channels(com.playz.tv.room.FavChannelEntity).\n Expected:\n" + gVar + "\n Found:\n" + gVarW, 1);
    }

    @Override // androidx.emoji2.text.h
    public final void r(y4.a aVar) {
    }

    @Override // androidx.emoji2.text.h
    public final void t(y4.a aVar) {
    }
}
