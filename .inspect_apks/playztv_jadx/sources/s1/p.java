package s1;

import a2.n1;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import e6.f0;
import java.util.ArrayDeque;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f11686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f11687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f11688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet f11689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayDeque f11690e;
    public final ArrayDeque f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f11691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11692h;
    public final boolean i;

    public p(Looper looper, w wVar, n nVar) {
        this(new CopyOnWriteArraySet(), looper, wVar, nVar, true);
    }

    public final void a(Object obj) {
        obj.getClass();
        synchronized (this.f11691g) {
            try {
                if (this.f11692h) {
                    return;
                }
                this.f11689d.add(new o(obj));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        f();
        ArrayDeque arrayDeque = this.f;
        if (arrayDeque.isEmpty()) {
            return;
        }
        y yVar = this.f11687b;
        if (!yVar.f11718a.hasMessages(1)) {
            yVar.getClass();
            x xVarB = y.b();
            Message messageObtainMessage = yVar.f11718a.obtainMessage(1);
            xVarB.f11716a = messageObtainMessage;
            Handler handler = yVar.f11718a;
            messageObtainMessage.getClass();
            handler.sendMessageAtFrontOfQueue(messageObtainMessage);
            xVarB.a();
        }
        ArrayDeque arrayDeque2 = this.f11690e;
        boolean zIsEmpty = arrayDeque2.isEmpty();
        arrayDeque2.addAll(arrayDeque);
        arrayDeque.clear();
        if (zIsEmpty) {
            while (!arrayDeque2.isEmpty()) {
                ((Runnable) arrayDeque2.peekFirst()).run();
                arrayDeque2.removeFirst();
            }
        }
    }

    public final void c(int i, m mVar) {
        f();
        this.f.add(new n1(new CopyOnWriteArraySet(this.f11689d), i, mVar, 5));
    }

    public final void d() {
        f();
        synchronized (this.f11691g) {
            this.f11692h = true;
        }
        for (o oVar : this.f11689d) {
            n nVar = this.f11688c;
            oVar.f11685d = true;
            if (oVar.f11684c) {
                oVar.f11684c = false;
                nVar.i(oVar.f11682a, oVar.f11683b.f());
            }
        }
        this.f11689d.clear();
    }

    public final void e(int i, m mVar) {
        c(i, mVar);
        b();
    }

    public final void f() {
        if (this.i) {
            d.g(Thread.currentThread() == this.f11687b.f11718a.getLooper().getThread());
        }
    }

    public p(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, w wVar, n nVar, boolean z2) {
        this.f11686a = wVar;
        this.f11689d = copyOnWriteArraySet;
        this.f11688c = nVar;
        this.f11691g = new Object();
        this.f11690e = new ArrayDeque();
        this.f = new ArrayDeque();
        this.f11687b = wVar.a(looper, new Handler.Callback() { // from class: s1.l
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                p pVar = this.f11681u;
                for (o oVar : pVar.f11689d) {
                    n nVar2 = pVar.f11688c;
                    if (!oVar.f11685d && oVar.f11684c) {
                        p1.o oVarF = oVar.f11683b.f();
                        oVar.f11683b = new f0(3);
                        oVar.f11684c = false;
                        nVar2.i(oVar.f11682a, oVarF);
                    }
                    if (pVar.f11687b.f11718a.hasMessages(1)) {
                        break;
                    }
                }
                return true;
            }
        });
        this.i = z2;
    }
}
