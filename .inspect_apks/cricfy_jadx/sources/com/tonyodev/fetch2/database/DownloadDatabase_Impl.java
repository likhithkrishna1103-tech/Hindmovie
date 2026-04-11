package com.tonyodev.fetch2.database;

import android.content.Context;
import d5.d;
import dd.c;
import e5.h;
import ge.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import w4.a;
import w4.g;
import w4.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class DownloadDatabase_Impl extends DownloadDatabase {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile c f3056k;

    @Override // w4.t
    public final g d() {
        return new g(this, new HashMap(0), new HashMap(0), "requests");
    }

    @Override // w4.t
    public final d f(a aVar) {
        x xVar = new x(aVar, new pc.c(this));
        Context context = aVar.f13902a;
        i.e(context, "context");
        String str = aVar.f13903b;
        aVar.f13904c.getClass();
        return new h(context, str, xVar);
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
        map.put(c.class, Collections.EMPTY_LIST);
        return map;
    }

    @Override // com.tonyodev.fetch2.database.DownloadDatabase
    public final c q() {
        c cVar;
        if (this.f3056k != null) {
            return this.f3056k;
        }
        synchronized (this) {
            try {
                if (this.f3056k == null) {
                    this.f3056k = new c(this);
                }
                cVar = this.f3056k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }
}
