package y1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.measurement.o4;
import java.util.ArrayDeque;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f14591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f14592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f14593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet f14594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayDeque f14595e;
    public final ArrayDeque f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f14596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14597h;
    public final boolean i;

    public p(Looper looper, v vVar, n nVar) {
        this(new CopyOnWriteArraySet(), looper, vVar, nVar, true);
    }

    public final void a(Object obj) {
        obj.getClass();
        synchronized (this.f14596g) {
            try {
                if (this.f14597h) {
                    return;
                }
                this.f14594d.add(new o(obj));
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
        x xVar = this.f14592b;
        if (!xVar.f14618a.hasMessages(1)) {
            xVar.getClass();
            w wVarB = x.b();
            Message messageObtainMessage = xVar.f14618a.obtainMessage(1);
            wVarB.f14616a = messageObtainMessage;
            Handler handler = xVar.f14618a;
            messageObtainMessage.getClass();
            handler.sendMessageAtFrontOfQueue(messageObtainMessage);
            wVarB.a();
        }
        ArrayDeque arrayDeque2 = this.f14595e;
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
        this.f.add(new c.k(new CopyOnWriteArraySet(this.f14594d), i, mVar, 5));
    }

    public final void d() {
        f();
        synchronized (this.f14596g) {
            this.f14597h = true;
        }
        for (o oVar : this.f14594d) {
            n nVar = this.f14593c;
            oVar.f14590d = true;
            if (oVar.f14589c) {
                oVar.f14589c = false;
                nVar.b(oVar.f14587a, oVar.f14588b.e());
            }
        }
        this.f14594d.clear();
    }

    public final void e(int i, m mVar) {
        c(i, mVar);
        b();
    }

    public final void f() {
        if (this.i) {
            d.g(Thread.currentThread() == this.f14592b.f14618a.getLooper().getThread());
        }
    }

    public p(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, v vVar, n nVar, boolean z10) {
        this.f14591a = vVar;
        this.f14594d = copyOnWriteArraySet;
        this.f14593c = nVar;
        this.f14596g = new Object();
        this.f14595e = new ArrayDeque();
        this.f = new ArrayDeque();
        this.f14592b = vVar.a(looper, new Handler.Callback() { // from class: y1.l
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                p pVar = this.f14586v;
                for (o oVar : pVar.f14594d) {
                    n nVar2 = pVar.f14593c;
                    if (!oVar.f14590d && oVar.f14589c) {
                        v1.n nVarE = oVar.f14588b.e();
                        oVar.f14588b = new o4(8);
                        oVar.f14589c = false;
                        nVar2.b(oVar.f14587a, nVarE);
                    }
                    if (pVar.f14592b.f14618a.hasMessages(1)) {
                        break;
                    }
                }
                return true;
            }
        });
        this.i = z10;
    }
}
