package kb;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import nc.i;
import of.t;
import pb.m;
import sd.l;
import uc.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tb.c f7395a;

    public b(tb.c cVar) {
        this.f7395a = cVar;
    }

    public final void a(uc.d dVar) {
        tb.c cVar = this.f7395a;
        HashSet hashSet = dVar.f12448a;
        ArrayList arrayList = new ArrayList(l.f0(hashSet, 10));
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            uc.c cVar2 = (uc.c) ((e) it.next());
            String str = cVar2.f12444b;
            String str2 = cVar2.f12446d;
            String strSubstring = cVar2.f12447e;
            String str3 = cVar2.f12445c;
            long j4 = cVar2.f;
            p6.c cVar3 = m.f10174a;
            if (strSubstring.length() > 256) {
                strSubstring = strSubstring.substring(0, 256);
            }
            arrayList.add(new pb.b(str, str2, strSubstring, str3, j4));
        }
        synchronized (((t) cVar.A)) {
            try {
                if (((t) cVar.A).b(arrayList)) {
                    ((ob.c) cVar.f11985x).f9743b.a(new i(2, cVar, ((t) cVar.A).a()));
                }
            } finally {
            }
        }
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Updated Crashlytics Rollout State", null);
        }
    }
}
