package cc;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t0 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2715c;

    public t0(Looper looper) {
        super(looper);
        this.f2715c = new ArrayList();
    }

    public final void a(Messenger messenger) {
        if (this.f2713a) {
            Object objB = ga.g.c().b(o0.class);
            be.h.d(objB, "Firebase.app[SessionGenerator::class.java]");
            c(messenger, ((o0) objB).b().f2642a);
            return;
        }
        Object objB2 = ga.g.c().b(u.class);
        be.h.d(objB2, "Firebase.app[SessionDatastore::class.java]");
        n nVar = (n) ((f0) ((u) objB2)).f2636c.get();
        String str = nVar != null ? nVar.f2683a : null;
        Log.d("SessionLifecycleService", "App has not yet foregrounded. Using previously stored session: " + str);
        if (str != null) {
            c(messenger, str);
        }
    }

    public final void b() {
        Object objB = ga.g.c().b(o0.class);
        be.h.d(objB, "Firebase.app[SessionGenerator::class.java]");
        o0 o0Var = (o0) objB;
        int i = o0Var.f2687d + 1;
        o0Var.f2687d = i;
        String strA = i == 0 ? o0Var.f2686c : o0Var.a();
        String str = o0Var.f2686c;
        int i10 = o0Var.f2687d;
        o0Var.f2684a.getClass();
        o0Var.f2688e = new g0(strA, str, i10, System.currentTimeMillis() * 1000);
        o0Var.b();
        StringBuilder sb2 = new StringBuilder("Generated new session ");
        Object objB2 = ga.g.c().b(o0.class);
        be.h.d(objB2, "Firebase.app[SessionGenerator::class.java]");
        sb2.append(((o0) objB2).b().f2642a);
        Log.d("SessionLifecycleService", sb2.toString());
        StringBuilder sb3 = new StringBuilder("Broadcasting new session: ");
        Object objB3 = ga.g.c().b(o0.class);
        be.h.d(objB3, "Firebase.app[SessionGenerator::class.java]");
        sb3.append(((o0) objB3).b());
        Log.d("SessionLifecycleService", sb3.toString());
        Object objB4 = ga.g.c().b(j0.class);
        be.h.d(objB4, "Firebase.app[SessionFirelogPublisher::class.java]");
        Object objB5 = ga.g.c().b(o0.class);
        be.h.d(objB5, "Firebase.app[SessionGenerator::class.java]");
        m0 m0Var = (m0) ((j0) objB4);
        rd.c cVar = null;
        ke.x.j(ke.x.a(m0Var.f2682e), null, new k0(m0Var, ((o0) objB5).b(), null), 3);
        ArrayList arrayList = new ArrayList(this.f2715c);
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            Messenger messenger = (Messenger) obj;
            be.h.d(messenger, "it");
            a(messenger);
        }
        Object objB6 = ga.g.c().b(u.class);
        be.h.d(objB6, "Firebase.app[SessionDatastore::class.java]");
        Object objB7 = ga.g.c().b(o0.class);
        be.h.d(objB7, "Firebase.app[SessionGenerator::class.java]");
        String str2 = ((o0) objB7).b().f2642a;
        f0 f0Var = (f0) ((u) objB6);
        be.h.e(str2, "sessionId");
        ke.x.j(ke.x.a(f0Var.f2635b), null, new e0(f0Var, str2, cVar, 0), 3);
    }

    public final void c(Messenger messenger, String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("SessionUpdateExtra", str);
            Message messageObtain = Message.obtain(null, 3, 0, 0);
            messageObtain.setData(bundle);
            messenger.send(messageObtain);
        } catch (DeadObjectException unused) {
            Log.d("SessionLifecycleService", "Removing dead client from list: " + messenger);
            this.f2715c.remove(messenger);
        } catch (Exception e10) {
            Log.w("SessionLifecycleService", "Unable to push new session to " + messenger + '.', e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0156  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleMessage(android.os.Message r12) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.t0.handleMessage(android.os.Message):void");
    }
}
