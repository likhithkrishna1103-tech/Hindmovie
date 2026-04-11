package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w5 implements a6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g5 f2708b = new g5(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2709a;

    public /* synthetic */ w5(Object obj) {
        this.f2709a = obj;
    }

    @Override // com.google.android.gms.internal.measurement.a6
    public boolean a(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (((a6[]) this.f2709a)[i].a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.a6
    public i6 b(Class cls) {
        for (int i = 0; i < 2; i++) {
            a6 a6Var = ((a6[]) this.f2709a)[i];
            if (a6Var.a(cls)) {
                return a6Var.b(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public Object c() {
        f4 f4Var = (f4) this.f2709a;
        ContentResolver contentResolver = f4Var.f2390a;
        Uri uri = f4Var.f2391b;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        try {
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.EMPTY_MAP;
            }
            Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, f4.f2389j, null, null, null);
            try {
                if (cursorQuery == null) {
                    Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                    return Collections.EMPTY_MAP;
                }
                int count = cursorQuery.getCount();
                if (count == 0) {
                    Map map = Collections.EMPTY_MAP;
                    cursorQuery.close();
                    return map;
                }
                Map eVar = count <= 256 ? new v.e(count) : new HashMap(count, 1.0f);
                while (cursorQuery.moveToNext()) {
                    eVar.put(cursorQuery.getString(0), cursorQuery.getString(1));
                }
                if (cursorQuery.isAfterLast()) {
                    cursorQuery.close();
                    return eVar;
                }
                Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                Map map2 = Collections.EMPTY_MAP;
                cursorQuery.close();
                return map2;
            } finally {
            }
        } catch (RemoteException e9) {
            Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e9);
            return Collections.EMPTY_MAP;
        } finally {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
    }

    public void d(int i, Object obj, j6 j6Var) throws a2.a {
        u4 u4Var = (u4) obj;
        b5 b5Var = (b5) this.f2709a;
        b5Var.p0((i << 3) | 2);
        b5Var.p0(u4Var.b(j6Var));
        j6Var.g(u4Var, b5Var.f2328e);
    }

    public void e(int i, Object obj, j6 j6Var) throws a2.a {
        b5 b5Var = (b5) this.f2709a;
        b5Var.g0(i, 3);
        j6Var.g((u4) obj, b5Var.f2328e);
        b5Var.g0(i, 4);
    }

    public w5(int i) {
        switch (i) {
            case 1:
                this.f2709a = new HashMap();
                break;
            default:
                g6 g6Var = g6.f2460c;
                w5 w5Var = new w5(new a6[]{g5.f2458b, f2708b});
                Charset charset = p5.f2570a;
                this.f2709a = w5Var;
                break;
        }
    }

    public w5(b5 b5Var) {
        Charset charset = p5.f2570a;
        this.f2709a = b5Var;
        b5Var.f2328e = this;
    }
}
