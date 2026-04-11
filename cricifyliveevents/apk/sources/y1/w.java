package y1;

import android.os.Message;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Message f14616a;

    public final void a() {
        this.f14616a = null;
        ArrayList arrayList = x.f14617b;
        synchronized (arrayList) {
            try {
                if (arrayList.size() < 50) {
                    arrayList.add(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        Message message = this.f14616a;
        message.getClass();
        message.sendToTarget();
        a();
    }
}
