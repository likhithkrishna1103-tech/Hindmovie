package c2;

import android.os.SystemClock;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Serializable f2250c;

    public b0(long j5) {
        this.f2250c = new LinkedHashMap(100, 0.75f, true);
        this.f2248a = j5;
    }

    public synchronized Object a(Object obj) {
        x6.i iVar;
        iVar = (x6.i) ((LinkedHashMap) this.f2250c).get(obj);
        return iVar != null ? iVar.f14284a : null;
    }

    public int b(Object obj) {
        return 1;
    }

    public synchronized Object d(Object obj, Object obj2) {
        int iB = b(obj2);
        long j5 = iB;
        if (j5 >= this.f2248a) {
            c(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.f2249b += j5;
        }
        x6.i iVar = (x6.i) ((LinkedHashMap) this.f2250c).put(obj, obj2 == null ? null : new x6.i(iB, obj2));
        if (iVar != null) {
            this.f2249b -= (long) iVar.f14285b;
            if (!iVar.f14284a.equals(obj2)) {
                c(obj, iVar.f14284a);
            }
        }
        f(this.f2248a);
        return iVar != null ? iVar.f14284a : null;
    }

    public void e(Exception exc) {
        boolean z2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (((Exception) this.f2250c) == null) {
            this.f2250c = exc;
        }
        if (this.f2248a == -9223372036854775807L) {
            synchronized (e0.f2260n0) {
                z2 = e0.f2262p0 > 0;
            }
            if (!z2) {
                this.f2248a = 200 + jElapsedRealtime;
            }
        }
        long j5 = this.f2248a;
        if (j5 == -9223372036854775807L || jElapsedRealtime < j5) {
            this.f2249b = jElapsedRealtime + 50;
            return;
        }
        Exception exc2 = (Exception) this.f2250c;
        if (exc2 != exc) {
            exc2.addSuppressed(exc);
        }
        Exception exc3 = (Exception) this.f2250c;
        this.f2250c = null;
        this.f2248a = -9223372036854775807L;
        this.f2249b = -9223372036854775807L;
        throw exc3;
    }

    public synchronized void f(long j5) {
        while (this.f2249b > j5) {
            Iterator it = ((LinkedHashMap) this.f2250c).entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            x6.i iVar = (x6.i) entry.getValue();
            this.f2249b -= (long) iVar.f14285b;
            Object key = entry.getKey();
            it.remove();
            c(key, iVar.f14284a);
        }
    }

    public b0() {
        this.f2248a = -9223372036854775807L;
        this.f2249b = -9223372036854775807L;
    }

    public void c(Object obj, Object obj2) {
    }
}
