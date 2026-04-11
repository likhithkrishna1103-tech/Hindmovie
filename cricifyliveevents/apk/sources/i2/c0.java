package i2;

import android.os.SystemClock;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Serializable f5984c;

    public c0(long j4) {
        this.f5984c = new LinkedHashMap(100, 0.75f, true);
        this.f5982a = j4;
    }

    public synchronized Object a(Object obj) {
        s7.i iVar;
        iVar = (s7.i) ((LinkedHashMap) this.f5984c).get(obj);
        return iVar != null ? iVar.f11600a : null;
    }

    public int b(Object obj) {
        return 1;
    }

    public synchronized Object d(Object obj, Object obj2) {
        int iB = b(obj2);
        long j4 = iB;
        if (j4 >= this.f5982a) {
            c(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.f5983b += j4;
        }
        s7.i iVar = (s7.i) ((LinkedHashMap) this.f5984c).put(obj, obj2 == null ? null : new s7.i(iB, obj2));
        if (iVar != null) {
            this.f5983b -= (long) iVar.f11601b;
            if (!iVar.f11600a.equals(obj2)) {
                c(obj, iVar.f11600a);
            }
        }
        f(this.f5982a);
        return iVar != null ? iVar.f11600a : null;
    }

    public void e(Exception exc) {
        boolean z10;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (((Exception) this.f5984c) == null) {
            this.f5984c = exc;
        }
        if (this.f5982a == -9223372036854775807L) {
            synchronized (f0.f6000n0) {
                z10 = f0.f6001p0 > 0;
            }
            if (!z10) {
                this.f5982a = 200 + jElapsedRealtime;
            }
        }
        long j4 = this.f5982a;
        if (j4 == -9223372036854775807L || jElapsedRealtime < j4) {
            this.f5983b = jElapsedRealtime + 50;
            return;
        }
        Exception exc2 = (Exception) this.f5984c;
        if (exc2 != exc) {
            exc2.addSuppressed(exc);
        }
        Exception exc3 = (Exception) this.f5984c;
        this.f5984c = null;
        this.f5982a = -9223372036854775807L;
        this.f5983b = -9223372036854775807L;
        throw exc3;
    }

    public synchronized void f(long j4) {
        while (this.f5983b > j4) {
            Iterator it = ((LinkedHashMap) this.f5984c).entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            s7.i iVar = (s7.i) entry.getValue();
            this.f5983b -= (long) iVar.f11601b;
            Object key = entry.getKey();
            it.remove();
            c(key, iVar.f11600a);
        }
    }

    public c0() {
        this.f5982a = -9223372036854775807L;
        this.f5983b = -9223372036854775807L;
    }

    public void c(Object obj, Object obj2) {
    }
}
