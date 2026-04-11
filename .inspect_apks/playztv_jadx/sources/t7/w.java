package t7;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.r0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f12338a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(e eVar, Looper looper) {
        super(looper, 3);
        this.f12338a = eVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        if (this.f12338a.f12286w.get() != message.arg1) {
            int i = message.what;
            if (i == 2 || i == 1 || i == 7) {
                p pVar = (p) message.obj;
                pVar.getClass();
                pVar.d();
                return;
            }
            return;
        }
        int i10 = message.what;
        if ((i10 == 1 || i10 == 7 || i10 == 4 || i10 == 5) && !this.f12338a.h()) {
            p pVar2 = (p) message.obj;
            pVar2.getClass();
            pVar2.d();
            return;
        }
        int i11 = message.what;
        if (i11 == 4) {
            e eVar = this.f12338a;
            eVar.f12283t = new q7.b(message.arg2);
            if (!eVar.f12284u && !TextUtils.isEmpty(eVar.v()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(eVar.v());
                    e eVar2 = this.f12338a;
                    if (!eVar2.f12284u) {
                        eVar2.A(3, null);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            e eVar3 = this.f12338a;
            q7.b bVar = eVar3.f12283t;
            if (bVar == null) {
                bVar = new q7.b(8);
            }
            eVar3.f12273j.m(bVar);
            System.currentTimeMillis();
            return;
        }
        if (i11 == 5) {
            e eVar4 = this.f12338a;
            q7.b bVar2 = eVar4.f12283t;
            if (bVar2 == null) {
                bVar2 = new q7.b(8);
            }
            eVar4.f12273j.m(bVar2);
            System.currentTimeMillis();
            return;
        }
        if (i11 == 3) {
            Object obj = message.obj;
            this.f12338a.f12273j.m(new q7.b(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null));
            System.currentTimeMillis();
            return;
        }
        if (i11 == 6) {
            this.f12338a.A(5, null);
            b bVar3 = this.f12338a.f12278o;
            if (bVar3 != null) {
                bVar3.e(message.arg2);
            }
            System.currentTimeMillis();
            e.z(this.f12338a, 5, 1, null);
            return;
        }
        if (i11 == 2 && !this.f12338a.b()) {
            p pVar3 = (p) message.obj;
            pVar3.getClass();
            pVar3.d();
            return;
        }
        int i12 = message.what;
        if (i12 != 2 && i12 != 1 && i12 != 7) {
            Log.wtf("GmsClient", e6.j.l("Don't know how to handle message: ", i12), new Exception());
            return;
        }
        p pVar4 = (p) message.obj;
        synchronized (pVar4) {
            try {
                bool = pVar4.f12328a;
                if (pVar4.f12329b) {
                    Log.w("GmsClient", "Callback proxy " + pVar4.toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            e eVar5 = pVar4.f;
            int i13 = pVar4.f12331d;
            if (i13 != 0) {
                eVar5.A(1, null);
                Bundle bundle = pVar4.f12332e;
                pVar4.a(new q7.b(i13, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
            } else if (!pVar4.b()) {
                eVar5.A(1, null);
                pVar4.a(new q7.b(8, null));
            }
        }
        synchronized (pVar4) {
            pVar4.f12329b = true;
        }
        pVar4.d();
    }
}
