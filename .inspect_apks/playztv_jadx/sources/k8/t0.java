package k8;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7425a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f7427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f7428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f7429e;

    public /* synthetic */ t0() {
    }

    public static t0 d(v vVar) {
        String str = vVar.f7444u;
        String str2 = vVar.f7446w;
        Bundle bundleD = vVar.f7445v.d();
        long j5 = vVar.f7447x;
        t0 t0Var = new t0();
        t0Var.f7427c = str;
        t0Var.f7428d = str2;
        t0Var.f7429e = bundleD;
        t0Var.f7426b = j5;
        return t0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x002e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0033 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(ue.a r6, ye.h r7, java.util.List r8, boolean r9) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f7429e
            java.util.concurrent.ConcurrentLinkedQueue r0 = (java.util.concurrent.ConcurrentLinkedQueue) r0
            java.util.Iterator r0 = r0.iterator()
        L8:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L37
            java.lang.Object r1 = r0.next()
            ye.k r1 = (ye.k) r1
            java.lang.String r3 = "connection"
            be.h.d(r1, r3)
            monitor-enter(r1)
            r3 = 1
            if (r9 == 0) goto L28
            bf.p r4 = r1.f14732g     // Catch: java.lang.Throwable -> L26
            if (r4 == 0) goto L23
            r2 = r3
        L23:
            if (r2 == 0) goto L33
            goto L28
        L26:
            r6 = move-exception
            goto L35
        L28:
            boolean r2 = r1.i(r6, r8)     // Catch: java.lang.Throwable -> L26
            if (r2 == 0) goto L33
            r7.b(r1)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r1)
            return r3
        L33:
            monitor-exit(r1)
            goto L8
        L35:
            monitor-exit(r1)
            throw r6
        L37:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.t0.a(ue.a, ye.h, java.util.List, boolean):boolean");
    }

    public int b(ye.k kVar, long j5) {
        byte[] bArr = ve.b.f13497a;
        ArrayList arrayList = kVar.f14740p;
        int i = 0;
        while (i < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                String str = "A connection to " + kVar.f14728b.f12931a.f12929h + " was leaked. Did you forget to close a response body?";
                cf.n nVar = cf.n.f2753a;
                cf.n.f2753a.j(((ye.f) reference).f14716a, str);
                arrayList.remove(i);
                kVar.f14734j = true;
                if (arrayList.isEmpty()) {
                    kVar.f14741q = j5 - this.f7426b;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }

    public v c() {
        return new v((String) this.f7427c, new u(new Bundle((Bundle) this.f7429e)), (String) this.f7428d, this.f7426b);
    }

    public String toString() {
        switch (this.f7425a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "origin=" + ((String) this.f7428d) + ",name=" + ((String) this.f7427c) + ",params=" + String.valueOf((Bundle) this.f7429e);
            default:
                return super.toString();
        }
    }

    public t0(xe.c cVar) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        be.h.e(cVar, "taskRunner");
        be.h.e(timeUnit, "timeUnit");
        this.f7426b = timeUnit.toNanos(5L);
        this.f7427c = cVar.e();
        this.f7428d = new bf.n(this, l4.a.o(new StringBuilder(), ve.b.f13502g, " ConnectionPool"));
        this.f7429e = new ConcurrentLinkedQueue();
    }
}
