package o8;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends a9.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f9700a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(e eVar, Looper looper) {
        super(looper, 0);
        this.f9700a = eVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        p pVar;
        e eVar = this.f9700a;
        if (eVar.f9641w.get() != message.arg1) {
            int i = message.what;
            if ((i == 2 || i == 1 || i == 7) && (pVar = (p) message.obj) != null) {
                pVar.c();
                return;
            }
            return;
        }
        int i10 = message.what;
        if ((i10 == 1 || i10 == 7 || i10 == 4 || i10 == 5) && !eVar.e()) {
            p pVar2 = (p) message.obj;
            if (pVar2 != null) {
                pVar2.c();
                return;
            }
            return;
        }
        int i11 = message.what;
        if (i11 == 4) {
            eVar.f9638t = new l8.b(message.arg2);
            if (!eVar.f9639u && !TextUtils.isEmpty(eVar.v()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(eVar.v());
                    if (!eVar.f9639u) {
                        eVar.A(3, null);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            l8.b bVar = eVar.f9638t;
            if (bVar == null) {
                bVar = new l8.b(8);
            }
            eVar.f9628j.h(bVar);
            System.currentTimeMillis();
            return;
        }
        if (i11 == 5) {
            l8.b bVar2 = eVar.f9638t;
            if (bVar2 == null) {
                bVar2 = new l8.b(8);
            }
            eVar.f9628j.h(bVar2);
            System.currentTimeMillis();
            return;
        }
        if (i11 == 3) {
            Object obj = message.obj;
            eVar.f9628j.h(new l8.b(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null));
            System.currentTimeMillis();
            return;
        }
        if (i11 == 6) {
            eVar.A(5, null);
            b bVar3 = eVar.f9633o;
            if (bVar3 != null) {
                bVar3.e(message.arg2);
            }
            System.currentTimeMillis();
            eVar.y(5, 1, null);
            return;
        }
        if (i11 == 2 && !eVar.a()) {
            p pVar3 = (p) message.obj;
            if (pVar3 != null) {
                pVar3.c();
                return;
            }
            return;
        }
        int i12 = message.what;
        if (i12 != 2 && i12 != 1 && i12 != 7) {
            StringBuilder sb = new StringBuilder(String.valueOf(i12).length() + 34);
            sb.append("Don't know how to handle message: ");
            sb.append(i12);
            Log.wtf("GmsClient", sb.toString(), new Exception());
            return;
        }
        p pVar4 = (p) message.obj;
        synchronized (pVar4) {
            try {
                bool = pVar4.f9688a;
                if (pVar4.f9689b) {
                    String string = pVar4.toString();
                    StringBuilder sb2 = new StringBuilder(string.length() + 47);
                    sb2.append("Callback proxy ");
                    sb2.append(string);
                    sb2.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb2.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            e eVar2 = pVar4.f;
            int i13 = pVar4.f9691d;
            if (i13 != 0) {
                eVar2.A(1, null);
                Bundle bundle = pVar4.f9692e;
                pVar4.b(new l8.b(i13, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
            } else if (!pVar4.a()) {
                eVar2.A(1, null);
                pVar4.b(new l8.b(8, null));
            }
        }
        synchronized (pVar4) {
            pVar4.f9689b = true;
        }
        pVar4.c();
    }
}
