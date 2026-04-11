package com.tonyodev.fetch2.database;

import a5.j;
import android.content.Context;
import be.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n.a1;
import r4.a;
import r4.g;
import r4.u;
import z4.b;
import zc.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class DownloadDatabase_Impl extends DownloadDatabase {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile c f3692k;

    @Override // r4.t
    public final g c() {
        return new g(this, new HashMap(0), new HashMap(0), "requests");
    }

    @Override // r4.t
    public final b e(a aVar) {
        u uVar = new u(aVar, new a1(this));
        Context context = aVar.f11404a;
        h.e(context, "context");
        String str = aVar.f11405b;
        aVar.f11406c.getClass();
        return new j(context, str, uVar);
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
        map.put(c.class, Collections.EMPTY_LIST);
        return map;
    }

    @Override // com.tonyodev.fetch2.database.DownloadDatabase
    public final c p() {
        c cVar;
        if (this.f3692k != null) {
            return this.f3692k;
        }
        synchronized (this) {
            try {
                if (this.f3692k == null) {
                    this.f3692k = new c(this);
                }
                cVar = this.f3692k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }
}
