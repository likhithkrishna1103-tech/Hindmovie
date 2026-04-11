package ub;

import a2.g1;
import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import n.a1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x extends Binder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a1 f12908d;

    public x(a1 a1Var) {
        this.f12908d = a1Var;
    }

    public final void a(y yVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "service received new intent via bind strategy");
        }
        Intent intent = yVar.f12909a;
        h hVar = (h) this.f12908d.f8343u;
        o8.h hVar2 = new o8.h();
        hVar.f12847u.execute(new g1(hVar, intent, hVar2, 11));
        hVar2.f9421a.b(new n4.b(0), new nc.c(17, yVar));
    }
}
