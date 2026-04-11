package oa;

import c7.q;
import ea.t;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Executor {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Logger f9471z = Logger.getLogger(i.class.getName());

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Executor f9472u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayDeque f9473v = new ArrayDeque();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f9474w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f9475x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final t f9476y = new t(this);

    public i(Executor executor) {
        v.h(executor);
        this.f9472u = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        v.h(runnable);
        synchronized (this.f9473v) {
            int i = this.f9474w;
            if (i != 4 && i != 3) {
                long j5 = this.f9475x;
                q qVar = new q(runnable, 2);
                this.f9473v.add(qVar);
                this.f9474w = 2;
                try {
                    this.f9472u.execute(this.f9476y);
                    if (this.f9474w != 2) {
                        return;
                    }
                    synchronized (this.f9473v) {
                        try {
                            if (this.f9475x == j5 && this.f9474w == 2) {
                                this.f9474w = 3;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Error | RuntimeException e10) {
                    synchronized (this.f9473v) {
                        try {
                            int i10 = this.f9474w;
                            boolean z2 = true;
                            if ((i10 != 1 && i10 != 2) || !this.f9473v.removeLastOccurrence(qVar)) {
                                z2 = false;
                            }
                            if (!(e10 instanceof RejectedExecutionException) || z2) {
                                throw e10;
                            }
                        } finally {
                        }
                    }
                    return;
                }
            }
            this.f9473v.add(runnable);
        }
    }

    public final String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f9472u + "}";
    }
}
