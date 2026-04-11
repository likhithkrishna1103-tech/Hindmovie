package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.os.RemoteException;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x5 implements a6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k5 f3234b = new k5(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f3235a;

    @Override // com.google.android.gms.internal.measurement.a6
    public i6 a(Class cls) {
        for (a6 a6Var : (a6[]) this.f3235a) {
            if (a6Var.b(cls)) {
                return a6Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.measurement.a6
    public boolean b(Class cls) {
        for (a6 a6Var : (a6[]) this.f3235a) {
            if (a6Var.b(cls)) {
                return true;
            }
        }
        return false;
    }

    public Object c() {
        g4 g4Var = (g4) this.f3235a;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = g4Var.f3010u.acquireUnstableContentProviderClient(g4Var.f3011v);
        try {
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.EMPTY_MAP;
            }
            Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(g4Var.f3011v, g4.C, null, null, null);
            try {
                if (cursorQuery == null) {
                    Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                    Map map = Collections.EMPTY_MAP;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return map;
                }
                int count = cursorQuery.getCount();
                if (count == 0) {
                    Map map2 = Collections.EMPTY_MAP;
                    cursorQuery.close();
                    return map2;
                }
                Map eVar = count <= 256 ? new s.e(count) : new HashMap(count, 1.0f);
                while (cursorQuery.moveToNext()) {
                    eVar.put(cursorQuery.getString(0), cursorQuery.getString(1));
                }
                if (cursorQuery.isAfterLast()) {
                    cursorQuery.close();
                    return eVar;
                }
                Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                Map map3 = Collections.EMPTY_MAP;
                cursorQuery.close();
                return map3;
            } finally {
            }
        } catch (RemoteException e10) {
            Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e10);
            return Collections.EMPTY_MAP;
        } finally {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
    }

    public void d(int i, Object obj, j6 j6Var) throws c6.c {
        b5 b5Var = (b5) this.f3235a;
        b5Var.r(i, 3);
        j6Var.i((u4) obj, b5Var.f2899b);
        b5Var.r(i, 4);
    }

    public void e(int i, Object obj, j6 j6Var) throws c6.c {
        b5 b5Var = (b5) this.f3235a;
        u4 u4Var = (u4) obj;
        b5Var.r(i, 2);
        b5Var.q(u4Var.a(j6Var));
        j6Var.i(u4Var, b5Var.f2899b);
    }
}
