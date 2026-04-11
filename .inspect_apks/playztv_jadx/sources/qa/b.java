package qa;

import android.util.Log;
import bc.d;
import bc.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import o2.i0;
import od.k;
import va.n;
import va.o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final za.c f11166a;

    public b(za.c cVar) {
        this.f11166a = cVar;
    }

    public final void a(d dVar) {
        za.c cVar = this.f11166a;
        HashSet hashSet = dVar.f2008a;
        ArrayList arrayList = new ArrayList(k.U(hashSet));
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            bc.c cVar2 = (bc.c) ((e) it.next());
            String str = cVar2.f2004b;
            String str2 = cVar2.f2006d;
            String strSubstring = cVar2.f2007e;
            String str3 = cVar2.f2005c;
            long j5 = cVar2.f;
            u5.d dVar2 = n.f13461a;
            if (strSubstring.length() > 256) {
                strSubstring = strSubstring.substring(0, 256);
            }
            arrayList.add(new va.b(str, str2, strSubstring, str3, j5));
        }
        synchronized (((o) cVar.f)) {
            try {
                if (((o) cVar.f).c(arrayList)) {
                    ((ua.d) cVar.f14936c).f12824b.a(new i0(cVar, 18, ((o) cVar.f).a()));
                }
            } finally {
            }
        }
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Updated Crashlytics Rollout State", null);
        }
    }
}
