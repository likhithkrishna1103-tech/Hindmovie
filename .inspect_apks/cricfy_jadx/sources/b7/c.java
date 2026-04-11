package b7;

import java.util.ArrayDeque;
import s7.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f1824a;

    public c(int i) {
        switch (i) {
            case 1:
                char[] cArr = m.f11607a;
                this.f1824a = new ArrayDeque(0);
                break;
            default:
                this.f1824a = new ArrayDeque();
                break;
        }
    }

    public b a() {
        b bVar;
        synchronized (this.f1824a) {
            bVar = (b) this.f1824a.poll();
        }
        return bVar == null ? new b() : bVar;
    }

    public void b(b bVar) {
        synchronized (this.f1824a) {
            try {
                if (this.f1824a.size() < 10) {
                    this.f1824a.offer(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void c(v6.c cVar) {
        cVar.f13475b = null;
        cVar.f13476c = null;
        this.f1824a.offer(cVar);
    }
}
