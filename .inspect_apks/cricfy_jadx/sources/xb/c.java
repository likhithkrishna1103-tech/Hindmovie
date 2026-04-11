package xb;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.lifecycle.j0;
import androidx.media3.decoder.DecoderInputBuffer;
import d1.h0;
import d1.k0;
import d1.l0;
import f1.e;
import g1.j;
import ge.i;
import ge.l;
import ge.q;
import h1.d;
import h1.h;
import java.util.LinkedHashSet;
import java.util.List;
import pe.f0;
import pe.h1;
import pe.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ le.c[] f14475d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadLocal f14477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f14478c;

    static {
        l lVar = new l(ge.c.f5241v, c.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0);
        q.f5255a.getClass();
        f14475d = new le.c[]{lVar};
    }

    public c(Context context, String str) {
        d dVar;
        i.e(context, "context");
        i.e(str, "name");
        this.f14476a = str;
        this.f14477b = new ThreadLocal();
        final int i = 0;
        e1.a aVar = new e1.a(new fe.l(this) { // from class: xb.a

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ c f14473w;

            {
                this.f14473w = this;
            }

            @Override // fe.l
            public final Object a(Object obj) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        d1.c cVar = (d1.c) obj;
                        i.e(cVar, "ex");
                        Log.w(q.a(c.class).c(), "CorruptionException in " + this.f14473w.f14476a + " DataStore running in process " + Process.myPid(), cVar);
                        return new h1.b(true);
                    default:
                        Context context2 = (Context) obj;
                        i.e(context2, "it");
                        String str2 = this.f14473w.f14476a;
                        LinkedHashSet linkedHashSet = j.f4615a;
                        i.e(str2, "sharedPreferencesName");
                        i.e(linkedHashSet, "keysToMigrate");
                        return n5.a.x(new f1.d(context2, str2, e.f3926a, new d1.q(linkedHashSet, null, 1), new g1.i(3, null)));
                }
            }
        });
        final int i10 = 1;
        fe.l lVar = new fe.l(this) { // from class: xb.a

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ c f14473w;

            {
                this.f14473w = this;
            }

            @Override // fe.l
            public final Object a(Object obj) {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        d1.c cVar = (d1.c) obj;
                        i.e(cVar, "ex");
                        Log.w(q.a(c.class).c(), "CorruptionException in " + this.f14473w.f14476a + " DataStore running in process " + Process.myPid(), cVar);
                        return new h1.b(true);
                    default:
                        Context context2 = (Context) obj;
                        i.e(context2, "it");
                        String str2 = this.f14473w.f14476a;
                        LinkedHashSet linkedHashSet = j.f4615a;
                        i.e(str2, "sharedPreferencesName");
                        i.e(linkedHashSet, "keysToMigrate");
                        return n5.a.x(new f1.d(context2, str2, e.f3926a, new d1.q(linkedHashSet, null, 1), new g1.i(3, null)));
                }
            }
        };
        we.e eVar = f0.f10232a;
        we.d dVar2 = we.d.f14160x;
        vd.c cVar = null;
        h1 h1Var = new h1(null);
        dVar2.getClass();
        ue.c cVarB = x.b(w8.e.k(dVar2, h1Var));
        g1.a aVar2 = new g1.a(str, aVar, lVar, cVarB);
        i.e(f14475d[0], "property");
        d dVar3 = (d) aVar2.f4612c;
        if (dVar3 == null) {
            synchronized (aVar2.f4610a) {
                try {
                    if (((d) aVar2.f4612c) == null) {
                        Context applicationContext = context.getApplicationContext();
                        i.d(applicationContext, "applicationContext");
                        List list = (List) lVar.a(applicationContext);
                        f1.a aVar3 = new f1.a(applicationContext, aVar2, i10);
                        aVar2.f4612c = new d(new d(new h0(new l0(h.f5479a, k0.f3258w, new j0(3, aVar3)), n5.a.x(new d1.e(list, cVar, i)), aVar, cVarB)));
                    }
                    dVar = (d) aVar2.f4612c;
                    i.b(dVar);
                } catch (Throwable th) {
                    throw th;
                }
            }
            dVar3 = dVar;
        }
        this.f14478c = dVar3;
    }

    public final void a(fe.l lVar) {
    }
}
