package app.cricfy.tv.room.db;

import androidx.emoji2.text.h;
import b6.f;
import c6.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import w4.g;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class AppDatabase_Impl extends AppDatabase {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile f f1574l;

    @Override // w4.t
    public final g d() {
        return new g(this, new HashMap(0), new HashMap(0), "fav_channels", "ns_data", "notifications");
    }

    @Override // w4.t
    public final h e() {
        return new a(this);
    }

    @Override // w4.t
    public final List h(LinkedHashMap linkedHashMap) {
        return new ArrayList();
    }

    @Override // w4.t
    public final Set k() {
        return new HashSet();
    }

    @Override // w4.t
    public final Map l() {
        HashMap map = new HashMap();
        map.put(f.class, Collections.EMPTY_LIST);
        return map;
    }

    @Override // app.cricfy.tv.room.db.AppDatabase
    public final f q() {
        f fVar;
        if (this.f1574l != null) {
            return this.f1574l;
        }
        synchronized (this) {
            try {
                if (this.f1574l == null) {
                    this.f1574l = new f(this);
                }
                fVar = this.f1574l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }
}
