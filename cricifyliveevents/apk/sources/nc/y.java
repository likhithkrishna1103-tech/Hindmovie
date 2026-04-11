package nc;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y extends Binder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m2.e f9108d;

    public y(m2.e eVar) {
        this.f9108d = eVar;
    }

    public final void a(z zVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "service received new intent via bind strategy");
        }
        Intent intent = zVar.f9109a;
        g gVar = (g) this.f9108d.f8050v;
        j9.i iVar = new j9.i();
        gVar.f9045v.execute(new androidx.emoji2.text.n(gVar, intent, iVar, 7));
        iVar.f6688a.b(new p.a(1), new kb.d(3, zVar));
    }
}
