package y1;

import android.content.Context;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s {
    public static s f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f14602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f14603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f14604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14606e;

    public s(Context context) {
        Executor executorI = b.i();
        this.f14602a = executorI;
        this.f14603b = new CopyOnWriteArrayList();
        this.f14604c = new Object();
        this.f14605d = 0;
        executorI.execute(new nc.i(15, this, context));
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
        synchronized (this.f14604c) {
            i = this.f14605d;
        }
        return i;
    }

    public final void c(int i) {
        CopyOnWriteArrayList<r> copyOnWriteArrayList = this.f14603b;
        for (r rVar : copyOnWriteArrayList) {
            if (rVar.f14599a.get() == null) {
                copyOnWriteArrayList.remove(rVar);
            }
        }
        synchronized (this.f14604c) {
            try {
                if (this.f14606e && this.f14605d == i) {
                    return;
                }
                this.f14606e = true;
                this.f14605d = i;
                for (r rVar2 : this.f14603b) {
                    rVar2.f14600b.execute(new pa.c(13, rVar2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
