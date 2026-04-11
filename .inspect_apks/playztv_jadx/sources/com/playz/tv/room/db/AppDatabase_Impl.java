package com.playz.tv.room.db;

import androidx.emoji2.text.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r4.g;
import rc.b;
import sc.a;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class AppDatabase_Impl extends AppDatabase {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile b f3684l;

    @Override // r4.t
    public final g c() {
        return new g(this, new HashMap(0), new HashMap(0), "fav_channels");
    }

    @Override // r4.t
    public final h d() {
        return new a(this);
    }

    @Override // r4.t
    public final List f(LinkedHashMap linkedHashMap) {
        return new ArrayList();
    }

    @Override // r4.t
    public final Set i() {
        return new HashSet();
    }

    @Override // r4.t
    public final Map j() {
        HashMap map = new HashMap();
        map.put(b.class, Collections.EMPTY_LIST);
        return map;
    }

    @Override // com.playz.tv.room.db.AppDatabase
    public final b p() {
        b bVar;
        if (this.f3684l != null) {
            return this.f3684l;
        }
        synchronized (this) {
            try {
                if (this.f3684l == null) {
                    this.f3684l = new b(0, this);
                }
                bVar = this.f3684l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }
}
