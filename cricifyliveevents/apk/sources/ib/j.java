package ib;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
import o8.u;
import ya.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Executor {
    public static final Logger A = Logger.getLogger(j.class.getName());

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Executor f6406v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayDeque f6407w = new ArrayDeque();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6408x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f6409y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final s f6410z = new s(this);

    public j(Executor executor) {
        u.g(executor);
        this.f6406v = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        u.g(runnable);
        synchronized (this.f6407w) {
            int i = this.f6408x;
            if (i != 4 && i != 3) {
                long j4 = this.f6409y;
                i iVar = new i(runnable, 0);
                this.f6407w.add(iVar);
                this.f6408x = 2;
                try {
                    this.f6406v.execute(this.f6410z);
                    if (this.f6408x != 2) {
                        return;
                    }
                    synchronized (this.f6407w) {
                        try {
                            if (this.f6409y == j4 && this.f6408x == 2) {
                                this.f6408x = 3;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Error | RuntimeException e9) {
                    synchronized (this.f6407w) {
                        try {
                            int i10 = this.f6408x;
                            boolean z10 = true;
                            if ((i10 != 1 && i10 != 2) || !this.f6407w.removeLastOccurrence(iVar)) {
                                z10 = false;
                            }
                            if (!(e9 instanceof RejectedExecutionException) || z10) {
                                throw e9;
                            }
                        } finally {
                        }
                    }
                    return;
                }
            }
            this.f6407w.add(runnable);
        }
    }

    public final String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f6406v + "}";
    }
}
