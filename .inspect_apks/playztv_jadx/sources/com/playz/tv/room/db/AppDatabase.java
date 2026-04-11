package com.playz.tv.room.db;

import android.content.Context;
import cf.d;
import r4.q;
import r4.t;
import rc.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppDatabase extends t {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile AppDatabase f3683k;

    public static AppDatabase q(Context context) {
        if (f3683k == null) {
            synchronized (AppDatabase.class) {
                try {
                    if (f3683k == null) {
                        q qVarL = d.l(context.getApplicationContext(), AppDatabase.class, "favorites_db");
                        qVarL.f11485n = false;
                        qVarL.f11486o = true;
                        f3683k = (AppDatabase) qVarL.a();
                    }
                } finally {
                }
            }
        }
        return f3683k;
    }

    public abstract b p();
}
