package g6;

import java.util.ArrayDeque;
import x6.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f5321a;

    public c(int i) {
        switch (i) {
            case 1:
                char[] cArr = m.f14291a;
                this.f5321a = new ArrayDeque(0);
                break;
            default:
                this.f5321a = new ArrayDeque();
                break;
        }
    }

    public b a() {
        b bVar;
        synchronized (this.f5321a) {
            bVar = (b) this.f5321a.poll();
        }
        return bVar == null ? new b() : bVar;
    }

    public void b(b bVar) {
        synchronized (this.f5321a) {
            try {
                if (this.f5321a.size() < 10) {
                    this.f5321a.offer(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void c(a6.c cVar) {
        cVar.f590b = null;
        cVar.f591c = null;
        this.f5321a.offer(cVar);
    }
}
