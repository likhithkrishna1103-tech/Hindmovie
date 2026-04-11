package s1;

import android.content.Context;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import o2.i0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s {
    public static s f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f11697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f11698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11701e;

    public s(Context context) {
        Executor executorI = b.i();
        this.f11697a = executorI;
        this.f11698b = new CopyOnWriteArrayList();
        this.f11699c = new Object();
        this.f11700d = 0;
        executorI.execute(new i0(this, 8, context));
    }

    public static synchronized s a(Context context) {
        try {
            if (f == null) {
                f = new s(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f;
    }

    public final int b() {
        int i;
        synchronized (this.f11699c) {
            i = this.f11700d;
        }
        return i;
    }

    public final void c(int i) {
        CopyOnWriteArrayList<r> copyOnWriteArrayList = this.f11698b;
        for (r rVar : copyOnWriteArrayList) {
            if (rVar.f11694a.get() == null) {
                copyOnWriteArrayList.remove(rVar);
            }
        }
        synchronized (this.f11699c) {
            try {
                if (this.f11701e && this.f11700d == i) {
                    return;
                }
                this.f11701e = true;
                this.f11700d = i;
                for (r rVar2 : this.f11698b) {
                    rVar2.f11695b.execute(new nc.b(4, rVar2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
